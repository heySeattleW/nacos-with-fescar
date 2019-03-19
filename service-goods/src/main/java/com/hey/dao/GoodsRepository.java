package com.hey.dao;

import com.hey.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @ClassName GoodsRepository
 * @Author hey
 * @Date 2019/3/19 10:07
 **/
public interface GoodsRepository extends JpaRepository<Goods,Integer> {

    /**
     * 减少商品库存
     * @param id
     * @param goodsNumber
     */
    @Query("update Goods set goodsNumber = goodsNumber -?2 where id=?1 and goodsNumber > ?2")
    @Modifying
    void decreaseGoodsNumber(Integer id,Integer goodsNumber);
}
