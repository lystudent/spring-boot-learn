package com.xingheng.ai.BigDataAnalysis.controller;

import com.xingheng.ai.BigDataAnalysis.domain.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	@ApiOperation(value = "异常测试", httpMethod = "POST")
	@PostMapping("/api/va/test_ext")
	public Object index() {
		int i = 1 / 0;
		return new User(11, "lym", "123456", "13888888888", new Date());
	}
}
