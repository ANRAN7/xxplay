$(function(){
	//选定角色
	selectedSelected("role",$("#roleId").val());
	$("#saveForm").bootstrapValidator({
		message: 'This value is not valid',
		feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            realName: {
                message: 'The realName is not valid',
                validators: {
                    notEmpty: {
                        message: '真实姓名不能为空'
                    }
                }
            }
        }
	}).on('success.form.bv', function(e) {
		e.preventDefault();
		var _url = "../admin/updateManager";
		var _realName = $("#realName").val();
		var _role = $("#role").val();
		var _id = $("#adminId").val();
		
		var params = {"realName":_realName,
					  "roleId" : _role,
					  "id":_id};
		ajaxSend(_url,params,updateManagerSuccess);
    });
});

function updateManagerSuccess(responseData){
	var result = responseData.result;
	if(!result){
		$("#errorTips").html(responseData.errorTips);
		$("#doSubmitBtn").removeAttr("disabled");
	}else{
		alert("修改管理员成功");
		parent.closeModal();
	}
}