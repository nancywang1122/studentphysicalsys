package com.joysw.bean.sysrolebean;

/**
 * 角色_权限 中间表 entity. @author tfj
 */

public class SysRoleMenuBean implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer menuId;
	private Integer roleId;

	private Integer isCreate;
	private Integer isDelete;
	private Integer isModify;

	public SysRoleMenuBean() {
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getIsCreate() {
		return this.isCreate;
	}

	public void setIsCreate(Integer isCreate) {
		this.isCreate = isCreate;
	}

	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getIsModify() {
		return this.isModify;
	}

	public void setIsModify(Integer isModify) {
		this.isModify = isModify;
	}

	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	public int hashCode() {
		return super.hashCode();
	}
}