package com.kakaofriends.core.common.configuration.persistence.typeHandler;

import com.kakaofriends.core.domain.enums.EnumCodeTypeHandler;
import com.kakaofriends.core.common.configuration.persistence.type.BannerType;
import org.apache.ibatis.type.MappedTypes;

@MappedTypes(BannerTypeHandler.class)
public class BannerTypeHandler extends EnumCodeTypeHandler<BannerType> {
    @Override
    protected BannerType[] values() {
        return BannerType.values();
    }
}
