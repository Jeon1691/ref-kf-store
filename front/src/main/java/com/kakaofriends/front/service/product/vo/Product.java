package com.kakaofriends.front.service.product.vo;

import com.kakaofriends.front.common.constants.Usable;
import com.kakaofriends.front.utils.LocalDateTimeUtil;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Locale;

/**
 * Product
 *
 * Author  april
 * Date    2018. 1. 14.
 */
@Data
public class Product {
    private Long sequence;
    private String productCode;
    private String koreanName;
    private String englishName;
    private String scpType;
    private String scpCode;
    private String itemKoreanName;
    private String itemEnglishName;
    private String barcode;
    private String manufacturer;
    private String countryName;
    private String minBuyableEa;
    private String foreignDeliveryYn;
    private Double weight;

    private String standard;
    private String standard1;
    private Integer volume1;
    private Integer volume2;
    private Integer volume3;

    private String color;
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
    private String info;
    private String info1;
    private String view1;
    private String view2;
    private String view3;
    private String view4;
    private String view5;
    private String view6;
    private String content;
    private String content1;

    private String searchWord;

    private Short status;
    private LocalDateTime discountStartDate;
    private LocalDateTime discountEndDate;
    private String newYn;
    private String hotYn;
    private Long order;
    private Usable krView;

    private String type;
    private String useYn;
    private String modifiedId;
    private String insertedId;
    private LocalDateTime modifiedDate;
    private LocalDateTime insertedDate;

    private double height;
    private double width;
    private double depth;

    private BigDecimal currentPrice;
    private BigDecimal originalPrice;
    private Long categorySequence;

    /**
     * 현재 할인 기간인지 여부를 반환한다.
     *
     * @return 할인 기간 여부
     */
    public boolean isDiscount() {
        return LocalDateTimeUtil.isTime(this.discountStartDate, this.discountEndDate);
    }

    /**
     * Locale 정보에 따른 결제 상품명을 반환한다.
     *
     * @param locale 언어 구분
     * @return 결제 상품명
     */
    public String getProductName(Locale locale) {
        String productName = this.getKoreanName();
        if (!locale.equals(Locale.KOREA)
                && StringUtils.isNotBlank(this.getEnglishName())) {
            productName = this.getEnglishName();
        }
        return productName;
    }
}