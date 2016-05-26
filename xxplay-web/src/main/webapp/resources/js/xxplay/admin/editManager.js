$(function(){
	$("#saveForm").bootstrapValidator({
		message: 'This value is not valid',
		feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	userName: {
                message: 'The username is not valid',
                validators: {
                    notEmpty: {
                        message: '用户名不能为空'
                    },
                    stringLength: {
                        min: 6,
                        max: 15,
                        message: '用户名长度为6到15位'
                    }
                }
            },
            realName: {
                message: 'The realName is not valid',
                validators: {
                    notEmpty: {
                        message: '真实姓名不能为空'
                    }
                }
            },
            password: {
                message: 'The password is not valid',
                validators: {
                    notEmpty: {
                        message: '登录密码不能为空'
                    },
                    regexp: {
                    	regexp: /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$/,
                    	message: '登录密码必须是6-20位的字母和数字'
                    }
                }
            },
            rePassword: {
                message: 'The rePassword is not valid',
                validators: {
                    notEmpty: {
                        message: '确认登录密码不能为空'
                    },
                    identical:{
                    	field:'password',
                    	message:'确认登录密码与登录密码两者不一致，请重新输入'
                    }
                }
            },
        }
	}).on('success.form.bv', function(e) {
		e.preventDefault();
		var _url = "../admin/addManager";
		var _userName = $("#userName").val();
		var _realName = $("#realName").val();
		var _password = $("#password").val();
		var _rePassword = $("#rePassword").val();
		var _role = $("#role").val();
		
		//密码加密
		var key1 = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCp0wHYbg/NOPO3nzMD3dndwS0MccuMeXCHgVlGOoYyFwLdS24Im2e7YyhB0wrUsyYf0/nhzCzBK8ZC9eCWqd0aHbdgOQT6CuFQBMjbyGYvlVYU2ZP7kG9Ft6YV6oc9ambuO7nPZh+bvXH0zDKfi02prknrScAKC0XhadTHT3Al0QIDAQAB";
		_password = strEnc(_password,key1,null,null);
		_rePassword = strEnc(_rePassword,key1,null,null);
		var params = {"userName":_userName,
					  "realName":_realName,
					  "password":_password,
					  "rePassword" : _rePassword,
					  "roleId" : _role};
		ajaxSend(_url,params,addManagerSuccess);
    });
});

function addManagerSuccess(responseData){
	var resultFlag = responseData.resultFlag;
	if(!resultFlag){
		$("#errorTips").html(responseData.errorTips);
		$("#doSubmitBtn").removeAttr("disabled");
	}else{
		alert("新增管理员成功");
		parent.closeModal();
	}
}