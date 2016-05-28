$(function(){
	$("#loginBtn").click(function(){
		var userName = $("#userName").val();
		var password = $("#password").val();
		if(userName == null || userName == ""){
			showErrorsAndInput("errorTips","用户名不能为空","userName");
			return;
		}else{
			showRightsInput("userName");
		}
		if(password == null || password == ""){
			showErrorsAndInput("errorTips","登录密码不能为空","password");
			return;
		}else{
			showRightsInput("password");
		}
		var key1 = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCp0wHYbg/NOPO3nzMD3dndwS0MccuMeXCHgVlGOoYyFwLdS24Im2e7YyhB0wrUsyYf0/nhzCzBK8ZC9eCWqd0aHbdgOQT6CuFQBMjbyGYvlVYU2ZP7kG9Ft6YV6oc9ambuO7nPZh+bvXH0zDKfi02prknrScAKC0XhadTHT3Al0QIDAQAB";
		password = strEnc(password,key1,null,null);
		
		//验证用户名、密码(增强用户体验，先用ajax验证，正确再次发送表单验证跳转)
		var params = {"userName":userName,"password":password};
		
		ajaxSend("../login/checkAdmin",params,login);
	});
});
function login(responseData){
	if(responseData.result){
		loginSubmit();
	}else{
		var error = responseData.error;
		if(error.indexOf("用户名")){
			showErrorsAndInput("errorTips",error,"userName");
		}else{
			showErrorsAndInput("errorTips",error,"password");
		}
	}
}

function loginSubmit(){
	$("#user_userName").val($("#userName").val());
	$("#user_password").val($("#password").val());
	$("#loginForm").submit();
}