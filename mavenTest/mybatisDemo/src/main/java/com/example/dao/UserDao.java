package com.example.dao;

import com.example.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author ssqswyf
 * @Date 2021/8/3
 */
public interface UserDao {
    public List<User> findAll();
    public User findUserAccountByUid(int uid);
    public User findUserRoleByUid(int uid);

    List<User> findUserByAddress(String address);

    List<User> findUserByAddressAndSex(User user);
    int deleteByUids(List<Integer> uids);
    User findUserByUid(int uid);
    User findUserByUidLazy(int uid);

    @Select("select * from t_user")
    List<User> findUsers();


}
