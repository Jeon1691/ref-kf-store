package com.kakaofriends.core.common.configuration.persistence.type;

import com.kakaofriends.core.domain.enums.Code;

public enum BoardReplyType implements Code {
    DEFAULT("null", "", ""),
    RECEPTION_COMPLETION("1", "접수완료", "Order complete"),
    CONTENT_CONFIRMATION("2", "내용확인", "View order"),
    ANSWER_COMPLETION("3", "답변완료", "Answer Completed");

    private String code;
    private String name;
    private String ename;

    BoardReplyType(String code, String name, String ename) {
        this.code = code;
        this.name = name;
        this.ename = ename;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getEname() {
        return ename;
    }

}