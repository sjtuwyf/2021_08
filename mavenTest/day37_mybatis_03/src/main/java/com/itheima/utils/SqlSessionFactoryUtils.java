package com.itheima.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 包名:com.itheima.utils
 *
 * @author Leevi
 * 日期2020-07-29  11:39
 * mybatis的工具类
 */
public class SqlSessionFactoryUtils {
    private static InputStream is;
    private static SqlSessionFactory sessionFactory;

    static {
        try {
            //1. 创建SqlSessionFactoryBuilder对象
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            //2. 读取核心配置文件，转换成字节输入流
            is = Resources.getResourceAsStream("SqlMapConfig.xml");
            //3. 创建SqlSessionFactory对象
            sessionFactory = sqlSessionFactoryBuilder.build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取SqlSession对象的方法
     * @return
     */
    public static SqlSession openSession(){
        SqlSession sqlSession = null;
        try {
            //4. 创建SqlSession对象
            sqlSession = sessionFactory.openSession();
            is.close();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        return sqlSession;
    }

    /**
     * 提交事务并且关闭资源
     * @param sqlSession
     */
    public static void commitAndClose(SqlSession sqlSession){
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 回滚事务并且关闭资源
     * @param sqlSession
     */
    public static void rollbackAndClose(SqlSession sqlSession){
        sqlSession.rollback();
        sqlSession.close();
    }
}
