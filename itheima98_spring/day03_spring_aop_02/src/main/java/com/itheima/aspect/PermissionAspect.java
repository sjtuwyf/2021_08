package com.itheima.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Author ssqswyf
 * @Date 2021/8/5
 */
@Component
@Aspect
public class PermissionAspect {

    @Pointcut("execution(* com.itheima.service.impl.UserServiceImpl.*(..))")
    public void pt1(){

    }

    @Pointcut("execution(* com.itheima.service.impl.UserServiceImpl.update(..))")
    public void pt2(){

    }

    @Before("pt1()")
    public void checkPermission() {
        System.out.println("check...");
    }

    @AfterReturning("pt1()")
    public void printLog() {
        System.out.println("log...");
    }

    @AfterThrowing("pt1()")
    public void showException() {
        System.out.println("exception...");
    }

    @After("pt1()")
    public void showEnd() {
        System.out.println("end...");
    }

    @Around("pt2()")
    public void showMillions(ProceedingJoinPoint joinPoint) {
        long timeMillis1 = System.currentTimeMillis();

        try {
            joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }

        long timeMillis2 = System.currentTimeMillis();

        System.out.println(timeMillis2 - timeMillis1);
    }

}
