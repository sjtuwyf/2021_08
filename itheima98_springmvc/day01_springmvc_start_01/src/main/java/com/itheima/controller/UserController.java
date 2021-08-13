package com.itheima.controller;

import com.itheima.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author ssqswyf
 * @Date 2021/8/6
 */
@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping("/getName")
    public String getName(String username,int age){
        System.out.println("uaername:" + username+" age:"+age);
        return "success";
    }

    @PostMapping("/register")
    public String register(User user){
        System.out.println(user);
        return "success";
    }

    @PostMapping("/getRequestBody")
    public String getRequestBody(@RequestBody String body){
        System.out.println(body);
        return "success";
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") int id){
        System.out.println("delete" + id);
        return "success";
    }

    @GetMapping("/{id}/{num}")
    public String findById(@PathVariable("id")int id,@PathVariable("num") int number){
        System.out.println("find" + id+"  "+number);
        return "success";
    }
}
