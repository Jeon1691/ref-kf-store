package com.kakaofriends.front.service.product;

import com.kakaofriends.core.common.pagination.PaginationInfo;
import com.kakaofriends.front.domain.product.*;

import java.util.List;

public interface DisplayGoodsService {
	//전시상품 카테고리리스트
	int findProductCountByCategoryWithCharacter(ProductDto.ProductRequest productRequest);
	List<ProductExpansion> findProductsByCategoryWithCharacter(ProductDto.ProductRequest productRequest, PaginationInfo pagination);
	//전시상품 신상품/인기상품리스트
	int findProductCountByCategoryGroup (ProductDto.ProductRequest productRequest);
	List<ProductExpansion> findProductsByCategoryGroup(ProductDto.ProductRequest productRequest, PaginationInfo pagination);
	//전시상품 검색리스트
	int findProductCountByName(ProductDto.SearchRequest searchRequest);
	List<ProductExpansion> findProductsByName(ProductDto.SearchRequest searchRequest, PaginationInfo pagination);
	//추천상품리스트
	List<ProductDto.SuggestedProduct> findSuggestedByDisplayGoodsId(ProductDto.ProductRequest productRequest);

	//상품상세
	DisplayGoodsExpansion findByDisplayGoodsId(ProductDto.ProductRequest productRequest);
	//전시상품의 상품리스트
	DisplayGoodsGroup findByDisplayGoodsIdGoodsAsDetail(Long displayGoodsId);
	//전시상품의 장바구니 옵션 조회 (ps 장바구니에서 옵션정보는 해당 제품이 선택되는 마지막 옵션만 내려줘야 함)
	DisplayGoodsGroup findByDisplayGoodsIdGoodsAsBasket(Long displayGoodsId, String bsPrCode);
	//옵션 타이틀 리스트 조회
	List<GoodsOptionTitle> findByDisplayGoodsIdOptionTitle(Long goodsId);
	//전시상품 옵션 리스트 조회
	List<GoodsOption> findByDisplayGoodsIdOption(Long goodsId, Long parentGoodsOptionId);
	//선택한 옵션의 제품 조회
	List<ProductExpansion> findProducts(Long goodsOptionId);
}
