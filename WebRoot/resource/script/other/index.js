$(function(){
	
	//nav中添加划过时，下拉菜单显示功能
	$("#nav .dropdown-toggle").mouseenter(function(){
		$("#nav .dropdown").addClass("open");
	});
	
	$("#nav .dropdown-menu").mouseleave(function(){
		$("#nav .dropdown").removeClass("open");
	});
	//背景图片定时器
	setInterval(changeImg,3000);
	
	
	//Account信息动态改变
	/*
	$("#login-tab li a").click(function(){
		var accountInfo = $(this).html();
		//$(this).css("background-color","#000000");
		$("#mainbody .account-info").html(accountInfo);
	});
	*/
	//触发提示信息框
	//$('[data-toggle="tooltip"]').tooltip();
	/*
	$("#mainbody .form-group input").focus(function(){
		$(this).next().show();
	});
	$("#mainbody .form-group input").blur(function(){
		$(this).next().hide();
	});
	*/
	
	//提交按钮
	/*
	$("#mainbody .tab-pane button").click(function(){
		//alert("hello");
		var formName = $(this).parent().attr("id");
		var pos = formName.indexOf("-");
		var type = formName.substring(0,pos);	
		var data = $("#"+formName).serialize();
		$.ajax({
	           url:type+"/login",
	           type:"POST",
	           data:data,
	           success:function(data,status){
                
	           }
	    });
	    
	});
	*/
});

//背景图片定时器
function changeImg(){
	var imgLis = $("#mainbody .img-carousel li");
	var onNum;
	for(var i = 0; i < imgLis.length; i++){
		if(imgLis[i].className == "on"){
			onNum = i;
			break;
		}
	}
	imgLis[onNum].className = "";
	if(onNum < imgLis.length - 1)onNum++;
	else onNum = 0;
	imgLis[onNum].className = "on";
}


