package com.kakaofriends.front.repository;

import com.kakaofriends.core.common.pagination.PaginationInfo;
import com.kakaofriends.core.domain.Product;
import com.kakaofriends.front.common.annotation.PrimaryMapper;
import com.kakaofriends.front.domain.SearchEngine;
import com.kakaofriends.front.domain.product.ProductData;
import com.kakaofriends.front.domain.product.ProductDto;
import com.kakaofriends.front.domain.product.ProductExpansion;
import com.kakaofriends.front.domain.product.RecommendationBanner;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@PrimaryMapper
@Repository
public interface ProductRepository {

	int findProductCountByCategoryWithCharacter(@Param("productRequest") ProductDto.ProductRequest productRequest);

	int findProductCountByCategoryGroup(@Param("productRequest") ProductDto.ProductRequest productRequest);

	List<ProductExpansion> findProductsByCategoryWithCharacter(@Param("productRequest") ProductDto.ProductRequest productRequest, @Param("pagination") PaginationInfo pagination);

	List<ProductExpansion> findProductsByCategoryGroup(@Param("productRequest") ProductDto.ProductRequest productRequest, @Param("pagination") PaginationInfo pagination);

	ProductExpansion findProductDetailByProductRequest(ProductDto.ProductRequest productRequest);

	List<ProductDto.SuggestedProduct> findSuggestedProductsByProductCode(ProductDto.ProductRequest productRequest);

	int findProductCountByName(@Param("searchRequest") ProductDto.SearchRequest searchRequest);

	List<ProductExpansion> findProductsByName(@Param("searchRequest") ProductDto.SearchRequest searchRequest, @Param("pagination") PaginationInfo pagination);

	List<ProductExpansion> findProductByNewBest(ProductDto.ProductRequest productRequest);

	List<Product> findProductForContent();

	int updateProductForContentImageSrc(Product product);

	Product findByPrCode(String prCode);

	List<ProductExpansion> findByPrCodes(@Param("prCodes")List<String> prCodes);

    ProductExpansion findProductByProductCode(@Param("prCode") String prCode, @Param("exchangeRate") double exchangeRate);

    List<ProductExpansion> findProductByCharacter(ProductDto.ProductRequest productRequest);

    List<RecommendationBanner> findRecommendationBanner(@Param(value = "language") String language);

    List<ProductExpansion> findProductForOhMyFriends();

    List<ProductExpansion> viewEventProductList();

    ProductExpansion viewEventProductByPrCode(@Param(value = "prCode") String prCode);

    ProductExpansion viewEventGlobalProductByPrCode(@Param(value = "prCode") String prCode);

    int updateEventStock(@Param(value = "prCode") String prCode);

    List<Integer> findProductCategoryCode(@Param(value = "bsPrCodes") List<String> bsPrCodes);

    // 곧 지워야 할 Fake Search Engine
	List<SearchEngine> getCategoryName ();
	int updateSearchWord(SearchEngine searchEngine);

	/**
	 * 상품코드로 단 건의 상품을 조회한다.
	 *
	 * @param productCode 상품 코드
	 * @return 상품 정보
	 */
	ProductData selectByProductCode(@Param("productCode") String productCode);

	/**
	 * 2018. 2. 1. layla
	 * 상품코드로 노출정보만 조회
	 *
	 * @param productCode 상품 코드
	 * @return 상품 노출여부
	 */
	String getProductKrView(@Param("productCode") String productCode);
}
