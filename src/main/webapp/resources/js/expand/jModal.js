/**
 * bootstrap modal窗口辅助js
 * autor:chenming
 * date:2015-05-18
 */
(function ($) {
	jQuery.extend({
      jModal:function (setting) {
    	  var options = $.extend({
    		  //model Id
    		  modelId:"",
              //model 窗口标题
              title: "",
              //如果提供的是 URL，将利用 jQuery 的 load 方法从此 URL 地址加载要展示的内容（只加载一次）并插入 .modal-content 内
              remote:"",
              //键盘上的 esc 键被按下时关闭模态框。默认false
              keyboard:false,
              //模态框初始化之后就立即显示出来。默认true
              show:true,
              //模态窗口大小
              width:""
          }, setting);
    	  
    	  //基本参数设定
    	  var _modelId = options.modelId;
    	  var _title = options.title;
    	  var _remote = options.remote;
    	  var _keyboard = options.keyboard;
    	  var _show = options.show;
    	  var _width = options.width;
    	  
    	  //设置标题
    	  $("#" + _modelId).find(".modal-header #modal-header-primary-label").html(_title);
    	  //设置宽度
    	  if(_width != null && _width != ""){
    		  $(".modal-lg").width(_width);
    	  }
    	  
    	  /**
    	   * bootstrap加载页面时只会加载一次，哪怕remote的链接变化，modal窗口都不会重新加载
    	   * 解决办法就是在加载数据前将页面进行隐藏
    	   */
    	  $("#" + _modelId).on("hidden.bs.modal", function() {
    		    $(this).removeData("bs.modal");
    		});
    	  //加载数据
    	  $("#" + _modelId).modal({
    		    remote: _remote,
    		    show:_show,
    		    keyboard:_keyboard
    		});
      }
	});
})(jQuery);