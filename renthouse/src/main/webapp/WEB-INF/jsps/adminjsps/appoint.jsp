<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>松子直租后台管理系统</title>
<!-- Bootstrap Styles-->
<link href="/renthouse/ht/assets/css/bootstrap.css" rel="stylesheet" />
<!-- FontAwesome Styles-->
<link href="/renthouse/ht/assets/css/font-awesome.css" rel="stylesheet" />
<!-- Custom Styles-->
<link href="/renthouse/ht/assets/css/custom-styles.css" rel="stylesheet" />
<!-- Google Fonts-->
<link href='https://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />

<link href="/renthouse/css/admin/bootstrap-table.min.css"
	rel="stylesheet" />
<link rel="icon" href="/renthouse/img/songzi.png" type="image/x-icon" />
<style>
.curtime {
	color: white;
	margin-right: 300px;
	font-size: 18px;
}

#page-inner {
	height: 0px;
}
</style>
</head>

<body>
	<div id="wrapper">
		<jsp:include page="/WEB-INF/jsps/adminjsps/nav_top.jsp" />
		<jsp:include page="/WEB-INF/jsps/adminjsps/nav_left.jsp" />

		<div id="page-wrapper">
			<div class="header">
				<ol class="breadcrumb">
					<li><a href="/admin/skipAdminIndexPage.action">首页</a></li>
					<li><a class="active">预约管理</a></li>
				</ol>

			</div>
			<div id="page-inner">
				<div id="table"></div>
				<jsp:include page="/WEB-INF/jsps/adminjsps/footer.jsp" />
			</div>
			<!-- /. PAGE INNER  -->
		</div>
		<!-- /. PAGE WRAPPER  -->
	</div>
	<!-- /. WRAPPER  -->

	<div class="modal fade" id="myModal1" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 id="" class="modal-title" id="myModalLabel">取消预约</h4>
				</div>
				<br>
				<div class="row">
					<div class="col-sm-1"></div>
					<div class="col-sm-11">
						<form action="/admin/cancelAppoint.action" method="post" id="form"
							class="form-horizontal">
							<input type="hidden" name="aid" id="aid"/>
							<div class="form-group">
								<label for=isConnect class="col-sm-2 control-label">是否联系:</label>
								<div class="col-sm-8">
									<select name="isConnect" class="form-control" style="width:40%">
										<option value="0">未联系</option>
										<option value="1">已联系</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label for=resaon class="col-sm-2 control-label">取消原因:</label>
								<div class="col-sm-8">
									<textarea rows="4" cols="75" name="resaon" id="resaon"
										class="form-control"></textarea>
									<span id="error" style="color:red"></span>
								</div>
							</div>
							<div class="modal-footer">
								<input type="button" class="btn btn-danger" data-dismiss="modal"
									value="关闭"> <a class="btn btn-danger"
									id="cancelAppoint">取消预约</a>
							</div>
						</form>
					</div>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>

	<!-- JS Scripts-->
	<!-- jQuery Js -->
	<script src="/renthouse/ht/assets/js/jquery-1.10.2.js"></script>
	<!-- Bootstrap Js -->
	<script src="/renthouse/ht/assets/js/bootstrap.min.js"></script>

	<!-- Metis Menu Js -->
	<script src="/renthouse/ht/assets/js/jquery.metisMenu.js"></script>
	<!-- Custom Js -->
	<script src="/renthouse/ht/assets/js/custom-scripts.js"></script>

	<script src="/renthouse/js/admin/bootstrap-table.min.js"></script>
	<script src="/renthouse/js/admin/bootstrap-table-zh-CN.min.js"></script>
	<script src="/renthouse/js/admin/table_appoint.js"></script>

	<script>
		$(function() {
			setInterval(
					"curtime.innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt (new Date().getDay());",
					1000);
		$(".form-control").focus(function(){
			$("#error").text("");
		});
		$("#cancelAppoint").bind("click", function(){
			var bool = true;
			
			var val = $("#reason").val();
			if(val == null || $.trim(val).length == 0){
				$("#error").text("取消原因必须填写");
				bool = false;
			}
			
			if(bool){
				$("#form").submit();
			}
		});
		})
	</script>
</body>

</html>