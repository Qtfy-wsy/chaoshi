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
import com.model.Spgys;
import com.util.StringUtil;

@Component
public class SpgysDao extends HibernateDaoSupport {

	public void save(final Spgys spgys) {
		getHibernateTemplate().save(spgys);
	}

	public void update(final Spgys spgys) {
		getHibernateTemplate().update(spgys);
	}

	public void delete(final Integer id) {
		Spgys spgys = getSpgys(id);
		getHibernateTemplate().delete(spgys);
	}

	public Spgys getSpgys(final Integer id) {
		return this.getHibernateTemplate().load(Spgys.class, id);
	}

	public List<Spgys> queryBySpgys(final Spgys spgys, final PageBean pageBean, final String sdate, final String edate) {
		List spgysList = getHibernateTemplate().executeFind(new HibernateCallback() {
			// 实现HibernateCallBack方法必须且唯一要实现的方法
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				// 执行hibernate分页查询
				StringBuffer hql = new StringBuffer("from Spgys where 1=1 ");
				if (spgys != null) {
					if (StringUtil.isNotEmpty(spgys.getSpgysName())) {
						hql.append(" and spgysName like '%" + spgys.getSpgysName() + "%'");
					}
					if (StringUtil.isNotEmpty(spgys.getSpgysPhone())) {
						hql.append(" and spgysPhone like '%" + spgys.getSpgysPhone() + "%'");
					}
					if (spgys.getSpgysId()!=null) {
						hql.append(" and spgysId = '" + spgys.getSpgysId() + "'");
					}
					if(StringUtil.isNotEmpty(sdate)){
						hql.append(" and spgysDate > '" + sdate + "'");
					}
					if(StringUtil.isNotEmpty(edate)){
						hql.append(" and spgysDate < '" + edate + "'");
					}
					if (spgys.getSpgysType()!=null) {
						hql.append(" and spgysType = '" + spgys.getSpgysType() + "'");
					}
					if (spgys.getSpgysType1()!=null) {
						hql.append(" and spgysType1 = '" + spgys.getSpgysType1() + "'");
					}
				}
				hql.append(" order by spgysId");
				if (pageBean != null) {
					int rows = pageBean.getRows();
					int start = pageBean.getStart();
					Query query = session.createQuery(hql.toString());
					query.setFirstResult(start);
					query.setMaxResults(rows);
					List<Spgys> list = query.list();
					session.close();
					return list;
				}
				Query query = session.createQuery(hql.toString());
				List<Spgys> list = query.list();
				session.close();
				return list;
			}

		});

		return spgysList;
	}

}
