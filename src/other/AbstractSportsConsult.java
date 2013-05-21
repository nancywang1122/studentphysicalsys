package other;

import java.sql.Timestamp;

/**
 * AbstractSportsConsult entity provides the base persistence definition of the
 * SportsConsult entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractSportsConsult implements java.io.Serializable {

	// Fields

	private Integer sportsConsultId;
	private String sportsConsultTitle;
	private String sportsConsultContent;
	private String sportsType;
	private Timestamp sportsConsultCreatedTime;
	private Integer sportsConsultCreatedBy;
	private String sportsConsultCreatedByName;
	private Timestamp sportsConsultUpdatedTime;
	private Integer sportsConsultUpdatedBy;
	private String sportsConsultUpdatedByName;
	private String sportsConsultDepartCode;

	// Constructors

	/** default constructor */
	public AbstractSportsConsult() {
	}

	/** full constructor */
	public AbstractSportsConsult(String sportsConsultTitle,
			String sportsConsultContent, String sportsType,
			Timestamp sportsConsultCreatedTime, Integer sportsConsultCreatedBy,
			String sportsConsultCreatedByName,
			Timestamp sportsConsultUpdatedTime, Integer sportsConsultUpdatedBy,
			String sportsConsultUpdatedByName, String sportsConsultDepartCode) {
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

	public Timestamp getSportsConsultCreatedTime() {
		return this.sportsConsultCreatedTime;
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

	public Timestamp getSportsConsultUpdatedTime() {
		return this.sportsConsultUpdatedTime;
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