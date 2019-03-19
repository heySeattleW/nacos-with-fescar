package com.hey.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @ClassName OrderEntity
 * @Author hey
 * @Date 2019/3/19 9:50
 **/
@Data
@Entity
@Table(name = "order_detail")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private BigDecimal orderPrice;
    private Integer orderStatus;
    private Integer userId;
    private Integer goodsId;
}
