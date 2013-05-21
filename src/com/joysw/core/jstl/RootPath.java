package com.joysw.core.jstl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class RootPath extends TagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int doEndTag() throws JspException {
		return super.doEndTag();
	}

	@SuppressWarnings("static-access")
	public int doStartTag() throws JspException {
		HttpServletRequest request = (HttpServletRequest) pageContext
				.getRequest();
		String str = request.getContextPath();
		try {
			pageContext.getOut().print(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.SKIP_BODY;
	}
}
