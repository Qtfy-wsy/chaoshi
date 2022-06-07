package com.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dao.ShangpinDao;
import com.model.PageBean;
import com.model.Shangpin;

public class ShangpinServiceImp implements ShangpinService {
	private ShangpinDao shangpinDao;
	
	private PageBean pageBean;
	
	public ShangpinDao getShangpinDao() {  
        return shangpinDao;  
    }  
  
    public void setShangpinDao(ShangpinDao shangpinDao) {  
        this.shangpinDao= shangpinDao;  
    }
	
	
	@Override
	public List<Shangpin> queryShangpins(Shangpin shangpin,PageBean pageBean, String sdate, String edate, String sdate1, String edate1){
		return shangpinDao.queryByShangpin(shangpin,pageBean,sdate,edate,sdate1,edate1);
	}
	
	@Override
	 public Shangpin getShangpin(Integer id){
			return shangpinDao.getShangpin(id);
	}
	
	@Override
	@Transactional
	public void save(Shangpin shangpin){
		shangpinDao.save(shangpin);
	}
	
	@Override
	@Transactional
	public void modifyShangpin(Shangpin shangpin){
		shangpinDao.update(shangpin);
	}
	
	@Override
	@Transactional
	public void deleteShangpin(Integer id){
		shangpinDao.delete(id);
	}
}
