<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="navbar-default navbar-side" role="navigation">
	<div class="sidebar-collapse">
		<ul class="nav" id="main-menu">

			<li><a class="active-menu"
				href="/admin/skipAdminIndexPage.action"><i
					class="fa fa-dashboard"></i> 仪表盘</a></li>
			<li><a href="/admin/skipHouseManagePage.action"><i
					class="fa fa-desktop"></i> 房源管理</a></li>
			<li><a href="#"><i class="fa fa-sitemap"></i> 预约管理<span
					class="fa arrow"></span></a>
				<ul class="nav nav-second-level">
					<li><a href="/admin/skipJoinAppointPage">业主加盟</a></li>
					<li><a href="/admin/skipAppointPage.action">看房预约</a></li>
				</ul>
			</li>
			<li><a href="#"><i class="fa fa-sitemap"></i> 系统设置<span
					class="fa arrow"></span></a>
				<ul class="nav nav-second-level">
					<li><a href="/admin/skipSysLogPage.action">日志管理</a></li>
					<li><a href="/admin/skipAdminManagePage.action">用户管理</a></li>
				</ul>
			</li>
		</ul>
	</div>
</nav>