package com.xingheng.ai.BigDataAnalysis.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 全局的异常处理
 * @author: lym
 * @Date:2019/1/11 16 11
 * @Description:
 */
@RestControllerAdvice
public class CustomExtHandler {

	private static final Logger LOG = LoggerFactory.getLogger(CustomExtHandler.class);
	// 捕获所有异常，处理所有不可知的异常
	@ExceptionHandler(value = Exception.class)
//	@RequestBody
	Object handleException(Exception e, HttpServletRequest request){
		LOG.error("url {},msg {}",request.getRequestURI(),e.getMessage());
		Map<String,Object> map = new HashMap<>();
		map.put("code",100);
		map.put("msg",e.getMessage());
		map.put("url",request.getRequestURI());
		return map;
	}



	/**sdddasddddd
	 * 处理自定义异常
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value = MyExcption.class)
	Object MyhandleException(Exception e){
		ModelAndView modelAndView = new ModelAndView();  // 用来做页面跳转
		modelAndView.setViewName("error.html");
		modelAndView.addObject("msg",e.getMessage());
		return modelAndView;
	}




}
