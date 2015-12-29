package com.ksoft.ees.login.prl;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
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
import com.ksoft.ees.common.vo.RoleVO;
import com.ksoft.ees.common.vo.UserVO;
import com.ksoft.ees.login.validator.LoginValidator;
import com.ksoft.ees.login.vo.LoginVO;
import com.ksoft.ees.registration.service.LoginService;
import com.ksoft.ees.registration.service.RegistrationService;
import com.ksoft.ees.registration.validator.RegistrationValidator;
import com.ksoft.ees.registration.vo.RegistrationVO;

@Controller
public class LoginController {

	@Autowired
	private LoginValidator loginValidator;
	
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

	@RequestMapping(value="/login.do")
	public ModelAndView showLoginPage(@ModelAttribute("loginVO")LoginVO loginVO){
		return new ModelAndView("login");
	}
	
	@RequestMapping(value="/validateLogin.do", method=RequestMethod.POST)
	public ModelAndView validateLogin(HttpServletRequest req, @ModelAttribute("loginVO")LoginVO loginVO, BindingResult result){
		loginValidator.validate(loginVO, result);
		ModelAndView mv = null;
		if(result.hasErrors()){
			mv = new ModelAndView("login");
		}else{
			
			UserVO userVO=loginService.validateLogin(loginVO);
			if(userVO==null){
				result.rejectValue("loginId", "invalid.user");

				mv = new ModelAndView("login");

			}else {
				mv = new ModelAndView("redirect:/home.do");
				sessionHolder.putValue("loggedIn", "Y");
				sessionHolder.putValue("userVO", userVO);
				/*
				mv = new ModelAndView("home/home");
				System.out.println("Controller..............."+userVO.getRoleId());

				if(userVO.getRoleId()==1){
					List<UserVO> userlist=loginService.getPendingApprovalUserList();
					System.out.println("Controller..............."+userlist);

					mv.addObject("userlist",userlist);
					
				}else if(userVO.getRoleId()==2){
					//get projectlist
					mv = new ModelAndView("home/home");
					
				}
*/			}
			//System.out.println(sessionHolder);
			
			  //req.getSessiosn().setAttribute("loggedIn", "Y");
			//mv = new ModelAndView("redirect:/home.do");
		}
		return mv;
	}
	/*@RequestMapping(value="/home.do")
	public ModelAndView showHomePage(){
		System.out.println("................");
		return new ModelAndView("home/home");
	}*/
	@RequestMapping(value="/registration.do")
	public ModelAndView displayRegistration(@ModelAttribute("regVO")RegistrationVO regVO){
		ModelAndView mv=null;
		List<RoleVO> rolelist=commonService.getRoleList();
		mv=new ModelAndView("/signup");
		mv.addObject("rolelist",rolelist); 
		return mv;
	
	}
	@RequestMapping(value="/submitsignup.do")
	public ModelAndView submitSignUp(@ModelAttribute("regVO")RegistrationVO regVO,BindingResult result){
		ModelAndView mv=null;
		registrationValidator.validate(regVO,result);
		if(result.hasErrors()){
			
			List<RoleVO> rolelist=commonService.getRoleList();
			mv=new ModelAndView("/signup");
			mv.addObject("rolelist",rolelist); 
			return mv;
		}
		else{
			registrationService.submitSignUp(regVO);
			
			mv=new ModelAndView("login");
			mv.addObject("loginVO", new LoginVO());
			mv.addObject("msg","Your data has been successfully submitted.");
		}
		return mv;
		
	}
	@RequestMapping(value="/approveuser.do")
	public ModelAndView approveUser(HttpServletRequest request) throws Exception{
		ModelAndView mv=null;
		mv=new ModelAndView("/home/home");
		String str=request.getParameter("selecteduserId");
		loginService.approveUser(Integer.parseInt(str));
		List<UserVO> userlist=loginService.getPendingApprovalUserList();

		mv.addObject("userlist",userlist);
		return mv;
	
	}
	@RequestMapping(value="/declineuser.do")

	public ModelAndView declineUser(HttpServletRequest request) throws AddressException, NumberFormatException, MessagingException
	{
		ModelAndView mv=null;
		mv=new ModelAndView("/home/home");
		String str=request.getParameter("selecteduserId");
		loginService.declineUser(Integer.parseInt(str));
		List<UserVO> userlist=loginService.getPendingApprovalUserList();
		mv.addObject("userlist",userlist);
		return mv;


	}
}
