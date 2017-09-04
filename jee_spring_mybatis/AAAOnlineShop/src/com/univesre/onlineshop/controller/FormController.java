package com.univesre.onlineshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/** 动态页面跳转控制器 */
@Controller
public class FormController{

	@RequestMapping(value="/{formName}")	// 注意变量及用法;
	 public String loginForm(@PathVariable String formName){
		// 动态跳转页面;
		return formName;
	}
}
