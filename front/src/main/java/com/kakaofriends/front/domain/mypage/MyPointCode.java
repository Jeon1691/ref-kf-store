package com.kakaofriends.front.domain.mypage;

import com.kakaofriends.core.domain.enums.Code;

public enum MyPointCode implements Code {

    USE("U", "사용", "USE"),
    CANCEL("C", "재적립", "Cancel"),
    GIFT("G", "Gift", "Gift"),
    ORDER("O", "적립", "EARN"),
    PAUSE("P", "소멸", "Pause");

    private String code;
    private String name;
    private String ename;

    MyPointCode(String code, String name, String ename) {
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

    public String getEname() { return ename; }

    public static String getMyPointCodeName(String code, String contury){
        for(MyPointCode myPointCode : MyPointCode.values()){
            if(myPointCode.code.equals(code)) {
                if (contury.equals("kr")) {
                    return myPointCode.getName();
                } else {
                    return myPointCode.getEname();
                }
            }
        }
        return "";
    }
}