package com.itheima.service.impl;

import com.itheima.service.UserService;

/**
 * @Author ssqswyf
 * @Date 2021/8/5
 */
public class UserServiceImpl implements UserService {
    @Override
    public void add() {

        System.out.println("add...");
//        int i = 1/0;
    }

    @Override
    public void delete() {
        System.out.println("delete...");
    }

    @Override
    public void update() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("update...");
    }

    @Override
    public void select() {
        System.out.println("select...");
    }
}
