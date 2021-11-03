package com.kakaofriends.front.domain.order;

import com.kakaofriends.core.domain.Product;
import com.kakaofriends.core.domain.ProductLevelPrice;
import com.kakaofriends.front.domain.SoldOut;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.LocalDate;

import static com.kakaofriends.core.utils.KakaoFriendsConstants.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderSheetExpansion implements SoldOut {
	private Long bsSeq;
	private String bsPrOption;
	private Long bsEa;
	private Long bsCtSeq;
	private String bsEtc5;
	private Product product;
	private ProductLevelPrice productLevelPrice;
	private Long orderEa;
	private Long stEa;
	private Boolean isSoldOut;
	private Boolean isDiscountPeriod;
	private Boolean isCustomProduct;
	private Boolean isGiftBag;
    private Boolean isEventProduct;
    private Long displayGoodsId;

	//판매가능수량 = 정상재고 - (  입금대기 + 주문접수 + 배송준비  )
	public Boolean getIsSoldOut() {
		return 1 > stEa;
	}

	public Boolean getIsDiscountPeriod() {
		if (product.getPrDiscountsDate() == null || product.getPrDiscounteDate() == null) {
			return false;
		}

		LocalDate startDate = new LocalDate(product.getPrDiscountsDate()).minusDays(1);
		LocalDate endDate = new LocalDate(product.getPrDiscounteDate()).plusDays(1);
		LocalDate today = new LocalDate();
		return today.isAfter(startDate) && today.isBefore(endDate) && StringUtils.isNotEmpty(product.getPrDiscountsDate()) && StringUtils.isNotEmpty(product.getPrDiscountsDate());
	}

	public Boolean getIsCustomProduct(){
		return product.getPrType().equals(PRODUCT_TYPE_CUSTOM_PRODUCT) ? true : false;
	}

	public Boolean getIsGiftBag(){
		return product.getPrType().equals(PRODUCT_TYPE_GIFT_BAG) ? true : false;
	}

    public Boolean getIsEventProduct(){
        return product.getPrType().equals(PRODUCT_TYPE_EVENT_PRODUCT) ? true : false;
    }
}
