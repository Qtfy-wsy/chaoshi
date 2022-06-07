package com.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dao.SpcangkuDao;
import com.model.PageBean;
import com.model.Spcangku;

public class SpcangkuServiceImp implements SpcangkuService {
	private SpcangkuDao spcangkuDao;
	
	private PageBean pageBean;
	
	public SpcangkuDao getSpcangkuDao() {  
        return spcangkuDao;  
    }  
  
    public void setSpcangkuDao(SpcangkuDao spcangkuDao) {  
        this.spcangkuDao= spcangkuDao;  
    }
	
	
	@Override
	public List<Spcangku> querySpcangkus(Spcangku spcangku,PageBean pageBean, String sdate, String edate){
		return spcangkuDao.queryBySpcangku(spcangku,pageBean,sdate,edate);
	}
	
	@Override
	 public Spcangku getSpcangku(Integer id){
			return spcangkuDao.getSpcangku(id);
	}
	
	@Override
	@Transactional
	public void save(Spcangku spcangku){
		spcangkuDao.save(spcangku);
	}
	
	@Override
	@Transactional
	public void modifySpcangku(Spcangku spcangku){
		spcangkuDao.update(spcangku);
	}
	
	@Override
	@Transactional
	public void deleteSpcangku(Integer id){
		spcangkuDao.delete(id);
	}
}
