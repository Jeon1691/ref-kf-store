package com.kakaofriends.front.domain.order;

import com.kakaofriends.front.domain.Friends;
import com.kakaofriends.front.domain.basket.BasketDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
public class OrderSheetDto implements Serializable {



	@Data
	@NoArgsConstructor
	public static class OrderSheetRequest extends Friends implements Serializable {

		private static final long serialVersionUID = 8244527739527645528L;

		private String osDeliInOutType;
		private List<Integer> checkBoxFlags;
		private Long ctSeq;
		private List<String> prCodes;
		private List<Long> prEas;
		private String customProductMsg;
		private String oaCountryName;
		private String oaAddressType;
        /**
         * 국가 변경 타입 C : 국가변경, S : 배송지 변경
         */
		private String changeNationType;
		private List<Boolean> isGiftBag; //2018.01.16 추가

		private String orderDirect; //2018.01.25 추가 (direct = N, directSheet = Y 구분)

		private List<Long> bsSeq; //2018.01.29 추가
		private List<BasketDto.Request> productList; //2018.08.27 전시옵션 상품정보 추가
		private List<Long> displayGoodsIds; //2018.08.30 전시상품ID 추가
	}

    /**
     * 배송지 국가 변경
     */
	public static String CHANGE_NATION_SHIPPING_TYPE = "S";
}