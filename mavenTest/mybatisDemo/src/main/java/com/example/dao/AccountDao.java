package com.example.dao;

import com.example.pojo.Account;

import java.util.List;

/**
 * @Author ssqswyf
 * @Date 2021/8/3
 */
public interface AccountDao {
   public Account findAccountByAid(int aid);
   public Account findAccountByAidLazy(int aid);
   List<Account> findAccountByUid(int uid);
}
