package com.kakaofriends.front.domain.product;

import com.kakaofriends.core.domain.Category;
import com.kakaofriends.core.domain.Product;
import com.kakaofriends.core.domain.ProductDisplay;
import com.kakaofriends.core.domain.ProductLevelPrice;
import com.kakaofriends.front.common.configuration.persistence.type.CategoryGroup;
import com.kakaofriends.front.domain.SoldOut;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.LocalDate;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.kakaofriends.core.utils.KakaoFriendsConstants.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductExpansion implements SoldOut {
	private Product product;
	private ProductLevelPrice productLevelPrice;
	private ProductDisplay productDisplay;
	private Category category;
	private CategoryGroup categoryGroup;
	private String prCode; //어디서쓰는거니?
	private long prOptionCnt;
	private long stEa;
	private Boolean isSoldOut;
	private Boolean isDiscountPeriod;
	private Boolean isTimeSale;
	private Boolean isCustomProduct;
	private Boolean isGiftBag;
    private Boolean isEventProduct;
	private Long bsSeq;
	private Long wsSeq;
	private Long basketCheck; // 전시상품 하위 제품들 중 장바구니에 들어있는 제품 카운트 2018.08.29.layla
	private Long foreigndeliCheck; // 전시상품 하위 제품들 중 해외배송 카운트 2018.08.29.layla
	private Long stZeroCheck; // 전시상품 하위 제품들의 전체 재고 카운트 0일경우 품절노출 2018.08.29.layla

	public Boolean getIsSoldOut() {
		return 1 > getStZeroCheck();
	}

	public Boolean getIsDiscountPeriod() {
		LocalDate startDate = new LocalDate(product.getPrDiscountsDate()).minusDays(1);
		LocalDate endDate = new LocalDate(product.getPrDiscounteDate()).plusDays(1);
		LocalDate today = new LocalDate();
		return today.isAfter(startDate) && today.isBefore(endDate) && StringUtils.isNotEmpty(product.getPrDiscountsDate()) && StringUtils.isNotEmpty(product.getPrDiscountsDate());
	}

	public Boolean getIsTimeSale() {
		try {
			if (product.getPrTimeSalesDate() != null) {
				SimpleDateFormat date = new SimpleDateFormat("yyyyMMddHH");
				Date startDate = date.parse(product.getPrTimeSalesDate());
				Date current = new Date();
				return current.after(startDate);
			}
		} catch(Exception e){
			e.getStackTrace();
		}
		return true;
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