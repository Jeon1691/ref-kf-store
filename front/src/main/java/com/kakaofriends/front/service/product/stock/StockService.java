package com.kakaofriends.front.service.product.stock;

import com.kakaofriends.front.common.exception.InvalidateException;
import com.kakaofriends.front.service.product.stock.vo.Stock;

import java.util.List;

/**
 * StockService
 *
 * Author  april
 * Date    2018. 1. 26.
 */
public interface StockService {

    void validateStock(String productCode, boolean domestic, int quantity) throws InvalidateException;

    Stock get(String productId, boolean domestic);

    int update(Stock stock);

    int updateList(List<Stock> stockList);

    Stock getAlertStock(String productId, boolean domestic);
}