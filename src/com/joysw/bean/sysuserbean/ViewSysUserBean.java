package com.joysw.bean.sysuserbean;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.joysw.bean.sysdepartbean.SysDepartmentBean;
import com.joysw.bean.sysrolebean.SysRoleBean;

/**
 * SysUser entity. @author MyEclipse Persistence Tools
 */

public class ViewSysUserBean implements java.io.Serializable {

	// Fields
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer userId;
	private String userDepartCode;
	private String userAccount;
	private String userPassword;
	private String userNewPassword;
	private String userSecondPassword;
	private String userName;
	private String userJob;
	private String userSex;
	private String userTelphone;
	private String userMobile;
	private String userEmail;
	private String userLoginIp;
	private Date userLoginTime = new Date();
	private Date userDateJoined = new Date();
	private Integer userCreatedBy;
	private Date userCreatedTime = new Date();
	private Integer userUpdatedBy;
	private Date userUpdatedTime = new Date();
	private Date userBirthday = new Date();
	private String userIdentityCard;
	private String userCompany;
	private String userRegion;
	private String userProvince;
	private String userCity;
	private String userTown;
	private String userAddress;
	private String userPostcode;
	private boolean userActivity;
	private String userActivityFlag;
	private Integer superuserFlag;
	private String userMemo;
	private String userImg;
	private boolean userSysFlag;
	private String userFirstName;
	private String userLastName;
	private boolean userStaff;

	public String getUserActivityFlag() {
		return userActivityFlag;
	}

	public void setUserActivityFlag(String userActivityFlag) {
		this.userActivityFlag = userActivityFlag;
	}

	public Integer getSuperuserFlag() {
		return superuserFlag;
	}

	public void setSuperuserFlag(Integer superuserFlag) {
		this.superuserFlag = superuserFlag;
	}

	public Date getUserDateJoined() {
		return userDateJoined;
	}

