package com.kakaofriends.front.repository;

import com.kakaofriends.core.domain.Basket;
import com.kakaofriends.front.common.annotation.PrimaryMapper;
import com.kakaofriends.front.domain.basket.BasketData;
import com.kakaofriends.front.domain.basket.BasketDto;
import com.kakaofriends.front.domain.basket.BasketExpansion;
import com.kakaofriends.front.domain.product.ProductDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@PrimaryMapper
@Repository
public interface BasketRepository {

	int findByBsOwnerIdAllCount(@Param("ownerId") String ownerId, @Param("bsDirect") String bsDirect);

	BasketExpansion findByBsOwnerIdPrCode(@Param("ownerId") String ownerId, @Param("prCode") String prCode, @Param("displayGoodsId") Long displayGoodsId, @Param("bsDirect") String bsDirect, @Param("exchangeRate") double exchangeRate, @Param("domestic") boolean domestic);

	//seq로 장바구니의 아이템 조회 2018.01.30 layla
	BasketExpansion findByBsOwnerIdBsSeq(@Param("ownerId") String ownerId, @Param("bsSeq") Long bsSeq, @Param("bsDirect") String bsDirect, @Param("exchangeRate") double exchangeRate, @Param("domestic") boolean domestic);

	int basketInsert(Basket basket);

	int basketUpdateBsEa(Basket basket);

	int basketUpdateBsEaBySeq(Basket basket);

	List<BasketExpansion> findByBsOwnerId(@Param("ownerId") String ownerId,@Param("exchangeRate") double exchangeRate, @Param("domestic") boolean domestic);

	List<BasketExpansion> findByBsSeqIds(@Param("seqIds") List<String> seqIds, @Param("exchangeRate") double exchangeRate, @Param("domestic") boolean domestic);

	int basketListUpdateBsEaPlus(@Param("updateBasketList") List<Basket> updateBasketList);

	int basketListUpdateOwnerId(@Param("loginId") String loginId, @Param("basketExpansionList") List<BasketExpansion> basketExpansionList);

	int basketDeleteProduct(Basket basket);

	//사용하지않는 듯 2018.02.22
	int basketUseUpdateForBsSeq(BasketDto.UseUpdate basketDto);

	List<BasketData> selectList(@Param("sequenceList") List<Long> sequenceList);

	void delete(Long sequence);

	void deleteByMemberId(String memberId);

	//전시상품 아이디 기준으로 장바구니에 들어있는 제품 수 조회 2018.08.22 layla
	int findByDisplayProductIdAllCount(@Param("ownerId") String ownerId, @Param("displayGoodsId") Long displayGoodsId);

	//상품의 추천상품 조회
	List<ProductDto.SuggestedProduct> findSuggestedProductByPrCode(@Param("displayGoodsId") Long displayGoodsId, @Param("domestic") boolean domestic);
}