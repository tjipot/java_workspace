package org.fkit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller		// 注册为一个Controller;
public class HelloWorldController {
	
	@RequestMapping("/helloWorld")	// 注册请求处理函数;
	public String helloWorld(Model model) {
		model.addAttribute("message", "Hello World!");
		return "helloWorld";	
	}
}