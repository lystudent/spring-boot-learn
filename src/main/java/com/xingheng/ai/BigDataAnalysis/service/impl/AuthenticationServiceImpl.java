package com.xingheng.ai.BigDataAnalysis.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.xingheng.ai.BigDataAnalysis.domain.User;
import com.xingheng.ai.BigDataAnalysis.service.AuthenticationService;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

/**
 * @Classname AuthenticationServiceImpl
 * @Description TODO
 * @Date 2019/5/22 3:33 PM
 * @Created by liuyanming
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Override
    public String getToken(User user) {
        String token = "";
        try{
            token = JWT.create()
                    .withAudience(user.getId().toString()) // 将 user id 保存到 token 里面
                    .sign(Algorithm.HMAC256(user.getPwd())); // 以 password 作为 token 的密钥
        }catch (UnsupportedEncodingException ignore) {
        }
        return token;
    }
}
