package com.example;

import com.example.dao.AccountDao;
import com.example.dao.UserDao;
import com.example.pojo.Account;
import com.example.pojo.User;
import com.example.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ssqswyf
 * @Date 2021/8/3
 */
public class MybatisTest {
    @Test
    public void test01(){
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        List<User> userList = userDao.findAll();
        for (User user : userList) {
            System.out.println(user);
        }

        SqlSessionFactoryUtils.commitAndClose(sqlSession);
    }

    @Test
    public void test02() {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        Account accountByAid = accountDao.findAccountByAid(2);
        System.out.println(accountByAid);
        SqlSessionFactoryUtils.commitAndClose(sqlSession);
    }

    @Test
    public void test03(){
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        User user = userDao.findUserAccountByUid(1);
        System.out.println(user);

        SqlSessionFactoryUtils.commitAndClose(sqlSession);
    }

    @Test
    public void test04(){
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        User user = userDao.findUserRoleByUid(2);
        System.out.println(user);

        SqlSessionFactoryUtils.commitAndClose(sqlSession);
    }

    @Test
    public void test05(){
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        for (User user : userDao.findUserByAddress("taiwan")) {
            System.out.println(user);
        }


        SqlSessionFactoryUtils.commitAndClose(sqlSession);
    }

    @Test
    public void test06(){
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = new User();
        user.setAddress("taiwan");
        user.setSex("男");

        List<User> userList = userDao.findUserByAddressAndSex(user);
        for (User user1 : userList) {
            System.out.println(user1);
        }


        SqlSessionFactoryUtils.commitAndClose(sqlSession);
    }

    @Test
    public void test07(){
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        List<Integer> uids = new ArrayList<>();
        uids.add(5);
        uids.add(6);
        int i = userDao.deleteByUids(uids);
        System.out.println(i);

        SqlSessionFactoryUtils.commitAndClose(sqlSession);
    }

    @Test
    public void test08() {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        Account account = accountDao.findAccountByAidLazy(2);
        System.out.println(account.getMoney());
        SqlSessionFactoryUtils.commitAndClose(sqlSession);
    }

    @Test
    public void test09(){
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        User userByUidLazy = userDao.findUserByUidLazy(1);
        System.out.println(userByUidLazy);

        SqlSessionFactoryUtils.commitAndClose(sqlSession);
    }

    @Test
    public void test10(){
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        List<User> userList = userDao.findUsers();
        for (User user : userList) {
            System.out.println(user);
        }

        SqlSessionFactoryUtils.commitAndClose(sqlSession);
    }


}
