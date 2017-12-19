$(function(){
	$('#switch_qlogin').click(function(){
		$('#switch_login').removeClass("switch_btn_focus").addClass('switch_btn');
		$('#switch_qlogin').removeClass("switch_btn").addClass('switch_btn_focus');
		$('#switch_bottom').animate({left:'0px',width:'70px'});
		$('#qlogin').css('display','none');
		$('#web_qr_login').css('display','block');
		
		});
	$('#switch_login').click(function(){
		
		$('#switch_login').removeClass("switch_btn").addClass('switch_btn_focus');
		$('#switch_qlogin').removeClass("switch_btn_focus").addClass('switch_btn');
		$('#switch_bottom').animate({left:'154px',width:'70px'});
		
		$('#qlogin').css('display','block');
		$('#web_qr_login').css('display','none');
		});
if(getParam("a")=='0')
{
	$('#switch_login').trigger('click');
}

	});
	
function logintab(){
	scrollTo(0);
	$('#switch_qlogin').removeClass("switch_btn_focus").addClass('switch_btn');
	$('#switch_login').removeClass("switch_btn").addClass('switch_btn_focus');
	$('#switch_bottom').animate({left:'154px',width:'96px'});
	$('#qlogin').css('display','none');
	$('#web_qr_login').css('display','block');
	
}


//根据参数名获得该参数 pname等于想要的参数名 
function getParam(pname) { 
    var params = location.search.substr(1); // 获取参数 平且去掉？ 
    var ArrParam = params.split('&'); 
    if (ArrParam.length == 1) { 
        //只有一个参数的情况 
        return params.split('=')[1]; 
    } 
    else { 
         //多个参数参数的情况 
        for (var i = 0; i < ArrParam.length; i++) { 
            if (ArrParam[i].split('=')[0] == pname) { 
                return ArrParam[i].split('=')[1]; 
            } 
        } 
    } 
}  


var reMethod = "GET",
	pwdmin = 6;

$(document).ready(function() {
	$("#btnLg").click(function(){
		var user=$("#userL").val();
		var pwd=$("#pwdL").val();
		var param={
				"username":user,
				"password":pwd
		};
		$.ajax({
			async : false,
			url:"login",
			type:"POST",
			data:param,
			success:function(data){
				if(data=="success"){
					location.href="after";
				}else{
					alert("用户名或密码错误");
					$("#pwdL").val("");
				}
				
			}
		});
	});

	$('#btnReg').click(function() {

		if ($('#userR').val() == "") {
			$('#userR').focus().css({
				border: "1px solid red",
				boxShadow: "0 0 2px red"
			});
			$('#userCue').html("<font color='red'><b>×用户名不能为空</b></font>");
			return false;
		}

		if ($('#userR').val().length < 4 || $('#userR').val().length > 16) {

			$('#userR').focus().css({
				border: "1px solid red",
				boxShadow: "0 0 2px red"
			});
			$('#userCue').html("<font color='red'><b>×用户名位4-16字符</b></font>");
			return false;

		}
		
		if ($('#userR').val() == "admin" || $('#userR').val() == "ymm") {
			$('#userR').focus().css({
				border: "1px solid red",
				boxShadow: "0 0 2px red"
			});
			$('#userCue').html("<font color='red'><b>×此用户名禁止被注册</b></font>");
			return false;
		}

		if ($('#pwdR').val().length < pwdmin) {
			$('#pwdR').focus();
			$('#userCue').html("<font color='red'><b>×密码不能小于" + pwdmin + "位</b></font>");
			return false;
		}
		if ($('#pwdR2').val() != $('#pwdR').val()) {
			$('#pwdR2').focus();
			$('#userCue').html("<font color='red'><b>×两次密码不一致！</b></font>");
			return false;
		}
		var user=$("#userR").val();
		var pwd=$("#pwdR").val();
		
		var param={
				"username":user,
				"password":pwd
		};
		$.ajax({
			async : false,
			url:"register",
			type:"POST",
			data:param,
			success:function(data){
				alert(data);
				window.location.reload();
			}
		});

	});
	

});