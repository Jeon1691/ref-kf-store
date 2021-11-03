package com.kakaofriends.core.common.tag;

import com.kakaofriends.core.common.pagination.PaginationInfo;
import com.kakaofriends.core.common.pagination.PaginationManager;
import com.kakaofriends.core.common.pagination.PaginationRenderer;
import com.kakaofriends.core.common.pagination.DefaultPaginationManager;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class PaginationTag extends TagSupport {

	private static final long serialVersionUID = 1L;

	private PaginationInfo paginationInfo;
	private String type;
	private String jsFunction;
	private String servletPath;
	private String queryString;

	public int doEndTag() throws JspException {

		try {
			JspWriter out = pageContext.getOut();
			PaginationManager paginationManager;
			WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(pageContext.getServletContext());
			if (ctx.containsBean("paginationManager")) {
				paginationManager = (PaginationManager) ctx.getBean("paginationManager");
			} else {
				paginationManager = new DefaultPaginationManager();
			}
			PaginationRenderer paginationRenderer = paginationManager.getRendererType(type);
			String contents = paginationRenderer.renderPagination(paginationInfo, jsFunction, servletPath, queryString);
			out.println(contents);
			return EVAL_PAGE;
		} catch (IOException e) {
			throw new JspException();
		}
	}

	public void setJsFunction(String jsFunction) {
		this.jsFunction = jsFunction;
	}

	public void setPaginationInfo(PaginationInfo paginationInfo) {
		this.paginationInfo = paginationInfo;
	}

	public void setServletPath(String servletPath) {
		this.servletPath = servletPath;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

	public void setType(String type) {
		this.type = type;
	}
}