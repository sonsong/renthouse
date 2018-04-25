// 对应table标签的id
$("#table").bootstrapTable({
	// 获取表格数据的url
	url : "/admin/queryUsers.action",
	// 设置为 false 禁用 AJAX 数据缓存， 默认为true
	cache : false,
	// 表格显示条纹，默认为false
	/* striped : true, */
	/* showRefresh : true, */
	// 在表格底部显示分页组件，默认false
	pagination : true,
	// 设置页面可以显示的数据条数
	pageList : [ 5, 10, 20 ],
	// 页面数据条数
	pageSize : 10,
	// 首页页码
	pageNumber : 1,
	// 设置为服务器端分页
	// 后台页面需要进行分页，返回total（总数）和rows（条件下的记录数）
	sidePagination : 'server',
	// 请求服务器数据时发送的参数，可以在这里添加额外的查询参数，返回false则终止请求
	queryParams : function(params) {
		return {
			// 每页要显示的数据条数
			ps : params.limit,
			// 每页显示数据的开始行号
			offset : params.offset,
			// 要排序的字段
			sort : params.sort,
			// 排序规则
			sortOrder : params.order,
			uname : $.trim($("#uname").val()),
			cname : $.trim($("#cname").val()),
			ctele : $.trim($("#ctele").val()),
			cid : $.trim($("#cid").val()),
			hid : $.trim($("#hid").val()),
			rid : $.trim($("#rid").val()),
		}
	},
	// 要排序的字段
	sortName : 'uid',
	// 排序规则
	sortOrder : 'desc',
	columns : [ {
		field : 'uid',
		title : '用户编码',
		align : 'center',
		valign : 'middle',
		width : 300
	}, {
		field : 'uname',
		title : '登录名',
		align : 'center',
		valign : 'middle',
		width : 300
	}, {
		field : 'cname',
		title : '签约名',
		align : 'center',
		valign : 'middle',
		width : 300
	},{
		field : 'utele',
		title : '联系方式',
		align : 'center',
		valign : 'middle',
		width : 300
	}, {
		field : 'uemail',
		title : '电子邮件',
		align : 'center',
		valign : 'middle',
		width : 300
	},{
		field : 'contracts.cid',
		title : '合同编码',
		align : 'center',
		valign : 'middle',
		width : 300
	}, {
		field : 'renters.rid',
		title : '租客编码',
		align : 'center',
		valign : 'middle',
		width : 300
	}, {
		field : 'houses.hid',
		title : '房源编码',
		align : 'center',
		valign : 'middle',
		width : 300
	}],
	onLoadSuccess : function() { // 加载成功时执行
		console.info("加载成功");
	},
	onLoadError : function() { // 加载失败时执行
		console.info("加载数据失败");
	}
});