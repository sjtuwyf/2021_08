package com.itheima.test;

import com.itheima.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author ssqswyf
 * @Date 2021/8/5
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestAop {

    @Autowired
    private UserService userService;

    @Test
    public void test01() {
        userService.add();

    }

    @Test
    public void test02() {
        userService.update();
    }
}
