package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author ssqswyf
 * @Date 2021/8/6
 */
@Controller
public class HelloController {

    @RequestMapping(value = "/hello/sayHello")
    public String sayHello() {
        System.out.println("hello world!");
        return "success";
    }

    @RequestMapping("/getName")
    public String getName(String username,int age){
        System.out.println("uaername:" + username+" age:"+age);
        return "success";
    }
}
