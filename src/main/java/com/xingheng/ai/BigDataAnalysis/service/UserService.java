package com.xingheng.ai.BigDataAnalysis.service;

import com.xingheng.ai.BigDataAnalysis.domain.User;
import org.springframework.stereotype.Service;

/**
 * @author: lym
 * @Date:2019/1/23 18 27
 * @Description:
 */

public interface UserService {

	public int add(User user);

	public int AddCount();

	public User findByName(String name);

	public  User findByID(Long id);

	public boolean comparePassword(User user,User userInDatabase);
}
