package com.kakaofriends.front.common.api;


import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class PayResult {
    private int status;
    private String message;

    private Object resultObj;
    private Map<String, Object> resultMap;
    private HashMap<String, String> resultHashMap;
}
