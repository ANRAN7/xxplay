
<div class="form-body">
	<div class="row">
		<div class="col-md-6 form-group">
			<label class="col-md-2 control-label label-text" for="inputName"></label>
			<div class="col-md-9 ">
				<input id="caseno" class="form-control" type="text" maxlength="30">
			</div>
		</div>
		<div class="col-md-6 form-group">
			<label class="col-md-2 control-label label-text" for="inputName"></label>
			<div class="col-md-9">
				<input id="clueno" class="form-control" type="text" maxlength="30">
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-6 form-group">
			<label class="col-md-2 control-label label-text" for="inputName"></label>
			<div class="col-md-9">
				<input id="accno" class="form-control" type="text" maxlength="30">
			</div>
		</div>
		<div class="col-md-6 form-group">
			<label class="col-md-2 control-label label-text" for="inputName"></label>
			<div class="col-md-9 ">
				<div class="col-md-5 input-icon col-md-m">
					<i class="fa fa-calendar"></i> <input readonly="readonly"
						id="beginDate" class="form-control inputText" type="text"
						name="daterangepicker-date-time"
						onclick="WdatePicker({dateFmt:'yyyyMMdd',maxDate:'%y-%M-%d'})">
				</div>
				<label class="col-md-1 control-label fgf" for="inputName">---</label>
				<div class="col-md-5 input-icon col-md-m">
					<i class="fa fa-calendar"></i> <input readonly="readonly"
						id="endDate" class="form-control inputText" type="text"
						name="daterangepicker-date-time"
						onclick="WdatePicker({dateFmt:'yyyyMMdd',maxDate:'%y-%M-%d'})">
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-6 form-group">
			<label class="col-md-2 control-label label-text" for="inputName"></label>
			<div class="col-md-9 ">
				<div class="col-md-5 col-md-m">
					<input id="beginRiskvalue" class="form-control" type="text"
						maxlength="30">
				</div>
				<label class="col-md-1 control-label fgf" for="inputName">---</label>
				<div class="col-md-5 col-md-m">
					<input id="endRiskvalue" class="form-control" type="text"
						maxlength="30">
				</div>
			</div>
		</div>
		<div class="col-md-6 form-group">
			<label class="col-md-2 control-label label-text" for="inputName"></label>
			<div class="col-md-9">
				<div class="col-md-5 input-icon col-md-m">
					<i class="fa fa-calendar"></i> <input readonly="readonly"
						id="beginDate" class="form-control inputText" type="text"
						name="daterangepicker-date-time"
						onclick="WdatePicker({dateFmt:'yyyyMMdd',maxDate:'%y-%M-%d'})">
				</div>
				<label class="col-md-1 control-label fgf" for="inputName">---</label>
				<div class="col-md-5 input-icon col-md-m">
					<i class="fa fa-calendar"></i> <input readonly="readonly"
						id="enddate" class="form-control inputText" type="text"
						name="daterangepicker-date-time"
						onclick="WdatePicker({dateFmt:'yyyyMMdd',maxDate:'%y-%M-%d'})">
				</div>
			</div>
		</div>
	</div>
	<div class="row btnRow">
		<button id="queryBtn" class="btn  btn-primary btn-square ra120"
			type="button" onclick="turnPage(1)">
		</button>
		<input type="hidden" id="menuFlag"
			value="<s:property value="menuFlag"/>" />
	</div>
</div>