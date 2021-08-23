package com.tanhua.server.utils;

import java.lang.annotation.*;

/**
 * @Author ssqswyf
 * @Date 2021/8/20
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NoAuthorization {
}
