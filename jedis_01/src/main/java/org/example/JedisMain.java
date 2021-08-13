package org.example;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ssqswyf
 * @Date 2021/8/12
 */
public class JedisMain {

    public static void main(String[] args) {
        String localhost = "localhost";
        int port = 6379;
        Jedis jedis = new Jedis(localhost, port);

        jedis.set("username", "dfasdfsaf");
        System.out.println(jedis.get("a"));

        Map<String,String> map = new HashMap<>();
        map.put("sdf", "dsfsdf");
        map.put("ssdfadf", "dsdffsdf");
        map.put("sfgdf", "dsfsdfdf");
        jedis.hmset("hs", map);
        jedis.lpush("ll", "sdf","sdafs","fas");
        System.out.println(jedis.lpop("ll"));
        jedis.sadd("ss", "d","d","s");

        jedis.close();
    }
}
