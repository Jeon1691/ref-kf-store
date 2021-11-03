package com.kakaofriends.front.service;

import com.kakaofriends.core.common.pagination.PaginationInfo;
import com.kakaofriends.core.domain.BoardArticle;
import com.kakaofriends.core.domain.BoardArticleExpansion;
import com.kakaofriends.core.domain.BoardCategory;
import com.kakaofriends.front.common.external.FileTransferProtocolComponent;
import com.kakaofriends.front.repository.BoardArticleRepository;
import com.kakaofriends.front.repository.BoardCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardArticleServiceImpl implements BoardArticleService {

	@Autowired
	private BoardArticleRepository boardArticleRepository;

	@Autowired
	private BoardCategoryRepository boardCategoryRepository;

	@Autowired
	private FileTransferProtocolComponent fileTransferProtocolComponent;

	@Override
	public List<BoardCategory> findByBoardCategoryAll() {
		return boardCategoryRepository.getBoardCategoriesAll();
	}

	@Override
	public int findByArticleNameToCount(String articleName) {
		return boardArticleRepository.getBoardArticlesCountByArticleName(articleName);
	}

	@Override
	public List<BoardArticle> findByArticleName(String articleName, PaginationInfo pagination) {
		return boardArticleRepository.getBoardArticlesByArticleName(articleName, pagination);
	}

	@Override
	public int findByArticleWithCategoryToCount(String articleName, Integer category) {
		return boardArticleRepository.getBoardArticlesCountByArticleCategory(articleName, category);
	}

	@Override
	public List<BoardArticleExpansion> findByArticleWithCategory(String articleName, Integer category, PaginationInfo pagination) {
		return boardArticleRepository.getBoardArticlesByArticleCategory(articleName, category, pagination);
	}

	@Override
	public BoardArticle findByCategoryNameFirstArticle(String category) {
		return boardArticleRepository.findByCategoryNameFirstArticle(category);
	}
}
