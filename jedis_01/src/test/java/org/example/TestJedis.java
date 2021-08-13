package org.example;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * @Author ssqswyf
 * @Date 2021/8/12
 */
public class TestJedis {

    @Test
    public void testJedis01() {
        String localhost = "localhost";
        int port = 6379;
        Jedis jedis = new Jedis(localhost, port);

        jedis.set("username", "dfasdfsaf");

        jedis.close();
    }
}
