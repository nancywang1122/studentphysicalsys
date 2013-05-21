function showProgress() {
	var win = $.messager.progress( {
		title : '请等待!',
		msg : '正在提交...'
	});
	return win;
}
function closeProgress() {
	setTimeout(function() {
		$.messager.progress('close');
	}, 3000);
}

function createFrame(id, url) {
	var s = "<iframe scrolling='auto' name='" + id + "' id='" + id+ "' frameborder='0' src='" + url+ "' style='width:100%;height:99%;'></iframe>";
	return s;
}
function showWindow(data) {
	$.messager.show( {
		title : '提示',
		msg : data
	});
}

function openWindowUpload(title, url) {
	$('#winUpload').window({
		title:title,
		draggable:false,
		content:url,
		onBeforeClose:function(){
			if (confirm('窗口正在关闭，请确认您当前的上传歌曲操作已结束。\n 是否继续关闭窗口？')) {
				$('#winUpload').window({closed:false,content:'<iframe></iframe>'});
				$('#winUpload').window('close',true);
			  	var currTab = $('#mainTabs').tabs('getSelected');
				var panelTab = currTab.panel('options');
				var frames = document.getElementById(panelTab.title);
				frames.contentWindow.searchmuseTempMusicTable();
			}else{
					return false;
				}
			}
	});
	$('#winUpload').window('open');
}

function refreshSysUserTable() {
	var currTab = $('#mainTabs').tabs('getSelected');
	var panelTab = currTab.panel('options');
	var frames = document.getElementById(panelTab.title);
	frames.contentWindow.sysUserTable();
}
function refreshMuseTagTable() {
	var currTab = $('#mainTabs').tabs('getSelected');
	var panelTab = currTab.panel('options');
	var frames = document.getElementById(panelTab.title);
	frames.contentWindow.searchMuseTagTable();
}
function refreshMuseTempMusicTable() {
	var currTab = $('#mainTabs').tabs('getSelected');
	var panelTab = currTab.panel('options');
	var frames = document.getElementById(panelTab.title);
	frames.contentWindow.searchmuseTempMusicTable();
}

function refreshMuseItemTable() {
	var currTab = $('#mainTabs').tabs('getSelected');
	var panelTab = currTab.panel('options');
	var frames = document.getElementById(panelTab.title);
	frames.contentWindow.searchMusePlayListTable();
}

function refreshMuseMyUploadMusicTable() {
	var currTab = $('#mainTabs').tabs('getSelected');
	var panelTab = currTab.panel('options');
	var frames = document.getElementById(panelTab.title);
	frames.contentWindow.museMyMusicTable();
}

function refreshMuseOfficialMusicTable() {
	var currTab = $('#mainTabs').tabs('getSelected');
	var panelTab = currTab.panel('options');
	var frames = document.getElementById(panelTab.title);
	frames.contentWindow.searchmuseOfficialMusicTable();
}
function refreshMuseMyMusicTable() {
	var currTab = $('#mainTabs').tabs('getSelected');
	var panelTab = currTab.panel('options');
	var frames = document.getElementById(panelTab.title);
	frames.contentWindow.searchmuseMyMusicTable();
}

function refreshPlaylist_music(obj) {
	var currTab = $('#mainTabs').tabs('getSelected');
	var panelTab = currTab.panel('options');
	var frames = document.getElementById(panelTab.title);
	frames.contentWindow.musePlayListMusicTable(obj);
}
function refreshPlaylist_term(obj) {
	var currTab = $('#mainTabs').tabs('getSelected');
	var panelTab = currTab.panel('options');
	var frames = document.getElementById(panelTab.title);
	frames.contentWindow.musePlayListTermTable(obj);
}
function refreshPlaylist() {
	var currTab = $('#mainTabs').tabs('getSelected');
	var panelTab = currTab.panel('options');
	var frames = document.getElementById(panelTab.title);
	frames.contentWindow.refreshMusePlayListTable();
}

function refreshTerm() {
	var currTab = $('#mainTabs').tabs('getSelected');
	var panelTab = currTab.panel('options');
	var frames = document.getElementById(panelTab.title);
	frames.contentWindow.reloadMuseTermTable();
}

