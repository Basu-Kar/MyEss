package com.ksoft.ees.login.prl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ksoft.ees.login.validator.LoginValidator;
import com.ksoft.ees.login.vo.LoginVO;

@Controller
public class LoginController {

	@Autowired
	private LoginValidator loginValidator;
	
	@RequestMapping(value="/login.do")
	public ModelAndView showLoginPage(@ModelAttribute("loginVO")LoginVO loginVO){
		return new ModelAndView("login");
	}
	
	@RequestMapping(value="/validateLogin.do", method=RequestMethod.POST)
	public ModelAndView validateLogin(@ModelAttribute("loginVO")LoginVO loginVO, BindingResult result){
		loginValidator.validate(loginVO, result);
		ModelAndView mv = null;
		if(result.hasErrors()){
			mv = new ModelAndView("login");
		}else{
			mv = new ModelAndView("home/home");
		}
		return mv;
	}
	
	/*@RequestMapping(value="/home.do")
	public ModelAndView showHomePage(){
		System.out.println("................");
		return new ModelAndView("home/home");
	}*/
}
