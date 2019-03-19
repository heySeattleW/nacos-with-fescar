package com.hey.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @ClassName Goods
 * @Author hey
 * @Date 2019/3/19 10:06
 **/
@Data
@Entity
public class Goods {
    @Id
    private Integer id;
    private String goodsName;
    private Integer goodsNumber;
    private BigDecimal goodsPrice;
}
