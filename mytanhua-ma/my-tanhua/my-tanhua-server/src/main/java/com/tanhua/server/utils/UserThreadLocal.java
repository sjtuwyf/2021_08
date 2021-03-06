package com.tanhua.server.utils;

import com.tanhua.server.pojo.User;

/**
 * @Author ssqswyf
 * @Date 2021/8/20
 */
public class UserThreadLocal {
    private static final ThreadLocal<User> LOCAL = new ThreadLocal<>();
    private UserThreadLocal() {

    }
    public static void set(User user){
        LOCAL.set(user);
    }
    public static User get() {
        return LOCAL.get();
    }
}
