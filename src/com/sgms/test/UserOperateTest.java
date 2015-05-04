package com.sgms.test;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sgms.user.basicOperate.UserLogin;
import com.sgms.user.basicOperate.UserRegister;



public class UserOperateTest {
	
	//@Test
	public void testUserLogin(){
		UserLogin ul = new UserLogin();
		String username = "001";
		String password = "1";
		String identity = "student";
		Map<String,String> result = ul.doLogin(username, password, identity);
		System.out.println("result is" + result.get("resultString"));
	}
	@Test
	public void testUserRegister(){
		UserRegister ur = new UserRegister();
		String username = "008";
		String password = "8";
		String identity = "student";
		Map<String,String> result = ur.doRegister(username, password, identity);
		System.out.println("result is" + result.get("resultString"));
	}
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
}
