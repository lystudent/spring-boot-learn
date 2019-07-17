package com.xingheng.ai.BigDataAnalysis.service;

import com.xingheng.ai.BigDataAnalysis.domain.User;
import org.springframework.stereotype.Service;

/**
 * @Classname AuthenticationService
 * @Description TODO
 * @Date 2019/5/22 3:31 PM
 * @Created by liuyanming
 */

@Service
public interface AuthenticationService {

    public  String getToken(User user);
}
