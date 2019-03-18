package com.hey.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @ClassName BuyGoodsDTO
 * @Author hey
 * @Date 2019/3/18 19:56
 **/
@Data
public class BuyGoodsDTO {
    private int orderId; // 订单id，创建订单完成后会随其他数据一起回传
    private int userId;
    private int goodsId;
    private int goodsNumber;
    private BigDecimal price;
}
