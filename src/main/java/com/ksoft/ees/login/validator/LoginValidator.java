package com.ksoft.ees.login.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		if((vo.getLoginId()==null)||(vo.getLoginId().equals(""))){
			errors.rejectValue("loginId", "error3");
	
		}
		else{
			if(vo.getLoginId().length()<4||vo.getLoginId().length()>30){
				errors.rejectValue("loginId", "error3","defult msg");
	
			}
			else if(!isValidEmail(vo.getLoginId())){
				errors.rejectValue("loginId", "reg.email.format");
			}
		}

	}
	private boolean isValidEmail(String email) {
		// TODO Auto-generated method stub
		Pattern p=Pattern.compile(EMAIL_PATTERN);
		Matcher m=p.matcher(email);
		return m.matches();
	}
	private static final String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";



}
