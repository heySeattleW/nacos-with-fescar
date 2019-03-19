package com.hey.client;

import com.hey.base.BaseResult;
import com.hey.dto.BuyGoodsDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName OrderFeignClient
 * @Author hey
 * @Date 2019/3/18 20:10
 **/
@FeignClient(name = "service-order")
public interface OrderFeignClient {

    /**
     * 创建订单
     */
    @PostMapping("/order/feign/create")
    BaseResult createOrder(@RequestBody BuyGoodsDTO buyGoodsDTO);

    /**
     * 成功支付订单
     * @param id 订单id
     * @return
     */
    @GetMapping("/order/feign/finish/success")
    BaseResult finishOrderWithSuccess(@RequestParam("id") Integer id);
}
