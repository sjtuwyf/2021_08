package com.itheima.juc;

/**
 * @Author ssqswyf
 * @Date 2021/8/11
 */
public class Singleton {
    private volatile static Singleton uniqueInstance;

    public Singleton() {
    }

    public static Singleton getUniqueInstance() {
        if (uniqueInstance == null){
            synchronized (Singleton.class) {
                if (uniqueInstance ==null ){
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}
