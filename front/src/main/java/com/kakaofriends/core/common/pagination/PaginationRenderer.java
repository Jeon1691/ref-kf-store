package com.kakaofriends.core.common.pagination;

public interface PaginationRenderer {

	String renderPagination(PaginationInfo paginationInfo, String jsFunction, String servletPath, String queryString);
}