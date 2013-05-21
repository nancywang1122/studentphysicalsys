<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ include file="../common/jstl.jsp"%>
<link rel="stylesheet" href="<rootPath:rootPath/>/ext/css/UploadPanel.css" >
<link rel="stylesheet" type="text/css" href="<rootPath:rootPath/>/ext/css/ext-all.css" />

<script type="text/javascript" src="<rootPath:rootPath/>/ext/ext-base.js"></script>
<script type="text/javascript" src="<rootPath:rootPath/>/ext/ext-all.js"></script>

<script type="text/javascript" src="<rootPath:rootPath/>/extswfupload/swfupload/swfupload.js"></script>
<script type="text/javascript" src="<rootPath:rootPath/>/extswfupload/UploadPanel.js"></script>
</head>
<script type="text/javascript">
/**
Ext.onReady(function(){
	Ext.QuickTips.init();
	new Ext.Window({
		width : 650,
		title : 'swfUpload demo',
		height : 300,
		layout : 'fit',
		items : [
			{
				xtype:'uploadPanel',
				border : false,
				fileSize : 1024*50,
				uploadUrl : 'uploadFiles.action',
				flashUrl : '<rootPath:rootPath/>/extswfupload/swfupload/swfupload.swf',
				filePostName : 'file',
				fileTypes : '*.mp3',
				postParams : {savePath:'upload\\'}
			}
		]
	}).show();
});
*/

Ext.onReady(function() {
    var win = new Ext.Window({
        //title : '多文件上传示例',
        width : 700,
        height : 400,
        resizable : false,
        layout : 'fit',
        items : [{
            xtype : 'uploadPanel',
            uploadUrl : '<rootPath:rootPath/>/musemusic/uploadFiles',
            filePostName : 'myUpload', // 这里很重要，默认值为'fileData',这里匹配action中的setMyUpload属性
            flashUrl : '<rootPath:rootPath/>/extswfupload/swfupload/swfupload.swf',
            fileSize : 1024*500,
            height : 400,
            border : true,
            fileTypes : '*.mp3', // 在这里限制文件类型:'*.jpg,*.png,*.gif'
            fileTypesDescription : '所有文件',
            postParams : {
                path : 'music' // 上传到服务器的files目录下面
            }
        }]
    });
    win.show();
});
</script>
<body>

</body>
</html>