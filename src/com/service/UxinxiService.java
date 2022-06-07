package com.service;
import java.util.List;

import com.model.Uxinxi;
import com.model.PageBean;

public interface UxinxiService {
	
	/**
	 *
	 */
	public void save(Uxinxi uxinxi);
	/**
	 *
	 */
	public void modifyUxinxi(Uxinxi uxinxi);
	/**
	 *
	 */
	public void deleteUxinxi(Integer id);
	/**
	 *
	 */
	public Uxinxi getUxinxi(Integer id);
	/**
	 *
	 */
	public List<Uxinxi> queryUxinxis(Uxinxi uxinxi,PageBean pageBean, String sdate, String edate);
	
}
