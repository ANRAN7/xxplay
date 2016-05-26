<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
	<div id="tab3-wizard-custom-circle" class="tab-pane">
		<form id="gameOtherInfoForm" action="#" class="form-horizontal form-seperated bv-form gameForm">
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<label class="col-md-3 control-label" ><span class="require">*</span>适用性说明：</label>
						<div class="col-md-6">
							<textarea class="form-control" rows="5" id="compDesc" name="compDesc" placeholder="适用性说明"></textarea>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<label class="col-md-3 control-label" ><span class="require">*</span>更新说明：</label>
						<div class="col-md-6">
							<textarea class="form-control" rows="5" id="updateDesc" name="updateDesc" placeholder="更新说明"></textarea>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<label class="col-md-3 control-label" ><span class="require">*</span>黄暴等级：</label>
						<div class="col-md-6">
							<input id="evilLevel" class="form-control" placeholder="黄暴等级" name="evilLevel">
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<label class="col-md-3 control-label" >游戏备注：</label>
						<div class="col-md-6">
							<textarea class="form-control" rows="5" id="remarks" name="remarks" placeholder="游戏备注"></textarea>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<label class="col-md-3 control-label" >推荐标志：</label>
						<div class="col-md-6">
							<input id="recommFlag" class="form-control" placeholder="推荐标志" name="recommFlag">
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<label class="col-md-3 control-label" >推荐值：</label>
						<div class="col-md-6">
							<input id="recommLevel" class="form-control" placeholder="推荐值" name="recommLevel">
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<label class="col-md-3 control-label" >推荐语：</label>
						<div class="col-md-6">
							<input id="recommWord" class="form-control" placeholder="推荐语" name="recommWord">
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>