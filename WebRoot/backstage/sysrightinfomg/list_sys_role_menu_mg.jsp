<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<%@ include file="../../common/easyui.jsp"%>
		<script type="text/javascript">
$(function() {
	showRoleTree();
	showDepartTree();
	showMenuTree("-1");
});

function showDepartTree() {
	$('#departTreeId').tree({
		url : '<rootPath:rootPath/>/sysrightmg/listSysDepartBeans?rand=' + Math
				.random(),
		onClick : function(node) {
			$(this).tree('toggle', node.target);
		},
		onAfterEdit:function(node){
			var url='<rootPath:rootPath/>/sysrightmg/updateSysDepartBean?departId='+node.id+'&departName='+node.text+'&rand='+Math.random();
			url = encodeURI(encodeURI(url));
			doAjaxAction(url);
			showDepartTree();
		},
		onContextMenu : function(e, node) {
			e.preventDefault();
			$('#departTreeId').tree('select', node.target);
			$('#departTreeMenu').menu('show', {
				left : e.pageX,
				top : e.pageY
			});
		}
	});
}

function update(obj) {
	if(obj=="2"){
		var node =  $("#departTreeId").tree('getSelected');
		if (node) {
			 $("#departTreeId").tree('beginEdit', node.target);
		}
	}else if(obj=="1"){
		var node =  $("#roleTreeId").tree('getSelected');
		if (node) {
			 $("#roleTreeId").tree('beginEdit', node.target);
		}
	}
}
function add(){
	var node = $("#roleTreeId").tree('getSelected');
	$.messager.prompt('提示', '请输入角色名称', function(roleName){
		if (roleName){
			if(roleName.length>20){
				$.messager.alert('提示','角色名称字符长度不能超过20!');
			}else{
				$("#roleTreeId").tree('insert', {
						after : node.target,
						data : {
							text : roleName,
							checked : true
						}
				});
				var depart_parent_id = node.id;
				var url='<rootPath:rootPath/>/sysrightmg/addSysRoleBean?roleName='+roleName+'&rand='+Math.random();
				url = encodeURI(encodeURI(url));
				doAjaxAction(url);
				showRoleTree();
			}
		}
	});
}
function append(obj) {
	if(obj=="2"){
		var node = $("#departTreeId").tree('getSelected');
		$.messager.prompt('提示', '请输入部门组织名称', function(departName){
			if (departName){
				if(departName.length>20){
					$.messager.alert('提示','部门组织名称字符长度不能超过20!');
				}else{
					$("#departTreeId").tree('append', {
						parent : (node ? node.target : null),
						data : [ {
							text : departName,
							checked : true
						}]
					});
					var depart_parent_id = node.id;
					var url='<rootPath:rootPath/>/sysrightmg/addSysDepartBean?departName='+departName+'&departParentId='+depart_parent_id+'&rand='+Math.random();
					url = encodeURI(encodeURI(url));
					doAjaxAction(url);
					showDepartTree();
				}
			}
		});
	}
}

function remove(obj) {
	if(obj=="2"){
			var node = $("#departTreeId").tree('getSelected');
			if (node) {
				$.messager.confirm('提示', '您确定要删除此记录吗？', function(r){
					if (r){
						$("#departTreeId").tree('remove', node.target);
						var url='<rootPath:rootPath/>/sysrightmg/deleteSysDepartBean?departId='+node.id+'&rand='+Math.random();
						doAjaxAction(url);
						showDepartTree();
					}
				});
			}
	}else if(obj=="1"){
		var node = $("#roleTreeId").tree('getSelected');
			if (node) {
				$.messager.confirm('提示', '您确定要删除此记录吗？', function(r){
					if (r){
						$("#roleTreeId").tree('remove', node.target);
						var url='<rootPath:rootPath/>/sysrightmg/deleteSysRoleBean?roleId='+node.id+'&rand='+Math.random();
						doAjaxAction(url);
						showRoleTree();
					}
				});
			}
	}
}

