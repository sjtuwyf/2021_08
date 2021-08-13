package com.itheima.day1;

import java.util.concurrent.TimeUnit;

/**
 * @Author ssqswyf
 * @Date 2021/8/8
 */
public class VolatileTest {

    static volatile int a = 1;

    public static void main(String[] args) throws InterruptedException {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " :   启动了");

                while (true) {
                    if (a == 3) {
                        break;
                    }
                }
                System.out.println(Thread.currentThread().getName() + " :   停止了");
            }
        },"t1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " :   启动了");

                while (true) {
                    if (a == 3) {
                        break;
                    }
                }
                System.out.println(Thread.currentThread().getName() + " :   停止了");
            }
        },"t2").start();

        TimeUnit.SECONDS.sleep(1);
        a=3;
    }
}
