<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎页</title>

<script type="text/javascript" src="<%=request.getContextPath()%>/Static/jQuery/jquery.min.js"></script>

</head>

<body>

<script type="text/javascript">
	function filterArray(arr){
		var newarr = new Array();
		for(var i=0; i<arr.length; i++){
			if($.inArray(arr[i],newarr)==-1){
				newarr.push(arr[i]);
			}
		}
		return newarr;
	}
	
	var dataSource = [
	
			
			
			
			{province:'上海',city:'上海',name:'上海内安电器设备安装有限公司    电话：086-02-552245521'}
			,
			
			{province:'上海',city:'上海2',name:'上海内安电器设备安装有限公司222222'}
			,
			
			
			{province:'江苏',city:'南京',name:'南京白下区玉其宁电器维修中心'}
			,
			
			
			
			{province:'辽宁',city:'大连',name:'大连市甘井子区汇迪卫浴维修服务部'}
			,
			
			
			
			{province:'广东',city:'广州',name:'广州佳缘卫浴用品有限公司'}
			,
			
			
			
			{province:'浙江',city:'杭州',name:'杭州东合建材有限公司'}
			,
			
			
			
			{province:'福建',city:'泉州',name:'泉州隆锦建材有限公司'}
			,
			
			
			
			{province:'山东',city:'青岛',name:'青岛和顺兴工贸有限公司'}
			,
			
			
			
			{province:'上海',city:'上海',name:'上海伊莫金建材有限公司<br>（闵行区,金山区,奉贤区,松江区,青浦区）'}
			,
			
			
			
			{province:'福建',city:'厦门',name:'厦门金色阳光商贸有限公司'}
			,
			
			
			
			{province:'广东',city:'东莞',name:'广州佳缘卫浴用品有限公司—东莞点'}
			,
			
			
			
			{province:'浙江',city:'嘉兴',name:'杭州东合建材有限公司—嘉兴点'}
			,
			
			
			
			{province:'辽宁',city:'沈阳',name:'沈阳市友捷卫浴服务站'}
			,
			
			
			
			{province:'山东',city:'烟台',name:'烟台市芝罘区乐凯卫厨维修部'}
			,
			
			
			
			{province:'江苏',city:'苏州',name:'苏州市吴中区长桥荣盛家用电器维修部'}
			,
			
			
			
			{province:'广东',city:'深圳',name:'广州佳缘卫浴用品有限公司—深圳点'}
			,
			
			
			
			{province:'江苏',city:'无锡',name:'无锡市北塘区万荣家用电器安装维修服务部'}
			,
			
			
			
			{province:'浙江',city:'绍兴',name:'杭州东合建材有限公司—绍兴点'}
			,
			
			
			
			{province:'山东',city:'济南',name:'济南大龙洁具有限公司'}
			,
			
			
			
			{province:'福建',city:'福州',name:'福州喜盈门卫橱装饰有限公司'}
			,
			
			
			
			{province:'江苏',city:'常州',name:'无锡市北塘区万荣家用电器安装维修服务部'}
			,
			
			
			
			{province:'江苏',city:'张家港',name:'无锡市北塘区万荣家用电器安装维修服务部'}
			,
			
			
			
			{province:'浙江',city:'宁波',name:'上海升驭实业有限公司—宁波点'}
			,
			
			
			
			{province:'江苏',city:'南通',name:'南京名高工程实业有限公司—南通点'}
			,
			
			
			
			{province:'广东',city:'汕头',name:'汕头市龙湖区长盛洁具装饰材料经营部'}
			,
			
			
			
			{province:'江苏',city:'扬州',name:'南京名高工程实业有限公司—扬州点'}
			,
			
			
			
			{province:'江苏',city:'镇江',name:'南京名高工程实业有限公司—镇江点'}
			,
			
			
			
			{province:'北京',city:'北京',name:'北京天择燃气技术开发服务中心'}
			,
			
			
			
			{province:'新疆',city:'乌鲁木齐',name:'乌鲁木齐高新技术产业开发区鸿信经销中心'}
			,
			
			
			
			{province:'江西',city:'南昌',name:'南昌市远星建材有限公司'}
			,
			
			
			
			{province:'黑龙江',city:'哈尔滨',name:'哈尔滨市道里区永兴卫生洁具售后服务部'}
			,
			
			
			
			{province:'天津',city:'天津',name:'天津天择电器设备维修服务有限公司'}
			,
			
			
			
			{province:'山西',city:'太原',name:'太原市小店区雅客饰家洁具售后服务部'}
			,
			
			
			
			{province:'安徽',city:'合肥',name:'安徽泓鑫建筑材料有限公司'}
			,
			
			
			
			{province:'广西',city:'南宁',name:'广西正基宏业商贸有限公司'}
			,
			
			
			
			{province:'四川',city:'成都',name:'成都欣心兰阳商贸有限公司'}
			,
			
			
			
			{province:'河北',city:'石家庄',name:'新华区嘉陶洁具维修中心'}
			,
			
			
			
			{province:'云南',city:'昆明',name:'昆明市西山区和钛卫浴经营部'}
			,
			
			
			
			{province:'湖北',city:'武汉',name:'武汉广联家电售后服务有限公司'}
			,
			
			
			
			{province:'海南',city:'海口',name:'海口琼山友益佳洁具售后服务部'}
			,
			
			
			
			{province:'海南',city:'三亚',name:'海口琼山友益佳洁具售后服务部'}
			,
			
			
			
			{province:'甘肃',city:'兰州',name:'甘肃佳恒经贸有限公司'}
			,
			
			
			
			{province:'吉林',city:'长春',name:'经济技术开发区龙翔洁具维修服务处'}
			,
			
			
			
			{province:'陕西',city:'西安',name:'西安宇枫洁具售后服务有限公司'}
			,
			
			
			
			{province:'贵州',city:'贵阳',name:'贵阳市南明区协和个体建材经营部'}
			,
			
			
			
			{province:'内蒙古',city:'呼和浩特',name:'赛罕区金意卫浴服务部'}
			,
			
			
			
			{province:'河南',city:'郑州',name:'郑州市金水区合家适居建材商行'}
			,
			
			
			
			{province:'重庆',city:'重庆',name:'重庆市南岸区诚帮家电维修部'}
			,
			
						
			
			{province:'西藏',city:'西藏',name:'西藏南岸区诚帮家电维修部22'}
			,
			
			
			
			{province:'湖南',city:'长沙',name:'长沙锦派建材有限公司'}
			];
	
