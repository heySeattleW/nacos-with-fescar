package com.hey.feign;

import com.alibaba.fescar.core.context.RootContext;
import com.hey.base.BaseResult;
import com.hey.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName GoodsFeign
 * @Author hey
 * @Date 2019/3/19 10:13
 **/
@Slf4j
@RestController
@RequestMapping("/goods/feign")
public class GoodsFeignController {

    @Autowired
    GoodsService goodsService;

    /**
     * 减少库存
     * @param id
     * @param goodsNumber
     * @return
     */
    @GetMapping("/decrease")
    public BaseResult decreaseGoodsNumber(@RequestParam("id") Integer id,@RequestParam("goodsNumber") Integer goodsNumber){
        log.info("减少库存，全局事务ID为：{}", RootContext.getXID());
        return goodsService.decreaseGoodsNumber(id,goodsNumber);
    }

    @GetMapping("/info")
    public BaseResult getGoodsInfo(@RequestParam("id") Integer id){
        return goodsService.getGoodsInfo(id);
    }
}
