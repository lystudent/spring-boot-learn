package com.xingheng.ai.BigDataAnalysis.controller;

import com.sun.net.httpserver.HttpsServer;
import com.xingheng.ai.BigDataAnalysis.annotation.LoginRequired;
import com.xingheng.ai.BigDataAnalysis.domain.JsonData;
import com.xingheng.ai.BigDataAnalysis.domain.User;
import com.xingheng.ai.BigDataAnalysis.mapper.UserMapper;
import com.xingheng.ai.BigDataAnalysis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @author: lym
 * @Date:2019/1/24 14 19
 * @Description:
 */
@RestController
@LoginRequired
@RequestMapping("/api/v1/user")

public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserMapper userMapper;

	/**
	 * 功能描述: user 保存接口
	 * @return
	 */
	@PostMapping("add")
	public Object add(@RequestBody User user){
		if (userService.findByName(user.getName()) !=null){
//            response.setStatus(401);
//            return JsonData.buildError("用户名已经被使用！",401);
		   return JsonData.buildError("用户名已经被使用");
        }
        userService.add(user);
		return userService.findByName(user.getName());
	}





	@GetMapping("findAll")
	public Object findAll(){

       return JsonData.buildSuccess(userMapper.getAll());
	}



	@GetMapping("findById")
	public Object findById(long id){
       return JsonData.buildSuccess(userMapper.findById(id));
	}


	@GetMapping("del_by_id")
	public Object delById(long id){
	userMapper.delete(id);
       return JsonData.buildSuccess();
	}

	@GetMapping("update")
	public Object update(String name,int id){
		User user = new User();
		user.setName(name);
		user.setId(id);
		userMapper.update(user);
	    return JsonData.buildSuccess();
	}





	//测试事务
	@GetMapping("add_account")
	public Object addAccount(){
		int id = userService.AddCount();
	    return JsonData.buildSuccess(id);
	}


}