$(function(){
	$(".tabbreadcrumb>ul>li>a").bind("click", function () {
		$(this).parent().parent().find("li").removeClass("current");
		$(this).parent().addClass("current");
		$(".catalogue").hide().eq($(this).parent().index()).show();
	});
	
	$(".tabbreadcrumb>ul>li").eq(0).find("a").click(); 
	
	$('#btn_close').click(function(){
		zone_close();
	});
	
	
	
	
	
	var provinces = $.map(dataSource,function(val){
		return val.province;
	});

	provinces = filterArray(provinces);
	
	$.each(provinces,function(key,val){
		$('#s1').append('<option value="'+val+'">'+val+'</option>');
	})
	
	$('#s1').bind('change',function(){
		var $v = $(this).val();
		$('#s2').find('option:gt(0)').remove();
		if($v==''){
			zone_close();
		}
		else{
			var result = $.grep(dataSource,function(val,key){
				if(val.province == $v){
					return true;
				}
				else{
					return false;
				}
			});
			var citys = $.map(result,function(val){
				return val.city;
			});
			citys = filterArray(citys);
			$.each(citys,function(key,val){
				$('#s2').append('<option value="'+val+'">'+val+'</option>');
			});
			zone_show($v,'',1);
		}
	});
	
	$('#s2').bind('change',function(){
		var $v = $(this).val();
		if($v==''){
			zone_close();
		}
		else{
			zone_show($('#s1').val(),$v,2);
		}
	});
	
});

function zone_close(){
		$('#mylist').empty();
		$('#myzone').hide();
	}
	
	function zone_show(p,c,type){
		$('#mylist').empty();
		var result = null;
		if(type == 1){
			result = $.grep(dataSource,function(val,key){
				if(val.province == p){
					return true;
				}
				else{
					return false;
				}
			});
			
		}
		else{
			result = $.grep(dataSource,function(val,key){
				if(val.city == c){
					return true;
				}
				else{
					return false;
				}
			});
		}

		if(result == null){
			zone_close();
		}
		
		$.each(result,function(key,val){
			$('#mylist').append('<tr><td class="one">'+val.city+'</td><td>'+val.name+'</td></tr>');
		});
		
		$('#mytitle').text(p+' '+c+' 特约售后服务商');
		
		$('#myzone').show();
	}

function setProvince(p){
	var $v = p;
	if($v!=''){
		$('#s2').find('option:gt(0)').remove();
		$('#s1').find('option').removeAttr('selected');
		$('#s1').find('option[value="'+p+'"]').attr('selected','selected');
		
		var result = $.grep(dataSource,function(val,key){
			if(val.province == $v){
				return true;
			}
			else{
				return false;
			}
		});

		$.each(result,function(key,val){
			$('#s2').append('<option value="'+val.city+'">'+val.city+'</option>');
		});

		zone_show($v,'',1);
	}
}

</script>

<style type="text/css">
*{margin:0;padding:0;list-style-type:none;}
a,img{border:0;}
body{font:12px/180% Arial, Helvetica, sans-serif, "新宋体";}

#container{margin:auto auto;width:665px;}
#mylist td{line-height:21px;}
#mylist td.one{width:50px;}
</style>

