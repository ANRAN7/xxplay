<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>xxplay后台管理系统</title>
<link href="../resources/styles/font/font-awesome.min.css" rel="stylesheet" type="text/css" />
<link href="../resources/styles/bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="../resources/styles/expand/baseStyle.css" rel="stylesheet" type="text/css" />
<link href="../resources/styles/skin/orange-blue.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="../resources/js/jquery/jquery-1.10.2.min.js"></script>
<script language="javascript" src="../resources/js/expand/ajax.js"></script>
<script language="javascript" src="../resources/js/expand/des.js"></script>
<script language="javascript" src="../resources/js/expand/public.js"></script>
<script language="javascript" src="../resources/js/xxplay/login.js"></script>
<style type="text/css">
.box {
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#6699FF', endColorstr='#6699FF'); /*  IE */
	background-image:linear-gradient(bottom, #6699FF 0%, #6699FF 100%);
	background-image:-o-linear-gradient(bottom, #6699FF 0%, #6699FF 100%);
	background-image:-moz-linear-gradient(bottom, #6699FF 0%, #6699FF 100%);
	background-image:-webkit-linear-gradient(bottom, #6699FF 0%, #6699FF 100%);
	background-image:-ms-linear-gradient(bottom, #6699FF 0%, #6699FF 100%);
	margin: 0 auto;
	position: relative;
	width: 100%;
	height: 100%;
}
</style>
</head>

<body>
    <div class="box">
		<div class="login-box">
			<div class="login-title text-center">
                <h4>xxplay后台管理系统</h4>
			</div>
			<div class="login-content ">
			<div class="form">
			<form action="" method="post">
				<div class="form-group">
					<div class="col-xs-12  ">
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-user"></i></span>
							<input type="text" id="userName" name="userId" class="form-control" placeholder="用户名">
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-xs-12  ">
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-unlock"></i></span>
							<input type="password" id="password" class="form-control" placeholder="密码">
						</div>
					</div>
				</div>
				<div class="form-group form-actions" style="background-color: #C2D3FF">
					<div class="col-xs-4 col-xs-offset-4" style="margin-top: 15px">
						<button type="button" id="loginBtn" class="btn btn-sm btn-info"><i class="fa fa-group"></i>&nbsp;&nbsp;登录&nbsp;&nbsp;</button>
					</div>
					<div id="errorTips" class="col-xs-4 col-xs-offset-4" style="width: 500px;margin-left: 0px;"></div>
				</div>
			</form>
			</div>
		</div>
	</div>
</div>
<form action="../login/login" id="loginForm" method="post">
	<input type="hidden" id="user_userName" name="userName"/>
	<input type="hidden" id="user_password" name="password"/>
</form>
</body>
</html>