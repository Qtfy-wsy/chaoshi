package com.dao;

import java.util.List;

import java.sql.SQLException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Query;

import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import com.model.User;
import com.model.PageBean;
import com.util.StringUtil;

@Component
public class UserDao extends HibernateDaoSupport {

	public void save(final User user) {
		getHibernateTemplate().save(user);
	}

	public void update(final User user) {
		getHibernateTemplate().update(user);
	}

	public void delete(Integer id) {
		User user = getUser(id);
		getHibernateTemplate().delete(user);
	}

	public User getUser(Integer id) {
		return this.getHibernateTemplate().load(User.class, id);
	}

	public List<User> queryByUser(final User user, final PageBean pageBean, final String sdate, final String edate) {
		List userList = getHibernateTemplate().executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				StringBuffer hql = new StringBuffer("from User where 1=1 ");
				if (user != null) {
					if (StringUtil.isNotEmpty(user.getUserName())) {
						hql.append(" and userName = '" + user.getUserName() + "'");
					}
					if (StringUtil.isNotEmpty(user.getUserXingming())) {
						hql.append(" and userXingming like '%" + user.getUserXingming() + "%'");
					}
					if (user.getUserId()!=null) {
						hql.append(" and userId ='" + user.getUserId() + "' ");
					}
					if (user.getUserType1()!=null) {
						hql.append(" and userType1 ='" + user.getUserType1() + "' ");
					}
					if (user.getUserType2()!=null) {
						hql.append(" and userType2 ='" + user.getUserType2() + "' ");
					}
					if (user.getRoleId()!=null) {
						hql.append(" and roleId ='" + user.getRoleId() + "' ");
					}
					if (user.getBumenId()!=null) {
						hql.append(" and bumenId ='" + user.getBumenId() + "' ");
					}
					if (user.getUserSex()!=null) {
						hql.append(" and userSex ='" + user.getUserSex() + "' ");
					}
					if(StringUtil.isNotEmpty(sdate)){
						hql.append(" and userDate1 > '" + sdate + "'");
					}
					if(StringUtil.isNotEmpty(edate)){
						hql.append(" and userDate1 < '" + edate + "'");
					}
				}
				hql.append(" order by userId");
				System.out.println(hql);
				if (pageBean != null) {
					int rows = pageBean.getRows();
					int start = pageBean.getStart();
					Query query = session.createQuery(hql.toString());
					query.setFirstResult(start);
					query.setMaxResults(rows);
					List<User> list = query.list();
					session.close();
					return list;
				} else {
					Query query = session.createQuery(hql.toString());
					List<User> list = query.list();
					session.close();
					return list;
				}
			}

		});

		return userList;
	}

	public List<User> loginUser(final User user) {
		List userList = getHibernateTemplate().executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				String userName = user.getUserName();
				String userPassword = user.getUserPassword();
				String hql = "from User where userName = '" + userName + "' and userPassword = '" + userPassword + "'";
				Query query = session.createQuery(hql.toString());
				List<User> list = query.list();
				session.close();
				return list;
			}
		});
		return userList;
	}
	
	public boolean exits(final String userName) {
		List userList = getHibernateTemplate().executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				String hql = "from User where userName = '" + userName + "'";
				Query query = session.createQuery(hql.toString());
				List<User> list = query.list();
				session.close();
				return list;
			}
		});
		if(userList.size()==0){
			return true;
		}else {
			return false;
		}
	}
}
