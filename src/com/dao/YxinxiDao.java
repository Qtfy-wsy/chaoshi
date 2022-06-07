package com.dao;

import java.util.List;

import java.sql.SQLException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Query;

import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import com.model.Yxinxi;
import com.model.PageBean;
import com.util.StringUtil;

@Component
public class YxinxiDao extends HibernateDaoSupport {

	public void save(final Yxinxi yxinxi) {
		getHibernateTemplate().save(yxinxi);
	}

	public void update(final Yxinxi yxinxi) {
		getHibernateTemplate().update(yxinxi);
	}

	public void delete(Integer id) {
		Yxinxi yxinxi = getYxinxi(id);
		getHibernateTemplate().delete(yxinxi);
	}

	public Yxinxi getYxinxi(Integer id) {
		return this.getHibernateTemplate().load(Yxinxi.class, id);
	}

	public List<Yxinxi> queryByYxinxi(final Yxinxi yxinxi, final PageBean pageBean, final String sdate, final String edate) {
		List yxinxiList = getHibernateTemplate().executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				StringBuffer hql = new StringBuffer("from Yxinxi where 1=1 ");
				if (yxinxi != null) {
					if (StringUtil.isNotEmpty(yxinxi.getYxinxiName())) {
						hql.append(" and yxinxiName like '%" + yxinxi.getYxinxiName() + "%'");
					}
					if (yxinxi.getYxinxiId()!=null) {
						hql.append(" and yxinxiId ='" + yxinxi.getYxinxiId() + "' ");
					}
					if (yxinxi.getYxtypeId()!=null) {
						hql.append(" and yxtypeId ='" + yxinxi.getYxtypeId() + "' ");
					}
					if(StringUtil.isNotEmpty(sdate)){
						hql.append(" and yxinxiDate > '" + sdate + "'");
					}
					if(StringUtil.isNotEmpty(edate)){
						hql.append(" and yxinxiDate < '" + edate + "'");
					}
					if (yxinxi.getYxinxiType()!=null) {
						hql.append(" and yxinxiType ='" + yxinxi.getYxinxiType() + "' ");
					}
					if (yxinxi.getYxinxiType1()!=null) {
						hql.append(" and yxinxiType1 ='" + yxinxi.getYxinxiType1() + "' ");
					}
					if (yxinxi.getYonghuId()!=null) {
						hql.append(" and yonghuId ='" + yxinxi.getYonghuId() + "' ");
					}
					if (yxinxi.getYhbumenId()!=null) {
						hql.append(" and yhbumenId ='" + yxinxi.getYhbumenId() + "' ");
					}
				}
				hql.append(" order by yxinxiId");
				System.out.println(hql);
				if (pageBean != null) {
					int rows = pageBean.getRows();
					int start = pageBean.getStart();
					Query query = session.createQuery(hql.toString());
					query.setFirstResult(start);
					query.setMaxResults(rows);
					List<Yxinxi> list = query.list();
					session.close();
					return list;
				} else {
					Query query = session.createQuery(hql.toString());
					List<Yxinxi> list = query.list();
					session.close();
					return list;
				}
			}

		});

		return yxinxiList;
	}
}
