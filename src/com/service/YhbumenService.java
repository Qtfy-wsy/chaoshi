package com.service;
import java.util.List;

import com.model.Yhbumen;
import com.model.PageBean;

public interface YhbumenService {
	/**
	 * 
	 */
	public void save(Yhbumen yhbumen);
	/**
	 * 
	 */
	public void modifyYhbumen(Yhbumen yhbumen);
	/**
	 *
	 */
	public void deleteYhbumen(Integer id);
	/**
	 *
	 */
	public Yhbumen getYhbumen(Integer id);
	/**
	 *
	 */
	public List<Yhbumen> queryYhbumens(Yhbumen yhbumen,PageBean pageBean);
	
}
