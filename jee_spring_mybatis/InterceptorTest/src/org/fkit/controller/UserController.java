package org.fkit.controller;

import javax.servlet.http.HttpSession;
import org.fkit.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/* 处理用户请求的控制器@Controller */
@Controller
public class UserController {

	/* 浏览器/login请求, 由@RequestMapping封装了参数中的ModelAndView, HttpSession */
	@RequestMapping(value="/login")
	public ModelAndView login(String loginname, String password, ModelAndView mv, HttpSession session) {
		// 模拟数据库根据登录名和密码查找用户, 判断用户登录;
		if(loginname != null && loginname.equals("fkit") && password!= null && password.equals("123456")){
			// 模拟用户创建;
			User user = new User();
			user.setLoginname(loginname);
			user.setPassword(password);
			user.setUsername("管理员");
			session.setAttribute("user", user);	// 登录成功, 将user对象设置到HttpSession作用范围域;
			mv.setViewName("redirect:main");	// 转发到main请求: 就是显示书目的main.jsp;
		}else{
			// 验证失败, 设置失败提示信息, 并跳转到登录页面;
			mv.addObject("message", "登录名或密码错误, 请重新输入!");
			mv.setViewName("loginForm");	// 此处逻辑: 验证失败, 由login进来, 由loginForm返回;
		}
		return mv;
	}
}
