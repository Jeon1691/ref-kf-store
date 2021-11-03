package com.kakaofriends.front.service;

import com.kakaofriends.front.domain.CategoryMenu;

import java.util.List;
import java.util.Map;

public interface CategoryService {

	List<CategoryMenu> findMenuCategory();

	Map<Long, List<CategoryMenu>> getCategoryGroupingByCtRoot(List<CategoryMenu> categoryMenus);
}
