package com.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dao.UxinxiDao;
import com.model.PageBean;
import com.model.Uxinxi;

public class UxinxiServiceImp implements UxinxiService {
	private UxinxiDao uxinxiDao;
	
	private PageBean pageBean;
	
	public UxinxiDao getUxinxiDao() {  
        return uxinxiDao;  
    }  
  
    public void setUxinxiDao(UxinxiDao uxinxiDao) {  
        this.uxinxiDao= uxinxiDao;  
    }
	@Override
	public List<Uxinxi> queryUxinxis(Uxinxi uxinxi,PageBean pageBean, String sdate, String edate){
		return uxinxiDao.queryByUxinxi(uxinxi,pageBean,sdate,edate);
	}
	
	@Override
	 public Uxinxi getUxinxi(Integer id){
			return uxinxiDao.getUxinxi(id);
	}
	
	@Override
	@Transactional
	public void save(Uxinxi uxinxi){
		uxinxiDao.save(uxinxi);
	}
	
	@Override
	@Transactional
	public void modifyUxinxi(Uxinxi uxinxi){
		uxinxiDao.update(uxinxi);
	}
	
	@Override
	@Transactional
	public void deleteUxinxi(Integer id){
		uxinxiDao.delete(id);
	}
}
