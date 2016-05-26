<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
	<div id="tab1-wizard-custom-circle" class="tab-pane">
		<form id="gameInfoForm" action="#" class="form-horizontal form-seperated bv-form gameForm" method="POST">
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<label class="col-md-3 control-label" ><span class="require">*</span> 应用名称：</label>
						<div class="col-md-6">
							<input id="appName" class="form-control" type="text" placeholder="应用名称" name="appName">
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<label class="col-md-3 control-label" ><span class="require">*</span> 显示名称：</label>
						<div class="col-md-6">
							<input id="showName" class="form-control" type="text" placeholder="显示名称" name="showName">
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<label class="col-md-3 control-label" ><span class="require">*</span> 关键词：</label>
						<div class="col-md-6">
							<input id="searchKeys" class="form-control" placeholder="关键词" name="searchKeys">
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<label class="col-md-3 control-label" ><span class="require">*</span>应用标签：</label>
						<div class="col-md-6">
							<div class="checkbox-list">
								<c:forEach var="tab" items="${tabs }">
									<label class="checkbox-inline"> 
										<input type="checkbox" name="appTab" value="${tab.id }" />&nbsp;${tab.tabName }
									</label>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<label class="col-md-3 control-label" ><span class="require">*</span>应用分类：</label>
						<div class="col-md-6">
							<select id="categoryId" name="categoryId" class="form-control">
								<c:forEach var="category" items="${categories }">
									<option value="${category.typeId }">${category.typeName }</option>
								</c:forEach>
							</select>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<label class="col-md-3 control-label" ><span class="require">*</span>是否为网游：</label>
						<div class="col-md-6">
							<div class="radio">
								<label class="radio-inline"> <input id="optionsVisa" type="radio" name="isOnlie" value="1" checked="checked" />
									&nbsp; 是网游
								</label> 
								<label class="radio-inline"> <input id="optionsMasterCard" type="radio" name="isOnlie" value="0" />
									&nbsp;不是网游
								</label>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<label class="col-md-3 control-label" ><span class="require">*</span>游戏说明：</label>
						<div class="col-md-6">
							<textarea class="form-control" rows="5" id="appdesc" name="appdesc"></textarea>
						</div>
					</div>
				</div>
			</div>
			</form>
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<label class="col-md-3 control-label" ><span class="require">*</span>游戏截图：</label>
						<div class="col-md-9">
							<form id="gamePicList" method="post" class="form-horizontal form-seperated bv-form" enctype="multipart/form-data">
							<div class="row fileupload-buttonbar">
								<div class="col-md-5">
									<span class="btn btn-success fileinput-button"> 
										<i class="glyphicon glyphicon-plus"></i> <span>选择文件</span> 
										<input type="file" name="files" id="gamePicList" multiple>
									</span>
									<button type="submit" class="btn btn-primary start">
										<i class="glyphicon glyphicon-upload"></i> <span>上传文件</span>
									</button>
								</div>
								<div class="col-md-6 fileupload-progress fade">
									<div class="progress progress-striped active" role="progressbar" aria-valuemin="0" aria-valuemax="100">
										<div class="progress-bar progress-bar-success" style="width: 0%;"></div>
									</div>
									<div class="progress-extended">&nbsp;</div>
								</div>
							</div>
							<table class="table table-striped" role="presentation">
								<tbody class="files"></tbody>
							</table>
							</form>
						</div>
					</div>
				</div>
			</div>
	</div>
</body>
</html>