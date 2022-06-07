package com.service;
import java.util.List;

import com.model.Gonggao;
import com.model.PageBean;

public interface GonggaoService {
	
	/**
	 *
	 */
	public void save(Gonggao gonggao);
	/**
	 *
	 */
	public void modifyGonggao(Gonggao gonggao);
	/**
	 *
	 */
	public void deleteGonggao(Integer id);
	/**
	 *
	 */
	public Gonggao getGonggao(Integer id);
	/**
	 *
	 */
	public List<Gonggao> queryGonggaos(Gonggao gonggao,PageBean pageBean, String sdate, String edate);
	
}
