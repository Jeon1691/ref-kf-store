package com.kakaofriends.front.repository.product.stock;

import com.kakaofriends.front.common.annotation.PrimaryMapper;
import com.kakaofriends.front.domain.product.StockHistoryData;
import org.springframework.stereotype.Repository;

/**
 * StockHistoryRepository
 *
 * Author  breeze
 * Date    2018. 2. 23.
 */
@PrimaryMapper
@Repository
public interface StockHistoryRepository {

    /**
     * INSERT 재고 이력
     * @param stockHistoryData
     * @return
     */
    void insert(StockHistoryData stockHistoryData);
}