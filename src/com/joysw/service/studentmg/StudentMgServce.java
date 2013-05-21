package com.joysw.service.studentmg;

import com.joysw.bean.studentbean.StudentBean;
import com.joysw.core.page.Page;
import com.joysw.service.base.BaseService;

public interface StudentMgServce extends BaseService<StudentBean> {

	/**
	 * 获取学生信息
	 * @param studentBean
	 * @param page
	 * @return
	 */
	public Object[] getStudentBeanList(StudentBean studentBean, Page page);
	/**
	 * 通过Id获取学生信息
	 * @param studentBean
	 * @return
	 */
	public StudentBean getStudentBeanById(StudentBean studentBean);
}
