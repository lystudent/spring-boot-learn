package com.xingheng.ai.BigDataAnalysis.controller;

import com.xingheng.ai.BigDataAnalysis.domain.MyExcption;
import com.xingheng.ai.BigDataAnalysis.domain.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * 异常测试
 *
 * @author: lym
 * @Date:2019/1/11 16 00
 * @Description:
 */
@RestController
public class ExcptionController {

	@ApiOperation(value = "全局异常测试", httpMethod = "POST")
	@PostMapping("/api/va/test_ext")
	public Object index() {
		int i = 1 / 0;
		return new User(11, "lym", "123456", "13888888888", new Date());
	}

	@ApiOperation(value = "自定义异常测试", httpMethod = "POST")
	@RequestMapping("/api/va/test_myext")
	@ResponseBody
	public Object myexc() {
		throw new MyExcption("499", "myexc 异常");
	}
}
