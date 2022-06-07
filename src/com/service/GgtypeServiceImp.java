package com.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dao.GgtypeDao;
import com.model.PageBean;
import com.model.Ggtype;

public class GgtypeServiceImp implements GgtypeService {
	private GgtypeDao ggtypeDao;
	
	private PageBean pageBean;
	
	public GgtypeDao getGgtypeDao() {  
        return ggtypeDao;  
    }  
  
    public void setGgtypeDao(GgtypeDao ggtypeDao) {  
        this.ggtypeDao= ggtypeDao;  
    }
	
	
	@Override
	public List<Ggtype> queryGgtypes(Ggtype ggtype,PageBean pageBean){
		return ggtypeDao.queryByGgtype(ggtype,pageBean);
	}
	
	@Override
	 public Ggtype getGgtype(Integer id){
			return ggtypeDao.getGgtype(id);
	}
	
	@Override
	@Transactional
	public void save(Ggtype ggtype){
		ggtypeDao.save(ggtype);
	}
	
	@Override
	@Transactional
	public void modifyGgtype(Ggtype ggtype){
		ggtypeDao.update(ggtype);
	}
	
	@Override
	@Transactional
	public void deleteGgtype(Integer id){
		ggtypeDao.delete(id);
	}
}
