<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@ include file="common/easyui.jsp"%>
<link href="<rootPath:rootPath/>/frontstage/css/css.css"
	rel="stylesheet" type="text/css">
<link href="<rootPath:rootPath/>/frontstage/css/css2.css"
	rel="stylesheet" type="text/css">
<script src="<rootPath:rootPath/>/frontstage/js/muen.js"
	type="text/javascript"></script>
</head>
<body>
	<table align="center" border="1" width="980px" height="800px">
		<tr class="logo_bg">
			<td><img src="<rootPath:rootPath/>/frontstage/images/logo.jpg"
				style="float: left; margin: 18px 0 0 25px;" width="420" height="64"><img
				src="<rootPath:rootPath/>/frontstage/images/logo_bg2.gif"
				width="502" height="99" style="float: right;"></td>
		</tr>
		<tr>
		<td>
			<div style="padding: 5px; border: 1px solid #ddd">
				<a href="#" class="easyui-linkbutton" data-options="plain:true">Home</a>
				<a id="btn-edit" href="#" class="easyui-menubutton"
					data-options="menu:'#mm1',iconCls:'icon-edit'">Edit</a> <a href="#"
					class="easyui-menubutton"
					data-options="menu:'#mm2',iconCls:'icon-help'">Help</a> <a href="#"
					class="easyui-menubutton" data-options="menu:'#mm3'">About</a>
			</div>
			<div id="mm1" style="width: 150px;">
				<div data-options="iconCls:'icon-undo'">Undo</div>
				<div data-options="iconCls:'icon-redo'">Redo</div>
				<div class="menu-sep"></div>
				<div>Cut</div>
				<div>Copy</div>
				<div>Paste</div>
				<div class="menu-sep"></div>
				<div>
					<span>Toolbar</span>
					<div style="width: 150px;">
						<div>Address</div>
						<div>Link</div>
						<div>Navigation Toolbar</div>
						<div>Bookmark Toolbar</div>
						<div class="menu-sep"></div>
						<div>New Toolbar...</div>
					</div>
				</div>
				<div data-options="iconCls:'icon-remove'">Delete</div>
				<div>Select All</div>
			</div>
			<div id="mm2" style="width: 100px;">
				<div>Help</div>
				<div>Update</div>
				<div>About</div>
			</div>
			<div id="mm3" class="menu-content"
				style="background: #f0f0f0; padding: 10px; text-align: left">
				<img src="http://www.jeasyui.com/images/logo1.png"
					style="width: 150px; height: 50px">
				<p style="font-size: 14px; color: #444;">Try jQuery EasyUI to
					build your modem, interactive, javascript applications.</p>
			</div>
			</td>
		</tr>
	</table>
</body>
</html>
