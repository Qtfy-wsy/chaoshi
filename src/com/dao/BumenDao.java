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
import com.model.Bumen;
import com.util.StringUtil;

@Component
public class BumenDao extends HibernateDaoSupport {

	public void save(final Bumen bumen) {
		getHibernateTemplate().save(bumen);
	}

	public void update(final Bumen bumen) {
		getHibernateTemplate().update(bumen);
	}

	public void delete(final Integer id) {
		Bumen bumen = getBumen(id);
		getHibernateTemplate().delete(bumen);
	}

	public Bumen getBumen(final Integer id) {
		return this.getHibernateTemplate().load(Bumen.class, id);
	}

	public List<Bumen> queryByBumen(final Bumen bumen, final PageBean pageBean) {
		List bumenList = getHibernateTemplate().executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				StringBuffer hql = new StringBuffer("from Bumen where 1=1 ");
				if (bumen != null) {
					if (StringUtil.isNotEmpty(bumen.getBumenName())) {
						hql.append(" and bumenName like '%" + bumen.getBumenName() + "%'");
					}
					if (bumen.getBumenMark2()!=null) {
						hql.append(" and bumenMark2 ='" + bumen.getBumenMark2() + "' ");
					}
				}
				hql.append(" order by bumenId");
				if (pageBean != null) {
					int rows = pageBean.getRows();
					int start = pageBean.getStart();
					Query query = session.createQuery(hql.toString());
					query.setFirstResult(start);
					query.setMaxResults(rows);
					List<Bumen> list = query.list();
					session.close();
					return list;
				}
				Query query = session.createQuery(hql.toString());
				List<Bumen> list = query.list();
				session.close();
				return list;
			}

		});

		return bumenList;
	}

}
