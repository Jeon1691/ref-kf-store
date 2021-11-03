package com.kakaofriends.core.common.pagination;

import org.apache.commons.lang3.StringUtils;

import java.text.MessageFormat;

public abstract class AbstractPaginationRenderer implements PaginationRenderer {

	public String firstPageLabel;
	public String previousPageLabel;
	public String currentPageLabel;
	public String otherPageLabel;
	public String nextPageLabel;
	public String lastPageLabel;

	public String renderPagination(PaginationInfo paginationInfo, String jsFunction, String servletPath, String queryString) {
		if (StringUtils.isNotEmpty(jsFunction)) {
			return renderPagination(paginationInfo, jsFunction);
		} else {
			return renderPagination(paginationInfo, servletPath, queryString);
		}
	}

	private String renderPagination(PaginationInfo paginationInfo, String servletPath, String queryString) {

		StringBuffer strBuff = new StringBuffer();

		String query = StringUtils.isNotEmpty(queryString) ? "?" + queryString : "";
		int firstPageNo = paginationInfo.getFirstPageNo();
		int firstPageNoOnPageList = paginationInfo.getFirstPageNoOnPageList();
		int totalPageCount = paginationInfo.getTotalPageCount();
		int pageSize = paginationInfo.getPageSize();
		int lastPageNoOnPageList = paginationInfo.getLastPageNoOnPageList();
		int currentPageNo = paginationInfo.getCurrentPageNo();
		int lastPageNo = paginationInfo.getLastPageNo();

		if (totalPageCount > pageSize) {
			if (firstPageNoOnPageList > pageSize) {
				strBuff.append(MessageFormat.format(firstPageLabel, getArguments(servletPath, query, firstPageNo)));
				strBuff.append(MessageFormat.format(previousPageLabel, getArguments(servletPath, query, Integer.toString(firstPageNoOnPageList - 1))));
			} else {
				strBuff.append(MessageFormat.format(firstPageLabel, getArguments(servletPath, query, firstPageNo)));
				strBuff.append(MessageFormat.format(previousPageLabel, getArguments(servletPath, query, firstPageNo)));
			}
		}

		if (lastPageNoOnPageList > 1) {
			for (int i = firstPageNoOnPageList; i <= lastPageNoOnPageList; i++) {
				if (i == currentPageNo) {
					strBuff.append(MessageFormat.format(currentPageLabel, getArguments(Integer.toString(i))));
				} else {
					strBuff.append(MessageFormat.format(otherPageLabel, getArguments(servletPath, query, Integer.toString(i), Integer.toString(i))));
				}
			}
		}

		if (totalPageCount > pageSize) {
			if (lastPageNoOnPageList < totalPageCount) {
				strBuff.append(MessageFormat.format(nextPageLabel, getArguments(servletPath, query, firstPageNoOnPageList + pageSize)));
				strBuff.append(MessageFormat.format(lastPageLabel, getArguments(servletPath, query, lastPageNo)));
			} else {
				strBuff.append(MessageFormat.format(nextPageLabel, getArguments(servletPath, query, lastPageNo)));
				strBuff.append(MessageFormat.format(lastPageLabel, getArguments(servletPath, query, lastPageNo)));
			}
		}
		return strBuff.toString();
	}

	private String renderPagination(PaginationInfo paginationInfo, String jsFunction) {

		StringBuffer strBuff = new StringBuffer();

		int firstPageNo = paginationInfo.getFirstPageNo();
		int firstPageNoOnPageList = paginationInfo.getFirstPageNoOnPageList();
		int totalPageCount = paginationInfo.getTotalPageCount();
		int pageSize = paginationInfo.getPageSize();
		int lastPageNoOnPageList = paginationInfo.getLastPageNoOnPageList();
		int currentPageNo = paginationInfo.getCurrentPageNo();
		int lastPageNo = paginationInfo.getLastPageNo();

		if (totalPageCount > pageSize) {
			if (firstPageNoOnPageList > pageSize) {
				strBuff.append(MessageFormat.format(firstPageLabel, new Object[]{jsFunction, Integer.toString(firstPageNo)}));
				strBuff.append(MessageFormat.format(previousPageLabel, new Object[]{jsFunction, Integer.toString(firstPageNoOnPageList - 1)}));
			} else {
				strBuff.append(MessageFormat.format(firstPageLabel, new Object[]{jsFunction, Integer.toString(firstPageNo)}));
				strBuff.append(MessageFormat.format(previousPageLabel, new Object[]{jsFunction, Integer.toString(firstPageNo)}));
			}
		}

		if (lastPageNoOnPageList > 1) {
			for (int i = firstPageNoOnPageList; i <= lastPageNoOnPageList; i++) {
				if (i == currentPageNo) {
					strBuff.append(MessageFormat.format(currentPageLabel, new Object[]{Integer.toString(i)}));
				} else {
					strBuff.append(MessageFormat.format(otherPageLabel, getArguments(jsFunction, Integer.toString(i), i)));
				}
			}
		}

		if (totalPageCount > pageSize) {
			if (lastPageNoOnPageList < totalPageCount) {
				strBuff.append(MessageFormat.format(nextPageLabel, new Object[]{jsFunction, Integer.toString(firstPageNoOnPageList + pageSize)}));
				strBuff.append(MessageFormat.format(lastPageLabel, new Object[]{jsFunction, Integer.toString(lastPageNo)}));
			} else {
				strBuff.append(MessageFormat.format(nextPageLabel, new Object[]{jsFunction, Integer.toString(lastPageNo)}));
				strBuff.append(MessageFormat.format(lastPageLabel, new Object[]{jsFunction, Integer.toString(lastPageNo)}));
			}
		}
		return strBuff.toString();
	}

	private Object[] getArguments(Object... objects) {
		return objects;
	}
}
