package com.itheima.controller;

import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @Author ssqswyf
 * @Date 2021/8/5
 */
@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    public void transfer(String fromName,String toName,Double money) {
        try {
            accountService.transfer(fromName, toName, money);
            System.out.println("success");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("fail");
        }
    }
}
