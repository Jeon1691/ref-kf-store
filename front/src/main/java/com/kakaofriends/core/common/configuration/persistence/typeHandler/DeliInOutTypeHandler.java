package com.kakaofriends.core.common.configuration.persistence.typeHandler;

import com.kakaofriends.core.common.configuration.persistence.type.DeliInOutType;
import com.kakaofriends.core.domain.enums.EnumCodeTypeHandler;
import org.apache.ibatis.type.MappedTypes;

@MappedTypes(DeliInOutType.class)
public class DeliInOutTypeHandler extends EnumCodeTypeHandler<DeliInOutType> {

	@Override
	protected DeliInOutType[] values() {
		return DeliInOutType.values();
	}
}