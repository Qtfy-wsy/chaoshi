package com.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dao.BumenDao;
import com.model.PageBean;
import com.model.Bumen;

public class BumenServiceImp implements BumenService {
	private BumenDao bumenDao;
	
	private PageBean pageBean;
	
	public BumenDao getBumenDao() {  
        return bumenDao;  
    }  
  
    public void setBumenDao(BumenDao bumenDao) {  
        this.bumenDao= bumenDao;  
    }
	
	
	@Override
	public List<Bumen> queryBumens(Bumen bumen,PageBean pageBean){
		return bumenDao.queryByBumen(bumen,pageBean);
	}
	
	@Override
	 public Bumen getBumen(Integer id){
			return bumenDao.getBumen(id);
	}
	
	@Override
	@Transactional
	public void save(Bumen bumen){
		bumenDao.save(bumen);
	}
	
	@Override
	@Transactional
	public void modifyBumen(Bumen bumen){
		bumenDao.update(bumen);
	}
	
	@Override
	@Transactional
	public void deleteBumen(Integer id){
		bumenDao.delete(id);
	}
}
