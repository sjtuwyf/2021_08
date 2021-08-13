package com.itheima.day1;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchDemo {

    static CountDownLatch countDownLatch = new CountDownLatch(3);

    //任务线程
    private static class TaskThread implements Runnable{

        @Override
        public void run() {
            countDownLatch.countDown();
            System.out.println("task thread is running");
        }
    }

    //等待线程
    private static class WaitThread implements Runnable{

        @Override
        public void run() {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("wait thread is running");
        }
    }

    public static void main(String[] args) throws InterruptedException {

        //等待线程执行
        for (int i = 0; i < 2; i++) {
            new Thread(new WaitThread()).start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(new TaskThread()).start();
        }

        TimeUnit.SECONDS.sleep(3);
    }
}