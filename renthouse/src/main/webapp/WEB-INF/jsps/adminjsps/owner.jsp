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
	margin-right:330px;
	font-size: 18px;
}

.curtime:hover {
	cursor: pointer;
	color: yellow;
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
					<li><a class="active">房东管理</a></li>
				</ol>

			</div>
			<div id="page-inner">
				<div id="search">
					<div class="row">
						<form class="form-horizontal"
							style="border: 1px solid #5bc0de; border-radius: 10px">
							<div
								style="background: #5bc0de; color: white; font-size: 18px; padding: 10px 0; border-radius: 10px"">
								<span style="margin-left: 10px">查询条件</span>
							</div>
							<br>
							<div class="form-group">

								<label for="cname" class="col-sm-3 control-label">房东名:</label>
								<div class="col-sm-2">
									<input type="text" class="form-control" id="oname" name="cname"
										value="">
								</div>

								<label for="ctele" class="col-sm-1 control-label">手机号:</label>
								<div class="col-sm-2">
									<input type="text" class="form-control" id="otele" name="ctele"
										value="">
								</div>
								<div class="col-sm-2 text-left">
									<input type="button" class="btn btn-info" id="query" value="查询"
										style="width: 100px">
								</div>
							</div>
						</form>
					</div>
				</div>
				<br>
				<div id="table"></div>
				<jsp:include page="/WEB-INF/jsps/adminjsps/footer.jsp" />
			</div>
			<!-- /. PAGE INNER  -->
		</div>
		<!-- /. PAGE WRAPPER  -->
	</div>
	<!-- /. WRAPPER  -->

	<!-- 生成合同弹出框 -->
	<div class="modal fade" id="myModal1" tabindex="-1" role="dialog"
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
						<form action="/admin/addOwnerContract.action" method="post" id="form1"
							class="form-horizontal">

							<input type="hidden" name="oid" id="oid" /> 
							<input type="hidden" name="hid" id="hid" /> 

							<div class="form-group">

								<label for="cname" class="col-sm-2 control-label">姓名(乙方):</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" id="cname" name="cname"
										value=""> <span id="cname_tip"
										style="color: red"></span>
								</div>

								<label for="ctele" class="col-sm-2 control-label">电话(乙方):</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" id="ctele" name="ctele"
										value=""> <span id="ctele_tip"
										style="color: red"></span>
								</div>

							</div>

							<div class="form-group">

								<label for="ccompany" class="col-sm-2 control-label">公司(甲方):</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" id="ccompany"
										name="ccompany" value="松子直租" readonly="readonly">
								</div>

								<label for="ccompanytele" class="col-sm-2 control-label">电话(甲方):</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" id="ccompanytele"
										name="ccompanytele" value="18279185736" readonly="readonly">
								</div>

							</div>

							<div class="form-group">

								<label for="cstime" class="col-sm-2 control-label">签约时间:</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" id="cstime"
										name="cstime" value="${ownerContract.cstime }"> <span
										id="cstime_tip" style="color: red"></span>
								</div>

								<label for="cetime" class="col-sm-2 control-label">到期时间:</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" id="cetime"
										name="cetime" value="${ownerContract.cetime }"> <span
										id="cetime_tip" style="color: red"></span>
								</div>

							</div>

							<div class="form-group">

								<label for="cmoney" class="col-sm-2 control-label">租金:</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" id="cmoney"
										name="cmoney" value="${ownerContract.cmoney }"> <span
										id="cmoney_tip" style="color: red"></span>
								</div>

								<label for="crtime" class="col-sm-2 control-label">租期:</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" id="crtime"
										name="crtime" value="${ownerContract.crtime }"> <span
										id="crtime_tip" style="color: red"></span>
								</div>

							</div>

							<div class="modal-footer">
								<input type="button" class="btn btn-danger" data-dismiss="modal"
									value="关闭"> <a class="btn btn-info" id="addContract">生成合同</a>
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

	<script type="text/javascript"
		src="/renthouse/js/jquery.datetimepicker.full.min.js"></script>
	<script src="/renthouse/js/admin/bootstrap-table.min.js"></script>
	<script src="/renthouse/js/admin/bootstrap-table-zh-CN.min.js"></script>
	<script src="/renthouse/js/admin/table_owner.js"></script>
	<script type="text/javascript" src="/renthouse/js/modalMsg.js"></script>

	<script>
		$(function() {
			//时间选择器
			  $.datetimepicker.setLocale("ch");
			  $("#cstime").datetimepicker({
			    format: "Y-m-d H:i"
			  });
			  $("#cetime").datetimepicker({
			    format: "Y-m-d H:i"
			  });
			$("#form1 .form-control").focus(function() {
			    $("#" + $(this).attr("name") + "_tip").text("");
			    $(this).css("border", "null");
			  });
			
		  //生成合同
		  $("#addContract").bind("click", function() {
		    var bool = true;

		    $("#form1 .form-control").each(function() {
		      if ($(this).val() === null || $.trim($(this).val()).length == 0) {
		        bool = false;
		        var id = $(this).attr("id");
		        $(this).css("border", "1px solid red");
		        $("#" + id + "_tip").text("该项信息是必填项");
		      } else {
		        //不是空，校验押金必须是数字
		        if ($(this).attr("id") === "ccash") {
		          //必须都为数字
		          if (!/^[0-9]*[1-9][0-9]*$/.test($("#" + $(this).attr("id")).val())) {
		            bool = false;
		            $(this).css("border", "1px solid red");
		            $("#" + $(this).attr("id") + "_tip").text("押金必须填写数字");
		          }
		        }
		      }
			  });
		    if (bool) {
		      $("#form1").submit();
		    }
		  	});
		  	
			//table从新发送请求
			$("#query").bind("click", function() {
				$("#table").bootstrapTable('refresh');
			});
			
			//时间
			setInterval(
					"curtime.innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt (new Date().getDay());",
					1000);
		});
	</script>
</body>

</html>