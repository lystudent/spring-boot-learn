package com.xingheng.ai.BigDataAnalysis.intercpter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: lym
 * @Date:2019/1/17 16 20
 * @Description:
 */
@Configuration
public class CustomWebMvcConfigurer implements WebMvcConfigurer {



//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(new LoginIntercepter()).addPathPatterns("/api2/*/**") ;
////		.excludePathPatterns("/api2/xxx/***"); //拦截正则
//		registry.addInterceptor(new TwoIntercepter()).addPathPatterns("/api2/*/**");
//		WebMvcConfigurer.super.addInterceptors(registry);
//	}


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor())
        .addPathPatterns("/**")
        .excludePathPatterns("/api/authentication/**");
        // 拦截所有请求，通过判断是否有 @LoginRequired 注解 决定是否需要登录
        WebMvcConfigurer.super.addInterceptors(registry);
    }

    @Bean
    public AuthenticationInterceptor authenticationInterceptor(){
        return new AuthenticationInterceptor();
    }
}
