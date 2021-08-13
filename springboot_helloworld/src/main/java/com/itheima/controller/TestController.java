package com.itheima.controller;

import com.itheima.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ssqswyf
 * @Date 2021/8/12
 */
@RestController
public class TestController {

    @Autowired
    private Environment environment;

    @Autowired
    private Student student;

    @Value("${person.name}")
    private String personName;

    @Value("${ips[0]}")
    private String ip;

    @Value("${students[0].name}")
    private String name;

    @Value("${age}")
    private Integer age;

    @RequestMapping("/hello")
    public String showHello(){



        return "hello world"+age+ip+name+personName+"  df  "+student.getName()
                +environment.getProperty("person.age");
    }
}
