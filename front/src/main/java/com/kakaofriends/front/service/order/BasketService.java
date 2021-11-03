package com.kakaofriends.front.service.order;

import com.kakaofriends.front.domain.basket.BasketDto;
import com.kakaofriends.front.domain.basket.BasketExpansion;
import com.kakaofriends.front.service.basket.vo.Basket;
import com.kakaofriends.front.service.basket.vo.BasketProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BasketService {

	int findByBsOwnerIdAllCount(String userId, String bsDirect);

	int basketInsertProduct(BasketDto.Request request, String ownerId, String bsDirect, Boolean plus);

	Long basketInsertProduct(BasketDto.Request request, String ownerId);

	List<BasketExpansion> findByBsOwnerId(String ownerId, String countryCode);

	List<BasketExpansion> findByBsSeqIds(List<String> bsSeqIds, String countryCode);

	int basketDeleteProduct(com.kakaofriends.core.domain.Basket basket);

	int basketDeleteProducts(List<com.kakaofriends.core.domain.Basket> baskets);

	/**
	 * 장바구니에 담긴 정보들을 조회한다.
	 *
	 * @param sequenceList 장바구니 시퀀스
	 * @return 장바구니에 담긴 정보 목록
	 */
	List<Basket> getList(List<Long> sequenceList);

	/**
	 * 장바구니와 장바구니에 담긴 상품을 조회한다.
	 *
	 * @param basketSequenceList 장바구니 시퀀스
	 * @return 장바구니와 상품 정보 목록
	 */
	List<BasketProduct> getBasketProductList(List<Long> basketSequenceList);

	/**
	 * 장바구니에 담긴 상품을 지운다.
	 *
	 * @param sequenceList 장바구니 시퀀스 목록
	 */
	void removeList(List<Long> sequenceList);

	/**
	 * 장바구니에 담긴 상품을 지운다.
	 *
	 * @param memberId 회원 아이디 또는 세션 아이디
	 */
	void remove(String memberId);

	boolean checkProductEa(List<com.kakaofriends.core.domain.Basket> bsList);

	//전시상품 아이디 기준으로 장바구니에 들어있는 제품 수 조회 2018.08.22 layla
	int findByDisplayProductIdAllCount(String ownerId, Long displayGoodsId);

	int basketInsertProductList(BasketDto.Request request, String friendsMemberId, String basketDirectNo, boolean b);

	//상품 정보를 리스트로 받는다.
	List<Long> basketInsertProductList(BasketDto.Request request, String friendsMemberId);
}
