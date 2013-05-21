package com.joysw.action.login;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import com.joysw.action.base.BaseAction;
import com.joysw.bean.sysdepartbean.SysDepartmentBean;
import com.joysw.bean.sysuserbean.SysUserBean;
import com.joysw.core.utils.FinalApplication;
import com.joysw.core.utils.StringEmpty;
import com.joysw.service.login.LoginService;
import com.joysw.service.sysrolemenumg.SysRoleMenuMgService;
import com.opensymphony.xwork2.ActionContext;

public class LoginAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private LoginService loginServiceImpl;
	private SysUserBean sysUserBean;
	private SysRoleMenuMgService sysRoleMenuMgServiceImpl;
	private JSONObject resultObj;

	public JSONObject getResultObj() {
		return resultObj;
	}


	public void setResultObj(JSONObject resultObj) {
		this.resultObj = resultObj;
	}


	public SysRoleMenuMgService getSysRoleMenuMgServiceImpl() {
		return sysRoleMenuMgServiceImpl;
	}

	public void setSysRoleMenuMgServiceImpl(
			SysRoleMenuMgService sysRoleMenuMgServiceImpl) {
		this.sysRoleMenuMgServiceImpl = sysRoleMenuMgServiceImpl;
	}

	public SysUserBean getSysUserBean() {
		return sysUserBean;
	}

	public void setSysUserBean(SysUserBean sysUserBean) {
		this.sysUserBean = sysUserBean;
	}

	public LoginService getLoginServiceImpl() {
		return loginServiceImpl;
	}

	public void setLoginServiceImpl(LoginService loginServiceImpl) {
		this.loginServiceImpl = loginServiceImpl;
	}

	public String logout() {
		ActionContext.getContext().getSession()
				.remove(FinalApplication.LOGIN_USER);
		ActionContext.getContext().getSession().clear();
		return SUCCESS;
	}

	public String home() {
		return SUCCESS;
	}
	public String admin() {
		return SUCCESS;
	}

	public String login() {
		Map<String, Object> map = new HashMap<String, Object>();
		if (sysUserBean == null) {
			map.put("result", "0");
			map.put("info", "登陆失败!");
			return this.outJSONArray(map);
		}
		if (StringEmpty.checkEmpty(sysUserBean.getUserAccount())) {
			map.put("result", "0");
			map.put("info", "用户名不能为空!");
			return this.outJSONArray(map);
		}
		if (StringEmpty.checkEmpty(sysUserBean.getUserPassword())) {
			map.put("result", "0");
			map.put("info", "密码不能为空!");
			return this.outJSONArray(map);
		}
		SysUserBean sessionUserBean = this.loginServiceImpl
				.getSysUserBean(sysUserBean);
		if (sessionUserBean != null) {
			map.put("result", "1");
			map.put("info", "验证成功,正在进入系统!");
			SysDepartmentBean sysDepartBean = this.sysRoleMenuMgServiceImpl
					.getSysDepartBeansByUserId(sessionUserBean);
			if(sysDepartBean==null){
				map.put("result", "0");
				map.put("info", "找不到该用户对于得部门信息，请核实!");
				return this.outJSONArray(map);
			}
			sessionUserBean.setUserDepartCode(sysDepartBean.getDepartCode());
			ActionContext.getContext().getSession()
					.put(FinalApplication.LOGIN_USER, sessionUserBean);
			ActionContext.getContext().getSession()
					.put("sessionUserName", sessionUserBean.getUserName());
			this.outJSONArray(map);
			return SUCCESS;
		} else {
			map.put("result", "0");
			map.put("info", "用户名或密码有误!");
			return this.outJSONArray(map);
		}
	}
}
