package com.hey.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @ClassName User
 * @Author hey
 * @Date 2019/3/18 19:50
 **/
@Data
@Entity
public class User {
    @Id
    private int id;
    private String username;
    private BigDecimal money;

}
