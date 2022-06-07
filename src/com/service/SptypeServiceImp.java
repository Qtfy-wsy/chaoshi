package com.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dao.SptypeDao;
import com.model.PageBean;
import com.model.Sptype;

public class SptypeServiceImp implements SptypeService {
	private SptypeDao sptypeDao;
	
	private PageBean pageBean;
	
	public SptypeDao getSptypeDao() {  
        return sptypeDao;  
    }  
  
    public void setSptypeDao(SptypeDao sptypeDao) {  
        this.sptypeDao= sptypeDao;  
    }
	
	
	@Override
	public List<Sptype> querySptypes(Sptype sptype,PageBean pageBean){
		return sptypeDao.queryBySptype(sptype,pageBean);
	}
	
	@Override
	 public Sptype getSptype(Integer id){
			return sptypeDao.getSptype(id);
	}
	
	@Override
	@Transactional
	public void save(Sptype sptype){
		sptypeDao.save(sptype);
	}
	
	@Override
	@Transactional
	public void modifySptype(Sptype sptype){
		sptypeDao.update(sptype);
	}
	
	@Override
	@Transactional
	public void deleteSptype(Integer id){
		sptypeDao.delete(id);
	}
}
