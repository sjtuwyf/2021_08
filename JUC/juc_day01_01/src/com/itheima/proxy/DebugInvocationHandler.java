package com.itheima.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author ssqswyf
 * @Date 2021/8/11
 */
public class DebugInvocationHandler implements InvocationHandler {
    private final Object target;

    public DebugInvocationHandler(Object target) {
        this.target = target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before"+method.getName());
        Object invoke = method.invoke(target, args);
        System.out.println("after" + method.getName());
        return invoke;
    }
}
