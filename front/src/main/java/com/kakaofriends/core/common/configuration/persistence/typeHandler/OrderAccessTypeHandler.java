package com.kakaofriends.core.common.configuration.persistence.typeHandler;

import com.kakaofriends.core.common.configuration.persistence.type.OrderAccessType;
import com.kakaofriends.core.domain.enums.EnumCodeTypeHandler;
import org.apache.ibatis.type.MappedTypes;

@MappedTypes(OrderAccessTypeHandler.class)
public class OrderAccessTypeHandler extends EnumCodeTypeHandler<OrderAccessType> {

    @Override
    protected OrderAccessType[] values() {
        return OrderAccessType.values();
    }
}
