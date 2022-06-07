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
import com.model.Role;
import com.util.StringUtil;

@Component
public class RoleDao extends HibernateDaoSupport {

	public void save(final Role role) {
		getHibernateTemplate().save(role);
	}

	public void update(final Role role) {
		getHibernateTemplate().update(role);
	}

	public void delete(final Integer id) {
		Role role = getRole(id);
		getHibernateTemplate().delete(role);
	}

	public Role getRole(final Integer id) {
		return this.getHibernateTemplate().load(Role.class, id);
	}

	public List<Role> queryByRole(final Role role, final PageBean pageBean) {
		List roleList = getHibernateTemplate().executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				StringBuffer hql = new StringBuffer("from Role where 1=1 ");
				if (role != null) {
					if (StringUtil.isNotEmpty(role.getRoleName())) {
						hql.append(" and roleName like '%" + role.getRoleName() + "%'");
					}
					if (role.getRoleMark2()!=null) {
						hql.append(" and roleMark2 ='" + role.getRoleMark2() + "' ");
					}
				}
				hql.append(" order by roleId");
				if (pageBean != null) {
					int rows = pageBean.getRows();
					int start = pageBean.getStart();
					Query query = session.createQuery(hql.toString());
					query.setFirstResult(start);
					query.setMaxResults(rows);
					List<Role> list = query.list();
					session.close();
					return list;
				}
				Query query = session.createQuery(hql.toString());
				List<Role> list = query.list();
				session.close();
				return list;
			}

		});

		return roleList;
	}

}
