package com.sgms.user.operate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.sgms.bean.SQL;
import com.sgms.bean.Student;
import com.sgms.bean.Teacher;
import com.sgms.common.LoginResponse;
import com.sgms.common.RegisterResponse;
import com.sgms.common.ResultMapName;
import com.sgms.common.UserIdentity;
import com.sgms.database.student.StudentOperateWithDB;
import com.sgms.database.student.TeacherOperateWithDB;

public class UserRegister {
	public Map<String,String> doRegister(String id, String password, String identity){
		final Logger logger = Logger.getLogger(UserLogin.class);
		Map<String,String> resultMap = new HashMap<String, String>();	
		if(identity.equals(UserIdentity.Student)){
			Student stu = new Student();
			stu.setId(id);
			stu.setPassword(password);	
			StudentOperateWithDB studentOperate = new StudentOperateWithDB();
			if(studentOperate.hasRegister(stu)){
				resultMap.put(ResultMapName.ResultString, RegisterResponse.UidExistString);
				resultMap.put(ResultMapName.ResultFlag, RegisterResponse.UidExistFlag);
			}
			else{
				if(studentOperate.addStudent(stu)){
					resultMap.put(ResultMapName.ResultString, RegisterResponse.RegisterSuccessString);
					resultMap.put(ResultMapName.ResultFlag, RegisterResponse.RegisterSuccessFlag);
				}
				else {
					resultMap.put(ResultMapName.ResultString, RegisterResponse.RegisterExceptionString);
					resultMap.put(ResultMapName.ResultFlag, RegisterResponse.RegisterExceptionFlag);
				}
			}
		}//if
		else if(identity.equals(UserIdentity.Teacher)){
			Teacher teacher = new Teacher();
			teacher.setId(id);
			teacher.setPassword(password);
			TeacherOperateWithDB teacherOperate = new TeacherOperateWithDB();
			if(teacherOperate.hasRegister(teacher)){
				resultMap.put(ResultMapName.ResultString, RegisterResponse.UidExistString);
				resultMap.put(ResultMapName.ResultFlag, RegisterResponse.UidExistFlag);
			}
			else{
				if(teacherOperate.addTeacher(teacher)){
					resultMap.put(ResultMapName.ResultString, RegisterResponse.RegisterSuccessString);
					resultMap.put(ResultMapName.ResultFlag, RegisterResponse.RegisterSuccessFlag);
				}
				else {
					resultMap.put(ResultMapName.ResultString, RegisterResponse.RegisterExceptionString);
					resultMap.put(ResultMapName.ResultFlag, RegisterResponse.RegisterExceptionFlag);
				}
			}
		}//if
			
		return resultMap;
	}
}
