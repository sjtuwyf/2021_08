package com.itheima.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @Author ssqswyf
 * @Date 2021/8/5
 */
public class PermissionAspect {
    public void checkPermission() {
        System.out.println("check...");
    }

    public void printLog() {
        System.out.println("log...");
    }

    public void showException() {
        System.out.println("exception...");
    }

    public void showEnd() {
        System.out.println("end...");
    }

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
