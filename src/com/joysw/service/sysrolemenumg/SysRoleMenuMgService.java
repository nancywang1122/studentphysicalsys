package com.joysw.service.sysrolemenumg;

import java.util.List;

import com.joysw.bean.sysdepartbean.SysDepartUserBean;
import com.joysw.bean.sysdepartbean.SysDepartmentBean;
import com.joysw.bean.sysrolebean.SysRoleBean;
import com.joysw.bean.sysrolebean.SysRoleMenuBean;
import com.joysw.bean.sysuserbean.SysUserBean;
import com.joysw.service.base.BaseService;

public interface SysRoleMenuMgService extends BaseService<SysRoleMenuBean> {

	public List<SysRoleBean> getSysRoleBeans(SysRoleBean sysRoleBean);

	public List<SysDepartmentBean> getSysDepartBeans(
			SysDepartmentBean sysDepartmentBean);

	public SysDepartmentBean getSysDepartBeansByUserId(SysUserBean sysUserBean);

	public void deleteSysRoleMenuBean(SysRoleMenuBean sysRoleMenuBean);

	public void deleteSysDepartBean(SysDepartmentBean sysDepartmentBean);

	public List<SysRoleMenuBean> getSysRoleMenuBeans(
			SysRoleMenuBean sysRoleMenuBean);

	public List<SysDepartUserBean> getSysDepartUserBeans(
			SysDepartmentBean sysDepartmentBean);
}
