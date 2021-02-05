package com.w.springboot.test.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.w.springboot.test.dao.UserRepository;
import com.w.springboot.test.entity.User;

@Controller
@RequestMapping("/hibernate")
@EnableAutoConfiguration
public class HibernateController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping("getUserById")
	@ResponseBody
	public Iterable<User> getUserById(Long id) {
		 Iterable<User> findAll = userRepository.findAll();
		return findAll;
	}

	@RequestMapping("saveUser")
	@ResponseBody
	public void saveUser() {
		User u = new User();
		u.setUserName("阿萨德飞");
		u.setAddress("化功大法娃儿");
		u.setBirthDay(new Date());
		u.setSex("男");
		userRepository.save(u);
	}
	
	

}