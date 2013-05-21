package com.joysw.action.sysusermg;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.joysw.action.base.BaseAction;
import com.joysw.bean.sysdepartbean.SysDepartUserBean;
import com.joysw.bean.sysdepartbean.SysDepartmentBean;
import com.joysw.bean.sysuserbean.SysRoleUserBean;
import com.joysw.bean.sysuserbean.SysUserBean;
import com.joysw.bean.sysuserbean.ViewSysUserBean;
import com.joysw.core.page.Page;
import com.joysw.core.utils.MD5Util;
import com.joysw.core.utils.StringEmpty;
import com.joysw.service.base.BaseService;
import com.joysw.service.sysusermg.SysUserService;

public class SysUserMgAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SysUserBean sysUserBean;
	private ViewSysUserBean viewSysUserBean;
	private SysUserService sysUserServiceImpl;
	private BaseService<SysUserBean> baseServiceSysUserImpl;
	private BaseService<SysDepartUserBean> baseServiceSysDepartUserImpl;
	private BaseService<SysDepartmentBean> baseServiceSysDepartImpl;
	private BaseService<SysRoleUserBean> baseServiceSysRoleUserImpl;
	private JSONArray resultArray;
	private JSONObject resultObj;

	public BaseService<SysDepartmentBean> getBaseServiceSysDepartImpl() {
		return baseServiceSysDepartImpl;
	}

	public void setBaseServiceSysDepartImpl(
			BaseService<SysDepartmentBean> baseServiceSysDepartImpl) {
		this.baseServiceSysDepartImpl = baseServiceSysDepartImpl;
	}

	public BaseService<SysDepartUserBean> getBaseServiceSysDepartUserImpl() {
		return baseServiceSysDepartUserImpl;
	}

	public void setBaseServiceSysDepartUserImpl(
			BaseService<SysDepartUserBean> baseServiceSysDepartUserImpl) {
		this.baseServiceSysDepartUserImpl = baseServiceSysDepartUserImpl;
	}

	public BaseService<SysRoleUserBean> getBaseServiceSysRoleUserImpl() {
		return baseServiceSysRoleUserImpl;
	}

	public void setBaseServiceSysRoleUserImpl(
			BaseService<SysRoleUserBean> baseServiceSysRoleUserImpl) {
		this.baseServiceSysRoleUserImpl = baseServiceSysRoleUserImpl;
	}

	public ViewSysUserBean getViewSysUserBean() {
		return viewSysUserBean;
	}

	public void setViewSysUserBean(ViewSysUserBean viewSysUserBean) {
		this.viewSysUserBean = viewSysUserBean;
	}

	public BaseService<SysUserBean> getBaseServiceSysUserImpl() {
		return baseServiceSysUserImpl;
	}

	public void setBaseServiceSysUserImpl(
			BaseService<SysUserBean> baseServiceSysUserImpl) {
		this.baseServiceSysUserImpl = baseServiceSysUserImpl;
	}

	public JSONArray getResultArray() {
		return resultArray;
	}

	public void setResultArray(JSONArray resultArray) {
		this.resultArray = resultArray;
	}

	public JSONObject getResultObj() {
		return resultObj;
	}

	public void setResultObj(JSONObject resultObj) {
		this.resultObj = resultObj;
	}

	public SysUserBean getSysUserBean() {
		return sysUserBean;
	}

	public void setSysUserBean(SysUserBean sysUserBean) {
		this.sysUserBean = sysUserBean;
	}

	public SysUserService getSysUserServiceImpl() {
		return sysUserServiceImpl;
	}

	public void setSysUserServiceImpl(SysUserService sysUserServiceImpl) {
		this.sysUserServiceImpl = sysUserServiceImpl;
	}

	public String loadSysUserBean() {
		return SUCCESS;
	}

	public String toAddSysUserBean() {
		return SUCCESS;
	}

	public String checkUserName() {
		String userName = this.getRequest().getParameter("userName");
		if(userName==null){
			userName="";
		}
		userName = userName.trim();
		System.out.println(userName);
		ViewSysUserBean view = this.sysUserServiceImpl
				.getViewSysUserBean(userName);
		if (view != null) {
			this.outString("false");
		} else {
			this.outString("true");
		}
		return null;
	}

	public String toUpdateSysUserBean() {
		this.sysUserBean = this.baseServiceSysUserImpl.get(sysUserBean,
				sysUserBean.getUserId());
		SysDepartUserBean sysDepart = this.sysUserServiceImpl
				.getSysDepartUserBean(sysUserBean.getUserId());
		sysUserBean.setUserDepartId(sysDepart.getDepartId());
		SysRoleUserBean sysRole = this.sysUserServiceImpl
				.getSysRoleUserBean(sysUserBean.getUserId());
		sysUserBean.setUserRoleId(sysRole.getRoleId());
		return SUCCESS;
	}

	public String addSysUserBean() {
		sysUserBean.setUserPassword(MD5Util.MD5(sysUserBean.getUserPassword()));
		if ("1".equals(sysUserBean.getSuperuserFlag()+"")) {
			sysUserBean.setUserSysFlag(true);
			sysUserBean.setUserStaff(false);
		} else {
			sysUserBean.setUserSysFlag(false);
			sysUserBean.setUserStaff(true);
		}
		sysUserBean.setUserActivity(true);
		sysUserBean.setUserLoginTime(new Date());
		sysUserBean.setUserDateJoined(new Date());

		SysDepartmentBean sysDepartmentBean = baseServiceSysDepartImpl.get(
				new SysDepartmentBean(), sysUserBean.getUserDepartId());
		sysUserBean.setUserDepartCode(sysDepartmentBean.getDepartCode());
		this.baseServiceSysUserImpl.save(sysUserBean);
		SysDepartUserBean sysDepartUser = new SysDepartUserBean();
		sysDepartUser.setDepartId(sysUserBean.getUserDepartId());
		sysDepartUser.setUserId(sysUserBean.getUserId());
		this.baseServiceSysDepartUserImpl.save(sysDepartUser);

		SysRoleUserBean sysRoleUser = new SysRoleUserBean();
		sysRoleUser.setRoleId(sysUserBean.getUserRoleId());
		sysRoleUser.setUserId(sysUserBean.getUserId());
		this.baseServiceSysRoleUserImpl.save(sysRoleUser);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("info", "操作成功!");
		return this.outJSONArray(map);
	}

	public String updateSysUserBean() {
		SysDepartmentBean sysDepartmentBean = baseServiceSysDepartImpl.get(
				new SysDepartmentBean(), sysUserBean.getUserDepartId());
		sysUserBean.setUserDepartCode(sysDepartmentBean.getDepartCode());

		SysUserBean temp = this.baseServiceSysUserImpl.get(new SysUserBean(),
				sysUserBean.getUserId());
		if (!StringEmpty.checkEmpty(sysUserBean.getUserPassword())) {
			temp.setUserPassword(MD5Util.MD5(sysUserBean.getUserPassword()));
		}
		temp.setUserName(sysUserBean.getUserName());
		temp.setSuperuserFlag(sysUserBean.getSuperuserFlag());
		temp.setUserFirstName(sysUserBean.getUserFirstName());
		temp.setUserLastName(sysUserBean.getUserLastName());
		temp.setUserEmail(sysUserBean.getUserEmail());
		temp.setUserDepartCode(sysUserBean.getUserDepartCode());
		if ("1".equals(sysUserBean.getSuperuserFlag()+"")) {
			temp.setUserSysFlag(true);
			temp.setUserStaff(false);
		} else {
			temp.setUserSysFlag(false);
			temp.setUserStaff(true);
		}
		this.baseServiceSysUserImpl.update(temp);
		SysDepartUserBean sysDepartUser = new SysDepartUserBean();
		this.sysUserServiceImpl
				.deleteSysDepartUserBean(sysUserBean.getUserId());
		sysDepartUser.setUserId(sysUserBean.getUserId());
		sysDepartUser.setDepartId(sysUserBean.getUserDepartId());
		this.baseServiceSysDepartUserImpl.save(sysDepartUser);

		SysRoleUserBean sysRoleUser = new SysRoleUserBean();
		this.sysUserServiceImpl.deleteSysRoleUserBean(sysUserBean.getUserId());

		sysRoleUser.setUserId(sysUserBean.getUserId());
		sysRoleUser.setRoleId(sysUserBean.getUserRoleId());
		this.baseServiceSysRoleUserImpl.save(sysRoleUser);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("info", "操作成功!");
		return this.outJSONArray(map);
	}

	public String updateSysUserBeanActive() {
		SysUserBean temp = this.baseServiceSysUserImpl.get(new SysUserBean(),
				sysUserBean.getUserId());
		if (sysUserBean.getUserActivityFlag().equals("1")) {
			temp.setUserActivity(true);
		} else if (sysUserBean.getUserActivityFlag().equals("0")) {
			temp.setUserActivity(false);
		}
		this.baseServiceSysUserImpl.update(temp);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("info", "操作成功!");
		resultObj = JSONObject.fromObject(map); // 将map对象转换成为json对象
		return SUCCESS;
	}
	
	public String deleteSysUserBean() {
		Map<String, Object> map = new HashMap<String, Object>();
		if(sysUserBean==null||sysUserBean.getUserId()==null){
			map.put("info", "操作失败!");
		}else{
			this.sysUserServiceImpl.deleteSysDepartUserBean(sysUserBean.getUserId());
			this.sysUserServiceImpl.deleteSysRoleUserBean(sysUserBean.getUserId());
			this.sysUserServiceImpl.deleteSysUserBean(sysUserBean.getUserId());
			map.put("info", "操作成功!");
		}
		return this.outJSONArray(map);
	}

	@SuppressWarnings("unchecked")
	public String listSysUserBeans() {
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
		if (viewSysUserBean == null) {
			viewSysUserBean = new ViewSysUserBean();
		}
		viewSysUserBean.setUserDepartCode(this.getSessionSysUserBean()
				.getUserDepartCode());
		Object[] result = this.sysUserServiceImpl.getSysUserBeansList(
				viewSysUserBean, page);
		List<SysUserBean> sysUserBeanList = (List<SysUserBean>) result[0];
		page = (Page) result[1];
		Map map = new HashMap();
		map.put("total", page.getRowCount());
		map.put("rows", sysUserBeanList);
		resultObj = JSONObject.fromObject(map); // 将map对象转换成为json对象
		System.out.println(resultObj);
		return SUCCESS;
	}
}
