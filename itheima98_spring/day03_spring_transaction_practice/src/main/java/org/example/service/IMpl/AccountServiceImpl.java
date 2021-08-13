package org.example.service.IMpl;

import org.aspectj.lang.annotation.Aspect;
import org.example.dao.AccountDao;
import org.example.pojo.Account;
import org.example.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author ssqswyf
 * @Date 2021/8/6
 */
@Transactional(rollbackFor = Exception.class,noRollbackFor = NullPointerException.class)
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public void transfer(String fromName, String toName, Double money) {
        accountDao.updateAccount(new Account(null,fromName,-money));

//        Account account =null;
//        System.out.println(account.getName());
//
//        int num = 10/0;

        accountDao.updateAccount(new Account(null,toName,money));
    }
}
