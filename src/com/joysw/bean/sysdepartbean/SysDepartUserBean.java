package com.joysw.bean.sysdepartbean;

import com.joysw.bean.sysuserbean.SysUserBean;

/**
 */

public class SysDepartUserBean implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private Integer userId;
	private Integer departId;
	private SysDepartmentBean sysDepartmentBean;

	private SysUserBean sysUsersBean;

	// Constructors

	/** default constructor */
	public SysDepartUserBean() {
	}

	/** full constructor */
	public SysDepartUserBean(Integer userId, Integer departId) {
		this.userId = userId;
		this.departId = departId;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getDepartId() {
		return this.departId;
	}

	public void setDepartId(Integer departId) {
		this.departId = departId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SysDepartUserBean))
			return false;
		SysDepartUserBean castOther = (SysDepartUserBean) other;

		return ((this.getUserId() == castOther.getUserId()) || (this
				.getUserId() != null
				&& castOther.getUserId() != null && this.getUserId().equals(
				castOther.getUserId())))
				&& ((this.getDepartId() == castOther.getDepartId()) || (this
						.getDepartId() != null
						&& castOther.getDepartId() != null && this
						.getDepartId().equals(castOther.getDepartId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		result = 37 * result
				+ (getDepartId() == null ? 0 : this.getDepartId().hashCode());
		return result;
	}

	public SysDepartmentBean getSysDepartmentBean() {
		return sysDepartmentBean;
	}

	public void setSysDepartmentBean(SysDepartmentBean sysDepartmentBean) {
		this.sysDepartmentBean = sysDepartmentBean;
	}

	public SysUserBean getSysUsersBean() {
		return sysUsersBean;
	}

	public void setSysUsersBean(SysUserBean sysUsersBean) {
		this.sysUsersBean = sysUsersBean;
	}

}