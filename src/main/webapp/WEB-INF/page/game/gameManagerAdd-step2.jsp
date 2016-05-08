<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
<div id="tab2-wizard-custom-circle" class="tab-pane">
		<div class="row">
			<div class="col-md-12">
				<div class="form-group">
					<label class="col-md-3 control-label" ><span class="require">*</span> 上传安装包：</label>
					<div class="col-md-9">
						<form id="apkFileForm" method="post" class="form-horizontal form-seperated bv-form" enctype="multipart/form-data">
							<div class="row fileupload-buttonbar">
								<div class="col-md-5">
									<span class="btn btn-success fileinput-button"> 
										<i class="glyphicon glyphicon-plus"></i> <span>选择文件</span> 
										<input type="file" name="apkFile" id="apkFile" multiple>
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
		<form id="packInfoForm" action="#" class="form-horizontal form-seperated bv-form gameForm">
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<label class="col-md-3 control-label" ><span class="require">*</span>下载地址：</label>
						<div class="col-md-6">
							<input id="packUrl" class="form-control" placeholder="下载地址" name="packUrl">
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<label class="col-md-3 control-label" ><span class="require">*</span>包名：</label>
						<div class="col-md-6">
							<input id="packageName" class="form-control" placeholder="包名" name="packageName">
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<label class="col-md-3 control-label" ><span class="require">*</span>版本代码：</label>
						<div class="col-md-6">
							<input id="verCode" class="form-control" placeholder="版本代码" name="verCode">
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<label class="col-md-3 control-label" ><span class="require">*</span>版本号：</label>
						<div class="col-md-6">
							<input id="verName" class="form-control" placeholder="版本号" name="verName">
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<label class="col-md-3 control-label" ><span class="require">*</span>MD5校验码：</label>
						<div class="col-md-6">
							<input id="packMd5" class="form-control" placeholder="MD5校验码" name="packMd5">
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<label class="col-md-3 control-label" ><span class="require">*</span>签名特征码：</label>
						<div class="col-md-6">
							<input id="signCode" class="form-control" placeholder="签名特征码" name="signCode">
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<label class="col-md-3 control-label" ><span class="require">*</span>文件大小：</label>
						<div class="col-md-6">
							<input id="packSize" class="form-control" placeholder="文件大小" name="packSize">
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<label class="col-md-3 control-label" ><span class="require">*</span>ICON地址：</label>
						<div class="col-md-6">
							<input id="iconPicurl" class="form-control" placeholder="ICON地址" name="iconPicurl">
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<label class="col-md-3 control-label" ><span class="require">*</span>ICON展示图：</label>
						<div class="col-md-6">
							<img id="showPackIcon" style="width: 72px;height: 72px"/>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<label class="col-md-3 control-label" ><span class="require">*</span>是否为主版本：</label>
						<div class="col-md-6">
							<div class="radio">
								<label class="radio-inline"> <input type="radio" name="isMainver" value="1" checked="checked" />
									&nbsp; 是主版本
								</label> 
								<label class="radio-inline"> <input type="radio" name="isMainver" value="0" />
									&nbsp;不是主版本
								</label>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>