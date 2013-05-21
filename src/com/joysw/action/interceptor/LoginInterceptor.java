package com.joysw.action.interceptor;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import com.joysw.bean.sysuserbean.SysUserBean;
import com.joysw.core.utils.FinalApplication;
import com.joysw.service.login.LoginService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LoginService loginServiceImpl;
	private JSONObject jsonObject;

	public JSONObject getJsonObject() {
		return jsonObject;
	}

	public void setJsonObject(JSONObject jsonObject) {
		this.jsonObject = jsonObject;
	}

	public LoginService getLoginServiceImpl() {
		return loginServiceImpl;
	}

	public void setLoginServiceImpl(LoginService loginServiceImpl) {
		this.loginServiceImpl = loginServiceImpl;
	}

	/**
	 * check user info when login system
	 */
	@SuppressWarnings("unchecked")
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext ctx = ActionContext.getContext();
		Map session = ctx.getSession();
		@SuppressWarnings("unused")
		SysUserBean sessionUserBean = (SysUserBean) session
				.get(FinalApplication.LOGIN_USER);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("info", "用户名有误");
		jsonObject = JSONObject.fromObject(map);
		System.out.println(jsonObject);
		return "login";

		/*
		 * if (sessionUserBean == null) {
		 * 
		 * } else { return invocation.invoke(); }
		 */
	}
}
