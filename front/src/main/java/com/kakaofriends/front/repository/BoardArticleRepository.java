package com.kakaofriends.front.repository;

import com.kakaofriends.core.common.pagination.PaginationInfo;
import com.kakaofriends.core.domain.BoardArticle;
import com.kakaofriends.core.domain.BoardArticleExpansion;
import com.kakaofriends.front.common.annotation.PrimaryMapper;
import com.kakaofriends.front.domain.BoardArticleDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@PrimaryMapper
@Repository
public interface BoardArticleRepository {

	int getBoardArticlesCountByArticleName(String articleName);

	List<BoardArticle> getBoardArticlesByArticleName(@Param("articleName") String articleName, @Param("pagination") PaginationInfo pagination);

	int getBoardArticlesCountByArticleCategory(@Param("articleName") String articleName, @Param("category") Integer category);

	List<BoardArticleExpansion> getBoardArticlesByArticleCategory(@Param("articleName") String articleName, @Param("category") Integer category, @Param("pagination") PaginationInfo pagination);

	int insertOneToOneArticle(BoardArticleDto.BoardArticleOneToOneRequest oneToOneArticle);

	int getOneToOneArticlesCountByUserId(String userId);

	List<BoardArticle> getOneToOneArticlesByUserId(@Param("userId") String userId, @Param("pagination") PaginationInfo pagination);

	List<BoardArticle> getOneToOneAnswersByUserId(@Param("userId") String userId, @Param("pagination") PaginationInfo pagination);

	BoardArticle findByCategoryNameFirstArticle(String category);

}