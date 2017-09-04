package org.fkit.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.fkit.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController{
	
	private static final Log logger = LogFactory.getLog(UserController.class);
	
	/* @RequestMapping应该是会自动根据springmvc的前缀和后缀的配置去补全路径信息的;
	 * */
	@RequestMapping(value="/{formName}")
	public String loginForm(@PathVariable String formName) {
		// 动态跳转页面;
		return formName;
	}
	 
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String register(@ModelAttribute User user, Model model) {
		logger.info(user);	// SpringMVC会自动对应post过来的表单中的信息, 将它们对应到user对象中;
		model.addAttribute("user", user);
		return "success";	// model数据应该交给"success.jsp"使用了;
	}
}
