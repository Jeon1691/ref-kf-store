package com.kakaofriends.front.repository;

import com.kakaofriends.front.common.annotation.PrimaryMapper;
import com.kakaofriends.front.domain.product.ProductLevelPriceData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * ProductLevelPriceRepository : 상품 가격 정보를 조회하는 레퍼지토리
 *
 * Author  april
 * Date    2018. 1. 14.
 */
@PrimaryMapper
@Repository
public interface ProductLevelPriceRepository {
    /**
     * 상품 가격을 조회한다.
     *
     * @param productCode 상품 코드
     * @return 상품 가격 데이터
     */
    ProductLevelPriceData select(@Param("productCode") String productCode);
}