function refreshMuseCopyRightTable() {
	var currTab = $('#mainTabs').tabs('getSelected');
	var panelTab = currTab.panel('options');
	var frames = document.getElementById(panelTab.title);
	frames.contentWindow.reloadmuseCopyRightTable();
}

function refreshTermByParam(obj) {
	var currTab = $('#mainTabs').tabs('getSelected');
	var panelTab = currTab.panel('options');
	var frames = document.getElementById(panelTab.title);
	frames.contentWindow._searchMuseTerm(obj);
}

function refreshStore(obj) {
	var currTab = $('#mainTabs').tabs('getSelected');
	var panelTab = currTab.panel('options');
	var frames = document.getElementById(panelTab.title);
	frames.contentWindow._searchMuseStore(obj);
}

function refreshStore2() {
	var currTab = $('#mainTabs').tabs('getSelected');
	var panelTab = currTab.panel('options');
	var frames = document.getElementById(panelTab.title);
	frames.contentWindow._reloadCustom();
}
function refreshSysUserTable() {
	var currTab = $('#mainTabs').tabs('getSelected');
	var panelTab = currTab.panel('options');
	var frames = document.getElementById(panelTab.title);
	frames.contentWindow.searchSysUserTable();
}
function refreshCustom() {
	var currTab = $('#mainTabs').tabs('getSelected');
	var panelTab = currTab.panel('options');
	var frames = document.getElementById(panelTab.title);
	frames.contentWindow._searchCustom();
}
function refreshMuseDBTable() {
	var currTab = $('#mainTabs').tabs('getSelected');
	var panelTab = currTab.panel('options');
	var frames = document.getElementById(panelTab.title);
	frames.contentWindow.museDBTable();
}

function removeWindow(url) {
	$.messager.confirm("提示", "您确定要删除此项吗?", function(r) {
		if (r) {
			$.ajax( {
				url : url,
				cache : false,
				success : function(data) {
					$.messager.show( {
						title : '提示',
						msg : eval(data)[0].info
					});
				}
			});
		}
	});
}

function refreshRePairlist() {
	//var currTab = $('#mainTabs').tabs('getSelected');
	//var panelTab = currTab.panel('options');
	var frames = document.getElementById("muse_repair_table_id");
	frames.contentWindow.museRepairTable();
}
function removeRepairWindow(url) {
	$.messager.confirm("提示", "您确定要删除此项吗?", function(r) {
		if (r) {
			$.ajax( {
				url : url,
				cache : false,
				success : function(data) {
					$.messager.show( {
						title : '提示',
						msg : eval(data)[0].info
					});
					return true;
				}
			});
		}
	});
}
function removePlayList(url) {
	$.messager.confirm("提示", "您确定要删除此项吗?", function(r) {
		if (r) {
			$.ajax( {
				url : url,
				cache : false,
				success : function(data) {
					$.messager.show( {
						title : '提示',
						msg : eval(data)[0].info
					});
					refreshPlaylist();
				}
			});
		}
	});
}
function removePlayListMusic(url) {
	$.messager.confirm("提示", "您确定要删除此项吗?", function(r) {
		if (r) {
			$.ajax( {
				url : url,
				cache : false,
				success : function(data) {
					$.messager.show( {
						title : '提示',
						msg : eval(data)[0].info
					});
					refreshMuseItemTable();
				}
			});
		}
	});
}

function cancelPlayList(url) {
	$.messager.confirm("提示", "您确定要取消此项吗?", function(r) {
		if (r) {
			$.ajax( {
				url : url,
				cache : false,
				success : function(data) {
					$.messager.show( {
						title : '提示',
						msg : eval(data)[0].info
					});
					refreshPlaylist();
				}
			});
		}
	});
}

function removeBindMusic(url, obj) {
	$.messager.confirm("提示", "您确定要删除此项吗?", function(r) {
		if (r) {
			$.ajax( {
				url : url,
				cache : false,
				success : function(data) {
					$.messager.show( {
						title : '提示',
						msg : eval(data)[0].info
					});
					refreshPlaylist_music(obj);
					refreshPlaylist();
				}
			});
		}
	});
}

