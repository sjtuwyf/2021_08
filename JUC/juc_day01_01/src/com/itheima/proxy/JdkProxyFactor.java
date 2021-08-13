package com.itheima.proxy;

import java.lang.reflect.Proxy;

/**
 * @Author ssqswyf
 * @Date 2021/8/11
 */
public class JdkProxyFactor {
    public static Object getProxy(Object target){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new DebugInvocationHandler(target));
    }
}
