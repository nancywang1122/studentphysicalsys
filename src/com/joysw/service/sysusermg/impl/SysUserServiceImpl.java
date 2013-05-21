package com.joysw.service.sysusermg.impl;

import java.util.ArrayList;
import java.util.List;

import com.joysw.bean.sysdepartbean.SysDepartUserBean;
import com.joysw.bean.sysdepartbean.SysDepartmentBean;
import com.joysw.bean.sysrolebean.SysRoleBean;
import com.joysw.bean.sysuserbean.SysRoleUserBean;
import com.joysw.bean.sysuserbean.ViewSysUserBean;
import com.joysw.core.page.Page;
import com.joysw.core.utils.StringEmpty;
import com.joysw.dao.base.BaseDAO;
import com.joysw.service.base.impl.BaseServiceImpl;
import com.joysw.service.sysusermg.SysUserService;

public class SysUserServiceImpl extends BaseServiceImpl<ViewSysUserBean>
		implements SysUserService {
	private BaseDAO<ViewSysUserBean> baseSysUserDAOImpl;
	private BaseDAO<SysDepartUserBean> baseSysDepartUserDAOImpl;
	private BaseDAO<SysRoleUserBean> baseSysRoleUserDAOImpl;
	private BaseDAO<SysDepartmentBean> baseSyDepartDAOImpl;
	private BaseDAO<SysRoleBean> baseSysRoleDAOImpl;

	public BaseDAO<SysDepartmentBean> getBaseSyDepartDAOImpl() {
		return baseSyDepartDAOImpl;
	}

	public void setBaseSyDepartDAOImpl(
			BaseDAO<SysDepartmentBean> baseSyDepartDAOImpl) {
		this.baseSyDepartDAOImpl = baseSyDepartDAOImpl;
	}

	public BaseDAO<SysRoleBean> getBaseSysRoleDAOImpl() {
		return baseSysRoleDAOImpl;
	}

	public void setBaseSysRoleDAOImpl(BaseDAO<SysRoleBean> baseSysRoleDAOImpl) {
		this.baseSysRoleDAOImpl = baseSysRoleDAOImpl;
	}

	public BaseDAO<SysDepartUserBean> getBaseSysDepartUserDAOImpl() {
		return baseSysDepartUserDAOImpl;
	}

	public void setBaseSysDepartUserDAOImpl(
			BaseDAO<SysDepartUserBean> baseSysDepartUserDAOImpl) {
		this.baseSysDepartUserDAOImpl = baseSysDepartUserDAOImpl;
	}

	public BaseDAO<SysRoleUserBean> getBaseSysRoleUserDAOImpl() {
		return baseSysRoleUserDAOImpl;
	}

	public void setBaseSysRoleUserDAOImpl(
			BaseDAO<SysRoleUserBean> baseSysRoleUserDAOImpl) {
		this.baseSysRoleUserDAOImpl = baseSysRoleUserDAOImpl;
	}

	public BaseDAO<ViewSysUserBean> getBaseSysUserDAOImpl() {
		return baseSysUserDAOImpl;
	}

	public void setBaseSysUserDAOImpl(
			BaseDAO<ViewSysUserBean> baseSysUserDAOImpl) {
		this.baseSysUserDAOImpl = baseSysUserDAOImpl;
	}

	public Object[] getSysUserBeansList(ViewSysUserBean sysUserBean, Page page) {
		StringBuffer hql = new StringBuffer();
		StringBuffer hqlCount = new StringBuffer();
		hql.append("from ViewSysUserBean where 1=1 ");
		hqlCount.append("select count(*) from ViewSysUserBean where 1=1 ");
		List<Object> params = new ArrayList<Object>();
		if (sysUserBean != null) {
			if (!StringEmpty.checkEmpty(sysUserBean.getUserName())) {
				hql.append(" and userName like ? ");
				hqlCount.append(" and userName like ? ");
				params.add("%" + sysUserBean.getUserName().trim() + "%");
			}
			if (!StringEmpty.checkEmpty(sysUserBean.getUserDepartCode())) {
				hql.append(" and userDepartCode  like ? ");
				hqlCount.append(" and userDepartCode like ? ");
				params.add("" + sysUserBean.getUserDepartCode() + "%");
			}
		}
		hql.append(" order by userId desc");
		int rowCount = this.baseSysUserDAOImpl.countListByHqlAndParas(hqlCount
				.toString(), params);
		if (page == null) {
			page = new Page(10, 1, rowCount);
		} else {
			page = new Page(page.getSize(), page.getNum(), rowCount);
		}
		return new Object[] {
				this.baseSysUserDAOImpl.getListByHqlAndParas(hql.toString(),
						params, page), page };
	}

	public SysDepartUserBean getSysDepartUserBean(Integer userId) {
		String sql = "from SysDepartUserBean where userId='" + userId + "'";
		List<SysDepartUserBean> list = this.baseSysDepartUserDAOImpl
				.getListByHqlAndParas(sql, null);
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	public SysRoleUserBean getSysRoleUserBean(Integer userId) {
		String sql = "from SysRoleUserBean where userId='" + userId + "'";
		List<SysRoleUserBean> list = this.baseSysRoleUserDAOImpl
				.getListByHqlAndParas(sql, null);
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	public SysDepartmentBean getSysDepartmentBean(Integer departId) {
		String sql = "from SysDepartmentBean where departId='" + departId + "'";
		List<SysDepartmentBean> list = this.baseSyDepartDAOImpl
				.getListByHqlAndParas(sql, null);
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	public SysRoleBean getSysRoleBean(Integer roleId) {
		String sql = "from SysRoleBean where roleId='" + roleId + "'";
		List<SysRoleBean> list = this.baseSysRoleDAOImpl.getListByHqlAndParas(
				sql, null);
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	public void deleteSysDepartUserBean(Integer userId) {
		String sql = "delete from SysDepartUserBean where userId='" + userId
				+ "'";
		this.baseSysUserDAOImpl.delete(sql);
	}
	public void deleteSysUserBean(Integer userId) {
		String sql = "delete from SysUserBean where userId='" + userId
		+ "'";
		this.baseSysUserDAOImpl.delete(sql);
	}

	public void deleteSysRoleUserBean(Integer userId) {
		String sql = "delete from SysRoleUserBean where userId='" + userId
				+ "'";
		this.baseSysUserDAOImpl.delete(sql);
	}

	public ViewSysUserBean getViewSysUserBean(String userName) {
		String sql = "from ViewSysUserBean where userName='" + userName + "'";
		List<ViewSysUserBean> list = this.baseSysUserDAOImpl
				.getListByHqlAndParas(sql, null);
		if (list != null & list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}
}
