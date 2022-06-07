package com.service;
import java.util.List;

import com.model.Admin;

public interface AdminService {
	/**
	 * 
	 */
	public List<Admin> login(Admin admin);
	/**
	 *
	 */
	public void save(Admin admin);
	/**
	 *
	 */
	public void modifyAdmin(Admin admin);
	/**
	 *
	 */
	public void deleteAdmin(Integer id);
	/**
	 *
	 */
	public Admin getAdmin(Integer id);
	
}
