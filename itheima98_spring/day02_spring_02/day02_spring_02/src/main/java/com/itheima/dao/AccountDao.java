package com.itheima.dao;

import com.itheima.pojo.Account;

import java.sql.SQLException;
import java.util.List;

/**
 * 包名:com.itheima.dao
 *
 * @author Leevi
 * 日期2020-08-09  14:56
 */
public interface AccountDao {
    /**
     * 查询所有账号信息
     * @return
     */
    public List<Account> findAll() throws SQLException;

    /**
     * 根据id查询账号信息
     * @param id
     * @return
     */
    public Account findById(int id) throws SQLException;

    /**
     * 根据id删除账号信息
     * @param id
     */
    public void deleteById(int id) throws SQLException;

    /**
     * 添加账号信息
     * @param account
     */
    public void add(Account account) throws SQLException;

    /**
     * 修改账号信息
     * @param account
     */
    public void update(Account account) throws SQLException;
}
