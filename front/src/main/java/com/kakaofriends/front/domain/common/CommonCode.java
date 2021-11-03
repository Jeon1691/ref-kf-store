package com.kakaofriends.front.domain.common;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors( chain = true )
public class CommonCode {

    private String codeType;

    private String codeId;

    private String codeNm;

    private String parentId;

    private String optionFirst;

    private String optionSecond;

    private String optionThird;

    private boolean active;

    private LocalDateTime crtDt;

    private LocalDateTime updDt;

}
