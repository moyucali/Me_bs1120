<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色列表</title>
<!-- 加载bootStrap，Jquery配置文件 -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/Content/bootstrap/css/bootstrap.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/Content/bootstrap-table/bootstrap-table.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/Content/bootstrap3-editable/css/bootstrap-editable.css">
<script src="<%=request.getContextPath()%>/Static/jQuery/jquery.min.js"></script>
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
var QueryUrl="http://localhost:8080/<%=request.getContextPath()%>/role/queryAll";
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
								uniqueId : "rid", //每一行的唯一标识，一般为主键列
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
							           fileName: '角色表',  //文件名称设置  
							           worksheetName: 'sheet1',  //表格工作区名称  
							           tableName: '角色表',  
							           excelstyles: ['background-color', 'color', 'font-size', 'font-weight']
							       }, 
								onPageChange : function(number, size) {
									pageNum = number;
								},
								onClickRow : function(row, $element, field) {
									// memberID = row.id;
									curRow = row;
									curRow.newField = field;
									//alert("rowData:" + JSON.stringify(curRow));
								},
								onLoadSuccess : function(aa, bb, cc) {
									$("#tb_Table a")
											.editable(
													{
														url : function(params) {
															//alert("editData:" + JSON.stringify(params.value));
															curRow[curRow.newField] = params.value;
															// alert("rowData:" + JSON.stringify(curRow));
															delete curRow.newField;
															$
																	.ajax({
																		type : 'POST',
																		url : "update",
																		data : curRow,
																		dataType : 'JSON',
																		success : function(
																				data) {
																		},
																		error : function() {
																		}
																	});
														},
														type : 'text'
													});
								},
								columns : [
										{
											checkbox : true
										},
										{
											field : 'rowId',
											title : '序号',
											width : 120,
											align : 'center',
											formatter : function(value, row,
													index) {
												row.rowId = index;
												return index + 1;
											}
										},
										{
											field : 'rid',
											title : '角色ID'
										},
										{
											field : 'rname',
											title : '角色名',
											formatter : function(value, row,
													index) {
												if(row.rid=="1" || row.rid=="2"){
													return value;
												}
												var strHtml = '<a class="editable editable-click">'
														+ value + '</a>';
												return strHtml;
											}
										},
										{
											field : 'rdescribe',
											title : '角色描述',
											formatter : function(value, row,
													index) {
												var strHtml = '<a class="editable editable-click">'
														+ value + '</a>';
												return strHtml;
											}
										}, ]
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

	//赋予表格可编辑状态
	$().ready(function() {
		//$.fn.editable.defaults.mode = 'inline'; //行内进行编辑.
		$.fn.editable.defaults.showbuttons = true; //不显示按钮组.
		$.fn.editable.defaults.onblur = "submit"; //当焦点离开时以提交处理,默认是取消.
		$.fn.editable.defaults.validate = function(value) { //字段验证
			if (!$.trim(value)) {
				return '表格不能为空';
			}
		}
		//点击单元格既进行编辑
		$('#tb_Table').on('click', 'td:has(.editable)', function(e) {

			e.stopPropagation(); // 阻止事件的冒泡行为

			$(this).find('.editable').editable('show'); // 打开被点击单元格的编辑状态
		});
	});

	//添加按钮操作
	$().ready(function() {
		$('#btn_add').click(function() {
			$.ajax({
				type : 'GET',
				url : "add",
				data : "",
				dataType : 'JSON',
				success : function(data) {

				},
				error : function() {
				}
			});
            setTimeout(function(){
            	$('#tb_Table').bootstrapTable
            	('refresh', {url: QueryUrl });
			}, 100);
		});
	});

	$().ready(function() {
		$("#btn_delete").click(function() {
			//删除时先获取选择行
			var rows = $('#tb_Table').bootstrapTable('getSelections');
			var cj=true;
			for (var i = 0; i < rows.length; i++) {
				if(rows[i].rid =="1" || rows[i].rid =="2"){
					cj=false;
				}
			}
			
			//选择要删除的行
			if (rows.length > 0 && cj==true) {
				var r = confirm("您确定要删除吗")
				if (r) {
					$(":checked").parent().parent().fadeOut("show");
					//alert("rowData:"+JSON.stringify(rows));
					var ids = [];
					for (var i = 0; i < rows.length; i++) {
						ids.push(rows[i].rid);
					}
					//将选择到的行存入数组并用,分隔转换成字符串，
					ids = ids.join(',');
					// alert(ids);
					//开始传到后台
					var param = {
						"ids" : ids
					};
					$.ajax({
						async : false,
						url : "del",
						type : "POST",
						data : param,
						success : function(data) {
						}
					});
		            setTimeout(function(){
		            	$('#tb_Table').bootstrapTable
		            	('refresh', {url: QueryUrl });
					}, 200);
				}

			} else {
				if(cj==false){alert("超级管理员&普通管理员禁止被删除，请重新选择")}
				if(rows.length <= 0){alert("请选择要删除的行");}
			}
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
	border-radius: 10px;

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
			<button id="btn_add" type="button" class="btn btn-default">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
			</button>
			<button id="btn_delete" type="button" class="btn btn-default">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>批量删除
			</button>
			<font style="color:red;	font-family: monospace;font-size: 12px;">注:仅可对超级管理员以外的角色执行删除操作</font>
		</div>
		<table id="tb_Table"></table>
	</div>


</body>


</html>