<div id="container">


	<div style="font-size:12px;margin-top:15px;margin-left:5px;">    
		
		<div style="height:36px;line-height:14px;color:#868686">    
				
				各大订单服务网点查询            
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;            
						
				省份(直辖市)：            
				<select id="s1">            
					<option value="">---请选择---</option>            
				</select>            
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;            
						
				城市：            
				<select id="s2">            
					<option value="">---请选择---</option>
				</select>
			
		</div>
	
		<div style="margin-bottom:25px;margin-left:7px;position: relative;">
			<img id="map" name="map" usemap="#m_map"  src="<%=request.getContextPath()%>/Static/images/map.jpg" alt="">
			<div id="myzone" style="width:393px;position: absolute;left:200px;top:100px;display:none;">
				<div style="height: 22px; background-image: url('<%=request.getContextPath()%>/Static/images/bg_top.png'); background-repeat: repeat; background-attachment: scroll; background-position: 0% 50%">
				<img id="btn_close" style="cursor:pointer;float: right;margin: 11px 15px 0 0;" SRC="<%=request.getContextPath()%>/Static/images/close.gif" alt="关闭">
				</div>
				<div style="background-image: url('<%=request.getContextPath()%>/Static/images/bg_middle.png'); background-repeat: repeat; background-attachment: scroll; padding-left: 20px; padding-right: 20px; padding-top: 0; padding-bottom: 0; background-position: 0% 50%">
					<div id="mytitle" style="margin-bottom:10px;line-height:14px;font-size:14px;font-family:Microsoft YaHei;"></div>
					<table id="mylist">
					</table>
				</div>
				<div style="height: 15px; background-image: url('<%=request.getContextPath()%>/Static/images/bg_bottom.png'); background-repeat: repeat; background-attachment: scroll; background-position: 0% 50%">
				</div>
			</div>
		</div>
	
	</div>

	<map name="m_map" id="m_map">
		<area shape="rect" coords="552, 79, 601, 104" href="javascript:setProvince('黑龙江')" alt="" />
		<area shape="rect" coords="542, 125, 579, 149" href="javascript:setProvince('吉林')" alt="" />
		<area shape="rect" coords="523, 170, 554, 192" href="javascript:setProvince('辽宁')" alt="" />
		<area shape="rect" coords="460, 181, 485, 197" href="javascript:setProvince('北京')" alt="" />
		<area shape="rect" coords="472, 202, 499, 215" href="javascript:setProvince('天津')" alt="" />
		<area shape="rect" coords="449, 221, 473, 233" href="javascript:setProvince('河北')" alt="" />
		<area shape="rect" coords="113, 152, 162, 183" href="javascript:setProvince('新疆')" alt="" />
		<area shape="rect" coords="246, 187, 291, 213" href="javascript:setProvince('甘肃')" alt="" />
		<area shape="rect" coords="362, 178, 410, 207" href="javascript:setProvince('内蒙古')" alt="" />
		<area shape="rect" coords="377, 276, 413, 298" href="javascript:setProvince('陕西')" alt="" />
		<area shape="rect" coords="308, 324, 335, 342" href="javascript:setProvince('四川')" alt="" />
		<area shape="rect" coords="366, 337, 399, 359" href="javascript:setProvince('重庆')" alt="" />
		<area shape="rect" coords="364, 379, 393, 400" href="javascript:setProvince('贵州')" alt="" />
		<area shape="rect" coords="295, 403, 321, 420" href="javascript:setProvince('云南')" alt="" />
		<area shape="rect" coords="404, 479, 428, 493" href="javascript:setProvince('海南')" alt="" />
		<area shape="rect" coords="392, 419, 420, 440" href="javascript:setProvince('广西')" alt="" />
		<area shape="rect" coords="444, 421, 471, 435" href="javascript:setProvince('广东')" alt="" />
		<area shape="rect" coords="418, 368, 448, 388" href="javascript:setProvince('湖南')" alt="" />
		<area shape="rect" coords="500, 377, 530, 399" href="javascript:setProvince('福建')" alt="" />
		<area shape="rect" coords="473, 350, 500, 367" href="javascript:setProvince('江西')" alt="" />
		<area shape="rect" coords="419, 320, 449, 341" href="javascript:setProvince('湖北')" alt="" />
		<area shape="rect" coords="481, 306, 506, 324" href="javascript:setProvince('安徽')" alt="" />
		<area shape="rect" coords="523, 329, 550, 345" href="javascript:setProvince('浙江')" alt="" />
		<area shape="rect" coords="544, 307, 569, 321" href="javascript:setProvince('上海')" alt="" />
		<area shape="rect" coords="517, 280, 545, 303" href="javascript:setProvince('江苏')" alt="" />
		<area shape="rect" coords="432, 278, 461, 298" href="javascript:setProvince('河南')" alt="" />
		<area shape="rect" coords="415, 240, 439, 258" href="javascript:setProvince('山西')" alt="" />
		<area shape="rect" coords="476, 243, 511, 265" href="javascript:setProvince('山东')" alt="" />
		<area shape="rect" coords="142, 285, 168, 306" href="javascript:setProvince('西藏')" alt="">
	</map>	

</div>

</body>
</html>