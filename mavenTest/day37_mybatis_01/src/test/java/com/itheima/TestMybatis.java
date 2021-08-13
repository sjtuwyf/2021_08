package com.itheima;

import com.itheima.dao.AccountDao;
import com.itheima.dao.RoleDao;
import com.itheima.dao.UserDao;
import com.itheima.pojo.Account;
import com.itheima.pojo.Role;
import com.itheima.pojo.User;
import com.itheima.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @Author ssqswyf
 * @Date 2021/8/3
 */
public class TestMybatis {


    @Test
    public void test01() {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);

        Account account = accountDao.findAccountUserByAid(2);
        System.out.println(account);

        SqlSessionFactoryUtils.commitAndClose(sqlSession);
    }

    @Test
    public void test02(){
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.findUserAccountByUid(1);
        System.out.println(user);
        SqlSessionFactoryUtils.commitAndClose(sqlSession);
    }

    @Test
    public void test03(){
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.findUserRoleByUid(2);
        System.out.println(user);
        SqlSessionFactoryUtils.commitAndClose(sqlSession);
    }

    @Test
    public void test04() {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        RoleDao roleDao = sqlSession.getMapper(RoleDao.class);
        Role role = roleDao.findRoleUserByRid(3);
        System.out.println(role);
        SqlSessionFactoryUtils.commitAndClose(sqlSession);

//        System.out.println(SqlSessionFactoryUtils.openSession().getMapper(RoleDao.class).findRoleUserByRid(3));

    }
}
