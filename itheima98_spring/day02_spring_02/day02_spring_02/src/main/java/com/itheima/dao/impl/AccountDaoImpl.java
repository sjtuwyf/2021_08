package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import com.itheima.pojo.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * 包名:com.itheima.dao.impl
 * @author Leevi
 * 日期2020-08-09  14:58
 * 使用DBUtils
 * 1. 创建QueryRunner对象
 */
public class AccountDaoImpl implements AccountDao {
    private QueryRunner queryRunner;

    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }

    @Override
    public List<Account> findAll() throws SQLException {
        String sql = "select * from account";
        List<Account> accountList = queryRunner.query(sql, new BeanListHandler<>(Account.class));
        return accountList;
    }

    @Override
    public Account findById(int id) throws SQLException {
        String sql = "select * from account where id=?";
        Account account = queryRunner.query(sql, new BeanHandler<>(Account.class), id);
        return account;
    }

    @Override
    public void deleteById(int id) throws SQLException {
        String sql = "delete from account where id=?";
        queryRunner.update(sql,id);
    }

    @Override
    public void add(Account account) throws SQLException {
        String sql = "insert into account values (null,?,?)";
        queryRunner.update(sql,account.getName(),account.getMoney());
    }

    @Override
    public void update(Account account) throws SQLException {
        String sql = "update account set name=?,money=? where id=?";
        queryRunner.update(sql,account.getName(),account.getMoney(),account.getId());
    }
}
