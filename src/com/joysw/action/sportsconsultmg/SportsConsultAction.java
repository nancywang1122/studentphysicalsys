package com.joysw.action.sportsconsultmg;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.joysw.action.base.BaseAction;
import com.joysw.bean.sportsconsultbean.SportsConsultBean;
import com.joysw.bean.sysuserbean.SysUserBean;
import com.joysw.core.page.Page;
import com.joysw.core.utils.FinalApplication;
import com.joysw.service.sportsconsultmg.SportsConsultService;
import com.opensymphony.xwork2.ActionContext;

public class SportsConsultAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SportsConsultBean sportsConsultBean;
	private SportsConsultService sportsConsultServiceImpl;
	private JSONObject resultObj;
	private JSONArray resultArray;

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

	public SportsConsultBean getSportsConsultBean() {
		return sportsConsultBean;
	}

	public void setSportsConsultBean(SportsConsultBean sportsConsultBean) {
		this.sportsConsultBean = sportsConsultBean;
	}

	public SportsConsultService getSportsConsultServiceImpl() {
		return sportsConsultServiceImpl;
	}

	public void setSportsConsultServiceImpl(
			SportsConsultService sportsConsultServiceImpl) {
		this.sportsConsultServiceImpl = sportsConsultServiceImpl;
	}

	public String toAddSportsConsultBean() {

		return INPUT;

	}

	/*
	 * 增加一条咨询信息
	 */
	public String addSportsConsultBean() {
		
		if(this.getSessionSysUserBean()==null){
			return INPUT;
		}
		
		ActionContext ctx = ActionContext.getContext();
		Map session = ctx.getSession();
		SysUserBean loginUser = (SysUserBean) session
				.get(FinalApplication.LOGIN_USER);
		
		SportsConsultBean newSportsConsultBean = new SportsConsultBean();

		newSportsConsultBean.setSportsType(sportsConsultBean.getSportsType());
		newSportsConsultBean.setSportsConsultTitle(sportsConsultBean
				.getSportsConsultTitle());
		newSportsConsultBean.setSportsConsultContent(sportsConsultBean
				.getSportsConsultContent());
		newSportsConsultBean.setSportsConsultCreatedTime(new Date());
		newSportsConsultBean.setSportsConsultUpdatedTime(new Date());
		
		if(loginUser!=null){
			String username=loginUser.getUserName();
			Integer userId=loginUser.getUserId();
			newSportsConsultBean.setSportsConsultCreatedBy(userId);
			newSportsConsultBean.setSportsConsultUpdatedBy(userId);
			newSportsConsultBean.setSportsConsultCreatedByName(username);
			newSportsConsultBean.setSportsConsultUpdatedByName(username);
		}
	
		this.sportsConsultServiceImpl.save(newSportsConsultBean);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "1");
		map.put("info", "发布咨询成功!");
		return this.outJSONArray(map);
		
	}

	@SuppressWarnings("unchecked")
	public String listSportConsultBeans() {
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

		Object[] result = this.sportsConsultServiceImpl
				.getSportConsultBeansList(sportsConsultBean, page);
		List<SportsConsultBean> sportConsultBeanlist = (List<SportsConsultBean>) result[0];
		page = (Page) result[1];
		Map map = new HashMap();
		map.put("total", page.getRowCount());
		map.put("rows", sportConsultBeanlist);
		resultObj = JSONObject.fromObject(map); // 将map对象转换成为json对象
		ActionContext.getContext().put("page", page);
		ActionContext.getContext().put("sportConsultBeanlist",
				sportConsultBeanlist);
		return SUCCESS;
	}

	public String displaySportsConsult() {
		return SUCCESS;
	}
}
