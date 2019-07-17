package com.xingheng.ai.BigDataAnalysis.service.impl;

import com.xingheng.ai.BigDataAnalysis.domain.User;
import com.xingheng.ai.BigDataAnalysis.mapper.UserMapper;
import com.xingheng.ai.BigDataAnalysis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
		String passwordHash = passwordToHash(user.getPwd());
		user.setPwd(passwordHash);
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

	@Override
	public User findByName(String name) {
		User user = userMapper.findByName(name);
		return user;
	}

	@Override
	public User findByID(Long id) {
		User user = userMapper.findById(id);
		return user;
	}


	/**
	 * 判断接口传入的密码和数据库的密码是否一致
	 * @param user
	 * @param userInDatabase
	 * @return
	 */
	@Override
	public boolean comparePassword(User user, User userInDatabase) {
		return  passwordToHash(user.getPwd())  // 将用户提交的密码转换为 hash
				.equals(userInDatabase.getPwd());  // 数据库中的 password 已经是 hash，不用转换
	}



	/**
	 * 将用户密码进行加密。
	 * @param password
	 * @return
	 */
	private String passwordToHash(String password){


		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			digest.update(password.getBytes());
			byte[] src = digest.digest();
			StringBuilder stringBuilder = new StringBuilder();
			// 字节数组转16进制字符串
			// https://my.oschina.net/u/347386/blog/182717
			for (byte aSrc : src) {
				String s = Integer.toHexString(aSrc & 0xFF);
				if (s.length() < 2) {
					stringBuilder.append('0');
				}
				stringBuilder.append(s);
			}
			return stringBuilder.toString();
		} catch (NoSuchAlgorithmException ignore) {
		}
		return null;
	}





}
