package com.kakaofriends.front.service.product.price;

import com.kakaofriends.front.service.product.vo.ProductLevelPrice;

/**
 * ProductLevelPriceService
 *
 * Author  april
 * Date    2018. 1. 15.
 */
public interface ProductLevelPriceService {
    /**
     * 상품에 대한 가격 정보를 조회한다.
     *
     * @param productCode 상품 코드
     * @return 상품 가격 정보
     */
    ProductLevelPrice get(String productCode);
}
