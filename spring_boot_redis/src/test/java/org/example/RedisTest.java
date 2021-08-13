package org.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author ssqswyf
 * @Date 2021/8/13
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testRedis01() {
        Object value = redisTemplate.boundValueOps("a").get();
        if (value!=null) {
            System.out.println(value);
//            return;
        }
        redisTemplate.boundValueOps("a").set("sdfafd");


    }
}
