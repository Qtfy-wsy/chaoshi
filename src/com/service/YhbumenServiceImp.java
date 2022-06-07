package com.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dao.YhbumenDao;
import com.model.PageBean;
import com.model.Yhbumen;

public class YhbumenServiceImp implements YhbumenService {
	private YhbumenDao yhbumenDao;
	
	private PageBean pageBean;
	
	public YhbumenDao getYhbumenDao() {  
        return yhbumenDao;  
    }  
  
    public void setYhbumenDao(YhbumenDao yhbumenDao) {  
        this.yhbumenDao= yhbumenDao;  
    }
	
	
	@Override
	public List<Yhbumen> queryYhbumens(Yhbumen yhbumen,PageBean pageBean){
		return yhbumenDao.queryByYhbumen(yhbumen,pageBean);
	}
	
	@Override
	 public Yhbumen getYhbumen(Integer id){
			return yhbumenDao.getYhbumen(id);
	}
	
	@Override
	@Transactional
	public void save(Yhbumen yhbumen){
		yhbumenDao.save(yhbumen);
	}
	
	@Override
	@Transactional
	public void modifyYhbumen(Yhbumen yhbumen){
		yhbumenDao.update(yhbumen);
	}
	
	@Override
	@Transactional
	public void deleteYhbumen(Integer id){
		yhbumenDao.delete(id);
	}
}
