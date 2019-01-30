package com.xingheng.ai.BigDataAnalysis.controller;

import com.xingheng.ai.BigDataAnalysis.domain.JsonData;
import javafx.beans.binding.ObjectExpression;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lym
 * @Date:2019/1/28 17 40
 * @Description:
 */
@RestController
@RequestMapping("/api2/log")
public class LogController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());


	@GetMapping("/test")
	public Object testLog(){
		logger.debug("这是debug日志信息");
		logger.info("这是info日志信息");
		logger.warn("这是warn日志信息");
		logger.error("这是error日志信息");
		return JsonData.buildSuccess();
	}
}
