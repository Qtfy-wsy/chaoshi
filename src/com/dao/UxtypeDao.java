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
import com.model.Uxtype;
import com.util.StringUtil;

@Component
public class UxtypeDao extends HibernateDaoSupport {

	public void save(final Uxtype uxtype) {
		getHibernateTemplate().save(uxtype);
	}

	public void update(final Uxtype uxtype) {
		getHibernateTemplate().update(uxtype);
	}

	public void delete(final Integer id) {
		Uxtype uxtype = getUxtype(id);
		getHibernateTemplate().delete(uxtype);
	}

	public Uxtype getUxtype(final Integer id) {
		return this.getHibernateTemplate().load(Uxtype.class, id);
	}

	public List<Uxtype> queryByUxtype(final Uxtype uxtype, final PageBean pageBean) {
		List uxtypeList = getHibernateTemplate().executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				StringBuffer hql = new StringBuffer("from Uxtype");
				if (uxtype != null) {
					String uxtypeName = uxtype.getUxtypeName();
					if (StringUtil.isNotEmpty(uxtypeName)) {
						hql.append(" where uxtypeName like '%" + uxtypeName + "%'");
					}
				}
				hql.append(" order by uxtypeId");
				if (pageBean != null) {
					int rows = pageBean.getRows();
					int start = pageBean.getStart();
					Query query = session.createQuery(hql.toString());
					query.setFirstResult(start);
					query.setMaxResults(rows);
					List<Uxtype> list = query.list();
					session.close();
					return list;
				}
				Query query = session.createQuery(hql.toString());
				List<Uxtype> list = query.list();
				session.close();
				return list;
			}

		});

		return uxtypeList;
	}

}
