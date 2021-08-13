package com.itheima.service.Impl;

import com.itheima.dao.AccountDao;
import com.itheima.pojo.Account;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author ssqswyf
 * @Date 2021/8/5
 */
@Service
public class AccountServiceIMpl implements AccountService {
    @Autowired
    public AccountDao accountDao;
    @Override
    public void transfer(String fromName, String toName, Double money) {

        accountDao.updateAccount(new Account(null, fromName, -money));
//        Account account =null;
//        System.out.println(account.getName());

//        int num = 10/0;

        accountDao.updateAccount(new Account(null, toName, money));

    }
}
