package com.ksoft.ees.template.prl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DataBaseTemplateController {

	@RequestMapping(value="/showDatabaseTemplate.do")
	public ModelAndView showDBTemplate(){
		return new ModelAndView("/template/database");
	}
}
