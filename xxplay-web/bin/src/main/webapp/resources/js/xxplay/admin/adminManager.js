$(function(){
	$("#addManager").click(function(){
		parent.openModal("增加管理员","../admin/addManagerInit","700");
	});
});

function turnPage(pageNo){
	var userName = $("#userName").val();
	var realName = $("#realName").val();
	
	var params ={"userName":userName,"realName":realName,"pageNo":pageNo};
	ajaxSendLoadingForTbody("../admin/queryAdminList", params, queryAdminListSuccess, "tableListContent");
}

function queryAdminListSuccess(responseData){
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
			
			row.find("[name='userName']").html(detail.userName);
			row.find("[name='realName']").html(detail.realName);
			row.find("[name='createTime']").html(detail.createTimeTxt);
			row.find("[name='role']").html(detail.roleName);
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
	var czHtml =  "<button class='btn btn-xs btn-info filter-submit' onclick='toUpdate(\"" + id + "\")'><i class='fa fa-external-link'>修改</i></button>&nbsp;&nbsp;&nbsp;&nbsp;" +
				  "<button class='btn btn-xs btn-warning filter-submit' onclick='toDelete(\"" + id + "\")'><i class='fa fa-minus-circle'>删除</i></button>&nbsp;&nbsp;&nbsp;&nbsp;";
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
	ajaxSend("../admin/updateAdminStatus",params,updateAdminStatusSuccess);
}

function updateAdminStatusSuccess(responseData){
	if(responseData.result){
		var pageNo = $("#currentPageNo").val();
		turnPage(pageNo);
	}
}

function toDelete(id){
	var params = {"id":id};
	ajaxSend("../admin/deleteAdmin",params,deleteAdminSuccsee);
}

function deleteAdminSuccsee(responseData){
	if(responseData.result){
		var pageNo = $("#currentPageNo").val();
		turnPage(pageNo);
	}
}

function toUpdate(id){
	parent.openModal("增加管理员","../admin/updateManagerInit?id=" + id,"700");
}