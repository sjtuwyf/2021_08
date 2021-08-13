package com.itheima.service.impl;

import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Author ssqswyf
 * @Date 2021/8/4
 */
@Service
public class UserServiceImpl implements UserService {
    @Value("asdfsdaf")
    private String username;


    @PostConstruct
    public void init(){
        System.out.println("init...");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("destroy...");
    }

    @Override
    public String getName() {
        return username;
    }
}
