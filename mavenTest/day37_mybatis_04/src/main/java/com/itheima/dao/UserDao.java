package com.itheima.dao;

import com.itheima.pojo.User;
import jdk.jfr.TransitionFrom;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Author ssqswyf
 * @Date 2021/8/3
 */
public interface UserDao {

    @Select("Select * from t_user")
    List<User> findAll();

    @Select("Select * from t_user where uid=#{id}")
    User findById(int id);


    @Insert("insert into t_user " +
            "values (null ,#{username},#{sex},#{birthday},#{address})")
    int addUser(User user);

    @Delete("delete from t_user where uid=#{uid}")
    int deleteById();

    @Update("update t_user set username=#{username}")
    int update(User user);



}
