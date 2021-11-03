package com.kakaofriends.front.domain.mypage;

import com.google.common.collect.Lists;

import java.util.List;

public enum MyMbsGubun{

    ROW_GUBUN1("적립","EARN", Lists.newArrayList("1","4")),
    ROW_GUBUN2("사용","USE",Lists.newArrayList("3")),
    ROW_GUBUN3("만료","EXPIRY",Lists.newArrayList("2","5")),
    ROW_GUBUN4("재적립","Cancel",Lists.newArrayList("6"));

    private String name;
    private String ename;
    private List<String> gubunCodes;

    MyMbsGubun(String name, String ename, List<String> gubunCodes) {
        this.name = name;
        this.ename = ename;
        this.gubunCodes = gubunCodes;
    }

    public String getName() {
        return name;
    }

    public String getEname() { return ename; }

    public List<String> getGubunCodes() {
        return gubunCodes;
    }

    public static String getMyMbsGubun(String code, String contury){
        for(MyMbsGubun myMbsGubun : MyMbsGubun.values()){
            if(myMbsGubun.gubunCodes.contains(code)) {
                if (contury.equals("kr")) {
                    return myMbsGubun.getName();
                } else {
                    return myMbsGubun.getEname();
                }
            }
        }
        return "";
    }
}