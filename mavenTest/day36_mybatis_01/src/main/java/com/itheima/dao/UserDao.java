package com.itheima.dao;

import com.itheima.pojo.User;

import java.util.List;

/**
 * @Author ssqswyf
 * @Date 2021/8/2
 */
public interface UserDao {
    /**
     * 查询所有用户信息
     * @return
     */
    List<User> findAll();

    void addUser(User user);

    void deleteUser(Integer id);

    void updateUser(User user);

    User findById(Integer id);

    List<User> searchByUsername(String username);


}
