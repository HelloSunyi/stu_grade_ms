package com.sgms.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sgms.bean.Course;
import com.sgms.bean.Teacher;
import com.sgms.common.ResultMapName;
import com.sgms.common.UpdateResponse;
import com.sgms.database.student.TeacherOperateWithDB;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
	final Logger logger = Logger.getLogger(IndexController.class);
	// 返回登录界面-get请求
	@RequestMapping(value="/index",method = RequestMethod.GET)
	public String getStudentIndexPage(HttpSession session,Model model){
		Teacher teacher = new Teacher();
		teacher.setId(session.getAttribute("username").toString());
		TeacherOperateWithDB operate = new TeacherOperateWithDB();
		List<Course> courseList = new ArrayList<Course>();
		courseList = operate.getAllCourse(teacher);
		model.addAttribute("courseList", courseList);
		return "teacher/teacherIndex";
	}
	
	@RequestMapping(value="/basicInfo",method = RequestMethod.GET)
	public String getTeacherBasicInfoPage(HttpSession session,Model model){
		Teacher teacher = new Teacher();
		teacher.setId(session.getAttribute("username").toString());
		TeacherOperateWithDB operate = new TeacherOperateWithDB();
		teacher = operate.getTeacherBasicInfo(teacher);
		model.addAttribute("teacher", teacher);
		return "teacher/basicInfo";
	}
	
	@RequestMapping(value="/modifyBasicInfo",method = RequestMethod.POST)
	public @ResponseBody
	Map modifyBasicInfo(@RequestParam("username") String username,
						@RequestParam("title") String title,
						HttpSession session,Model model){
		Teacher teacher = new Teacher();
		TeacherOperateWithDB operate = new TeacherOperateWithDB();
		teacher.setId(session.getAttribute("username").toString());
		teacher = operate.getTeacherBasicInfo(teacher);
		if(!username.equals(""))teacher.setName(username);
		if(!title.equals(""))teacher.setTitle(title);
		Map<String,String> result = new HashMap<String,String>();
		if(operate.setTeacherBasicInfo(teacher)){
			result.put(ResultMapName.ResultString,UpdateResponse.UpdateSuccessString);
			result.put(ResultMapName.ResultFlag,UpdateResponse.UpdateSuccessFlag);
		}
		else{
			result.put(ResultMapName.ResultString,UpdateResponse.UpdateFailString);
			result.put(ResultMapName.ResultFlag,UpdateResponse.UpdateFailFlag);
		}		
		return result;
	}
}
