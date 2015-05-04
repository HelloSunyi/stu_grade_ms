$(function(){
	//下拉菜单
	$("#header .dropdown-toggle").mouseenter(function(){
		$("#header .dropdown").css("background-color","#232931");
		$("#header .dropdown").addClass("open");	
	});
	$("#header .dropdown-menu").mouseleave(function(){
		$("#header .dropdown").css("background-color","#39424E");
		$("#header .dropdown").removeClass("open");
	});
	
	//侧边栏
	$("#mainbody .mainbody-left").mouseenter(function(){
		$("#mainbody .mainbody-left .list-menu").removeClass("on");
		$("#mainbody .mainbody-left .list-content").addClass("on");
	});
	$("#mainbody .mainbody-left").mouseleave(function(){
		$("#mainbody .mainbody-left .list-content").removeClass("on");
		$("#mainbody .mainbody-left .list-menu").addClass("on");
	});
	
	//表单提交
	$("#mainbody .mainbody-right-middle .save-btn").click(function(){	
		var password1 = $("#password1").val();
		var password2 = $("#password2").val();
		if(password1 == ""||password2 == ""){
			$("#mymodal .modal-body p").html("密码不能为空，请重新输入！");	
			$("#mymodal").modal();
			return;
		}
		if(password1 != password2){
			$("#mymodal .modal-body p").html("两次密码输入不相同，请重新输入！");	
			$("#mymodal").modal();
			return;
		}
		$.ajax({
			type : "post",
			url : "teacher/doModifyPassword",
			dataType : "json",
			data : {
				"password":password1		
			},
			success : function(result) {					
				//window.location.href="student/basicInfo";
				$("#mymodal .modal-body p").html(result["resultString"]);	
				$("#mymodal").modal();
			}
		}); 	
	});
});



