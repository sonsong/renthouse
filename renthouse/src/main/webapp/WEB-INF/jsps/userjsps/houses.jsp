<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>松子直租 | 条件查找</title>

    <!--导入bootstrap css-->
    <link href="/renthouse/js/bootstrap/dist/css/bootstrap.css" rel="stylesheet">
    <!--自定义样式-->
    <link href="/renthouse/css/user/common.css" rel="stylesheet">
    <link href="/renthouse/css/user/font-awesome.min.css" rel="stylesheet">
    <link href="/renthouse/css/user/style.css" rel="stylesheet">
    <link href="/renthouse/css/user/reset.css" rel="stylesheet">
    
    <link rel="icon" href="/renthouse/img/songzi.png" type="image/x-icon"/>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>

<jsp:include page="/WEB-INF/jsps/userjsps/ttop.jsp"/>
<!--头部-->
<jsp:include page="/WEB-INF/jsps/userjsps/top.jsp"/>
    <div class="container">
        <br>
        <div class="row">
            <div class="col-sm-1"></div>
            <div class="col-sm-10">
                <div style="width:946px; margin:0 auto;">
                    <div class="clearfix">
                        <p class="shaixuan-tj floatLeft clearfix">
                            <span><a href="/">全部结果</a></span>
                            <i class="icon-angle-right"></i>
                            <span><strong>"松子直租"</strong></span>
                            <i class="icon-angle-right"></i>
                        </p>
                        <p id="sxbtn" class="shaixuan-btn clearfix"><span><em>收起筛选</em><i class="icon-angle-up"></i></span></p>
                    </div>
                    <div id="page-search-store" class="mb10 border sxcon">
                        <div class="search-by by-category relative">
                            <dl class="relative clearfix">
                                <dt class="floatLeft"><a href="/">居住类型：</a></dt>
                                <dd class="floatLeft show-con">
                                    <a href="/" class="">合租</a>
                                    <a href="/" class="">整租</a>
                                </dd>
                            </dl>
                            <dl class="relative clearfix" style="border-bottom:0">
                                <dt class="floatLeft"><a href="/">出租类型：</a></dt>
                                <dd class="floatLeft show-con">
                                    <a href="/" class="">日租</a>
                                    <a href="/" class="">月租</a>
                                    <a href="/" class="">长租</a>
                                </dd>
                            </dl>
                            <dl class="relative clearfix" style="border-bottom:0">
                                <dt class="floatLeft"><a href="/">位置：</a></dt>
                                <dd class="floatLeft show-con">
                                    <a href="/" class="">浦东新区</a>
                                    <a href="/" class="">长宁区</a>
                                    <a href="/" class="">松江区</a>
                                    <a href="/" class="">青山湖区</a>
                                    <a href="/" class="">新建区</a>
                                    <a href="/" class="">西湖区</a>
                                </dd>
                            </dl>
                            <dl class="relative clearfix" style="border-bottom:0">
                                <dt class="floatLeft"><a href="/">价格：</a></dt>
                                <dd class="floatLeft show-con">
                                    <a href="/" class="">0-1000</a>元
                                    <a href="/" class="">1000-1500</a>元
                                    <a href="/" class="">1500-2000</a>元
                                    <a href="/" class="">2500-3000</a>元
                                    <a href="/" class="">3000以上</a>
                                </dd>
                            </dl>
                            <dl class="relative clearfix" style="border-bottom:0">
                                <dt class="floatLeft"><a href="/">居室：</a></dt>
                                <dd class="floatLeft show-con">
                                    <a href="/" class="">1室</a>
                                    <a href="/" class="">2室</a>
                                    <a href="/" class="">3室</a>
                                    <a href="/" class="">4室</a>
                                </dd>
                            </dl>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-sm-1"></div>
        </div>
    </div>
    <br>
    <div class="container-fluid">
        <div id="house"></div>
    </div>
    <!--底部-->
<jsp:include page="/WEB-INF/jsps/userjsps/bottom.jsp"/>
</body>

<!--导入jQuery-->
<script src="/renthouse/js/jquery-1.8.3.min.js"></script>
<!-- 导入bootstrap js支持-->
<script src="/renthouse/js/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="/renthouse/js/user/houses.js"></script>、
<script>
	var url = '${url}';
</script>
</html>