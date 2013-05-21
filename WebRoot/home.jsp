<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
	<head>
		<%@ include file="common/easyui.jsp"%>
		<script type="text/javascript">
$(function() {
	museCustomContractTable();
	museCustomUpdateTable();
	museReleaseTable();
	museCopyRightTable();
});

function museCustomContractTable() {
	$('#muse_custom_contract_table_id')
			.datagrid(
					{
						iconCls : 'icon-ok',
						nowrap : false,
						fit : true,
						animate : true,
						collapsible : true,
						fitColumns : true,
						url : '<rootPath:rootPath/>/listCustomContractBeans?rand=' + Math
								.random(),
						sortName : 'id',
						sortOrder : 'desc',
						remoteSort : false,
						idField : 'id',
						columns : [ [ {
							field : 'storeName',
							title : '门店名称',
							width : 65,
							sortable : true
						}, {
							field : 'strContractStopTime',
							title : '合同时间',
							width : 100,
							sortable : true
						}, {
							field : 'remarks',
							title : '提示信息',
							width : 180,
							sortable : true
						} ] ],
						pagination : true,
						rownumbers : true,
						singleSelect : true
					});
}
function museCustomUpdateTable() {
	$('#muse_custom_update_table_id').datagrid(
			{
				iconCls : 'icon-ok',
				nowrap : false,
				fit : true,
				animate : true,
				collapsible : true,
				fitColumns : true,
				url : '<rootPath:rootPath/>/listCustomDailyUpdateBeans?rand=' + Math
						.random(),
				sortName : 'id',
				sortOrder : 'desc',
				remoteSort : false,
				idField : 'id',
				columns : [ [ {
					field : 'storeName',
					title : '门店名称',
					width : 80,
					sortable : true
				}, {
					field : 'strUpdateFreq',
					title : '日常更新时间',
					width : 80,
					sortable : true
				}, {
					field : 'remarks',
					title : '提示信息',
					width : 180,
					sortable : true
				} ] ],
				pagination : true,
				rownumbers : true,
				singleSelect : true
			});
}

function museReleaseTable() {
	var muse_playlist_name_id = "1";
	$('#muse_release_table_id')
			.datagrid(
					{
						//title : '客户信息管理',
						iconCls : 'icon-ok',
						nowrap : false,
						fit : true,
						animate : true,
						collapsible : true,
						fitColumns : true,
						queryParams : {
							'musePlayListBean.playlistRelease' : muse_playlist_name_id
						},
						url : '<rootPath:rootPath/>/museplaylist/listMuseReleasePlayListBeans?rand=' + Math
								.random(),
						sortName : 'id',
						sortOrder : 'desc',
						remoteSort : false,
						idField : 'id',
						columns : [ [
								{
									field : 'id',
									title : 'ID',
									width : 40,
									sortable : true
								},
								{
									field : 'playlistName',
									title : '节目单名称',
									width : 200,
									sortable : true
								},
								{
									field : 'playlistCreatedBy',
									title : '创建人',
									width : 80,
									sortable : true
								},
								{
									field : 'playlistCount',
									title : '歌曲数量',
									width : 80,
									sortable : true
								},
								{
									field : 'strCtime',
									title : '创建时间',
									width : 120,
									sortable : true
								},
								{
									field : 'playlistUpdatedBy',
									title : '节目下发人',
									width : 80,
									sortable : true
								},
								{
									field : 'playlistReleaseCount32',
									title : '下载EXCEL',
									width : 100,
									sortable : true,
									formatter : function(value, row, index) {
										return "<a href='<rootPath:rootPath/>/museplaylist/downloadExcel?musePlayListBean.playlistId="+row.playlistId+"'><img src='<rootPath:rootPath/>/images/excel.png' style='border:0;' width='20px' height='20px' /></a>";
									}
								},{
									field : 'playlistId',
									title : '下载歌单',
									width : 100,
									sortable : true,
									formatter : function(value, row, index) {
										return "<a href='<rootPath:rootPath/>/museplaylist/downloadMusic?musePlayListBean.playlistId="+row.playlistId+"'><img src='<rootPath:rootPath/>/images/zip.png' style='border:0;' width='20px' height='20px' /></a>";
									}
								}] ],
						pagination : true,
						rownumbers : true,
						singleSelect : true
					});
}

function downloadMusic(obj) {
	var url = "<rootPath:rootPath/>/museplaylist/dowloadMusic?musePlayListBean.playlistId="
			+ obj
			+ "&rand="
			+ Math.random();
	loadtion.href=url;
}
function downloadExcel(obj) {
	var url = "<rootPath:rootPath/>/museplaylist/downloadExcel?musePlayListBean.playlistId="
			+ obj
			+ "&rand="
			+ Math.random();
	loadtion.href=url;
}

function museCopyRightTable() {
	$('#muse_copy_right_table_id')
			.datagrid(
					{
						iconCls : 'icon-ok',
						nowrap : false,
						fit : true,
						animate : true,
						collapsible : true,
						fitColumns : true,
						url : '<rootPath:rootPath/>/listCopyRightBeans?rand=' + Math
								.random(),
						sortName : 'id',
						sortOrder : 'desc',
						remoteSort : false,
						idField : 'id',
						onClickRow : function(rowIndex, rowData) {
						},
						columns : [ [ {
							field : 'copyrightName',
							title : '版权提供方',
							width : 90,
							sortable : true
						},{
							field : 'strContractStoptime',
							title : '版权到限期',
							width : 90,
							sortable : true
						}, {
							field : 'remarks',
							title : '提示信息',
							width : 200,
							sortable : true
						} ] ],
						pagination : true,
						rownumbers : true,
						singleSelect : true
					});
}
</script>
	</head>
	<body class="easyui-layout">
		<div data-options="region:'south',split:true" title="离线下载"
			style="height: 250px; padding: 10px;">
			<table id="muse_release_table_id"></table>
		</div>
		<div data-options="region:'east',split:true" title="版权到期通知"
			style="width: 430px;">
			<table id="muse_copy_right_table_id"></table>
		</div>
		<div data-options="region:'west',split:true" title="日常更新到期通知"
			style="width: 430px; padding1: 1px; overflow: hidden;">
			<table id="muse_custom_update_table_id"></table>
		</div>
		<div data-options="region:'center'" title="合同到期通知"
			style="overflow: hidden;">
			<table id="muse_custom_contract_table_id"></table>
		</div>
	</body>
</html>