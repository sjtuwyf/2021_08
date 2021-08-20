package com.tanhua.sso.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestSmsService {

    @Autowired
    private SmsService smsService;

    @Test
    public void testSend(){
        String code = this.smsService.sendSms("13127827189");
        System.out.println(code);
    }

}
