package com.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dao.UxtypeDao;
import com.model.PageBean;
import com.model.Uxtype;

public class UxtypeServiceImp implements UxtypeService {
	private UxtypeDao uxtypeDao;
	
	private PageBean pageBean;
	
	public UxtypeDao getUxtypeDao() {  
        return uxtypeDao;  
    }  
  
    public void setUxtypeDao(UxtypeDao uxtypeDao) {  
        this.uxtypeDao= uxtypeDao;  
    }
	
	
	@Override
	public List<Uxtype> queryUxtypes(Uxtype uxtype,PageBean pageBean){
		return uxtypeDao.queryByUxtype(uxtype,pageBean);
	}
	
	@Override
	 public Uxtype getUxtype(Integer id){
			return uxtypeDao.getUxtype(id);
	}
	
	@Override
	@Transactional
	public void save(Uxtype uxtype){
		uxtypeDao.save(uxtype);
	}
	
	@Override
	@Transactional
	public void modifyUxtype(Uxtype uxtype){
		uxtypeDao.update(uxtype);
	}
	
	@Override
	@Transactional
	public void deleteUxtype(Integer id){
		uxtypeDao.delete(id);
	}
}
