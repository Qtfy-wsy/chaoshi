package com.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import com.model.Admin;
import com.model.PageBean;
import com.util.StringUtil;

@Component
public class AdminDao extends HibernateDaoSupport  {
	public void save(final Admin admin) {
		getHibernateTemplate().save(admin);
	}

	public void update(final Admin admin) {
		getHibernateTemplate().update(admin);
	}

	public void delete(Integer id) {
		Admin admin = getAdmin(id);
		getHibernateTemplate().delete(admin);
	}

	public Admin getAdmin(Integer id) {
		return this.getHibernateTemplate().load(Admin.class, id);
	}
	
	public List<Admin> loginAdmin(final Admin admin) {
		List adminList = getHibernateTemplate().executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				String adminName = admin.getAdminName();
				String adminPassword = admin.getAdminPassword();
				String hql = "from Admin where adminName = '" + adminName + "' and adminPassword = '" + adminPassword + "'";
				Query query = session.createQuery(hql.toString());
				List<Admin> list = query.list();
				session.close();
				return list;
			}
		});
		return adminList;
	}

	public List<Admin> queryByAdmin(final Admin admin, final PageBean pageBean, final String sdate, final String edate) {
		List adminList = getHibernateTemplate().executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				StringBuffer hql = new StringBuffer("from Admin where 1=1 ");
				if (admin != null) {
					if (StringUtil.isNotEmpty(admin.getAdminName())) {
						hql.append(" and adminName like '%" + admin.getAdminName() + "%'");
					}
					if (admin.getAdminId()!=null) {
						hql.append(" and adminId ='" + admin.getAdminId() + "' ");
					}
				}
				hql.append(" order by adminId");
				System.out.println(hql);
				if (pageBean != null) {
					int rows = pageBean.getRows();
					int start = pageBean.getStart();
					Query query = session.createQuery(hql.toString());
					query.setFirstResult(start);
					query.setMaxResults(rows);
					List<Admin> list = query.list();
					session.close();
					return list;
				} else {
					Query query = session.createQuery(hql.toString());
					List<Admin> list = query.list();
					session.close();
					return list;
				}
			}

		});

		return adminList;
	}

}
