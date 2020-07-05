package com.blingma.mallsecondskillsvr.basic.kill.service;

import com.blingma.mallsecondskillsvr.basic.item.mapper.MallItemMapper;
import com.blingma.mallsecondskillsvr.basic.kill.mapper.MallKillOrderMapper;
import com.blingma.mallsecondskillsvr.basic.kill.mapper.entity.KillOrder;
import com.blingma.mallsecondskillsvr.common.SnowFlake;
import com.blingma.mallsecondskillsvr.common.TimeUtil;
import com.blingma.mallsecondskillsvr.mq.Sender;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author shihao.ma
 * @since 2020/6/3
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class MallKillOrderServiceImpl implements MallKillOrderService {

    private final MallKillOrderMapper mallKillOrderMapper;

    private final MallItemMapper mallItemMapper;

    private final RedissonClient redissonClient;

    private final Sender sender;

    @Override
    @Transactional
    public void saveKillOrder(KillOrder killOrder) {
        RLock lock = redissonClient.getLock(killOrder.getUserId() + killOrder.getUserId() + "Lock");
        lock.lock();

        try {
            //根据用户id 查询KillOrder中该用户是否已经抢购过该商品
            List<KillOrder> orderList = mallKillOrderMapper.findByUserIdAndKillId(killOrder.getUserId(), killOrder.getKillId());
            log.info("订单查询列表为：{}", new Gson().toJson(orderList));
            if (orderList.size() == 0) {
                long orderId = new SnowFlake(1, 1).nextId();
                killOrder.setId(String.valueOf(orderId));
                killOrder.setCreateTime(TimeUtil.getDateTime(TimeUtil.PatternEnum.PATTERN3));
                killOrder.setStatus(0);
                // 更新库存
                Integer integer = mallItemMapper.updateItemCount(killOrder.getKillId());
                if (integer > 0) {
                    // 更新成功之后插入秒杀订单
                    KillOrder save = mallKillOrderMapper.save(killOrder);
                    log.info("订单创建成功，订单号 {}", killOrder.getId());
                    if (save != null) {
                        //向消息队列发送信息
                        try {
                            sender.sendMailMessage(orderId);
                        } catch (Exception e) {
                            log.error("you");
                        }
                    }
                }
            }
        } catch (Exception e) {
            log.error("MallKillOrderServiceImpl saveKillOrder 异常：{}", e.getMessage());
        } finally {
            lock.unlock();
        }

    }
}
