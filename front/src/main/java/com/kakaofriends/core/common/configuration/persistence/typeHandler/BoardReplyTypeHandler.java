package com.kakaofriends.core.common.configuration.persistence.typeHandler;

import com.kakaofriends.core.common.configuration.persistence.type.BoardReplyType;
import com.kakaofriends.core.domain.enums.EnumCodeTypeHandler;
import org.apache.ibatis.type.MappedTypes;


@MappedTypes(BoardReplyType.class)
public class BoardReplyTypeHandler extends EnumCodeTypeHandler<BoardReplyType> {
    @Override
    protected BoardReplyType[] values() {
        return BoardReplyType.values();
    }
}
