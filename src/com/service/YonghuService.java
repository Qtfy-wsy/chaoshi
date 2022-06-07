package com.service;
import java.util.List;

import com.model.Yonghu;
import com.model.PageBean;

public interface YonghuService {
	/**
	 * 
	 */
	public boolean exits(String yonghuName);
	
	/**
	 * 
	 */
	public List<Yonghu> login(Yonghu yonghu);
	/**
	 *
	 */
	public void save(Yonghu yonghu);
	/**
	 *
	 */
	public void modifyYonghu(Yonghu yonghu);
	/**
	 *
	 */
	public void deleteYonghu(Integer id);
	/**
	 *
	 */
	public Yonghu getYonghu(Integer id);
	/**
	 *
	 */
	public List<Yonghu> queryYonghus(Yonghu yonghu,PageBean pageBean, String sdate, String edate);
	
}
