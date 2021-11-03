package com.kakaofriends.front.domain.theme;

import com.kakaofriends.front.domain.SoldOut;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.LocalDate;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * ThemeProductData
 * <p>
 * Author  layla
 * Date    2018. 6. 1.
 */
@Data
public class ThemeProductData implements SoldOut {
    private String themeCode;
    private String prCode;
    private LocalDateTime createDate;

    private String prName;
    private String prEnName;
    private String prImage;
    private String prDiscountsDate;
    private String prDiscounteDate;
    private String prForeigndeliyn;

    private BigDecimal prlpSaleprice;
    private BigDecimal prlpDiscountprice;
    private double exchangePrice;
    private double exchangeDiscountPrice;

    private String defaultPrcode;
    private Long foreigndeliCheck;
    private Long stZeroCheck;
    private Long basketCheck;

    private Boolean isSoldOut;
    private Boolean isDiscountPeriod;

    public Boolean getIsSoldOut() {
        return 1 > stZeroCheck;
    }
    /**
     * 현재 할인 기간인지 여부를 반환한다.
     *
     * @return 할인 기간 여부
     */
    public Boolean getIsDiscountPeriod() {
        if (getPrDiscountsDate() == null || getPrDiscounteDate() == null) {
            return false;
        }

        LocalDate startDate = new LocalDate(getPrDiscountsDate()).minusDays(1);
        LocalDate endDate = new LocalDate(getPrDiscounteDate()).plusDays(1);
        LocalDate today = new LocalDate();
        return today.isAfter(startDate) && today.isBefore(endDate) && StringUtils.isNotEmpty(getPrDiscountsDate()) && StringUtils.isNotEmpty(getPrDiscountsDate());
    }
}
