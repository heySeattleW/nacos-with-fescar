package com.hey.service;

import com.hey.base.BaseResult;
import com.hey.client.GoodsFeignClient;
import com.hey.client.OrderFeignClient;
import com.hey.dao.UserRepository;
import com.hey.dto.BuyGoodsDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName UserService
 * @Author hey
 * @Date 2019/3/18 19:52
 **/
@Service
@Slf4j
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    OrderFeignClient orderFeignClient;

    @Autowired
    GoodsFeignClient goodsFeignClient;

    /**
     * 购买商品
     * @param buyGoodsDTO
     * @return
     */
    @Transactional
    public BaseResult buyGoods(BuyGoodsDTO buyGoodsDTO){
        // 1.调用订单服务，创建订单
        log.info("开始购买商品");
        BaseResult baseResult = orderFeignClient.createOrder(buyGoodsDTO);
        log.info("创建订单服务结果：{}",baseResult.getMsg());
        if(baseResult.getCode() == 200){
            //创建订单成功
            // 2.减少库存
            BuyGoodsDTO newBuyGoodsDTO = (BuyGoodsDTO)baseResult.getData();
            BaseResult result = goodsFeignClient.decreaseGoodsNumber(buyGoodsDTO.getGoodsNumber());
            log.info("减少库存服务结果：{}",result.getMsg());
            if(result.getCode() == 200){
                //减少库存成功
                // 3.扣除用户余额
                userRepository.reduceUserMoney(buyGoodsDTO.getPrice(),buyGoodsDTO.getUserId());
                // 4.扣除余额成功则置订单状态为已完成
                BaseResult finishResult = orderFeignClient.finishOrderWithSuccess(newBuyGoodsDTO.getOrderId());
                log.info("完成订单服务结果：{}",finishResult.getMsg());
                if(finishResult.getCode() == 200){
                    //完成订单,返回订单号
                    return BaseResult.ofSuccess(newBuyGoodsDTO.getOrderId());
                }else {
                    throw new RuntimeException("完成订单阶段失败");
                }
            }else {
                throw new RuntimeException("减少库存阶段失败");
            }
        }else {
            throw new RuntimeException("创建订单阶段失败");
        }
    }
}
