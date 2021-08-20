package com.tanhua.sso.service;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

/**
 * @Author ssqswyf
 * @Date 2021/8/17
 */
public class testMangoDBData {

    @Test
    public void testMongoDBData() {
        for (int i = 2; i < 100; i++) {
            int score = RandomUtils.nextInt(30, 99);
            System.out.println("db.recommend_user.insert({\"userId\":" + i +
                    ",\"toUserId\":1,\"score\":"+score+",\"date\":\"2019/1/1\"})");
        }
    }
}


