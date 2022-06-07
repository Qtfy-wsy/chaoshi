package com.dao;

import java.util.List;

import java.sql.SQLException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Query;

import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import com.model.Gonggao;
import com.model.PageBean;
import com.util.StringUtil;

@Component
public class GonggaoDao extends HibernateDaoSupport {

	public void save(final Gonggao gonggao) {
		getHibernateTemplate().save(gonggao);
	}

	public void update(final Gonggao gonggao) {
		getHibernateTemplate().update(gonggao);
	}

	public void delete(Integer id) {
		Gonggao gonggao = getGonggao(id);
		getHibernateTemplate().delete(gonggao);
	}

	public Gonggao getGonggao(Integer id) {
		return this.getHibernateTemplate().load(Gonggao.class, id);
	}

	public List<Gonggao> queryByGonggao(final Gonggao gonggao, final PageBean pageBean, final String sdate, final String edate) {
		List gonggaoList = getHibernateTemplate().executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				StringBuffer hql = new StringBuffer("from Gonggao where 1=1 ");
				if (gonggao != null) {
					if (StringUtil.isNotEmpty(gonggao.getGonggaoName())) {
						hql.append(" and gonggaoName like '%" + gonggao.getGonggaoName() + "%'");
					}
					if (gonggao.getGonggaoId()!=null) {
						hql.append(" and gonggaoId ='" + gonggao.getGonggaoId() + "' ");
					}
					if (gonggao.getGgtypeId()!=null) {
						hql.append(" and ggtypeId ='" + gonggao.getGgtypeId() + "' ");
					}
					if(StringUtil.isNotEmpty(sdate)){
						hql.append(" and gonggaoDate > '" + sdate + "'");
					}
					if(StringUtil.isNotEmpty(edate)){
						hql.append(" and gonggaoDate < '" + edate + "'");
					}
				}
				hql.append(" order by gonggaoId");
				System.out.println(hql);
				if (pageBean != null) {
					int rows = pageBean.getRows();
					int start = pageBean.getStart();
					Query query = session.createQuery(hql.toString());
					query.setFirstResult(start);
					query.setMaxResults(rows);
					List<Gonggao> list = query.list();
					session.close();
					return list;
				} else {
					Query query = session.createQuery(hql.toString());
					List<Gonggao> list = query.list();
					session.close();
					return list;
				}
			}

		});

		return gonggaoList;
	}
}
