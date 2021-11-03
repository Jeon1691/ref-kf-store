package com.kakaofriends.front.domain.product;

import com.kakaofriends.front.domain.SoldOut;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.LocalDate;

/**
 * GoodsOptionPrice
 * <p>
 * Author  layla
 * Date    2018. 8. 29.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsOptionPrice implements SoldOut {
    private Long id;

    private Integer salePrice;
    private Integer discountPrice;
    private double exchangePrice;
    private double exchangeDiscountPrice;
    private String discountsDate;
    private String discounteDate;

    private Integer prSalePrice;
    private Integer prDiscountPrice;
    private double prExchangePrice;
    private double prExchangeDiscountPrice;
    private String prDiscountsDate;
    private String prDiscounteDate;

    private int availableStock;
    private Boolean isSoldOut;
    private Boolean isDiscountPeriod;
    private Boolean isPrDiscountPeriod;


    public Boolean getIsSoldOut() {
        return 1 > getAvailableStock();
    }

    public Boolean getIsDiscountPeriod() {
        LocalDate startDate = new LocalDate(getDiscountsDate()).minusDays(1);
        LocalDate endDate = new LocalDate(getDiscounteDate()).plusDays(1);
        LocalDate today = new LocalDate();
        return today.isAfter(startDate) && today.isBefore(endDate) && StringUtils.isNotEmpty(getDiscountsDate()) && StringUtils.isNotEmpty(getDiscounteDate());
    }

    public Boolean getIsPrDiscountPeriod() {
        LocalDate startDate = new LocalDate(getPrDiscountsDate()).minusDays(1);
        LocalDate endDate = new LocalDate(getPrDiscounteDate()).plusDays(1);
        LocalDate today = new LocalDate();
        return today.isAfter(startDate) && today.isBefore(endDate) && StringUtils.isNotEmpty(getPrDiscountsDate()) && StringUtils.isNotEmpty(getPrDiscounteDate());
    }
}
