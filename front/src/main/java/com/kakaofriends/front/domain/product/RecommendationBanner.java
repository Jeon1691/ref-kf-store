package com.kakaofriends.front.domain.product;

import lombok.Data;

/**
 * Created by ben on 2017. 11. 20..
 */
@Data
public class RecommendationBanner {
    /**
     * 고유번호
     */
    private int seq;

    /**
     * 언어 KR EN
     */
    private String language;

    /**
     * 제목
     */
    private String title;

    /**
     * 부제목
     */
    private String subTitle;

    /**
     * PC 이미지
     */
    private String pcImage;

    /**
     * 모바일 이미지
     */
    private String mobileImage;

    /**
     * PC 배경 이미지
     */
    private String pcBgImage;

    /**
     * 모바일 배경 이미지
     */
    private String mobileBgImage;

    /**
     * 링크
     */
    private String link;

    /**
     * 이미지 설명
     */
    private String alt;

    /**
     * 타겟
     */
    private String target;

    /**
     * 수정자 아이디
     */
    private String updUser;

    /**
     * 등록자 아이디
     */
    private String regUser;

    /**
     * 수정일
     */
    private String updDttm;

    /**
     * 등록일
     */
    private String regDttm;
}
