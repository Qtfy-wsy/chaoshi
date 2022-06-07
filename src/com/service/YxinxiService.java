package com.service;
import java.util.List;

import com.model.Yxinxi;
import com.model.PageBean;

public interface YxinxiService {
	
	/**
	 *
	 */
	public void save(Yxinxi yxinxi);
	/**
	 *
	 */
	public void modifyYxinxi(Yxinxi yxinxi);
	/**
	 *
	 */
	public void deleteYxinxi(Integer id);
	/**
	 *
	 */
	public Yxinxi getYxinxi(Integer id);
	/**
	 *
	 */
	public List<Yxinxi> queryYxinxis(Yxinxi yxinxi,PageBean pageBean, String sdate, String edate);
	
}
