package com.itheima.day1;

import java.util.HashSet;
import java.util.Set;

public class DeadLock {



    private static String value1 = "a";
    private static String value2 = "b";

    public static void main(String[] args) {
        new DeadLock().deadLock();
    }

    private void deadLock() {

        Set<Character> set = new HashSet<>();

        Thread t1 = new Thread(()->{
            try {
                System.out.println("t1 running");
                while (true){
                    synchronized (value1){
                        System.out.println("t1 lock value1");
                        Thread.sleep(3000);//获取obj1后先等一会儿，让Lock2有足够的时间锁住obj2
                        synchronized(value2){
                            System.out.println("t1 lock value2");
                        }
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(()->{
            try {
                System.out.println("t2 running");
                while (true){
                    synchronized (value2){
                        System.out.println("t2 lock value2");
                        Thread.sleep(3000);//获取obj1后先等一会儿，让Lock2有足够的时间锁住obj2
                        synchronized(value1){
                            System.out.println("t2 lock value1");
                        }
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
    }
}