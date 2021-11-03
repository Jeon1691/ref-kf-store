package com.kakaofriends.front.common.api;

public enum OrderPath {
    ORDER("order"),
    ORDERADDDELI("orderadddeli");

    private String path;

    OrderPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public static OrderPath get(String path) {
        for (OrderPath orderPath : OrderPath.values()) {
            if (orderPath.getPath().equals(path)) {
                return orderPath;
            }
        }
        return OrderPath.ORDER;
    }
}
