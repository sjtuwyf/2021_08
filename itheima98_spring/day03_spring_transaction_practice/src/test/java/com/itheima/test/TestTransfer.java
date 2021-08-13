package com.itheima.test;

import org.example.controller.AccountController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author ssqswyf
 * @Date 2021/8/6
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestTransfer {

    @Autowired
    private AccountController accountController;
    @Test
    public void testTransfer(){
        accountController.transfer("a", "b", 100.0);
    }
}
