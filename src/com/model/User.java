package com.model;

import java.util.Date;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer userId;
	private String userName;
	private String userPassword;
	private String userXingming;
	private Integer userSex;
	private Integer userAge;
	private String userPhone;
	private String userMark1;
	private String userMark2;
	private String userMark3;
	private String userMark4;
	private Date userDate1;
	private Date userDate2;
	private Integer userType1;
	private Integer userType2;
	private String userImg;
	private String userImgName;
	private Integer roleId;
	private String roleName;
	private Integer bumenId;
	private String bumenName;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(String userName, String userPassword, String userXingming,
			Integer userSex, Integer userAge, String userPhone,
			String userMark1, String userMark2, String userMark3,
			String userMark4, Date userDate1, Date userDate2,
			Integer userType1, Integer userType2, String userImg, String userImgName, Integer roleId,
			String roleName, Integer bumenId, String bumenName) {
		this.userName = userName;
		this.userPassword = userPassword;
		this.userXingming = userXingming;
		this.userSex = userSex;
		this.userAge = userAge;
		this.userPhone = userPhone;
		this.userMark1 = userMark1;
		this.userMark2 = userMark2;
		this.userMark3 = userMark3;
		this.userMark4 = userMark4;
		this.userDate1 = userDate1;
		this.userDate2 = userDate2;
		this.userType1 = userType1;
		this.userType2 = userType2;
		this.userImg = userImg;
		this.userImgName = userImgName;
		this.roleId = roleId;
		this.roleName = roleName;
		this.bumenId = bumenId;
		this.bumenName = bumenName;
	}

	// Property accessors

	
	
	
	public Integer getUserId() {
		return this.userId;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", userXingming=" + userXingming + ", userSex=" + userSex + ", userAge=" + userAge + ", userPhone="
				+ userPhone + ", userMark1=" + userMark1 + ", userMark2=" + userMark2 + ", userMark3=" + userMark3
				+ ", userMark4=" + userMark4 + ", userDate1=" + userDate1 + ", userDate2=" + userDate2 + ", userType1="
				+ userType1 + ", userType2=" + userType2 + ", userImg=" + userImg + ", userImgName=" + userImgName
				+ ", roleId=" + roleId + ", roleName=" + roleName + ", bumenId=" + bumenId + ", bumenName=" + bumenName
				+ "]";
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserXingming() {
		return this.userXingming;
	}

	public void setUserXingming(String userXingming) {
		this.userXingming = userXingming;
	}

	public Integer getUserSex() {
		return this.userSex;
	}

	public void setUserSex(Integer userSex) {
		this.userSex = userSex;
	}

	public Integer getUserAge() {
		return this.userAge;
	}

	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}

	public String getUserPhone() {
		return this.userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserMark1() {
		return this.userMark1;
	}

	public void setUserMark1(String userMark1) {
		this.userMark1 = userMark1;
	}

	public String getUserMark2() {
		return this.userMark2;
	}

	public void setUserMark2(String userMark2) {
		this.userMark2 = userMark2;
	}

	public String getUserMark3() {
		return this.userMark3;
	}

	public void setUserMark3(String userMark3) {
		this.userMark3 = userMark3;
	}

	public String getUserMark4() {
		return this.userMark4;
	}

	public void setUserMark4(String userMark4) {
		this.userMark4 = userMark4;
	}

	public Date getUserDate1() {
		return this.userDate1;
	}

	public void setUserDate1(Date userDate1) {
		this.userDate1 = userDate1;
	}

	public Date getUserDate2() {
		return this.userDate2;
	}

	public void setUserDate2(Date userDate2) {
		this.userDate2 = userDate2;
	}

	public Integer getUserType1() {
		return this.userType1;
	}

	public void setUserType1(Integer userType1) {
		this.userType1 = userType1;
	}

	public Integer getUserType2() {
		return this.userType2;
	}

	public String getUserImg() {
		return userImg;
	}

	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}

	public String getUserImgName() {
		return userImgName;
	}

	public void setUserImgName(String userImgName) {
		this.userImgName = userImgName;
	}

	public void setUserType2(Integer userType2) {
		this.userType2 = userType2;
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getBumenId() {
		return this.bumenId;
	}

	public void setBumenId(Integer bumenId) {
		this.bumenId = bumenId;
	}

	public String getBumenName() {
		return this.bumenName;
	}

	public void setBumenName(String bumenName) {
		this.bumenName = bumenName;
	}

}