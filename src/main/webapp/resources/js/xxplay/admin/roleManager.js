$(function(){
	turnPage(1);
	
	$("#addRole").click(function(){
		parent.openModal("增加管理员","../role/addRoleInit","1000");
	});
});

function turnPage(pageNo){
	var params = {"pageNo" : pageNo};
	ajaxSendLoadingForTbody("../role/queryRoleList", params, queryRoleListSuccess, "tableListContent");
}

function queryRoleListSuccess(responseData){
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
			
			row.find("[name='roleName']").html(detail.roleName);
			row.find("[name='status']").html(getStatus(detail.statusTxt,detail.status));

			var _opera = getOpera(detail.id,detail.status);
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
	var czHtml =  "<button class='btn btn-xs btn-info filter-submit' onclick='toUpdate(\"" + id + "\")'><i class='fa fa-external-link'>修改</i></button>&nbsp;&nbsp;&nbsp;&nbsp;";
	if(status == "1"){
		czHtml += "<button class='btn btn-xs btn-danger filter-submit' onclick='toUpdateState(\"" + id + "\",\"0\")'><i class='fa fa-times'>停用</i></button>";
	}else{
		czHtml += "<button class='btn btn-xs btn-success filter-submit' onclick='toUpdateState(\"" + id + "\",\"1\")'><i class='fa fa-check'>启用</i></button>";
	}
	return czHtml;
}

function toUpdateState(id,status){
	var params = {"id":id,
				  "status":status};
	ajaxSend("../role/updateRoleStatus",params,updateRoleStatusSuccess);
}

function updateRoleStatusSuccess(responseData){
	if(responseData.result){
		var pageNo = $("#currentPageNo").val();
		turnPage(pageNo);
	}
}