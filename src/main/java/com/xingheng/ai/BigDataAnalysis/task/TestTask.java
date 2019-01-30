package com.xingheng.ai.BigDataAnalysis.task;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author: lym
 * @Date:2019/1/28 14 45
 * @Description:
 */

@Component // 会被启动类里面的 EnableScheduling注解扫描
public class TestTask {



//	@Scheduled(fixedRate = 2000)   // 每隔2秒 输出当前时间
//	@Scheduled(cron = "* * * * * *") //每秒执行一次
//	@Scheduled(fixedRateString = "1000")  //字符串参数，可以实现配置参数
	public void sum() throws InterruptedException{
		Thread.sleep(1000L);
		System.out.println("当前时间："+ new Date());
	}
}
