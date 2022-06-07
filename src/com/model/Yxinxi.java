package com.model;

import java.util.Date;

/**
 * Yxinxi entity. @author MyEclipse Persistence Tools
 */

public class Yxinxi implements java.io.Serializable {

	// Fields

	private Integer yxinxiId;
	private String yxinxiName;
	private String yxinxiMark;
	private String yxinxiMark1;
	private String yxinxiMark2;
	private String yxinxiImg;
	private String yxinxiImgName;
	private Date yxinxiDate;
	private Integer yxinxiType;
	private Integer yxinxiType1;
	private Integer yxtypeId;
	private String yxtypeName;
	private Integer yonghuId;
	private String yonghuName;
	private Integer yhbumenId;
	private String yhbumenName;

	// Constructors

	/** default constructor */
	public Yxinxi() {
	}

	/** full constructor */
	public Yxinxi(String yxinxiName, String yxinxiMark, String yxinxiMark1,
			String yxinxiMark2, String yxinxiImg, String yxinxiImgName,
			Date yxinxiDate, Integer yxinxiType, Integer yxinxiType1,
			Integer yxtypeId, String yxtypeName, Integer yonghuId,
			String yonghuName, Integer yhbumenId, String yhbumenName) {
		this.yxinxiName = yxinxiName;
		this.yxinxiMark = yxinxiMark;
		this.yxinxiMark1 = yxinxiMark1;
		this.yxinxiMark2 = yxinxiMark2;
		this.yxinxiImg = yxinxiImg;
		this.yxinxiImgName = yxinxiImgName;
		this.yxinxiDate = yxinxiDate;
		this.yxinxiType = yxinxiType;
		this.yxinxiType1 = yxinxiType1;
		this.yxtypeId = yxtypeId;
		this.yxtypeName = yxtypeName;
		this.yonghuId = yonghuId;
		this.yonghuName = yonghuName;
		this.yhbumenId = yhbumenId;
		this.yhbumenName = yhbumenName;
	}

	// Property accessors

	public Integer getYxinxiId() {
		return this.yxinxiId;
	}

	public void setYxinxiId(Integer yxinxiId) {
		this.yxinxiId = yxinxiId;
	}

	public String getYxinxiName() {
		return this.yxinxiName;
	}

	public void setYxinxiName(String yxinxiName) {
		this.yxinxiName = yxinxiName;
	}

	public String getYxinxiMark() {
		return this.yxinxiMark;
	}

	public void setYxinxiMark(String yxinxiMark) {
		this.yxinxiMark = yxinxiMark;
	}

	public String getYxinxiMark1() {
		return this.yxinxiMark1;
	}

	public void setYxinxiMark1(String yxinxiMark1) {
		this.yxinxiMark1 = yxinxiMark1;
	}

	public String getYxinxiMark2() {
		return this.yxinxiMark2;
	}

	public void setYxinxiMark2(String yxinxiMark2) {
		this.yxinxiMark2 = yxinxiMark2;
	}

	public String getYxinxiImg() {
		return this.yxinxiImg;
	}

	public void setYxinxiImg(String yxinxiImg) {
		this.yxinxiImg = yxinxiImg;
	}

	public String getYxinxiImgName() {
		return this.yxinxiImgName;
	}

	public void setYxinxiImgName(String yxinxiImgName) {
		this.yxinxiImgName = yxinxiImgName;
	}

	public Date getYxinxiDate() {
		return this.yxinxiDate;
	}

	public void setYxinxiDate(Date yxinxiDate) {
		this.yxinxiDate = yxinxiDate;
	}

	public Integer getYxinxiType() {
		return this.yxinxiType;
	}

	public void setYxinxiType(Integer yxinxiType) {
		this.yxinxiType = yxinxiType;
	}

	public Integer getYxinxiType1() {
		return this.yxinxiType1;
	}

	public void setYxinxiType1(Integer yxinxiType1) {
		this.yxinxiType1 = yxinxiType1;
	}

	public Integer getYxtypeId() {
		return this.yxtypeId;
	}

	public void setYxtypeId(Integer yxtypeId) {
		this.yxtypeId = yxtypeId;
	}

	public String getYxtypeName() {
		return this.yxtypeName;
	}

	public void setYxtypeName(String yxtypeName) {
		this.yxtypeName = yxtypeName;
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

}