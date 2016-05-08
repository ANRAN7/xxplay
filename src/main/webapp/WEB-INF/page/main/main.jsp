<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <%@include file="../../page/include/include_base_css.jsp" %>
</head>

<body class="">
    <div>
    	<!-- begin 顶部 -->
        <%@include file="../../page/include/include_header.jsp" %>
        <!-- end 顶部 -->
        <!-- begin 主题内容-->
        <div id="wrapper">
            <!--begin 导航栏-->
            <%@include file="../../page/include/include_sidebar.jsp" %>
            <!--end 导航栏-->
            <!--begin 内容-->
            <div id="page-wrapper">
                <!--begin 当前位置-->
                <div id="title-breadcrumb-option-demo" class="page-title-breadcrumb">
                    <div class="page-header pull-left" style="display: none">
                        <div class="page-title">当前位置</div>
                    </div>
                    <ol class="breadcrumb page-breadcrumb pull-left" id="page_crumb">
                    </ol>
                    <div class="btn btn-blue reportrange" style="display: none"><i class="fa fa-calendar"></i>&nbsp;<span></span>&nbsp;report&nbsp;<i class="fa fa-angle-down"></i>
                        <input type="hidden" name="datestart" />
                        <input type="hidden" name="endstart" />
                    </div>
                    <div class="clearfix"></div>
                </div>
                <!-- end 当前位置-->
                <!--begin 页面内容-->
                <div class="page-content">
                	<div class="tab-general">
                		<iframe src="##"  id="mainFrame" width=100%  name="mainFrame" scrolling="no" onLoad="sizeChange()"></iframe>
                	</div>
   				 </div>
    		<!--end 内容-->
    		</div>
    		<!--begin 页面底部-->
    		<%@include file="../../page/include/include_footer.jsp" %>
    		<!--end 页面底部-->
    		<!--end 页面主体内容-->
    		<%@include file="../../page/include/include_modals_showDetail.jsp" %>
    	</div>
    </div>
    <%@include file="../../page/include/include_base_js.jsp" %>
</body>
<script type="text/javascript">
	/**
	 * 打开modal窗口
	 */
	function openModal(title,url,width){
		$.jModal({
			modelId:"showDetailModal",
			title:title,
			remote:url,
			width:width
		});
	}
	
	function closeModal(){
		$("#showDetailModal").modal('toggle');
	}
</script>
</html>