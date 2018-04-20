// 对应table标签的id
$("#table")
		.bootstrapTable(
				{
					// 获取表格数据的url
					url : "/admin/queryAllBills.action",
					toolbar : '#toolbar',
					// 设置为 false 禁用 AJAX 数据缓存， 默认为true
					cache : false,
					// 表格显示条纹，默认为false
					striped : true,
					// 在表格底部显示分页组件，默认false
					pagination : true,
					// 设置页面可以显示的数据条数
					pageList : [ 5, 10, 20 ],
					// 页面数据条数
					pageSize : 5,
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
						}
					},
					// 要排序的字段
					sortName : 'btime',
					// 排序规则
					sortOrder : 'desc',
					columns : [
							{
								field : 'user.uname',
								title : '登录名',
								align : 'center',
								valign : 'middle',
								width: 200
							},
							{
								field : 'btime',
								title : '创建时间',
								align : 'center',
								valign : 'middle',
								width: 200
							},
							{
								field : 'bdue',
								title : '收款原因',
								align : 'center',
								valign : 'middle',
								width: 200
							},
							{
								field : 'bprice',
								title : '金额',
								align : 'center',
								valign : 'middle',
								width: 200
							},
							{
								field : 'isPay',
								title : '是否支付',
								align : 'center',
								valign : 'middle',
								width: 200
							},
							{
								title : "操作",
								align : 'center',
								valign : 'middle',
								width: 200,
								formatter : function(value, row, index) {
									/*return '<button class="btn btn-warning btn-sm sign" onclick="sign(\''
											+ row.aid + ',' + row.aname + ',' + row.user.uid + ',' + row.atele + ',' + row.house.hid + "," + row.house.hprice 
											+ '\')">生成合同</button>&nbsp;&nbsp;<button class="btn btn-danger btn-sm cancel" onclick="cancel(\''
											+ row.aid + ',' + row.aname + ',' + row.atele + ','+ row.antime + '\')">取消预约</button>';*/
									return "";
								}
							} ],
					onLoadSuccess : function() { // 加载成功时执行
						console.info("加载成功");
					},
					onLoadError : function() { // 加载失败时执行
						console.info("加载数据失败");
					}
				});

// 签约
function sign(aid) {
	$(".sign").attr("data-toggle", "modal").attr("data-target", "#myModal2");
	var params = aid.split(",");
	$("#appid").val(params[0]);
	//预约人
	$("#cname").val(params[1]);
	//登录用户编码
	$("#uid").val(params[2]);
	//联系方式
	$("#ctele").val(params[3]);
	//房源信息
	$("#hid").val(params[4]);
	$("#cmoney").val(params[5]);
}
// 取消预约
function cancel(aid) {
	$(".cancel").attr("data-toggle", "modal").attr("data-target", "#myModal1");
	var params = aid.split(",");
	$("#aid").val(params[0]);
	$("#name").val(params[1]);
	$("#atele").val(params[2]);
	$("#antime").val(params[3]);
}
