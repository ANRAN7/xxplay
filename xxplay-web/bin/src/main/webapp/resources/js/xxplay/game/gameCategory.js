$(function(){
	turnPage(1);
	
	$("#addGameCategory").click(function(){
		parent.openModal("新增游戏分类","../gameCatetory/addGameCategory","700");
	});
});

function turnPage(pageNo){
	var params = {"pageNo":pageNo};
	
	ajaxSendLoadingForTbody("../gameCatetory/queryGameCategoyrList", params, queryGameCategoryListSuccess, "tableListContent");
}

function queryGameCategoryListSuccess(responseData){
	var _rowContent = $("#tableListContent");
	_rowContent.empty();
	var rowTr = $("#trContent");
	if(responseData.resultList.length < 1){
		_rowContent.append(getNoResultRow(5,"没有相应记录"));
	}else{
		$.each(responseData.resultList, function(i,detail){
			var row = $("<tr class='trContent'></tr>");
			row.html($(rowTr).html());
			row.attr("name", "name_"+i);
			row.attr("id", "tC_"+i);
			
			row.find("[name='typeId']").html(detail.typeId);
			row.find("[name='typeName']").html(detail.typeName);
			row.find("[name='iconUrl']").html(detail.typeIconurl);
			row.find("[name='typeStatus']").html(getStatus(detail.typeStatusTxt,detail.typeStatus));

			var _opera = getOpera(detail.typeId,detail.typeStatus);
			row.find("[name='opeart']").html(_opera);
			
			_rowContent.append(row);
			row.show(); 
		});
		setPageDirect("pageDirect",responseData.pageNo,responseData.totalPage);
	}
	parent.sizeChange();
}

function getStatus(statusTxt,status){
	switch(status){
		case"0" : return getErrorText(statusTxt); break;
		case"1" : return getRightText(statusTxt); break;
	}
}

function getOpera(id,status){
	var czHtml =  "<button class='btn btn-xs btn-info filter-submit' onclick='toUpdate(\"" + id + "\")'><i class='fa fa-external-link'>&nbsp;修改</i></button>&nbsp;&nbsp;&nbsp;&nbsp;";
	if(status == "1"){
		czHtml += "<button class='btn btn-xs btn-danger filter-submit' onclick='toUpdateState(\"" + id + "\",\"0\")'><i class='fa fa-times'>&nbsp;停用</i></button>";
	}else{
		czHtml += "<button class='btn btn-xs btn-success filter-submit' onclick='toUpdateState(\"" + id + "\",\"1\")'><i class='fa fa-check'>&nbsp;启用</i></button>";
	}
	return czHtml;
}

function toUpdateState(id,status){
	var params = {"id":id,
				  "status":status};
	ajaxSend("../gameCatetory/updateGameCategoryStatus",params,updateGameCategoryStatusSuccess);
}

function updateGameCategoryStatusSuccess(responseData){
	if(responseData.result){
		var pageNo = $("#currentPageNo").val();
		turnPage(pageNo);
	}
}
