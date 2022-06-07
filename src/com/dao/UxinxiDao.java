package com.dao;

import java.util.List;

import java.sql.SQLException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Query;

import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import com.model.Uxinxi;
import com.model.PageBean;
import com.util.StringUtil;

@Component
public class UxinxiDao extends HibernateDaoSupport {

	public void save(final Uxinxi uxinxi) {
		getHibernateTemplate().save(uxinxi);
	}

	public void update(final Uxinxi uxinxi) {
		getHibernateTemplate().update(uxinxi);
	}

	public void delete(Integer id) {
		Uxinxi uxinxi = getUxinxi(id);
		getHibernateTemplate().delete(uxinxi);
	}

	public Uxinxi getUxinxi(Integer id) {
		return this.getHibernateTemplate().load(Uxinxi.class, id);
	}

	public List<Uxinxi> queryByUxinxi(final Uxinxi uxinxi, final PageBean pageBean, final String sdate, final String edate) {
		List uxinxiList = getHibernateTemplate().executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				StringBuffer hql = new StringBuffer("from Uxinxi where 1=1 ");
				if (uxinxi != null) {
					if (StringUtil.isNotEmpty(uxinxi.getUxinxiName())) {
						hql.append(" and uxinxiName like '%" + uxinxi.getUxinxiName() + "%'");
					}
					if (uxinxi.getUxinxiId()!=null) {
						hql.append(" and uxinxiId ='" + uxinxi.getUxinxiId() + "' ");
					}
					if (uxinxi.getUxtypeId()!=null) {
						hql.append(" and uxtypeId ='" + uxinxi.getUxtypeId() + "' ");
					}
					if(StringUtil.isNotEmpty(sdate)){
						hql.append(" and uxinxiDate > '" + sdate + "'");
					}
					if(StringUtil.isNotEmpty(edate)){
						hql.append(" and uxinxiDate < '" + edate + "'");
					}
					if (uxinxi.getUxinxiType()!=null) {
						hql.append(" and uxinxiType ='" + uxinxi.getUxinxiType() + "' ");
					}
					if (uxinxi.getUxinxiType1()!=null) {
						hql.append(" and uxinxiType1 ='" + uxinxi.getUxinxiType1() + "' ");
					}
					if (uxinxi.getUserId()!=null) {
						hql.append(" and userId ='" + uxinxi.getUserId() + "' ");
					}
					if (uxinxi.getBumenId()!=null) {
						hql.append(" and bumenId ='" + uxinxi.getBumenId() + "' ");
					}
				}
				hql.append(" order by uxinxiId");
				System.out.println(hql);
				if (pageBean != null) {
					int rows = pageBean.getRows();
					int start = pageBean.getStart();
					Query query = session.createQuery(hql.toString());
					query.setFirstResult(start);
					query.setMaxResults(rows);
					List<Uxinxi> list = query.list();
					session.close();
					return list;
				} else {
					Query query = session.createQuery(hql.toString());
					List<Uxinxi> list = query.list();
					session.close();
					return list;
				}
			}

		});

		return uxinxiList;
	}
}