function removeBindTerm(url, obj) {
	$.messager.confirm("提示", "您确定要删除此项吗?", function(r) {
		if (r) {
			$.ajax( {
				url : url,
				cache : false,
				success : function(data) {
					$.messager.show( {
						title : '提示',
						msg : eval(data)[0].info
					});
					refreshPlaylist_term(obj);
					refreshPlaylist();
				}
			});
		}
	});
}

function removeMuseMyMusicTable(url) {
	$.messager.confirm("提示", "您确定要删除此项吗?", function(r) {
		if (r) {
			$.ajax( {
				url : url,
				cache : false,
				success : function(data) {
					$.messager.show( {
						title : '提示',
						msg : eval(data)[0].info
					});
					refreshMuseMyMusicTable();
				}
			});
		}
	});
}

function removeMuseTempMusicTable(url) {
	$.messager.confirm("提示", "您确定要删除此项吗?", function(r) {
		if (r) {
			$.ajax( {
				url : url,
				cache : false,
				success : function(data) {
					$.messager.show( {
						title : '提示',
						msg : eval(data)[0].info
					});
					refreshMuseTempMusicTable();
				}
			});
		}
	});
}
function removeMuseOfficialMusicTable(url) {
	$.messager.confirm("提示", "您确定要删除此项吗?", function(r) {
		if (r) {
			$.ajax( {
				url : url,
				cache : false,
				success : function(data) {
					$.messager.show( {
						title : '提示',
						msg : eval(data)[0].info
					});
					refreshMuseOfficialMusicTable();
					closeWindow(obj);
				}
			});
		}
	});
}
function removeMuseMyMusicTableAndClose(url, obj) {
	$.messager.confirm("提示", "您确定要删除此项吗?", function(r) {
		if (r) {
			$.ajax( {
				url : url,
				cache : false,
				success : function(data) {
					$.messager.show( {
						title : '提示',
						msg : eval(data)[0].info
					});
					refreshMuseMyUploadMusicTable();
					closeWindow(obj);
				}
			});
		}
	});
}

function removeMuseTempMusicTableAndClose(url, obj) {
	$.messager.confirm("提示", "您确定要删除此项吗?", function(r) {
		if (r) {
			$.ajax( {
				url : url,
				cache : false,
				success : function(data) {
					$.messager.show( {
						title : '提示',
						msg : eval(data)[0].info
					});
					refreshMuseTempMusicTable();
					closeWindow(obj);
				}
			});
		}
	});
}

function removeMuseTempMusicTableAndCloseJquery(url) {
	$.messager.confirm("提示", "您确定要删除此项吗?", function(r) {
		if (r) {
			$.ajax( {
				url : url,
				cache : false,
				success : function(data) {
					$.messager.show( {
						title : '提示',
						msg : eval(data)[0].info
					});
					refreshMuseTempMusicTable();
					closeJqueryWindow();
				}
			});
		}
	});
}

function removeMuseOfficialMusicTableAndClose(url, obj) {
	$.messager.confirm("提示", "您确定要删除此项吗?", function(r) {
		if (r) {
			$.ajax( {
				url : url,
				cache : false,
				success : function(data) {
					$.messager.show( {
						title : '提示',
						msg : eval(data)[0].info
					});
					refreshMuseOfficialMusicTable();
					closeWindow(obj);
				}
			});
		}
	});
}

function removeTerm(url) {
	$.messager.confirm("提示", "您确定要删除此项吗?", function(r) {
		if (r) {
			$.ajax( {
				url : url,
				cache : false,
				success : function(data) {
					$.messager.show( {
						title : '提示',
						msg : eval(data)[0].info
					});
					refreshTerm();
				}
			});
		}
	});
}

