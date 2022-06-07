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
import com.model.Ggtype;
import com.util.StringUtil;

@Component
public class GgtypeDao extends HibernateDaoSupport {

	public void save(final Ggtype ggtype) {
		getHibernateTemplate().save(ggtype);
	}

	public void update(final Ggtype ggtype) {
		getHibernateTemplate().update(ggtype);
	}

	public void delete(final Integer id) {
		Ggtype ggtype = getGgtype(id);
		getHibernateTemplate().delete(ggtype);
	}

	public Ggtype getGgtype(final Integer id) {
		return this.getHibernateTemplate().load(Ggtype.class, id);
	}

	public List<Ggtype> queryByGgtype(final Ggtype ggtype, final PageBean pageBean) {
		List ggtypeList = getHibernateTemplate().executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				StringBuffer hql = new StringBuffer("from Ggtype");
				if (ggtype != null) {
					String ggtypeName = ggtype.getGgtypeName();
					if (StringUtil.isNotEmpty(ggtypeName)) {
						hql.append(" where ggtypeName like '%" + ggtypeName + "%'");
					}
				}
				hql.append(" order by ggtypeId");
				if (pageBean != null) {
					int rows = pageBean.getRows();
					int start = pageBean.getStart();
					Query query = session.createQuery(hql.toString());
					query.setFirstResult(start);
					query.setMaxResults(rows);
					List<Ggtype> list = query.list();
					session.close();
					return list;
				}
				Query query = session.createQuery(hql.toString());
				List<Ggtype> list = query.list();
				session.close();
				return list;
			}

		});

		return ggtypeList;
	}

}
