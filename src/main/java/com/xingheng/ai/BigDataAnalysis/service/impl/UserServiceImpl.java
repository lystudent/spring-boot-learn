package com.xingheng.ai.BigDataAnalysis.service.impl;

import com.xingheng.ai.BigDataAnalysis.domain.User;
import com.xingheng.ai.BigDataAnalysis.mapper.UserMapper;
import com.xingheng.ai.BigDataAnalysis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author: lym
 * @Date:2019/1/23 18 27
 * @Description:
 */

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;

	@Override
	public int add(User user) {
		userMapper.insert(user);
		int id = user.getId();
		return id;
	}



	@Override
	@Transactional(propagation = Propagation.REQUIRED) // 事物注释 隔离级别：REQUIRED
	public int AddCount() {
		User user = new User();
		user.setAge(11);
		user.setCreateTime(new Date());
		user.setName("测试事物啦");
		user.setPhone("18888888888");
		userMapper.insert(user);
        int i= 10/0;
		return i;
	}
}
