package com.blingma.mallsecondskillsvr.basic.kill.mapper;

import com.blingma.mallsecondskillsvr.basic.kill.mapper.entity.KillOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author shihao.ma
 * @since 2020/6/3
 */
public interface MallKillOrderMapper extends JpaRepository<KillOrder, String>, JpaSpecificationExecutor<KillOrder> {

   List<KillOrder> findByUserIdAndKillId(String userId, String killId);

}
