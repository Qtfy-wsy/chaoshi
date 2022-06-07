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
import com.model.Shangpin;
import com.util.StringUtil;

@Component
public class ShangpinDao extends HibernateDaoSupport {

	public void save(final Shangpin shangpin) {
		getHibernateTemplate().save(shangpin);
	}

	public void update(final Shangpin shangpin) {
		getHibernateTemplate().update(shangpin);
	}

	public void delete(final Integer id) {
		Shangpin shangpin = getShangpin(id);
		getHibernateTemplate().delete(shangpin);
	}

	public Shangpin getShangpin(final Integer id) {
		return this.getHibernateTemplate().load(Shangpin.class, id);
	}

	public List<Shangpin> queryByShangpin(final Shangpin shangpin, final PageBean pageBean, final String sdate, final String edate, final String sdate1, final String edate1) {
		List shangpinList = getHibernateTemplate().executeFind(new HibernateCallback() {
			// 实现HibernateCallBack方法必须且唯一要实现的方法
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				// 执行hibernate分页查询
				StringBuffer hql = new StringBuffer("from Shangpin where 1=1 ");
				if (shangpin != null) {
					if (StringUtil.isNotEmpty(shangpin.getShangpinName())) {
						hql.append(" and shangpinName like '%" + shangpin.getShangpinName() + "%'");
					}
					if (shangpin.getSptypeId()!=null) {
						hql.append(" and sptypeId = '" + shangpin.getSptypeId() + "'");
					}
					if (shangpin.getShangpinId()!=null) {
						hql.append(" and shangpinId = '" + shangpin.getShangpinId() + "'");
					}
					if(StringUtil.isNotEmpty(sdate)){
						hql.append(" and shangpinDate > '" + sdate + "'");
					}
					if(StringUtil.isNotEmpty(edate)){
						hql.append(" and shangpinDate < '" + edate + "'");
					}
					if(StringUtil.isNotEmpty(sdate1)){
						hql.append(" and shangpinDate1 > '" + sdate1 + "'");
					}
					if(StringUtil.isNotEmpty(edate1)){
						hql.append(" and shangpinDate1 < '" + edate1 + "'");
					}
					if (shangpin.getShangpinType()!=null) {
						hql.append(" and shangpinType = '" + shangpin.getShangpinType() + "'");
					}
					if (shangpin.getShangpinType1()!=null) {
						hql.append(" and shangpinZong < shangpinType1");
					}
					if (shangpin.getUserId()!=null) {
						hql.append(" and userId = '" + shangpin.getUserId() + "'");
					}
					if (shangpin.getBumenId()!=null) {
						hql.append(" and bumenId = '" + shangpin.getBumenId() + "'");
					}
					if (shangpin.getRoleId()!=null) {
						hql.append(" and roleId = '" + shangpin.getRoleId() + "'");
					}
				}
				hql.append(" order by shangpinId");
				if (pageBean != null) {
					int rows = pageBean.getRows();
					int start = pageBean.getStart();
					Query query = session.createQuery(hql.toString());
					query.setFirstResult(start);
					query.setMaxResults(rows);
					List<Shangpin> list = query.list();
					session.close();
					return list;
				}
				Query query = session.createQuery(hql.toString());
				List<Shangpin> list = query.list();
				session.close();
				return list;
			}

		});

		return shangpinList;
	}

}
