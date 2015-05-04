package com.sgms.user.basicOperate;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.sgms.bean.SQL;
import com.sgms.common.LoginResponse;
import com.sgms.common.ResultMapName;

public class UserLogin {
	public Map<String,String> doLogin(String uid,String password,String identity){
		final Logger logger = Logger.getLogger(UserLogin.class);
		Map<String,String> resultMap=new HashMap<String,String>();
		SQL db = new SQL();
		String sql = "select password from "+ identity + " where id='" + uid + "'";
		ResultSet rs = db.executeQuery(sql);
		try{
			if(rs.next()){
				String pw = rs.getString("password");
				if(password.equals(pw)){			
					logger.info(LoginResponse.LoginSuccessString);
					resultMap.put(ResultMapName.ResultFlag, LoginResponse.LoginSuccessFlag);
					resultMap.put(ResultMapName.ResultString, LoginResponse.LoginSuccessString);				
				}
				else{
					logger.info(LoginResponse.PasswordFalseString);
					resultMap.put(ResultMapName.ResultFlag, LoginResponse.PasswordFalseFlag);
					resultMap.put(ResultMapName.ResultString, LoginResponse.PasswordFalseString);	
				}
			}
			else{
				logger.info(LoginResponse.UidNotFoundString);
				resultMap.put(ResultMapName.ResultFlag, LoginResponse.UidNotFoundFlag);
				resultMap.put(ResultMapName.ResultString, LoginResponse.UidNotFoundString);	
			}
		}
		catch(Exception e){
			logger.info(LoginResponse.ExceptionString);
			resultMap.put(ResultMapName.ResultFlag, LoginResponse.ExceptionFlag);
			resultMap.put(ResultMapName.ResultString, LoginResponse.ExceptionString);	
		}
		
		return resultMap;
	}
}
