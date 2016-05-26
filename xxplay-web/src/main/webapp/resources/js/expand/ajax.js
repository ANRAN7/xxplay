/**
 * jquery的ajax提交请求封装函数
 * @param url 请求url
 * @param params 提交的数据
 * @param successCallFun 页面自己的回调函数，无需加引号
 */
function ajaxSend( url,params,successCallFun){
	$.ajax({
		// 后台处理程序
		url : url,
		// 数据发送方式
		type : "post",  
		// 接受数据格式
		dataType : "json",
		contentType:"application/json;charset=UTF-8",
		// 要传递的数据
		data : JSON.stringify(params),
		//不缓存，每次重新请求后台
		cache: false,
		// 回传函数
		success : function( responseData,textStatus,btnId ){
			successCallFun(responseData);
		}
	});
}

/**
 * ajax请求，加载"加载中动画",主要用于DIV
 * @param url
 * @param params
 * @param successCallFun
 * @param divId
 */
function ajaxSendLoadingForDiv(url,params,successCallFun,divId){
	var oldHtml = $("#" + divId).html();
	$.ajax({
		// 后台处理程序
		url : url,
		// 数据发送方式
		type : "post",
		contentType:"application/json;charset=UTF-8",
		// 接受数据格式
		dataType : "json",
		// 要传递的数据
		data : JSON.stringify(params),
		//不缓存，每次重新请求后台
		cache: false,
		beforeSend:function(XMLHttpRequest){
           $("#" + divId).html("<div style='width:100%'><div class='loadingImg'></div></div>");
		},
		// 回传函数
		success : function( responseData,textStatus,btnId ){
			$("#" + divId).html(oldHtml);
			if(responseData.errorCode!=null||responseData.errorMessage!=null){
				return;
			}
			successCallFun(responseData);
		}
	});
}

/**
 * ajax请求，加载"加载中动画",主要用于table列表展示，tbodyId为显示内容tbody Id
 * @param url
 * @param params
 * @param successCallFun
 * @param divId
 */
function ajaxSendLoadingForTbody(url,params,successCallFun,tbodyId){
	var oldHtml = $("#" + tbodyId).html();
	$.ajax({
		// 后台处理程序
		url : url,
		// 数据发送方式
		type : "post",
		contentType:"application/json;charset=UTF-8",
		// 接受数据格式
		dataType : "json",
		// 要传递的数据
		data : JSON.stringify(params),
		//不缓存，每次重新请求后台
		cache: false,
		beforeSend:function(XMLHttpRequest){
			var _table = $("#" + tbodyId).closest("table").eq(0);
			var _clos = _table.find("thead th").length;
           $("#" + tbodyId).html("<tr><td  colspan='"+_clos+"' align='center'><div class='loadingImg'></div></td></tr>");
		},
		// 回传函数
		success : function( responseData,textStatus){
			$("#" + tbodyId).html(oldHtml);
			if(responseData.errorCode != null ||responseData.errorMessage != null){
				var _table = $("#" + tbodyId).closest("table").eq(0);
				var _clos = _table.find("thead td").length;
	            $("#" + tbodyId).html("<tr><td  colspan='"+_clos+"' align='center'><div class='alert alert-danger'>" + responseData.errorMessage + "</div></td></tr>");
				return;
			}
			successCallFun(responseData);
			try{
				sizeChange();		//控制页面
			}catch(e){}
		}
	});
}
