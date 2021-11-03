package com.kakaofriends.front.domain.basket;

import com.kakaofriends.front.domain.Friends;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

public class BasketDto {

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	public static class Request extends Friends implements Serializable {

		private static final long serialVersionUID = -1505306109969093081L;
		private String prCode;
		private List<String> prCodes;
		private Long prEa = 1L;
		private Long ctSeq;
		private String bsEtc5;
		private String oaCountryName;
		private boolean isGiftBag; //2018.01.16 추가
		private Long bsSeq; //2018.01.30 추가
		private String oaCountryCode; //2018.02.28 추가
		private Long displayGoodsId; //2018.08.22 전시상품ID 추가
		private List<Long> displayGoodsIds; //2018.08.22 전시상품ID 추가
		private List<BasketDto.Request> productList; //2018.08.27 전시옵션 상품정보 추가
		private List<Long> bsSeqs;
	}

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	public static class UseUpdate {
		private String[] bsSeqList;
		private String bsUse;
	}
}
