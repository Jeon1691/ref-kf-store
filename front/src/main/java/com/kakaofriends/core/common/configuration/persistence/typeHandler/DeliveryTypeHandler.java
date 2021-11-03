package com.kakaofriends.core.common.configuration.persistence.typeHandler;

import com.kakaofriends.core.domain.enums.EnumCodeTypeHandler;
import com.kakaofriends.core.common.configuration.persistence.type.DeliveryType;
import org.apache.ibatis.type.MappedTypes;

@MappedTypes(DeliveryType.class)
public class DeliveryTypeHandler extends EnumCodeTypeHandler<DeliveryType> {

	@Override
	protected DeliveryType[] values() {
		return DeliveryType.values();
	}
}
