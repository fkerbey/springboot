package com.w.springboot.test.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.w.springboot.framework.db.DbClient;
import com.w.springboot.test.entity.User;
import com.w.springboot.test.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private DbClient  client;
	
	@Override
	public User findUserByUserName(String name) {
		User user = new User();
		user.setUsername(name);
		Object findOne = client.findOne(1);
		return null;
	}

}
