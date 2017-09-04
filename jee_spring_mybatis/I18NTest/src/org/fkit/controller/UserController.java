package org.fkit.controller;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.fkit.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.RequestContext;

@Controller
public class UserController {
	
	private static final Log logger = LogFactory.getLog(UserController.class);
	
	@RequestMapping(value="/{formName}")
	public String loginForm(@PathVariable String formName, Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return formName;
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@ModelAttribute @Validated User user, Model model, HttpServletRequest request) {
		
		logger.info(user);
		// 登录名: fkit, 密码: 123456;
		if(user.getLoginname() != null && user.getLoginname().equals("fkit")
				&& user.getPassword() != null && user.getPassword().equals("123456")) {
			// 从后台代码获取国际化信息username;
			RequestContext requestContext = new RequestContext(request);
			String username = requestContext.getMessage("username");
			// 将获取的username信息设置到User的对象并设置到Model中;
			user.setUsername(username);
			model.addAttribute("user", user);
			return "success";
		}
		return "error";
	}
}
