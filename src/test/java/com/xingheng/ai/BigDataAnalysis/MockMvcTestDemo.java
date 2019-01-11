package com.xingheng.ai.BigDataAnalysis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.concurrent.ExecutionException;

/**
 * @author: lym
 * @Date:2019/1/11 15 09
 * @Description:
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {BigDataAnalysisApplication.class})
@AutoConfigureMockMvc
public class MockMvcTestDemo {
	@Autowired
	private MockMvc mockMvc; // 模拟 客户端 http请求

	@Test
	public void apiTest() throws Exception {
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/test/home"))  // perform 模拟请求  RequestBuilders 构建请求的构建体
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();  // andExpect 类似断言   .isOk() 状态为200
		int status  = mvcResult.getResponse().getStatus();
		String message = mvcResult.getResponse().getContentAsString();
		System.out.println(status);
		System.out.println(message);

	}
}

