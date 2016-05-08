/**
 * bootstrap 警告窗口辅助js
 * autor:chenming
 * date:2015-05-18
 */
(function ($) {
	jQuery.extend({
      jAlert:function (setting) {
    	  var options = $.extend({
    		  //model Id
    		  modelId:"alertModal",
              //警告内容
              content:"",
              //键盘上的 esc 键被按下时关闭模态框。默认false
              keyboard:false,
              //模态框初始化之后就立即显示出来。默认true
              show:true
          }, setting);
    	  
    	  //基本参数设定
    	  var _modelId = options.modelId;
    	  var _content = options.content;
    	  var _keyboard = options.keyboard;
    	  var _show = options.show;
    	  /**
    	   * bootstrap加载页面时只会加载一次，哪怕remote的链接变化，modal窗口都不会重新加载
    	   * 解决办法就是在加载数据前将页面进行隐藏
    	   */
    	  $("#" + _modelId).on("hidden.bs.modal", function() {
    		    $(this).removeData("bs.modal");
    		});
    	  
    	  //设置内容
    	  $("#" + _modelId).find("#modal-content").html(_content);
    	  
    	  //显示模态窗口
    	  $("#" + _modelId).modal({
    		    show:_show,
    		    keyboard:_keyboard
    		});
      }
	});
})(jQuery);