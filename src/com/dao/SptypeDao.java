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
import com.model.Sptype;
import com.util.StringUtil;

@Component
public class SptypeDao extends HibernateDaoSupport {

	public void save(final Sptype sptype) {
		getHibernateTemplate().save(sptype);
	}

	public void update(final Sptype sptype) {
		getHibernateTemplate().update(sptype);
	}

	public void delete(final Integer id) {
		Sptype sptype = getSptype(id);
		getHibernateTemplate().delete(sptype);
	}

	public Sptype getSptype(final Integer id) {
		return this.getHibernateTemplate().load(Sptype.class, id);
	}

	public List<Sptype> queryBySptype(final Sptype sptype, final PageBean pageBean) {
		List sptypeList = getHibernateTemplate().executeFind(new HibernateCallback() {
			// 实现HibernateCallBack方法必须且唯一要实现的方法
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				// 执行hibernate分页查询
				StringBuffer hql = new StringBuffer("from Sptype where 1=1 ");
				if (sptype != null) {
					if (StringUtil.isNotEmpty(sptype.getSptypeName())) {
						hql.append(" and sptypeName like '%" + sptype.getSptypeName() + "%'");
					}
					if (sptype.getSptypeId()!=null) {
						hql.append(" and sptypeId = '" + sptype.getSptypeId() + "'");
					}
					if (sptype.getSptypeMark2()!=null) {
						hql.append(" and sptypeMark2 = '" + sptype.getSptypeMark2() + "'");
					}
				}
				hql.append(" order by sptypeId");
				if (pageBean != null) {
					int rows = pageBean.getRows();
					int start = pageBean.getStart();
					Query query = session.createQuery(hql.toString());
					query.setFirstResult(start);
					query.setMaxResults(rows);
					List<Sptype> list = query.list();
					session.close();
					return list;
				}
				Query query = session.createQuery(hql.toString());
				List<Sptype> list = query.list();
				session.close();
				return list;
			}

		});

		return sptypeList;
	}

}
