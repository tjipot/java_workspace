package org.fkit.controller;

import java.util.Date;

import org.fkit.domain.User;
import org.fkit.converter.DateEditor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	
	private static final Log logger = LogFactory.getLog(UserController.class);
	
	@RequestMapping(value="/{formName}")
	public String loginForm(@PathVariable String formName) {
		// 动态跳转页面;
		return formName;
	}
	
	/* 在控制器初始化时注册属性编辑器,
	 * WebDataBinder对象用于绑定请求消息和处理方法(DateEditor类);
	 * */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// 注册自定义编辑器,将传入的Date类型使用DateEditor类型进行转换;
		binder.registerCustomEditor(Date.class, new DateEditor());
	}
	
	// 只要是用@RequestMapping注解了,就会依据配置信息添加前缀和后缀信息,
	// 在最后返回"xxx.jsp"页面给服务器(容器);
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(@ModelAttribute User user, Model model) {
		logger.info(user);
		model.addAttribute("user", user);
		return "success";	
	}
}
