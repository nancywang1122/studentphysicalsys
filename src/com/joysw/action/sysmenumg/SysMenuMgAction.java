package com.joysw.action.sysmenumg;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.joysw.action.base.BaseAction;
import com.joysw.bean.sysmenubean.SysMenuBean;
import com.joysw.core.page.Page;
import com.joysw.core.utils.StringEmpty;
import com.joysw.service.base.BaseService;
import com.joysw.service.sysmenumg.SysMenuMgService;
import com.opensymphony.xwork2.ActionContext;

public class SysMenuMgAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JSONObject resultObj;
	private SysMenuMgService sysMenuMgServiceImpl;
	private BaseService<SysMenuBean> baseServiceImpl;
	private SysMenuBean sysMenuBean;

	public BaseService<SysMenuBean> getBaseServiceImpl() {
		return baseServiceImpl;
	}

	public void setBaseServiceImpl(BaseService<SysMenuBean> baseServiceImpl) {
		this.baseServiceImpl = baseServiceImpl;
	}

	public SysMenuBean getSysMenuBean() {
		return sysMenuBean;
	}

	public void setSysMenuBean(SysMenuBean sysMenuBean) {
		this.sysMenuBean = sysMenuBean;
	}

	public SysMenuMgService getSysMenuMgServiceImpl() {
		return sysMenuMgServiceImpl;
	}

	public void setSysMenuMgServiceImpl(SysMenuMgService sysMenuMgServiceImpl) {
		this.sysMenuMgServiceImpl = sysMenuMgServiceImpl;
	}

	public JSONObject getResultObj() {
		return resultObj;
	}

	public void setResultObj(JSONObject resultObj) {
		this.resultObj = resultObj;
	}

	public String listParentSysMenus() {
		List<SysMenuBean> parentMenuBeanList = this.sysMenuMgServiceImpl
				.getParentSysMenuBeans(this.getSessionSysUserBean());
		ActionContext.getContext()
				.put("parentMenuBeanList", parentMenuBeanList);
		return SUCCESS;
	}

	public String addSysMenuBean() {
		if (sysMenuBean == null) {
			sysMenuBean = new SysMenuBean();
			sysMenuBean.setMenuParentId(1);
		} else {
			sysMenuBean.setMenuParentId(sysMenuBean.getMenuId());
		}
		// sysMenuBean.setMenuId(new Date().getTime());
		sysMenuBean.setMenuCreatedBy(this.getSessionSysUserBean().getUserId());
		sysMenuBean.setMenuCreatedTime(new Date());
		this.baseServiceImpl.save(sysMenuBean);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("info", "操作成功!");
		resultObj = JSONObject.fromObject(map); // 将map对象转换成为json对象
		return SUCCESS;
	}

	public String updateSysMenuBean() throws UnsupportedEncodingException {
		Map<String, Object> map = new HashMap<String, Object>();
		if (sysMenuBean == null) {
			map.put("info", "操作失败!");
		} else {
			sysMenuBean.setMenuName(URLDecoder.decode(
					sysMenuBean.getMenuName(), "UTF-8"));
			sysMenuBean.setMenuUpdatedBy(this.getSessionSysUserBean()
					.getUserId());
			sysMenuBean.setMenuUpdatedTime(new Date());
			this.baseServiceImpl.update(sysMenuBean);
			map.put("info", "操作成功!");
		}
		resultObj = JSONObject.fromObject(map); // 将map对象转换成为json对象
		return SUCCESS;
	}

	public String updateSysMenuBeanFlag() {
		Map<String, Object> map = new HashMap<String, Object>();
		String menuId = this.getRequest().getParameter("menuId");
		String menuActiveFlag = this.getRequest()
				.getParameter("menuActiveFlag");

		if (StringEmpty.checkEmpty(menuId)) {
			map.put("info", "操作失败!");
			resultObj = JSONObject.fromObject(map); // 将map对象转换成为json对象
			return SUCCESS;
		}
		if (StringEmpty.checkEmpty(menuActiveFlag)) {
			map.put("info", "操作失败!");
			resultObj = JSONObject.fromObject(map); // 将map对象转换成为json对象
			return SUCCESS;
		}
		sysMenuBean = new SysMenuBean();
		sysMenuBean.setMenuId(new Integer(menuId));
		sysMenuBean = this.baseServiceImpl.get(sysMenuBean,
				sysMenuBean.getMenuId());
		if (sysMenuBean == null) {
			map.put("info", "操作失败!");
		} else {
			sysMenuBean.setMenuActiveFlag(menuActiveFlag);
			this.baseServiceImpl.update(sysMenuBean);
			map.put("info", "操作成功!");
		}
		resultObj = JSONObject.fromObject(map); // 将map对象转换成为json对象
		return SUCCESS;
	}

	public String listLoopChildSysMenus(List<SysMenuBean> childMenuBeanList) {
		String strJson = "[";
		for (SysMenuBean temp : childMenuBeanList) {
			sysMenuBean = new SysMenuBean();
			sysMenuBean.setMenuId(temp.getMenuId());
			sysMenuBean.setMenuCreatedBy(this.getSessionSysUserBean()
					.getUserId());
			List<SysMenuBean> childMenuBeanListSub = this.sysMenuMgServiceImpl
					.getSysMenuBeansByParam(sysMenuBean);
			strJson += "{'id':'" + temp.getMenuId() + "','text':'"
					+ temp.getMenuName() + "','attributes':{'url':'"
					+ temp.getMenuUrl() + "'}";
			if (childMenuBeanListSub != null && childMenuBeanListSub.size() > 0) {
				strJson += ",'state':'closed','children':"
						+ listLoopChildSysMenus(childMenuBeanListSub) + "}";
			} else {
				strJson += "}";
			}
			strJson += ",";
		}
		strJson = strJson.substring(0, strJson.length() - 1);
		strJson += "]";
		return strJson;
	}

	public String listLoopFlagSysMenus(List<SysMenuBean> childMenuBeanList) {
		String strJson = "";
		for (SysMenuBean temp : childMenuBeanList) {
			sysMenuBean = new SysMenuBean();
			sysMenuBean.setMenuId(temp.getMenuId());
			List<SysMenuBean> childMenuBeanListSub = this.sysMenuMgServiceImpl
					.getSysMenuBeans(sysMenuBean);
			strJson += temp.getMenuId() + ",";
			if (childMenuBeanListSub != null && childMenuBeanListSub.size() > 0) {
				strJson += listLoopFlagSysMenus(childMenuBeanListSub);
			}
		}
		return strJson;// 1,2,1,2,
	}

	public String listChildSysMenus() {
		if (sysMenuBean == null) {
			sysMenuBean = new SysMenuBean();
		}
		sysMenuBean.setMenuCreatedBy(this.getSessionSysUserBean().getUserId());
		List<SysMenuBean> childMenuBeanList = this.sysMenuMgServiceImpl
				.getSysMenuBeansByParam(sysMenuBean);
		return this.outJSONString(listLoopChildSysMenus(childMenuBeanList));
	}

	@SuppressWarnings("unchecked")
	public List listLoopModuleSysMenus(List<SysMenuBean> sysMenuBeanList) {
		ArrayList list = new ArrayList();
		for (SysMenuBean sysMenuPojo : sysMenuBeanList) {
			Map m = new HashMap();
			m.put("menuId", ((sysMenuPojo.getMenuId() == null) ? ""
					: sysMenuPojo.getMenuId()));
			m.put("menuName",
					((sysMenuPojo.getMenuName() == null) ? "" : this
							.getText(sysMenuPojo.getMenuName())));
			m.put("menuURL", ((sysMenuPojo.getMenuUrl() == null) ? ""
					: sysMenuPojo.getMenuUrl()));
			m.put("menuParentName", (sysMenuPojo.getMenuParentBean()
					.getMenuName() == null ? "" : sysMenuPojo
					.getMenuParentBean().getMenuName()));
			m.put("menuParentId", sysMenuPojo.getMenuParentId());
			m.put("menuURL", ((sysMenuPojo.getMenuUrl() == null) ? ""
					: sysMenuPojo.getMenuUrl()));
			m.put("menuCreatedTime",
					(sysMenuPojo.getStrMenuCreatedTime() == null ? ""
							: sysMenuPojo.getStrMenuCreatedTime()));
			m.put("menuUpdatedTime",
					(sysMenuPojo.getStrMenuUpdatedTime() == null) ? ""
							: sysMenuPojo.getStrMenuUpdatedTime());
			m.put("menuOrder", ((sysMenuPojo.getMenuOrder() == null) ? ""
					: sysMenuPojo.getMenuOrder()));
			m.put("menuActiveFlag",
					((sysMenuPojo.getMenuActiveFlag() == null) ? "0"
							: sysMenuPojo.getMenuActiveFlag()));
			sysMenuBean = new SysMenuBean();
			sysMenuBean.setMenuId(sysMenuPojo.getMenuId());
			List<SysMenuBean> childMenuBeanListSub = this.sysMenuMgServiceImpl
					.getSysMenuBeans(sysMenuBean);
			if (childMenuBeanListSub != null && childMenuBeanListSub.size() > 0) {
				m.put("state", "closed");
				List sublist = this
						.listLoopModuleSysMenus(childMenuBeanListSub);
				m.put("children", sublist);
			}
			list.add(m);
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public String listSysMenuModules() {
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
		Object[] result = this.sysMenuMgServiceImpl.getSysMenuBeansList(
				sysMenuBean, page);
		List<SysMenuBean> sysMenuBeanList = (List<SysMenuBean>) result[0];
		page = (Page) result[1];
		Map map = new HashMap();
		List list = this.listLoopModuleSysMenus(sysMenuBeanList);
		map.put("total", page.getRowCount());
		map.put("rows", list);
		resultObj = JSONObject.fromObject(map); // 将map对象转换成为json对象
		System.out.println(resultObj);
		return SUCCESS;
	}

	public String loadSysMenuModules() {
		return SUCCESS;
	}

	public String listSysMenuBeans() {
		List<SysMenuBean> parentMenuBeanListTemp = this.sysMenuMgServiceImpl
				.getSysMenuBeansIds();
		List<SysMenuBean> parentMenuBeanList = new ArrayList<SysMenuBean>();
		SysMenuBean sysMenu = null;
		for (SysMenuBean temp : parentMenuBeanListTemp) {
			sysMenu = new SysMenuBean();
			sysMenu.setMenuId(temp.getMenuId());
			sysMenu.setMenuName(temp.getMenuName());
			parentMenuBeanList.add(sysMenu);
		}
		this.getResponse().setContentType("text/html;charset=utf-8");
		this.getResponse().setCharacterEncoding("UTF-8");
		PrintWriter out;
		try {
			out = this.getResponse().getWriter();
			out.println(JSONArray.fromObject(parentMenuBeanList).toString());
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取前台功能菜单
	 * 
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String loadFrontMenuList() {
		List<SysMenuBean> listSysMenuBeans = this.sysMenuMgServiceImpl
				.getFrontMenuBeans(1);
		List listTemp = new ArrayList();
		String li = "";
		if (listSysMenuBeans != null) {
			for (SysMenuBean temp : listSysMenuBeans) {
				Map m = new HashMap();
				li += "<li><a href='"
						+ (temp.getMenuUrl() == null ? '#' : temp.getMenuUrl())
						+ "' class='parent'><span>" + temp.getMenuName()
						+ "</span></a>";
				List<SysMenuBean> listSubSysMenuBeans = this.sysMenuMgServiceImpl
						.getFrontChildMenuBeans(temp.getMenuId() + "");
				if (listSubSysMenuBeans != null) {
					li += "<div><ul>";
					for (SysMenuBean temp2 : listSubSysMenuBeans) {
						li += "<li><a href='"
								+ (temp2.getMenuUrl() == null ? '#' : temp2
										.getMenuUrl()) + "'><span>"
								+ temp2.getMenuName() + "</span></a></li>";
					}
					li += " </ul></div>";
				}
				li += "</li>";
				m.put("li", li);
				listTemp.add(m);
			}
		}
		/*
		 * if (listSysMenuBeans != null) { for (SysMenuBean temp :
		 * listSysMenuBeans) { Map m = new HashMap(); m.put("menuId",
		 * temp.getMenuId() + ""); m.put("menuName", temp.getMenuName());
		 * m.put("menuURL", temp.getMenuUrl()); listTemp.add(m); } }
		 */
		System.out.println(listTemp);
		return this.outJSONString(li);
	}

	/**
	 * public String loadFrontMenuList() { List<SysMenuBean> listSysMenuBeans =
	 * this.sysMenuMgServiceImpl .getFrontMenuBeans(1); List listTemp = new
	 * ArrayList(); String li = ""; if (listSysMenuBeans != null) { for
	 * (SysMenuBean temp : listSysMenuBeans) { Map m = new HashMap(); li += "<li class='one'>
	 * <a href='" + (temp.getMenuUrl() == null ? '#' : temp.getMenuUrl()) + "'>"
	 * + temp.getMenuName() + "</a>"; List<SysMenuBean> listSubSysMenuBeans =
	 * this.sysMenuMgServiceImpl .getFrontChildMenuBeans(temp.getMenuId() + "");
	 * if (listSubSysMenuBeans != null) { li += "
	 * <ul>
	 * "; for (SysMenuBean temp2 : listSubSysMenuBeans) { li += "
	 * <li><a href='" + (temp2.getMenuUrl() == null ? '#' : temp2 .getMenuUrl())
	 * + "'>" + temp2.getMenuName() + "</a></li>"; } li += "
	 * </ul>
	 * "; } li += "</li>"; m.put("li", li); listTemp.add(m); } }
	 * System.out.println(listTemp); return this.outJSONString(li); }
	 */

	/**
	 * 获取前台父集功能菜单
	 * 
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String loadFrontParentMenuList() {
		List<SysMenuBean> listSysMenuBeans = this.sysMenuMgServiceImpl
				.getFrontMenuBeans(1);
		List listTemp = new ArrayList();
		String li = "";
		if (listSysMenuBeans != null) {
			for (SysMenuBean temp : listSysMenuBeans) {
				Map m = new HashMap();
				li += "<li id='bottom_none'><a href='#' onclick='DoMenu('"+ temp.getMenuId() + "')'>";

				List<SysMenuBean> listSubSysMenuBeans = this.sysMenuMgServiceImpl
						.getFrontChildMenuBeans(temp.getMenuId() + "");
				if (listSubSysMenuBeans != null) {
					li += "<ul id='" + temp.getMenuId() + "' class='collapsed'>";
					for (SysMenuBean temp2 : listSubSysMenuBeans) {
						li += "<li><a href='"
								+ (temp2.getMenuUrl() == null ? '#' : temp2
										.getMenuUrl()) + "'>"
								+ temp2.getMenuName() + "</a></li>";
					}
					li += " </ul>";
				}
				li += "</li>";
				m.put("li", li);
				listTemp.add(m);
			}
		}
		System.out.println(listTemp);
		return this.outJSONString(li);
	}

	/**
	 * 获取前台子集功能菜单
	 * 
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String loadFrontChildMenuList() {
		String menuId = this.getRequest().getParameter("menuId");
		List<SysMenuBean> listSysMenuBeans = this.sysMenuMgServiceImpl
				.getFrontChildMenuBeans(menuId);
		List listTemp = new ArrayList();
		if (listSysMenuBeans != null) {
			for (SysMenuBean temp : listSysMenuBeans) {
				Map m = new HashMap();
				m.put("menuId", temp.getMenuId() + "");
				m.put("menuName", temp.getMenuName());
				m.put("menuURL", temp.getMenuUrl());
				listTemp.add(m);
			}
		}
		System.out.println(listTemp);
		return this.outJSONArrayList(listTemp);
	}
}
