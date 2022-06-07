package com.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dao.AdminDao;
import com.model.Admin;
import com.model.PageBean;

public class AdminServiceImp implements AdminService {
	private AdminDao adminDao;
	
	private PageBean pageBean;
	
	public AdminDao getAdminDao() {  
        return adminDao;  
    }  
  
    public void setAdminDao(AdminDao adminDao) {  
        this.adminDao= adminDao;  
    }
	/**
	@Override
	public boolean exits(String adminName){
		List<Admin> adminList = adminDao.findByAdminName(adminName);
		if(adminList.size()>0)
			return true;
		else
			return false;
	}
	*/
	
    @Override
	public List<Admin> login(Admin admin){
		return adminDao.loginAdmin(admin);
	}
	
	@Override
	 public Admin getAdmin(Integer id){
			return adminDao.getAdmin(id);
	}
	
	@Override
	@Transactional
	public void save(Admin admin){
		adminDao.save(admin);
	}
	
	@Override
	@Transactional
	public void modifyAdmin(Admin admin){
		adminDao.update(admin);
	}
	
	@Override
	@Transactional
	public void deleteAdmin(Integer id){
		adminDao.delete(id);
	}
}
