package com.service;
import java.util.List;

import com.model.Spcangku;
import com.model.PageBean;

public interface SpcangkuService {
	public void save(Spcangku spcangku);
	public void modifySpcangku(Spcangku spcangku);
	public void deleteSpcangku(Integer id);
	public Spcangku getSpcangku(Integer id);
	public List<Spcangku> querySpcangkus(Spcangku spcangku,PageBean pageBean, String sdate, String edate);
	
}
