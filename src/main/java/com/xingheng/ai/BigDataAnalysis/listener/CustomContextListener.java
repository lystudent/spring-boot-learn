package com.xingheng.ai.BigDataAnalysis.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * @author: lym
 * @Date:2019/1/16 18 34
 * @Description:
 */
@WebListener
public class CustomContextListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("===========contextInitialized=====================请求初始化");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("===========contextDestroyed=====================请求销毁");
	}
}
