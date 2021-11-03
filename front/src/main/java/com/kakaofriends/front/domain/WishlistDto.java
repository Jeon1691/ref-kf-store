package com.kakaofriends.front.domain;

import com.kakaofriends.core.domain.Product;
import com.kakaofriends.core.domain.ProductLevelPrice;
import com.kakaofriends.core.domain.Wishlist;
import com.kakaofriends.front.domain.product.ProductDto;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.LocalDate;

import java.util.List;

import static com.kakaofriends.core.utils.KakaoFriendsConstants.*;

public class WishlistDto {

	@Data
	public static class Request extends Friends {
		private Integer pageIndex = 1;
		private String prCode;
		private Long ctSeq;
		private String ownerId;
		private Long displayGoodsId; //2018.08.23 전시상품코드 추가
	}

	@Data
	public static class WishlistExpansion implements SoldOut {
		private Wishlist wishlist;
		private Product wishlistInProduct;
		private ProductLevelPrice productLevelPrice;
		private List<ProductDto.SuggestedProduct> suggestedProducts;
		private Boolean isSoldOut;
		private Boolean isDiscountPeriod;
		private Boolean isCustomProduct;
		private Boolean isGiftBag;
        private Boolean isEventProduct;
		private Long stZeroCheck; // 전시상품 하위 제품들의 전체 재고 카운트 0일경우 품절노출 2018.08.29.layla
		private Long prGiftBagCount; // 전시상품 하위 제품들 중 기프트백 타입 카운트 2018.08.29.layla

		public Boolean getIsSoldOut() {
			return 1 > getStZeroCheck();
		}

		public Boolean getIsDiscountPeriod() {
			LocalDate startDate = new LocalDate(wishlistInProduct.getPrDiscountsDate()).minusDays(1);
			LocalDate endDate = new LocalDate(wishlistInProduct.getPrDiscounteDate()).plusDays(1);
			LocalDate today = new LocalDate();
			return today.isAfter(startDate) && today.isBefore(endDate) && StringUtils.isNotEmpty(wishlistInProduct.getPrDiscountsDate()) && StringUtils.isNotEmpty(wishlistInProduct.getPrDiscountsDate());
		}

		public Boolean getIsCustomProduct(){
			return wishlistInProduct.getPrType().equals(PRODUCT_TYPE_CUSTOM_PRODUCT) ? true : false;
		}

		/*
		* 2018.08.29 layla
		* GiftBag 단일타입 비교 -> count 비교
		* */
		public Boolean getIsGiftBag(){
			return getPrGiftBagCount() > 0;
			//return wishlistInProduct.getPrType().equals(PRODUCT_TYPE_GIFT_BAG) ? true : false;
		}

        public Boolean getIsEventProduct(){
            return wishlistInProduct.getPrType().equals(PRODUCT_TYPE_EVENT_PRODUCT) ? true : false;
        }
	}
}