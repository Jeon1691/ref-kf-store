package com.kakaofriends.front.domain.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * DisplayGoods
 * <p>
 * Author  layla
 * Date    2018. 8. 20.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DisplayGoods {
    private Long id;
    private String code;
    private String name;
    private String name1;
    private String foreignDeliYn;
    private String image1;
    private String image2;
    private String image3;
    private String image4;
    private String image5;
    private String image6;
    private String image7;
    private String image8;
    private String image9;
    private String image10;
    private String image11;
    private String image12;
    private String content;
    private String content1;

    private String searchWord;
    private Short status;
    private String discountsDate;
    private String discounteDate;
    private String krView;

    private String type;
    private String use;
    private String moid;
    private String inid;
    private LocalDateTime modate;
    private LocalDateTime indate;

    private Integer salePrice;
    private Integer discountPrice;

    private double exchangePrice;
    private double exchangeDiscountPrice;

    private String defaultPrcode;
}
