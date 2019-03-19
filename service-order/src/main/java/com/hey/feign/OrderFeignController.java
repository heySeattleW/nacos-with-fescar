package com.hey.feign;

import com.alibaba.fescar.core.context.RootContext;
import com.hey.base.BaseResult;
import com.hey.dto.BuyGoodsDTO;
import com.hey.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName OrderFeignController order服务对外提供feign服务
 * @Author hey
 * @Date 2019/3/19 9:42
 **/
@Slf4j
@RestController
@RequestMapping("/order/feign")
public class OrderFeignController {

    @Autowired
    OrderService orderService;

    /**
     * 创建订单
     * @param buyGoodsDTO
     * @return
     */
    @PostMapping("/create")
    public BaseResult createOrder(@RequestBody BuyGoodsDTO buyGoodsDTO){
        log.info("创建订单，全局事务ID为：{}", RootContext.getXID());
        return orderService.createOrder(buyGoodsDTO);
    }

    @GetMapping("/finish/success")
    public BaseResult finishOrderWithSuccess(@RequestParam("id") Integer id){
        log.info("完成订单，全局事务ID为：{}", RootContext.getXID());
        return orderService.finishOrderWithSuccess(id);
    }
}
