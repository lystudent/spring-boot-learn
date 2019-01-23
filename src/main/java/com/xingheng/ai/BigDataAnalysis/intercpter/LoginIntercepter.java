package com.xingheng.ai.BigDataAnalysis.intercpter;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截
 * @author: lym
 * @Date:2019/1/17 18 30
 * @Description:
 */
public class LoginIntercepter implements HandlerInterceptor {

	/**
	 * 进入contrpller方法之前
	 *
	 * @param request
	 * @param response
	 * @param handler
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("Loginintercepter------>preHandle");
		request.getParameter("access_token"); //获取token,存在缓存里，redis。
//		response.getWriter().print("fail");   //返回响应
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	/**
	 * 调用完controller之后，在视图渲染之前
	 *
	 * @param request
	 * @param response
	 * @param handler
	 * @param modelAndView
	 * @throws Exception
	 */

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		System.out.println("Loginintercepter------>postHandle");
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	/**
	 * 整个完成之后,通常用于资源清理
	 *
	 * @param request
	 * @param response
	 * @param handler
	 * @param ex
	 * @throws Exception
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		System.out.println("Loginintercepter------>afterCompletion");
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}
