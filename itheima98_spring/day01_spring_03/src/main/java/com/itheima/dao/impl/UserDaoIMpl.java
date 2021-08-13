package com.itheima.dao.impl;

import com.itheima.dao.UserDao;

import java.util.Arrays;
import java.util.Map;

/**
 * @Author ssqswyf
 * @Date 2021/8/4
 */
public class UserDaoIMpl implements UserDao {
    private String username;
    private Integer age;
    private String[] stringArrays;
    private Map map;

    public void setMap(Map map) {
        this.map = map;
    }

    public void setStringArrays(String[] stringArrays) {
        this.stringArrays = stringArrays;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getName() {
        System.out.println(map);
        System.out.println(Arrays.toString(stringArrays));
        System.out.println(age);

        return username;
    }
}
