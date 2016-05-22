<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
		<div class="panel-body pan ">
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<label class="col-md-2 control-label" ><span class="require">*</span>导入文件：</label>
						<div>
							<form id="gameAddBathForm" method="post" class="form-horizontal form-seperated bv-form" enctype="multipart/form-data">
							<div class="row fileupload-buttonbar">
								<div class="col-md-4">
									<span class="btn btn-success fileinput-button"> 
										<i class="glyphicon glyphicon-plus"></i> <span>选择文件</span> 
										<input type="file" name="gameExcelModal" id="gameExcelModal" multiple>
									</span>
									&nbsp;&nbsp;&nbsp;
									<button type="submit" class="btn btn-primary start">
										<i class="glyphicon glyphicon-download"></i> <span>下载Excel模板</span>
									</button>
								</div>
								<div class="col-md-5 fileupload-progress fade">
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
		<ul id="bathGameInfoTab" class="nav nav-tabs ul-edit">
			<li class="active"><a data-toggle="tab" href="#rightInfo-tab">正确信息列表</a></li>
			<li><a data-toggle="tab" href="#errorInfo-tab">错误信息列表</a></li>
		</ul>
		<div id="bathGameInfoTabContent" class="tab-content">
			<div id="rightInfo-tab" class="tab-pane fade in active">
				<div class="tab-general">
					<div class="panel panel-blue"  style="max-height: 600px;overflow-y:auto;">
						<div class="panel-heading">正确信息列表</div>
						<div class="panel-body">
							<div class="table-responsive dataTables_wrapper form-inline no-footer ">
								<table class="table table-striped table-bordered table-hover table-advanced">
									<thead>
										<tr>
											<th>游戏名称</th>
											<th>展示游戏名称</th>
											<th>关键词</th>
											<th>游戏标签</th>
											<th>游戏分类</th>
											<th>是否为网游</th>
											<th>apk文件名</th>
										</tr>
									</thead>
									<tbody id="rightTableListContent">
									</tbody>
									<tr id="rightTrContent" style="display: none">
										<td name="appName"></td>
										<td name="showAppName"></td>
										<td name="keys"></td>
										<td name="tabs"></td>
										<td name="category"></td>
										<td name="isOnline"></td>
										<td name="apkName"></td>
									</tr>
								</table>
							</div>
						</div>
					</div>
				</div>
				<div style="margin: 0px auto;text-align: center;">
					<a class="btn btn-success" id="saveBathGameInfo" href="javascript:void(0)">&nbsp;&nbsp;&nbsp;<i class="fa fa-save"></i>&nbsp;&nbsp;保存&nbsp;&nbsp;&nbsp;</a>
				</div>
			</div>
			<div id="errorInfo-tab" class="tab-pane fade">
				<div class="tab-general">
					<div class="panel panel-blue"  style="max-height: 600px;overflow-y:auto;">
						<div class="panel-heading">错误信息列表</div>
						<div class="panel-body">
							<div class="table-responsive dataTables_wrapper form-inline no-footer ">
								<table class="table table-striped table-bordered table-hover table-advanced">
									<thead>
										<tr>
											<th>游戏名称</th>
											<th>展示游戏名称</th>
											<th>关键词</th>
											<th>游戏标签</th>
											<th>游戏分类</th>
											<th>是否为网游</th>
											<th>apk文件名</th>
											<th>错误信息</th>
										</tr>
									</thead>
									<tbody id="errorTableListContent">
									</tbody>
									<tr id="errorTrContent" style="display: none">
										<td name="appName"></td>
										<td name="showAppName"></td>
										<td name="keys"></td>
										<td name="tabs"></td>
										<td name="category"></td>
										<td name="isOnline"></td>
										<td name="apkName"></td>
										<td name="errorTips"></td>
									</tr>
								</table>
							</div>
						</div>
					</div>
					<div style="margin: 0px auto;text-align: center;">
						<a class="btn btn-primary" id="downErrorGameInfo" href="javascript:void(0);">&nbsp;&nbsp;<i class="fa fa-cloud-download"></i>&nbsp;&nbsp;下载错误信息&nbsp;&nbsp;</a>
					</div>
				</div>
			</div>
		</div>
</body>
</html>