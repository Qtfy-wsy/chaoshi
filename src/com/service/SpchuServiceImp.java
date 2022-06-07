package com.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dao.SpchuDao;
import com.model.PageBean;
import com.model.Spchu;

public class SpchuServiceImp implements SpchuService {
	private SpchuDao spchuDao;
	
	private PageBean pageBean;
	
	public SpchuDao getSpchuDao() {  
        return spchuDao;  
    }  
  
    public void setSpchuDao(SpchuDao spchuDao) {  
        this.spchuDao= spchuDao;  
    }
	
	
	@Override
	public List<Spchu> querySpchus(Spchu spchu,PageBean pageBean, String sdate, String edate){
		return spchuDao.queryBySpchu(spchu,pageBean,sdate,edate);
	}
	
	@Override
	 public Spchu getSpchu(Integer id){
			return spchuDao.getSpchu(id);
	}
	
	@Override
	@Transactional
	public void save(Spchu spchu){
		spchuDao.save(spchu);
	}
	
	@Override
	@Transactional
	public void modifySpchu(Spchu spchu){
		spchuDao.update(spchu);
	}
	
	@Override
	@Transactional
	public void deleteSpchu(Integer id){
		spchuDao.delete(id);
	}
}
