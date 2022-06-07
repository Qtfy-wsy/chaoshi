package com.model;

import java.util.Date;

/**
 * Spgys entity. @author MyEclipse Persistence Tools
 */

public class Spgys implements java.io.Serializable {

	// Fields

	private Integer spgysId;
	private String spgysName;
	private String spgysMark;
	private String spgysMark1;
	private String spgysMark2;
	private String spgysPhone;
	private String spgysDizhi;
	private Date spgysDate;
	private Date spgysDate1;
	private Integer spgysType;
	private Integer spgysType1;

	// Constructors

	/** default constructor */
	public Spgys() {
	}

	/** full constructor */
	public Spgys(String spgysName, String spgysMark, String spgysMark1,
			String spgysMark2, String spgysPhone, String spgysDizhi,
			Date spgysDate, Date spgysDate1, Integer spgysType,
			Integer spgysType1) {
		this.spgysName = spgysName;
		this.spgysMark = spgysMark;
		this.spgysMark1 = spgysMark1;
		this.spgysMark2 = spgysMark2;
		this.spgysPhone = spgysPhone;
		this.spgysDizhi = spgysDizhi;
		this.spgysDate = spgysDate;
		this.spgysDate1 = spgysDate1;
		this.spgysType = spgysType;
		this.spgysType1 = spgysType1;
	}

	// Property accessors

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

	public String getSpgysMark() {
		return this.spgysMark;
	}

	public void setSpgysMark(String spgysMark) {
		this.spgysMark = spgysMark;
	}

	public String getSpgysMark1() {
		return this.spgysMark1;
	}

	public void setSpgysMark1(String spgysMark1) {
		this.spgysMark1 = spgysMark1;
	}

	public String getSpgysMark2() {
		return this.spgysMark2;
	}

	public void setSpgysMark2(String spgysMark2) {
		this.spgysMark2 = spgysMark2;
	}

	public String getSpgysPhone() {
		return this.spgysPhone;
	}

	public void setSpgysPhone(String spgysPhone) {
		this.spgysPhone = spgysPhone;
	}

	public String getSpgysDizhi() {
		return this.spgysDizhi;
	}

	public void setSpgysDizhi(String spgysDizhi) {
		this.spgysDizhi = spgysDizhi;
	}

	public Date getSpgysDate() {
		return this.spgysDate;
	}

	public void setSpgysDate(Date spgysDate) {
		this.spgysDate = spgysDate;
	}

	public Date getSpgysDate1() {
		return this.spgysDate1;
	}

	public void setSpgysDate1(Date spgysDate1) {
		this.spgysDate1 = spgysDate1;
	}

	public Integer getSpgysType() {
		return this.spgysType;
	}

	public void setSpgysType(Integer spgysType) {
		this.spgysType = spgysType;
	}

	public Integer getSpgysType1() {
		return this.spgysType1;
	}

	public void setSpgysType1(Integer spgysType1) {
		this.spgysType1 = spgysType1;
	}

}