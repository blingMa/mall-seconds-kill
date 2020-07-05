package com.blingma.mallsecondskillsvr.basic.kill.mapper.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author shihao.ma
 * @since 2020/6/3
 */
@Data
@Table(name = "KILL_ORDER")
@Entity
public class KillOrder {
    @Id
    @Column(name = "ID")
    @ApiModelProperty("ID")
    private String id;

    @Column(name = "ITEM_ID")
    @ApiModelProperty("商品ID")
    private String itemID;

    @Column(name = "KILL_ID")
    @ApiModelProperty("秒杀商品ID")
    private String killId;

    @Column(name = "USER_ID")
    @ApiModelProperty("用户ID")
    private String userId;

    @Column(name = "PRICE")
    @ApiModelProperty("商品价格")
    private Double price;

    @Column(name = "COUNT")
    @ApiModelProperty("商品数量")
    private Integer count;

    @Column(name = "CREATE_TIME")
    @ApiModelProperty("订单创建时间")
    private String createTime;

    @Column(name = "STATUS")
    @ApiModelProperty("订单状态")
    private Integer status;
}