function removeMuseCopyRight(url) {
	$.messager.confirm("提示", "您确定要删除此项吗?", function(r) {
		if (r) {
			$.ajax( {
				url : url,
				cache : false,
				success : function(data) {
					$.messager.show( {
						title : '提示',
						msg : eval(data)[0].info
					});
					refreshMuseCopyRightTable();
				}
			});
		}
	});
}
function removeTermByParam(url, obj) {
	$.messager.confirm("提示", "您确定要删除此项吗?", function(r) {
		if (r) {
			$.ajax( {
				url : url,
				cache : false,
				success : function(data) {
					$.messager.show( {
						title : '提示',
						msg : eval(data)[0].info
					});
					refreshTermByParam(obj);
				}
			});
		}
	});
}

function removeStore(url, obj) {
	$.messager.confirm("提示", "您确定要删除此项吗?", function(r) {
		if (r) {
			$.ajax( {
				url : url,
				cache : false,
				success : function(data) {
					$.messager.show( {
						title : '提示',
						msg : eval(data)[0].info
					});
					refreshStore(obj);
					refreshTermByParam("");
				}
			});
		}
	});
}

function removeSysUser(url) {
	$.messager.confirm("提示", "您确定要删除此项吗?", function(r) {
		if (r) {
			$.ajax( {
				url : url,
				cache : false,
				success : function(data) {
					$.messager.show( {
						title : '提示',
						msg : eval(data)[0].info
					});
					refreshSysUserTable();
				}
			});
		}
	});
}

function removeStore2(url) {
	$.messager.confirm("提示", "您确定要删除此项吗?", function(r) {
		if (r) {
			$.ajax( {
				url : url,
				cache : false,
				success : function(data) {
					$.messager.show( {
						title : '提示',
						msg : eval(data)[0].info
					});
					refreshStore2();
				}
			});
		}
	});
}

function removeCustom(url) {
	$.messager.confirm("提示", "您确定要删除此项吗?", function(r) {
		if (r) {
			$.ajax( {
				url : url,
				cache : false,
				success : function(data) {
					$.messager.show( {
						title : '提示',
						msg : eval(data)[0].info
					});
					refreshCustom();
					refreshStore("");
					refreshTermByParam("");
				}
			});
		}
	});
}

function removeMuseTag(url) {
	$.messager.confirm("提示", "您确定要删除此项吗?", function(r) {
		if (r) {
			$.ajax( {
				url : url,
				cache : false,
				success : function(data) {
					$.messager.show( {
						title : '提示',
						msg : eval(data)[0].info
					});
					refreshMuseTagTable();
				}
			});
		}
	});
}

function formSubmitMuseMusicTemp(url) {
	$.messager.confirm("提示", "您确定要执行此操作吗?", function(r) {
		if (r) {
			$('#updateMuseMusic_form_id').form('submit', {
				url : url,
				method : 'post',
				onSubmit : function() {
					if ($(this).form('validate')) {
						showProgress();
						return true;
					} else {
						return false;
					}
				},
				success : function(data) {
					closeProgress();
					showWindow(eval(data)[0].info);
					refreshMuseTempMusicTable();
					closeWindow('#winFull');
				}
			});
		}
	});
}

function alertWindow(title, data) {
	$.messager.alert(title, data);
}

function openWindow(title, url) {
	$('#win').window({
		title:title,
		draggable:false,
		content:url,
		onBeforeClose:function(){
			// $('#win').window({closed:false,content:url});
			$('#win').window({closed:false,content:'<iframe></iframe>'});
			$('#win').window('close',true);
		}
	});
	$('#win').window('open');
}


function openPlayListWindow(title, url) {
	$('#winPlaylist').window({
		title:title,
		content:url,
		draggable:false,
		onBeforeClose:function(){
			// $('#winPlaylist').window({closed:false,content:url});
			$('#winPlaylist').window({closed:false,content:'<iframe></iframe>'});
			$('#winPlaylist').window('close',true);
		}
	});
	$('#winPlaylist').window('open');
}

