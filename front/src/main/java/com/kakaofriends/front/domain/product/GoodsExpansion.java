package com.kakaofriends.front.domain.product;

import com.kakaofriends.front.domain.SoldOut;
import com.kakaofriends.front.utils.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.LocalDate;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.kakaofriends.core.utils.KakaoFriendsConstants.PRODUCT_TYPE_EVENT_PRODUCT;
import static com.kakaofriends.core.utils.KakaoFriendsConstants.PRODUCT_TYPE_GIFT_BAG;

/**
 * GoodsExpansion
 *
 * Author  layla
 * Date    2018. 8. 24.
 */
@Deprecated
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsExpansion implements SoldOut {
    private Goods goods;
    private int foreigndeliCheck;
    private int stZeroCheck;

    private Boolean isSoldOut;
    private Boolean isDiscountPeriod;

    public Boolean getIsSoldOut() {
        return 1 > getStZeroCheck();
    }

    public Boolean getIsDiscountPeriod() {
        LocalDate startDate = new LocalDate(goods.getDiscountsDate()).minusDays(1);
        LocalDate endDate = new LocalDate(goods.getDiscounteDate()).plusDays(1);
        LocalDate today = new LocalDate();
        return today.isAfter(startDate) && today.isBefore(endDate) && StringUtils.isNotEmpty(goods.getDiscountsDate()) && StringUtils.isNotEmpty(goods.getDiscountsDate());
    }
}