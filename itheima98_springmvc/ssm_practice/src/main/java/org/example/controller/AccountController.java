package org.example.controller;

import org.example.pojo.Account;
import org.example.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author ssqswyf
 * @Date 2021/8/7
 */

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping("findAll/{id}")
    public String findAll(/*String myText, @RequestParam("hobby") List<Integer> hobby,*/ @PathVariable("id") Integer nid){
//        System.out.println(myText);
//        List<Account> accountList = accountService.findAll();
//        System.out.println(accountService.findAll());
//        System.out.println(myText);
//        System.out.println(hobby);
        System.out.println(nid);
        return "accountList.get(0)";
    }
}
