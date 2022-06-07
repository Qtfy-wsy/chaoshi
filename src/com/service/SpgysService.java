package com.service;
import java.util.List;

import com.model.Spgys;
import com.model.PageBean;

public interface SpgysService {
	public void save(Spgys spgys);
	public void modifySpgys(Spgys spgys);
	public void deleteSpgys(Integer id);
	public Spgys getSpgys(Integer id);
	public List<Spgys> querySpgyss(Spgys spgys,PageBean pageBean, String sdate, String edate);
	
}
