package com.itheima.test;

import com.itheima.dao.Userdao;
import com.itheima.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author ssqswyf
 * @Date 2021/8/4
 */
public class TestMybatisSpring {
    @Test
    public void test01() throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        SqlSessionFactory factory = builder.build(is);

        SqlSession sqlSession = factory.openSession();

        Userdao userdao = sqlSession.getMapper(Userdao.class);

        for (User user : userdao.findAll()) {
            System.out.println(user);
        }

        is.close();
        sqlSession.close();

    }

    @Test
    public void test02() {
        ApplicationContext act = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Userdao userDao = (Userdao) act.getBean("userdao");
        for (User user : userDao.findAll()) {
            System.out.println(user);
        }

    }
}
