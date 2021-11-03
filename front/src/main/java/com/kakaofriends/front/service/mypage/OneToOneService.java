package com.kakaofriends.front.service.mypage;

import com.kakaofriends.core.common.pagination.PaginationInfo;
import com.kakaofriends.core.domain.BoardArticle;
import com.kakaofriends.front.domain.BoardArticleDto;

import java.util.List;

public interface OneToOneService  {

    int registerOneToOneArticle(BoardArticleDto.BoardArticleOneToOneRequest oneToOneArticle) throws Exception;

    int findOneToOneArticlesCountByUserId(String userId);

    List<BoardArticle> findOneToOneArticlesByUserId(String userId, PaginationInfo pagination);

    List<BoardArticle> findOneToOneAnswersByUserId(String userId, PaginationInfo pagination);
}
