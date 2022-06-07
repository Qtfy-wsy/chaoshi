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
import com.model.Yxtype;
import com.util.StringUtil;

@Component
public class YxtypeDao extends HibernateDaoSupport {

	public void save(final Yxtype yxtype) {
		getHibernateTemplate().save(yxtype);
	}

	public void update(final Yxtype yxtype) {
		getHibernateTemplate().update(yxtype);
	}

	public void delete(final Integer id) {
		Yxtype yxtype = getYxtype(id);
		getHibernateTemplate().delete(yxtype);
	}

	public Yxtype getYxtype(final Integer id) {
		return this.getHibernateTemplate().load(Yxtype.class, id);
	}

	public List<Yxtype> queryByYxtype(final Yxtype yxtype, final PageBean pageBean) {
		List yxtypeList = getHibernateTemplate().executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				StringBuffer hql = new StringBuffer("from Yxtype");
				if (yxtype != null) {
					String yxtypeName = yxtype.getYxtypeName();
					if (StringUtil.isNotEmpty(yxtypeName)) {
						hql.append(" where yxtypeName like '%" + yxtypeName + "%'");
					}
				}
				hql.append(" order by yxtypeId");
				if (pageBean != null) {
					int rows = pageBean.getRows();
					int start = pageBean.getStart();
					Query query = session.createQuery(hql.toString());
					query.setFirstResult(start);
					query.setMaxResults(rows);
					List<Yxtype> list = query.list();
					session.close();
					return list;
				}
				Query query = session.createQuery(hql.toString());
				List<Yxtype> list = query.list();
				session.close();
				return list;
			}

		});

		return yxtypeList;
	}

}
