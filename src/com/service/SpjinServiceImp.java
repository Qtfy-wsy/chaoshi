package com.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dao.SpjinDao;
import com.model.PageBean;
import com.model.Spjin;

public class SpjinServiceImp implements SpjinService {
	private SpjinDao spjinDao;
	
	private PageBean pageBean;
	
	public SpjinDao getSpjinDao() {  
        return spjinDao;  
    }  
  
    public void setSpjinDao(SpjinDao spjinDao) {  
        this.spjinDao= spjinDao;  
    }
	
	
	@Override
	public List<Spjin> querySpjins(Spjin spjin,PageBean pageBean, String sdate, String edate){
		return spjinDao.queryBySpjin(spjin,pageBean,sdate,edate);
	}
	
	@Override
	 public Spjin getSpjin(Integer id){
			return spjinDao.getSpjin(id);
	}
	
	@Override
	@Transactional
	public void save(Spjin spjin){
		spjinDao.save(spjin);
	}
	
	@Override
	@Transactional
	public void modifySpjin(Spjin spjin){
		spjinDao.update(spjin);
	}
	
	@Override
	@Transactional
	public void deleteSpjin(Integer id){
		spjinDao.delete(id);
	}
}
