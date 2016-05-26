$(function(){
	/*
	$(document).ready(function() {
		//禁用鼠标右击
		$(document).bind("contextmenu", function(e) {
			return false;
		});
		
		//禁用F5刷新
		$(document).bind("keydown", function(e) {
			e = window.event || e;
			//禁用F5刷新
			if (e.keyCode == 116) {
				e.keyCode = 0;
				return false;
			}
			
			//禁用Alt+ 方向键
			if ((event.altKey)&&((event.keyCode==37)||(event.keyCode==39))){
	               event.returnValue=false; 
	               return false;
	        }
		}); 
	}); 
	*/
});

/**
* 检验字符串是否为空
* @param {String} 字符串
* @return {bool} 是否为空
*/
function isEmpty(input){
	if( input==null ||  trim(input).length == 0 || input == 'null')
		return true;
	else
		return false;
}

/**
 * 改变页面大小
 */
function sizeChange() {
	var ifm = document.getElementById("mainFrame");
	var subWeb = document.frames ? document.frames["mainFrame"].document :
	ifm.contentDocument;
	if (ifm != null && subWeb != null) {
		var ifHeight = subWeb.body.scrollHeight;
		if (ifHeight < 5) {
			ifHeight = 500;
		}
		ifm.height = ifHeight;
	}
}

/**
 * 回到顶部
 */
function toTop(){
	$("html, body").animate({scrollTop:0}, 'fast');
}

/**
 * 将json格式的字符串解析为json对象
 * @param str
 */
function toJson(str){
	return  eval('(' + str + ')');
}

/**
 * 获取下拉框的值
 * @param selectId
 * @returns
 */
function getSelectValue(selectId){
	return ("#"+selectId).find("option:selected").val();
}

/**
 * 选定select
 * @param selectId
 * @param selectValue
 */
function selectedSelected(selectId,selectValue){
	var _option = $("#" + selectId).find("option");
	for( var i = 0 ; i < _option.length ; i++){
		if(selectValue == _option.eq(i).val()){
			_option.eq(i).attr("selected","selected");
			break;
		}
	}
}

/**
 * 获取checkBox的值,多值用“,”拼接
 */
function getCheckboxValue(checkboxName){
	var value = "";
	$("input[name='"+checkboxName+"']:checked").each(function(){
		value = value + $(this).val() + ",";
	});
	
	if(value.length >= 2){
		value = value.substring(0,value.length - 1);
	}
	return value;
}

/**
 * 获取radio的值
 * @param radioName
 * @returns
 */
function getRadioValue(radioName){
	return $("input[name='"+radioName+"']:checked").val();
}

/**
* 检查字符串是否为合法的金额
* @param {String} 字符串
* @return {bool} 是否为合法金额
*/
function isMoney(s) {
	var isMoney = RegExp(/^[0-9]{0,12}\.{0,1}[0-9]{0,2}$/);
	return ( isMoney.test(s) );
}

/**
* 为金额添加,分割符和.分割符
* @param {String} 要转换的金额字符串
* @return {String} 转换后的金额字符串
*/
function toCashWithCommaAndDot( cash ){
	cash = cash + "";
	var temp = toCashWithComma( cash );
	if ( temp.length == 0 ){
		return "0.00";
	}
	var dotPos = temp.indexOf(".");
	if ( dotPos < 0 ){
		return temp+'.00';
	}
	if ( dotPos == 0 ){
		temp = '0' + temp;
		dotPos = temp.indexOf(".");
	}
	if ( dotPos == temp.length-2){
		return temp + '0';
	}
	if ( dotPos == temp.length-1){
		return temp + '00';
	}
	return temp;
}

/**
* 为金额添加,分割符
* @param {String} 要转换的金额字符串
* @return {String} 转换后的金额字符串
*/
function toCashWithComma( cash ){
	cash = cash + "";
	while( cash.charAt(0) == '0' ){
		cash = cash.substr(1);
	}
	if( !isFloat( cash ) )
		return addComma(cash);	
			
	var dotIndex = cash.indexOf('.');
	var integerCash = cash.substring( 0, dotIndex );
	var decimalCash = cash.substring( dotIndex );
	
	return addComma(integerCash)+decimalCash;
}

/**
 * 展示错误提示信息，适用于表单提示
 * @param id
 * @param tips
 */
function showErrors(id,tips){
	$("#" + id).html("<div class='alert alert-danger tips'><i class='fa fa-times left'></i>" + tips + "</div>");
	$("#" + id).show();
}

/**
 * 展示错误信息，并清空表单数据，适用于表达提示
 * @param divId
 * @param tips
 * @param inputId
 * @returns
 */
function showErrorsAndInput(divId,tips,inputId){
	showErrors(divId,tips);
	$("#" + inputId).val("");
	$("#" + inputId).css("border","1px solid #d9534f");
	$("#" + inputId).focus();
}

/**
 * 展示错误信息，不清空表单数据，适用于表达提示
 * @param divId
 * @param tips
 * @param inputId
 * @returns
 */
function showErrorsAndInputNotNull(divId,tips,inputId){
	showErrors(divId,tips);
	$("#" + inputId).css("border","1px solid #d9534f");
	$("#" + inputId).focus();
}

function showRightsInput(inputId){
	$("#" + inputId).css("border","1px solid #5cb85c");
}


/**
 * 警告信息，适用于表格列表
 * @param errors
 * @returns {String}
 */
function getWarnSpan(tips){
	return "<span class='label label-sm label-warning'>" + tips + "</span>";
}

/**
 * 错误提示信息，适用于表格列表
 * @param tips
 * @returns {String}
 */
function getErrorSpan(tips){
	return "<span class='label label-sm label-danger'>" + tips + "</span>";
}

/**
 * 正确提示信息，适用于表格列表
 * @param tips
 * @returns {String}
 */
function getRightSpan(tips){
	return "<span class='label label-sm label-success'>" + tips + "</span>";
}


function getGreenSpan(text){
	return "<span class='label label-sm label-green'>" + text + "</span>";
}

function getBlueSpan(text){
	return "<span class='label label-sm label-blue'>" + text + "</span>";
}

function getOrangeSpan(text){
	return "<span class='label label-sm label-orange'>" + text + "</span>";
}

function getRedSpan(text){
	return "<span class='label label-sm label-red'>" + text + "</span>";
}

function getYellowSpan(text){
	return "<span class='yellow'>" + text + "</span>";
}

function getGreen(text){
	return "<span class='green'>" + text + "</span>";
}

function getBlue(text){
	return "<span class='blue'>" + text + "</span>";
}

function getOrange(text){
	return "<span class='orange'>" + text + "</span>";
}

function getRed(text){
	return "<span class='red'>" + text + "</span>";
}

function getYellow(text){
	return "<span class='yellow'>" + text + "</span>";
}

function getRightText(text){
	return "<span class='green'><i class='fa fa-check'></i>&nbsp;&nbsp;" + text + "</span>";
}

function getErrorText(text){
	return "<span class='red'><i class='fa fa-times'></i>&nbsp;&nbsp;" + text + "</span>";
}
