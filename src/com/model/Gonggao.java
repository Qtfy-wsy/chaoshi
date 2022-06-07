package com.model;

import java.util.Date;

/**
 * Gonggao entity. @author MyEclipse Persistence Tools
 */

public class Gonggao implements java.io.Serializable {

	// Fields

	private Integer gonggaoId;
	private String gonggaoName;
	private String gonggaoMark;
	private String gonggaoImg;
	private String gonggaoImgName;
	private Date gonggaoDate;
	private Integer ggtypeId;
	private String ggtypeName;

	// Constructors

	/** default constructor */
	public Gonggao() {
	}

	/** full constructor */
	public Gonggao(String gonggaoName, String gonggaoMark, String gonggaoImg,
			String gonggaoImgName, Date gonggaoDate, Integer ggtypeId,
			String ggtypeName) {
		this.gonggaoName = gonggaoName;
		this.gonggaoMark = gonggaoMark;
		this.gonggaoImg = gonggaoImg;
		this.gonggaoImgName = gonggaoImgName;
		this.gonggaoDate = gonggaoDate;
		this.ggtypeId = ggtypeId;
		this.ggtypeName = ggtypeName;
	}

	// Property accessors

	public Integer getGonggaoId() {
		return this.gonggaoId;
	}

	public void setGonggaoId(Integer gonggaoId) {
		this.gonggaoId = gonggaoId;
	}

	public String getGonggaoName() {
		return this.gonggaoName;
	}

	public void setGonggaoName(String gonggaoName) {
		this.gonggaoName = gonggaoName;
	}

	public String getGonggaoMark() {
		return this.gonggaoMark;
	}

	public void setGonggaoMark(String gonggaoMark) {
		this.gonggaoMark = gonggaoMark;
	}

	public String getGonggaoImg() {
		return this.gonggaoImg;
	}

	public void setGonggaoImg(String gonggaoImg) {
		this.gonggaoImg = gonggaoImg;
	}

	public String getGonggaoImgName() {
		return this.gonggaoImgName;
	}

	public void setGonggaoImgName(String gonggaoImgName) {
		this.gonggaoImgName = gonggaoImgName;
	}

	public Date getGonggaoDate() {
		return this.gonggaoDate;
	}

	public void setGonggaoDate(Date gonggaoDate) {
		this.gonggaoDate = gonggaoDate;
	}

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

}