package com.kakaofriends.core.common.pagination;

public class PathPaginationRenderer extends AbstractPaginationRenderer {

	public PathPaginationRenderer() {
		firstPageLabel = "";
		previousPageLabel = "<a href=\"{0}/pages/{2}{1}" + "" + "\" class=\"link_page\"><span class=\"ico_newfriends_v1 ico_prev\">이전</span></a>";
		currentPageLabel = "<span class=\"screen_out\">현재 페이지</span><em class=\"link_page\">{0}</em>";
		otherPageLabel = "<a href=\"{0}/pages/{2}{1}" + "" + "\" class=\"link_page\">{3}</a>";
		nextPageLabel = "<a href=\"{0}/pages/{2}{1}" + "" + "\" class=\"link_page\"><span class=\"ico_newfriends_v1 ico_next\">다음</span></a>";
		lastPageLabel = "";
	}

	@Override
	public String renderPagination(PaginationInfo paginationInfo, String jsFunction, String servletPath, String queryString) {
		return super.renderPagination(paginationInfo, jsFunction, servletPath, queryString);
	}
}