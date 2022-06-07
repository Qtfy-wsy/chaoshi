package com.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dao.SpgysDao;
import com.model.PageBean;
import com.model.Spgys;

public class SpgysServiceImp implements SpgysService {
	private SpgysDao spgysDao;
	
	private PageBean pageBean;
	
	public SpgysDao getSpgysDao() {  
        return spgysDao;  
    }  
  
    public void setSpgysDao(SpgysDao spgysDao) {  
        this.spgysDao= spgysDao;  
    }
	
	
	@Override
	public List<Spgys> querySpgyss(Spgys spgys,PageBean pageBean, String sdate, String edate){
		return spgysDao.queryBySpgys(spgys,pageBean,sdate,edate);
	}
	
	@Override
	 public Spgys getSpgys(Integer id){
			return spgysDao.getSpgys(id);
	}
	
	@Override
	@Transactional
	public void save(Spgys spgys){
		spgysDao.save(spgys);
	}
	
	@Override
	@Transactional
	public void modifySpgys(Spgys spgys){
		spgysDao.update(spgys);
	}
	
	@Override
	@Transactional
	public void deleteSpgys(Integer id){
		spgysDao.delete(id);
	}
}
