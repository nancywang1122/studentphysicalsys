package com.joysw.action.studentmg;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.joysw.action.base.BaseAction;
import com.joysw.bean.studentbean.StudentBean;
import com.joysw.core.page.Page;
import com.joysw.service.studentmg.StudentMgServce;

public class StudentMgAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JSONObject resultObj;
	private JSONArray resultArray;
	private StudentMgServce studentMgServceImpl;
	private StudentBean studentBean;

	public StudentBean getStudentBean() {
		return studentBean;
	}

	public void setStudentBean(StudentBean studentBean) {
		this.studentBean = studentBean;
	}

	public JSONObject getResultObj() {
		return resultObj;
	}

	public void setResultObj(JSONObject resultObj) {
		this.resultObj = resultObj;
	}

	public JSONArray getResultArray() {
		return resultArray;
	}

	public void setResultArray(JSONArray resultArray) {
		this.resultArray = resultArray;
	}

	public StudentMgServce getStudentMgServceImpl() {
		return studentMgServceImpl;
	}

	public void setStudentMgServceImpl(StudentMgServce studentMgServceImpl) {
		this.studentMgServceImpl = studentMgServceImpl;
	}

	@SuppressWarnings("unchecked")
	public String listStudentBeans() {
		this.getResponse().setContentType("text/json;charset=UTF-8");
		this.getResponse().setCharacterEncoding("UTF-8");
		String pageStr = this.getRequest().getParameter("page");
		String rowsStr = this.getRequest().getParameter("rows");
		Integer pageIndex = 1;
		if (pageStr != null && !pageStr.equals("null")) {
			pageIndex = new Integer(pageStr);
		}
		Integer pageSize = 10;
		if (rowsStr != null && !rowsStr.equals("null")) {
			pageSize = new Integer(rowsStr);
		}
		Page page = new Page();
		page.setSize(pageSize);
		page.setNum(pageIndex);
		/*
		 * Object[] result = this.museDBMgServiceImpl.getMuseBackUpBeansList(
		 * new MuseBackUpBean(), page); List<MuseBackUpBean> museBackUpBeanList
		 * = (List<MuseBackUpBean>) result[0]; page = (Page) result[1]; Map map
		 * = new HashMap(); map.put("total", page.getRowCount());
		 * map.put("rows", museBackUpBeanList); resultObj =
		 * JSONObject.fromObject(map); // 将map对象转换成为json对象
		 * System.out.println(resultObj);
		 */
		return SUCCESS;
	}

	/**
	 * 通过id，获取学生信息
	 * 
	 * @return
	 */
	public String getStudentBeanById() {
		if(this.getSessionSysUserBean()==null){
			return INPUT;
		}
		studentBean = new StudentBean();
		studentBean.setStuUserId(this.getSessionSysUserBean().getUserId());
		studentBean = studentMgServceImpl.getStudentBeanById(studentBean);
		return SUCCESS;
	}
	
	public String load() {
		return SUCCESS;
	}
}
