package com.itheima.day1;

/**
 * @Author ssqswyf
 * @Date 2021/8/8
 */
public class NewThread {
    private static class UseThread extends Thread{
        @Override
        public void run(){
            System.out.println("use Thread");
        }
    }

    private static class UseRunnable implements Runnable{

        @Override
        public void run() {
            System.out.println("use runnable");
        }
    }

    public static void main(String[] args) {
        Thread useThread = new UseThread();
        useThread.start();
//        useThread.start();
        Thread useRunnable = new Thread(new UseRunnable());
        useRunnable.start();
        useThread.run();
    }
}
