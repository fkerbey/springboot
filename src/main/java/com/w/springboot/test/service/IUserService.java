package com.w.springboot.test.service;

import com.w.springboot.test.entity.User;

public interface IUserService {

	public User findUserByUserName(String name);
}
