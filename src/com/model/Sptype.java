package com.model;

/**
 * Sptype entity. @author MyEclipse Persistence Tools
 */

public class Sptype implements java.io.Serializable {

	// Fields

	private Integer sptypeId;
	private String sptypeName;
	private String sptypeMark;
	private String sptypeMark1;
	private Integer sptypeMark2;

	// Constructors

	/** default constructor */
	public Sptype() {
	}

	/** full constructor */
	public Sptype(String sptypeName, String sptypeMark, String sptypeMark1,
			Integer sptypeMark2) {
		this.sptypeName = sptypeName;
		this.sptypeMark = sptypeMark;
		this.sptypeMark1 = sptypeMark1;
		this.sptypeMark2 = sptypeMark2;
	}

	// Property accessors

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

	public String getSptypeMark() {
		return this.sptypeMark;
	}

	public void setSptypeMark(String sptypeMark) {
		this.sptypeMark = sptypeMark;
	}

	public String getSptypeMark1() {
		return this.sptypeMark1;
	}

	public void setSptypeMark1(String sptypeMark1) {
		this.sptypeMark1 = sptypeMark1;
	}

	public Integer getSptypeMark2() {
		return this.sptypeMark2;
	}

	public void setSptypeMark2(Integer sptypeMark2) {
		this.sptypeMark2 = sptypeMark2;
	}

}