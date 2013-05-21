package com.joysw.service.login.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.joysw.bean.sysuserbean.SysUserBean;
import com.joysw.core.page.Page;
import com.joysw.core.utils.StringEmpty;
import com.joysw.dao.base.BaseDAO;
import com.joysw.dao.login.LoginDAO;
import com.joysw.service.base.impl.BaseServiceImpl;
import com.joysw.service.login.LoginService;

public class LoginServiceImpl extends BaseServiceImpl<SysUserBean> implements
		LoginService {

	private LoginDAO loginDAOImpl;

	public LoginDAO getLoginDAOImpl() {
		return loginDAOImpl;
	}


	public void setLoginDAOImpl(LoginDAO loginDAOImpl) {
		this.loginDAOImpl = loginDAOImpl;
	}


	public SysUserBean getSysUserBean(SysUserBean sysUserBean) {
		StringBuffer hql = new StringBuffer();
		hql.append("from SysUserBean where 1=1 ");
		List<Object> params = new ArrayList<Object>();
		if (null != sysUserBean) {
			if (!StringEmpty.checkEmpty(sysUserBean.getUserAccount())) {
				hql.append(" and userName = ?");
				params.add(StringEmpty.toString(sysUserBean.getUserAccount()));
			}
			if (!StringEmpty.checkEmpty(sysUserBean.getUserPassword())) {
				hql.append(" and userPassword = ?");
				//params.add(MD5Util.MD5(StringEmpty.toString(sysUserBean.getUserPassword())));
				params.add(StringEmpty.toString(sysUserBean.getUserPassword()));
			}
			List<SysUserBean> list = this.loginDAOImpl.getListByHqlAndParas(hql
					.toString(), params);
			if (list == null || list.size() == 0) {
				return null;
			} else {
				return list.get(0);
			}
		} else {
			return null;
		}
	}
}
