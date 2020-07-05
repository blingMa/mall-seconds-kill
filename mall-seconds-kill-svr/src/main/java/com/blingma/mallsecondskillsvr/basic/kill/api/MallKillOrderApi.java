package com.blingma.mallsecondskillsvr.basic.kill.api;

import com.blingma.mallsecondskillsvr.basic.kill.mapper.entity.KillOrder;
import com.blingma.mallsecondskillsvr.basic.kill.service.MallKillOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shihao.ma
 * @since 2020/6/3
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "秒杀订单接口API")
public class MallKillOrderApi {

    private final MallKillOrderService mallKillOrderService;

    @PostMapping("/save")
    @ApiOperation("新增秒杀订单")
    public void saveKillOrder(@RequestBody KillOrder killOrder) {
        mallKillOrderService.saveKillOrder(killOrder);
    }

}
