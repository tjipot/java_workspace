package org.fkit.controller;

import org.fkit.domain.User;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	// 静态List<User>集合, 替代数据库来保存用户信息一下;
	private static List<User> userList;
	// 静态日志类LogFactory;
	private static final Log logger = LogFactory.getLog(UserController.class);
	
	// 构造器初始化List<User>集合;
	public UserController() { 
		super();
		userList = new ArrayList<User>();
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String registerForm() {
		logger.info("register Get方法被调用");
		return "registerForm";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(@RequestParam("loginname") String loginname,
			@RequestParam("password") String password, @RequestParam("username") String username) {
		logger.info("register POST 方法被调用");
		// 创建User对象;
		User user = new User();
		user.setLoginname(loginname);
		user.setPassword(password);
		user.setUsername(username);
		// 模拟数据库存储User信息;
		userList.add(user);
		
		return "loginForm";
	}
	
	@RequestMapping("/login")
	public String login(@RequestParam("loginname") String loginname,
			@RequestParam("password") String password, Model model) {	// 传进来的是框架包装好的Model类型;
		
		logger.info("Login Name" + loginname + " Password:" + password);
		for(User user : userList) {
			if(user.getLoginname().equals(loginname) && user.getPassword().equals(password)) {
				model.addAttribute("user", user);
				return "welcome";
			}
		}
		return "loginFrom";
	}
}
