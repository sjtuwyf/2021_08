package com.itheima.test;

import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;
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
        ApplicationContext act = new ClassPathXmlApplicationContext("classpath:spring.xml");

        UserService userService = (UserService) act.getBean("userService");

        System.out.println(userService.getName());
    }


}
