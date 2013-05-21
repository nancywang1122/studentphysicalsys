package com.joysw.action.sysrolemenumg;

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
import com.joysw.bean.sysdepartbean.SysDepartUserBean;
import com.joysw.bean.sysdepartbean.SysDepartmentBean;
import com.joysw.bean.sysmenubean.SysMenuBean;
import com.joysw.bean.sysrolebean.SysRoleBean;
import com.joysw.bean.sysrolebean.SysRoleMenuBean;
import com.joysw.bean.sysuserbean.SysUserBean;
import com.joysw.bean.treebean.TreeBean;
import com.joysw.core.utils.StringEmpty;
import com.joysw.service.base.BaseService;
import com.joysw.service.sysmenumg.SysMenuMgService;
import com.joysw.service.sysrolemenumg.SysRoleMenuMgService;

public class SysRoleMenuMgAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JSONArray resultArray;
	private JSONObject resultObject;
	private SysMenuMgService sysMenuMgServiceImpl;
	private SysRoleBean sysRoleBean;
	private SysRoleMenuMgService sysRoleMenuMgServiceImpl;
	private BaseService<SysRoleMenuBean> baseSysRoleMenuMgServiceImpl;
	private BaseService<SysDepartmentBean> baseSysDepartMgServiceImpl;
	private BaseService<SysRoleBean> baseSysRoleServiceImpl;

	public BaseService<SysDepartmentBean> getBaseSysDepartMgServiceImpl() {
		return baseSysDepartMgServiceImpl;
	}

	public void setBaseSysDepartMgServiceImpl(
			BaseService<SysDepartmentBean> baseSysDepartMgServiceImpl) {
		this.baseSysDepartMgServiceImpl = baseSysDepartMgServiceImpl;
	}

	public JSONArray getResultArray() {
		return resultArray;
	}

	public void setResultArray(JSONArray resultArray) {
		this.resultArray = resultArray;
	}

	public JSONObject getResultObject() {
		return resultObject;
	}

	public void setResultObject(JSONObject resultObject) {
		this.resultObject = resultObject;
	}

	public BaseService<SysRoleMenuBean> getBaseSysRoleMenuMgServiceImpl() {
		return baseSysRoleMenuMgServiceImpl;
	}

	public void setBaseSysRoleMenuMgServiceImpl(
			BaseService<SysRoleMenuBean> baseSysRoleMenuMgServiceImpl) {
		this.baseSysRoleMenuMgServiceImpl = baseSysRoleMenuMgServiceImpl;
	}

	public SysRoleMenuMgService getSysRoleMenuMgServiceImpl() {
		return sysRoleMenuMgServiceImpl;
	}

	public void setSysRoleMenuMgServiceImpl(
			SysRoleMenuMgService sysRoleMenuMgServiceImpl) {
		this.sysRoleMenuMgServiceImpl = sysRoleMenuMgServiceImpl;
	}

	public BaseService<SysRoleBean> getBaseSysRoleServiceImpl() {
		return baseSysRoleServiceImpl;
	}

	public void setBaseSysRoleServiceImpl(
			BaseService<SysRoleBean> baseSysRoleServiceImpl) {
		this.baseSysRoleServiceImpl = baseSysRoleServiceImpl;
	}

	public SysMenuMgService getSysMenuMgServiceImpl() {
		return sysMenuMgServiceImpl;
	}

	public void setSysMenuMgServiceImpl(SysMenuMgService sysMenuMgServiceImpl) {
		this.sysMenuMgServiceImpl = sysMenuMgServiceImpl;
	}

	public SysRoleBean getSysRoleBean() {
		return sysRoleBean;
	}

	public void setSysRoleBean(SysRoleBean sysRoleBean) {
		this.sysRoleBean = sysRoleBean;
	}

	public String listLoopChildSysMenus(List<SysMenuBean> childMenuBeanList,
			Integer roleId) {
		String strJson = "[";
		for (SysMenuBean temp : childMenuBeanList) {
			SysMenuBean sysMenuBean = new SysMenuBean();
			sysMenuBean.setMenuId(temp.getMenuId());
			List<SysMenuBean> childMenuBeanListSub = this.sysMenuMgServiceImpl
					.getUnlockSysMenuBeans(sysMenuBean);
			strJson += "{'id':'"
					+ (temp.getMenuId() == null ? "" : temp.getMenuId())
					+ "','text':'"
					+ (temp.getMenuName() == null ? "" : temp.getMenuName())
					+ "'";
			if (childMenuBeanListSub != null && childMenuBeanListSub.size() > 0) {
				strJson += ",'state':'closed','children':"
						+ listLoopChildSysMenus(childMenuBeanListSub, roleId)
						+ "}";
			} else {
				if (!"-1".equals(roleId.toString())) {
					SysRoleMenuBean sysRoleMenuBean = new SysRoleMenuBean();
					sysRoleMenuBean.setRoleId(roleId);
					sysRoleMenuBean.setMenuId(temp.getMenuId());
					List<SysRoleMenuBean> sysRoleMenuList = this.sysRoleMenuMgServiceImpl
							.getSysRoleMenuBeans(sysRoleMenuBean);
					if (sysRoleMenuList != null && sysRoleMenuList.size() > 0) {
						strJson += ",'checked':'true'";
					}
				}
				strJson += "}";
			}
			strJson += ",";
		}
		strJson = strJson.substring(0, strJson.length() - 1);
		strJson += "]";
		return strJson;
	}

	public String listLoopAllChildSysMenus(List<SysMenuBean> childMenuBeanList,
			Integer roleId) {
		String strJson = "[";
		for (SysMenuBean temp : childMenuBeanList) {
			SysMenuBean sysMenuBean = new SysMenuBean();
			sysMenuBean.setMenuId(temp.getMenuId());
			List<SysMenuBean> childMenuBeanListSub = this.sysMenuMgServiceImpl
					.getAllSysMenuBeans(sysMenuBean);

			strJson += "{'id':'"
					+ (temp.getMenuId() == null ? "" : temp.getMenuId())
					+ "','text':'"
					+ (temp.getMenuName() == null ? "" : temp.getMenuName())
					+ "'";

			if (childMenuBeanListSub != null && childMenuBeanListSub.size() > 0) {
				strJson += ",'state':'closed','children':"
						+ listLoopAllChildSysMenus(childMenuBeanListSub, roleId)
						+ "}";
			} else {
				if (!"-1".equals(roleId.toString())) {
					SysRoleMenuBean sysRoleMenuBean = new SysRoleMenuBean();
					sysRoleMenuBean.setRoleId(roleId);
					sysRoleMenuBean.setMenuId(temp.getMenuId());
					List<SysRoleMenuBean> sysRoleMenuList = this.sysRoleMenuMgServiceImpl
							.getSysRoleMenuBeans(sysRoleMenuBean);
					if (sysRoleMenuList != null && sysRoleMenuList.size() > 0) {
						strJson += ",'checked':'true'";
					}
				}
				strJson += "}";
			}
			strJson += ",";
		}
		strJson = strJson.substring(0, strJson.length() - 1);
		strJson += "]";
		return strJson;
	}

	public String listSysMenuBeans() {
		String roleId = this.getRequest().getParameter("roleId");
		SysMenuBean sysMenuBean = new SysMenuBean();
		sysMenuBean.setMenuId(1);
		//if(!StringEmpty.checkEmpty(roleId)){
			//sysMenuBean.setRoleId(Integer.parseInt(roleId));
		//}
		List<SysMenuBean> sysMenuList = new ArrayList<SysMenuBean>();
		String json = "";
		if (this.getSessionSysUserBean().getSuperuserFlag().equals("2")) {
			sysMenuList = this.sysMenuMgServiceImpl
					.getAllSysMenuBeans(sysMenuBean);
			json = listLoopAllChildSysMenus(sysMenuList, new Integer(roleId));
		} else {
			sysMenuList = this.sysMenuMgServiceImpl
					.getUnlockSysMenuBeans(sysMenuBean);
			json = listLoopChildSysMenus(sysMenuList, new Integer(roleId));
		}
		resultArray = JSONArray.fromObject(json);
		System.out.println("*********************" + resultArray);
		return SUCCESS;
	}

	public String listSysDepartBeans() {
		SysUserBean sysUserBean = this.getSessionSysUserBean();
		SysDepartmentBean sysDepartmentBean = new SysDepartmentBean();
		sysDepartmentBean.setDepartCode(sysUserBean.getUserDepartCode());

		List<SysDepartmentBean> sysDepartBeanList = this.sysRoleMenuMgServiceImpl
				.getSysDepartBeans(sysDepartmentBean);
		String json = listLoopDepartSysMenus(sysDepartBeanList);
		resultArray = JSONArray.fromObject(json);
		System.out.println("*********************" + resultArray);
		return SUCCESS;
	}

	public String listLoopDepartSysMenus(
			List<SysDepartmentBean> childDepartBeanList) {
		String strJson = "[";
		for (SysDepartmentBean temp : childDepartBeanList) {
			SysDepartmentBean sysDepartmentBean = new SysDepartmentBean();
			sysDepartmentBean.setDepartParentId(temp.getDepartId());
			List<SysDepartmentBean> childMenuBeanListSub = this.sysRoleMenuMgServiceImpl
					.getSysDepartBeans(sysDepartmentBean);
			strJson += "{'id':'"
					+ (temp.getDepartId() == null ? "" : temp.getDepartId())
					+ "','text':'"
					+ (temp.getDepartName() == null ? "" : temp.getDepartName())
					+ "'";

			if (childMenuBeanListSub != null && childMenuBeanListSub.size() > 0) {
				strJson += ",'state':'closed','children':"
						+ listLoopDepartSysMenus(childMenuBeanListSub) + "}";
			} else {
				strJson += "}";
			}
			strJson += ",";
		}
		strJson = strJson.substring(0, strJson.length() - 1);
		strJson += "]";
		return strJson;
	}

	public String saveSysRoleMenuBean() throws Exception {
		String roleId = this.getRequest().getParameter("roleId");
		String menuIds = this.getRequest().getParameter("menuIds");
		String[] menuIdsArray = menuIds.split(",");
		SysRoleMenuBean sysRoleMenuBean = new SysRoleMenuBean();
		sysRoleMenuBean.setRoleId(new Integer(roleId));
		this.sysRoleMenuMgServiceImpl.deleteSysRoleMenuBean(sysRoleMenuBean);
		for (int i = 0; i < menuIdsArray.length; i++) {
			sysRoleMenuBean = new SysRoleMenuBean();
			sysRoleMenuBean.setRoleId(new Integer(roleId));
			sysRoleMenuBean.setMenuId(new Integer(menuIdsArray[i]));
			this.baseSysRoleMenuMgServiceImpl.save(sysRoleMenuBean);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("info", "操作成功!");
		resultObject = this.getJSONObject(map); // 将map对象转换成为json对象
		System.out.println(resultObject);
		return SUCCESS;
	}

	public String listSysRoleBeans() {
		SysUserBean sysUserBean = this.getSessionSysUserBean();
		sysRoleBean = new SysRoleBean();
		sysRoleBean.setRoleDepartCode(sysUserBean.getUserDepartCode());
		List<SysRoleBean> sysRoleBeanList = this.sysRoleMenuMgServiceImpl
				.getSysRoleBeans(sysRoleBean);
		List<TreeBean> treeList = new ArrayList<TreeBean>();
		if (sysRoleBeanList != null && sysRoleBeanList.size() > 0) {
			TreeBean treeBean = null;
			for (SysRoleBean temp : sysRoleBeanList) {
				treeBean = new TreeBean();
				treeBean.setId(temp.getRoleId().toString());
				treeBean.setText(temp.getRoleName());
				treeList.add(treeBean);
			}
		}
		if (treeList == null || treeList.size() == 0) {
			TreeBean treeBean = new TreeBean();
			treeBean.setId("");
			treeBean.setText("");
			treeList.add(treeBean);
		}
		resultArray = JSONArray.fromObject(treeList);
		System.out.println(resultArray);
		return SUCCESS;
	}

	public String updateSysDepartBean() throws UnsupportedEncodingException {
		SysUserBean sysUserBean = this.getSessionSysUserBean();
		String departId = this.getRequest().getParameter("departId");
		String departName = this.getRequest().getParameter("departName");
		if (StringEmpty.checkEmpty(departId)) {
			SysDepartmentBean sysDepartmentBean = new SysDepartmentBean();
			// sysDepartmentBean.setDepartId(new Date().getTime());
			sysDepartmentBean.setDepartName(URLDecoder.decode(departName,
					"UTF-8"));
			sysDepartmentBean.setDepartCode(sysUserBean.getUserDepartCode());
			this.baseSysDepartMgServiceImpl.save(sysDepartmentBean);
		} else {
			SysDepartmentBean sysDepartmentBean = new SysDepartmentBean();
			sysDepartmentBean.setDepartId(new Integer(departId));
			sysDepartmentBean = this.baseSysDepartMgServiceImpl.get(
					sysDepartmentBean, sysDepartmentBean.getDepartId());
			sysDepartmentBean.setDepartName(URLDecoder.decode(departName,
					"UTF-8"));
			this.baseSysDepartMgServiceImpl.update(sysDepartmentBean);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("info", "操作成功!");
		resultObject = this.getJSONObject(map); // 将map对象转换成为json对象
		System.out.println(resultObject);
		return SUCCESS;
	}

	public String deleteSysDepartBean() {
		String departId = this.getRequest().getParameter("departId");
		SysDepartmentBean sysDepartmentBean = new SysDepartmentBean();
		sysDepartmentBean.setDepartId(new Integer(departId));

		sysDepartmentBean = this.baseSysDepartMgServiceImpl.get(
				sysDepartmentBean, sysDepartmentBean.getDepartId());

		List<SysDepartUserBean> departUserList = this.sysRoleMenuMgServiceImpl
				.getSysDepartUserBeans(sysDepartmentBean);
		Map<String, Object> map = new HashMap<String, Object>();
		if (departUserList != null && departUserList.size() > 0) {
			map.put("info", "操作失败,该部门还有其他用户信息!");
		} else {
			this.sysRoleMenuMgServiceImpl
					.deleteSysDepartBean(sysDepartmentBean);
			map.put("info", "操作成功!");
		}
		resultObject = this.getJSONObject(map); // 将map对象转换成为json对象
		System.out.println(resultObject);
		return SUCCESS;
	}

	public String addSysDepartBean() throws UnsupportedEncodingException {
		SysUserBean sysUserBean = this.getSessionSysUserBean();
		String departName = this.getRequest().getParameter("departName");
		String departParentId = this.getRequest()
				.getParameter("departParentId");
		SysDepartmentBean sysDepartmentBean = new SysDepartmentBean();
		if (StringEmpty.checkEmpty(departParentId)) {
			// sysDepartmentBean.setDepartId(new Date().getTime());
			sysDepartmentBean.setDepartCode(sysUserBean.getUserDepartCode());
		} else {
			sysDepartmentBean.setDepartParentId(new Integer(departParentId));
			SysDepartmentBean sysDepartmentBeanParent = this.baseSysDepartMgServiceImpl
					.get(sysDepartmentBean, sysDepartmentBean
							.getDepartParentId());
			sysDepartmentBean.setDepartCode(sysDepartmentBeanParent
					.getDepartCode()
					+ "_" + new Date().getTime());
		}
		sysDepartmentBean.setDepartName(URLDecoder.decode(departName, "UTF-8"));
		this.baseSysDepartMgServiceImpl.save(sysDepartmentBean);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("info", "操作成功!");
		resultObject = this.getJSONObject(map); // 将map对象转换成为json对象
		System.out.println(resultObject);
		return SUCCESS;
	}

	public String updateSysRoleBean() throws UnsupportedEncodingException {
		SysUserBean sysUserBean = this.getSessionSysUserBean();
		String roleId = this.getRequest().getParameter("roleId");
		String roleName = this.getRequest().getParameter("roleName");
		roleName = URLDecoder.decode(roleName, "UTF-8");
		if (StringEmpty.checkEmpty(roleId)) {
			SysRoleBean sysRoleBean = new SysRoleBean();
			// sysRoleBean.setRoleId(new Date().getTime());
			sysRoleBean.setRoleName(roleName);
			sysRoleBean.setRoleDepartCode(sysUserBean.getUserDepartCode());
			this.baseSysRoleServiceImpl.save(sysRoleBean);
		} else {
			SysRoleBean sysRoleBean = new SysRoleBean();
			sysRoleBean.setRoleId(new Integer(roleId));
			sysRoleBean = this.baseSysRoleServiceImpl.get(sysRoleBean,
					sysRoleBean.getRoleId());
			sysRoleBean.setRoleName(roleName);
			this.baseSysRoleServiceImpl.update(sysRoleBean);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("info", "操作成功!");
		resultObject = this.getJSONObject(map); // 将map对象转换成为json对象
		System.out.println(resultObject);
		return SUCCESS;
	}

	public String addSysRoleBean() throws UnsupportedEncodingException {
		SysUserBean sysUserBean = this.getSessionSysUserBean();
		String roleName = this.getRequest().getParameter("roleName");
		roleName = URLDecoder.decode(roleName, "UTF-8");
		SysRoleBean sysRoleBean = new SysRoleBean();
		// sysRoleBean.setRoleId(new Date().getTime());
		sysRoleBean.setRoleName(roleName);
		sysRoleBean.setRoleDepartCode(sysUserBean.getUserDepartCode());
		this.baseSysRoleServiceImpl.save(sysRoleBean);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("info", "操作成功!");
		resultObject = this.getJSONObject(map); // 将map对象转换成为json对象
		System.out.println(resultObject);
		return SUCCESS;
	}

	public String deleteSysRoleBean() {
		String roleId = this.getRequest().getParameter("roleId");
		SysRoleBean sysRoleBean = new SysRoleBean();
		sysRoleBean.setRoleId(new Integer(roleId));
		this.baseSysRoleServiceImpl.delete(sysRoleBean);
		SysRoleMenuBean sysRoleMenuBean = new SysRoleMenuBean();
		sysRoleMenuBean.setRoleId(new Integer(roleId));

		this.sysRoleMenuMgServiceImpl.deleteSysRoleMenuBean(sysRoleMenuBean);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("info", "操作成功!");
		resultObject = this.getJSONObject(map); // 将map对象转换成为json对象
		System.out.println(resultObject);
		return SUCCESS;
	}

	public String loadSysRoleMenuBeans() {
		return SUCCESS;
	}
}
