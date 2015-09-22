package com.ksoft.ees.home.prl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ksoft.ees.common.session.ISessionHolder;
import com.ksoft.ees.login.vo.LoginVO;
import com.ksoft.ees.project.vo.PortfolioVO;

@Controller
public class HomeController {

	@Autowired
	private ISessionHolder<String> sessionHolder;
	
	@RequestMapping(value="/home.do", method=RequestMethod.GET)
	public ModelAndView validateLogin(HttpServletRequest req,@ModelAttribute("loginVO")LoginVO loginVO, BindingResult result){
		
		System.out.println(sessionHolder.getValue("loggedIn"));
		ModelAndView mv = null;
		//if(!"Y".equals((String)req.getSession().getAttribute("loggedIn"))){
		if(!"Y".equals(sessionHolder.getValue("loggedIn"))){
			mv=  new ModelAndView("redirect:login.do");
		}else{
			mv=  new ModelAndView("home/home");
			mv.addObject("portfolioVO", new PortfolioVO());
		}
		
		return mv;
	}
}
