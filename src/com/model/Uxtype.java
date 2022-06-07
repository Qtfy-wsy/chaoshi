package com.model;

/**
 * Uxtype entity. @author MyEclipse Persistence Tools
 */

public class Uxtype implements java.io.Serializable {

	// Fields

	private Integer uxtypeId;
	private String uxtypeName;
	private String uxtypeMark;

	// Constructors

	/** default constructor */
	public Uxtype() {
	}

	/** full constructor */
	public Uxtype(String uxtypeName, String uxtypeMark) {
		this.uxtypeName = uxtypeName;
		this.uxtypeMark = uxtypeMark;
	}

	// Property accessors

	public Integer getUxtypeId() {
		return this.uxtypeId;
	}

	public void setUxtypeId(Integer uxtypeId) {
		this.uxtypeId = uxtypeId;
	}

	public String getUxtypeName() {
		return this.uxtypeName;
	}

	public void setUxtypeName(String uxtypeName) {
		this.uxtypeName = uxtypeName;
	}

	public String getUxtypeMark() {
		return this.uxtypeMark;
	}

	public void setUxtypeMark(String uxtypeMark) {
		this.uxtypeMark = uxtypeMark;
	}

}