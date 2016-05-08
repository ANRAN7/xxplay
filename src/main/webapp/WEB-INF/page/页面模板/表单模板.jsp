					<div class="panel panel-blue">
                        <div class="panel-heading">IP黑名单修改</div>
						<div class="panel-body pan">
							<form class="form-horizontal form-seperated">
	                			<div class="row">
	                				<div class="col-md-6">
	                					<div class="form-group">
	                						<label class="col-md-3 control-label" ><span class="require">*</span><s:text name="package.blacklist.custName"/>：</label>
	                						<div class="col-md-9"><input id="custName" class="form-control" type="text"></div>
	                					</div>
	                				</div>
	                				<div class="col-md-6">
	                					<div class="form-group">
	                						<label class="col-md-3 control-label" ><span class="require">*</span><s:text name="package.blacklist.custNo"/>：</label>
	                						<div class="col-md-9"><input id="custNo" class="form-control" type="text"></div>
	                					</div>
	                				</div>
	                			</div>
	                			<div class="row">
	                				<div class="col-md-6">
	                					<div class="form-group">
	                						<label class="col-md-3 control-label" ><span class="require">*</span><s:text name="package.blacklist.startIp"/>：</label>
	                						<div class="col-md-9"><input id="startIp" class="form-control" type="text"></div>
	                					</div>
	                				</div>
	                				<div class="col-md-6">
	                					<div class="form-group">
	                						<label class="col-md-3 control-label" ><span class="require">*</span><s:text name="package.blacklist.endIp"/>：</label>
	                						<div class="col-md-9"><input id="endIp" class="form-control" type="text"></div>
	                					</div>
	                				</div>
	                			</div>
	                			<div class="row">
	                				<div class="col-md-6">
	                					<div class="form-group">
	                						<label class="col-md-3 control-label" ><span class="require">*</span><s:text name="package.blacklist.listState"/>：</label>
	                						<div class="col-md-9">
	                							<s:select id="stete" cssClass="form-control" list="states" listKey="aprValue" listValue="aprShowMsg"/>
	                						</div>
	                					</div>
	                				</div>
	                				<div class="col-md-6">
	                					<div class="form-group">
	                						<label class="col-md-3 control-label" ><span class="require">*</span><s:text name="package.blacklist.source"/>：</label>
	                						<div class="col-md-9">
	                							<s:select id="source" cssClass="form-control" list="sources" listKey="aprValue" listValue="aprShowMsg"/>
	                						</div>
	                					</div>
	                				</div>
	                			</div>
	                		</form>
	                	</div>
						<div class="panel-body pan">
	                		<div id="errorTips"></div>
							<div class="col-md-12 btn-general" style="margin-top: 10px">
								<button class="btn btn-primary" type="button" id="doSubmitBtn" onclick="doSubmit()">保&nbsp;&nbsp;&nbsp;存</button>
								<button class="btn btn-primary" type="button" id="goBackBtn" onclick="goBack()">返&nbsp;&nbsp;&nbsp;回</button>
							</div>
	                	</div>
	                </div>