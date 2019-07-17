package com.xingheng.ai.BigDataAnalysis.controller;

import com.xingheng.ai.BigDataAnalysis.annotation.LoginRequired;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: lym
 * @Date:2019/1/9 14 09
 * @Description:
 */

@RestController
@LoginRequired
@RequestMapping("/api/otherhttp")
public class OtherHttpController {

	private Map<String,Object> params = new HashMap<>();


	/**
	 * post请求
	 * @param id
	 * @param pwd
	 * @return
	 */
	@ApiOperation(value = "login", httpMethod = "POST")
	@PostMapping("/v1/login")
	public Object login(String id,String pwd){
		params.clear();
		params.put("id",id);
		params.put("pwd",pwd);
		return params;
	}

	/**
	 * put请求
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "put", httpMethod = "PUT")
	@PutMapping("/v1/put")
	public Object put(String id){
		params.clear();
		params.put("id",id);
		return params;
	}

	/**
	 * delete 请求
	 * @param id
	 * @return
	 */
	@DeleteMapping("v1/del")
	public Object del(String id){
		params.clear();
		params.put("id",id);
		return  params;

	}


}
