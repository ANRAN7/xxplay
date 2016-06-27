<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="../include_base_css.jsp"%>
</head>
<body>
	<ul id="progressbarTab" class="nav nav-tabs ul-edit">
		<li class="active"><a data-toggle="tab" href="#gameAddInpput-tab">手动录入</a></li>
		<li><a data-toggle="tab" href="#gameAddBath-tab">批量导入</a></li>
	</ul>
	<div id="progressbarTabContent" class="tab-content">
		<div id="gameAddInpput-tab" class="tab-pane fade in active">
			<jsp:include page="gameManagerAddInput.jsp"/>
		</div>
		<div id="gameAddBath-tab" class="tab-pane fade">
			<jsp:include page="gameManagerAddBath.jsp"/>
		</div>
	</div>
	<%@include file="../include_file_upload_vendorjs.jsp"%>
</body>
<%@include file="../include_base_js.jsp"%>
<%@include file="../include-jquery-step.jsp"%>
<%@include file="../include_file_upload.jsp"%>
<!-- 一个页面存在多个上传 -->
<script src="../resources/js/jquery/jquery.form.js" type="text/javascript"></script>
<script src="../resources/js/xxplay/game/gameManagerAddInput.js" type="text/javascript"></script>
<script src="../resources/js/xxplay/game/gameManagerAddBath.js" type="text/javascript"></script>
</html>