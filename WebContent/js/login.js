$(document).ready(function(){
	
	$(window).keydown(function(event){
		if(event.keyCode == 13){
			loginuser();
		}
	});
	
	$("#submit").click(function(){
		loginuser();
	});
});

//登陆方法
function loginuser(){
	
	var user = $("#loginuser").val();
	var pass = $("#loginpass").val();
	//去空格
	var loginuser = $.trim(user);
	var loginpass = $.trim(pass);
	//验证用户名，密码不能为空
	if(!lowerCase(loginuser)){
		art.dialog.tips('用户名为4位以上的字母或数字的组合', 2);
		return;
	}
	if(!lowerCase(loginpass)){
		art.dialog.tips('请输入密码', 2);
		return;
	}
	
	$.ajax({
		url : '/kindergarten/account/loginUser?ttid='+Math.random(),
		type : 'post',
		data : {
			loginuser:loginuser,
			loginpass:loginpass
		},
		success : function(data){
			var result = data.result;
			if(-1 == result){
				window.location = '/kindergarten/pages/index.jsp';
			}else{
				art.dialog.tips('用户名或密码错误', 2);
			}
		}
	});
}