package com.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dao.YxinxiDao;
import com.model.PageBean;
import com.model.Yxinxi;

public class YxinxiServiceImp implements YxinxiService {
	private YxinxiDao yxinxiDao;
	
	private PageBean pageBean;
	
	public YxinxiDao getYxinxiDao() {  
        return yxinxiDao;  
    }  
  
    public void setYxinxiDao(YxinxiDao yxinxiDao) {  
        this.yxinxiDao= yxinxiDao;  
    }
	@Override
	public List<Yxinxi> queryYxinxis(Yxinxi yxinxi,PageBean pageBean, String sdate, String edate){
		return yxinxiDao.queryByYxinxi(yxinxi,pageBean,sdate,edate);
	}
	
	@Override
	 public Yxinxi getYxinxi(Integer id){
			return yxinxiDao.getYxinxi(id);
	}
	
	@Override
	@Transactional
	public void save(Yxinxi yxinxi){
		yxinxiDao.save(yxinxi);
	}
	
	@Override
	@Transactional
	public void modifyYxinxi(Yxinxi yxinxi){
		yxinxiDao.update(yxinxi);
	}
	
	@Override
	@Transactional
	public void deleteYxinxi(Integer id){
		yxinxiDao.delete(id);
	}
}
