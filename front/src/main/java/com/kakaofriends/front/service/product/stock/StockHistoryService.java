package com.kakaofriends.front.service.product.stock;

import com.kakaofriends.front.service.product.stock.vo.StockHistory;

/**
 * StockHistoryService
 *
 * Author  layla
 * Date    2018. 2. 26.
 */
public interface StockHistoryService {

    /**
     * 재고히스토리 insert
     *
     * @param stockHistory 재고 이력
     */
    void insert(StockHistory stockHistory);
}
