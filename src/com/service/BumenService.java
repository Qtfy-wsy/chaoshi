package com.service;
import java.util.List;

import com.model.Bumen;
import com.model.PageBean;

public interface BumenService {
	/**
	 * 
	 */
	public void save(Bumen bumen);
	/**
	 * 
	 */
	public void modifyBumen(Bumen bumen);
	/**
	 *
	 */
	public void deleteBumen(Integer id);
	/**
	 *
	 */
	public Bumen getBumen(Integer id);
	/**
	 *
	 */
	public List<Bumen> queryBumens(Bumen bumen,PageBean pageBean);
	
}
