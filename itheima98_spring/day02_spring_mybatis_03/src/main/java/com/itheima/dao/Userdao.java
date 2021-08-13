package com.itheima.dao;

import com.itheima.pojo.User;

import java.util.List;

/**
 * @Author ssqswyf
 * @Date 2021/8/4
 */
public interface Userdao {
    List<User> findAll();
}
