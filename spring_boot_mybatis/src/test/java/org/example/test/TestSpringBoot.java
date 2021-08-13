package org.example.test;

import org.example.dao.UserMapper;
import org.example.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author ssqswyf
 * @Date 2021/8/12
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestSpringBoot {

    @Autowired(required = false)
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testFindAll(){
        System.out.println(userMapper.findAllUser());
    }

    @Test
    public void testFindAllUser(){
        List<User> list = (List<User>) redisTemplate.boundValueOps("key_all").get();
        if (list != null && list.size()> 0) {
            System.out.println(list + "  redis");
        } else {
            List<User> allUser = userMapper.findAllUser();
            redisTemplate.boundValueOps("key_all").set(allUser);
            System.out.println(allUser + " mysql");
        }
    }



}
