<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="http://libs.useso.com/js/html5shiv/3.7/html5shiv.min.js"></script>
<script type="text/javascript" src="http://libs.useso.com/js/respond.js/1.4.2/respond.min.js"></script>
<script type="text/javascript" src="http://cdn.bootcss.com/css3pie/2.0beta1/PIE_IE678.js"></script>
<![endif]-->
<!--[if IE 7]>
<link href="http://www.bootcss.com/p/font-awesome/assets/css/font-awesome-ie7.min.css" rel="stylesheet" type="text/css" />
<![endif]-->
<title>客户信息</title>
</head>
<body>
<div class="cl pd-20" style=" background-color:#5bacb6">
  <img class="avatar avatar-XL l" src="<%=request.getContextPath()%>/Static/images/user.jpg" 
  width="170px" height="170px" style="margin-left: 20px">
  <dl style="margin-left:80px; color:#fff">
    <dt><span class="f-18">『${customer.cnickname}』</span> <span class="pl-10 f-12">》》：${customer.clevel}</span></dt>
    <dd class="pt-10 f-12" style="margin-left:0">这家伙很懒，什么也没有留下</dd>
  </dl>
</div>
<div class="pd-20">
  <table class="table">
    <tbody>
       <tr>
        <th class="text-r">：登入名</th>
        <td>${customer.cname}</td>
      </tr>
       <tr>
        <th class="text-r">：密码</th>
        <td>${customer.cpwd}</td>
      </tr>
       <tr>
        <th class="text-r" width="80">真实姓名：</th>
        <td>${customer.crealname}</td>
      </tr>
      <tr>
        <th class="text-r">手机：</th>
        <td>${customer.cphone}</td>
      </tr>
      <tr>
        <th class="text-r">：消费金额</th>
        <td>${customer.costed}</td>
      </tr>
      <tr>
        <th class="text-r">积分：</th>
        <td>${customer.credit}</td>
      </tr>
      <tr>
        <th class="text-r">注册时间：</th>
        <td>${customer.ctime }</td>
      </tr>
    </tbody>
  </table>
</div>
<script type="text/javascript" src="<%=request.getContextPath()%>/Static/jQuery/jquery.min.js"></script> 
<script>
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "//hm.baidu.com/hm.js?080836300300be57b7f34f4b3e97d911";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();
var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F080836300300be57b7f34f4b3e97d911' type='text/javascript'%3E%3C/script%3E"));
</script>
</body>
</html>