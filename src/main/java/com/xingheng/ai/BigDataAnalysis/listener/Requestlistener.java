package com.xingheng.ai.BigDataAnalysis.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;


/**
 * @author: lym
 * @Date:2019/1/16 18 27
 * @Description:
 */
@WebListener
public class Requestlistener implements ServletRequestListener{
	@Override
	public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
		System.out.println("===========requestDestroyed=====================请求销毁");
	}

	@Override
	public void requestInitialized(ServletRequestEvent servletRequestEvent) {
		System.out.println("===========requestInitialized=====================请求初始化");
	}
}
