package com.kakaofriends.front.repository;

import com.kakaofriends.front.common.annotation.PrimaryMapper;
import com.kakaofriends.front.domain.CategoryMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@PrimaryMapper
public interface CategoryRepository {

	List<CategoryMenu> findMenuCategory();
}