package org.example.test;

import org.example.dao.AccountDao;
import org.example.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author ssqswyf
 * @Date 2021/8/7
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestSSM {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private AccountService accountService;

    @Test
    public void test01() {
//        System.out.println(accountDao.findAll());
        System.out.println(accountService.findAll());
    }

}
