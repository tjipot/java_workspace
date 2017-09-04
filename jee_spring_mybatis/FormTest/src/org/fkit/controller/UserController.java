package org.fkit.controller;

import org.fkit.domain.User;
//import org.springframework.*;	// 偷懒法: 全部引入;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	
	@RequestMapping(value="/registerForm", method=RequestMethod.GET)
	public String registerForm(Model model) {
		User user = new User("Jacky","Male", 28);
		// 将user对象整个添加到model中去(取user对象的属性值),
		// 因为springmvc默认取得的model的属性是'command';
		model.addAttribute("command", user);
		return "registerForm";
	}
}
