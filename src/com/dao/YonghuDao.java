package com.dao;

import java.util.List;

import java.sql.SQLException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Query;

import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import com.model.Yonghu;
import com.model.PageBean;
import com.util.StringUtil;

@Component
public class YonghuDao extends HibernateDaoSupport {

	public void save(final Yonghu yonghu) {
		getHibernateTemplate().save(yonghu);
	}

	public void update(final Yonghu yonghu) {
		getHibernateTemplate().update(yonghu);
	}

	public void delete(Integer id) {
		Yonghu yonghu = getYonghu(id);
		getHibernateTemplate().delete(yonghu);
	}

	public Yonghu getYonghu(Integer id) {
		return this.getHibernateTemplate().load(Yonghu.class, id);
	}

	public List<Yonghu> queryByYonghu(final Yonghu yonghu, final PageBean pageBean, final String sdate, final String edate) {
		List yonghuList = getHibernateTemplate().executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				StringBuffer hql = new StringBuffer("from Yonghu where 1=1 ");
				if (yonghu != null) {
					if (StringUtil.isNotEmpty(yonghu.getYonghuName())) {
						hql.append(" and yonghuName = '" + yonghu.getYonghuName() + "'");
					}
					if (StringUtil.isNotEmpty(yonghu.getYonghuXingming())) {
						hql.append(" and yonghuXingming like '%" + yonghu.getYonghuXingming() + "%'");
					}
					if (yonghu.getYonghuId()!=null) {
						hql.append(" and yonghuId ='" + yonghu.getYonghuId() + "' ");
					}
					if (yonghu.getYonghuType1()!=null) {
						hql.append(" and yonghuType1 ='" + yonghu.getYonghuType1() + "' ");
					}
					if (yonghu.getYonghuType2()!=null) {
						hql.append(" and yonghuType2 ='" + yonghu.getYonghuType2() + "' ");
					}
					if (yonghu.getYhroleId()!=null) {
						hql.append(" and yhroleId ='" + yonghu.getYhroleId() + "' ");
					}
					if (yonghu.getYhbumenId()!=null) {
						hql.append(" and yhbumenId ='" + yonghu.getYhbumenId() + "' ");
					}
					if (yonghu.getYonghuSex()!=null) {
						hql.append(" and yonghuSex ='" + yonghu.getYonghuSex() + "' ");
					}
					if(StringUtil.isNotEmpty(sdate)){
						hql.append(" and yonghuDate1 > '" + sdate + "'");
					}
					if(StringUtil.isNotEmpty(edate)){
						hql.append(" and yonghuDate1 < '" + edate + "'");
					}
				}
				hql.append(" order by yonghuId");
				System.out.println(hql);
				if (pageBean != null) {
					int rows = pageBean.getRows();
					int start = pageBean.getStart();
					Query query = session.createQuery(hql.toString());
					query.setFirstResult(start);
					query.setMaxResults(rows);
					List<Yonghu> list = query.list();
					session.close();
					return list;
				} else {
					Query query = session.createQuery(hql.toString());
					List<Yonghu> list = query.list();
					session.close();
					return list;
				}
			}

		});

		return yonghuList;
	}

	public List<Yonghu> loginYonghu(final Yonghu yonghu) {
		List yonghuList = getHibernateTemplate().executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				String yonghuName = yonghu.getYonghuName();
				String yonghuPassword = yonghu.getYonghuPassword();
				String hql = "from Yonghu where yonghuName = '" + yonghuName + "' and yonghuPassword = '" + yonghuPassword + "'";
				Query query = session.createQuery(hql.toString());
				List<Yonghu> list = query.list();
				session.close();
				return list;
			}
		});
		return yonghuList;
	}
	
	public boolean exits(final String yonghuName) {
		List yonghuList = getHibernateTemplate().executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				String hql = "from Yonghu where yonghuName = '" + yonghuName + "'";
				Query query = session.createQuery(hql.toString());
				List<Yonghu> list = query.list();
				session.close();
				return list;
			}
		});
		if(yonghuList.size()==0){
			return true;
		}else {
			return false;
		}
	}
}
