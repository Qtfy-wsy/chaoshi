package com.service;
import java.util.List;

import com.model.Role;
import com.model.PageBean;

public interface RoleService {
	/**
	 * 
	 */
	public void save(Role role);
	/**
	 * 
	 */
	public void modifyRole(Role role);
	/**
	 *
	 */
	public void deleteRole(Integer id);
	/**
	 *
	 */
	public Role getRole(Integer id);
	/**
	 *
	 */
	public List<Role> queryRoles(Role role,PageBean pageBean);
	
}
