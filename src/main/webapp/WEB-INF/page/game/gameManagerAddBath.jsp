<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
	<div class="tab-content">
		<div class="panel-body pan ">
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<label class="col-md-2 control-label" ><span class="require">*</span>导入文件：</label>
						<div>
							<form id="gameAddBathForm" method="post" class="form-horizontal form-seperated bv-form" enctype="multipart/form-data">
							<div class="row fileupload-buttonbar">
								<div class="col-md-6">
									<span class="btn btn-success fileinput-button"> 
										<i class="glyphicon glyphicon-plus"></i> <span>选择文件</span> 
										<input type="file" name="gameExcelModal" id="gameExcelModal" multiple>
									</span>
									<button type="submit" class="btn btn-primary start">
										<i class="glyphicon glyphicon-upload"></i> <span>上传文件</span>
									</button>
									&nbsp;&nbsp;&nbsp;
									<button type="submit" class="btn btn-primary start">
										<i class="glyphicon glyphicon-upload"></i> <span>下载Excel模板</span>
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
	</div>
</body>
</html>