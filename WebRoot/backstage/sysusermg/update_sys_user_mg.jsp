<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
	<head>
		<%@ include file="../../common/easyui.jsp"%>
		<style type="text/css">
.font_weight {
	font-weight: bold;font-size: 12px;
}
</style>
		<script type="text/javascript">
function _reset() {
	$("#user_form_id")[0].reset();
}
function formSubmit() {
	$('#user_form_id')
			.form(
					'submit',
					{
						url : '<rootPath:rootPath/>/sysuser/updateSysUserBean?rand=' + Math
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
					<input type="hidden" name="sysUserBean.userId"
						value="<s:property value="sysUserBean.userId"/>" />
					<table align="left" style="padding-top: 10px;">
						<tr>
							<td class="font_weight">
								用户名:
							</td>
							<td>
								<input type="text" name="sysUserBean.userName"
									style="width: 150px;border: 0" value="<s:property value="sysUserBean.userName"/>" readonly="readonly"/>
							</td>
							<td class="font_weight">
								密码:
							</td>
							<td>
								<input type="password" name="sysUserBean.userPassword"
									style="width: 150px;" value="" class="easyui-validatebox"
									data-options="validType:'length[6,6]',invalidMessage:'密码长度为6位!'"/>
							</td>
						</tr>
						<tr>
							<td class="font_weight">
								第一个名字:
							</td>
							<td>
								<input type="text" name="sysUserBean.userFirstName"
									style="width: 150px;" class="easyui-validatebox"
									data-options="required:true,validType:'maxLength[10]',invalidMessage:'长度最长为10位!'" 
									value="<s:property value="sysUserBean.userFirstName"/>" />
							</td>
							<td class="font_weight">
								后一个名字:
							</td>
							<td>
								<input type="text" name="sysUserBean.userLastName"
									style="width: 150px;" class="easyui-validatebox"
									data-options="required:true,validType:'maxLength[10]',invalidMessage:'长度最长为10位!'"
									value="<s:property value="sysUserBean.userLastName"/>" />
							</td>
						</tr>
						<tr>
							<td class="font_weight">
								Email:
							</td>
							<td>
								<input type="text" name="sysUserBean.userEmail"
									style="width: 150px;" class="easyui-validatebox"
									data-options="validType:'email',required:true" maxlength="30"
									value="<s:property value="sysUserBean.userEmail"/>" />
							</td>
							<td class="font_weight">
								职务级别:
							</td>
							<td>
								<input type="radio" name="sysUserBean.superuserFlag" value=0
									<s:if test='sysUserBean.superuserFlag==0'>checked="checked"</s:if> />
								职员&nbsp;&nbsp;
								<input type="radio" name="sysUserBean.superuserFlag" value=1
									<s:if test='sysUserBean.superuserFlag==1'>checked="checked"</s:if> />
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
									style="width: 150px;"
									value="<s:property value="sysUserBean.userRoleId"/>">
							</td>
							<td class="font_weight">
								用户所在部门:
							</td>
							<td>
								<input id="ccc" name="sysUserBean.userDepartId"
									class="easyui-combotree"
									data-options="url:'<rootPath:rootPath/>/sysrightmg/listSysDepartBeans',required:true"
									style="width: 150px;"
									value="<s:property value="sysUserBean.userDepartId"/>">
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