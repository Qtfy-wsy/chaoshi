package com.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dao.RoleDao;
import com.model.PageBean;
import com.model.Role;

public class RoleServiceImp implements RoleService {
	private RoleDao roleDao;
	
	private PageBean pageBean;
	
	public RoleDao getRoleDao() {  
        return roleDao;  
    }  
  
    public void setRoleDao(RoleDao roleDao) {  
        this.roleDao= roleDao;  
    }
	
	
	@Override
	public List<Role> queryRoles(Role role,PageBean pageBean){
		return roleDao.queryByRole(role,pageBean);
	}
	
	@Override
	 public Role getRole(Integer id){
			return roleDao.getRole(id);
	}
	
	@Override
	@Transactional
	public void save(Role role){
		roleDao.save(role);
	}
	
	@Override
	@Transactional
	public void modifyRole(Role role){
		roleDao.update(role);
	}
	
	@Override
	@Transactional
	public void deleteRole(Integer id){
		roleDao.delete(id);
	}
}