function openMp3Window(title, url) {
	$('#winmp3').window({
		title:title,
		content:url,
		cache : false,
		draggable:false,
		onBeforeClose:function(){
			$('#winmp3').window({closed:false,content:'<iframe></iframe>'});
			$('#winmp3').window('close',true);
		}
	});
	$('#winmp3').window('open');
}
function openMusicMp3Window(title, url) {
	$('#playMp3Win').window({
		title:title,
		content:url,
		cache : false,
		draggable:false,
		onBeforeClose:function(){
			$('#playMp3Win').window({closed:false,content:'<iframe></iframe>'});
			$('#playMp3Win').window('close',true);
		}
	});
	$('#playMp3Win').window('open');
}
var iIndex=null;
function closeJqueryWindow() {
	// alert(iIndex);
	layer.close(iIndex);
}

function openJqueryMp3Window(title, url) {
	iIndex=null;
	iIndex = $.layer({
	    type : 2,
	    title : [title,true],
	    move : ['.xubox_title' , false],
	    closeBtn : [0 , false],
	    border : [10 , 0.3 , '#000', false],
	    iframe : {src : url},
	    area : ['360px' , '150px'],
	    offset : ['100px','']
	});
}

function openFullJqueryMp3Window(title, url) {
	iIndex=null;
	iIndex = $.layer({
	    type : 2,
	    title : [title,true],
	    move : ['.xubox_title' , false],
	    closeBtn : [0 , false],
	    border : [10 , 0.3 , '#000', false],
	    iframe : {src : url},
	    area : [$(document).width() , $(document).height()],
	    offset : ['-10px','']
	});
}

function openMp32Window(title, url) {
	$('#winmp32').window({
		title:title,
		content:url,
		draggable:false,
		onBeforeClose:function(){
			$('#winmp32').window({closed:false,content:'<iframe></iframe>'});
			$('#winmp32').window('close',true);
		}
	});
	$('#winmp32').window('open');
}

function openItemWindow(title, url) {
	$('#winItem').window({
		title:title,
		content:url,
		width:1100,
		height:600,
		draggable:false,
		onBeforeClose:function(){
			$('#winItem').window({closed:false,content:'<iframe></iframe>'});
			$('#winItem').window('close',true);
		}
	});
	$('#winItem').window('open');
}

function openItemWindow2(title, url) {
	$('#winItem2').window({
		title:title,
		content:url,
		width:1100,
		height:600,
		draggable:false,
		onBeforeClose:function(){
			$('#winItem2').window({closed:false,content:'<iframe></iframe>'});
			$('#winItem2').window('close',true);
		}
	});
	$('#winItem2').window('open');
}

function openWindow(title,url,width,height) {
	$('#win').window({
		title:title,
		width:width,
		height:height,
		content:url,
		draggable:false,
		onBeforeClose:function(){
			$('#win').window({closed:false,content:'<iframe></iframe>'});
			$('#win').window('close',true);
		}
	});
	$('#win').window('open');
}

$(function(){
	$('#winFull').window({  
	    width:$(document).width(),  
	    height:$(document).height(),
	    iconCls:'icon-save',
	    modal:true,
	    collapsible:false,
	    minimizable:false,
	    maximizable:false,
	    closed:true,
	    modal:true  
	});
});

function openWindowAuto(title,url) {
	$('#winFull').window({
		title:title,
		content:url,
		draggable:false,
		onBeforeClose:function(){
		    	$('#winFull').window({closed:false,content:'<iframe></iframe>'});
		    	$('#winFull').window('close',true);// 这里调用close 方法，true,表示面板被关闭的时候忽略onBeforeClose 回调函数。
		}
	});
	$('#winFull').window('open');
}


function closeWindow() {
	$('#win').window('close');
}
function closeFullWindow() {
	$('#winFull').window('close');
}
function closeWindow(obj) {
	$(obj).window('close');
}

