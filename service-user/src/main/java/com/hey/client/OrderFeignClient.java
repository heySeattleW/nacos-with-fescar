package com.hey.client;

import com.hey.base.BaseResult;
import com.hey.dto.BuyGoodsDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @ClassName OrderFeignClient
 * @Author hey
 * @Date 2019/3/18 20:10
 **/
@FeignClient(name = "order-service")
public interface OrderFeignClient {

    /**
     * 创建订单
     */
    @PostMapping("/order/create")
    BaseResult createOrder(BuyGoodsDTO buyGoodsDTO);

    /**
     * 成功支付订单
     * @param id 订单id
     * @return
     */
    @GetMapping("/order/finish/success")
    BaseResult finishOrderWithSuccess(Integer id);
}
