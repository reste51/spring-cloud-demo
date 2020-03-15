package com.imooc.add.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 忽略返回的注解
 * Created by 50204 on 2020/3/12.
 */
// 可修饰 类 和 方法
@Target({ElementType.TYPE,ElementType.METHOD})
// 运行时
@Retention(RetentionPolicy.RUNTIME)
public @interface IgnoreResponseAdvice {
}
