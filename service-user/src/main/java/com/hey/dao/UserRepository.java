package com.hey.dao;

import com.hey.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

/**
 * @ClassName UserRepository
 * @Author hey
 * @Date 2019/3/18 19:49
 **/
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query("update User set money=money-?1 where id=?2")
    @Modifying
    void reduceUserMoney(BigDecimal money,Integer userId);
}
