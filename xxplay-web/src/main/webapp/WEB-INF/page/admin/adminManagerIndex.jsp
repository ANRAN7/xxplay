<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="../include_base_css.jsp" %>
</head>
<body>
	<div class="form-body">
		<div class="row">
			<div class="col-md-6 form-group">
				<label class="col-md-2 control-label label-text" for="inputName">用户名：</label>
				<div class="col-md-9 ">
					<input id="userName" class="form-control" type="text" maxlength="30">
				</div>
			</div>
			<div class="col-md-6 form-group">
				<label class="col-md-2 control-label label-text" for="inputName">姓名：</label>
				<div class="col-md-9">
					<input id="realName" class="form-control" type="text" maxlength="30">
				</div>
			</div>
		</div>
		
		<div class="row btnRow">
			<button id="queryBtn" class="btn  btn-primary btn-square ra120" type="button" onclick="turnPage(1)" >
				查询
			</button>
		</div>
		<div class="tab-general">
			<div class="panel panel-blue">
				<div class="panel-heading">
					用户列表
					<button class="btn btn-orange btn-square btn-table" type="button" id="addManager">新增管理员</button>
				</div>
				<div class="panel-body">
					<div
						class="table-responsive dataTables_wrapper form-inline no-footer ">
						<table
							class="table table-striped table-bordered table-hover table-advanced">
							<thead>
								<tr>
									<th>用户名</th>
									<th>姓名</th>
									<th>提交时间</th>
									<th>角色</th>
									<th>状态</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody id="tableListContent">
							</tbody>
							<tr id="trContent" style="display: none">
								<td name="userName"></td>
								<td name="realName"></td>
								<td name="createTime"></td>
								<td name="role"></td>
								<td name="status"></td>
								<td name="opeart"></td>
							</tr>
						</table>
						<div class="row" id="pageDirect"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<%@include file="../include_base_js.jsp" %>
<script src="../resources/js/xxplay/admin/adminManager.js" type="text/javascript"></script>
</html>