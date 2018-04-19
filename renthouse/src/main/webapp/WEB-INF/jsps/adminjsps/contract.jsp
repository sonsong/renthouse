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
					<li><a class="active">租客合同管理</a></li>
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

	<!-- 取消预约弹出框 -->
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
							<input type="hidden" name="aid" id="aid" /> <input type="hidden"
								name="name" id="name" /> <input type="hidden" name="atele"
								id="atele" /> <input type="hidden" name="antime" id="antime" />
							<div class="form-group">
								<label for=isConnect class="col-sm-2 control-label">是否联系:</label>
								<div class="col-sm-8">
									<select name="isConnect" class="form-control"
										style="width: 40%">
										<option value="0">未联系</option>
										<option value="1">已联系</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label for=resaon class="col-sm-2 control-label">取消原因:</label>
								<div class="col-sm-8">
									<textarea rows="4" cols="75" name="reason" id="reason"
										class="form-control"></textarea>
									<span id="error" style="color: red"></span>
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
	<!-- 生成合同弹出框 -->
	<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 id="" class="modal-title" id="myModalLabel">生成合同</h4>
				</div>
				<br>
				<div class="row">
					<div class="col-sm-1"></div>
					<div class="col-sm-10">
						<form action="/admin/addContract.action" method="post" id="form1"
							class="form-horizontal">
							
							<input type="hidden" name="aid" id="appid" />
							<input type="hidden" name="hid" id="hid" />
							<input type="hidden" name="uid" id="uid" />
							
							<div class="form-group">
							
								<label for="cname" class="col-sm-2 control-label">姓名(乙方):</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" id="cname" name="cname" value="${contract.cname }"> 
									<span id="cname_tip" style="color: red"></span>
								</div>
								
								<label for="ctele" class="col-sm-2 control-label">电话(乙方):</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" id="ctele" name="ctele" value="${contract.ctele }"> 
									<span id="ctele_tip" style="color: red"></span>
								</div>
								
							</div>
							
							<div class="form-group">
							
								<label for="ccompany" class="col-sm-2 control-label">公司(甲方):</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" id="ccompany" name="ccompany" value="松子直租" readonly="readonly"> 
								</div>
								
								<label for="ccompanytele" class="col-sm-2 control-label">电话(甲方):</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" id="ccompanytele" name="ccompanytele" value="18279185736" readonly="readonly"> 
								</div>
								
							</div>
							
							<div class="form-group">
							
								<label for="cstime" class="col-sm-2 control-label">签约时间:</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" id="cstime" name="cstime" value="${contract.cstime }"> 
									<span id="cstime_tip" style="color: red"></span>
								</div>
								
								<label for="cetime" class="col-sm-2 control-label">到期时间:</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" id="cetime" name="cetime" value="${contract.cetime }"> 
									<span id="cetime_tip" style="color: red"></span>
								</div>
								
							</div>
							
							<div class="form-group">
							
								<label for="cpaytype" class="col-sm-2 control-label">付款方式:</label>
								<div class="col-sm-4">
									<select id="select1" class="form-control" name="cpaytype">
										<option value="2">请选择付款方式</option>
										<option value="0">月付</option>
										<option value="1">年付</option>
									</select>
									<span id="cpaytype_tip" style="color: red"></span>
								</div>
								
								<label for="cpaytime" class="col-sm-2 control-label">交租时间:</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" id="cpaytime" name="cpaytime" value="${contract.cpaytime }"> 
									<span id="cpaytime_tip" style="color: red"></span>
								</div>
								
							</div>
						
							<div class="form-group">
							
								<label for="ccashtype" class="col-sm-2 control-label">押金方式:</label>
								<div class="col-sm-4">
									<select id="select2" class="form-control" name="ccashtype">
										<option value="2">请选择押金方式</option>
										<option value="0">押一付一</option>
										<option value="1">押一付三</option>
									</select>
									<span id="cpaytype_tip" style="color: red"></span>
								</div>
								
								<label for="ccash" class="col-sm-2 control-label">押金:</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" id="ccash" name="ccash" value="${contract.ccash}"> 
									<span id="ccash_tip" style="color: red"></span>
								</div>
								
							</div>
							
							<div class="form-group">
							
								<label for="cmoney" class="col-sm-2 control-label">租金:</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" id="cmoney" name="cmoney" value="${contract.cmoney }"> 
									<span id="cmoney_tip" style="color: red"></span>
								</div>
								
								<label for="crtime" class="col-sm-2 control-label">租期:</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" id="crtime" name="crtime" value="${contract.crtime }"> 
									<span id="crtime_tip" style="color: red"></span>
								</div>
								
							</div>
							
							<div class="modal-footer">
								<input type="button" class="btn btn-danger" data-dismiss="modal"
									value="关闭"> <a class="btn btn-info"
									id="addContract">生成合同</a>
							</div>
						</form>
					</div>
					<div class="col-sm-1"></div>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>

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
	<script src="/renthouse/js/admin/table_contract.js"></script>
	<script type="text/javascript" src="/renthouse/js/modalMsg.js"></script>

	<script>
		$("#reason").val("");
		$(function() {
			//时间选择器
			$.datetimepicker.setLocale('ch');
			$("#cstime").datetimepicker({
				format: "Y-m-d h:i",
			});
			$("#cetime").datetimepicker({
				format: "Y-m-d h:i",
			});
			//时间
			setInterval(
					"curtime.innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt (new Date().getDay());",
					1000);
			$(".form-control").focus(function() {
				$("#error").text("");
			});
			//取消预约校验
			$("#cancelAppoint").bind("click", function() {
				var bool = true;

				var val = $("#reason");
				if (val == null || $.trim(val).length == 0) {
					$("#error").text("取消原因必须填写");
					bool = false;
				}

				if (bool) {
					$("#form").submit();
				}
			});
			//生成合同
			$("#addContract").bind("click", function(){
				$("#form1").submit();
			});
		})
	</script>
</body>

</html>