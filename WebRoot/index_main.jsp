<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ include file="common/easyui.jsp"%>

<script type="text/javascript">
$(function() {
	tabCloseEven();
	initAccordion();
	showMenuChild();
});

function initAccordion() {
	var pp = $('#accordion_id').accordion('getSelected');
	var menuId = pp.attr("id");
	var url = '<rootPath:rootPath/>/sysmenumg/listChildSysMenus?sysMenuBean.menuId='
			+ menuId + '&rand=' + Math.random()
	$.ajax( {
		url : url,
		contentType : "application/json;charset=utf-8",
		dateType : "json",
		cache : false,
		success : function(data) {
			var strjson = eval(data);
			$('#treeId' + menuId).tree( {
				data : strjson,
				animate : true,
				onClick : function(node) {
					addTab(node.text, node.attributes.url);
				}
			});
		}
	});
}
function showMenuChild() {
	$('#accordion_id').accordion({
		onSelect : function(title) {
			var pp = $('#accordion_id')
					.accordion('getSelected');
			var menuId = pp.attr("id");
			var url = '<rootPath:rootPath/>/sysmenumg/listChildSysMenus?sysMenuBean.menuId='
					+ menuId + '&rand=' + Math.random()
			$.ajax( {
				url : url,
				contentType : "application/json;charset=utf-8",
				dateType : "json",
				cache : false,
				success : function(data) {
					var strjson = eval(data);
					$('#treeId' + menuId).tree({
						data : strjson,
						animate : true,
						onClick : function(node) {
							addTab(node.text,node.attributes.url);
						}
					});
				}
			});
		}
	});
}
function addTab(title, url) {
	if ($('#mainTabs').tabs('exists', title)) {
		$('#mainTabs').tabs('select', title);
		var currTab = $('#mainTabs').tabs('getSelected');
		var panelTab = currTab.panel('options');
		if (url != undefined && url != 'null' && url != null && url != "") {
			$('#mainTabs').tabs('update',{
				tab : currTab,
				options : {
					title : panelTab.title,
					icon : 'icon-tab',
					content : createFrame(panelTab.title,'<rootPath:rootPath/>/' + url + '?rand=' + Math.random())
				}
			});
		}
	} else {
		if (url != undefined && url != 'null' && url != null && url != "") {
			$('#mainTabs').tabs(
					'add',
					{
						title : title,
						content : createFrame(title,'<rootPath:rootPath/>/' + url+ '?rand=' + Math.random()),
						cache : false,
						icon : 'icon-tab',
						closable : true
					});
		}
	}
}

</script>
</head>
<body class="easyui-layout">
	<div region="north" border="true" title="上海交通大学体育系体质管理平台"
		style="height: 130px"></div>
	<div id="navigation_id" region="west" border="true" split="true"
		title="Navigation" style="width: 210px">
		<div id="accordion_id" class="easyui-accordion" fit="true"
			border="false">
			<s:iterator value="#parentMenuBeanList" status="st"
				var="parentMenuBeanList">
				<s:if test="#st.count==1">
					<div id="<s:property value="#parentMenuBeanList.menuId"/>"
						title="<s:text name="%{#parentMenuBeanList.menuName}"/>"
						data-options="selected:true" style="overflow: auto; padding: 5px;">
						<ul id="treeId<s:property value="#parentMenuBeanList.menuId"/>"></ul>
					</div>
				</s:if>
				<s:else>
					<div id="<s:property value="#parentMenuBeanList.menuId"/>"
						title="<s:text name="%{#parentMenuBeanList.menuName}"/>">
						<ul id="treeId<s:property value="#parentMenuBeanList.menuId"/>"></ul>
					</div>
				</s:else>
			</s:iterator>
		</div>
	</div>
	<div id="mainPanle" region="center"  border="false" >
		<div id="mainTabs" class="easyui-tabs"  fit="true" border="false">
			<div title="Home">
				<div class="cs-home-remark">
					<h1>上海交通大学体育系体质管理平台</h1>
				</div>
			</div>
		</div>
	</div>
	<div id="win" class="easyui-window"
		data-options="iconCls:'icon-save',modal:true,collapsible:false,minimizable:false,maximizable:false,closed:true"
		style="width: 630px; height: 400px; padding: 5px;"></div>
	<div id="winUpload" class="easyui-window"
		data-options="iconCls:'icon-save',modal:true,collapsible:false,minimizable:false,maximizable:false,closed:true"
		style="width: 630px; height: 400px; padding: 5px;"></div>

	<div id="winPlaylist" class="easyui-window"
		data-options="iconCls:'icon-save',modal:true,collapsible:false,minimizable:false,maximizable:false,closed:true"
		style="width: 680px; height: 560px; padding: 5px;"></div>
	<div id="winmp3" class="easyui-window"
		data-options="iconCls:'icon-save',modal:true,collapsible:false,minimizable:false,maximizable:false,closed:true"
		style="width: 360px; height: 155px; padding: 5px;"></div>
	<div id="playMp3Win" class="easyui-window"
		data-options="iconCls:'icon-save',modal:true,closable:false,collapsible:false,minimizable:false,maximizable:false,closed:true"
		style="width: 360px; height: 150px; padding: 5px;"></div>

	<div id="winmp32" class="easyui-window"
		data-options="iconCls:'icon-save',collapsible:false,minimizable:false,maximizable:false,closed:true"
		style="width: 360px; height: 155px; padding: 5px;"></div>
	<div id="winItem" class="easyui-window"
		data-options="iconCls:'icon-save',modal:true,closable:false,collapsible:false,minimizable:false,maximizable:false,closed:true"
		style="width: 1100px; height: 600px; padding: 5px;"></div>
	<div id="winItem2" class="easyui-window"
		data-options="iconCls:'icon-save',modal:true,collapsible:false,minimizable:false,maximizable:false,closed:true"
		style="width: 1100px; height: 600px; padding: 5px;"></div>
	<div id="winFull" data-options="modal:true,closable:false"></div>
</body>
</html>