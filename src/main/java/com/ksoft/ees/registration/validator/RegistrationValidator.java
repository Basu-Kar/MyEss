package com.ksoft.ees.registration.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ksoft.ees.registration.vo.RegistrationVO;

@Component
public class RegistrationValidator implements Validator{

	public boolean supports(Class<?> arg0) {
		return false;
	}

	public void validate(Object arg0, Errors arg1) {
		RegistrationVO regVO=(RegistrationVO)arg0;
	}

}
