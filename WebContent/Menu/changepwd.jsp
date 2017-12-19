<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="/favicon.ico" >
<link rel="Shortcut Icon" href="/favicon.ico" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/h-ui/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/h-ui/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/h-ui/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/h-ui/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/h-ui/static/h-ui.admin/css/style.css" />
<title>修改密码  </title>
<script type="text/javascript">
function updatePwd() {
	var param={
			"id":$("#uid").val(),
			"username":$("#user").val(),
			"password":$("#pwd").val()
	};
	$.ajax({
        type: 'POST',
        url: "../user/update",
        data: param,
        dataType: 'JSON',
        success: function (data) {
        },
        error: function () {}
    });
	var r = confirm("修改完成，下次登录生效，是否立即返回登录页面.")
	if (r) {
		window.parent.frames.location.href="../";
	}
}
</script>
</head>
<body>
<article class="page-container" style="margin-top: 100px">
	<form class="form form-horizontal" id="form-change-password">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>账户名：</label>
			<div class="formControls col-xs-8 col-sm-9"> ${sessionScope.user.username}</div>
			<input type="hidden" id="uid" value="${sessionScope.user.id}">
			<input type="hidden" id="user" value="${sessionScope.user.username}">
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>输入新密码：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input name="password" type="password" id="pwd" class="input-text" autocomplete="off" placeholder="不修改请留空" name="newpassword" id="newpassword">
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input onclick="updatePwd()" class="btn btn-primary radius" type="button" value="&nbsp;&nbsp;保存&nbsp;&nbsp;">
			</div>
		</div>
	</form>
</article>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="<%=request.getContextPath()%>/h-ui/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath()%>/h-ui/lib/layer/2.4/layer.js"></script>  
<script type="text/javascript" src="<%=request.getContextPath()%>/h-ui/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath()%>/h-ui/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer /作为公共模版分离出去-->
<script type="text/javascript">
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>