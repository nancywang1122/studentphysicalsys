package com.joysw.service.sysusermg;

import com.joysw.bean.sysdepartbean.SysDepartUserBean;
import com.joysw.bean.sysdepartbean.SysDepartmentBean;
import com.joysw.bean.sysrolebean.SysRoleBean;
import com.joysw.bean.sysuserbean.SysRoleUserBean;
import com.joysw.bean.sysuserbean.ViewSysUserBean;
import com.joysw.core.page.Page;
import com.joysw.service.base.BaseService;

public interface SysUserService extends BaseService<ViewSysUserBean> {
	public Object[] getSysUserBeansList(ViewSysUserBean sysUserBean, Page page);

	public SysDepartUserBean getSysDepartUserBean(Integer userId);

	public SysRoleUserBean getSysRoleUserBean(Integer userId);

	public void deleteSysDepartUserBean(Integer userId);
	public void deleteSysUserBean(Integer userId);

	public void deleteSysRoleUserBean(Integer userId);

	public SysDepartmentBean getSysDepartmentBean(Integer userId);

	public ViewSysUserBean getViewSysUserBean(String userName);

	public SysRoleBean getSysRoleBean(Integer userId);
}
