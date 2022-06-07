package com.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dao.UserDao;
import com.model.PageBean;
import com.model.User;

public class UserServiceImp implements UserService {
	private UserDao userDao;
	
	private PageBean pageBean;
	
	public UserDao getUserDao() {  
        return userDao;  
    }  
  
    public void setUserDao(UserDao userDao) {  
        this.userDao= userDao;  
    }
	/**
	@Override
	public boolean exits(String userName){
		List<User> userList = userDao.findByUserName(userName);
		if(userList.size()>0)
			return true;
		else
			return false;
	}
	*/
	
    @Override
	public List<User> login(User user){
		return userDao.loginUser(user);
	}	
	@Override
	public List<User> queryUsers(User user,PageBean pageBean, String sdate, String edate){
		return userDao.queryByUser(user,pageBean,sdate,edate);
	}
	
	@Override
	 public User getUser(Integer id){
			return userDao.getUser(id);
	}
	
	@Override
	 public boolean exits(String userName){
			return userDao.exits(userName);
	}
	
	@Override
	@Transactional
	public void save(User user){
		userDao.save(user);
	}
	
	@Override
	@Transactional
	public void modifyUser(User user){
		userDao.update(user);
	}
	
	@Override
	@Transactional
	public void deleteUser(Integer id){
		userDao.delete(id);
	}
}
