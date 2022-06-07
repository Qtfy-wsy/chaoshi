package com.model;

/**
 * Ggtype entity. @author MyEclipse Persistence Tools
 */

public class Ggtype implements java.io.Serializable {

	// Fields

	private Integer ggtypeId;
	private String ggtypeName;
	private String ggtypeMark;

	// Constructors

	/** default constructor */
	public Ggtype() {
	}

	/** full constructor */
	public Ggtype(String ggtypeName, String ggtypeMark) {
		this.ggtypeName = ggtypeName;
		this.ggtypeMark = ggtypeMark;
	}

	// Property accessors

	public Integer getGgtypeId() {
		return this.ggtypeId;
	}

	public void setGgtypeId(Integer ggtypeId) {
		this.ggtypeId = ggtypeId;
	}

	public String getGgtypeName() {
		return this.ggtypeName;
	}

	public void setGgtypeName(String ggtypeName) {
		this.ggtypeName = ggtypeName;
	}

	public String getGgtypeMark() {
		return this.ggtypeMark;
	}

	public void setGgtypeMark(String ggtypeMark) {
		this.ggtypeMark = ggtypeMark;
	}

}