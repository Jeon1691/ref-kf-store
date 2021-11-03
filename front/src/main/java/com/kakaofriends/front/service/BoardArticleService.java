package com.kakaofriends.front.service;

import com.kakaofriends.core.common.pagination.PaginationInfo;
import com.kakaofriends.core.domain.BoardArticle;
import com.kakaofriends.core.domain.BoardArticleExpansion;
import com.kakaofriends.core.domain.BoardCategory;

import java.util.List;

public interface BoardArticleService {

	List<BoardCategory> findByBoardCategoryAll();

	int findByArticleNameToCount(String articleName);

	List<BoardArticle> findByArticleName(String articleName, PaginationInfo pagination);

	int findByArticleWithCategoryToCount(String articleName, Integer category);

	List<BoardArticleExpansion> findByArticleWithCategory(String articleName, Integer category, PaginationInfo pagination);

	BoardArticle findByCategoryNameFirstArticle(String cateogry);
}
