package com.kakaofriends.front.repository.product.category;

import com.kakaofriends.front.common.annotation.PrimaryMapper;
import com.kakaofriends.front.domain.product.ProductCategoryData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * ProductCategoryRepository : 상품 카테고리 매핑 DB 정보와 통신하는 레퍼지토리
 *
 * Author  april
 * Date    2018. 1. 30.
 */
@PrimaryMapper
@Repository
public interface ProductCategoryRepository {
    ProductCategoryData select(@Param("productCode") String productCode);
}
