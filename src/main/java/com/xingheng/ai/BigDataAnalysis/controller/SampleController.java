package com.xingheng.ai.BigDataAnalysis.controller;

import com.xingheng.ai.BigDataAnalysis.domain.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: lym
 * @Date:2019/1/9 10 16
 * @Description:
 */
@RestController
@RequestMapping
public class SampleController {

	@ApiOperation(value = "hello", httpMethod = "POST")
	@RequestMapping("/hello")
	String hemo(){
		return "Hello,World";
	}


	@RequestMapping(value = "/test/home",method = RequestMethod.POST)
	public String home(){
		return "xdclass";
	}


	@ApiOperation(value = "test", httpMethod = "POST")
	@RequestMapping("/test")
	public Map<String,String> testMap(){
		Map<String,String> map = new HashMap<>();
		map.put("name","lym");
		return  map ; //@ResponseBody 会把map转化为json返回
	}

	@ApiOperation(value = "testJson", httpMethod = "GET")
	@GetMapping("/testJson")
	public Object testJson(){
		return  new User(11,"lym","123456","138",new Date()); //@ResponseBody 会把user转化为json返回
	}

}
