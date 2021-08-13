package com.itheima.controller;

import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;



/**
 * @Author ssqswyf
 * @Date 2021/8/4
 */
@Controller
public class UserController {
    @Autowired
//    @Qualifier("userServiceImpl")
//    @Resource(name = "userServiceImpl")
    private UserService userService;
    public String getName(){
        return userService.getName();
    }
}
