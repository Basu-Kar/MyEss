package com.ksoft.ees.home.prl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ksoft.ees.login.vo.LoginVO;

@Controller
public class HomeController {

	@RequestMapping(value="/home.do", method=RequestMethod.GET)
	public ModelAndView validateLogin(HttpServletRequest req,@ModelAttribute("loginVO")LoginVO loginVO, BindingResult result){
		if(!"Y".equals((String)req.getSession().getAttribute("loggedIn"))){
			return  new ModelAndView("redirect:login.do");
		}else{
			return  new ModelAndView("home/home");
		}
		
	}
}
