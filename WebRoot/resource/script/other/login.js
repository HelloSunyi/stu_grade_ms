$(function(){
	
	//单选款动态效果
	var dds=$("#mainbody .radio dd");
    for(var i=0;i<dds.length;i++){           
        dds[i].onclick=function(){
            for(var j=0;j<dds.length;j++)dds[j].className="";
            this.className="selected";
        }                       
    }
    
    //表单提交
    $("#mainbody .mainbody-form .login-btn").click(function(){
    	var username = $("#username").val();
    	var password = $("#password").val();
    	var identity = $("#mainbody .radio .selected").attr("name");  
    	if(username == ""||password == ""){
			$("#message").addClass("on");
			$("#message").html("用户名或密码不能为空！");
			$("#mainbody .container-wrap").css("height","500px");
			return;
		}	 		
		$.ajax({
			type : "post",
			url : "index/doLogin",
			dataType : "json",
			data : {
				"username":username,
				"password":password,
				"identity":identity
			},
			success : function(result) {
				var resultFlag = result["resultFlag"];
				var resultString = result["resultString"];
				if(resultFlag!="LS"){
					$("#message").addClass("on");
					$("#message").html(resultString);
					$("#mainbody .container-wrap").css("height","500px");
				}
				else{
					window.location.href = identity + "/index";
				}				
			}
		}); 	
	});
    
    
    
});
        