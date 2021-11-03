package com.kakaofriends.front.repository;

import com.kakaofriends.core.domain.BoardCategory;
import com.kakaofriends.front.common.annotation.PrimaryMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@PrimaryMapper
@Repository
public interface BoardCategoryRepository {

	List<BoardCategory> getBoardCategoriesAll();

}