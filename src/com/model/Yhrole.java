package com.model;

/**
 * Yhrole entity. @author MyEclipse Persistence Tools
 */

public class Yhrole implements java.io.Serializable {

	// Fields

	private Integer yhroleId;
	private String yhroleName;
	private String yhroleMark;
	private String yhroleMark1;
	private Integer yhroleMark2;

	// Constructors

	/** default constructor */
	public Yhrole() {
	}

	/** full constructor */
	public Yhrole(String yhroleName, String yhroleMark, String yhroleMark1,
			Integer yhroleMark2) {
		this.yhroleName = yhroleName;
		this.yhroleMark = yhroleMark;
		this.yhroleMark1 = yhroleMark1;
		this.yhroleMark2 = yhroleMark2;
	}

	// Property accessors

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

	public String getYhroleMark() {
		return this.yhroleMark;
	}

	public void setYhroleMark(String yhroleMark) {
		this.yhroleMark = yhroleMark;
	}

	public String getYhroleMark1() {
		return this.yhroleMark1;
	}

	public void setYhroleMark1(String yhroleMark1) {
		this.yhroleMark1 = yhroleMark1;
	}

	public Integer getYhroleMark2() {
		return this.yhroleMark2;
	}

	public void setYhroleMark2(Integer yhroleMark2) {
		this.yhroleMark2 = yhroleMark2;
	}

}