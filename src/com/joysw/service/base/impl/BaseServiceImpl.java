package com.joysw.service.base.impl;

import com.joysw.dao.base.BaseDAO;
import com.joysw.service.base.BaseService;

public class BaseServiceImpl<T> implements BaseService<T> {

	private BaseDAO<T> baseDAOImpl;

	public BaseDAO<T> getBaseDAOImpl() {
		return baseDAOImpl;
	}

	public void setBaseDAOImpl(BaseDAO<T> baseDAOImpl) {
		this.baseDAOImpl = baseDAOImpl;
	}

	public void delete(T domain) {
		this.baseDAOImpl.delete(domain);
	}

	public void save(T domain) {
		System.out.println("********"+baseDAOImpl+"*********");
		this.baseDAOImpl.save(domain);
	}

	public void saveOrUpdate(T domain) {
		this.baseDAOImpl.saveOrUpdate(domain);
	}

	public void update(T domain) {
		this.baseDAOImpl.update(domain);
	}

	public T get(T domain, Integer id) {
		return this.baseDAOImpl.get(domain, id);
	}
}