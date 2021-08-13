package com.ithiema;

import com.itheima.dao.UserDao;
import com.itheima.pojo.User;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @Author ssqswyf
 * @Date 2021/8/2
 */
public class TestMybatis {
    private UserDao userDao;
    private InputStream is;
    private SqlSession sqlSession;


    @Before
    public void init() throws IOException {
        //1. 创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //2. 读取核心配置文件，转换成字节输入流
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //3. 创建SqlSessionFactory对象
        SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(is);
        //4. 创建SqlSession对象
        sqlSession = sessionFactory.openSession();
        //5. 创建UserDao的代理对象
        userDao = sqlSession.getMapper(UserDao.class);
    }
    @Test
    public void testFindAll(){
        //测试执行findAll()方法
        //6. 调用你想执行的方法
        List<User> userList = userDao.findAll();

        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testAddUser(){
        User user = new User(0,"jay","男",new Date(),"taiwan");
        userDao.addUser(user);
        testFindAll();
    }

    @Test
    public void testDeleteUser(){
        userDao.deleteUser(4);
        testFindAll();
    }

    @Test
    public void testSearch(){
        List<User> userList = userDao.searchByUsername("a");
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @After
    public void destroy() throws IOException {
        //提交事务!!!!!!!!!!!!!
        sqlSession.commit();
        //7. 关闭资源
        sqlSession.close();
        is.close();
    }
}
