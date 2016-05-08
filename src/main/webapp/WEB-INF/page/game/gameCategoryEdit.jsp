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
							<label class="col-md-3 control-label" ><span class="require">*</span> 分类名称：</label>
							<div class="col-md-6">
								<input id="userName" class="form-control" type="text" placeholder="用户名" name="userName">
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<div class="form-group">
							<label class="col-md-3 control-label" ><span class="require">*</span>ICON图片：</label>
							<div class="col-md-6">
								<span class="btn btn-success fileinput-button"><i class="glyphicon glyphicon-plus"></i>&nbsp;<span>Add icon...</span></span>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<div class="form-group">
							<label class="col-md-3 control-label" ><span class="require">*</span> 登录名：</label>
							<div class="col-md-6">
								<input id="password" class="form-control" placeholder="登录密码" name="password">
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
<script language="javascript" src="../resources/js/expand/des.js"></script>
<script src="../resources/js/xxplay/game/editGameCategory.js" type="text/javascript"></script>
</html>