package com.blingma.mallsecondskillsvr.basic.item.mapper.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

/**
 * @author shihao.ma
 * @since 2020/6/3
 */
@Data
@Table(name = "ITEM")
@Entity
public class Item {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("ID")
    private Integer id;

    @Column(name = "ITEM_NAME")
    @ApiModelProperty("商品名称")
    private String itemName;

    @Column(name = "KILL_ID", unique = true)
    @ApiModelProperty("秒杀商品ID")
    private String killId;

    @Column(name = "PRICE")
    @ApiModelProperty("商品价格")
    private Double price;

    @Column(name = "COUNT")
    @ApiModelProperty("商品库存数量")
    private Integer count;

    @Column(name = "IS_KILL")
    @ApiModelProperty("是否允许秒杀")
    private Integer isKill;

}
