package com.kakaofriends.core.common.configuration.persistence.typeHandler;

import com.kakaofriends.core.common.configuration.persistence.type.ProductDisplayType;
import com.kakaofriends.core.domain.enums.EnumCodeTypeHandler;
import org.apache.ibatis.type.MappedTypes;

@MappedTypes(ProductDisplayTypeHandler.class)
public class ProductDisplayTypeHandler extends EnumCodeTypeHandler<ProductDisplayType> {
	@Override
	protected ProductDisplayType[] values() {
		return ProductDisplayType.values();
	}
}
