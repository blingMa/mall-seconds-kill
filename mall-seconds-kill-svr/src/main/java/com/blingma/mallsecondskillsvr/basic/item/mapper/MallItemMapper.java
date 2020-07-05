package com.blingma.mallsecondskillsvr.basic.item.mapper;

import com.blingma.mallsecondskillsvr.basic.item.mapper.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author shihao.ma
 * @since 2020/6/3
 */
public interface MallItemMapper extends JpaRepository<Item, Integer>, JpaSpecificationExecutor<Item> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE item i SET i.count = i.count-1 WHERE i.count > 0 AND i.kill_id = ?1", nativeQuery = true)
    int updateItemCount(String id);

}
