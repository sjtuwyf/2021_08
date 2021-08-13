package org.example.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author ssqswyf
 * @Date 2021/8/7
 */
@Component
@Aspect
public class aspect {

    @Pointcut("execution(* org.example.controller.AccountController.findAll(..))")
    public void pt1(){}


    @Before("pt1()")
    public void pre(){
        System.out.println("pre");
    }
}
