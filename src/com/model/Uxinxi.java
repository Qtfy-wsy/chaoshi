package com.model;

import java.util.Date;

/**
 * Uxinxi entity. @author MyEclipse Persistence Tools
 */

public class Uxinxi implements java.io.Serializable {

	// Fields

	private Integer uxinxiId;
	private String uxinxiName;
	private String uxinxiMark;
	private String uxinxiMark1;
	private String uxinxiMark2;
	private String uxinxiImg;
	private String uxinxiImgName;
	private Date uxinxiDate;
	private Integer uxinxiType;
	private Integer uxinxiType1;
	private Integer uxtypeId;
	private String uxtypeName;
	private Integer userId;
	private String userName;
	private Integer bumenId;
	private String bumenName;

	// Constructors

	/** default constructor */
	public Uxinxi() {
	}

	/** full constructor */
	public Uxinxi(String uxinxiName, String uxinxiMark, String uxinxiMark1,
			String uxinxiMark2, String uxinxiImg, String uxinxiImgName,
			Date uxinxiDate, Integer uxinxiType, Integer uxinxiType1,
			Integer uxtypeId, String uxtypeName, Integer userId,
			String userName, Integer bumenId, String bumenName) {
		this.uxinxiName = uxinxiName;
		this.uxinxiMark = uxinxiMark;
		this.uxinxiMark1 = uxinxiMark1;
		this.uxinxiMark2 = uxinxiMark2;
		this.uxinxiImg = uxinxiImg;
		this.uxinxiImgName = uxinxiImgName;
		this.uxinxiDate = uxinxiDate;
		this.uxinxiType = uxinxiType;
		this.uxinxiType1 = uxinxiType1;
		this.uxtypeId = uxtypeId;
		this.uxtypeName = uxtypeName;
		this.userId = userId;
		this.userName = userName;
		this.bumenId = bumenId;
		this.bumenName = bumenName;
	}

	// Property accessors

	public Integer getUxinxiId() {
		return this.uxinxiId;
	}

	public void setUxinxiId(Integer uxinxiId) {
		this.uxinxiId = uxinxiId;
	}

	public String getUxinxiName() {
		return this.uxinxiName;
	}

	public void setUxinxiName(String uxinxiName) {
		this.uxinxiName = uxinxiName;
	}

	public String getUxinxiMark() {
		return this.uxinxiMark;
	}

	public void setUxinxiMark(String uxinxiMark) {
		this.uxinxiMark = uxinxiMark;
	}

	public String getUxinxiMark1() {
		return this.uxinxiMark1;
	}

	public void setUxinxiMark1(String uxinxiMark1) {
		this.uxinxiMark1 = uxinxiMark1;
	}

	public String getUxinxiMark2() {
		return this.uxinxiMark2;
	}

	public void setUxinxiMark2(String uxinxiMark2) {
		this.uxinxiMark2 = uxinxiMark2;
	}

	public String getUxinxiImg() {
		return this.uxinxiImg;
	}

	public void setUxinxiImg(String uxinxiImg) {
		this.uxinxiImg = uxinxiImg;
	}

	public String getUxinxiImgName() {
		return this.uxinxiImgName;
	}

	public void setUxinxiImgName(String uxinxiImgName) {
		this.uxinxiImgName = uxinxiImgName;
	}

	public Date getUxinxiDate() {
		return this.uxinxiDate;
	}

	public void setUxinxiDate(Date uxinxiDate) {
		this.uxinxiDate = uxinxiDate;
	}

	public Integer getUxinxiType() {
		return this.uxinxiType;
	}

	public void setUxinxiType(Integer uxinxiType) {
		this.uxinxiType = uxinxiType;
	}

	public Integer getUxinxiType1() {
		return this.uxinxiType1;
	}

	public void setUxinxiType1(Integer uxinxiType1) {
		this.uxinxiType1 = uxinxiType1;
	}

	public Integer getUxtypeId() {
		return this.uxtypeId;
	}

	public void setUxtypeId(Integer uxtypeId) {
		this.uxtypeId = uxtypeId;
	}

	public String getUxtypeName() {
		return this.uxtypeName;
	}

	public void setUxtypeName(String uxtypeName) {
		this.uxtypeName = uxtypeName;
	}

	public Integer getUserId() {
		return this.userId;
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