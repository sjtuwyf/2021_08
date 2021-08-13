package com.itheima.controller;

import com.itheima.service.UserService;

/**
 * @Author ssqswyf
 * @Date 2021/8/4
 */
public class UserController {
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserController() {
    }

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public String getName(){
        return userService.getName();
    }
}
