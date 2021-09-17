package com.demo.config;

import java.lang.annotation.*;

@Inherited//标识该注解会被子类继承
@Documented//标识自定义注解
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface OperateLog {
}
