package com.model;

import java.util.Date;

/**
 * Yonghu entity. @author MyEclipse Persistence Tools
 */

public class Yonghu implements java.io.Serializable {

	// Fields

	private Integer yonghuId;
	private String yonghuName;
	private String yonghuPassword;
	private String yonghuXingming;
	private Integer yonghuSex;
	private Integer yonghuAge;
	private String yonghuPhone;
	private String yonghuMark1;
	private String yonghuMark2;
	private String yonghuMark3;
	private String yonghuMark4;
	private Date yonghuDate1;
	private Date yonghuDate2;
	private Integer yonghuType1;
	private Integer yonghuType2;
	private String yonghuImg;
	private String yonghuImgName;
	private Integer yhroleId;
	private String yhroleName;
	private Integer yhbumenId;
	private String yhbumenName;

	// Constructors

	/** default constructor */
	public Yonghu() {
	}

	/** full constructor */
	public Yonghu(String yonghuName, String yonghuPassword,
			String yonghuXingming, Integer yonghuSex, Integer yonghuAge,
			String yonghuPhone, String yonghuMark1, String yonghuMark2,
			String yonghuMark3, String yonghuMark4, Date yonghuDate1,
			Date yonghuDate2, Integer yonghuType1, Integer yonghuType2, String yonghuImg,
			String yonghuImgName,Integer yhroleId, String yhroleName, Integer yhbumenId,
			String yhbumenName) {
		this.yonghuName = yonghuName;
		this.yonghuPassword = yonghuPassword;
		this.yonghuXingming = yonghuXingming;
		this.yonghuSex = yonghuSex;
		this.yonghuAge = yonghuAge;
		this.yonghuPhone = yonghuPhone;
		this.yonghuMark1 = yonghuMark1;
		this.yonghuMark2 = yonghuMark2;
		this.yonghuMark3 = yonghuMark3;
		this.yonghuMark4 = yonghuMark4;
		this.yonghuDate1 = yonghuDate1;
		this.yonghuDate2 = yonghuDate2;
		this.yonghuType1 = yonghuType1;
		this.yonghuType2 = yonghuType2;
		this.yonghuImg = yonghuImg;
		this.yonghuImgName = yonghuImgName;
		this.yhroleId = yhroleId;
		this.yhroleName = yhroleName;
		this.yhbumenId = yhbumenId;
		this.yhbumenName = yhbumenName;
	}

	// Property accessors

	@Override
	public String toString() {
		return "Yonghu [yonghuId=" + yonghuId + ", yonghuName=" + yonghuName + ", yonghuPassword=" + yonghuPassword
				+ ", yonghuXingming=" + yonghuXingming + ", yonghuSex=" + yonghuSex + ", yonghuAge=" + yonghuAge
				+ ", yonghuPhone=" + yonghuPhone + ", yonghuMark1=" + yonghuMark1 + ", yonghuMark2=" + yonghuMark2
				+ ", yonghuMark3=" + yonghuMark3 + ", yonghuMark4=" + yonghuMark4 + ", yonghuDate1=" + yonghuDate1
				+ ", yonghuDate2=" + yonghuDate2 + ", yonghuType1=" + yonghuType1 + ", yonghuType2=" + yonghuType2
				+ ", yonghuImg=" + yonghuImg + ", yonghuImgName=" + yonghuImgName + ", yhroleId=" + yhroleId
				+ ", yhroleName=" + yhroleName + ", yhbumenId=" + yhbumenId + ", yhbumenName=" + yhbumenName + "]";
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

	public String getYonghuPassword() {
		return this.yonghuPassword;
	}

	public void setYonghuPassword(String yonghuPassword) {
		this.yonghuPassword = yonghuPassword;
	}

	public String getYonghuXingming() {
		return this.yonghuXingming;
	}

	public void setYonghuXingming(String yonghuXingming) {
		this.yonghuXingming = yonghuXingming;
	}

	public Integer getYonghuSex() {
		return this.yonghuSex;
	}

	public void setYonghuSex(Integer yonghuSex) {
		this.yonghuSex = yonghuSex;
	}

	public Integer getYonghuAge() {
		return this.yonghuAge;
	}

	public void setYonghuAge(Integer yonghuAge) {
		this.yonghuAge = yonghuAge;
	}

	public String getYonghuPhone() {
		return this.yonghuPhone;
	}

	public void setYonghuPhone(String yonghuPhone) {
		this.yonghuPhone = yonghuPhone;
	}

	public String getYonghuMark1() {
		return this.yonghuMark1;
	}

	public void setYonghuMark1(String yonghuMark1) {
		this.yonghuMark1 = yonghuMark1;
	}

	public String getYonghuMark2() {
		return this.yonghuMark2;
	}

	public void setYonghuMark2(String yonghuMark2) {
		this.yonghuMark2 = yonghuMark2;
	}

	public String getYonghuMark3() {
		return this.yonghuMark3;
	}

	public void setYonghuMark3(String yonghuMark3) {
		this.yonghuMark3 = yonghuMark3;
	}

	public String getYonghuMark4() {
		return this.yonghuMark4;
	}

	public void setYonghuMark4(String yonghuMark4) {
		this.yonghuMark4 = yonghuMark4;
	}

	public Date getYonghuDate1() {
		return this.yonghuDate1;
	}

	public void setYonghuDate1(Date yonghuDate1) {
		this.yonghuDate1 = yonghuDate1;
	}

	public Date getYonghuDate2() {
		return this.yonghuDate2;
	}

	public void setYonghuDate2(Date yonghuDate2) {
		this.yonghuDate2 = yonghuDate2;
	}

	public Integer getYonghuType1() {
		return this.yonghuType1;
	}

	public void setYonghuType1(Integer yonghuType1) {
		this.yonghuType1 = yonghuType1;
	}

	public Integer getYonghuType2() {
		return this.yonghuType2;
	}

	public void setYonghuType2(Integer yonghuType2) {
		this.yonghuType2 = yonghuType2;
	}

	public String getYonghuImg() {
		return yonghuImg;
	}

	public void setYonghuImg(String yonghuImg) {
		this.yonghuImg = yonghuImg;
	}

	public String getYonghuImgName() {
		return yonghuImgName;
	}

	public void setYonghuImgName(String yonghuImgName) {
		this.yonghuImgName = yonghuImgName;
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

}