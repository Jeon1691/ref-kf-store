package com.kakaofriends.core.common.pagination;

import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

public class MobilePaginationRenderer extends AbstractPaginationRenderer implements ServletContextAware {

	private ServletContext servletContext;

	public MobilePaginationRenderer() {

	}

	public void initVariables() {
		firstPageLabel="";
		previousPageLabel = "<a href=\"#\" class=\"link_page\" onclick=\"{0}(\''{1}\'', {2});return false;\"><span class=\"img_comm ico_prev\">이전</span></a>";
		currentPageLabel = "<span class=\"screen_out\">현재페이지</span><em class=\"link_num\"><span class=\"selected\">{0}</span></em>";
		otherPageLabel = "<a href=\"#\" class=\"link_num\" onclick=\"{0}(\''{1}\'', {2});return false;\"><span>{2}</span></a>";
		nextPageLabel = "<a href=\"#\" class=\"link_page\" onclick=\"{0}(\''{1}\'', {2});return false;\"><span class=\"img_comm ico_next\">다음</span></a>";
		lastPageLabel="";
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
		initVariables();
	}
}