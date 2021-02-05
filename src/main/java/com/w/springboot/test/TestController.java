package com.w.springboot.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.w.springboot.test.entity.User;
import com.w.springboot.test.service.IUserService;

@Controller
@RequestMapping("/")
public class TestController {

	@Autowired
	private IUserService service;
	
	@RequestMapping("test")
	public User finduser() {
		return service.findUserByUserName("");
	}
}
