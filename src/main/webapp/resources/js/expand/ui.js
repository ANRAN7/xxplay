function pubTurnPage(pageNo,totalPage){
	var beginPage = 1;
	var endPage = totalPage;
	if(pageNo - 3 > beginPage ){
		beginPage = pageNo - 3;
	}
	if(pageNo + 3 < endPage){
		endPage = pageNo + 3;
	}
	var pageDiv = $("<div id='table_id_paginate' class='dataTables_paginate paging_simple_numbers'><input type='hidden' id='currentPageNo' value='" + pageNo + "'></div>");
	var pageUL = $("<ul class='pagination'></ul>");
	
	var _previous ;
	if(pageNo == 1){
		_previous = $("<li id='table_id_previous' class='paginate_button previous disabled' aria-controls='table_id' tabindex='0'><a href='javascript:void(0);'> < </a></li>");
	}else{
		_previous = $("<li id='table_id_previous' class='paginate_button previous' aria-controls='table_id' tabindex='0'><a href='javascript:turnPage(" + eval(pageNo - 1) + ");'> < </a></li>");
	}
	pageUL.append(_previous);
	
	if(beginPage > 1){
		var _page1 = $("<li class='paginate_button' aria-controls='table_id' tabindex='0'><a href='javascript:turnPage(1)'>1</a></li>");
		pageUL.append(_page1);
	}
	
	if(beginPage - 1 > 1){
		var _other = $("<li class='paginate_button' aria-controls='table_id'><a class='other'>...</a></li>");
		pageUL.append(_other);
	}
	
	var page;
	for(var i = beginPage ; i <= endPage ; i++){
		if(i == pageNo){
			page = $("<li class='paginate_button active' aria-controls='table_id' tabindex='0'><a href='javascript:turnPage(" + i + ")'>" + i + "</a></li>");
		}else{
			page = $("<li class='paginate_button' aria-controls='table_id' tabindex='0'><a href='javascript:turnPage(" + i + ")'>" + i + "</a></li>");
		}
		pageUL.append(page);
	}
	
	if(endPage + 1 < totalPage){
		var _other = $("<li class='paginate_button ' aria-controls='table_id' ><a class='other'>...</a></li>");
		pageUL.append(_other);
	}
	
	if(endPage < totalPage){
		page = $("<li class='paginate_button' aria-controls='table_id' tabindex='0'><a href='javascript:turnPage(" + totalPage + ")'>" + totalPage + "</a></li>");
		pageUL.append(page);
	}
	var _next;
	if(pageNo  < totalPage){
		_next = $("<li id='table_id_next' class='paginate_button next' aria-controls='table_id' tabindex='0'><a href='javascript:turnPage(" + eval(pageNo+1) + ");'> > </a></li>");
	}else{
		_next = $("<li id='table_id_next' class='paginate_button next disabled' aria-controls='table_id' tabindex='0'><a href='javascript:void(0)'> > </a></li>");
	}
	
	pageUL.append(_next);
	pageDiv.append(pageUL);
	
	return pageDiv;
}

function pubTurnPageMethod(pageNo,totalPage,method){
	var beginPage = 1;
	var endPage = totalPage;
	if(pageNo - 3 > beginPage ){
		beginPage = pageNo-3;
	}
	if(pageNo + 3 < endPage){
		endPage = pageNo + 3;
	}
	var pageDiv = $("<div id='table_id_paginate' class='dataTables_paginate paging_simple_numbers'></div>");
	var pageUL = $("<ul class='pagination'></ul>");
	
	var _previous ;
	if(pageNo == 1){
		_previous = $("<li id='table_id_previous' class='paginate_button previous disabled' aria-controls='table_id' tabindex='0'><a href='javascript:void(0);'> < </a></li>");
	}else{
		_previous = $("<li id='table_id_previous' class='paginate_button previous' aria-controls='table_id' tabindex='0'><a href='javascript:" + method + "(" + eval(pageNo - 1) + ");'> < </a></li>");
	}
	pageUL.append(_previous);
	
	if(beginPage > 1){
		var _page1 = $("<li class='paginate_button' aria-controls='table_id' tabindex='0'><a href='javascript:" + method + "(1)'>1</a></li>");
		pageUL.append(_page1);
	}
	
	if(beginPage - 1 > 1){
		var _other = $("<li class='paginate_button' aria-controls='table_id'><a class='other'>...</a></li>");
		pageUL.append(_other);
	}
	
	var page;
	for(var i = beginPage ; i <= endPage ; i++){
		if(i == pageNo){
			page = $("<li class='paginate_button active' aria-controls='table_id' tabindex='0'><a href='javascript:" + method + "(" + i + ")'>" + i + "</a></li>");
		}else{
			page = $("<li class='paginate_button' aria-controls='table_id' tabindex='0'><a href='javascript:" + method + "(" + i + ")'>" + i + "</a></li>");
		}
		pageUL.append(page);
	}
	
	if(endPage + 1 < totalPage){
		var _other = $("<li class='paginate_button ' aria-controls='table_id' ><a class='other'>...</a></li>");
		pageUL.append(_other);
	}
	
	if(endPage < totalPage){
		page = $("<li class='paginate_button' aria-controls='table_id' tabindex='0'><a href='javascript:" + method + "(" + totalPage + ")'>" + totalPage + "</a></li>");
		pageUL.append(page);
	}
	var _next;
	if(pageNo  < totalPage){
		_next = $("<li id='table_id_next' class='paginate_button next' aria-controls='table_id' tabindex='0'><a href='javascript:" + method + "(" + eval(pageNo+1) + ");'> > </a></li>");
	}else{
		_next = $("<li id='table_id_next' class='paginate_button next disabled' aria-controls='table_id' tabindex='0'><a href='javascript:void(0)'> > </a></li>");
	}
	
	pageUL.append(_next);
	pageDiv.append(pageUL);
	
	return pageDiv;
}

function getNoResultRow(colspan){
	var row = $("<tr class='trContent'></tr>");
	row.html("<td colspan='" + colspan + "'><div class='alert alert-info tableAlert'>没有相应记录</div></td>");
	
	return row;
}

function getNoResultRow(colspan,content){
	var row = $("<tr class='trContent'></tr>");
	row.html("<td colspan='" + colspan + "'><div class='alert alert-info tableAlert'>" + content + "</div></td>");
	
	return row;
}

function getExceptionResultRow(colspan,content){
	var row = $("<tr class='trContent'></tr>");
	row.html("<td colspan='" + colspan + "'><div class='alert alert-info tableAlert'>" + content + "</div></td>");
	return row;
}

function getExceptionResultDiv(content){
	return "<div class='alert alert-info tableAlert' style='text-align:center'>" + content + "</div>";
}

function setPageDirect(id,pageNo,totalPage){
	var pageDiv = pubTurnPage(pageNo, totalPage);
	$("#" + id).html(pageDiv);
}

function setPageDirectMethod(id,pageNo,totalPage,method){
	var pageDiv = pubTurnPageMethod(pageNo, totalPage,method);
	$("#" + id).html(pageDiv);
}