package com.model;

/**
 * Yhbumen entity. @author MyEclipse Persistence Tools
 */

public class Yhbumen implements java.io.Serializable {

	// Fields

	private Integer yhbumenId;
	private String yhbumenName;
	private String yhbumenMark;
	private String yhbumenMark1;
	private Integer yhbumenMark2;

	// Constructors

	/** default constructor */
	public Yhbumen() {
	}

	/** full constructor */
	public Yhbumen(String yhbumenName, String yhbumenMark, String yhbumenMark1,
			Integer yhbumenMark2) {
		this.yhbumenName = yhbumenName;
		this.yhbumenMark = yhbumenMark;
		this.yhbumenMark1 = yhbumenMark1;
		this.yhbumenMark2 = yhbumenMark2;
	}

	// Property accessors

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

	public String getYhbumenMark() {
		return this.yhbumenMark;
	}

	public void setYhbumenMark(String yhbumenMark) {
		this.yhbumenMark = yhbumenMark;
	}

	public String getYhbumenMark1() {
		return this.yhbumenMark1;
	}

	public void setYhbumenMark1(String yhbumenMark1) {
		this.yhbumenMark1 = yhbumenMark1;
	}

	public Integer getYhbumenMark2() {
		return this.yhbumenMark2;
	}

	public void setYhbumenMark2(Integer yhbumenMark2) {
		this.yhbumenMark2 = yhbumenMark2;
	}

}