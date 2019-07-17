package com.xingheng.ai.BigDataAnalysis.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Classname LoginRequired
 * @Description 在需要登录验证的Controller的方法上使用此注解
 * @Date 2019/5/23 11:17 AM
 * @Created by liuyanming
 */

@Target({ElementType.TYPE,ElementType.METHOD})  //表示该自定义注解可以用在方法上
@Retention(RetentionPolicy.RUNTIME)  //表示该注解在代码运行时起作用
public @interface LoginRequired {


}
