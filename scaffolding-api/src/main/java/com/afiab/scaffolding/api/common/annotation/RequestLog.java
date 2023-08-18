package com.afiab.scaffolding.api.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/8/14 11:41
 * @Description: 使用本注解的方法推送请求日志 到 kafka
 */
@Documented
@Retention(RUNTIME)
@Target(METHOD)
public @interface RequestLog {

}
