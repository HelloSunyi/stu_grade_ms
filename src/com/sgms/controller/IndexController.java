package com.sgms.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sgms.common.LoginResponse;
import com.sgms.user.basicOperate.UserLogin;
import com.sgms.user.basicOperate.UserRegister;

@Controller
@RequestMapping("/index")
public class IndexController {
	
	final Logger logger = Logger.getLogger(IndexController.class);
	// 返回登录界面-get请求
	@RequestMapping(value="/login",method = RequestMethod.GET)
	public String getAboutPage(){
		return "other/login";
	}
	//用户登录-post请求
	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	public @ResponseBody
	Map userLogin(@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam("identity") String identity,HttpSession session){	
		Map<String,String> result = new HashMap<String,String>();		
		UserLogin operate = new UserLogin();
		result = operate.doLogin(username,password,identity);
		session.setAttribute("username", username);
		return result;
	}
	//返回用户注册界面--get请求
	@RequestMapping(value="/register",method = RequestMethod.GET)
	String getRegisterPage(){
		return "other/register";
	}
	//新用户注册--post请求
	@RequestMapping(value = "/doRegister", method = RequestMethod.POST)
	public @ResponseBody
	Map userRegister(@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam("identity") String identity,
			HttpSession session){		
		Map<String,String> result = new HashMap<String,String>();		
		UserRegister operate = new UserRegister();
		result = operate.doRegister(username,password,identity);
		session.setAttribute("username", username);
		return result;
	}
	@RequestMapping(value="/success",method = RequestMethod.GET)
	public String getSuccessPage(){
		return "other/success";
	}
}
