package org.fkit.validator;

import org.fkit.domain.User;
import org.springframework.validation.*;

public class UserValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		// 验证usrename, sex和age是否为null;
		ValidationUtils.rejectIfEmpty(errors, "username", null, "Username Can't Be Empty!");
		ValidationUtils.rejectIfEmpty(errors, "sex", null, "Sex Can't Be Empty!");
		ValidationUtils.rejectIfEmpty(errors, "age", null, "Age Can't Be Empty!");	
	}
}
