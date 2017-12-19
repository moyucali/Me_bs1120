<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 加载bootStrap，Jquery配置文件 -->
<link rel="stylesheet" href="Content/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="Content/bootstrap-editable/css/bootstrap-editable.css">
<script src="Static/jQuery/jquery.min.js"></script>
<script src="Content/bootstrap/js/bootstrap.min.js"></script>
<script src="Content/bootstrap-editable/js/bootstrap-editable.min.js"></script>
<script src="Content/bootstrap-table/locale/bootstrap-table-zh-CN.js"></script>
    <style>
        body{
            height:100%;
            width: 100%;
            margin:0;
        }
        .container{
            height:min-intrinsic;
        }
        .modal { 
            overflow: auto
        }
        #calculate{
            padding: 20px;
        }
        #calculate table{
            font-size: 15px;
            line-height:20px;
        }
    </style>
    <script>
    <!--源代码复制自：http://www.cnblogs.com/landeanfen/p/5821192.html-->
         $(function () {
            $('#department').editable({
                type: "select",              //编辑框的类型。支持text|textarea|select|date|checklist等
                source: [{ value: 1, text: "开发部" }, { value: 2, text: "销售部" }, {value:3,text:"行政部"}],
                title: "选择部门",           //编辑框的标题
                disabled: false,           //是否禁用编辑
                emptytext: "空文本",       //空值的默认文本
                mode: "popup",            //编辑框的模式：支持popup和inline两种模式，默认是popup
                validate: function (value) { //字段验证
                    if (!$.trim(value)) {
                        return '不能为空';
                    }
                }
            });
    
        });
    </script>
<body>
    <div class="container" style="margin-top: 500px">
        <div id="toolbar">
            <button id="btn_add" type="button" class="btn btn-default">
            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增账单
            </button>
            <button id="btn_edit" type="button" class="btn btn-default">
            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改/查看
            </button>
            <button id="btn_delete" type="button" class="btn btn-default">
            <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
            </button>
            <a href="#" id="department">选择部门</a>
        </div>
        <!--     bill list table     -->
        <table id="table" data-toolbar="#toolbar" 
        data-click-to-select="true" 
        data-select-item-name="bill"
        data-pagination="true"
        data-search="true"
        data-show-refresh="true"
        data-page-size="50">
        </table>
        <!--    end bill list table      -->
    </div>
</body>
</html>