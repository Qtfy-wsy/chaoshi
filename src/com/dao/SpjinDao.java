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
import com.model.Spjin;
import com.util.StringUtil;

@Component
public class SpjinDao extends HibernateDaoSupport {

	public void save(final Spjin spjin) {
		getHibernateTemplate().save(spjin);
	}

	public void update(final Spjin spjin) {
		getHibernateTemplate().update(spjin);
	}

	public void delete(final Integer id) {
		Spjin spjin = getSpjin(id);
		getHibernateTemplate().delete(spjin);
	}

	public Spjin getSpjin(final Integer id) {
		return this.getHibernateTemplate().load(Spjin.class, id);
	}

	public List<Spjin> queryBySpjin(final Spjin spjin, final PageBean pageBean, final String sdate, final String edate) {
		List spjinList = getHibernateTemplate().executeFind(new HibernateCallback() {
			// 实现HibernateCallBack方法必须且唯一要实现的方法
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				// 执行hibernate分页查询
				StringBuffer hql = new StringBuffer("from Spjin where 1=1 ");
				if (spjin != null) {
					if (StringUtil.isNotEmpty(spjin.getSpjinName())) {
						hql.append(" and spjinName like '%" + spjin.getSpjinName() + "%'");
					}
					if (spjin.getSpjinId()!=null) {
						hql.append(" and spjinId = '" + spjin.getSpjinId() + "'");
					}
					if(StringUtil.isNotEmpty(sdate)){
						hql.append(" and spjinDate > '" + sdate + "'");
					}
					if(StringUtil.isNotEmpty(edate)){
						hql.append(" and spjinDate < '" + edate + "'");
					}
					if (spjin.getSpjinType()!=null) {
						hql.append(" and spjinType = '" + spjin.getSpjinType() + "'");
					}
					if (spjin.getSpjinType1()!=null) {
						hql.append(" and spjinType1 = '" + spjin.getSpjinType1() + "'");
					}
					if (spjin.getSptypeId()!=null) {
						hql.append(" and sptypeId = '" + spjin.getSptypeId() + "'");
					}
					if (spjin.getShangpinId()!=null) {
						hql.append(" and shangpinId = '" + spjin.getShangpinId() + "'");
					}
					if (spjin.getSpcangkuId()!=null) {
						hql.append(" and spcangkuId = '" + spjin.getSpcangkuId() + "'");
					}
					if (spjin.getSpgysId()!=null) {
						hql.append(" and spgysId = '" + spjin.getSpgysId() + "'");
					}
					if (spjin.getUserId()!=null) {
						hql.append(" and userId = '" + spjin.getUserId() + "'");
					}
					if (spjin.getBumenId()!=null) {
						hql.append(" and bumenId = '" + spjin.getBumenId() + "'");
					}
					if (spjin.getRoleId()!=null) {
						hql.append(" and roleId = '" + spjin.getRoleId() + "'");
					}
				}
				hql.append(" order by spjinId");
				if (pageBean != null) {
					int rows = pageBean.getRows();
					int start = pageBean.getStart();
					Query query = session.createQuery(hql.toString());
					query.setFirstResult(start);
					query.setMaxResults(rows);
					List<Spjin> list = query.list();
					session.close();
					return list;
				}
				Query query = session.createQuery(hql.toString());
				List<Spjin> list = query.list();
				session.close();
				return list;
			}

		});

		return spjinList;
	}

}
