package com.kakaofriends.front.common.configuration.persistence.typeHandler;

import com.kakaofriends.core.domain.enums.EnumCodeTypeHandler;
import com.kakaofriends.front.common.configuration.persistence.type.CategoryGroup;
import org.apache.ibatis.type.MappedTypes;

@MappedTypes(CategoryGroupTypeHandler.class)
public class CategoryGroupTypeHandler extends EnumCodeTypeHandler<CategoryGroup> {

	@Override
	protected CategoryGroup[] values() {
		return CategoryGroup.values();
	}
}