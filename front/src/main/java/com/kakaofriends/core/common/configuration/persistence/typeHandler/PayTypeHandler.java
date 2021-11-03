package com.kakaofriends.core.common.configuration.persistence.typeHandler;

import com.kakaofriends.core.domain.enums.EnumCodeTypeHandler;
import com.kakaofriends.core.common.configuration.persistence.type.PayType;
import org.apache.ibatis.type.MappedTypes;

@MappedTypes(PayType.class)
public class PayTypeHandler extends EnumCodeTypeHandler<PayType> {

	@Override
	protected PayType[] values() {
		return PayType.values();
	}
}
