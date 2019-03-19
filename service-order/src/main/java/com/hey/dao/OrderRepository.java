package com.hey.dao;

import com.hey.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @ClassName OrderRepository
 * @Author hey
 * @Date 2019/3/19 9:53
 **/
public interface OrderRepository extends JpaRepository<Order,Integer> {

    /**
     * 完成订单
     */
    @Query("update Order set orderStatus=1 where id=?1 and orderStatus <> 1")
    @Modifying
    int updateOrOrderStatus(Integer id);
}
