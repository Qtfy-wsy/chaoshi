package com.dao;

import java.util.List;

import java.sql.SQLException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Query;

import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import com.model.PageBean;
import com.model.Yhrole;
import com.util.StringUtil;

@Component
public class YhroleDao extends HibernateDaoSupport {

	public void save(final Yhrole yhrole) {
		getHibernateTemplate().save(yhrole);
	}

	public void update(final Yhrole yhrole) {
		getHibernateTemplate().update(yhrole);
	}

	public void delete(final Integer id) {
		Yhrole yhrole = getYhrole(id);
		getHibernateTemplate().delete(yhrole);
	}

	public Yhrole getYhrole(final Integer id) {
		return this.getHibernateTemplate().load(Yhrole.class, id);
	}

	public List<Yhrole> queryByYhrole(final Yhrole yhrole, final PageBean pageBean) {
		List yhroleList = getHibernateTemplate().executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				StringBuffer hql = new StringBuffer("from Yhrole where 1=1 ");
				if (yhrole != null) {
					if (StringUtil.isNotEmpty(yhrole.getYhroleName())) {
						hql.append(" and yhroleName like '%" + yhrole.getYhroleName() + "%'");
					}
					if (yhrole.getYhroleMark2()!=null) {
						hql.append(" and yhroleMark2 ='" + yhrole.getYhroleMark2() + "' ");
					}
				}
				hql.append(" order by yhroleId");
				if (pageBean != null) {
					int rows = pageBean.getRows();
					int start = pageBean.getStart();
					Query query = session.createQuery(hql.toString());
					query.setFirstResult(start);
					query.setMaxResults(rows);
					List<Yhrole> list = query.list();
					session.close();
					return list;
				}
				Query query = session.createQuery(hql.toString());
				List<Yhrole> list = query.list();
				session.close();
				return list;
			}

		});

		return yhroleList;
	}

}
