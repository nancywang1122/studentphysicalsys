package com.joysw.bean.sportsconsultbean;

import java.sql.Timestamp;
import java.util.Date;

/**
 * SportsConsult entity. @author MyEclipse Persistence Tools
 */

public class SportsConsultBean implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer sportsConsultId;
	private String sportsConsultTitle;
	private String sportsConsultContent;
	private String sportsType;
	private Date sportsConsultCreatedTime=new Date();
	private Integer sportsConsultCreatedBy;
	private String sportsConsultCreatedByName;
	private Date sportsConsultUpdatedTime=new Date();
	private Integer sportsConsultUpdatedBy;
	private String sportsConsultUpdatedByName;
	private String sportsConsultDepartCode;

	// Constructors

	/** default constructor */
	public SportsConsultBean() {
	}

	/** minimal constructor */
	public SportsConsultBean(Integer sportsConsultId) {
		this.sportsConsultId = sportsConsultId;
	}

	/** full constructor */
	public SportsConsultBean(Integer sportsConsultId, String sportsConsultTitle,
			String sportsConsultContent, String sportsType,
			Timestamp sportsConsultCreatedTime, Integer sportsConsultCreatedBy,
			Timestamp sportsConsultUpdatedTime, Integer sportsConsultUpdatedBy,
			String sportsConsultDepartCode) {
		this.sportsConsultId = sportsConsultId;
		this.sportsConsultTitle = sportsConsultTitle;
		this.sportsConsultContent = sportsConsultContent;
		this.sportsType = sportsType;
		this.sportsConsultCreatedTime = sportsConsultCreatedTime;
		this.sportsConsultCreatedBy = sportsConsultCreatedBy;
		this.sportsConsultCreatedByName = sportsConsultCreatedByName;
		this.sportsConsultUpdatedTime = sportsConsultUpdatedTime;
		this.sportsConsultUpdatedBy = sportsConsultUpdatedBy;
		this.sportsConsultUpdatedByName = sportsConsultUpdatedByName;
		this.sportsConsultDepartCode = sportsConsultDepartCode;
	}

	// Property accessors

	public Integer getSportsConsultId() {
		return this.sportsConsultId;
	}

	public void setSportsConsultId(Integer sportsConsultId) {
		this.sportsConsultId = sportsConsultId;
	}

	public String getSportsConsultTitle() {
		return this.sportsConsultTitle;
	}

	public void setSportsConsultTitle(String sportsConsultTitle) {
		this.sportsConsultTitle = sportsConsultTitle;
	}

	public String getSportsConsultContent() {
		return this.sportsConsultContent;
	}

	public void setSportsConsultContent(String sportsConsultContent) {
		this.sportsConsultContent = sportsConsultContent;
	}

	public String getSportsType() {
		return this.sportsType;
	}

	public void setSportsType(String sportsType) {
		this.sportsType = sportsType;
	}

	public Date getSportsConsultCreatedTime() {
		return sportsConsultCreatedTime;
	}

	public void setSportsConsultCreatedTime(Date sportsConsultCreatedTime) {
		this.sportsConsultCreatedTime = sportsConsultCreatedTime;
	}

	public Date getSportsConsultUpdatedTime() {
		return sportsConsultUpdatedTime;
	}

	public void setSportsConsultUpdatedTime(Date sportsConsultUpdatedTime) {
		this.sportsConsultUpdatedTime = sportsConsultUpdatedTime;
	}

	public void setSportsConsultCreatedTime(Timestamp sportsConsultCreatedTime) {
		this.sportsConsultCreatedTime = sportsConsultCreatedTime;
	}

	public Integer getSportsConsultCreatedBy() {
		return this.sportsConsultCreatedBy;
	}

	public void setSportsConsultCreatedBy(Integer sportsConsultCreatedBy) {
		this.sportsConsultCreatedBy = sportsConsultCreatedBy;
	}

	public String getSportsConsultCreatedByName() {
		return this.sportsConsultCreatedByName;
	}

	public void setSportsConsultCreatedByName(String sportsConsultCreatedByName) {
		this.sportsConsultCreatedByName = sportsConsultCreatedByName;
	}

	public void setSportsConsultUpdatedTime(Timestamp sportsConsultUpdatedTime) {
		this.sportsConsultUpdatedTime = sportsConsultUpdatedTime;
	}

	public Integer getSportsConsultUpdatedBy() {
		return this.sportsConsultUpdatedBy;
	}

	public void setSportsConsultUpdatedBy(Integer sportsConsultUpdatedBy) {
		this.sportsConsultUpdatedBy = sportsConsultUpdatedBy;
	}

	public String getSportsConsultUpdatedByName() {
		return this.sportsConsultUpdatedByName;
	}

	public void setSportsConsultUpdatedByName(String sportsConsultUpdatedByName) {
		this.sportsConsultUpdatedByName = sportsConsultUpdatedByName;
	}
	
	public String getSportsConsultDepartCode() {
		return this.sportsConsultDepartCode;
	}

	public void setSportsConsultDepartCode(String sportsConsultDepartCode) {
		this.sportsConsultDepartCode = sportsConsultDepartCode;
	}

}