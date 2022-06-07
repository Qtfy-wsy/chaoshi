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
import com.model.Spchu;
import com.util.StringUtil;

@Component
public class SpchuDao extends HibernateDaoSupport {

	public void save(final Spchu spchu) {
		getHibernateTemplate().save(spchu);
	}

	public void update(final Spchu spchu) {
		getHibernateTemplate().update(spchu);
	}

	public void delete(final Integer id) {
		Spchu spchu = getSpchu(id);
		getHibernateTemplate().delete(spchu);
	}

	public Spchu getSpchu(final Integer id) {
		return this.getHibernateTemplate().load(Spchu.class, id);
	}

	public List<Spchu> queryBySpchu(final Spchu spchu, final PageBean pageBean, final String sdate, final String edate) {
		List spchuList = getHibernateTemplate().executeFind(new HibernateCallback() {
			// 实现HibernateCallBack方法必须且唯一要实现的方法
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				// 执行hibernate分页查询
				StringBuffer hql = new StringBuffer("from Spchu where 1=1 ");
				if (spchu != null) {
					if (StringUtil.isNotEmpty(spchu.getSpchuName())) {
						hql.append(" and spchuName like '%" + spchu.getSpchuName() + "%'");
					}
					if (spchu.getSpchuId()!=null) {
						hql.append(" and spchuId = '" + spchu.getSpchuId() + "'");
					}
					if(StringUtil.isNotEmpty(sdate)){
						hql.append(" and spchuDate > '" + sdate + "'");
					}
					if(StringUtil.isNotEmpty(edate)){
						hql.append(" and spchuDate < '" + edate + "'");
					}
					if (spchu.getSpchuType()!=null) {
						hql.append(" and spchuType = '" + spchu.getSpchuType() + "'");
					}
					if (spchu.getSpchuType1()!=null) {
						hql.append(" and spchuType1 = '" + spchu.getSpchuType1() + "'");
					}
					if (spchu.getSptypeId()!=null) {
						hql.append(" and sptypeId = '" + spchu.getSptypeId() + "'");
					}
					if (spchu.getShangpinId()!=null) {
						hql.append(" and shangpinId = '" + spchu.getShangpinId() + "'");
					}
					if (spchu.getYonghuId()!=null) {
						hql.append(" and yonghuId = '" + spchu.getYonghuId() + "'");
					}
					if (spchu.getYhroleId()!=null) {
						hql.append(" and yhroleId = '" + spchu.getYhroleId() + "'");
					}
					if (spchu.getYhbumenId()!=null) {
						hql.append(" and yhbumenId = '" + spchu.getYhbumenId() + "'");
					}
					if (spchu.getUserId()!=null) {
						hql.append(" and userId = '" + spchu.getUserId() + "'");
					}
					if (spchu.getBumenId()!=null) {
						hql.append(" and bumenId = '" + spchu.getBumenId() + "'");
					}
					if (spchu.getRoleId()!=null) {
						hql.append(" and roleId = '" + spchu.getRoleId() + "'");
					}
				}
				hql.append(" order by spchuId");
				if (pageBean != null) {
					int rows = pageBean.getRows();
					int start = pageBean.getStart();
					Query query = session.createQuery(hql.toString());
					query.setFirstResult(start);
					query.setMaxResults(rows);
					List<Spchu> list = query.list();
					session.close();
					return list;
				}
				Query query = session.createQuery(hql.toString());
				List<Spchu> list = query.list();
				session.close();
				return list;
			}

		});

		return spchuList;
	}

}
