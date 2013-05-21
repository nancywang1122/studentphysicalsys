package com.joysw.service.sysmenumg.impl;

import java.util.List;

import com.joysw.bean.sysmenubean.SysMenuBean;
import com.joysw.bean.sysuserbean.SysUserBean;
import com.joysw.core.page.Page;
import com.joysw.core.utils.StringEmpty;
import com.joysw.dao.sysmenumg.SysMenuMgDAO;
import com.joysw.service.base.impl.BaseServiceImpl;
import com.joysw.service.sysmenumg.SysMenuMgService;

public class SysMenuMgServiceImpl extends BaseServiceImpl<SysMenuBean>
		implements SysMenuMgService {

	private SysMenuMgDAO sysMenuMgDAOImpl;

	public SysMenuMgDAO getSysMenuMgDAOImpl() {
		return sysMenuMgDAOImpl;
	}

	public void setSysMenuMgDAOImpl(SysMenuMgDAO sysMenuMgDAOImpl) {
		this.sysMenuMgDAOImpl = sysMenuMgDAOImpl;
	}

	public Object[] getSysMenuBeansList(SysMenuBean menuBean, Page page) {
		StringBuffer hql = new StringBuffer();
		StringBuffer hqlCount = new StringBuffer();
		hql.append("from SysMenuBean where menuParentId=1");
		hqlCount.append("select count(*) from SysMenuBean where menuParentId=1 ");

		hql.append(" order by menuOrder");
		int rowCount = this.sysMenuMgDAOImpl.countListByHqlAndParas(
				hqlCount.toString(), null);
		if (page == null) {
			page = new Page(10, 1, rowCount);
		} else {
			page = new Page(page.getSize(), page.getNum(), rowCount);
		}
		return new Object[] {
				this.sysMenuMgDAOImpl.getListByHqlAndParas(hql.toString(),
						null, page), page };
	}

	public List<SysMenuBean> getSysMenuBeansByParam(SysMenuBean sysMenuBean) {
		String hql = "from SysMenuBean where menuParentId!=-1 and menuId in (select menuId from SysRoleMenuBean where roleId in(select roleId from SysRoleUserBean where userId = '"
				+ sysMenuBean.getMenuCreatedBy() + "')) ";
		if (sysMenuBean != null) {
			if (!StringEmpty.checkEmpty("" + sysMenuBean.getMenuId())) {
				hql += " and menuParentId='" + sysMenuBean.getMenuId() + "'";
			}
		}
		List<SysMenuBean> list = this.sysMenuMgDAOImpl.getListByHqlAndParas(
				hql, null);
		if (list == null || list.size() == 0) {
			return null;
		} else {
			return list;
		}
	}

	public List<SysMenuBean> getUnlockSysMenuBeans(SysMenuBean sysMenuBean) {
		String hql = "from SysMenuBean where menuParentId!=-1 and menuActiveFlag='1'";
		if (sysMenuBean != null) {
			if (!StringEmpty.checkEmpty("" + sysMenuBean.getMenuId())) {
				hql += " and menuParentId='" + sysMenuBean.getMenuId() + "'";
			}
			// if (!StringEmpty.checkEmpty("" + sysMenuBean.getRoleId())) {
			// hql +=
			// " and menuId in (select menuId from SysRoleMenuBean where roleId='"
			// + sysMenuBean.getRoleId() + "')";
			// }
		}
		List<SysMenuBean> list = this.sysMenuMgDAOImpl.getListByHqlAndParas(
				hql, null);
		if (list == null || list.size() == 0) {
			return null;
		} else {
			return list;
		}
	}

	public List<SysMenuBean> getAllSysMenuBeans(SysMenuBean sysMenuBean) {
		String hql = "from SysMenuBean where menuParentId!=-1 ";
		if (sysMenuBean != null) {
			if (!StringEmpty.checkEmpty("" + sysMenuBean.getMenuId())) {
				hql += " and menuParentId='" + sysMenuBean.getMenuId() + "'";
			}
		}
		List<SysMenuBean> list = this.sysMenuMgDAOImpl.getListByHqlAndParas(
				hql, null);
		if (list == null || list.size() == 0) {
			return null;
		} else {
			return list;
		}
	}

	public List<SysMenuBean> getSysMenuBeans(SysMenuBean sysMenuBean) {
		String hql = "from SysMenuBean where menuParentId!=-1";
		if (sysMenuBean != null) {
			if (!StringEmpty.checkEmpty("" + sysMenuBean.getMenuId())) {
				hql += " and menuParentId='" + sysMenuBean.getMenuId() + "'";
			}
		}
		List<SysMenuBean> list = this.sysMenuMgDAOImpl.getListByHqlAndParas(
				hql, null);
		if (list == null || list.size() == 0) {
			return null;
		} else {
			return list;
		}
	}

	public List<SysMenuBean> getSysMenuBeansIds() {
		String hql = "from SysMenuBean where menuParentId!=-1 ";
		List<SysMenuBean> list = this.sysMenuMgDAOImpl.getListByHqlAndParas(
				hql, null);
		if (list == null || list.size() == 0) {
			return null;
		} else {
			return list;
		}
	}

	public List<SysMenuBean> getParentSysMenuBeans(SysUserBean sysUserBean) {
		String hql = "from SysMenuBean smb where smb.menuParentId=1";
		System.out.println(sysUserBean.getSuperuserFlag());
		if (sysUserBean.getSuperuserFlag() == 2) {
			hql += "  and smb.menuId in (select srm.menuId from SysRoleMenuBean srm where srm.roleId in(select sru.roleId from SysRoleUserBean sru where sru.userId = '"
					+ sysUserBean.getUserId()
					+ "')) order by smb.menuOrder ASC";
		} else {
			hql += " and menuActiveFlag='1' and smb.menuId in (select srm.menuId from SysRoleMenuBean srm where srm.roleId in(select sru.roleId from SysRoleUserBean sru where sru.userId = '"
					+ sysUserBean.getUserId()
					+ "')) order by smb.menuOrder ASC";
		}
		List<SysMenuBean> list = this.sysMenuMgDAOImpl.getListByHqlAndParas(
				hql, null);
		if (list == null || list.size() == 0) {
			return null;
		} else {
			return list;
		}
	}

	/**
	 * 获取前台菜单功能
	 * 
	 * @param i
	 * @return
	 */
	public List<SysMenuBean> getFrontMenuBeans(Integer i) {
		String hql = "from SysMenuBean smb where smb.menuFrontFlag=1 and smb.menuParentId = (select menuId from SysMenuBean smb2 where smb2.menuParentId=-1) order by menuOrder,menuCreatedTime";
		List<SysMenuBean> list = this.sysMenuMgDAOImpl.getListByHqlAndParas(
				hql, null);
		if (list == null || list.size() == 0) {
			return null;
		} else {
			return list;
		}
	}

	/**
	 * 获取前台子集菜单功能
	 * 
	 * @param i
	 * @return
	 */
	public List<SysMenuBean> getFrontChildMenuBeans(String i) {
		String hql = "from SysMenuBean smb where smb.menuParentId ='" + i
				+ "')  order by menuOrder,menuCreatedTime";
		List<SysMenuBean> list = this.sysMenuMgDAOImpl.getListByHqlAndParas(
				hql, null);
		if (list == null || list.size() == 0) {
			return null;
		} else {
			return list;
		}
	}
}
