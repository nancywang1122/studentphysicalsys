package com.joysw.action.interceptor;

import java.util.Map;

import com.joysw.bean.sysuserbean.SysUserBean;
import com.joysw.core.utils.FinalApplication;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class SessionIterceptor extends AbstractInterceptor {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		ActionContext ctx = ActionContext.getContext();
		Map session = ctx.getSession();
		System.out.println(actionInvocation.getInvocationContext().getName());
		if ("login".equals(actionInvocation.getInvocationContext().getName())) {
			return actionInvocation.invoke();
		}
		SysUserBean loginUser = (SysUserBean) session
				.get(FinalApplication.LOGIN_USER);
		if (loginUser == null) {
			return "logout";
		} else {
			return actionInvocation.invoke();
		}
	}
}
