package com.ksoft.ees.login;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.ksoft.ees.login.prl.LoginController;
import com.ksoft.ees.login.vo.LoginVO;
import com.ksoft.ees.test.framework.MVCTest;


public class LoginControllerTest extends MVCTest{

	
	
    @Before
    public void setup() {
    	this.mockMvc = MockMvcBuilders.standaloneSetup(this.loginController).build();
    } 
	    
	@Autowired
	private LoginController loginController;
	
	
	@Test
	public void testValidateLogin() throws Exception {
		this.mockMvc.perform(get("/login.do")
				.requestAttr("loginVO", new LoginVO()))
				.andExpect(status().is(200))
				.andExpect(forwardedUrl("login"));
		
	}

}
