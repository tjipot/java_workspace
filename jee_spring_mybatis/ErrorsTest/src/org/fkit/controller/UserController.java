package org.fkit.controller;

import org.fkit.domain.User;
import org.fkit.validator.UserValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.*;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

	@RequestMapping(value="/registerForm", method=RequestMethod.GET)
	public String registerForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);	// 将user对象添加到model中的"user"中, 供registerForm.jsp"使用";
		return "registerForm";
	}
	
	@InitBinder	// 何用?!
	public void initBinder(DataBinder binder) {
		binder.setValidator(new UserValidator());
	}
	
	// errors模块还不熟;
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(@Validated User user, Errors errors) {
		// 如果Errors对象有Field错误时, 重新跳回注册页面, 否则正常提交;
		if(errors.hasFieldErrors()){
			// 虽然return了"registerForm", 但此处的return不会更改地址栏的地址,
			// 因为服务器只是返回了registerForm的内容, 而html表单是"提交"了跳转的地址的;
			return "registerForm";
		}
		return "submit";
	}
}
