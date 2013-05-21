<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ include file="../common/easyui.jsp"%>
<script type="text/javascript">

function showProgress() {
	var win = $.messager.progress( {
		//title : '请等待!',
		text:'正在验证,请等待'
	});
	return win;
}
function closeProgress() {
	setTimeout(function() {
		$.messager.progress('close');
	}, 5000);
}
function _reload() {
	location.reload();
}
$(document).keydown(function(event) {
	if (event.keyCode == '13') {
		formSubmit();
	}
});

function formSubmit() {
	$('#login_form_id').form('submit', {
		url : '<rootPath:rootPath/>/login?rand=' + Math.random(),
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
			if (eval(data)[0].result == "1") {
				setTimeout(function() {
					$.messager.progress('close');
					location.href = "home";
				}, 3000);
				$.messager.show( {
					title : '提示',
					msg : eval(data)[0].info
				});
			} else {
				setTimeout(function() {
					$.messager.progress('close');
				}, 3000);
				$.messager.show( {
					title : '提示',
					msg : eval(data)[0].info
				});
			}
		}
	});
}
</script>
</head>

<body
	style="height: 100%; width: 100%; overflow: hidden; border: none; padding: 20px">
	<div id="w" class="easyui-window"
		data-options="title:'用户登陆',modal:true,collapsible:false,minimizable:false,maximizable:false,closable:false"
		style="width: 500px; height: 250px; padding: 5px;">
		<div class="easyui-layout" data-options="fit:true">
			<div data-options="region:'center',border:false"
				style="padding: 5px; background: #fff; border: 1px solid #ccc;">
				<form action="" method="post" id="login_form_id" novalidate>
					<table border="0" width="100%" height="87%">
						<tr>
							<td width="45%">
								<table>
									<tr>
										<td>用户名:</td>
										<td><input class="easyui-validatebox" type="text"
											name="sysUserBean.userAccount" style="width: 120px"
											data-options="required:true" value=""></input></td>
									</tr>
									<tr>
										<td>密码:</td>
										<td><input class="easyui-validatebox"
											style="width: 120px" type="password"
											name="sysUserBean.userPassword" data-options="required:true"
											value=""></input></td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</form>
			</div>
			<div data-options="region:'south',border:false"
				style="text-align: right; padding: 5px 0;">
				<a class="easyui-linkbutton" data-options="iconCls:'icon-ok'"
					href="javascript:void(0)" id="submit_id" onclick="formSubmit()">登陆</a>
			</div>
		</div>
	</div>
</body>
</html>
