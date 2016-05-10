$(function(){
	$("#gameAddBathForm").fileupload({
        url: '../gameManager/uploadGameInfoAndRead',
        acceptFileTypes:  /(\.|\/)(xlsx)$/,
        dataType: 'json',
        done:function(e,data){
        	var rights = data.result.rights;
        	var errors = data.result.errors;
        	//设置正确信息
        	setResultContent(rights,"right");
        	//设置错误信息
        	setResultContent(errors,"error");
        }
    });
});

function setResultContent(contents,tab){
	var _rowContent = $("#" + tab + "TableListContent");
	_rowContent.empty();
	var rowTr = $("#" + tab + "TrContent");
	if(contents.length < 1){
		_rowContent.append(getNoResultRow(7,"没有相应记录"));
	}else{
		$.each(contents, function(i,detail){
			var row = $("<tr class='trContent'></tr>");
			row.html($(rowTr).html());
			
			row.find("[name='appName']").html(detail.gameName);
			row.find("[name='showAppName']").html(detail.showGameName);
			row.find("[name='keys']").html(detail.keys);
			row.find("[name='tabs']").html(detail.tabs);
			row.find("[name='category']").html(detail.categoryTxt);
			row.find("[name='isOnline']").html(detail.isOnlineTxt);
			row.find("[name='apkName']").html(detail.apkName);
			row.find("[name='errorTips']").html(detail.errorTips);
			
			_rowContent.append(row);
			row.show(); 
		});
	}
	parent.sizeChange();
}