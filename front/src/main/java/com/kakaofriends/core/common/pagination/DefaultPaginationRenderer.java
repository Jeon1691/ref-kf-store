package com.kakaofriends.core.common.pagination;

public class DefaultPaginationRenderer extends AbstractPaginationRenderer {

	public DefaultPaginationRenderer() {
		firstPageLabel = "";
		previousPageLabel = "<a href=\"#\" class=\"link_page\" onclick=\"{0}(\''{1}\'');return false;\"><span class=\"ico_newfriends_v1 ico_prev\">이전</span></a>";
		currentPageLabel = "<span class=\"screen_out\">현재 페이지</span><em class=\"link_page\">{0}</em>";
		otherPageLabel = "<a href=\"#\" class=\"link_page\" onclick=\"{0}(\''{1}\'');return false;\">{1}</a>";
		nextPageLabel = "<a href=\"#\" class=\"link_page\" onclick=\"{0}(\''{1}\'');return false;\"><span class=\"ico_newfriends_v1 ico_next\">다음</span></a>";
		lastPageLabel = "";
	}

	@Override
	public String renderPagination(PaginationInfo paginationInfo, String jsFunction, String servletPath, String queryString) {
		return super.renderPagination(paginationInfo, jsFunction, servletPath, queryString);
	}
}