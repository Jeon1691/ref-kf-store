package com.kakaofriends.front.repository;

import com.kakaofriends.core.common.pagination.PaginationInfo;
import com.kakaofriends.front.common.annotation.PrimaryMapper;
import com.kakaofriends.front.domain.product.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DisplayGoodsRepository
 * <p>
 * Author  layla
 * Date    2018. 8. 22.
 */

@PrimaryMapper
@Repository
public interface DisplayGoodsRepository {
    //카테고리별 상품리스트 전체 카운트
    int findProductCountByCategoryWithCharacter(@Param("productRequest") ProductDto.ProductRequest productRequest);
    List<ProductExpansion> findProductsByCategoryWithCharacter(@Param("productRequest") ProductDto.ProductRequest productRequest, @Param("pagination") PaginationInfo pagination);

    //전시상품 신상품/인기상품리스트
    int findProductCountByCategoryGroup(@Param("productRequest") ProductDto.ProductRequest productRequest);
    List<ProductExpansion> findProductsByCategoryGroup(@Param("productRequest") ProductDto.ProductRequest productRequest, @Param("pagination") PaginationInfo pagination);

    //전시상품 검색리스트
    int findProductCountByName(@Param("searchRequest") ProductDto.SearchRequest searchRequest);
    List<ProductExpansion> findProductsByName(@Param("searchRequest") ProductDto.SearchRequest searchRequest, @Param("pagination") PaginationInfo pagination);

    //추천상품 리스트(findSuggestedProductsByProductCode)
    List<ProductDto.SuggestedProduct> findSuggestedByDisplayGoodsId(ProductDto.ProductRequest productRequest);

    //전시상품상세 (findProductDetailByProductRequest)
    DisplayGoodsExpansion findByDisplayGoodsId(ProductDto.ProductRequest productRequest);
    //전시상품의 상품리스트 전체 조회
    List<Goods> findByDisplayGoodsIdGoods(@Param("displayGoodsId") Long displayGoodsId, @Param("exchangeRate") double exchangeRate);
    //goodsOptionId 검색 (단품 일때 set해주기 위함)
    Long findGoodsOptionId(@Param("goodsId") Long goodsId);
    //하위 옵션이 있을때
    GoodsEtcData findByGoodsIdEctDataSum(Goods goods);
    //하위 옵션이 없을때
    GoodsEtcData findByGoodsIdEctData(Goods goods);

    //전시상품 옵션 타이틀 리스트 조회
    List<GoodsOptionTitle> findByDisplayGoodsIdOptionTitle(@Param("goodsId") Long goodsId);
    //전시상품 옵션 리스트 조회
    List<GoodsOption> findByDisplayGoodsIdOption(@Param("goodsId") Long goodsId, @Param("parentGoodsOptionId") Long parentGoodsOptionId);
    //옵션 마지막 단계 에서 상품과 제품의 차액 노출 계산을 위한 조회
    GoodsOptionPrice findByDisplayGoodsIdOptionPrice(@Param("goodsOptionId") Long goodsOptionId, @Param("goodsId") Long goodsId);
    //선택한 옵션의 제품 조회
    List<ProductExpansion> findProducts(@Param("goodsOptionId") Long goodsOptionId, @Param("exchangeRate") double exchangeRate);

    //전시상품코드와 제품코드를 통해 GoodsId조회
    Long findGoodsIdByPrcode(@Param("displayGoodsId") Long displayGoodsId, @Param("prCode") String prCode);
}
