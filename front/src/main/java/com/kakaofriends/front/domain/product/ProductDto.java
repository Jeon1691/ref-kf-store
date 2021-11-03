package com.kakaofriends.front.domain.product;

import com.kakaofriends.core.domain.Category;
import com.kakaofriends.core.domain.Product;
import com.kakaofriends.core.domain.ProductLevelPrice;
import com.kakaofriends.core.utils.KakaoFriendsConstants;
import com.kakaofriends.front.common.configuration.persistence.type.CategoryGroup;
import com.kakaofriends.front.domain.FriendsListing;
import com.kakaofriends.front.domain.SoldOut;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.LocalDate;

import java.util.List;

import static com.kakaofriends.core.utils.KakaoFriendsConstants.*;

public class ProductDto {

	@Data
	public static class ProductRequest extends FriendsListing {
		private Long requestCategory;
		private Long requestCharacter;
		private Long ctSeq;
		private String ctGroup;
		private String ctLink;
		private String cpCode;
		private String prCode;
		private String prUse;
		private String propPrType;
		private String prKrView;
		private Integer prdType;
		private Integer prStatus;
		private String orderBy;
		private Integer endRow;
		private Integer startRow;
		private String basketPopup;
		private String ownerId;
		private int prEa;
		private double exchangeRate;
		private Long ctCode;
	}

	@Data
	public static class SearchRequest extends FriendsListing {
		private String keyword;
		private List<String> keywords;
		private String ownerId = KakaoFriendsConstants.CTA_OWNER_ID;
		private String[] prTypeArray;
		private String cpCode = KakaoFriendsConstants.NONB2C;
		private Integer prStatus;
		private String prUse;
		private String ctUse;
		private String prLanguageViewColumn;
		private String prLanguageView;
		private double exchangeRate;
	}

	@Data
	public static class SuggestedProduct implements SoldOut {
		private Product product;
		private ProductLevelPrice productLevelPrice;
		private Category category;
		private CategoryGroup categoryGroup;
		private Boolean isSoldOut;
		private Boolean isCustomProduct;
		private Boolean isGiftBag;
        private Boolean isEventProduct;
		private double exchangeRate;
		private long stEa;
		private Long stZeroCheck; // 전시상품 하위 제품들의 전체 재고 카운트 0일경우 품절노출 2018.08.29.layla
		private Long prGiftBagCount; // 전시상품 하위 제품들 중 기프트백 타입 카운트 2018.08.29.layla

		public Boolean getIsSoldOut() {
			return 1 >  getStZeroCheck();
		}

		@Override
		public Boolean getIsDiscountPeriod() {
			LocalDate startDate = new LocalDate(product.getPrDiscountsDate()).minusDays(1);
			LocalDate endDate = new LocalDate(product.getPrDiscounteDate()).plusDays(1);
			LocalDate today = new LocalDate();
			return today.isAfter(startDate) && today.isBefore(endDate) && StringUtils.isNotEmpty(product.getPrDiscountsDate()) && StringUtils.isNotEmpty(product.getPrDiscountsDate());
		}

		public Boolean getIsCustomProduct(){
			return product.getPrType().equals(PRODUCT_TYPE_CUSTOM_PRODUCT) ? true : false;
		}

		/*
		 * 2018.08.29 layla
		 * GiftBag 단일타입 비교 -> count 비교
		 * */
		public Boolean getIsGiftBag(){
			return getPrGiftBagCount() > 0;
			//return product.getPrType().equals(PRODUCT_TYPE_GIFT_BAG) ? true : false;
		}

        public Boolean getIsEventProduct(){
            return product.getPrType().equals(PRODUCT_TYPE_EVENT_PRODUCT) ? true : false;
        }
	}

}