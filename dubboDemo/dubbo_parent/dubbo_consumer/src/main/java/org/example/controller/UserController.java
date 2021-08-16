package org.example.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import org.example.pojo.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

//    @Reference(loadbalance = "rounddrobin")
    @Autowired
    private UserService userService;

    @RequestMapping("/findById")
    public User findById(int id){
        // 调用服务
        User user = userService.findById(id);
        return user;// 返回json数据
    }
}