package com.ksoft.ees.project.prl;


import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ksoft.ees.project.vo.PortfolioVO;

@Controller
public class ProjectController {

	@RequestMapping(value="/showProjectDetails.do", method=RequestMethod.POST)
	public ModelAndView showProjectDetails(@ModelAttribute("portfolioVO")PortfolioVO portfolioVO, BindingResult result){
	
		return new ModelAndView("/projects/projectDetails");
	
	}
	
	@RequestMapping(value="/addProject.do", method=RequestMethod.POST)
	public ModelAndView addProject(@ModelAttribute("portfolioVO")PortfolioVO portfolioVO, BindingResult result){
	
		return new ModelAndView("");
	
	}
	
	@RequestMapping(value="/editProject.do", method=RequestMethod.POST)
	public ModelAndView editProject(@ModelAttribute("portfolioVO")PortfolioVO portfolioVO, BindingResult result){
	
		return new ModelAndView("");
	
	}
	
	@RequestMapping(value="/deleteProject.do", method=RequestMethod.POST)
	public ModelAndView deleteProject(@ModelAttribute("portfolioVO")PortfolioVO portfolioVO, BindingResult result){
	
		return new ModelAndView("");
	
	}
	
	@RequestMapping(value="/deletePortFolio.do", method=RequestMethod.POST)
	public ModelAndView deletePortfolio(@ModelAttribute("portfolioVO")PortfolioVO portfolioVO, BindingResult result){
		
		return new ModelAndView("");
	
	}
	
	@RequestMapping(value="/updatePortfolio.do", method=RequestMethod.POST)
	public ModelAndView updatePortfolio(@ModelAttribute("portfolioVO")PortfolioVO portfolioVO, BindingResult result){
		
		return new ModelAndView("");
	
	}
}
