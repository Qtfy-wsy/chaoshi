package com.service;
import java.util.List;

import com.model.Shangpin;
import com.model.PageBean;

public interface ShangpinService {
	public void save(Shangpin shangpin);
	public void modifyShangpin(Shangpin shangpin);
	public void deleteShangpin(Integer id);
	public Shangpin getShangpin(Integer id);
	public List<Shangpin> queryShangpins(Shangpin shangpin,PageBean pageBean, String sdate, String edate, String sdate1, String edate1);
	
}
