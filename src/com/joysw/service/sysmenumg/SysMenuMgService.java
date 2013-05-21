package com.joysw.service.sysmenumg;

import java.util.List;

import com.joysw.bean.sysmenubean.SysMenuBean;
import com.joysw.bean.sysuserbean.SysUserBean;
import com.joysw.core.page.Page;
import com.joysw.service.base.BaseService;

public interface SysMenuMgService extends BaseService<SysMenuBean> {

	public List<SysMenuBean> getParentSysMenuBeans(SysUserBean sysUserBean);

	public List<SysMenuBean> getSysMenuBeansByParam(SysMenuBean sysMenuBean);

	public List<SysMenuBean> getSysMenuBeans(SysMenuBean sysMenuBean);

	public List<SysMenuBean> getSysMenuBeansIds();

	public Object[] getSysMenuBeansList(SysMenuBean menuBean, Page page);

	public List<SysMenuBean> getUnlockSysMenuBeans(SysMenuBean sysMenuBean);

	public List<SysMenuBean> getAllSysMenuBeans(SysMenuBean sysMenuBean);

	/**
	 * 获取前台菜单功能
	 * 
	 * @param i
	 * @return
	 */
	public List<SysMenuBean> getFrontMenuBeans(Integer i);

	/**
	 * 获取前台子集菜单功能
	 * 
	 * @param i
	 * @return
	 */
	public List<SysMenuBean> getFrontChildMenuBeans(String i);

}
