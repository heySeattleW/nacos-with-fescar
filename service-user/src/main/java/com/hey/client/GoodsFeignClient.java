package com.hey.client;

import com.hey.base.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName GoodsFeignClient
 * @Author hey
 * @Date 2019/3/18 20:33
 **/
@FeignClient(name = "service-goods")
public interface GoodsFeignClient {

    /**
     * 减少商品库存
     */
    @GetMapping("/goods/feign/decrease")
    BaseResult decreaseGoodsNumber(@RequestParam("id") Integer id, @RequestParam("goodsNumber") int goodsNumber);

    /**
     * 获取商品信息
     */
    @GetMapping("/goods/feign/info")
    BaseResult getGoodsInfo(@RequestParam("id") Integer id);
}
