package com.service;
import java.util.List;

import com.model.Spchu;
import com.model.PageBean;

public interface SpchuService {
	public void save(Spchu spchu);
	public void modifySpchu(Spchu spchu);
	public void deleteSpchu(Integer id);
	public Spchu getSpchu(Integer id);
	public List<Spchu> querySpchus(Spchu spchu,PageBean pageBean, String sdate, String edate);
	
}
