package com.kakaofriends.front.service.product;

import com.kakaofriends.core.common.pagination.PaginationInfo;
import com.kakaofriends.front.domain.SearchEngine;
import com.kakaofriends.front.domain.product.ProductDto;
import com.kakaofriends.front.domain.product.ProductExpansion;
import com.kakaofriends.front.domain.product.RecommendationBanner;
import com.kakaofriends.front.service.product.vo.Product;

import java.util.List;

public interface ProductService {

	int findProductCountByCategoryWithCharacter (ProductDto.ProductRequest productRequest);

	int findProductCountByCategoryGroup (ProductDto.ProductRequest productRequest);

	List<ProductExpansion> findProductsByCategoryGroup(ProductDto.ProductRequest productRequest, PaginationInfo pagination);

	List<ProductExpansion> findProductsByCategoryWithCharacter(ProductDto.ProductRequest productRequest, PaginationInfo pagination);

	ProductExpansion findProductDetailByProductRequest(ProductDto.ProductRequest productRequest);

	List<ProductDto.SuggestedProduct> findSuggestedProductsByProductCode(ProductDto.ProductRequest productRequest);

	int findProductCountByName(ProductDto.SearchRequest searchRequest);

	List<ProductExpansion> findProductsByName(ProductDto.SearchRequest searchRequest, PaginationInfo pagination);

	List<ProductExpansion>  findProductByNewBest(ProductDto.ProductRequest productRequest);

	int updateProductForContentImageSrc();

	ProductExpansion findProductByProductCode(String prCode);

	List<ProductExpansion> findProductByCharacter(ProductDto.ProductRequest productRequest);

    List<RecommendationBanner> findRecommendationBanner(String language);

	List<ProductExpansion> findProductForOhMyFriends();

    List<Integer> findProductCategoryCode(List<String> bsPrCodes);

	// 곧 지워야 할 Fake Search Engine
	List<SearchEngine> getCategoryName ();
	int updateSearchWord(SearchEngine searchEngine);

	/**
	 * 상품 한 건을 조회한다.
	 *
	 * @param productCode 상품코드
	 * @return 상품 정보
	 */
	Product get(String productCode);

	/**
	 * 상품 판매 가격을 포함한 상품 데이터를 조회한다.
	 * - originalPrice : 상품 할인 전 가격.
	 * - currentPrice : 현재 판매 가격
	 * - 상품 할인 기간이 아닐 경우 두 가격이 동일하게 반환된다.
	 *
	 * @param productCode 상품코드
	 * @return 상품 정보와 상품 가격
	 */
	Product getWithPrice(String productCode);
}
