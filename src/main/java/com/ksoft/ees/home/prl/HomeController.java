package com.ksoft.ees.home.prl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ksoft.ees.common.service.CommonService;
import com.ksoft.ees.common.session.ISessionHolder;
import com.ksoft.ees.common.vo.UserVO;
import com.ksoft.ees.login.vo.LoginVO;
import com.ksoft.ees.project.vo.PortfolioVO;
import com.ksoft.ees.registration.service.LoginService;
import com.ksoft.ees.registration.service.RegistrationService;
import com.ksoft.ees.registration.validator.RegistrationValidator;

@Controller
public class HomeController {

	@Autowired
	private ISessionHolder<Object> sessionHolder;
	
	@Autowired 
	private CommonService commonService;
	
	@Autowired
	private RegistrationValidator registrationValidator;
	
	@Autowired
	private RegistrationService registrationService;
	
	@Autowired
	private LoginService loginService;
	
	
	
	@RequestMapping(value="/home.do", method=RequestMethod.GET)
	public ModelAndView validateLogin(HttpServletRequest req,@ModelAttribute("loginVO")LoginVO loginVO, BindingResult result){
		
		System.out.println(sessionHolder.getValue("loggedIn"));
		ModelAndView mv = null;
		//if(!"Y".equals((String)req.getSession().getAttribute("loggedIn"))){
		if(!"Y".equals(sessionHolder.getValue("loggedIn"))){
			mv=  new ModelAndView("redirect:login.do");
		}else{
			mv=  new ModelAndView("home/home");
			UserVO userVO=(UserVO)sessionHolder.getValue("userVO");
			System.out.println("Controller..............."+userVO.getRoleId());

			if(userVO.getRoleId()==1){
				List<UserVO> userlist=loginService.getPendingApprovalUserList();
				System.out.println("Controller..............."+userlist);

				mv.addObject("userlist",userlist);
				
			}else if(userVO.getRoleId()==2){
				//get projectlist
				mv = new ModelAndView("home/home");
				
			}


		}
		
		return mv;
	}
}
