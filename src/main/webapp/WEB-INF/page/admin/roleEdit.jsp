<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
	<div class="tab-general" style="overflow: hidden">
		<div class="panel-body pan ">
			<form class="form-horizontal form-seperated" id="saveForm" method="post">
				<div class="row">
					<div class="col-md-12">
						<div class="form-group">
							<label class="col-md-3 control-label" ><span class="require">*</span> 角色名称：</label>
							<div class="col-md-6">
								<input id="roleName" class="form-control" type="text" placeholder="角色名称" name="roleName">
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<div class="form-group">
							<label class="col-md-3 control-label" ><span class="require">*</span> 角色描述：</label>
							<div class="col-md-6">
								<textarea class="form-control" rows="3" id="roleDesc" name="roleDesc" placeholder="角色描述"></textarea>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<div class="form-group">
							<label class="col-md-3 control-label" ><span class="require">*</span>功能菜单：</label>
							<div class="col-md-6">
								<ul>
									<li>
										<input type="checkbox">游戏管理
										<div>
											
										</div>
									</li>
									<li></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
					<div id="errorTips"></div>
					<div class="col-md-12 btn-general" style="margin-top: 10px">
					<button class="btn btn-primary" type="submit" id="doSubmitBtn">保&nbsp;&nbsp;&nbsp;存</button>
				</div>
			</form>
		</div>
	</div>
</body>
<script src="../resources/js/xxplay/admin/roleEdit.js" type="text/javascript"></script>
</html>