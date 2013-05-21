<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
 <html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<%@ include file="../common/jstl.jsp"%>
		<script type="text/javascript">
function greateControl() {
	if (!+ [ 1, ]) {
		var obj = document.getElementById('mediaplayIE');
		obj.stop();
	} else {
		var obj = document.getElementById('mediaplay');
		obj.stop();
	}
}
</script>
	</head>
	<body>
	
	
	<div id="win" class="easyui-window" title="My Window" style="width:600px;height:400px"  
        data-options="iconCls:'icon-save',modal:true">  
    <div class="easyui-layout" data-options="fit:true">  
        <div data-options="region:'north',split:true" style="height:100px"></div>  
        <div data-options="region:'center'">  
            The Content.  
        </div>  
    </div>  
</div>
	
	
		<table align="center">
			<%--<tr>
				<td>
					歌曲名：
					<s:property value='#musciName' />
					<input type="button" onclick="greateControl()" value="click">
				</td>
			</tr>
			--%><tr>
				<td>
					<object id="mediaplayIE" width="280" height="50" type="application/x-oleobject">
						<param name="FileName" value="<rootPath:rootPath />/<s:property value='#mp3Path' />">
						<param name="AutoStart" value="1">
						<param name="ShowControls" value="1">
						<param name="ShowPositionControls" value="0">
						<param name="ShowAudioControls" value="1">
						<param name="ShowTracker" value="1">
						<param name="ShowDisplay" value="0">
						<param name="ShowStatusBar" value="1">
						<param name="AutoSize" value="0">
						<param name="ShowGotoBar" value="0">
						<param name="ShowCaptioning" value="0">
						<param name="AutoStart" value="1">
						<param name="PlayCount" value="0">
						<param name="AnimationAtStart" value="0">
						<param name="TransparentAtStart" value="0">
						<param name="AllowScan" value="0">
						<param name="EnableContextMenu" value="0">
						<param name="ClickToPlay" value="0">
						<param name="InvokeURLs" value="1">
						<param name="DefaultFrame" value="datawindow">
						<embed id="mediaplay" src="<rootPath:rootPath />/<s:property value='#mp3Path' />" align="baseline" border="0"
							width="280" height="50" type="application/x-mplayer2"
							pluginspage="http://www.microsoft.com/isapi/redir.dll?prd=windows&amp;sbp=mediaplayer&amp;ar=media&amp;sba=plugin&amp;"
							name="MediaPlayer" showcontrols="1" showpositioncontrols="0"
							showaudiocontrols="1" showtracker="1" showdisplay="0"
							showstatusbar="1" autosize="0" showgotobar="0" showcaptioning="0"
							autostart="1" autorewind="0" animationatstart="0"
							transparentatstart="0" allowscan="1" enablecontextmenu="0"
							clicktoplay="0" invokeurls="1" defaultframe="datawindow">
						</embed>
					</object>
					<!--
					<object classid="clsid:6BF52A52-394A-11d3-B153-00C04F79FAA6" width="250" height="50" id="mediaplayIE">
						<param name="quality" value="high" />
						<param name="autostart" value="1" />
						<param name="url" value="<rootPath:rootPath />/<s:property value="#mp3Path" />" />
						<embed id="mediaplay" src="<rootPath:rootPath />/<s:property value="#mp3Path" />" autostart="1" type="application/x-mplayer2" width="250" height="50"></embed>
					</object>
					<embed src="<rootPath:rootPath />/<s:property value="#mp3Path" />"
						type="application/x-mplayer2" showcontrols="1"
						showaudiocontrols="1" showstatusbar="1" autostart="1" loop="1"
						enablecontextmenu="1"></embed>
					 
					 
					<embed src="<rootPath:rootPath />/<s:property value="#mp3Path" />"
						type="application/x-mplayer3" loop="true" ShowStatusBar="true"
						ShowPositionControls="true" showaudiocontrols="true"
						showstatusbar="true" EnableContextMenu="true" height="20px" autostart="false">
					</embed>

					<embed src="http://www.mapleflying.com/player/player.swf"
						quality="high" width="290" height="24" name="mp3player"
						type="application/x-shockwave-flash"
						pluginspage="http://www.macromedia.com/go/getflashplayer"
						flashvars="autostart=yes&soundFile=<rootPath:rootPath />/<s:property value='#mp3Path' />?autoplay=1"></embed>
					-->
				</td>
			</tr>
		</table>
	</body>
</html>
