package com.kakaofriends.front.domain.mypage;

import com.kakaofriends.core.domain.enums.Code;

public enum MyCouponCode implements Code {

    DEFAULT("6", "Gift", "Gift"),
    PAPER("7", "쿠폰등록", "Register coupon"),

    OPTION_DEFAULT("A", "전상품", "ALL"),
    OPTION_FREESHIPPING("D", "무료배송", "FREESHIPPING"),
    OPTION_CATEGORY("C", "카테고리", "CATEGORY");



    private String code;
    private String name;
    private String ename;

    MyCouponCode(String code, String name, String ename) {
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

    //2017-11-10 쿠폰 적립방식 구분에 따른 명칭 리턴
    public static String getMyCouponCodeName(String code, String contury){
        for(MyCouponCode myCouponCode : MyCouponCode.values()){
            if(myCouponCode.code.equals(code)) {
                if (contury.equals("kr")) {
                    return myCouponCode.getName();
                } else {
                    return myCouponCode.getEname();
                }
            }
        }
        return "";
    }
}