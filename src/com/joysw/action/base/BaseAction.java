package com.joysw.action.base;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.joysw.bean.sysdepartbean.SysDepartmentBean;
import com.joysw.bean.sysuserbean.SysUserBean;
import com.joysw.core.utils.FinalApplication;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements ServletRequestAware {

	private static final long serialVersionUID = 1L;

	public JSONArray getJSONArray(Map<String, Object> map) {
		return JSONArray.fromObject(map);
	}

	public JSONObject getJSONObject(Map<String, Object> map) {
		return JSONObject.fromObject(map);
	}

	public String outJSONArray(Map<String, Object> map) {
		this.getResponse().setContentType("text/html;charset=utf-8");
		this.getResponse().setCharacterEncoding("UTF-8");
		PrintWriter out;
		try {
			out = this.getResponse().getWriter();
			out.println(this.getJSONArray(map).toString());
			System.out.println(this.getJSONArray(map).toString());
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String outJSONArrayList(List<Object> list) {
		this.getResponse().setContentType("text/html;charset=utf-8");
		this.getResponse().setCharacterEncoding("UTF-8");
		PrintWriter out;
		try {
			out = this.getResponse().getWriter();
			out.println(JSONArray.fromObject(list).toString());
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String outJSONString(String json) {
		this.getResponse().setContentType("text/html;charset=utf-8");
		this.getResponse().setCharacterEncoding("UTF-8");
		PrintWriter out;
		try {
			out = this.getResponse().getWriter();
			System.out.println(json);
			out.println(json);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String outJSONObject(Map<String, Object> map) {
		this.getResponse().setContentType("text/html;charset=utf-8");
		this.getResponse().setCharacterEncoding("UTF-8");
		PrintWriter out;
		try {
			out = this.getResponse().getWriter();
			out.println(JSONObject.fromObject(map));
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void outJsonString(String str) {
		getResponse().setContentType("text/javascript;charset=UTF-8");
		outString(str);
	}

	public SysUserBean getSessionSysUserBean() {
		SysUserBean sysUserBean = (SysUserBean) ActionContext.getContext()
				.getSession().get(FinalApplication.LOGIN_USER);
		return sysUserBean;
	}

	public SysDepartmentBean getSessionSysDepartBean() {
		SysDepartmentBean sysDepartmentBean = (SysDepartmentBean) ActionContext
				.getContext().getSession().get(FinalApplication.LOGIN_DEPART);
		return sysDepartmentBean;
	}

	public void outString(String str) {
		try {
			PrintWriter out = getResponse().getWriter();
			out.write(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void outXMLString(String xmlStr) {
		getResponse().setContentType("application/xml;charset=UTF-8");
		outString(xmlStr);
	}

	/**
	 * 获得request
	 * 
	 * @return
	 */
	public HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	/**
	 * 获得response
	 * 
	 * @return
	 */
	public HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	/**
	 * 获得session
	 * 
	 * @return
	 */
	public HttpSession getSession() {
		return getRequest().getSession();
	}

	/**
	 * 获得servlet上下斄1�7
	 * 
	 * @return
	 */
	public ServletContext getServletContext() {
		return ServletActionContext.getServletContext();
	}

	public String getRealyPath(String path) {
		return getServletContext().getRealPath(path);
	}

	public void setServletRequest(HttpServletRequest arg0) {
	}
}
