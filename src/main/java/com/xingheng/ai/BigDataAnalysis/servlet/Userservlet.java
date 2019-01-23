package com.xingheng.ai.BigDataAnalysis.servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义servlet
 * @author: lym
 * @Date:2019/1/16 17 24
 * @Description:
 */

@WebServlet(name = "userServlet",urlPatterns = "/v1/api/test/customs")
public class Userservlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().print("custom servlet");
		resp.getWriter().flush();
		resp.getWriter().close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}


}
