package com.xingheng.ai.BigDataAnalysis.controller;

import com.alibaba.fastjson.JSONObject;
import com.xingheng.ai.BigDataAnalysis.domain.JsonData;
import com.xingheng.ai.BigDataAnalysis.domain.User;
import com.xingheng.ai.BigDataAnalysis.service.AuthenticationService;
import com.xingheng.ai.BigDataAnalysis.service.UserService;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.json.Json;

/**
 * @Classname AuthenticationController
 * @Description TODO
 * @Date 2019/5/22 3:30 PM
 * @Created by liuyanming
 */

@RestController
@RequestMapping("/api/authentication")
public class AuthenticationController {

    private AuthenticationService authenticationService;

    private UserService userService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService, UserService userService){
        this.authenticationService = authenticationService;
        this.userService = userService;
    }

    @PostMapping("")
    public Object login(@RequestBody User user){
        User userInDataBase = userService.findByName(user.getName());
//        JsonData jsonData = new JsonData();
        JSONObject jsonObject = new JSONObject();
        if(userInDataBase == null){
//            jsonData.buildError("用户不存在");
            jsonObject.put("message", "用户不存在");

        }else if(!userService.comparePassword(user,userInDataBase)){
//            jsonData.buildError("用户密码错误");
            jsonObject.put("message", "密码不正确");
        }else {
            String token = authenticationService.getToken(userInDataBase);
            jsonObject.put("token", token);
            jsonObject.put("user", userInDataBase);
        }

        return jsonObject;
    }

}
