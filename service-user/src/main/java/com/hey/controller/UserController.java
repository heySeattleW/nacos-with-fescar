package com.hey.controller;

import com.hey.base.BaseResult;
import com.hey.dto.BuyGoodsDTO;
import com.hey.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Author hey
 * @Date 2019/3/19 14:13
 **/
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("buy")
    public BaseResult buy(@RequestBody BuyGoodsDTO buyGoodsDTO){
        return userService.buyGoods(buyGoodsDTO);
    }
}
