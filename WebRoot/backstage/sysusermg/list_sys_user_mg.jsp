<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
	<head>
		<%@ include file="../../common/easyui.jsp"%>

		<script type="text/javascript">
$(function() {
	sysUserTable();
});

function searchSysUserTable() {
	sysUserTable();
}
function sysUserTable() {
	$('#sys_user_table_id')
			.datagrid(
					{
						//title : '客户信息管理',
						iconCls : 'icon-ok',
						nowrap : false,
						fit : true,
						animate : true,
						collapsible : true,
						fitColumns : true,
						url : '<rootPath:rootPath/>/sysuser/listSysUserBeans?rand=' + Math
								.random(),
						sortName : 'userId',
						sortOrder : 'desc',
						remoteSort : false,
						idField : 'userId',
						frozenColumns : [ [ {
							field : 'ck',
							checkbox : true
						} ] ],
						toolbar : [
								{
									id : 'btnadd',
									text : '增加',
									iconCls : 'icon-add',
									handler : function() {
										var rows = $('#sys_user_table_id')
												.datagrid('getSelections');
										var url = "<rootPath:rootPath/>/sysuser/toAddSysUserBean?rand="
												+ Math.random();
										
										var iframe = window.parent.createFrame(
												Math.random(), url);
										window.parent.openWindow('增加用户信息',
												iframe);
									}
								},
								{
									id : 'btnedit',
									text : '修改',
									iconCls : 'icon-edit',
									handler : function() {
										var rows = $('#sys_user_table_id')
												.datagrid('getSelections');
										if (rows.length == 0) {
											window.parent.alertWindow("提示",
													"请选择一个记录!");
											return false;
										}
										var url = "<rootPath:rootPath/>/sysuser/toUpdateSysUserBean?rand="
												+ Math.random()
												+ "&sysUserBean.userId="
												+ rows[0].userId;
										var iframe = window.parent.createFrame(
												Math.random(), url);
										window.parent.openWindow('修改用户信息', iframe);
									}
								} ,
								{
									id : 'btnremove',
									text : '删除',
									iconCls : 'icon-remove',
									handler : function() {
										var rows = $('#sys_user_table_id')
												.datagrid('getSelections');
										if (rows.length == 0) {
											window.parent.alertWindow("提示",
													"请选择一个记录!");
											return false;
										}
										
										var url = "<rootPath:rootPath/>/sysuser/deleteSysUserBean?rand="+ Math.random()+ "&sysUserBean.userId="+ rows[0].userId;
										window.parent.removeSysUser(url);
									}
								}],
						columns : [ [
								{
									field : 'userId',
									title : 'ID',
									width : 40,
									sortable : true
								},
								{
									field : 'userName',
									title : '用户名',
									width : 120,
									sortable : true
								},
								{
									field : 'userFirstName',
									title : '第一个名字',
									width : 80,
									sortable : true
								},
								{
									field : 'userLastName',
									title : '后一个名字',
									width : 80,
									sortable : true
								},
								{
									field : 'userEmail',
									title : '邮件',
									width : 100,
									sortable : true
								},
								{
									field : 'userActivity',
									title : '用户状态',
									width : 50,
									sortable : true,
									formatter : function(value, row, index) {
										if (value == "0") {
											return "<img src='<rootPath:rootPath/>/images/lock.png' alt='禁用' style='cursor:pointer' width='20px' height='20px' onclick='setSysUserFlag(1,"
													+ row.userId + ")'/>";
										} else if (value == "1") {
											return "<img src='<rootPath:rootPath/>/images/unlock.png' alt='启用' style='cursor:pointer' width='20px' height='20px' onclick='setSysUserFlag(0,"
													+ row.userId + ")'/>";
										}
									}
								}, {
									field : 'superuserFlag',
									title : '职务级别',
									width : 50,
									sortable : true,
									formatter : function(value, row, index) {
										if (value == "0") {
											return "职工";
										} else if (value == "1") {
											return "系统管理员";
										} else if (value == "2") {
											return "超级管理员";
										}
									}
								}, {
									field : 'strUserLoginTime',
									title : '最后登陆时间',
									width : 50,
									sortable : true
								}, {
									field : 'strUserDateJoined',
									title : '创建时间',
									width : 50,
									sortable : true
								} ] ],
						pagination : true,
						rownumbers : true,
						singleSelect : true
					});
}
function setSysUserFlag(value, userId) {
	$
			.ajax( {
				url : '<rootPath:rootPath/>/sysuser/updateSysUserBeanActive?sysUserBean.userId='
						+ userId
						+ '&sysUserBean.userActivityFlag='
						+ value
						+ '&rand=' + Math.random(),
				contentType : "application/json;charset=utf-8",
				dateType : "json",
				cache : false,
				success : function(data) {
					window.parent.showWindow(data.info);
					sysUserTable();
				}
			});
}
</script>
	</head>
	<body class="easyui-layout">
		<div data-options="region:'center'" style="overflow: hidden;">
			<table id="sys_user_table_id"></table>
		</div>
	</body>
</html>