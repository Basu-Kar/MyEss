package com.ksoft.ees.registration.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ksoft.ees.registration.vo.RegistrationVO;

@Component
public class RegistrationValidator implements Validator{

	public boolean supports(Class<?> arg0) {
		return false;
	}

	public void validate(Object arg0, Errors errors) {
		RegistrationVO regVO=(RegistrationVO)arg0;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fName", "signup.fname");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lName", "signup.lname");
		if((regVO.getEmailId()==null)||(regVO.getEmailId().equals(""))){
			errors.rejectValue("emailId", "error3");
	
		}
		else{
			if(regVO.getEmailId().length()<4||regVO.getEmailId().length()>30){
				errors.rejectValue("emailId", "error3","defult msg");
	
			}
			else if(!isValidEmail(regVO.getEmailId())){
				errors.rejectValue("emailId", "reg.email.format");
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
