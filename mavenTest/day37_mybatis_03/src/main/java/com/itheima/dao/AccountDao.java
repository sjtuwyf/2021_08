package com.itheima.dao;

import com.itheima.pojo.Account;

/**
 * @Author ssqswyf
 * @Date 2021/8/3
 */
public interface AccountDao {
    Account findAccountByAid(int aid);

}
