package com.itheima.proxy;

/**
 * @Author ssqswyf
 * @Date 2021/8/11
 */
public class psvm {
    public static void main(String[] args) {
        SmsService proxy = (SmsService) JdkProxyFactor.getProxy(new SmsServiceImpl());
        proxy.send("java");
    }
}
