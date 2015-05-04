$(function(){
	var dds=$("#mainbody .radio dd");
    for(var i=0;i<dds.length;i++){           
        dds[i].onclick=function(){
            for(var j=0;j<dds.length;j++)dds[j].className="";
            this.className="selected";
        }                       
    }
    
    
    //表单提交
    $("#mainbody .mainbody-form .login-btn").click(function(){
		var identity = $("#mainbody .radio .selected").attr("name"); 
		var username = $("#username").val();
		var password1 = $("#password").val();
		var password2 = $("#password2").val();
		if(username == ""||password1 == ""||password2 == ""){
			$("#message").addClass("on");
			$("#message").html("用户名或密码不能为空！");
			$("#mainbody .container-wrap").css("height","560px");
			return;
		}
		if(password1 != password2){
			$("#message").addClass("on");
			$("#message").html("两次密码不相同，请重新输入！");
			$("#mainbody .container-wrap").css("height","560px");
			return;
		}
		
		$.ajax({
			type : "post",
			url : "index/doRegister",
			dataType : "json",
			data : {
				"username":username,
				"password":password1,
				"identity":identity
			},
			success : function(result) {
				var resultFlag = result["resultFlag"];
				var resultString = result["resultString"];
				if(resultFlag == "RS"){
					$("#mymodal .modal-body p").html(resultString);	
					$("#mymodal").modal();
				}
				else{
					$("#message").addClass("on");
					$("#message").html(resultString);
					$("#mainbody .container-wrap").css("height","560px");
				}				
			}
		});	
	});
    
    $("#mymodal .modal-footer .btn").click(function(){
    	var identity = $("#mainbody .radio .selected").attr("name");
    	setTomeout(function(){
    		window.location.href = identity + "/index";
    	},2000);    	
    });
});
        