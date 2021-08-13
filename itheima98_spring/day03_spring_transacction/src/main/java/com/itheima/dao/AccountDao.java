package com.itheima.dao;

import com.itheima.pojo.Account;
import org.springframework.stereotype.Repository;

/**
 * @Author ssqswyf
 * @Date 2021/8/5
 */
//@Repository
public interface AccountDao {

    void updateAccount(Account account);
}
