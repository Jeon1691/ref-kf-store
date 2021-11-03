package com.kakaofriends.front.service;

import com.kakaofriends.front.domain.CategoryMenu;
import com.kakaofriends.front.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<CategoryMenu> findMenuCategory() {
		return categoryRepository.findMenuCategory();
	}

	@Override
	public Map<Long, List<CategoryMenu>> getCategoryGroupingByCtRoot(List<CategoryMenu> categoryMenus) {
		return categoryMenus.stream().collect(Collectors.groupingBy(CategoryMenu::getCtRoot));
	}
}
