package com.ksoft.ees.login;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;
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
