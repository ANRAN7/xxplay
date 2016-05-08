$(function () {
	/**
	 * 上传游戏图例列表
	 */
	$("#gamePicList").fileupload({
        url: '../gameManager/uploadGamePicList',
        acceptFileTypes:  /(\.|\/)(gif|jpe?g|png)$/
    });
	
	$("#apkFileForm").fileupload({
        url: '../gameManager/uploadAppPackAndRead',
        acceptFileTypes:  /(\.|\/)(apk)$/,
        dataType: 'json',
        done:function(e,data){
        	$("#packInfoForm #packUrl").val(data.result.packInfo.packUrl);
        	$("#packInfoForm #packageName").val(data.result.packInfo.packageName);
        	$("#packInfoForm #verCode").val(data.result.packInfo.verCode);
        	$("#packInfoForm #verName").val(data.result.packInfo.verName);
        	$("#packInfoForm #packMd5").val(data.result.packInfo.packMd5);
        	$("#packInfoForm #signCode").val(data.result.packInfo.signCode);
        	$("#packInfoForm #packSize").val(data.result.packInfo.packSize);
        	$("#packInfoForm #iconPicurl").val(data.result.packInfo.iconPicurl);
        	$("#packInfoForm #showPackIcon").attr("src",".." + data.result.packInfo.iconTempUrl);
        }
    });
	
	
	//启动定时器实时计算高度
	setInterval("setPageSize()",1000);
	
	$("#gameInfoForm").bootstrapValidator({
		feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	appName: {
                validators: {
                    notEmpty: {
                        message: '应用名称不能为空'
                    }
                }
            },
            showName: {
                validators: {
                    notEmpty: {
                        message: '显示名称不能为空'
                    }
                }
            },
            searchKeys: {
                validators: {
                    notEmpty: {
                        message: '关键词不能为空'
                    }
                }
            },
            appTab: {
                validators: {
                	 notEmpty:{
                        message: '请选择应用标签'
                    }
                }
            },
            appdesc: {
                validators: {
                    notEmpty: {
                        message: '游戏说明不能为空'
                    }
                }
            }
        }
	}).on('success.form.bv', function(e) {
		e.preventDefault();
		var params = {"appName":$("#appName").val(),
					  "showName":$("#showName").val(),
					  "searchKeys":$("#searchKeys").val(),
					  "appTab":getCheckboxValue("appTab"),
					  "categoryId":$("#categoryId").val(),
					  "isOnlie":getRadioValue("isOnlie"),
					  "appdesc":$("#appdesc").val()};
		ajaxSend("../gameManager/saveGameInfoStep1",params,saveGameInfoSuccess);
    });
	
	$("#packInfoForm").bootstrapValidator({
		feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        }
    });
	
	$("#gameOtherInfoForm").bootstrapValidator({
		feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	compDesc: {
                validators: {
                    notEmpty: {
                        message: '适用性说明不能为空'
                    }
                }
            },
            updateDesc: {
                validators: {
                    notEmpty: {
                        message: '更新说明不能为空'
                    }
                }
            },
            evilLevel: {
                validators: {
                    notEmpty: {
                        message: '黄暴等级不能为空'
                    }
                }
            }
        }
	}).on('success.form.bv', function(e) {
		e.preventDefault();
		var params = {"compDesc":$("#compDesc").val(),
					  "updateDesc":$("updateDesc").val(),
					  "evilLevel":$("#evilLevel").val(),
					  "remarks":getCheckboxValue("remarks"),
					  "recommFlag":$("#recommFlag").val(),
					  "recommLevel":getRadioValue("recommLevel"),
					  "recommWord":$("#recommWord").val()};
		ajaxSend("../gameManager/saveGameInfoStep3",params,saveGameInfoSuccess);
	});
	
    $('#rootwizard-custom-circle').bootstrapWizard({
        onTabShow: function(tab, navigation, index) {
            var $total = navigation.find('li').length;
            var $current = index+1;
            var $percent = ($current/$total) * 100;
            $('#rootwizard-custom-circle').find('.bar').css({width:$percent+'%'});
        },
        'onNext': function(tab, navigation, index) {
            var $id = tab.find("a").attr("href");
            $($id + " form.gameForm").submit();
            var _valid = $($id + " form.gameForm").data('bootstrapValidator').isValid();
            if(!_valid){
            	parent.sizeChange();
            	$("#errorTips").html("录入的信息有误，请重新输入");
            }else{
            	parent.toTop();
            }
            return _valid;
        },
        'onTabClick': function(tab, navigation, index) {
        	var $id = tab.find("a").attr("href");
            $($id + " form.gameForm").submit();
            var _valid = $($id + " form.gameForm").data('bootstrapValidator').isValid();
            if(!_valid){
            	parent.sizeChange();
            	$("#errorTips").html("录入的信息有误，请重新输入");
            }else{
            	parent.toTop();
            }
            return _valid;
        },
        'tabClass': 'bwizard-steps-o','nextSelector': '.button-next', 'previousSelector': '.button-previous'
    });

});

function setPageSize(){
	parent.sizeChange();
}

function saveGameInfoSuccess(responseData){
	
}

