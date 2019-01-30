package com.xingheng.ai.BigDataAnalysis.controller;

import com.xingheng.ai.BigDataAnalysis.domain.JsonData;
import com.xingheng.ai.BigDataAnalysis.domain.ServerSettings;
import com.xingheng.ai.BigDataAnalysis.domain.User;
import com.xingheng.ai.BigDataAnalysis.service.UserService;
import com.xingheng.ai.BigDataAnalysis.task.AsyncTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.core.Ordered;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

/**
 * get请求
 *
 * @author: lym
 * @Date:2019/1/9 11 50
 * @Description:
 */

@RestController
public class GetController {
	private Map<String, Object> params = new HashMap<>();

	@Autowired
	private UserService userService;

	@Autowired
	private AsyncTask asyncTask;

//	@RequestMapping(path = "/{city_id}/{user_id}",method = RequestMethod.GET)
//	public Object findUser(@PathVariable("city_id") String cityId, @PathVariable("user_id") String userId){
//		params.clear();
//
//		params.put("cityId",cityId);
//		params.put("userId",userId);
//		return params;
//	}

	@GetMapping(value = "/v1/page_user1")
	public Object pageUser(int from, int size) {
		params.clear();

		params.put("from", from);
		params.put("size", size);
		return params;
	}

	/**
	 * 功能描述 ： 默认值，是否必须的参数
	 *
	 * @param from
	 * @param size
	 * @return
	 */
	@GetMapping(value = "/v1/page_user2")
	public Object pageUserV2(@RequestParam(defaultValue = "0", name = "from") Integer from, int size) {  //默认值类型不能是int，参数为int类型，不能赋值为null，故需要修改为Integer
		params.clear();

		params.put("from", from);
		params.put("size", size);
		System.out.println("热部署");
		System.out.println("热部署");
		return params;
	}

	/**
	 * 对象传输  POST
	 *
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/v1/save_user", method = RequestMethod.POST)
	public Object saveUser(@RequestBody User user) {
		params.clear();
		params.put("user", user);
		return params;
	}


	/**
	 * 测试Http头信息
	 *
	 * @param accessToken
	 * @param size
	 * @return
	 */
	@GetMapping(value = "/v1/page_user3")
	public Object getHeader(@RequestHeader("access_token") String accessToken, int size) {
		params.clear();

		params.put("access_token", accessToken);
		params.put("size", size);
		return params;
	}


	@GetMapping(value = "/v1/test_request")
	public Object test_requst(HttpServletRequest request) {
		params.clear();
		String id = request.getParameter("id");
		System.out.println("Controller处理中");
		params.put("id", id);
		return params;
	}


	@Autowired
	private ServerSettings serverSettings;

	@GetMapping(value = "/api/v1/test_properties")
	public Object test_properties(HttpServletRequest request) {

		return serverSettings;
	}


	@GetMapping(value = "/api/v1/account")
	public Object account() {  //默认值类型不能是int，参数为int类型，不能赋值为null，故需要修改为Integer
		params.clear();
		params.put("money","100000000000");
		params.put("name", "lym");
		return params;
	}

	@GetMapping(value = "/api2/v1/account1")
	public Object account1(){
		System.out.println("crotroller --->account1");
		params.put("money","1000");
		return params;
	}

	@PutMapping(value = "/api/insertuser")
	public Integer insertuser(){
		userService.add(new User());
		return 1;
	}

	@GetMapping(value = "/api/v1/async")
	public JsonData exeTask() throws  InterruptedException{
		long begin = System.currentTimeMillis();
//		asyncTask.task1();
//		asyncTask.task2();
//		asyncTask.task3();
		Future<String> task4 = asyncTask.task4();
		Future<String> task5 = asyncTask.task5();
		Future<String> task6 = asyncTask.task6();
		for(;;){
			if (task4.isDone() && task5.isDone() && task6.isDone()){
				break;
			}
		}
		long end = System.currentTimeMillis();
		long total = end-begin;
		System.out.println("执行总耗时="+total);
		return JsonData.buildSuccess();
	}

}
