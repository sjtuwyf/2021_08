package org.example.dao;

import org.example.pojo.Account;

import java.util.List;

/**
 * @Author ssqswyf
 * @Date 2021/8/7
 */
public interface AccountDao {

    public List<Account> findAll();
}
