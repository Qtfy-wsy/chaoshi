package com.service;
import java.util.List;

import com.model.User;
import com.model.PageBean;

public interface UserService {
	/**
	 * 
	 */
	public boolean exits(String userName);
	
	/**
	 * 
	 */
	public List<User> login(User user);
	/**
	 *
	 */
	public void save(User user);
	/**
	 *
	 */
	public void modifyUser(User user);
	/**
	 *
	 */
	public void deleteUser(Integer id);
	/**
	 *
	 */
	public User getUser(Integer id);
	/**
	 *
	 */
	public List<User> queryUsers(User user,PageBean pageBean, String sdate, String edate);
	
}
