<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.joysw.bean.sysuserbean.SysUserBean"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%Object obj = session.getAttribute("loginUser");
SysUserBean sessionUserBean = null;
if(obj !=null){
	sessionUserBean = (SysUserBean)obj;
}
%>
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
<script src="<rootPath:rootPath/>/frontstage/js/nav.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		var random = Math.random();
		var sessionUser = '<%=sessionUserBean%>';
		if(sessionUser=='null'){
			location.href="<rootPath:rootPath/>/checklogin";
		}
		loadFrontMenuBeans();
		loadFrontParentMenuBeans();
	});
	function loadFrontMenuBeans() {
		$.ajax({
			url : '<rootPath:rootPath/>/frontmenumg/loadFrontMenuList?rand='
					+ Math.random(),
			contentType : "application/json;charset=utf-8",
			dateType : "json",
			cache : false,
			success : function(data) {
				$("#nuw").html(data);
			}
		});
	}
	function loadFrontParentMenuBeans() {
		$.ajax({
					url : '<rootPath:rootPath/>/frontmenumg/loadFrontParentMenuList?rand='
							+ Math.random(),
					contentType : "application/json;charset=utf-8",
					dateType : "json",
					cache : false,
					success : function(data) {
						//alert(data);
						$("#left_nuw").html(data);
					}
				});
	}
</script>
</head>
<body>
	<div class="juzhong" id="show_id">
		<div class="top">
			<div class="top_top">
				<span style="float: left; margin-left: 14px;">欢迎访问某律师团队专业法律服务网！
					建站咨询热线: 15886674344</span><span style="float: right; margin-right: 6px;">今天是:
					2008.10.22. 星期三</span>
				<div class="clear"></div>
			</div>
			<div class="logo_bg">
				<img src="<rootPath:rootPath/>/frontstage/images/logo.jpg"
					style="float: left; margin: 18px 0 0 25px;" width="420" height="64"><img
					src="<rootPath:rootPath/>/frontstage/images/logo_bg2.gif"
					width="502" height="100" style="float: right;">
				<div class="clear"></div>
			</div>
			<div class="muen">
				<div class="subnav">
					<ul id="nuw">
					</ul>
				</div>
				<div class="sousuo"></div>
				<div class="clear"></div>
			</div>
		</div>
		<div class="main_2">
			<div class="right_nr">
				<div class="right_title">
					<span style="float: left;"><strong>个人基本信息</strong>Personal
						Information introduced</span> <span style="float: right;">首页<font>&gt;</font>个人基本信息
					</span>
					<div class="clear"></div>
				</div>
				<div class="jieshao">
					<div class="jieshao_nr">
						<div class="jieshao_nr_left">
							<div class="easyui-panel" title="个人信息"
								style="width: 300px; height: 270px"
								data-options="iconCls:'icon-save',modal:true,border:true">
								<table>
									<tbody>
										<tr>
											<td>姓名</td>
											<td><s:property value="studentBean.stuName"/></td>
										</tr>
										<tr>
											<td>学号</td>
											<td><s:property value="studentBean.stuNo"/></td>
										</tr>
										<tr>
											<td>系别</td>
											<td><s:property value="studentBean.stuDepartName"/></td>
										</tr>
										<tr>
											<td>专业</td>
											<td><s:property value="studentBean.stuMajor"/></td>
										</tr>
										<tr>
											<td>年级</td>
											<td><s:property value="studentBean.stuName"/></td>
										</tr>
										<tr>
											<td>班级</td>
											<td><s:property value="studentBean.stuName"/></td>
										</tr>
										<tr>
											<td>班级号</td>
											<td><s:property value="studentBean.stuName"/></td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="jieshao_nr_right">
							<div class="easyui-panel" title="最新体测结果"
								style="width: 650px; height: 270px"
								data-options="iconCls:'icon-save',modal:true,border:true">
								<table>
									<thead>
										<tr>
											<td width="180px">测试项目</td>
											<td width="80px">成绩</td>
											<td width="80px">得分</td>
											<td width="80px">等级</td>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>身高（厘米）</td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td>体重（公斤）</td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td>肺活量（毫升）</td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td>1000米跑（秒）</td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td>坐位体能屈（厘米）</td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td>50米跑（秒）</td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="clear"></div>
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