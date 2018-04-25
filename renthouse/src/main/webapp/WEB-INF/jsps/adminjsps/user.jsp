<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
    
    <link href="/renthouse/css/admin/bootstrap-table.min.css" rel="stylesheet" />
    <link rel="icon" href="/renthouse/img/songzi.png" type="image/x-icon"/>
    <link href="/renthouse/js/jquery.datetimepicker.css" rel="stylesheet">
    <style>
    	.curtime{
    		color:white;
    		margin-right:630px;
    		font-size: 18px;
    	}
    	.curtime:hover{
    		cursor: pointer;
    		color: yellow;
    	}

    </style>
</head>

<body>
    <div id="wrapper">
        <jsp:include page="/WEB-INF/jsps/adminjsps/nav_top.jsp"/>
        <jsp:include page="/WEB-INF/jsps/adminjsps/nav_left.jsp"/>
        
		<div id="page-wrapper">
		  	<div class="header"> 
				<ol class="breadcrumb">
				  <li><a href="/admin/skipAdminIndexPage.action">首页</a></li>
				  <li><a class="active">用户管理</a></li>
				</ol>
									
			</div>
            <div id="page-inner">
            	<div id="search">
            		<div class="row">
            			<form class="form-horizontal" style="border: 1px solid #5bc0de;border-radius: 10px">
            				<div style="background:#5bc0de; color:white; font-size: 18px; padding: 10px 0; border-radius: 10px"">
            					<span style="margin-left:10px">查询条件</span>
            				</div>
            				<br>
							<div class="form-group">
								<label for="uname" class="col-sm-2 control-label">登录名:</label>
								<div class="col-sm-2">
									<input type="text" class="form-control" id="uname" name="uname" value=""> 
								</div>
								
								<label for="cname" class="col-sm-1 control-label">签约名:</label>
								<div class="col-sm-2">
									<input type="text" class="form-control" id="cname" name="cname" value=""> 
								</div>
								
								<label for="ctele" class="col-sm-1 control-label">联系方式:</label>
								<div class="col-sm-2">
									<input type="text" class="form-control" id="ctele" name="ctele" value=""> 
								</div>
							</div>
							<div class="form-group">
								
								<label for="cid" class="col-sm-2 control-label">合同编码:</label>
								<div class="col-sm-2">
									<input type="text" class="form-control" id="cid" name="cid" value=""> 
								</div>
								
								<label for="rid" class="col-sm-1 control-label">租客编码:</label>
								<div class="col-sm-2">
									<input type="text" class="form-control" id="rid" name="rid" value=""> 
								</div>
								
								<label for="hid" class="col-sm-1 control-label">房源编码:</label>
								<div class="col-sm-2">
									<input type="text" class="form-control" id="hid" name="hid" value=""> 
								</div>
								
								<div class="col-sm-2 text-left">
									<input type="button" class="btn btn-info" id="query" value="查询" style="width:100px"> 
								</div>
							</div>
						</form>
            		</div>
            	</div>
            	<br>
            	<div id="table"></div> 
				<jsp:include page="/WEB-INF/jsps/adminjsps/footer.jsp"/>
            </div>
            <!-- /. PAGE INNER  -->
        </div>
        <!-- /. PAGE WRAPPER  -->
    </div>
    <!-- /. WRAPPER  -->
    
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
    <script src="/renthouse/js/admin/table_user.js"></script>
    <script type="text/javascript" src="/renthouse/js/jquery.datetimepicker.full.min.js"></script>
    
    <script>
    	$(function(){
    		setInterval("curtime.innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt (new Date().getDay());",1000);
			$("#query").bind("click", function(){
				$("#table").bootstrapTable('refresh');
			});
    	})
    </script>
</body>

</html>