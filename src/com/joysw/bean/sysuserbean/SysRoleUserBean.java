package com.joysw.bean.sysuserbean;

/**
 * SysUser entity. @author MyEclipse Persistence Tools
 */

public class SysRoleUserBean implements java.io.Serializable {

	// Fields
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer userId;
	private Integer roleId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
}