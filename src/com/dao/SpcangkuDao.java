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
import com.model.Spcangku;
import com.util.StringUtil;

@Component
public class SpcangkuDao extends HibernateDaoSupport {

	public void save(final Spcangku spcangku) {
		getHibernateTemplate().save(spcangku);
	}

	public void update(final Spcangku spcangku) {
		getHibernateTemplate().update(spcangku);
	}

	public void delete(final Integer id) {
		Spcangku spcangku = getSpcangku(id);
		getHibernateTemplate().delete(spcangku);
	}

	public Spcangku getSpcangku(final Integer id) {
		return this.getHibernateTemplate().load(Spcangku.class, id);
	}

	public List<Spcangku> queryBySpcangku(final Spcangku spcangku, final PageBean pageBean, final String sdate, final String edate) {
		List spcangkuList = getHibernateTemplate().executeFind(new HibernateCallback() {
			// 实现HibernateCallBack方法必须且唯一要实现的方法
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				// 执行hibernate分页查询
				StringBuffer hql = new StringBuffer("from Spcangku where 1=1 ");
				if (spcangku != null) {
					if (StringUtil.isNotEmpty(spcangku.getSpcangkuName())) {
						hql.append(" and spcangkuName like '%" + spcangku.getSpcangkuName() + "%'");
					}
					if (StringUtil.isNotEmpty(spcangku.getSpcangkuPhone())) {
						hql.append(" and spcangkuPhone like '%" + spcangku.getSpcangkuPhone() + "%'");
					}
					if (spcangku.getSpcangkuId()!=null) {
						hql.append(" and spcangkuId = '" + spcangku.getSpcangkuId() + "'");
					}
					if(StringUtil.isNotEmpty(sdate)){
						hql.append(" and spcangkuDate > '" + sdate + "'");
					}
					if(StringUtil.isNotEmpty(edate)){
						hql.append(" and spcangkuDate < '" + edate + "'");
					}
					if (spcangku.getSpcangkuType()!=null) {
						hql.append(" and spcangkuType = '" + spcangku.getSpcangkuType() + "'");
					}
					if (spcangku.getSpcangkuType1()!=null) {
						hql.append(" and spcangkuType1 = '" + spcangku.getSpcangkuType1() + "'");
					}
				}
				hql.append(" order by spcangkuId");
				if (pageBean != null) {
					int rows = pageBean.getRows();
					int start = pageBean.getStart();
					Query query = session.createQuery(hql.toString());
					query.setFirstResult(start);
					query.setMaxResults(rows);
					List<Spcangku> list = query.list();
					session.close();
					return list;
				}
				Query query = session.createQuery(hql.toString());
				List<Spcangku> list = query.list();
				session.close();
				return list;
			}

		});

		return spcangkuList;
	}

}
