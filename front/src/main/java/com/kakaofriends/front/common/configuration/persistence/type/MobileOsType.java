package com.kakaofriends.front.common.configuration.persistence.type;

public enum MobileOsType {
    IPHONE("iPhone"),
    IPOD("iPod"),
    ANDROID("Android"),
    BLACKBERRY("BlackBerry"),
    WINDOWS_CE("windows CE"),
    NOKIA("Nokia"),
    WEBOS("Webos"),
    OPERA_MINI("Opera Mini"),
    SONYERICSSON("SonyEricsson"),
    OPERA_MOBI("Opera Mobi"),
    IEMOBILE("IEMobile");

    private String name;

    MobileOsType(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
