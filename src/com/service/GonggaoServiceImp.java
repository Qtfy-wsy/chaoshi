package com.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dao.GonggaoDao;
import com.model.PageBean;
import com.model.Gonggao;

public class GonggaoServiceImp implements GonggaoService {
	private GonggaoDao gonggaoDao;
	
	private PageBean pageBean;
	
	public GonggaoDao getGonggaoDao() {  
        return gonggaoDao;  
    }  
  
    public void setGonggaoDao(GonggaoDao gonggaoDao) {  
        this.gonggaoDao= gonggaoDao;  
    }
	@Override
	public List<Gonggao> queryGonggaos(Gonggao gonggao,PageBean pageBean, String sdate, String edate){
		return gonggaoDao.queryByGonggao(gonggao,pageBean,sdate,edate);
	}
	
	@Override
	 public Gonggao getGonggao(Integer id){
			return gonggaoDao.getGonggao(id);
	}
	
	@Override
	@Transactional
	public void save(Gonggao gonggao){
		gonggaoDao.save(gonggao);
	}
	
	@Override
	@Transactional
	public void modifyGonggao(Gonggao gonggao){
		gonggaoDao.update(gonggao);
	}
	
	@Override
	@Transactional
	public void deleteGonggao(Integer id){
		gonggaoDao.delete(id);
	}
}
