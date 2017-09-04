package org.fkit.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.fkit.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller	// 注册为一个Handler先;
public class User1Controller {
	
	private static final Log logger = LogFactory.getLog(User1Controller.class);
	
	@ModelAttribute	// 被@ModelAttribute修饰方法会先于login调用, userModel()用于接收从前台jsp页面传入的参数;
	public void userModel(String loginname, String password, Model model) {	// Model参数也是框架包装好的数据;
		logger.info("userModel");
		// 创建User对象, 存储jsp页面传入的参数;
		User user = new User();
		user.setLoginname(loginname);
		user.setPassword(password);
		// 将User对象添加到Model当中(一个Map);
		model.addAttribute("user", user);
	}
	
	@RequestMapping(value="/login1")
	public String login(Model model) {
		logger.info("login");
		// 从Model中取出之前存入到Model(Map)的数据;
		User user = (User) model.asMap().get("user");
		System.out.println(user);
		// 设置user对象的username属性;
		user.setUsername("Test");
		return "result1";
	}
}
