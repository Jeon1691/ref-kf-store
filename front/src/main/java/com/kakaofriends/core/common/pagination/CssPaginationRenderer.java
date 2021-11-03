package com.kakaofriends.core.common.pagination;

import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

public class CssPaginationRenderer extends AbstractPaginationRenderer implements ServletContextAware {

	private ServletContext servletContext;

	public CssPaginationRenderer() {

	}

	public void initVariables() {
		firstPageLabel = "";
		previousPageLabel = "<a href=\"?pageIndex={1}\" class=\"link_num\" onclick=\"{0}({1});return false; \"><img src=\"" + servletContext.getContextPath()+ "/images/icon/icon_prev.gif\"    alt=\"이전\"   border=\"0\"/></a>&#160;";
		currentPageLabel = "<em class=\"link_num\"><span class=\"selected\">{0}</span></em>";
		otherPageLabel = "<a href=\"?pageIndex={1}\" class=\"link_num\" onclick=\"{0}({1});return false; \">{2}</a>;";
		nextPageLabel = "<a href=\"?pageIndex={1}\" class=\"link_num\" onclick=\"{0}({1});return false; \"><img src=\"" + servletContext.getContextPath() + "/images/icon_next.gif\"    alt=\"다음\"   border=\"0\"/></a>&#160;";
		lastPageLabel = "";
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
		initVariables();
	}
}