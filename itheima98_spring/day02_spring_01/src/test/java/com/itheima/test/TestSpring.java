package com.itheima.test;

import com.itheima.controller.UserController;
import com.itheima.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author ssqswyf
 * @Date 2021/8/4
 */
public class TestSpring {
    @Test
    public void test01(){
        ApplicationContext act = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        UserService userService = (UserService) act.getBean("userServiceImpl");

        System.out.println(userService.getName());
    }

    @Test
    public void test02(){
        ApplicationContext act = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        UserController userController = (UserController) act.getBean("userController");

        System.out.println(userController.getName());
    }
}