function showRoleTree() {
	$('#roleTreeId').tree({
		url : '<rootPath:rootPath/>/sysrightmg/listSysRoleBeans?rand=' + Math
				.random(),
		onClick : function(node) {
			$(this).tree('toggle', node.target);
			showMenuTree(node.id);
		},
		onAfterEdit:function(node){
			var url='<rootPath:rootPath/>/sysrightmg/updateSysRoleBean?roleId='+node.id+'&roleName='+node.text+'&rand='+Math.random();
			url = encodeURI(encodeURI(url));
			doAjaxAction(url);
			showRoleTree();
		},
		onContextMenu : function(e, node) {
			e.preventDefault();
			$('#roleTreeId').tree('select', node.target);
			$('#roleTreeMenu').menu('show', {
				left : e.pageX,
				top : e.pageY
			});
		}
	});
}

function showMenuTree(obj) {
	var url = '<rootPath:rootPath/>/sysrightmg/listSysMenuBeans?roleId=' + obj
			+ '&rand=' + Math.random();

	$('#menuTreeId').tree( {
		checkbox : true,
		url : url,
		onClick : function(node) {
			$(this).tree('toggle', node.target);
		}
	});
}
function doAjaxAction(obj) {
	$.ajax( {
		url : obj,
		contentType : "application/json;charset=utf-8",
		dateType : "json",
		cache : false,
		async : false,
		success : function(data) {
			window.parent.showWindow(data.info);
		}
	});
}
function saveRoleMenuFun() {
	var node = $('#roleTreeId').tree('getSelected');
	var nodeMenu = $('#menuTreeId').tree('getChecked');
	if (node && (nodeMenu != "")) {
		var parentNodes = [];
		$("#menuTreeId").find('.tree-checkbox2').each(
				function() {
					var node = $(this).parent();
					parentNodes.push($.extend( {},
							$.data(node[0], 'tree-node'), {
								target : node[0],
								checked : node.find('.tree-checkbox').hasClass(
										'tree-checkbox2')
							}));
				});
		var menuId = [];
		for ( var i = 0; i < parentNodes.length; i++) {
			menuId.push(parentNodes[i].id);
		}
		for ( var i = 0; i < nodeMenu.length; i++) {
			menuId.push(nodeMenu[i].id);
		}
		var url = '<rootPath:rootPath/>/sysrightmg/saveSysRoleMenuBean?roleId='
				+ node.id + '&menuIds=' + menuId + '&rand=' + Math.random();
		doAjaxAction(url);
	} else {
		$.messager.alert('提示', '请同时选择一个角色和模块!');
	}
}
</script>
	</head>
	<body>
		<div style="width: auto; height: auto;" class="easyui-layout"
			fit="true">
			<div region="west" title="角色信息管理" iconCls="icon-reload" split="true"
				style="width: 230px;">
				<ul id="roleTreeId"></ul>
			</div>
			<div region="center" title="模块信息查看" iconCls="icon-reload" style="overflow: auto;">
				<ul id="menuTreeId"></ul>
			</div>
			<div region="east" title="部门信息管理" iconCls="icon-reload" split="true"
				style="width: 230px;">
				<ul id="departTreeId"></ul>
			</div>
			<div region="south" border="false">
				<a class="easyui-linkbutton" iconCls="icon-save" onclick="saveRoleMenuFun()">授权</a>
			</div>
		</div>
		
		<div id="departTreeMenu" class="easyui-menu" style="width: 120px;">
			<div onclick="append(2)" iconCls="icon-add">增加部门</div>
			<div onclick="update(2)" iconCls="icon-edit">修改部门</div>
			<div onclick="remove(2)" iconCls="icon-remove">删除部门</div>
		</div>
		<div id="roleTreeMenu" class="easyui-menu" style="width: 120px;">
			<div onclick="add()" iconCls="icon-add">增加角色</div>
			<div onclick="update(1)" iconCls="icon-edit">修改角色</div>
			<div onclick="remove(1)" iconCls="icon-remove">删除角色</div>
		</div>
	</body>
</html>
