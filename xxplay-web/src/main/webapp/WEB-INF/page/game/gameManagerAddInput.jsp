<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="../include_base_css.jsp"%>
</head>
<body>
	<div class="portlet box portlet-blue">
		<div class="portlet-body">
			<div id="rootwizard-custom-circle">
				<div class="navbar">
					<div class="navbar-inner">
						<ul>
							<li >
								<a href="#tab1-wizard-custom-circle" data-toggle="tab">
									<i class="glyphicon glyphicon-user"></i> <p class="anchor">1. 录入基本信息</p>
								</a>
							</li>
							<li><a href="#tab2-wizard-custom-circle" data-toggle="tab">
							 		<i class="glyphicon glyphicon-send mln"></i> <p class="anchor">2.安装包信息</p>
								</a>
							</li>
							<li>
								<a href="#tab3-wizard-custom-circle" data-toggle="tab">
									<i class="glyphicon glyphicon-shopping-cart"></i> <p class="anchor">3.游戏补充信息</p>
								</a>
							</li>
							<li>
								<a href="#tab4-wizard-custom-circle" data-toggle="tab">
									<i class="glyphicon glyphicon-shopping-cart"></i> <p class="anchor">4.录入信息确认</p>
								</a>
							</li>
						</ul>
					</div>
				</div>
				<div id="bar" class="progress active">
					<div class="bar progress-bar progress-bar-primary"></div>
				</div>
				<div class="tab-content">
					<jsp:include page="gameManagerAdd-step1.jsp"/>
					<jsp:include page="gameManagerAdd-step2.jsp"/>
					<jsp:include page="gameManagerAdd-step3.jsp"/>
					<jsp:include page="gameManagerAdd-step4.jsp"/>
					<div class="action text-right">
						<div id="errorTips" style="text-align: right;padding-right: 100px;margin-bottom: 15px"></div>
						<button type="button" name="previous" value="Previous" class="btn btn-info button-previous">
							<i class="fa fa-arrow-circle-o-left mrx"></i>上一步
						</button>
						<button type="button" name="next" value="Next" class="btn btn-info button-next mlm">
							下一步<i class="fa fa-arrow-circle-o-right mlx"></i>
						</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>