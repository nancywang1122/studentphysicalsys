package com.joysw.dao.base;

import java.util.List;

import com.joysw.bean.sysdepartbean.SysDepartUserBean;
import com.joysw.core.page.Page;

/**
 * 操作数据底层类
 * 
 * @author liy
 * 
 * @param <T>
 */

public interface BaseDAO<T> {

	/**
	 * 保存数据
	 * 
	 * @param domain
	 */
	public abstract void save(T domain);

	/**
	 * 删除数据
	 * 
	 * @param domain
	 */
	public abstract void delete(T domain);

	public abstract void delete(String hql);

	/**
	 * 保存或修改数据
	 * 
	 * @param domain
	 */
	public abstract void saveOrUpdate(T domain);

	/**
	 * 修改数据
	 * 
	 * @param domain
	 */
	public abstract void update(T domain);

	/**
	 * 查询数据
	 * 
	 * @param domain
	 * @param id
	 * @return
	 */
	public abstract T get(T domain, Integer id);

	/**
	 * 分页查询 用HQL配合通配符等，进行条件分页｜排序查询
	 * 
	 * @param hql
	 *            hql语句
	 * @param paras
	 *            参数
	 * */
	public abstract List<T> getListByHqlAndParas(String hql, List<Object> paras);

	/**
	 * 分页查询 用HQL配合通配符等，进行条件分页｜排序查询
	 * 
	 * @param hql
	 *            hql语句
	 * @param paras
	 *            参数
	 * @param page
	 *            分页工具类:1->如果page不为null则是分页查询;　2->如果为NULL则全部查询出来
	 * */
	public abstract List<T> getListByHqlAndParas(String hql, List<Object> paras,
			Page page);

	/**
	 * 统计总行数 用HQL配合通配符等，进行条件统计列表的总行数．
	 * 
	 * @param hql
	 *            对象语句
	 * @param paras
	 *            参数
	 * @return
	 */
	public abstract Integer countListByHqlAndParas(String hql, List<Object> paras);

	public abstract List<SysDepartUserBean> getListSysDepartUserBean(String hql);

}
