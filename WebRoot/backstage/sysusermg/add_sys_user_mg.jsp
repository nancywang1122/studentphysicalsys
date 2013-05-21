<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
	<head>
		<%@ include file="../../common/easyui.jsp"%>
		<style type="text/css">
.font_weight {
	font-weight: bold;
	font-size: 12px;
}
</style>
		<script type="text/javascript">
function _reset() {
	$("#user_form_id")[0].reset();

}

$.extend($.fn.validatebox.defaults.rules, {
	remoteDefine : {
		validator : function(value, param) {
			var userName_id = $("#userName_id").val();
			var url = '<rootPath:rootPath/>/sysuser/checkUserName?rand='+ Math.random() + '&userName=' + userName_id;
			var result = $.ajax( {
				url : url,
				async : false,
				cache : false,
				type : "post"
			}).responseText;
			return result == "true";
		},
		message : "用户名已经存在!"
	}
});

function formSubmit() {
	$('#user_form_id')
			.form(
					'submit',
					{
						url : '<rootPath:rootPath/>/sysuser/addSysUserBean?rand=' + Math
								.random(),
						method : 'post',
						onSubmit : function() {
							if ($(this).form('validate')) {
								window.parent.showProgress();
								return true;
							} else {
								return false;
							}
						},
						success : function(data) {
							window.parent.closeProgress();
							window.parent.showWindow(eval(data)[0].info);
							window.parent.refreshSysUserTable();
							window.parent.closeWindow('#win');
						}
					});
}
</script>
	</head>
	<body>
		<div class="easyui-layout" data-options="fit:true">
			<div data-options="region:'center',border:false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc;">
				<form action="" method="post" id="user_form_id" novalidate>
					<table align="left" style="padding-top: 10px;">
						<tr>
							<td class="font_weight">
								用户名:
							</td>
							<td>
								<input type="text" id="userName_id" name="sysUserBean.userName"
									style="width: 150px;" class="easyui-validatebox"
									data-options="required:true,validType:'remoteDefine'"
									onkeyup="value=value.replace(/[\W]/g,'')"
									onchange="value=value.replace(/[\W]/g,'')"
									onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))"
									maxlength="30" />
							</td>
							<td class="font_weight">
								密码:
							</td>
							<td>
								<input type="text" name="sysUserBean.userPassword"
									style="width: 150px;" class="easyui-validatebox"
									data-options="required:true,validType:'length[6,6]',invalidMessage:'密码长度为6位!'" />
							</td>
						</tr>
						<tr>
							<td class="font_weight">
								第一个名字:
							</td>
							<td>
								<input type="text" name="sysUserBean.userFirstName"
									style="width: 150px;" class="easyui-validatebox"
									data-options="required:true,validType:'maxLength[10]',invalidMessage:'长度最长为10位!'" />
							</td>
							<td class="font_weight">
								后一个名字:
							</td>
							<td>
								<input type="text" name="sysUserBean.userLastName"
									style="width: 150px;" class="easyui-validatebox"
									data-options="required:true,validType:'maxLength[10]',invalidMessage:'长度最长为10位!'" />
							</td>
						</tr>
						<tr>
							<td class="font_weight">
								Email:
							</td>
							<td>
								<input type="text" name="sysUserBean.userEmail"
									style="width: 150px;" class="easyui-validatebox"
									data-options="required:true,validType:'email'" maxlength="30" />
							</td>
							<td class="font_weight">
								职务级别:
							</td>
							<td>
								<input type="radio" name="sysUserBean.superuserFlag" value=0
									checked="checked" />
								职员&nbsp;&nbsp;
								<input type="radio" name="sysUserBean.superuserFlag" value=1 />
								管理员
							</td>
						</tr>
						<tr>
							<td class="font_weight">
								用户所属角色:
							</td>
							<td>
								<input id="cc" name="sysUserBean.userRoleId"
									class="easyui-combotree"
									data-options="url:'<rootPath:rootPath/>/sysrightmg/listSysRoleBeans',required:true"
									style="width: 150px;">
							</td>
							<td class="font_weight">
								用户所在部门:
							</td>
							<td>
								<input id="ccc" name="sysUserBean.userDepartId"
									class="easyui-combotree"
									data-options="url:'<rootPath:rootPath/>/sysrightmg/listSysDepartBeans',required:true"
									style="width: 150px;">
							</td>
						</tr>
					</table>
				</form>
			</div>
			<div data-options="region:'south',border:false"
				style="text-align: right; padding: 5px 0;">
				<a class="easyui-linkbutton" data-options="iconCls:'icon-ok'"
					href="javascript:void(0)" id="submit_id" onclick="formSubmit()">保存</a>
				<a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'"
					href="javascript:void(0)" id="reset_id" onclick="_reset()">取消</a>
			</div>
		</div>
	</body>
</html>