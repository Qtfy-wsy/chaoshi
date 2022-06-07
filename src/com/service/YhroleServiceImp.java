package com.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dao.YhroleDao;
import com.model.PageBean;
import com.model.Yhrole;

public class YhroleServiceImp implements YhroleService {
	private YhroleDao yhroleDao;
	
	private PageBean pageBean;
	
	public YhroleDao getYhroleDao() {  
        return yhroleDao;  
    }  
  
    public void setYhroleDao(YhroleDao yhroleDao) {  
        this.yhroleDao= yhroleDao;  
    }
	
	
	@Override
	public List<Yhrole> queryYhroles(Yhrole yhrole,PageBean pageBean){
		return yhroleDao.queryByYhrole(yhrole,pageBean);
	}
	
	@Override
	 public Yhrole getYhrole(Integer id){
			return yhroleDao.getYhrole(id);
	}
	
	@Override
	@Transactional
	public void save(Yhrole yhrole){
		yhroleDao.save(yhrole);
	}
	
	@Override
	@Transactional
	public void modifyYhrole(Yhrole yhrole){
		yhroleDao.update(yhrole);
	}
	
	@Override
	@Transactional
	public void deleteYhrole(Integer id){
		yhroleDao.delete(id);
	}
}
