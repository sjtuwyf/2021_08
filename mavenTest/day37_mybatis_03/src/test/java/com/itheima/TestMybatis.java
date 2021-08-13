package com.itheima;

import com.itheima.dao.AccountDao;
import com.itheima.dao.UserDao;
import com.itheima.pojo.Account;
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
//        UserDao userDao = sqlSession.getMapper(UserDao.class);

        Account account = accountDao.findAccountByAid(2);

//        User user = userDao.findUserByUid(account.getUid());
//
//        account.setUser(user);
        System.out.println(account.getAid());

        SqlSessionFactoryUtils.commitAndClose(sqlSession);

    }


}
