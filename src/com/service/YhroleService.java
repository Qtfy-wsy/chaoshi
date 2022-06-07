package com.service;
import java.util.List;

import com.model.Yhrole;
import com.model.PageBean;

public interface YhroleService {
	/**
	 * 
	 */
	public void save(Yhrole yhrole);
	/**
	 * 
	 */
	public void modifyYhrole(Yhrole yhrole);
	/**
	 *
	 */
	public void deleteYhrole(Integer id);
	/**
	 *
	 */
	public Yhrole getYhrole(Integer id);
	/**
	 *
	 */
	public List<Yhrole> queryYhroles(Yhrole yhrole,PageBean pageBean);
	
}
