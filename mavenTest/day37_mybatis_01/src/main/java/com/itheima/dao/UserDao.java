package com.itheima.dao;

import com.itheima.pojo.User;

import java.util.List;

/**
 * @Author ssqswyf
 * @Date 2021/8/3
 */
public interface UserDao {


    User findUserAccountByUid(int uid);
    User findUserRoleByUid(int uid);
}
