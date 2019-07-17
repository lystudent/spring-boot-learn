package com.xingheng.ai.BigDataAnalysis.intercpter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.xingheng.ai.BigDataAnalysis.annotation.LoginRequired;
import com.xingheng.ai.BigDataAnalysis.domain.User;
import com.xingheng.ai.BigDataAnalysis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.FallbackExceptionTranslationStrategy;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;


/**
 * @Classname AuthenticationInterceptor
 * @Description 登录拦截器
 * @Date 2019/5/23 11:23 AM
 * @Created by liuyanming
 */
public  class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();   // 获取方法的注解


//        RequestLimitmethodRequestLimit= ((HandlerMethod) handler).getMethodAnnotation(LoginRequired.class);              //方法注解
//        RequestLimitclassRequestLimit= ((HandlerMethod) handler).getBean().getClass().getAnnotation(LoginRequired.class);      //类注解


        // 判断接口是否需要登录
        LoginRequired methodAnnotation = method.getAnnotation(LoginRequired.class);

        LoginRequired typeAnnotation = handlerMethod.getBean().getClass().getAnnotation(LoginRequired.class); // 获取类的注解，并判断是否需要登录
        // 有 @LoginRequired 注解，需要认证

        if (typeAnnotation != null) {
            //执行认证
            String token = request.getHeader("Authorization");
            if (token == null) {
                throw new RuntimeException("无token,请重新登录");
            }
            Long userID;
            try {
                userID = Long.parseLong(JWT.decode(token).getAudience().get(0));
            } catch (JWTDecodeException e) {
                throw new RuntimeException("token无效，请重新登录");
            }
            User user = userService.findByID(userID);
            if (user == null) {
                throw new RuntimeException("用户不存在，请重新登录");
            }

            //验证token

            try {
                JWTVerifier verifier = JWT.require(Algorithm.HMAC256(user.getPwd())).build();
                try {
                    verifier.verify(token);
                } catch (JWTVerificationException e) {
                    throw new RuntimeException("token无效，请重新登录");
                }
            } catch (UnsupportedEncodingException e) { }
            request.setAttribute("currentUser", user);
            return true;
        }
        return true;
    }

}
