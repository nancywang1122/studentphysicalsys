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
	function _reset() {
		$("#sportsconsult_form_id")[0].reset();

	}
	function formSubmit() {
		$("#sportsconsult_form_id")
				.form(
						'submit',
						{
							url : '<rootPath:rootPath/>/addSportsConsultBean?rand='
									+ Math.random(),
							method : 'post',
							onSubmit : function() {
								if ($(this).form('validate')) {
									window.parent.showProgress();
									return true;
								} else {
									return false;
								}
							},

							success : function(data) {
								if (eval(data)[0].result == "1") {
									setTimeout(
											function() {
												$.messager.progress('close');
												location.href = "<rootPath:rootPath/>/displaySportsConsult";
											}, 3000);
									$.messager.show({
										title : '提示',
										msg : eval(data)[0].info
									});
								} else {
									setTimeout(function() {
										$.messager.progress('close');
									}, 3000);
									$.messager.show({
										title : '提示',
										msg : eval(data)[0].info
									});
								}
							}
						});
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
				<div class="sousuo"></div>
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
					<div style="padding-top:8px; color:#4c657e;">如果你想咨询体育运动方面的情况，请填写带*项；感谢你对我们的关注和支持。</div>
					<form action="" method="post" id="sportsconsult_form_id" novalidate>
						<table width="100%" border="0" cellpadding="0" cellspacing="1"
							bgcolor="#cbcbcb" class="biaoge">
							<tr>
								<td bgcolor="#f8f8f8"><span>*</span>标题：</td>
								<td height="95" bgcolor="#f8f8f8"><label> <textarea
											name="sportsConsultBean.sportsConsultTitle" cols="80"
											rows="5"></textarea> </label></td>
							</tr>
							<tr>
								<td bgcolor="#f8f8f8"><span>*</span>咨询内容：</td>
								<td height="95" bgcolor="#f8f8f8"><textarea
										name="sportsConsultBean.sportsConsultContent" id="textarea2"
										cols="80" rows="15"></textarea></td>
							</tr>

							<tr>
								<td height="35" bgcolor="#f8f8f8"><span>*</span> 运动类型：</td>
								<td bgcolor="#f8f8f8"><s:select
										name="sportsConsultBean.sportsType"
										list="{'田径','足球','篮球','排球','游泳','跆拳道'}">

									</s:select></td>
							</tr>
						</table>
					</form>
					<div>
						<div align="center" style="padding:15px 0;">
							<a class="easyui-linkbutton" data-options="iconCls:'icon-ok'"
								href="javascript:void(0)" id="submit_id" onclick="formSubmit()">提交</a>
							<a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'"
								href="javascript:void(0)" id="reset_id" onclick="_reset()">重置</a>
						</div>
					</div>
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
		<div class="bottom_right">地址：中国上海 邮政编码：200000 沪ICP备案号00000000号</div>
	</div>
	</div>
</body>
</html>