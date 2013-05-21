package com.joysw.bean.sysdepartbean;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * SysDepartment entity. @author MyEclipse Persistence Tools
 */

public class SysDepartmentBean implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields
	private Integer departId;
	private String departCode;
	private String departName;
	private Integer departParentId;
	private Integer departCreatedBy;
	private Date departCreatedTime = new Date();
	private Integer departUpdatedBy;
	private Date departUpdatedTime = new Date();
	private String departMemo;
	private SysDepartmentBean sysDepartParentBean;
	// 会员信息
	@SuppressWarnings("unchecked")
	private Set sysUserBeans = new HashSet(0);

	// Constructors

	

	public String getDepartCode() {
		return departCode;
	}

	public void setDepartCode(String departCode) {
		this.departCode = departCode;
	}



	public SysDepartmentBean getSysDepartParentBean() {
		return sysDepartParentBean;
	}

	public void setSysDepartParentBean(SysDepartmentBean sysDepartParentBean) {
		this.sysDepartParentBean = sysDepartParentBean;
	}

	@SuppressWarnings("unchecked")
	public Set getSysUserBeans() {
		return sysUserBeans;
	}

	@SuppressWarnings("unchecked")
	public void setSysUserBeans(Set sysUserBeans) {
		this.sysUserBeans = sysUserBeans;
	}

	/** default constructor */
	public SysDepartmentBean() {
	}

	/** full constructor */
	public SysDepartmentBean(String departName, Integer departParentId,
			Integer departCreatedBy, Timestamp departCreatedTime,
			Integer departUpdatedBy, Timestamp departUpdatedTime, String departMemo) {
		this.departName = departName;
		this.departParentId = departParentId;
		this.departCreatedBy = departCreatedBy;
		this.departCreatedTime = departCreatedTime;
		this.departUpdatedBy = departUpdatedBy;
		this.departUpdatedTime = departUpdatedTime;
		this.departMemo = departMemo;
	}

	// Property accessors

	public Integer getDepartId() {
		return this.departId;
	}

	public void setDepartId(Integer departId) {
		this.departId = departId;
	}

	public String getDepartName() {
		return this.departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

	public Integer getDepartParentId() {
		return this.departParentId;
	}

	public void setDepartParentId(Integer departParentId) {
		this.departParentId = departParentId;
	}

	public Integer getDepartCreatedBy() {
		return this.departCreatedBy;
	}

	public void setDepartCreatedBy(Integer departCreatedBy) {
		this.departCreatedBy = departCreatedBy;
	}

	public Integer getDepartUpdatedBy() {
		return this.departUpdatedBy;
	}

	public void setDepartUpdatedBy(Integer departUpdatedBy) {
		this.departUpdatedBy = departUpdatedBy;
	}

	public Date getDepartCreatedTime() {
		return departCreatedTime;
	}

	public void setDepartCreatedTime(Date departCreatedTime) {
		this.departCreatedTime = departCreatedTime;
	}

	public Date getDepartUpdatedTime() {
		return departUpdatedTime;
	}

	public void setDepartUpdatedTime(Date departUpdatedTime) {
		this.departUpdatedTime = departUpdatedTime;
	}

	public String getDepartMemo() {
		return this.departMemo;
	}

	public void setDepartMemo(String departMemo) {
		this.departMemo = departMemo;
	}

}