<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<%@ include file="../common/easyui.jsp"%>
	</head>
	<body>
		<table align="center">
			<tr>
				<td>
					<!-- 
					<embed src="<rootPath:rootPath />/<s:property value="#mp3Path" />"
						type="application/x-mplayer3" loop="true" ShowStatusBar="true"
						ShowPositionControls="true" showaudiocontrols="true"
						showstatusbar="true" EnableContextMenu="true" height="20px" autostart="false">
					</embed>
					
					<object>
						<param name="url"
							value="<rootPath:rootPath />/<s:property value="#mp3Path" />" />
						<param name="showcontrols" value="1" />
						<param name="showaudiocontrols" value="1" />
						<param name="showstatusbar" value="1" />
						<param name="autostart" value="1" />
						<param name="loop" value="1" />
						<param name="enablecontextmenu" value="1" />
						<embed type="application/x-mplayer2"
							showcontrols="1" showaudiocontrols="1" showstatusbar="1"
							autostart="1" loop="1" enablecontextmenu="1"
							src="<rootPath:rootPath />/<s:property value="#mp3Path" />"></embed>
					</object>
					 -->
					 <embed src="<rootPath:rootPath />/<s:property value="#mp3Path" />"
						type="application/x-mplayer2" showcontrols="1"
						showaudiocontrols="1" showstatusbar="1" autostart="1" loop="1"
						enablecontextmenu="1"></embed>
				</td>
			</tr>
		</table>
	</body>
</html>
