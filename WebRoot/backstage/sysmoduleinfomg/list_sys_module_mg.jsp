<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
	<head>
		<%@ include file="../../common/easyui.jsp"%>
		<script type="text/javascript">
$(function() {
	var menuParentJson = "";
	$.ajax( {
		url : '<rootPath:rootPath/>/sysmenumg/listSysMenuBeans?rand=' + Math.random(),
		contentType : "application/json;charset=utf-8",
		dateType : "json",
		cache : false,
		async : false,
		success : function(data) {
			menuParentJson = eval(data);
		}
	});
	
	$('#menu_module_table_id').treegrid({
		title : '模块信息管理',
		iconCls : 'icon-ok',
		nowrap: false,
		fit:true,
		animate : true,
		collapsible : true,
		fitColumns : true,
		url:'<rootPath:rootPath/>/sysmenumg/listSysMenuModules?rand=' + Math.random(),
		idField : 'menuId',
		treeField : 'menuId',
		frozenColumns : [ [ {
			field : 'ck',
			checkbox : true
		} ] ],
		toolbar : [ {
			id : 'btnadd',
			text : '增加',
			iconCls : 'icon-add',
			handler : function() {
				$('#btnsave').linkbutton('enable');
				appendAdd();
			}
		}, {
			id : 'btnupdate',
			text : '修改',
			iconCls : 'icon-edit',
			handler : function() {
				$('#btnsave').linkbutton('enable');
				editNode();
			}
		}, {
			id : 'btnsave',
			text : '保存',
			disabled : true,
			iconCls : 'icon-save',
			handler : function() {
				saveNode();
			}
		}, {
			id : 'btnrefresh',
			text : '刷新',
			iconCls : 'icon-reload',
			handler : function() {
				reloadNode();
			}
		} ],
		columns : [ [ {
			field : 'menuId',
			title : 'ID',
			width : 80
		}, {
			field : 'menuName',
			title : '模块名称',
			width : 120,
			editor : 'text'
		}, {
			field : 'menuParentId',
			title : '父级模块ID',
			width : 60,
			editor : {
				type : 'combobox',
				options : {
					valueField : 'menuId',
					textField : 'menuId',
					data : menuParentJson,
					required : true
				}
			}
		}, {
			field : 'menuParentName',
			title : '父级模块名称',
			width : 120
		}, {
			field : 'menuURL',
			title : '模块URL',
			width : 180,
			editor : 'text'
		}, {
			field : 'menuOrder',
			title : '模块级别',
			width : 50,
			editor:{type:'numberbox',options:{required:true}}
		}, {
			field : 'menuActiveFlag',
			title : '模块状态',
			width : 50,
			formatter: function(value,row,index){
				if(value=="0"){
					return "<img src='<rootPath:rootPath/>/images/lock.png' alt='禁用' style='cursor:pointer' width='20px' height='20px' onclick='setMenuFlag(0,"+row.menuId+")'/>";
				}else if(value=="1"){
					return "<img src='<rootPath:rootPath/>/images/unlock.png' alt='启用' style='cursor:pointer' width='20px' height='20px' onclick='setMenuFlag(1,"+row.menuId+")'/>";
				}
			}
		}, {
			field : 'menuCreatedTime',
			title : '创建时间',
			width : 120
		}, {
			field : 'menuUpdatedTime',
			title : '修改时间',
			width : 110
		} ] ],
		pagination : true,
		rownumbers : true,
		singleSelect : true
	});
});

function reloadNode() {
	var node = $('#menu_module_table_id').treegrid('getSelected');
	$('#menu_module_table_id').treegrid('reload');
}

function getSelectedNode() {
	var node = $('#menu_module_table_id').treegrid('getSelected');
	if (node) {
		alert(node.menuId + ":" + node.menuName);
	}
}

function removeNode() {
	var node = $('#menu_module_table_id').treegrid('getSelected');
	if (node) {
		$.messager.confirm('<s:text name="tips_label"/>',
				'<s:text name="confirm_delete_label"/>', function(r) {
					if (r) {
						deleteMenuNode(node);
					}
				});
	} else {
		$.messager.alert('<s:text name="tips_label"/>',
				'<s:text name="pls_select_model_label"/>');
		return false;
	}
}

function editNode() {
	var node = $('#menu_module_table_id').treegrid('getSelected');
	if (!node) {
		window.parent.alertWindow('警告','请选择一条记录!');
	}
	if (node) {
		$('#menu_module_table_id').treegrid('beginEdit', node.menuId);
	}
}
function saveNode() {
	var node = $('#menu_module_table_id').treegrid('getSelected');
	if (!node) {
		window.parent.alertWindow('警告','请选择一条记录!');
	}
	if (node) {
		$('#menu_module_table_id').treegrid('endEdit', node.menuId);
		saveMenuNode(node);
	}
}
var codeIndex = new Date().getTime();
function appendAdd() {
	var node = $('#menu_module_table_id').treegrid('getSelected');
	addMenuNode(node);
}

function saveMenuNode(obj) {
	if(isNaN(obj.menuParentId)){
		window.parent.alertWindow('提示','父级模块有误！');
	}else if(obj.menuOrder==null||obj.menuOrder==""){
		window.parent.alertWindow('提示','排序必须为数字型！');
	}else{
		var url = '<rootPath:rootPath/>/sysmenumg/updateSysMenuBean?sysMenuBean.menuId='
				+ obj.menuId + '&sysMenuBean.menuName=' + obj.menuName
				+ '&sysMenuBean.menuUrl=' + obj.menuURL
				+ '&sysMenuBean.menuParentId=' + obj.menuParentId
				+ '&sysMenuBean.menuActiveFlag=' + obj.menuActiveFlag
				+ '&sysMenuBean.menuOrder=' + obj.menuOrder + '&sysMenuBean.menuParentName='+obj.menuParentName+'&rand='
				+ Math.random();
		url = encodeURI(encodeURI(url));
		$.ajax( {
			url : url,
			contentType : "application/json;charset=utf-8",
			dateType : "json",
			cache : false,
			success : function(data) {
				window.parent.showWindow(data.info);
				reloadNode();
			}
		});
	}
}

function setMenuFlag(value,menuId) {
	if(value=="0"){
		value="1";
	}else if(value=="1"){
		value="0";
	}
	$.ajax( {
		url : '<rootPath:rootPath/>/sysmenumg/updateSysMenuBeanFlag?menuId='+ menuId + '&menuActiveFlag='+value+'&rand=' + Math.random(),
		contentType : "application/json;charset=utf-8",
		dateType : "json",
		cache : false,
		success : function(data) {
			window.parent.showWindow(data.info);
			reloadNode();
		}
	});
}

function addMenuNode(obj) {
	var url = "<rootPath:rootPath/>/sysmenumg/addSysMenuBean?rand=" + Math.random();
	if (obj) {
		url += "&sysMenuBean.menuId=" + obj.menuId;
	}
	$.ajax( {
		url : url,
		contentType : "application/json;charset=utf-8",
		dateType : "json",
		cache : false,
		success : function(data) {
			window.parent.showWindow(data.info);
			reloadNode();
		}
	});
}
</script>
	</head>
	<body>
		<table id="menu_module_table_id"></table>
	</body>
</html>