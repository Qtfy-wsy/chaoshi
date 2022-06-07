package com.service;
import java.util.List;

import com.model.Sptype;
import com.model.PageBean;

public interface SptypeService {
	public void save(Sptype sptype);
	public void modifySptype(Sptype sptype);
	public void deleteSptype(Integer id);
	public Sptype getSptype(Integer id);
	public List<Sptype> querySptypes(Sptype sptype,PageBean pageBean);
	
}
