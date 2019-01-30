package com.xingheng.ai.BigDataAnalysis;

import com.xingheng.ai.BigDataAnalysis.domain.User;
import com.xingheng.ai.BigDataAnalysis.utils.JsonUtils;
import com.xingheng.ai.BigDataAnalysis.utils.RedisClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: lym
 * @Date:2019/1/28 14 23
 * @Description:
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes={BigDataAnalysisApplication.class})
public class JsonTest {
	@Autowired
	private StringRedisTemplate strTpl;

	@Autowired
	private RedisClient redis;

	@Test
	public void testOne(){
		User u = new User();
		u.setAge(1);
		u.setPhone("22222");
		u.setPwd("0000");

		String str = JsonUtils.obj2String(u);
		strTpl.opsForValue().set("str", str);
		System.out.println(str);

	}

}
