<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/other/login.css" type="text/css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/bootstrap_css/bootstrap.min.css" type="text/css">
	<script src="<%=request.getContextPath()%>/resource/script/jquery-1.11.1.min.js"></script>
	<script src="<%=request.getContextPath()%>/resource/script/other/login.js"></script>
	<script src="<%=request.getContextPath()%>/resource/script/bootstrap_js/bootstrap.min.js"></script>
  	
  </head>
  
  <body>
  	<div id="mainbody">
  		<div class="container">
  			<h1 class="title">成绩管理系统</h1>
  			<div class="container-wrap">
  				<div class="main-header">
	  				<ul>
	  					<li class="login-tab"><a href="index/login">登录</a></li>
	  					<li class="register-tab"><a href="index/register">注册</a></li>
	  				</ul>
	  			</div>	
	  			<div class="mainbody-form">
	  				<div id="message"></div>
	  				<form class="form-horizontal" role="form" >	
	  					<div class="form-group">
	  						<i class="glyphicon glyphicon-user"></i>				   
						    <input id="username" name="username" type="text" class="form-control"  placeholder="用户名.."
						    data-toggle="tooltip" data-placement="top" data-original-title="正确格式为：管理员账号，字母大写" data-trigger="focus"/>
						</div>
						<div class="form-group">
							<i class="glyphicon glyphicon-lock"></i>	
						    <input id="password" type="password"  class="form-control" name="password" placeholder="密码.." 
						    data-toggle="tooltip" data-placement="top" data-original-title="请注意字母大小写" data-trigger="focus"/>
						</div>
						<div class="radio">
							<dl>
						        <dd class="selected" name="student"><span><b></b>学生</span></dd>
						        <dd name="teacher"><span><b></b>教师</span></dd>
						        <dd name="manager"><span><b></b>管理员</span></dd>
						    </dl>
						</div>
						
	  				</form>
	  				<button class="btn btn-success btn-lg login-btn">登录</button>
	  			</div>
  			</div>  		
  		</div>	
  		
  	</div>
  	
  </body>
</html>
