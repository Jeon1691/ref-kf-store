package com.kakaofriends.front.domain.product;

import com.kakaofriends.core.domain.Category;
import com.kakaofriends.core.domain.ProductDisplay;
import com.kakaofriends.front.common.configuration.persistence.type.CategoryGroup;
import com.kakaofriends.front.domain.SoldOut;
import com.kakaofriends.front.utils.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.LocalDate;

import java.util.List;

import static com.kakaofriends.core.utils.KakaoFriendsConstants.PRODUCT_TYPE_CUSTOM_PRODUCT;
import static com.kakaofriends.core.utils.KakaoFriendsConstants.PRODUCT_TYPE_EVENT_PRODUCT;
import static com.kakaofriends.core.utils.KakaoFriendsConstants.PRODUCT_TYPE_GIFT_BAG;

/**
 * DisplayGoodsExpansion
 * <p>
 * Author  layla
 * Date    2018. 8. 20.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DisplayGoodsExpansion implements SoldOut {
    private ProductDisplay productDisplay;
    private DisplayGoods displayGoods; //전시상품 공통상세
    private Category category;
    private CategoryGroup categoryGroup;
    private Boolean isSoldOut;
    private Boolean isDiscountPeriod;
    private Boolean isGiftBag;
    private Boolean isEventProduct;
    private Boolean isCustomProduct;
    private Boolean isHasOption; //하나라도 옵션이 있으면 false

    private Long wsSeq;
    private Long basketCheck; // 전시상품 하위 제품들 중 장바구니에 들어있는 제품 카운트 2018.08.29.layla
    private Long foreigndeliCheck; // 전시상품 하위 제품들 중 해외배송 카운트 2018.08.29.layla
    private Long stZeroCheck; // 전시상품 하위 제품들의 전체 재고 카운트 0일경우 품절노출 2018.08.29.layla
    private Long prGiftBagCount; // 전시상품 하위 제품들 중 기프트백 타입 카운트 2018.08.29.layla

    public Boolean getIsSoldOut() {
        return 1 > getStZeroCheck();
    }

    public Boolean getIsDiscountPeriod() {
        LocalDate startDate = new LocalDate(displayGoods.getDiscountsDate()).minusDays(1);
        LocalDate endDate = new LocalDate(displayGoods.getDiscounteDate()).plusDays(1);
        LocalDate today = new LocalDate();
        return today.isAfter(startDate) && today.isBefore(endDate) && StringUtils.isNotEmpty(displayGoods.getDiscountsDate()) && StringUtils.isNotEmpty(displayGoods.getDiscountsDate());
    }

    public Boolean getIsCustomProduct(){
        return displayGoods.getType().equals(PRODUCT_TYPE_CUSTOM_PRODUCT) ? true : false;
    }

    /*
     * 2018.08.29 layla
     * GiftBag 단일타입 비교 -> count 비교
     * */
    public Boolean getIsGiftBag(){
        return getPrGiftBagCount() > 0;
        //return displayGoods.getType().equals(PRODUCT_TYPE_GIFT_BAG) ? true : false;
    }

    public Boolean getIsEventProduct(){
        return displayGoods.getType().equals(PRODUCT_TYPE_EVENT_PRODUCT) ? true : false;
    }
}