	public String getStrUserDateJoined() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (this.userDateJoined != null) {
			return sdf.format(this.userDateJoined);
		}
		return null;
	}

	public void setUserDateJoined(Date userDateJoined) {
		this.userDateJoined = userDateJoined;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public boolean isUserStaff() {
		return userStaff;
	}

	public void setUserStaff(boolean userStaff) {
		this.userStaff = userStaff;
	}

	public String getUserImg() {
		return userImg;
	}

	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}

	public String getUserNewPassword() {
		return userNewPassword;
	}

	public void setUserNewPassword(String userNewPassword) {
		this.userNewPassword = userNewPassword;
	}

	public String getUserSecondPassword() {
		return userSecondPassword;
	}

	public void setUserSecondPassword(String userSecondPassword) {
		this.userSecondPassword = userSecondPassword;
	}

	// Constructors
	/** default constructor */
	public ViewSysUserBean() {
	}

	/** full constructor */
	public ViewSysUserBean(String userDepartCode, String userAccount,
			String userPassword, String userName, String userJob,
			String userSex, String userTelphone, String userMobile,
			String userEmail, String userLoginIp, Timestamp userLoginTime,
			Integer userCreatedBy, Timestamp userCreatedTime,
			Integer userUpdatedBy, Timestamp userUpdatedTime,
			Timestamp userBirthday, String userIdentityCard,
			String userCompany, String userRegion, String userProvince,
			String userCity, String userTown, String userAddress,
			String userPostcode, boolean userActivity, String userMemo) {
		this.userDepartCode = userDepartCode;
		this.userAccount = userAccount;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userJob = userJob;
		this.userSex = userSex;
		this.userTelphone = userTelphone;
		this.userMobile = userMobile;
		this.userEmail = userEmail;
		this.userLoginIp = userLoginIp;
		this.userLoginTime = userLoginTime;
		this.userCreatedBy = userCreatedBy;
		this.userCreatedTime = userCreatedTime;
		this.userUpdatedBy = userUpdatedBy;
		this.userUpdatedTime = userUpdatedTime;
		this.userBirthday = userBirthday;
		this.userIdentityCard = userIdentityCard;
		this.userCompany = userCompany;
		this.userRegion = userRegion;
		this.userProvince = userProvince;
		this.userCity = userCity;
		this.userTown = userTown;
		this.userAddress = userAddress;
		this.userPostcode = userPostcode;
		this.userActivity = userActivity;
		this.userMemo = userMemo;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public Date getUserLoginTime() {
		return userLoginTime;
	}

	public String getStrUserLoginTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (this.userLoginTime != null) {
			return sdf.format(this.userLoginTime);
		}
		return null;
	}

	public void setUserLoginTime(Date userLoginTime) {
		this.userLoginTime = userLoginTime;
	}

	public Date getUserCreatedTime() {
		return userCreatedTime;
	}

	public void setUserCreatedTime(Date userCreatedTime) {
		this.userCreatedTime = userCreatedTime;
	}

	public Date getUserUpdatedTime() {
		return userUpdatedTime;
	}

	public void setUserUpdatedTime(Date userUpdatedTime) {
		this.userUpdatedTime = userUpdatedTime;
	}

	public Date getUserBirthday() {
		return userBirthday;
	}

	public String getStrUserBirthday() {
		// return userBirthday;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (this.userBirthday != null) {
			return sdf.format(this.userBirthday);
		}
		return null;
	}

	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserDepartCode() {
		return userDepartCode;
	}

	public void setUserDepartCode(String userDepartCode) {
		this.userDepartCode = userDepartCode;
	}

	public String getUserAccount() {
		return this.userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserJob() {
		return this.userJob;
	}

	public void setUserJob(String userJob) {
		this.userJob = userJob;
	}

	public String getUserSex() {
		return this.userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserTelphone() {
		return this.userTelphone;
	}

	public void setUserTelphone(String userTelphone) {
		this.userTelphone = userTelphone;
	}

	public String getUserMobile() {
		return this.userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserLoginIp() {
		return this.userLoginIp;
	}

	public void setUserLoginIp(String userLoginIp) {
		this.userLoginIp = userLoginIp;
	}

	public Integer getUserCreatedBy() {
		return this.userCreatedBy;
	}

	public void setUserCreatedBy(Integer userCreatedBy) {
		this.userCreatedBy = userCreatedBy;
	}

	public Integer getUserUpdatedBy() {
		return this.userUpdatedBy;
	}

	public void setUserUpdatedBy(Integer userUpdatedBy) {
		this.userUpdatedBy = userUpdatedBy;
	}

	public String getUserIdentityCard() {
		return this.userIdentityCard;
	}

	public void setUserIdentityCard(String userIdentityCard) {
		this.userIdentityCard = userIdentityCard;
	}

	public String getUserCompany() {
		return this.userCompany;
	}

	public void setUserCompany(String userCompany) {
		this.userCompany = userCompany;
	}

	public String getUserRegion() {
		return this.userRegion;
	}

	public void setUserRegion(String userRegion) {
		this.userRegion = userRegion;
	}

	public String getUserProvince() {
		return this.userProvince;
	}

	public void setUserProvince(String userProvince) {
		this.userProvince = userProvince;
	}

	public String getUserCity() {
		return this.userCity;
	}

	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}

	public String getUserTown() {
		return this.userTown;
	}

	public void setUserTown(String userTown) {
		this.userTown = userTown;
	}

	public String getUserAddress() {
		return this.userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserPostcode() {
		return this.userPostcode;
	}

	public void setUserPostcode(String userPostcode) {
		this.userPostcode = userPostcode;
	}

	public boolean isUserActivity() {
		return userActivity;
	}

	public void setUserActivity(boolean userActivity) {
		this.userActivity = userActivity;
	}

	public boolean isUserSysFlag() {
		return userSysFlag;
	}

	public void setUserSysFlag(boolean userSysFlag) {
		this.userSysFlag = userSysFlag;
	}

	public String getUserMemo() {
		return this.userMemo;
	}

	public void setUserMemo(String userMemo) {
		this.userMemo = userMemo;
	}

}