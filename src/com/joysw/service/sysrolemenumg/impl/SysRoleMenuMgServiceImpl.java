package com.joysw.service.sysrolemenumg.impl;

import java.util.List;

import com.joysw.bean.sysdepartbean.SysDepartUserBean;
import com.joysw.bean.sysdepartbean.SysDepartmentBean;
import com.joysw.bean.sysrolebean.SysRoleBean;
import com.joysw.bean.sysrolebean.SysRoleMenuBean;
import com.joysw.bean.sysuserbean.SysUserBean;
import com.joysw.core.utils.StringEmpty;
import com.joysw.dao.base.impl.BaseDAOImpl;
import com.joysw.service.base.impl.BaseServiceImpl;
import com.joysw.service.sysrolemenumg.SysRoleMenuMgService;

public class SysRoleMenuMgServiceImpl extends BaseServiceImpl<SysRoleMenuBean>
		implements SysRoleMenuMgService {

	private BaseDAOImpl<SysRoleBean> baseSysRoleMgDAOImpl;
	private BaseDAOImpl<SysDepartmentBean> baseSysDepartMgDAOImpl;
	private BaseDAOImpl<SysRoleMenuBean> baseSysRoleMenuMgDAOImpl;

	public BaseDAOImpl<SysRoleBean> getBaseSysRoleMgDAOImpl() {
		return baseSysRoleMgDAOImpl;
	}

	public void setBaseSysRoleMgDAOImpl(
			BaseDAOImpl<SysRoleBean> baseSysRoleMgDAOImpl) {
		this.baseSysRoleMgDAOImpl = baseSysRoleMgDAOImpl;
	}

	public BaseDAOImpl<SysDepartmentBean> getBaseSysDepartMgDAOImpl() {
		return baseSysDepartMgDAOImpl;
	}

	public void setBaseSysDepartMgDAOImpl(
			BaseDAOImpl<SysDepartmentBean> baseSysDepartMgDAOImpl) {
		this.baseSysDepartMgDAOImpl = baseSysDepartMgDAOImpl;
	}

	public BaseDAOImpl<SysRoleMenuBean> getBaseSysRoleMenuMgDAOImpl() {
		return baseSysRoleMenuMgDAOImpl;
	}

	public void setBaseSysRoleMenuMgDAOImpl(
			BaseDAOImpl<SysRoleMenuBean> baseSysRoleMenuMgDAOImpl) {
		this.baseSysRoleMenuMgDAOImpl = baseSysRoleMenuMgDAOImpl;
	}

	public List<SysRoleBean> getSysRoleBeans(SysRoleBean sysRoleBean) {
		String hql = "from SysRoleBean where 1=1";
		if (sysRoleBean != null) {
			if (!StringEmpty.checkEmpty(sysRoleBean.getRoleDepartCode())) {
				hql += " and roleDepartCode like '"
						+ sysRoleBean.getRoleDepartCode() + "%'";
			}
		}
		return this.baseSysRoleMgDAOImpl.getListByHqlAndParas(hql, null);
	}

	public List<SysRoleMenuBean> getSysRoleMenuBeans(
			SysRoleMenuBean sysRoleMenuBean) {
		String hql = "from SysRoleMenuBean where 1=1";
		if (sysRoleMenuBean != null) {
			if (!StringEmpty.checkEmpty(sysRoleMenuBean.getRoleId().toString())) {
				hql += " and roleId = '" + sysRoleMenuBean.getRoleId() + "'";
			}
			if (!StringEmpty.checkEmpty(sysRoleMenuBean.getMenuId().toString())) {
				hql += " and menuId = '" + sysRoleMenuBean.getMenuId() + "'";
			}
		}
		return this.baseSysRoleMenuMgDAOImpl.getListByHqlAndParas(hql, null);
	}

	public void deleteSysRoleMenuBean(SysRoleMenuBean sysRoleMenuBean) {
		String hql = "delete from SysRoleMenuBean where roleId = '"
				+ sysRoleMenuBean.getRoleId() + "'";
		this.baseSysRoleMenuMgDAOImpl.delete(hql);
	}

	public List<SysDepartmentBean> getSysDepartBeans(
			SysDepartmentBean sysDepartmentBean) {
		String hql = "from SysDepartmentBean where 1=1";
		if (sysDepartmentBean != null) {
			if (!StringEmpty.checkEmpty(sysDepartmentBean.getDepartCode())) {
				hql += " and departCode = '"
						+ sysDepartmentBean.getDepartCode() + "'";
			}
			if (sysDepartmentBean.getDepartParentId() != null) {
				hql += " and departParentId = '"
						+ sysDepartmentBean.getDepartParentId() + "'";
			}
		}
		return this.baseSysDepartMgDAOImpl.getListByHqlAndParas(hql, null);
	}

	public SysDepartmentBean getSysDepartBeansByUserId(SysUserBean sysUserBean) {
		String hql = "from SysDepartmentBean where departId in (select departId from SysDepartUserBean where userId = '"
				+ sysUserBean.getUserId() + "')";

		hql += " order by departParentId asc ";
		List<SysDepartmentBean> list = this.baseSysDepartMgDAOImpl
				.getListByHqlAndParas(hql, null);
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	public void deleteSysDepartBean(SysDepartmentBean sysDepartmentBean) {
		String hql = "delete from SysDepartmentBean where departCode like '"
				+ sysDepartmentBean.getDepartCode() + "%'";
		this.baseSysRoleMenuMgDAOImpl.delete(hql);
	}

	public List<SysDepartUserBean> getSysDepartUserBeans(
			SysDepartmentBean sysDepartmentBean) {
		String hql = "from SysDepartUserBean where departId in (select departId from SysDepartmentBean where departCode like '"+ sysDepartmentBean.getDepartCode() + "%')";
		return this.baseSysRoleMenuMgDAOImpl.getListSysDepartUserBean(hql);
	}
}
