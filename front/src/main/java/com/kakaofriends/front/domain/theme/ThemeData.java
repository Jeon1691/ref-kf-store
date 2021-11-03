package com.kakaofriends.front.domain.theme;

import lombok.Data;

/**
 * ThemeData
 * <p>
 * Author  layla
 * Date    2018. 6. 1.
 */
@Data
public class ThemeData {
    private String themeCode;
    private String link;

    private String image;
    private String bgImage;
    private String imageM; //모바일
    private String bgImageM; //모바일

    private String alt;
    private String altSub;
    private String altM; //모바일
    private String altSubM; //모바일
}
