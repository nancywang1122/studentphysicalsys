package com.joysw.service.login;

import com.joysw.bean.sysuserbean.SysUserBean;
import com.joysw.service.base.BaseService;

public interface LoginService extends BaseService<SysUserBean> {
	public SysUserBean getSysUserBean(SysUserBean sysUserBean);

}
