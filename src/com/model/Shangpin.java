package com.model;

import java.util.Date;

/**
 * Shangpin entity. @author MyEclipse Persistence Tools
 */

public class Shangpin implements java.io.Serializable {

	// Fields

	private Integer shangpinId;
	private String shangpinName;
	private String shangpinMark;
	private String shangpinMark1;
	private String shangpinMark2;
	private String shangpinMark3;
	private Date shangpinDate;
	private Date shangpinDate1;
	private Integer shangpinZong;
	private Double shangpinJin;
	private Double shangpinXiao;
	private Double shangpinLirun;
	private Integer shangpinType;
	private Integer shangpinType1;
	private String shangpinImg;
	private String shangpinImgName;
	private Integer sptypeId;
	private String sptypeName;
	private Integer userId;
	private String userName;
	private Integer bumenId;
	private String bumenName;
	private Integer roleId;
	private String roleName;

	// Constructors

	/** default constructor */
	public Shangpin() {
	}

	/** full constructor */
	public Shangpin(String shangpinName, String shangpinMark,
			String shangpinMark1, String shangpinMark2, String shangpinMark3,
			Date shangpinDate, Date shangpinDate1,
			Integer shangpinZong, Double shangpinJin, Double shangpinXiao,
			Double shangpinLirun, Integer shangpinType, Integer shangpinType1,
			String shangpinImg, String shangpinImgName, Integer sptypeId,
			String sptypeName, Integer userId, String userName,
			Integer bumenId, String bumenName, Integer roleId, String roleName) {
		this.shangpinName = shangpinName;
		this.shangpinMark = shangpinMark;
		this.shangpinMark1 = shangpinMark1;
		this.shangpinMark2 = shangpinMark2;
		this.shangpinMark3 = shangpinMark3;
		this.shangpinDate = shangpinDate;
		this.shangpinDate1 = shangpinDate1;
		this.shangpinZong = shangpinZong;
		this.shangpinJin = shangpinJin;
		this.shangpinXiao = shangpinXiao;
		this.shangpinLirun = shangpinLirun;
		this.shangpinType = shangpinType;
		this.shangpinType1 = shangpinType1;
		this.shangpinImg = shangpinImg;
		this.shangpinImgName = shangpinImgName;
		this.sptypeId = sptypeId;
		this.sptypeName = sptypeName;
		this.userId = userId;
		this.userName = userName;
		this.bumenId = bumenId;
		this.bumenName = bumenName;
		this.roleId = roleId;
		this.roleName = roleName;
	}

	// Property accessors

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

	public String getShangpinMark() {
		return this.shangpinMark;
	}

	public void setShangpinMark(String shangpinMark) {
		this.shangpinMark = shangpinMark;
	}

	public String getShangpinMark1() {
		return this.shangpinMark1;
	}

	public void setShangpinMark1(String shangpinMark1) {
		this.shangpinMark1 = shangpinMark1;
	}

	public String getShangpinMark2() {
		return this.shangpinMark2;
	}

	public void setShangpinMark2(String shangpinMark2) {
		this.shangpinMark2 = shangpinMark2;
	}

	public String getShangpinMark3() {
		return this.shangpinMark3;
	}

	public void setShangpinMark3(String shangpinMark3) {
		this.shangpinMark3 = shangpinMark3;
	}

	public Date getShangpinDate() {
		return this.shangpinDate;
	}

	public void setShangpinDate(Date shangpinDate) {
		this.shangpinDate = shangpinDate;
	}

	public Date getShangpinDate1() {
		return this.shangpinDate1;
	}

	public void setShangpinDate1(Date shangpinDate1) {
		this.shangpinDate1 = shangpinDate1;
	}

	public Integer getShangpinZong() {
		return this.shangpinZong;
	}

	public void setShangpinZong(Integer shangpinZong) {
		this.shangpinZong = shangpinZong;
	}

	public Double getShangpinJin() {
		return this.shangpinJin;
	}

	public void setShangpinJin(Double shangpinJin) {
		this.shangpinJin = shangpinJin;
	}

	public Double getShangpinXiao() {
		return this.shangpinXiao;
	}

	public void setShangpinXiao(Double shangpinXiao) {
		this.shangpinXiao = shangpinXiao;
	}

	public Double getShangpinLirun() {
		return this.shangpinLirun;
	}

	public void setShangpinLirun(Double shangpinLirun) {
		this.shangpinLirun = shangpinLirun;
	}

	public Integer getShangpinType() {
		return this.shangpinType;
	}

	public void setShangpinType(Integer shangpinType) {
		this.shangpinType = shangpinType;
	}

	public Integer getShangpinType1() {
		return this.shangpinType1;
	}

	public void setShangpinType1(Integer shangpinType1) {
		this.shangpinType1 = shangpinType1;
	}

	public String getShangpinImg() {
		return this.shangpinImg;
	}

	public void setShangpinImg(String shangpinImg) {
		this.shangpinImg = shangpinImg;
	}

	public String getShangpinImgName() {
		return this.shangpinImgName;
	}

	public void setShangpinImgName(String shangpinImgName) {
		this.shangpinImgName = shangpinImgName;
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

}