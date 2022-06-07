package com.model;

/**
 * Bumen entity. @author MyEclipse Persistence Tools
 */

public class Bumen implements java.io.Serializable {

	// Fields

	private Integer bumenId;
	private String bumenName;
	private String bumenMark;
	private String bumenMark1;
	private Integer bumenMark2;

	// Constructors

	/** default constructor */
	public Bumen() {
	}

	/** full constructor */
	public Bumen(String bumenName, String bumenMark, String bumenMark1,
			Integer bumenMark2) {
		this.bumenName = bumenName;
		this.bumenMark = bumenMark;
		this.bumenMark1 = bumenMark1;
		this.bumenMark2 = bumenMark2;
	}

	// Property accessors

	public Integer getBumenId() {
		return this.bumenId;
	}

	public void setBumenId(Integer bumenId) {
		this.bumenId = bumenId;
	}

	public String getBumenName() {
		return this.bumenName;
	}

	public void setBumenName(String bumenName) {
		this.bumenName = bumenName;
	}

	public String getBumenMark() {
		return this.bumenMark;
	}

	public void setBumenMark(String bumenMark) {
		this.bumenMark = bumenMark;
	}

	public String getBumenMark1() {
		return this.bumenMark1;
	}

	public void setBumenMark1(String bumenMark1) {
		this.bumenMark1 = bumenMark1;
	}

	public Integer getBumenMark2() {
		return this.bumenMark2;
	}

	public void setBumenMark2(Integer bumenMark2) {
		this.bumenMark2 = bumenMark2;
	}

}