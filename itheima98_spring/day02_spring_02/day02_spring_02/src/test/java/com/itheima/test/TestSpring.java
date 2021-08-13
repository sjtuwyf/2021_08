package com.itheima.test;

import com.itheima.controller.AccountController;
import com.itheima.pojo.Account;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.List;

/**
 * 包名:com.itheima.test
 *
 * @author Leevi
 * 日期2020-08-09  15:16
 */
public class TestSpring {
    private AccountController accountController;
    @Before
    public void init(){
        //1. 创建spring的核心容器对象
        ApplicationContext act = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        //2. 从核心容器中获取AccountController的对象
        accountController = (AccountController) act.getBean("accountController");
    }
    @Test
    public void testFindAll() throws SQLException {
        List<Account> accountList = accountController.findAll();
        System.out.println(accountList);
    }

    @Test
    public void testFindById() throws SQLException {
        Account account = accountController.findById(1);
        System.out.println(account);
    }

    @Test
    public void testDeleteById() throws SQLException {
        accountController.deleteById(3);
    }

    @Test
    public void testAdd() throws SQLException {
        Account account = new Account();
        account.setName("ww");
        account.setMoney(1000.0);

        accountController.add(account);
    }

    @Test
    public void testUpdate() throws SQLException {
        Account account = accountController.findById(5);
        account.setName("aobama");
        account.setMoney(1500.0);

        accountController.update(account);
    }
}
