package com.model;

/**
 * Role entity. @author MyEclipse Persistence Tools
 */

public class Role implements java.io.Serializable {

	// Fields

	private Integer roleId;
	private String roleName;
	private String roleMark;
	private String roleMark1;
	private Integer roleMark2;

	// Constructors

	/** default constructor */
	public Role() {
	}

	/** full constructor */
	public Role(String roleName, String roleMark, String roleMark1,
			Integer roleMark2) {
		this.roleName = roleName;
		this.roleMark = roleMark;
		this.roleMark1 = roleMark1;
		this.roleMark2 = roleMark2;
	}

	// Property accessors

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleMark() {
		return this.roleMark;
	}

	public void setRoleMark(String roleMark) {
		this.roleMark = roleMark;
	}

	public String getRoleMark1() {
		return this.roleMark1;
	}

	public void setRoleMark1(String roleMark1) {
		this.roleMark1 = roleMark1;
	}

	public Integer getRoleMark2() {
		return this.roleMark2;
	}

	public void setRoleMark2(Integer roleMark2) {
		this.roleMark2 = roleMark2;
	}

}