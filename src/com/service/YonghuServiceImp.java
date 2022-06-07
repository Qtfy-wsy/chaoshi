package com.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dao.YonghuDao;
import com.model.PageBean;
import com.model.Yonghu;

public class YonghuServiceImp implements YonghuService {
	private YonghuDao yonghuDao;
	
	private PageBean pageBean;
	
	public YonghuDao getYonghuDao() {  
        return yonghuDao;  
    }  
  
    public void setYonghuDao(YonghuDao yonghuDao) {  
        this.yonghuDao= yonghuDao;  
    }
	/**
	@Override
	public boolean exits(String yonghuName){
		List<Yonghu> yonghuList = yonghuDao.findByYonghuName(yonghuName);
		if(yonghuList.size()>0)
			return true;
		else
			return false;
	}
	*/
	
    @Override
	public List<Yonghu> login(Yonghu yonghu){
		return yonghuDao.loginYonghu(yonghu);
	}	
	@Override
	public List<Yonghu> queryYonghus(Yonghu yonghu,PageBean pageBean, String sdate, String edate){
		return yonghuDao.queryByYonghu(yonghu,pageBean,sdate,edate);
	}
	
	@Override
	 public Yonghu getYonghu(Integer id){
			return yonghuDao.getYonghu(id);
	}
	
	@Override
	 public boolean exits(String yonghuName){
			return yonghuDao.exits(yonghuName);
	}
	
	@Override
	@Transactional
	public void save(Yonghu yonghu){
		yonghuDao.save(yonghu);
	}
	
	@Override
	@Transactional
	public void modifyYonghu(Yonghu yonghu){
		yonghuDao.update(yonghu);
	}
	
	@Override
	@Transactional
	public void deleteYonghu(Integer id){
		yonghuDao.delete(id);
	}
}
