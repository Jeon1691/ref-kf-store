package com.kakaofriends.core.common.configuration.persistence.typeHandler;

import com.kakaofriends.core.domain.enums.EnumCodeTypeHandler;
import com.kakaofriends.core.common.configuration.persistence.type.BusinessDayType;
import org.apache.ibatis.type.MappedTypes;

@MappedTypes(BusinessDayType.class)
public class BusinessDayTypeHandler extends EnumCodeTypeHandler<BusinessDayType> {

	@Override
	protected BusinessDayType[] values() {
		return BusinessDayType.values();
	}
}
