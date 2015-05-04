<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/teacher/modifyPassword.css" type="text/css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/bootstrap_css/bootstrap.min.css" type="text/css">
	<script src="<%=request.getContextPath()%>/resource/script/jquery-1.11.1.min.js"></script>
	<script src="<%=request.getContextPath()%>/resource/script/teacher/modifyPassword.js"></script>
	<script src="<%=request.getContextPath()%>/resource/script/bootstrap_js/bootstrap.min.js"></script>
  </head>
  
  <body>
  	<!-- header 标签开始 -->
  	<div id="header">
  		<div class="container">
  			<h1>成绩管理系统<small>--教师端</small></h1>
  			<div class="dropdown">
  				<a class="dropdown-toggle" data-toggle="dropdown">
  					<i class="glyphicon glyphicon-user"></i>
  					<span class="username"><%=(String)session.getAttribute("username")%></span>
  					<span class="caret"></span>
  				</a>
  				<ul class="dropdown-menu">
  					<li><a href="teacher/basicInfo">基本信息</a></li>
  					<li><a href="teacher/modifyPassword">修改密码</a></li>
  					<li><a href="index.jsp">退出登录</a></li>
  				</ul>
  			</div>			
  		</div>
  	</div>
  	<!-- header 标签结束 -->
  	
  	<!-- mainbody 标签开始 -->
  	<div id="mainbody">
		<div class="mainbody-left">
			<ul class="list-group list-menu on">
				<i class="glyphicon glyphicon-chevron-right"></i>
				<li class="list-group-item tab"></li>
			</ul>
			<ul class="list-group list-content">
				<i class="glyphicon glyphicon-chevron-left"></i>
				<li class="list-group-item capsule"><a href="teacher/index">教师授课</a></li>
			</ul>	
		</div>
  			<div class="mainbody-right">
  				<div class="mainbody-right-top">
		  			<i class="glyphicon glyphicon-th-list"></i>
		  			<span class="basic-info">修改密码</span>
		  			<div class="divider"></div>
  				</div>
  				<div class="mainbody-right-middle">	
  					<form class="form-inline" role="form" >	
	  					<div class="form-group">
	  						<label>新密码：</label>			   
						    <input id="password1" name="password1" type="text" class="form-control"/>
						    <i class="glyphicon glyphicon-pencil"></i>	
						</div>
						<div class="form-group">
							<label>确认密码：</label>			   
						    <input id="password2" name="password2" type="text" class="form-control"/>
						    <i class="glyphicon glyphicon-pencil"></i>
						</div>
					</form>		
					<a class="btn btn-success btn-lg save-btn">保存修改</a>	
  				</div>
  			</div>
  			<div class="modal" id="mymodal">
			    <div class="modal-dialog">
			        <div class="modal-content">
			            <div class="modal-header">
			    			<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
							<h4 class="modal-title">修改密码结果</h4>
						</div>
						<div class="modal-body">
							<p></p>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						</div>
					</div><!-- /.modal-content -->
				</div><!-- /.modal-dialog -->
			</div><!-- /.modal -->	
  	</div>
  	<!-- mainbody 标签结束 -->
  	
  	<!-- footer 标签开始 -->
  	<div id="footer">
  	
  	</div>
  	<!-- footer 标签结束 -->
  </body>
</html>
