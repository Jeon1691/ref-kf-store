package com.kakaofriends.front.domain.basket;

import com.kakaofriends.core.domain.Basket;
import com.kakaofriends.core.domain.Product;
import com.kakaofriends.core.domain.ProductLevelPrice;
import com.kakaofriends.front.domain.SoldOut;
import com.kakaofriends.front.domain.product.DisplayGoodsGroup;
import com.kakaofriends.front.domain.product.GoodsOptionTitle;
import com.kakaofriends.front.domain.product.ProductDto.SuggestedProduct;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.LocalDate;

import java.util.List;

import static com.kakaofriends.core.utils.KakaoFriendsConstants.*;

@Data
public class BasketExpansion implements SoldOut {
	private Basket basket;
	private Product basketInProduct;
	private ProductLevelPrice productLevelPrice;
	private List<SuggestedProduct> suggestedProducts;
	private long bsCtSeq;
	private long stEa;
	private Boolean isSoldOut;
	private Boolean isDiscountPeriod;
	private Boolean isCustomProduct;
	private Boolean isGiftBag;
    private Boolean isEventProduct;
    private double exchangeRate;
    private Boolean stDomestic; // true 국내 false 해외
	private Long displayGoodsId; //2018.08.23 전시상품코드 추가
	private DisplayGoodsGroup displayGoodsGroup;
	private GoodsOptionTitle goodsOptionTitle; //2018.08.28 장바구니리스트 옵션명 set 용도
	private String displayGoodsKrView; //전시상품노출여부 2018.09.05 layla

	public Boolean getIsSoldOut() {
		return 1 > stEa;
	}

	public Boolean getIsDiscountPeriod() {
		if (basketInProduct.getPrDiscountsDate() == null || basketInProduct.getPrDiscounteDate() == null) {
			return false;
		}
		LocalDate startDate = new LocalDate(basketInProduct.getPrDiscountsDate()).minusDays(1);
		LocalDate endDate = new LocalDate(basketInProduct.getPrDiscounteDate()).plusDays(1);
		LocalDate today = new LocalDate();
		return today.isAfter(startDate) && today.isBefore(endDate) && StringUtils.isNotEmpty(basketInProduct.getPrDiscountsDate()) && StringUtils.isNotEmpty(basketInProduct.getPrDiscounteDate());
	}

	public Boolean getIsCustomProduct(){
		return basketInProduct.getPrType().equals(PRODUCT_TYPE_CUSTOM_PRODUCT) ? true : false;
	}

	public Boolean getIsGiftBag(){
		return basketInProduct.getPrType().equals(PRODUCT_TYPE_GIFT_BAG) ? true : false;
	}

    public Boolean getIsEventProduct(){
        return basketInProduct.getPrType().equals(PRODUCT_TYPE_EVENT_PRODUCT) ? true : false;
    }
}