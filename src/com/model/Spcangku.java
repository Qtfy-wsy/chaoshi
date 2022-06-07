package com.model;

import java.util.Date;

/**
 * Spcangku entity. @author MyEclipse Persistence Tools
 */

public class Spcangku implements java.io.Serializable {

	// Fields

	private Integer spcangkuId;
	private String spcangkuName;
	private String spcangkuMark;
	private String spcangkuMark1;
	private String spcangkuMark2;
	private String spcangkuPhone;
	private String spcangkuDizhi;
	private Date spcangkuDate;
	private Date spcangkuDate1;
	private Integer spcangkuType;
	private Integer spcangkuType1;

	// Constructors

	/** default constructor */
	public Spcangku() {
	}

	/** full constructor */
	public Spcangku(String spcangkuName, String spcangkuMark,
			String spcangkuMark1, String spcangkuMark2, String spcangkuPhone,
			String spcangkuDizhi, Date spcangkuDate,
			Date spcangkuDate1, Integer spcangkuType, Integer spcangkuType1) {
		this.spcangkuName = spcangkuName;
		this.spcangkuMark = spcangkuMark;
		this.spcangkuMark1 = spcangkuMark1;
		this.spcangkuMark2 = spcangkuMark2;
		this.spcangkuPhone = spcangkuPhone;
		this.spcangkuDizhi = spcangkuDizhi;
		this.spcangkuDate = spcangkuDate;
		this.spcangkuDate1 = spcangkuDate1;
		this.spcangkuType = spcangkuType;
		this.spcangkuType1 = spcangkuType1;
	}

	// Property accessors

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

	public String getSpcangkuMark() {
		return this.spcangkuMark;
	}

	public void setSpcangkuMark(String spcangkuMark) {
		this.spcangkuMark = spcangkuMark;
	}

	public String getSpcangkuMark1() {
		return this.spcangkuMark1;
	}

	public void setSpcangkuMark1(String spcangkuMark1) {
		this.spcangkuMark1 = spcangkuMark1;
	}

	public String getSpcangkuMark2() {
		return this.spcangkuMark2;
	}

	public void setSpcangkuMark2(String spcangkuMark2) {
		this.spcangkuMark2 = spcangkuMark2;
	}

	public String getSpcangkuPhone() {
		return this.spcangkuPhone;
	}

	public void setSpcangkuPhone(String spcangkuPhone) {
		this.spcangkuPhone = spcangkuPhone;
	}

	public String getSpcangkuDizhi() {
		return this.spcangkuDizhi;
	}

	public void setSpcangkuDizhi(String spcangkuDizhi) {
		this.spcangkuDizhi = spcangkuDizhi;
	}

	public Date getSpcangkuDate() {
		return this.spcangkuDate;
	}

	public void setSpcangkuDate(Date spcangkuDate) {
		this.spcangkuDate = spcangkuDate;
	}

	public Date getSpcangkuDate1() {
		return this.spcangkuDate1;
	}

	public void setSpcangkuDate1(Date spcangkuDate1) {
		this.spcangkuDate1 = spcangkuDate1;
	}

	public Integer getSpcangkuType() {
		return this.spcangkuType;
	}

	public void setSpcangkuType(Integer spcangkuType) {
		this.spcangkuType = spcangkuType;
	}

	public Integer getSpcangkuType1() {
		return this.spcangkuType1;
	}

	public void setSpcangkuType1(Integer spcangkuType1) {
		this.spcangkuType1 = spcangkuType1;
	}

}