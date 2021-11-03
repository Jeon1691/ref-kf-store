package com.kakaofriends.front.domain.product;

import com.kakaofriends.front.domain.SoldOut;
import com.kakaofriends.front.service.product.vo.GoodsOptionType;
import com.kakaofriends.front.utils.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.LocalDate;

/**
 * Goods
 * <p>
 * Author  layla
 * Date    2018. 8. 21.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods implements SoldOut {
    private Long displayGoodsId;
    private Long id;
    private String addonType;
    private String optionType;
    //private GoodsOptionType optionType;
    private String name;
    private String nameEn;

    private Long goodsOptionId; // 제품조회 를 위한 Goods_option table 의 id값 지정 2018.08.29 layla

    private Integer salePrice;
    private Integer discountPrice;

    private double exchangePrice;
    private double exchangeDiscountPrice;

    private String discountsDate;
    private String discounteDate;


    private int foreigndeliCheck;
    //private int stZeroCheck;

    private Boolean isSoldOut;
    private Boolean isDiscountPeriod;

   /* public Boolean getIsSoldOut() {
        return 1 > getStZeroCheck();
    }*/

    public Boolean getIsDiscountPeriod() {
        LocalDate startDate = new LocalDate(getDiscountsDate()).minusDays(1);
        LocalDate endDate = new LocalDate(getDiscounteDate()).plusDays(1);
        LocalDate today = new LocalDate();
        return today.isAfter(startDate) && today.isBefore(endDate) && StringUtils.isNotEmpty(getDiscountsDate()) && StringUtils.isNotEmpty(getDiscountsDate());
    }
}
