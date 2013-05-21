package com.joysw.service.studentmg.impl;

import java.util.ArrayList;
import java.util.List;

import com.joysw.bean.studentbean.StudentBean;
import com.joysw.core.page.Page;
import com.joysw.core.utils.StringEmpty;
import com.joysw.dao.base.BaseDAO;
import com.joysw.service.base.impl.BaseServiceImpl;
import com.joysw.service.studentmg.StudentMgServce;

public class StudentMgServceImpl extends BaseServiceImpl<StudentBean> implements
		StudentMgServce {
	private BaseDAO<StudentBean> baseStudentDAOImpl;

	public BaseDAO<StudentBean> getBaseStudentDAOImpl() {
		return baseStudentDAOImpl;
	}

	public void setBaseStudentDAOImpl(BaseDAO<StudentBean> baseStudentDAOImpl) {
		this.baseStudentDAOImpl = baseStudentDAOImpl;
	}

	public Object[] getStudentBeanList(StudentBean studentBean, Page page) {
		StringBuffer hql = new StringBuffer();
		StringBuffer hqlCount = new StringBuffer();
		hql.append("from StudentBean where 1=1 ");
		hqlCount.append("select count(*) from StudentBean where 1=1 ");
		List<Object> params = new ArrayList<Object>();
		if (studentBean != null) {
			if (!StringEmpty.checkEmpty(studentBean.getStuName())) {
				hql.append(" and stuName like ? ");
				hqlCount.append("and stuName like ? ");
				params.add("%" + studentBean.getStuName().trim() + "%");
			}
		}
		hql.append(" order by stuNo desc");
		int rowCount = this.baseStudentDAOImpl.countListByHqlAndParas(
				hqlCount.toString(), params);
		if (page == null) {
			page = new Page(10, 1, rowCount);
		} else {
			page = new Page(page.getSize(), page.getNum(), rowCount);
		}
		return new Object[] {
				this.baseStudentDAOImpl.getListByHqlAndParas(hql.toString(),
						params, page), page };
	}

	/*
	 * 通过Id获取学生信息 (non-Javadoc)
	 * 
	 * @see
	 * com.joysw.service.studentmg.StudentMgServce#getStudentBeanById(com.joysw
	 * .bean.studentbean.StudentBean)
	 */
	public StudentBean getStudentBeanById(StudentBean studentBean) {
		String sql = "from StudentBean where stuUserId ='"
				+ studentBean.getStuUserId() + "'";
		List<StudentBean> list = baseStudentDAOImpl.getListByHqlAndParas(sql,
				null);
		if (list != null && list.size() > 0) {
			return baseStudentDAOImpl.get(studentBean, list.get(0).getStuId());
		} else {
			return null;
		}
	}
}
