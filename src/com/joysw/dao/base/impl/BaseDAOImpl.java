package com.joysw.dao.base.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.joysw.bean.sysdepartbean.SysDepartUserBean;
import com.joysw.core.page.Page;
import com.joysw.dao.base.BaseDAO;

/**
 * 数据库DAO公共类实现
 * 
 * @author liy
 * 
 */
public class BaseDAOImpl<T> extends HibernateDaoSupport implements BaseDAO<T> {

	protected final Log log = LogFactory.getLog(getClass());

	public void save(T domain) {
		try {
			log.debug("saving " + getClass().getName() + " instance");
			getHibernateTemplate().save(domain);
			log.debug("saving sucessfull" + getClass().getName() + " instance");
		} catch (RuntimeException re) {
			log.error("save failed ", re);
			throw re;
		}
	};

	public void saveOrUpdate(T domain) {
		try {
			log.debug("saveOrUpdating " + getClass().getName() + " instance");
			getHibernateTemplate().saveOrUpdate(domain);
			log.debug("saveOrUpdating sucessfull " + getClass().getName()
					+ " instance");
		} catch (RuntimeException re) {
			log.error("saveOrUpdating failed ", re);
			throw re;
		}
	};

	public void update(T domain) {
		try {
			log.debug("updating " + getClass().getName() + " instance");
			getHibernateTemplate().update(domain);
			log.debug("updating sucessfull " + getClass().getName()
					+ " instance");
		} catch (RuntimeException re) {
			log.error("updating failed ", re);
			throw re;
		}
	};

	@SuppressWarnings("unchecked")
	public T get(T domain, Integer id) {
		try {
			log.debug("getting " + getClass().getName() + " instance");
			T t = (T) getHibernateTemplate().get(domain.getClass(), id);
			log.debug("getting sucessfull " + getClass().getName()
					+ " instance");
			return t;
		} catch (RuntimeException re) {
			log.error("getting failed ", re);
			throw re;
		}
	};

	public void delete(T domain) {
		try {
			log.debug("deleting " + getClass().getName() + " instance");
			getHibernateTemplate().delete(domain);
			log.debug("deleting sucessfull " + getClass().getName()
					+ " instance");
		} catch (RuntimeException re) {
			log.error("deleting failed ", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> getListByHqlAndParas(String hql, List<Object> paras, Page page) {
		try {
			log.debug("getListByHqlAndParas " + getClass().getName() + " list");
			Query query = this.getSessionFactory().getCurrentSession()
					.createQuery(hql);
			if (paras != null && paras.size() > 0) {
				int i = 0;
				for (Object tempPara : paras) {
					query.setParameter(i++, tempPara);
				}
			}
			if (page != null) {
				query.setFirstResult((page.getNum() - 1) * page.getSize());
				query.setMaxResults(page.getSize());
			}
			log.debug("getListByHqlAndParas sucessfull " + getClass().getName()
					+ " list");
			return query.list();
		} catch (RuntimeException re) {
			log.debug("getListByHqlAndParas failed " + getClass().getName()
					+ " list");
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> getListByHqlAndParas(String hql, List<Object> paras) {
		try {
			log.debug("getListByHqlAndParas " + getClass().getName() + " list");
			Query query = this.getSessionFactory().getCurrentSession()
					.createQuery(hql);
			if (paras != null && paras.size() > 0) {
				int i = 0;
				for (Object tempPara : paras) {
					query.setParameter(i++, tempPara);
				}
			}
			log.debug("getListByHqlAndParas sucessfull " + getClass().getName()
					+ " list");
			return query.list();
		} catch (RuntimeException re) {
			log.debug("getListByHqlAndParas failed " + getClass().getName()
					+ " list");
			throw re;
		}
	}

	public Integer countListByHqlAndParas(String hql, List<Object> paras) {
		try {
			log.debug("countListByHqlAndParas " + getClass().getName());
			Query query = this.getSessionFactory().getCurrentSession()
					.createQuery(hql);
			if (paras != null && paras.size() > 0) {
				int i = 0;
				for (Object tempPara : paras) {
					query.setParameter(i++, tempPara);
				}
			}
			log.debug("countListByHqlAndParas sucessfull "
					+ getClass().getName());
			return Integer.parseInt(query.uniqueResult().toString());
		} catch (RuntimeException re) {
			log.debug("countListByHqlAndParas failed " + getClass().getName());
			throw re;
		}
	}

	public void delete(String hql) {
		try {
			log.debug("delete " + getClass().getName());
			this.getSessionFactory().getCurrentSession().createQuery(hql)
					.executeUpdate();
			log.debug("delete sucessfull " + getClass().getName());
		} catch (RuntimeException re) {
			log.debug("delete failed " + getClass().getName());
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<SysDepartUserBean> getListSysDepartUserBean(String hql) {
		try {
			log.debug("getListSysDepartUserBean " + getClass().getName()
					+ " list");
			Query query = this.getSessionFactory().getCurrentSession()
					.createQuery(hql);
			log.debug("getListSysDepartUserBean sucessfull "
					+ getClass().getName() + " list");
			return query.list();
		} catch (RuntimeException re) {
			log.debug("getListSysDepartUserBean failed " + getClass().getName()
					+ " list");
			throw re;
		}
	}
}
