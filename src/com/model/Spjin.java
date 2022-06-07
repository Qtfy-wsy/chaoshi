package com.model;

import java.util.Date;

/**
 * Spjin entity. @author MyEclipse Persistence Tools
 */

public class Spjin implements java.io.Serializable {

	// Fields

	private Integer spjinId;
	private String spjinName;
	private String spjinMark;
	private String spjinMark1;
	private String spjinMark2;
	private String spjinMark3;
	private Date spjinDate;
	private Date spjinDate1;
	private Integer spjinZong;
	private Double spjinJine;
	private Double spjinZe;
	private Integer spjinType;
	private Integer spjinType1;
	private Integer shangpinId;
	private String shangpinName;
	private Integer sptypeId;
	private String sptypeName;
	private Integer spcangkuId;
	private String spcangkuName;
	private Integer spgysId;
	private String spgysName;
	private Integer userId;
	private String userName;
	private Integer bumenId;
	private String bumenName;
	private Integer roleId;
	private String roleName;
	private String spjinImg;
	private String spjinImgName;

	// Constructors

	/** default constructor */
	public Spjin() {
	}

	/** full constructor */
	public Spjin(String spjinName, String spjinMark, String spjinMark1,
			String spjinMark2, String spjinMark3, Date spjinDate,
			Date spjinDate1, Integer spjinZong, Double spjinJine,
			Double spjinZe, Integer spjinType, Integer spjinType1,
			Integer shangpinId, String shangpinName, Integer sptypeId,
			String sptypeName, Integer spcangkuId, String spcangkuName,
			Integer spgysId, String spgysName, Integer userId, String userName,
			Integer bumenId, String bumenName, Integer roleId, String roleName,
			String spjinImg, String spjinImgName) {
		this.spjinName = spjinName;
		this.spjinMark = spjinMark;
		this.spjinMark1 = spjinMark1;
		this.spjinMark2 = spjinMark2;
		this.spjinMark3 = spjinMark3;
		this.spjinDate = spjinDate;
		this.spjinDate1 = spjinDate1;
		this.spjinZong = spjinZong;
		this.spjinJine = spjinJine;
		this.spjinZe = spjinZe;
		this.spjinType = spjinType;
		this.spjinType1 = spjinType1;
		this.shangpinId = shangpinId;
		this.shangpinName = shangpinName;
		this.sptypeId = sptypeId;
		this.sptypeName = sptypeName;
		this.spcangkuId = spcangkuId;
		this.spcangkuName = spcangkuName;
		this.spgysId = spgysId;
		this.spgysName = spgysName;
		this.userId = userId;
		this.userName = userName;
		this.bumenId = bumenId;
		this.bumenName = bumenName;
		this.roleId = roleId;
		this.roleName = roleName;
		this.spjinImg = spjinImg;
		this.spjinImgName = spjinImgName;
	}

	// Property accessors

	public Integer getSpjinId() {
		return this.spjinId;
	}

	public void setSpjinId(Integer spjinId) {
		this.spjinId = spjinId;
	}

	public String getSpjinName() {
		return this.spjinName;
	}

	public void setSpjinName(String spjinName) {
		this.spjinName = spjinName;
	}

	public String getSpjinMark() {
		return this.spjinMark;
	}

	public void setSpjinMark(String spjinMark) {
		this.spjinMark = spjinMark;
	}

	public String getSpjinMark1() {
		return this.spjinMark1;
	}

	public void setSpjinMark1(String spjinMark1) {
		this.spjinMark1 = spjinMark1;
	}

	public String getSpjinMark2() {
		return this.spjinMark2;
	}

	public void setSpjinMark2(String spjinMark2) {
		this.spjinMark2 = spjinMark2;
	}

	public String getSpjinMark3() {
		return this.spjinMark3;
	}

	public void setSpjinMark3(String spjinMark3) {
		this.spjinMark3 = spjinMark3;
	}

	public Date getSpjinDate() {
		return this.spjinDate;
	}

	public void setSpjinDate(Date spjinDate) {
		this.spjinDate = spjinDate;
	}

	public Date getSpjinDate1() {
		return this.spjinDate1;
	}

	public void setSpjinDate1(Date spjinDate1) {
		this.spjinDate1 = spjinDate1;
	}

	public Integer getSpjinZong() {
		return this.spjinZong;
	}

	public void setSpjinZong(Integer spjinZong) {
		this.spjinZong = spjinZong;
	}

	public Double getSpjinJine() {
		return this.spjinJine;
	}

	public void setSpjinJine(Double spjinJine) {
		this.spjinJine = spjinJine;
	}

	public Double getSpjinZe() {
		return this.spjinZe;
	}

	public void setSpjinZe(Double spjinZe) {
		this.spjinZe = spjinZe;
	}

	public Integer getSpjinType() {
		return this.spjinType;
	}

	public void setSpjinType(Integer spjinType) {
		this.spjinType = spjinType;
	}

	public Integer getSpjinType1() {
		return this.spjinType1;
	}

	public void setSpjinType1(Integer spjinType1) {
		this.spjinType1 = spjinType1;
	}

	public Integer getShangpinId() {
		return this.shangpinId;
	}

	public void setShangpinId(Integer shangpinId) {
		this.shangpinId = shangpinId;
	}

	public String getShangpinName() {
		return this.shangpinName;
	}

	public void setShangpinName(String shangpinName) {
		this.shangpinName = shangpinName;
	}

	public Integer getSptypeId() {
		return this.sptypeId;
	}

	public void setSptypeId(Integer sptypeId) {
		this.sptypeId = sptypeId;
	}

	public String getSptypeName() {
		return this.sptypeName;
	}

	public void setSptypeName(String sptypeName) {
		this.sptypeName = sptypeName;
	}

	public Integer getSpcangkuId() {
		return this.spcangkuId;
	}

	public void setSpcangkuId(Integer spcangkuId) {
		this.spcangkuId = spcangkuId;
	}

	public String getSpcangkuName() {
		return this.spcangkuName;
	}

	public void setSpcangkuName(String spcangkuName) {
		this.spcangkuName = spcangkuName;
	}

	public Integer getSpgysId() {
		return this.spgysId;
	}

	public void setSpgysId(Integer spgysId) {
		this.spgysId = spgysId;
	}

	public String getSpgysName() {
		return this.spgysName;
	}

	public void setSpgysName(String spgysName) {
		this.spgysName = spgysName;
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

	public String getSpjinImg() {
		return this.spjinImg;
	}

	public void setSpjinImg(String spjinImg) {
		this.spjinImg = spjinImg;
	}

	public String getSpjinImgName() {
		return this.spjinImgName;
	}

	public void setSpjinImgName(String spjinImgName) {
		this.spjinImgName = spjinImgName;
	}

}