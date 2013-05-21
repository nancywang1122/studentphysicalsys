<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<%@ include file="../common/easyui.jsp"%>
		<script src="<rootPath:rootPath/>/layer/layer.js"></script>
		<script type="text/javascript">
function greateControl() {
	if (!+ [ 1, ]) {
		var obj = document.getElementById('mediaplayIE');
		if(obj&&obj.controls){
			obj.controls.stop();
		}
	} else {
		var obj = document.getElementById('mediaplay');
		if(obj&&obj.controls){
			obj.controls.stop();
		}
	}
	 window.parent.closeJqueryWindow();
	 //layer.close(0);
}
</script>
	</head>
	<body>
		<div class="easyui-layout" data-options="fit:true">  
	        <div data-options="region:'south'" style="height:40px" align="right">
	        	歌曲名：<s:property value='#musciName' />&nbsp;<a class="easyui-linkbutton" href="javascript:void(0)" onclick="greateControl()">关闭</a>
	        </div>  
	        <div data-options="region:'center'" align="center">  
	            <object classid="clsid:6BF52A52-394A-11d3-B153-00C04F79FAA6"  type="application/x-oleobject" width="280" height="45" id="mediaplayIE">
					<param name="quality" value="high" />
					<param name="autostart" value="1" />
					<param name="url" value="<rootPath:rootPath />/<s:property value="#mp3Path" />" />
					<embed id="mediaplay" src="<rootPath:rootPath />/<s:property value="#mp3Path" />" autostart="1" type="application/x-mplayer2" width="280" height="45"></embed>
				</object>
	        </div>  
    	</div>  
	</body>
</html>
