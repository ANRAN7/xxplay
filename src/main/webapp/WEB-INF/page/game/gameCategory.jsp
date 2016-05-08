<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="../../page/include/include_base_css.jsp" %>
</head>
<body>
	<div class="tab-general">
		<div class="panel panel-blue">
			<div class="panel-heading">
				游戏分类列表
				<button class="btn btn-orange btn-square btn-table" type="button"
					id="addGameCategory">新增游戏分类</button>
			</div>
			<div class="panel-body">
				<div
					class="table-responsive dataTables_wrapper form-inline no-footer ">
					<table
						class="table table-striped table-bordered table-hover table-advanced">
						<thead>
							<tr>
								<th>类型ID</th>
								<th>分类名称</th>
								<th>ICON图片</th>
								<th>状态</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody id="tableListContent">
						</tbody>
						<tr id="trContent" style="display: none">
							<td name="typeId"></td>
							<td name="typeName"></td>
							<td name="iconUrl"></td>
							<td name="typeStatus"></td>
							<td name="opeart"></td>
						</tr>
					</table>
					<div class="row" id="pageDirect"></div>
				</div>
			</div>
		</div>
	</div>
</body>
<%@include file="../../page/include/include_base_js.jsp" %>
<script src="../resources/js/xxplay/game/gameCategory.js" type="text/javascript"></script>
</html>