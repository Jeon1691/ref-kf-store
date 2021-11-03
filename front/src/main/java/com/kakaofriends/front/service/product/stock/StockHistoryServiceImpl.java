package com.kakaofriends.front.service.product.stock;

import com.kakaofriends.front.domain.product.StockHistoryData;
import com.kakaofriends.front.repository.product.stock.StockHistoryRepository;
import com.kakaofriends.front.service.product.stock.vo.StockHistory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * StockHistoryServiceImpl
 *
 * Author  layla
 * Date    2018. 2. 26.
 */
@Slf4j
@Service
public class StockHistoryServiceImpl implements StockHistoryService {

    @Autowired
    private StockHistoryRepository stockHistoryRepository;

    @Override
    public void insert(StockHistory stockHistory) {
        log.info("#### PARAM : {}", stockHistory);
        stockHistoryRepository.insert(this.converts(stockHistory));
    }

    private StockHistoryData converts(StockHistory stock) {
        StockHistoryData data = new StockHistoryData();
        data.setId(stock.getId());
        data.setOrderId(stock.getOrderId());
        data.setProductId(stock.getProductId());
        data.setDomestic(stock.isDomestic());
        data.setAction(stock.getAction());
        data.setQuantity(stock.getQuantity());
        data.setCreateId(stock.getCreateId());
        data.setCreateDate(stock.getCreateDate());
        return data;
    }
}
