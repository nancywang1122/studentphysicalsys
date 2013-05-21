<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@ include file="../../common/easyui.jsp"%>

<link href="<rootPath:rootPath/>/frontstage/css/css.css"
	rel="stylesheet" type="text/css">
<link href="<rootPath:rootPath/>/frontstage/css/css2.css"
	rel="stylesheet" type="text/css">
<script src="<rootPath:rootPath/>/frontstage/js/muen.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		loadFrontMenuBeans();
	});
	function loadFrontMenuBeans() {
		$.ajax({url : '<rootPath:rootPath/>/frontmenumg/loadFrontMenuList?rand='
							+ Math.random(),
					contentType : "application/json;charset=utf-8",
					dateType : "json",
					cache : false,
					success : function(data) {
						$("#nuw").html(data);
					}
				});
	}
	function preFunc(obj){
	
		location.href="<rootPath:rootPath/>/displaySportsConsult?page="+obj;
	}
	
	function jumpToPageFunc(){
	
	   var obj=$("#jumptopage_id").val();
	   if(obj==""){
	     window.alert("页码必须是数字");
	   }
	   else{
	     location.href="<rootPath:rootPath/>/displaySportsConsult?page="+obj;
	   }
	}
	
</script>
</head>
<body>
	<div class="juzhong">
		<div class="top">
			<div class="top_top">
				<span style="float:left; margin-left:14px;"></span><span
					style="float:right; margin-right:6px;">今天是:2008.10.22. 星期三</span>
				<div class="clear"></div>
			</div>
			<div class="logo_bg">
				<img src="<rootPath:rootPath/>/frontstage/images/logo.jpg"
					style="float:left; margin:18px 0 0 25px;" width="420" height="64"><img
					src="<rootPath:rootPath/>/frontstage/images/logo_bg2.gif"
					width="502" height="100" style=" float:right;">
				<div class="clear"></div>
			</div>
			<div class="muen">
				<div class="subnav">
					<ul id="nuw">
					</ul>
				</div>
				<div class="sousuo">
				</div>
				<div class="clear"></div>
			</div>
		</div>
		<div class="main_2">
			<div class="right_nr">
				<div class="right_title">
					<span style="float:left;"><strong>在线运动咨询</strong>On-line
						consultation</span> <span style="float:right;">首页<font>&gt;</font>在线服务<font>&gt;</font>在线运动咨询
					</span>
					<div class="clear"></div>
				</div>
				
				<div class="zaixianfalv">
					<s:iterator id="sportConsultBeanlist" value="#sportConsultBeanlist" status="status">
					<div class="zaixianfalv_1">
						<div class="zaixianfalv_1_title">
						<s:property value="#sportConsultBeanlist.sportsConsultCreatedByName"/> 
						<s:property value="#sportConsultBeanlist.sportsConsultCreatedTime"/> 咨询：
						 <s:if test="#status.index==0">
						<a href="<rootPath:rootPath/>/toAddSportsConsultBean"><img src="<rootPath:rootPath/>/images/woyao_zixun.gif" border="0"></a>
					 </s:if> 
						
						
						</div>
						<div class="zaixianfalv_1_nr">
							<s:property value="#sportConsultBeanlist.sportsConsultTitle"/></div>
					</div>
					</s:iterator>
				</div>
				<div class="fangye" style="border:none; margin:0px;">
					<div class="fanye_left">共 <s:property value="#page.rowCount"/> 条新闻 当前为：<s:property value="#page.num"/>/<s:property value="#page.count"/>页 每页<s:property value="#page.size"/> 条</div>
					<div class="fanye_right">
						跳到第 <input name="" id="jumptopage_id" type="text" class="fanye_input"> 页 <span
							style="margin:0 15px;"><a href="#" onclick="preFunc(<s:property value="#page.first"/>)">&lt;&lt;</a>
							<a href="#" onclick="preFunc(<s:property value="#page.prev"/>)">&lt;</a> <a
							href="#" onclick="preFunc(<s:property value="#page.next"/>)">&gt;</a> <a
							href="#" onclick="preFunc(<s:property value="#page.last"/>)">&gt;&gt; </a> </span> <input name=""
							type="image" src="<rootPath:rootPath/>/frontstage/images/go.gif" onclick="jumpToPageFunc()">
					</div>
				</div>
			</div>
			<div class="clear"></div>
		</div>
		<div class="bottom">
			<div class="bottom_left">
				<a href="http://www.865171.cn">联系我们</a> | <a
					href="http://www.865171.cn">在线咨询</a> | <a
					href="http://www.865171.cn">网站地图</a> | <a
					href="http://www.865171.cn">官方博客</a> | <a
					href="http://www.865171.cn">隐私声明</a>
			</div>
			<div class="bottom_right">地址：中国上海 邮政编码：200000 沪ICP备案号00000000号
			</div>
		</div>
	</div>
</body>
</html>