package com.hey.service;

import com.hey.base.BaseResult;
import com.hey.dao.OrderRepository;
import com.hey.dto.BuyGoodsDTO;
import com.hey.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName OrderService
 * @Author hey
 * @Date 2019/3/19 9:53
 **/
@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    /**
     * 创建订单
     * @param buyGoodsDTO
     * @return
     */
    @Transactional
    public BaseResult createOrder(BuyGoodsDTO buyGoodsDTO){
        Order order = new Order();
        order.setGoodsId(buyGoodsDTO.getGoodsId());
        order.setUserId(buyGoodsDTO.getUserId());
        order.setOrderPrice(buyGoodsDTO.getPrice());
        order.setOrderStatus(0);
        Order newOrder =  orderRepository.save(order);
        buyGoodsDTO.setOrderId(newOrder.getId());
        return BaseResult.ofSuccess(buyGoodsDTO);
    }

    @Transactional
    public BaseResult finishOrderWithSuccess(Integer id){
        int flag = orderRepository.updateOrOrderStatus(id);
        if(flag == 0){
            //更新失败
            throw new RuntimeException("完成订单失败");
        }
        return BaseResult.ofSuccess(flag);
    }
}
