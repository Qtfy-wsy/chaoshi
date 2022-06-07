package com.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dao.YxtypeDao;
import com.model.PageBean;
import com.model.Yxtype;

public class YxtypeServiceImp implements YxtypeService {
	private YxtypeDao yxtypeDao;
	
	private PageBean pageBean;
	
	public YxtypeDao getYxtypeDao() {  
        return yxtypeDao;  
    }  
  
    public void setYxtypeDao(YxtypeDao yxtypeDao) {  
        this.yxtypeDao= yxtypeDao;  
    }
	
	
	@Override
	public List<Yxtype> queryYxtypes(Yxtype yxtype,PageBean pageBean){
		return yxtypeDao.queryByYxtype(yxtype,pageBean);
	}
	
	@Override
	 public Yxtype getYxtype(Integer id){
			return yxtypeDao.getYxtype(id);
	}
	
	@Override
	@Transactional
	public void save(Yxtype yxtype){
		yxtypeDao.save(yxtype);
	}
	
	@Override
	@Transactional
	public void modifyYxtype(Yxtype yxtype){
		yxtypeDao.update(yxtype);
	}
	
	@Override
	@Transactional
	public void deleteYxtype(Integer id){
		yxtypeDao.delete(id);
	}
}
