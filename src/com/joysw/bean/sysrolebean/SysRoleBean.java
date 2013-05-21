package com.joysw.bean.sysrolebean;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.joysw.bean.sysmenubean.SysMenuBean;
import com.joysw.bean.sysuserbean.SysUserBean;

/**
 * SysRole entity. @author MyEclipse Persistence Tools
 */

public class SysRoleBean implements java.io.Serializable {

	// Fields
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer roleId;
	private String roleDepartCode;
	private String roleName;
	private Integer roleOrder;
	private String roleMemo;
	private Integer roleCreatedBy;
	private Date roleCreatedTime = new Date();
	private Integer roleUpdatedBy;
	private Date roleUpdatedTime = new Date();
	private Set<SysMenuBean> sysMenuBeans = new HashSet<SysMenuBean>();
	private Set<SysUserBean> sysUserBeans = new HashSet<SysUserBean>();

	// Constructors

	/** default constructor */
	public SysRoleBean() {
	}

	public Set<SysUserBean> getSysUserBeans() {
		return sysUserBeans;
	}

	public void setSysUserBeans(Set<SysUserBean> sysUserBeans) {
		this.sysUserBeans = sysUserBeans;
	}

	public Date getRoleCreatedTime() {
		return roleCreatedTime;
	}

	public Date getRoleUpdatedTime() {
		return roleUpdatedTime;
	}

	public Set<SysMenuBean> getSysMenuBeans() {
		return sysMenuBeans;
	}

	public void setSysMenuBeans(Set<SysMenuBean> sysMenuBeans) {
		this.sysMenuBeans = sysMenuBeans;
	}

	public void setRoleCreatedTime(Date roleCreatedTime) {
		this.roleCreatedTime = roleCreatedTime;
	}

	public void setRoleUpdatedTime(Date roleUpdatedTime) {
		this.roleUpdatedTime = roleUpdatedTime;
	}

	/** full constructor */
	public SysRoleBean(String roleDepartCode, String roleName,
			Integer roleOrder, String roleMemo, Integer roleCreatedBy,
			Timestamp roleCreatedTime, Integer roleUpdatedBy,
			Timestamp roleUpdatedTime) {
		this.roleDepartCode = roleDepartCode;
		this.roleName = roleName;
		this.roleOrder = roleOrder;
		this.roleMemo = roleMemo;
		this.roleCreatedBy = roleCreatedBy;
		this.roleCreatedTime = roleCreatedTime;
		this.roleUpdatedBy = roleUpdatedBy;
		this.roleUpdatedTime = roleUpdatedTime;
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleDepartCode() {
		return roleDepartCode;
	}

	public void setRoleDepartCode(String roleDepartCode) {
		this.roleDepartCode = roleDepartCode;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getRoleOrder() {
		return this.roleOrder;
	}

	public void setRoleOrder(Integer roleOrder) {
		this.roleOrder = roleOrder;
	}

	public String getRoleMemo() {
		return this.roleMemo;
	}

	public void setRoleMemo(String roleMemo) {
		this.roleMemo = roleMemo;
	}

	public Integer getRoleCreatedBy() {
		return this.roleCreatedBy;
	}

	public void setRoleCreatedBy(Integer roleCreatedBy) {
		this.roleCreatedBy = roleCreatedBy;
	}

	public Integer getRoleUpdatedBy() {
		return this.roleUpdatedBy;
	}

	public void setRoleUpdatedBy(Integer roleUpdatedBy) {
		this.roleUpdatedBy = roleUpdatedBy;
	}
}