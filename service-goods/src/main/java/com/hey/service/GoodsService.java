package com.hey.service;

import com.hey.base.BaseResult;
import com.hey.dao.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName GoodsService
 * @Author hey
 * @Date 2019/3/19 10:10
 **/
@Service
public class GoodsService {

    @Autowired
    GoodsRepository goodsRepository;

    /**
     * 减少库存
     * @param id 商品id
     * @param goodsNumber 要减少的商品数量
     * @return
     */
    @Transactional
    public BaseResult decreaseGoodsNumber(Integer id,Integer goodsNumber){
        goodsRepository.decreaseGoodsNumber(id,goodsNumber);
        return BaseResult.ofSuccess();
    }

    public BaseResult getGoodsInfo(Integer id){
        return BaseResult.ofSuccess(goodsRepository.findById(id));
    }
}
