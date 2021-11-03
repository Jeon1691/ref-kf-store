package com.kakaofriends.front.repository.product.stock;

import com.kakaofriends.front.common.annotation.PrimaryMapper;
import com.kakaofriends.front.domain.product.StockData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * DomesticStockRepository
 *
 * Author  april
 * Date    2018. 1. 26.
 */
@PrimaryMapper
@Repository
public interface StockRepository {

    /**
     * GET 재고 현황
     * @param productId
     * @param domestic
     * @return
     */
    StockData get(@Param("productId") String productId, @Param("domestic") boolean domestic);

    /**
     * UPDATE 재고 현황
     * @param stockData
     * @return
     */
    int update(StockData stockData);

    /**
     * GET 재고 SMS설정값
     * @param productId
     * @param domestic
     * @return
     */
    StockData getAlertStock(@Param("productId") String productId, @Param("domestic") boolean domestic);
}