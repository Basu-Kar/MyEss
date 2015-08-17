package com.ksoft.ees.login.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ksoft.ees.login.vo.LoginVO;

@Component
public class LoginValidator implements Validator{

	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public void validate(Object arg0, Errors errors) {
		LoginVO vo = (LoginVO)arg0;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "loginId", "login.loginId");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "login.password");
	}

}
