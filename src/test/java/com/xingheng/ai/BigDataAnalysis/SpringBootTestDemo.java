package com.xingheng.ai.BigDataAnalysis;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: lym
 * @Date:2019/1/11 14 59
 * @Description:
 */

@RunWith(SpringRunner.class)  //底层用junit SpringJUnit4ClassRunner
@SpringBootTest(classes = {BigDataAnalysisApplication.class})  //启动整个springboot工程
public class SpringBootTestDemo {

	@Test
	public void testOne(){
		System.out.println("Hello,test");
		TestCase.assertEquals(1,1); //断言
	}

	@Test
	public void testTwo(){
		System.out.println("Hello,test2");
		TestCase.assertEquals(2,2); //断言
	}

	@Before
	public void testBefore(){
		System.out.println("Before");
	}

	@After
	public void testAfter(){
		System.out.println("After");
	}


}
