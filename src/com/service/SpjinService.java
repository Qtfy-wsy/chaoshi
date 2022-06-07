package com.service;
import java.util.List;

import com.model.Spjin;
import com.model.PageBean;

public interface SpjinService {
	public void save(Spjin spjin);
	public void modifySpjin(Spjin spjin);
	public void deleteSpjin(Integer id);
	public Spjin getSpjin(Integer id);
	public List<Spjin> querySpjins(Spjin spjin,PageBean pageBean, String sdate, String edate);
	
}
