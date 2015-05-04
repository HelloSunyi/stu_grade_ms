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
import com.sgms.bean.CourseGrade;
import com.sgms.bean.Student;
import com.sgms.common.DeleteResponse;
import com.sgms.common.ResultMapName;
import com.sgms.common.SelectCourseResponse;
import com.sgms.common.UpdateResponse;
import com.sgms.user.databaseOperate.StudentOperateWithDB;

@Controller
@RequestMapping("/student")
public class StudentController {
	final Logger logger = Logger.getLogger(IndexController.class);
	// 返回登录界面-get请求
	@RequestMapping(value="/index",method = RequestMethod.GET)
	public String getStudentIndexPage(HttpSession session,Model model){
		Student stu = new Student();
		stu.setId(session.getAttribute("username").toString());
		StudentOperateWithDB operate = new StudentOperateWithDB();
		List<CourseGrade> courseGradeList = new ArrayList<CourseGrade>();
		courseGradeList = operate.getCourseGrade(stu);
		model.addAttribute("courseGradeList", courseGradeList);
		return "student/studentIndex";
	}
	
	@RequestMapping(value="/basicInfo",method = RequestMethod.GET)
	public String getStudentBasicInfoPage(HttpSession session,Model model){
		Student stu = new Student();
		stu.setId(session.getAttribute("username").toString());
		StudentOperateWithDB operate = new StudentOperateWithDB();
		stu = operate.getStuBasicInfo(stu);
		model.addAttribute("student", stu);
		return "student/basicInfo";
	}
	
	@RequestMapping(value="/modifyBasicInfo",method = RequestMethod.POST)
	public @ResponseBody
	Map modifyBasicInfo(@RequestParam("username") String username,
						@RequestParam("classNo") String classNo,
						@RequestParam("major") String major,
						HttpSession session,Model model){
		Student stu = new Student();
		StudentOperateWithDB operate = new StudentOperateWithDB();
		stu.setId(session.getAttribute("username").toString());
		stu = operate.getStuBasicInfo(stu);
		if(!username.equals(""))stu.setName(username);
		if(!classNo.equals(""))stu.setClassNo(classNo);
		if(!major.equals(""))stu.setMajor(major);	
		Map<String,String> result = new HashMap<String,String>();
		if(operate.setStuBasicInfo(stu)){
			result.put(ResultMapName.ResultString,UpdateResponse.UpdateSuccessString);
			result.put(ResultMapName.ResultFlag,UpdateResponse.UpdateSuccessFlag);
		}
		else{
			result.put(ResultMapName.ResultString,UpdateResponse.UpdateFailString);
			result.put(ResultMapName.ResultFlag,UpdateResponse.UpdateFailFlag);
		}		
		return result;
	}
	
	@RequestMapping(value="/modifyPassword",method = RequestMethod.GET)
	public String getModifyPasswordPage(){			
		return "student/modifyPassword";
	}
	
	@RequestMapping(value="/doModifyPassword",method = RequestMethod.POST)
	public @ResponseBody
	Map doModifyPassword(@RequestParam("password") String password,
						HttpSession session,Model model){
		Student stu = new Student();
		StudentOperateWithDB operate = new StudentOperateWithDB();
		stu.setId(session.getAttribute("username").toString());
		stu.setPassword(password);
		Map<String,String> result = new HashMap<String,String>();
		if(operate.setStuPassword(stu)){
			result.put(ResultMapName.ResultString,UpdateResponse.UpdateSuccessString);
			result.put(ResultMapName.ResultFlag,UpdateResponse.UpdateSuccessFlag);
		}
		else{
			result.put(ResultMapName.ResultString,UpdateResponse.UpdateFailString);
			result.put(ResultMapName.ResultFlag,UpdateResponse.UpdateFailFlag);
		}		
		return result;
	}
	
	@RequestMapping(value="/deleteCourse",method = RequestMethod.POST)
	public @ResponseBody
	Map doSelectCourse(@RequestParam("idList[]") String[] idList,
						HttpSession session,Model model){
		Student stu = new Student();
		StudentOperateWithDB operate = new StudentOperateWithDB();
		stu.setId(session.getAttribute("username").toString());
		Map<String,String> result = new HashMap<String,String>();
		if(operate.deleteStuCourse(stu,idList)){
			result.put(ResultMapName.ResultString,DeleteResponse.DeleteSuccessString);
			result.put(ResultMapName.ResultFlag,DeleteResponse.DeleteSuccessFlag);
		}
		else{
			result.put(ResultMapName.ResultString,DeleteResponse.DeleteFailString);
			result.put(ResultMapName.ResultFlag,DeleteResponse.DeleteFailFlag);
		}		
		return result;
	}
	
	@RequestMapping(value="/selectCourse",method = RequestMethod.GET)
	public String getSelectClassPage(HttpSession session,Model model){
		Student stu = new Student();
		stu.setId(session.getAttribute("username").toString());
		StudentOperateWithDB operate = new StudentOperateWithDB();
		List<Course> courseList = new ArrayList<Course>();
		courseList = operate.getUnSelectCourse(stu);	
		model.addAttribute("courseList", courseList);
		return "student/selectCourse";
	}
	
	@RequestMapping(value="/doSelectCourse",method = RequestMethod.POST)
	public @ResponseBody
	Map doSelectClass(@RequestParam("idList[]") String[] idList,
						HttpSession session,Model model){
		Student stu = new Student();
		StudentOperateWithDB operate = new StudentOperateWithDB();
		stu.setId(session.getAttribute("username").toString());
		Map<String,String> result = new HashMap<String,String>();
		if(operate.selectStuCourse(stu, idList)){
			result.put(ResultMapName.ResultString,SelectCourseResponse.SelectSuccessString);
			result.put(ResultMapName.ResultFlag,SelectCourseResponse.SelectSuccessFlag);
		}
		else{
			result.put(ResultMapName.ResultString,SelectCourseResponse.SelectFailString);
			result.put(ResultMapName.ResultFlag,SelectCourseResponse.SelectFailFlag);
		}		
		return result;
	}
	
	
	
}
