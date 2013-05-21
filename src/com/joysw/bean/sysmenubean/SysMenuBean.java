package com.joysw.bean.sysmenubean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.joysw.bean.sysrolebean.SysRoleBean;

/**
 * SysRight entity. @author MyEclipse Persistence Tools
 */

public class SysMenuBean implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer menuId;
	private String menuName;
	private String menuTip;
	private String menuImgUrl;
	private String menuUrl;
	private String menuTarget;
	private Integer menuParentId;
	private Integer menuOrder;
	private Integer menuCreatedBy;
	private Date menuCreatedTime = new Date();
	private Integer menuUpdatedBy;
	private Date menuUpdatedTime = new Date();
	private String menuMemo;
	private String menuDeployFlag;
	private String menuDeleteFlag;
	private String menuActiveFlag;
	private SysMenuBean menuParentBean;
	private Set<SysMenuBean> childMenuBeans = new HashSet<SysMenuBean>();
	private Set<SysRoleBean> sysRoleBeans = new HashSet<SysRoleBean>();
	private Integer roleId;
	private Integer menuFrontFlag;
	
	public Integer getMenuFrontFlag() {
		return menuFrontFlag;
	}

	public void setMenuFrontFlag(Integer menuFrontFlag) {
		this.menuFrontFlag = menuFrontFlag;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Set<SysMenuBean> getChildMenuBeans() {
		return childMenuBeans;
	}

	public String getMenuActiveFlag() {
		return menuActiveFlag;
	}

	public void setMenuActiveFlag(String menuActiveFlag) {
		this.menuActiveFlag = menuActiveFlag;
	}

	public void setChildMenuBeans(Set<SysMenuBean> childMenuBeans) {
		this.childMenuBeans = childMenuBeans;
	}

	public Set<SysRoleBean> getSysRoleBeans() {
		return sysRoleBeans;
	}

	public void setSysRoleBeans(Set<SysRoleBean> sysRoleBeans) {
		this.sysRoleBeans = sysRoleBeans;
	}

	public String getMenuDeployFlag() {
		return menuDeployFlag;
	}

	public void setMenuDeployFlag(String menuDeployFlag) {
		this.menuDeployFlag = menuDeployFlag;
	}

	public String getMenuDeleteFlag() {
		return menuDeleteFlag;
	}

	public void setMenuDeleteFlag(String menuDeleteFlag) {
		this.menuDeleteFlag = menuDeleteFlag;
	}

	public SysMenuBean() {
		super();
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuTip() {
		return menuTip;
	}

	public void setMenuTip(String menuTip) {
		this.menuTip = menuTip;
	}

	public String getMenuImgUrl() {
		return menuImgUrl;
	}

	public void setMenuImgUrl(String menuImgUrl) {
		this.menuImgUrl = menuImgUrl;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public String getMenuTarget() {
		return menuTarget;
	}

	public void setMenuTarget(String menuTarget) {
		this.menuTarget = menuTarget;
	}

	public Integer getMenuParentId() {
		return menuParentId;
	}

	public void setMenuParentId(Integer menuParentId) {
		this.menuParentId = menuParentId;
	}

	public SysMenuBean getMenuParentBean() {
		return menuParentBean;
	}

	public void setMenuParentBean(SysMenuBean menuParentBean) {
		this.menuParentBean = menuParentBean;
	}

	public Integer getMenuOrder() {
		return menuOrder;
	}

	public void setMenuOrder(Integer menuOrder) {
		this.menuOrder = menuOrder;
	}

	public Integer getMenuCreatedBy() {
		return menuCreatedBy;
	}

	public void setMenuCreatedBy(Integer menuCreatedBy) {
		this.menuCreatedBy = menuCreatedBy;
	}

	public Date getMenuCreatedTime() {
		return menuCreatedTime;
	}

	public String getStrMenuCreatedTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (this.menuCreatedTime != null) {
			return sdf.format(this.menuCreatedTime);
		}
		return null;
	}

	public void setMenuCreatedTime(Date menuCreatedTime) {
		this.menuCreatedTime = menuCreatedTime;
	}

	public Integer getMenuUpdatedBy() {
		return menuUpdatedBy;
	}

	public void setMenuUpdatedBy(Integer menuUpdatedBy) {
		this.menuUpdatedBy = menuUpdatedBy;
	}

	public String getStrMenuUpdatedTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (this.menuUpdatedTime != null) {
			return sdf.format(this.menuUpdatedTime);
		}
		return null;
	}

	public Date getMenuUpdatedTime() {
		return menuUpdatedTime;
	}

	public void setMenuUpdatedTime(Date menuUpdatedTime) {
		this.menuUpdatedTime = menuUpdatedTime;
	}

	public String getMenuMemo() {
		return menuMemo;
	}

	public void setMenuMemo(String menuMemo) {
		this.menuMemo = menuMemo;
	}
}