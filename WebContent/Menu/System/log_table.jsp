<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员列表</title>
<!-- 加载bootStrap，Jquery配置文件 -->
<!-- 加载bootStrap，Jquery配置文件 -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/Content/bootstrap/css/bootstrap.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/Content/bootstrap-table/bootstrap-table.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/Content/bootstrap3-editable/css/bootstrap-editable.css">
<script src="http://libs.baidu.com/jquery/1.9.1/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/Content/bootstrap/js/bootstrap.js"></script>
<script src="<%=request.getContextPath()%>/Content/bootstrap-table/bootstrap-table.js"></script>
<script
	src="<%=request.getContextPath()%>/Content/bootstrap-table-export.js"></script>
<script
	src="<%=request.getContextPath()%>/Content/tableExport/tableExport.min.js"></script>
<script
	src="<%=request.getContextPath()%>/Content/bootstrap3-editable/js/bootstrap-editable.js"></script>
<script
	src="<%=request.getContextPath()%>/Content/bootstrap-table/locale/bootstrap-table-zh-CN.js"></script>
<script type="text/javascript">
	var QueryUrl="http://localhost:8080/<%=request.getContextPath()%>/log/queryAll";
	$(function() {	
		//1.初始化Table
		var oTable = new TableInit();
		oTable.Init();

		//2.初始化Button的点击事件
		var oButtonInit = new ButtonInit();
		oButtonInit.Init();

	});

	var TableInit = function() {
		var oTableInit = new Object();
		//初始化Table
		oTableInit.Init = function() {
			//alert("oTableInit.Init");
			$('#tb_Table')
					.bootstrapTable(
							{
								url : QueryUrl, //请求后台的URL（*）
								method : 'get', //请求方式（*）
								toolbar : '#toolbar', //工具按钮用哪个容器
								striped : true, //是否显示行间隔色
								cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
								pagination : true, //是否显示分页（*）
								sortable : false, //是否启用排序
								sortOrder : "asc", //排序方式
								queryParams : oTableInit.queryParams,//传递参数（*）
								sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*）
								pageNumber : 1, //初始化加载第一页，默认第一页
								pageSize : 10, //每页的记录行数（*）
								pageList : [ 10, 25, 50, 100 ], //可供选择的每页的行数（*）
								search : true, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
								strictSearch : true,
								showColumns : true, //是否显示所有的列
								showRefresh : true, //是否显示刷新按钮
								minimumCountColumns : 2, //最少允许的列数
								clickToSelect : true, //是否启用点击选中行
								height : 420, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
								uniqueId : "id", //每一行的唯一标识，一般为主键列
								showToggle : true, //是否显示详细视图和列表视图的切换按钮
								cardView : false, //是否显示详细视图
								detailView : false, //是否显示父子表
								editable : true,//开启编辑模式
								showExport: true,  //是否显示导出按钮  
							    buttonsAlign:"right",  //按钮位置  
							    exportTypes:['excel'],  //导出文件类型  
							    Icons:'glyphicon-export', 
							    exportOptions:{  
							           ignoreColumn: [0,1],  //忽略某一列的索引  
							           fileName: '操作日志',  //文件名称设置  
							           worksheetName: 'sheet1',  //表格工作区名称  
							           tableName: '操作日志',  
							           excelstyles: ['background-color', 'color', 'font-size', 'font-weight']
							       },  
								onPageChange: function (number, size) {
					                pageNum = number;
					            },
								onClickRow : function(row,$element, field) {
									curRow = row;
									curRow.newField=field;
								},
								columns : [
										{
											checkbox : true
										},
										{
											field : 'id',
											title : 'ID',
											align : 'center'
										},
										{
											field : 'uname',
											title : '操作者',
											align : 'center',
											formatter : function(value, row,
													index) {
													return value;
											}
										},
										{
											field : 'method',
											title : '操作内容',
											align : 'center',
											formatter : function(value, row,
													index) {
												return value;
											}
										},
										{
											field : 'time',
											title : '时间',
											align : 'center',
											formatter : function(value, row,
													index) {
												return value;
											}
										},
										{
											field : 'explain',
											title : '备注',
											align : 'center',
											formatter : function(value, row,
													index) {
												return value;
											}
										}
										]
							});
		};

		//得到查询的参数
		oTableInit.queryParams = function(params) {
			var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
				limit : params.limit, //页面大小
				offset : params.offset, //页码
				address : $("#txt_search_address").val(),
			};
			return temp;
		};
		return oTableInit;
	};

	var ButtonInit = function() {
		var oInit = new Object();
		var postdata = {};

		oInit.Init = function() {
			//初始化页面上面的按钮事件
		};

		return oInit;
	};
	
	$().ready(function() {
		$("#btn_delete").click(function() {
					$.ajax({
						async : false,
						url : "clear",
						type : "POST",
						data : null,
						success : function(data) {
						}
					});
		            setTimeout(function(){
		            	$('#tb_Table').bootstrapTable
		            	('refresh', {url: QueryUrl });
					}, 200);

		});
	})

</script>

<!--表格样式CSS-->
<style type="text/css">
table {
	border-collapse: collapse;
	border: 1px solid #FFFFFF;
}

table td {
	text-align: center;
	height: 20px;
	font-size: 12px;
	line-height: 30px;
	border: 1px solid #efecec;
	border-radius: 10px
}
</style>
</head>


<body>
	<div class="panel-body" style="padding-bottom: 0px;">
		<div class="panel panel-default">
			<div class="panel-body">
				<form id="formSearch" class="form-horizontal">
					<div class="form-group" style="margin-top: 15px">
						<label class="control-label col-sm-1" for="txt_search_address"></label>
						<div class="col-sm-3" style="float: left;">
							<input type="text" class="form-control" id="txt_search_address">
						</div>
						<div class="col-sm-4" style="text-align: left;">
							<button type="button" style="margin-left: 50px" id="btn_query"
								class="btn btn-primary">查询</button>
						</div>
					</div>
				</form>
			</div>
		</div>

		<div id="toolbar" class="btn-group">
					<button id="btn_delete" type="button" class="btn btn-default">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>清空日志
			</button>
		</div>
		<table id="tb_Table"></table>
	</div>


</body>


</html>
