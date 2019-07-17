package com.xingheng.ai.BigDataAnalysis.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义filter 拦截器
 *
 * @author: lym
 * @Date:2019/1/16 16 12
 * @Description:
 */

//@WebFilter(urlPatterns = "/api/*",filterName = "LoginFilter")
public class LoginFilter implements Filter {

	/**
	 * filter初始化 在启动容器的时候 new一个实例，掉这个方法
	 * 容器加载的时候用
	 * @param filterConfig
	 * @throws ServletException
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("init loginFilter");
	}

	/**
	 * 请求过滤
	 * 请求被拦截的时候用
	 * @param servletRequest
	 * @param servletResponse
	 * @param filterChain
	 * @throws IOException
	 * @throws ServletException
	 */
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		System.out.println("doFilter loginFilter");

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String username = request.getParameter("username");

		if ("lym".equals(username)) {
			filterChain.doFilter(servletRequest, servletResponse);
		} else {
			response.sendRedirect("/index1.html"); // 过滤跳转页面
			return;
		}


	}

	/**
	 * 容器被销毁的时候调用
	 */
	@Override
	public void destroy() {
		System.out.println("destroy loginfilter");
	}
}
