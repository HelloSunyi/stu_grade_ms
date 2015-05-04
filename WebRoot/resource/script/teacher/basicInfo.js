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
		$.ajax({
			type : "post",
			url : "teacher/modifyBasicInfo",
			dataType : "json",
			data : {
				"username":$("#username").val(),
				"title":$("#classNo").val(),
			},
			success : function(result) {					
				//window.location.href="student/basicInfo";
				$("#mymodal .modal-body p").html(result["resultString"]);	
				$("#mymodal").modal();
			}
		}); 	
	});
	
	//input focus:
	$("#mainbody .form-group input").focus(function(){
		$(this).css("color","gray");
	});
	$("#mainbody .form-group input").blur(function(){
		$(this).css("color","black");
	});
	$("#mainbody .form-group input").bind("input propertychange",function() { 
		$(this).css("color","black");
	}); 
});



