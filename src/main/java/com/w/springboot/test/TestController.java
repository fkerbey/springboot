package com.w.springboot.test;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.w.springboot.test.entity.User;
import com.w.springboot.test.service.IUserService;

@Controller
@RequestMapping("/")
public class TestController {

	@Autowired
	private IUserService service;
	
	@RequestMapping("test")
	public String test() {
		return "index";
	}
	
	@RequestMapping("finduser")
	@ResponseBody
	public User finduser() {
		return service.findUserByUserName("");
	}
	@RequestMapping("/login")
    public String login() {
		return "login";  
    }
    @RequestMapping("/loginUser")
    public String loginUser(String username,String password,HttpSession session) {
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(usernamePasswordToken);   //完成登录
            User user=(User) subject.getPrincipal();
            session.setAttribute("user", user);
            return "web/index";
        } catch(Exception e) {
            return "web/login";//返回登录页面
        }
        
    }
    @RequestMapping("/logOut")
    public String logOut(HttpSession session) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
//        session.removeAttribute("user");
        return "web/login";
    }
}