function submitMuseItemPrompt(r,url){
	$.ajax( {
		url : url+encodeURIComponent(encodeURIComponent(r)),
		cache : false,
		success : function(data) {
			$.messager.show( {
				title : '提示',
				msg : eval(data)[0].info
			});
			refreshMuseItemTable();
		}
	});
}
function backupDB(url) {
	$.messager.confirm("提示", "您确定要备份数据吗?", function(r) {
		if (r) {
			showProgress();
			$.ajax( {
				url : url,
				cache : false,
				success : function(data) {
					closeProgress();
					$.messager.show( {
						title : '提示',
						msg : eval(data)[0].info
					});
					refreshMuseDBTable();
				}
			});
		}
	});
}
function storeDB(url) {
	$.messager.confirm("提示", "您确定要还原数据吗?", function(r) {
		if (r) {
			showProgress();
			$.ajax( {
				url : url,
				cache : false,
				success : function(data) {
				closeProgress();
					$.messager.show( {
						title : '提示',
						msg : eval(data)[0].info
					});
					refreshMuseDBTable();
				}
			});
		}
	});
}
function openPrompt(title,content,url){
	$.messager.prompt(title, content, function(r){
		if (r){
			submitMuseItemPrompt(r,url);
		}
	});
}

function tabClose() {
	/* 双击关闭TAB选项卡 */
	$(".tabs-inner").dblclick(function() {
		var subtitle = $(this).children(".tabs-closable").text();
		$('#mainTabs').tabs('close', subtitle);
	});
	/* 为选项卡绑定右键 */
	$(".tabs-inner").bind('contextmenu', function(e) {
		$('#mm').menu('show', {
			left : e.pageX,
			top : e.pageY
		});
		var subtitle = $(this).children(".tabs-closable").text();
		$('#mm').data("currtab", subtitle);
		$('#mainTabs').tabs('select', subtitle);
		return false;
	});
}
// 绑定右键菜单事件
function tabCloseEven() {
	// 刷新
	$('#mm-tabupdate').click(function() {
		var currTab = $('#mainTabs').tabs('getSelected');
		var panelTab = currTab.panel('options');
		var url = $(currTab.panel('options').content).attr('src');
		if (url != undefined && currTab.panel('options').title != '首页') {
			$('#mainTabs').tabs('update', {
				tab : currTab,
				options : {
					content : createFrame( panelTab.title,url)
				}
			});
		}
	});
	// 关闭当前
	$('#mm-tabclose').click(function() {
		var currtab_title = $('#mm').data("currtab");
		$('#mainTabs').tabs('close', currtab_title);
	});
	// 全部关闭
	$('#mm-tabcloseall').click(function() {
		$('.tabs-inner span').each(function(i, n) {
			var t = $(n).text();
			if (t != '首页') {
				$('#mainTabs').tabs('close', t);
			}
		});
	});
	// 关闭除当前之外的TAB
	$('#mm-tabcloseother').click(function() {
		var prevall = $('.tabs-selected').prevAll();
		var nextall = $('.tabs-selected').nextAll();
		if (prevall.length > 0) {
			prevall.each(function(i, n) {
				var t = $('a:eq(0) span', $(n)).text();
				if (t != '首页') {
					$('#mainTabs').tabs('close', t);
				}
			});
		}
		if (nextall.length > 0) {
			nextall.each(function(i, n) {
				var t = $('a:eq(0) span', $(n)).text();
				if (t != '首页') {
					$('#mainTabs').tabs('close', t);
				}
			});
		}
		return false;
	});
	// 关闭当前右侧的TAB
	$('#mm-tabcloseright').click(function() {
		var nextall = $('.tabs-selected').nextAll();
		if (nextall.length == 0) {
			// msgShow('系统提示','后边没有啦~~','error');
			alert('后边没有啦~~');
			return false;
		}
		nextall.each(function(i, n) {
			var t = $('a:eq(0) span', $(n)).text();
			$('#mainTabs').tabs('close', t);
		});
		return false;
	});
	// 关闭当前左侧的TAB
	$('#mm-tabcloseleft').click(function() {
		var prevall = $('.tabs-selected').prevAll();
		if (prevall.length == 0) {
			alert('到头了，前边没有啦~~');
			return false;
		}
		prevall.each(function(i, n) {
			var t = $('a:eq(0) span', $(n)).text();
			$('#mainTabs').tabs('close', t);
		});
		return false;
	});
	// 退出
	$("#mm-exit").click(function() {
		$('#mm').menu('hide');
	});
}