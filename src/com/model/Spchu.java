package com.model;

import java.util.Date;

/**
 * Spchu entity. @author MyEclipse Persistence Tools
 */

public class Spchu implements java.io.Serializable {

	// Fields

	private Integer spchuId;
	private String spchuName;
	private String spchuMark;
	private String spchuMark1;
	private String spchuMark2;
	private String spchuMark3;
	private Date spchuDate;
	private Date spchuDate1;
	private Integer spchuZong;
	private Double spchuJine;
	private Double spchuZe;
	private Integer spchuType;
	private Integer spchuType1;
	private Integer shangpinId;
	private String shangpinName;
	private Integer sptypeId;
	private String sptypeName;
	private Integer yonghuId;
	private String yonghuName;
	private Integer yhroleId;
	private String yhroleName;
	private Integer yhbumenId;
	private String yhbumenName;
	private Integer userId;
	private String userName;
	private Integer bumenId;
	private String bumenName;
	private Integer roleId;
	private String roleName;
	private String spchuImg;
	private String spchuImgName;

	// Constructors

	/** default constructor */
	public Spchu() {
	}

	/** full constructor */
	public Spchu(String spchuName, String spchuMark, String spchuMark1,
			String spchuMark2, String spchuMark3, Date spchuDate,
			Date spchuDate1, Integer spchuZong, Double spchuJine,
			Double spchuZe, Integer spchuType, Integer spchuType1,
			Integer shangpinId, String shangpinName, Integer sptypeId,
			String sptypeName, Integer yonghuId, String yonghuName,
			Integer yhroleId, String yhroleName, Integer yhbumenId,
			String yhbumenName, Integer userId, String userName,
			Integer bumenId, String bumenName, Integer roleId, String roleName,
			String spchuImg, String spchuImgName) {
		this.spchuName = spchuName;
		this.spchuMark = spchuMark;
		this.spchuMark1 = spchuMark1;
		this.spchuMark2 = spchuMark2;
		this.spchuMark3 = spchuMark3;
		this.spchuDate = spchuDate;
		this.spchuDate1 = spchuDate1;
		this.spchuZong = spchuZong;
		this.spchuJine = spchuJine;
		this.spchuZe = spchuZe;
		this.spchuType = spchuType;
		this.spchuType1 = spchuType1;
		this.shangpinId = shangpinId;
		this.shangpinName = shangpinName;
		this.sptypeId = sptypeId;
		this.sptypeName = sptypeName;
		this.yonghuId = yonghuId;
		this.yonghuName = yonghuName;
		this.yhroleId = yhroleId;
		this.yhroleName = yhroleName;
		this.yhbumenId = yhbumenId;
		this.yhbumenName = yhbumenName;
		this.userId = userId;
		this.userName = userName;
		this.bumenId = bumenId;
		this.bumenName = bumenName;
		this.roleId = roleId;
		this.roleName = roleName;
		this.spchuImg = spchuImg;
		this.spchuImgName = spchuImgName;
	}

	// Property accessors

	public Integer getSpchuId() {
		return this.spchuId;
	}

	public void setSpchuId(Integer spchuId) {
		this.spchuId = spchuId;
	}

	public String getSpchuName() {
		return this.spchuName;
	}

	public void setSpchuName(String spchuName) {
		this.spchuName = spchuName;
	}

	public String getSpchuMark() {
		return this.spchuMark;
	}

	public void setSpchuMark(String spchuMark) {
		this.spchuMark = spchuMark;
	}

	public String getSpchuMark1() {
		return this.spchuMark1;
	}

	public void setSpchuMark1(String spchuMark1) {
		this.spchuMark1 = spchuMark1;
	}

	public String getSpchuMark2() {
		return this.spchuMark2;
	}

	public void setSpchuMark2(String spchuMark2) {
		this.spchuMark2 = spchuMark2;
	}

	public String getSpchuMark3() {
		return this.spchuMark3;
	}

	public void setSpchuMark3(String spchuMark3) {
		this.spchuMark3 = spchuMark3;
	}

	public Date getSpchuDate() {
		return this.spchuDate;
	}

	public void setSpchuDate(Date spchuDate) {
		this.spchuDate = spchuDate;
	}

	public Date getSpchuDate1() {
		return this.spchuDate1;
	}

	public void setSpchuDate1(Date spchuDate1) {
		this.spchuDate1 = spchuDate1;
	}

	public Integer getSpchuZong() {
		return this.spchuZong;
	}

	public void setSpchuZong(Integer spchuZong) {
		this.spchuZong = spchuZong;
	}

	public Double getSpchuJine() {
		return this.spchuJine;
	}

	public void setSpchuJine(Double spchuJine) {
		this.spchuJine = spchuJine;
	}

	public Double getSpchuZe() {
		return this.spchuZe;
	}

	public void setSpchuZe(Double spchuZe) {
		this.spchuZe = spchuZe;
	}

	public Integer getSpchuType() {
		return this.spchuType;
	}

	public void setSpchuType(Integer spchuType) {
		this.spchuType = spchuType;
	}

	public Integer getSpchuType1() {
		return this.spchuType1;
	}

	public void setSpchuType1(Integer spchuType1) {
		this.spchuType1 = spchuType1;
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

	public Integer getYonghuId() {
		return this.yonghuId;
	}

	public void setYonghuId(Integer yonghuId) {
		this.yonghuId = yonghuId;
	}

	public String getYonghuName() {
		return this.yonghuName;
	}

	public void setYonghuName(String yonghuName) {
		this.yonghuName = yonghuName;
	}

	public Integer getYhroleId() {
		return this.yhroleId;
	}

	public void setYhroleId(Integer yhroleId) {
		this.yhroleId = yhroleId;
	}

	public String getYhroleName() {
		return this.yhroleName;
	}

	public void setYhroleName(String yhroleName) {
		this.yhroleName = yhroleName;
	}

	public Integer getYhbumenId() {
		return this.yhbumenId;
	}

	public void setYhbumenId(Integer yhbumenId) {
		this.yhbumenId = yhbumenId;
	}

	public String getYhbumenName() {
		return this.yhbumenName;
	}

	public void setYhbumenName(String yhbumenName) {
		this.yhbumenName = yhbumenName;
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

	public String getSpchuImg() {
		return this.spchuImg;
	}

	public void setSpchuImg(String spchuImg) {
		this.spchuImg = spchuImg;
	}

	public String getSpchuImgName() {
		return this.spchuImgName;
	}

	public void setSpchuImgName(String spchuImgName) {
		this.spchuImgName = spchuImgName;
	}

}