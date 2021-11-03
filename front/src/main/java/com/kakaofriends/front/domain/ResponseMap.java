package com.kakaofriends.front.domain;

import lombok.Data;

import java.util.Map;

@Data
public class ResponseMap {
    private int status;
    private String message;
    private Map<String, Object> result;
}
