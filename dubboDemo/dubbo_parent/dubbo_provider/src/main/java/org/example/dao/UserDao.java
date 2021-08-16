package org.example.dao;

import org.example.pojo.User;

/**
 * @Author ssqswyf
 * @Date 2021/8/15
 */
public interface UserDao {


    User findById(Integer id);

}
