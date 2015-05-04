<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>首页</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/other/index.css" type="text/css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/bootstrap_css/bootstrap.min.css" type="text/css">
	<script src="<%=request.getContextPath()%>/resource/script/jquery-1.11.1.min.js"></script>
	<script src="<%=request.getContextPath()%>/resource/script/other/index.js"></script>
	<script src="<%=request.getContextPath()%>/resource/script/bootstrap_js/bootstrap.min.js"></script>
  </head>
  
  <body>
  	<!--  顶部导航区  -->
  	<div class="navbar" id="nav">
  		<div class="container">
  			<div class="navbar-header navbar-brand">成绩管理系统</div>
  			<ul class="nav navbar-nav">
  				<li  class="navbar-link"><a href="index.jsp">首页</a></li>
  				<li><a href="http://www.buaa.edu.cn/">学校主页</a></li>
  				<li class="dropdown">
  					<a class="dropdown-toggle" data-toggle="dropdown" style="background-color:#39424E">
  						学院主页<span class="caret"></span>
  					</a>
  					<ul class="dropdown-menu">
  						<li><a href="http://scse.buaa.edu.cn/buaa-css-web/initAction.action">计算机学院</a></li>
  						<li><a href="http://www.beihangsoft.cn/BuaaPublic/html/index.html">软件学院</a></li>
  						<li><a href="http://flying.buaa.edu.cn/">飞行学院</a></li>
  						<li><a href="http://www.hss.buaa.edu.cn/">人文学院</a></li>
  					</ul>
  				</li>
  			</ul>
  			<div class="nav-right">
	  			<a href="index/login" class="btn btn-lg btn-login">登录</a>
	  			<a href="index/register" class="btn btn-lg btn-register">注册</a>
  			</div>
  		</div>
  	</div>
	<!-- 顶部导航区结束 -->
	
	<!-- 中间内容区 -->
	<div id="mainbody">
		<ul class="img-carousel">		
			<li class="on"><img src="resource/img/other/index/img-carousel1.jpg"/></li>
			<li><img src="resource/img/other/index/img-carousel2.jpg"/></li>
			<li><img src="resource/img/other/index/img-carousel3.jpg"/></li>
		</ul>
		
		<div class="school-moto">
			<span class="line line_top"></span>
	        <span class="line line_right"></span>
	        <span class="line line_bottom"></span>
	        <span class="line line_left"></span>
			<p>德才兼备</p><p>知行合一</p>
		</div>
	</div>
	<!-- 中间内容区结束 -->
	
	<!-- 底部版权区 -->
	<div id="footer">
		<div class="container"><p>@2015sunyi</p></div>
	</div>
	<!-- 底部版权区结束 -->
	
  </body>
  
</html>
