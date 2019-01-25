package com.xingheng.ai.BigDataAnalysis.controller;

import com.xingheng.ai.BigDataAnalysis.domain.JsonData;
import com.xingheng.ai.BigDataAnalysis.domain.User;
import com.xingheng.ai.BigDataAnalysis.utils.JsonUtils;
import com.xingheng.ai.BigDataAnalysis.utils.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author: lym
 * @Date:2019/1/24 21 10
 * @Description:
 */
@RestController
@RequestMapping("/api/v1/redis")
public class RedisController {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private RedisClient redis;

	@GetMapping(value = "add")
	public Object add(String name){
//		stringRedisTemplate.opsForValue().set("name",name);
		redis.set("username", name);
		return JsonData.buildSuccess("ok");
	}


	@GetMapping(value = "get")
	public Object get(){
//		String value = stringRedisTemplate.opsForValue().get("name");
		String value = redis.get("username");
		return JsonData.buildSuccess(value);
	}


	@GetMapping(value="save_user")
	public Object saveUser(){
		User user = new User(1, "lym", "123456","18404983938", new Date());
		String userStr = JsonUtils.obj2String(user);
		boolean flag = redis.set("base:user:11", userStr);
		return JsonData.buildSuccess(flag);

	}

	@GetMapping(value="find_user")
	public Object findUser(){

		String userStr = redis.get("base:user:11");
		User user = JsonUtils.string2Obj(userStr, User.class);

		return JsonData.buildSuccess(user);

	}


}
