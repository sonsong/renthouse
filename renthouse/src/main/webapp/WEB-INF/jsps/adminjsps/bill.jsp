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
<link href="/renthouse/js/jquery.datetimepicker.css" rel="stylesheet">
<style>
.curtime {
	color: white;
	margin-right: 50px;
	font-size: 18px;
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
					<li><a class="active">账单管理</a></li>
				</ol>

			</div>
			<div id="page-inner">
				<div id="table" style=""></div>
				<jsp:include page="/WEB-INF/jsps/adminjsps/footer.jsp" />
			</div>
			<!-- /. PAGE INNER  -->
		</div>
		<!-- /. PAGE WRAPPER  -->
	</div>
	<!-- /. WRAPPER  -->

	<jsp:include page="/WEB-INF/jsps/modal.jsp" />
	<!-- JS Scripts-->
	<!-- jQuery Js -->
	<script src="/renthouse/ht/assets/js/jquery-1.10.2.js"></script>
	<!-- Bootstrap Js -->
	<script src="/renthouse/ht/assets/js/bootstrap.min.js"></script>

	<!-- Metis Menu Js -->
	<script src="/renthouse/ht/assets/js/jquery.metisMenu.js"></script>
	<!-- Custom Js -->
	<script src="/renthouse/ht/assets/js/custom-scripts.js"></script>
	
	<script type="text/javascript" src="/renthouse/js/jquery.datetimepicker.full.min.js"></script>
	<script src="/renthouse/js/admin/bootstrap-table.min.js"></script>
	<script src="/renthouse/js/admin/bootstrap-table-zh-CN.min.js"></script>
	<script src="/renthouse/js/admin/table_bill.js"></script>
	<script type="text/javascript" src="/renthouse/js/modalMsg.js"></script>

	<script>
		$(function(){
			//时间
			setInterval(
					"curtime.innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt (new Date().getDay());",
					1000);
		});
	</script>
</body>

</html>