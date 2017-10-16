package com.wanwan.common.util.aoplog;

import java.lang.annotation.*;

/**
 * Created by c_zhangyayun-001 on 2017/9/22.
 * 自定义一个注解
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemLog {
    String module() default "";
    String methods() default "";
}
