package com.ksoft.ees.login;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ksoft.ees.login.dao.LoginDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:ApplicationContext-Test.xml")
public class HomeControllerTest {

	@Autowired
	private LoginDAO loginDAO;
	@Test
	public void test() {
		System.out.println("-------------------------"+loginDAO.getTotalCountOfPendingUserStatus());
	}

}
