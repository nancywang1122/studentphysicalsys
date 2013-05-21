package com.joysw.service.base;

public interface BaseService<T> {

	public abstract void save(T domain);

	public abstract void delete(T domain);

	public abstract void saveOrUpdate(T domain);

	public abstract void update(T domain);

	public abstract T get(T domain, Integer id);

}
