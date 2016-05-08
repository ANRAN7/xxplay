	var fas = new Array("fa-bullhorn", "fa-laptop", "fa-rocket", "fa-desktop",
						"fa-align-left", "fa-align-right", "fa-instagram", "fa-hand-o-up",
						"fa-trello", "fa-font", "fa-list-alt", "fa-tint",
						"fa-dot-circle-o", "fa-th-large", "fa-tasks", "fa-rocket",
						"fa-columns", "fa-cube", "fa-magic", "fa-cloud-upload",
						"fa-upload", "fa-th-large", "fa-indent", "fa-edit", "fa-table",
						"fa-tencent-weibo", "fa-file-o", "fa-suitcase", "fa-group",
						"fa-calendar","fa-slack","fa-bar-chart-o","fa-bullseye",
						"fa-certificate");
	$(function() {
		queryMenu();
	});

	var _i = 0;
	function queryMenu() {
		var url = "../login/queryMenu.action";
		ajaxSend(url,null,queryMenuSuccess);
		$.ajax({
			type : "POST",
			url : '',
			dateType : "json",
			success : function(date) {
				
			}
		});
	};
	
function queryMenuSuccess(responseData){
	var _menu = responseData.roots;
	var _sideMenu = $("#side-menu");
	$.each(_menu, function(i, value) { //可能存在四级菜单，注意迭代
		//构建一级菜单
		var _firstLi = $("<li></li>");
		var _a1 = $("<a href='#'></a>");
		var _i1 = "<i class='fa fa-fw " + getFunClass(value.childList) + "'></i>";
		var _span1 = "<span class='menu-title'>" + value.menuName + "</span>";
		var _firstChild = value.childList;
		
		_a1.append(_i1);
		_a1.append(_span1);
		
		 /*
		  *二级菜单不为空，构建二级菜单
		  *从二级菜单开始迭代，如果存在子菜单，则继续迭代，如果不存在则设置url
		  */
		if(_firstChild != null && _firstChild.length > 0){  
			//构建菜单
			_firstLi = buildChildMenu(_firstChild,_a1,_firstLi,2);
		}else{
			_firstLi.append(_a1);
		}
		
		_sideMenu.append(_firstLi);
		
		_i++;   //图标+1
	});
	setSidebarActive();      //设置菜单、初始化菜单
	$("#side-menu").metisMenu();    //初始化菜单
}
	
	/**
	 * 构建子菜单
	 * child：子菜单
	 * _a：子菜单a
	 * _li:子菜单li
	 * level:第几级菜单
	 */
	function buildChildMenu(child,_a,_li,level){
		_i++;        //图标+1
		var _span2 = "<span class='fa arrow'></span>";
		_a.append(_span2);     //将_span2添加到_a中
		_li.append(_a);  //将_a1添加到_li
		var _ul = $("<ul class='nav " + getLevelClass(level) + " collapse '>");
		$.each(child,function(i,_value){
			var _li1 = $("<li></li>");
			var _a1;
			if(_value.childList != null && _value.childList.length > 0){
				_a1 = $("<a href='#'></a>");
			}
			else{
				_a1 = $("<a href='javascript:void(0)' target='_self' onclick='toFunMenu(\"" + _value.menuUrl + "\")' id='" + _value.menuCode + "'></a>");
			}
			var _i1 = "<i class='fa fa-fw " + getFunClass(_value.childList) + "'></i>";
			var _span1 = "<span class='menu-title'>" + _value.menuName + "</span>";
			_a1.append(_i1);
			_a1.append(_span1);
			if(_value.childList != null && _value.childList.length > 0){
				_li1 = buildChildMenu(_value.childList,_a1,_li1,Number(_value.level) + 1);   //递归调用
			}
			else{
				_li1.append(_a1);
			}
			
			_ul.append(_li1);
			
			_i++;   //图标+1
			
		});
		_li.append(_ul);
		return _li;
	};
	
	/**
	 * 获取功能性菜单图标
	 */
	function getFunClass(isFun){
		
		if(isFun == null){
			return "fa-angle-double-right";
		}
		return fas[_i];
	}
	
	/**
	 * 获取菜单级别  目前菜单最多四级，再多菜单级别用户体验可能不是特别好
	 */
	function getLevelClass(level){
		var _class = "";
		switch(level){
			case 2: _class = "nav-second-level";break;
			case 3: _class = "nav-third-level";break;
			case 4: _class = "nav-fourth-level";break;
		};
		return _class;
	}
	
	/**
	 * 设置当前导航栏
	 */
	function setSidebarActive(){
		var _activeMenuCode = getActiveMenuCode();
		var _ul = $(".nav-second-level");
		for(var i = 0 ; i < _ul.length ; i++){
			var ul = _ul.eq(i);
			setLiActive(ul,_activeMenuCode);
		}
	}
	
	function setLiActive(ul,activeMenuCode){
		var _li = ul.children("li");
		for(var j = 0 ; j < _li.length ; j++){
			var _child = _li.eq(j).children("ul");
			if(_child != null && _child.length > 0){
				setLiActive(_child,activeMenuCode);
			}
			else{
				var _a = _li.eq(j).children("a");
				if(activeMenuCode == _a.attr("id")){    //menuCode 找到，向上设置active
					$("#side-menu .active").removeClass("active");
					_a.parents("li").addClass("active");
					break;
				}
			}
		}
	}
	
	/**
	 * 获取当前活动的menuCode
	 */
	function getActiveMenuCode(){
		var menuCode = getQueryString("menuCode");    //从URL参数中获取menuCode
		if(isEmpty(menuCode)){    //menuCode未空，从后台中获取
//			menuCode = getMenuCode();
		}
		return menuCode;
	}
	
	/**
	 * 从URL中获取指定参数
	 */
	function getQueryString(name) { 
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
		var r = window.location.search.substr(1).match(reg); 
		if (r != null) return unescape(r[2]); return null; 
	} 
	
	function getMenuCode(){
		var pathName  = window.location.pathname;
		var _actions = pathName.split("/");
		var _action = _actions[_actions.length - 1];
		var menuCode = "";
		$.ajax({
			async:false,   //使用同步机制，只有当该ajax请求完之后才能执行以后函数
			type : "POST",
			url : '../login/queryMenuCodeByUrl.action?url=' + _action,
			dateType : "json",
			success : function(date) {
				menuCode = date.menuCode; 
			}
		});
		return menuCode;
	}
	
	function toFunMenu(url){
		var _frame = $(window.parent.document).find("#mainFrame");
		_frame.attr("src",url);
	}
	
