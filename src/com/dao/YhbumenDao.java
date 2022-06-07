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
import com.model.Yhbumen;
import com.util.StringUtil;

@Component
public class YhbumenDao extends HibernateDaoSupport {

	public void save(final Yhbumen yhbumen) {
		getHibernateTemplate().save(yhbumen);
	}

	public void update(final Yhbumen yhbumen) {
		getHibernateTemplate().update(yhbumen);
	}

	public void delete(final Integer id) {
		Yhbumen yhbumen = getYhbumen(id);
		getHibernateTemplate().delete(yhbumen);
	}

	public Yhbumen getYhbumen(final Integer id) {
		return this.getHibernateTemplate().load(Yhbumen.class, id);
	}

	public List<Yhbumen> queryByYhbumen(final Yhbumen yhbumen, final PageBean pageBean) {
		List yhbumenList = getHibernateTemplate().executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				StringBuffer hql = new StringBuffer("from Yhbumen where 1=1 ");
				if (yhbumen != null) {
					if (StringUtil.isNotEmpty(yhbumen.getYhbumenName())) {
						hql.append(" and yhbumenName like '%" + yhbumen.getYhbumenName() + "%'");
					}
					if (yhbumen.getYhbumenMark2()!=null) {
						hql.append(" and yhbumenMark2 ='" + yhbumen.getYhbumenMark2() + "' ");
					}
				}
				hql.append(" order by yhbumenId");
				if (pageBean != null) {
					int rows = pageBean.getRows();
					int start = pageBean.getStart();
					Query query = session.createQuery(hql.toString());
					query.setFirstResult(start);
					query.setMaxResults(rows);
					List<Yhbumen> list = query.list();
					session.close();
					return list;
				}
				Query query = session.createQuery(hql.toString());
				List<Yhbumen> list = query.list();
				session.close();
				return list;
			}

		});

		return yhbumenList;
	}

}
