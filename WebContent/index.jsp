<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>登录页</title>
<script type="text/javascript" src="Static/jQuery/jquery.min.js"></script>
<script type="text/javascript" src="Static/js/login.js"></script>
<link href="Static/css/login2.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<h1>
		YMM后台管理系统登录<sup>2017</sup>
	</h1>

	<div class="login" style="margin-top: 50px;">

		<div class="header">
			<div class="switch" id="switch">
				<a class="switch_btn_focus" id="switch_qlogin"
					href="javascript:void(0);" tabindex="7">登录</a> <a
					class="switch_btn" id="switch_login" href="javascript:void(0);"
					tabindex="8">注册</a>
				<div class="switch_bottom" id="switch_bottom"
					style="position: absolute; width: 64px; left: 0px;"></div>
			</div>
		</div>


		<div class="web_qr_login" id="web_qr_login"
			style="display: block; height: 235px;">

			<!--登录-->
			<div class="web_login" id="web_login">


				<div class="login-box">


					<div class="login_form">
						<input type="hidden" name="did" value="0" /> <input type="hidden"
							name="to" value="log" />
						<div class="uinArea" id="uinArea">
							<label class="input-tips" for="u">帐号：</label>
							<div class="inputOuter" id="uArea">

								<input type="text" id="userL" name="username" class="inputstyle" />
							</div>
						</div>
						<div class="pwdArea" id="pwdArea">
							<label class="input-tips" for="p">密码：</label>
							<div class="inputOuter" id="pArea">

								<input type="password" id="pwdL" name="p" class="inputstyle" />
							</div>
						</div>

						<div style="padding-left: 50px; margin-top: 20px;">
							<input id="btnLg" type="submit" value="登 录" style="width: 150px;"
								class="button_blue" />
						</div>

					</div>

				</div>

			</div>
			<!--登录end-->
		</div>


		<!--注册-->
		<div class="qlogin" id="qlogin" style="display: none;">

			<div class="web_login">
				<form name="form2" id="regUser" accept-charset="utf-8" action=""
					method="post">
					<input type="hidden" name="to" value="reg" /> <input type="hidden"
						name="did" value="0" />
					<div id="userCue" class="cue"></div>
					<ul class="reg_form" id="reg-ul">

						<li><label for="user" class="input-tips2">用户名：</label>
							<div class="inputOuter2">
								<input type="text" id="userR" name="user" maxlength="16"
									class="inputstyle2" />
							</div></li>

						<li><label for="passwd" class="input-tips2">密码：</label>
							<div class="inputOuter2">
								<input type="password" id="pwdR" name="passwd" maxlength="16"
									class="inputstyle2" />
							</div></li>
						<li><label for="passwd2" class="input-tips2">确认密码：</label>
							<div class="inputOuter2">
								<input type="password" id="pwdR2" name="" maxlength="16"
									class="inputstyle2" />
							</div></li>


						<li>
							<div class="inputArea">
								<input type="button" id="btnReg"
									style="margin-top: 10px; margin-left: 85px;"
									class="button_blue" value="同意协议并注册" /> <a href="#" class="zcxy"
									target="_blank">注册协议</a>
							</div>

						</li>
						<div class="cl"></div>
					</ul>
				</form>


			</div>


		</div>
		<!--注册end-->
	</div>
	<div class="jianyi">*推荐使用ie8或以上版本ie浏览器或Chrome内核浏览器访问本站</div>
</body>
</html>