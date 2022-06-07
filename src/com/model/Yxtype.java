package com.model;

/**
 * Yxtype entity. @author MyEclipse Persistence Tools
 */

public class Yxtype implements java.io.Serializable {

	// Fields

	private Integer yxtypeId;
	private String yxtypeName;
	private String yxtypeMark;

	// Constructors

	/** default constructor */
	public Yxtype() {
	}

	/** full constructor */
	public Yxtype(String yxtypeName, String yxtypeMark) {
		this.yxtypeName = yxtypeName;
		this.yxtypeMark = yxtypeMark;
	}

	// Property accessors

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

	public String getYxtypeMark() {
		return this.yxtypeMark;
	}

	public void setYxtypeMark(String yxtypeMark) {
		this.yxtypeMark = yxtypeMark;
	}

}