package com.kakaofriends.front.service.product.stock;

import com.kakaofriends.front.common.exception.InvalidateException;
import com.kakaofriends.front.domain.product.StockData;
import com.kakaofriends.front.repository.product.stock.StockRepository;
import com.kakaofriends.front.service.product.stock.vo.Stock;
import com.kakaofriends.front.service.product.stock.vo.StockHistory;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.kakaofriends.front.utils.FriendsUtil.isAnonymousUser;

/**
 * StockServiceImpl : 상품 재고에 대한 비즈니스 로직을 처리하는 서비스
 *
 * Author  april
 * Date    2018. 1. 26.
 */
@Slf4j
@Service
@AllArgsConstructor(onConstructor = @_(@Autowired))
public class StockServiceImpl implements StockService {

    private StockRepository stockRepository;
    private StockHistoryService stockHistoryService;

    @Override
    @Transactional(readOnly = true)
    public void validateStock(String productCode, boolean domestic, int quantity) throws InvalidateException {
        log.info("#### PARAM : productCode = {}, domestic = {}, quantity = {}", productCode, domestic, quantity);
        Stock stock = this.get(productCode, domestic);
        if (stock.getAvailableStock() < quantity) {
            throw new InvalidateException("invalid.stock");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Stock get(String productId, boolean domestic) {
        log.info("#### PARAM : productCode = {}, domestic = {}", productId, domestic);
        return this.converts(stockRepository.get(productId, domestic));
    }

    @Override
    public int update(Stock stock) {
        log.info("#### PARAM : {}", stock);
        int updateCnt = stockRepository.update(this.converts(stock));
        stockHistoryService.insert(setStockHistory(stock));
        return updateCnt;
    }

    @Override
    public int updateList(List<Stock> stockList) {
        int count = 0;
        for (Stock stock : stockList) {
            try {
                count += this.update(stock);
            } catch (Exception e) {
                log.error("#### Exception Caught during update stock = {}", stock);
                log.error("#### Exception Caught during update stock = {}", e);
            }

        }
        return count;
    }

    @Override
    @Transactional(readOnly = true)
    public Stock getAlertStock(String productId, boolean domestic) {
        log.info("#### PARAM = productCode = {}, domestic = {}", productId, domestic);
        return this.converts(stockRepository.getAlertStock(productId, domestic));
    }

    /**
     * 재고 히스토리 정보 생성
     *
     * @param stock 주문메인정보
     * @return stockHistory
     */
    private StockHistory setStockHistory(Stock stock) {
        StockHistory history = new StockHistory();
        history.setOrderId(stock.getOrderNumber());
        history.setProductId(stock.getProductId());
        history.setDomestic(stock.isDomestic());
        history.setAction(stock.getOrderAction().getName());
        history.setQuantity(Math.abs(stock.getOrderStock()));
        if(isAnonymousUser()) {
            history.setCreateId(StockHistory.NON_MEMBER);
        } else {
            history.setCreateId(stock.getMemberId());
        }
        return history;
    }

    private Stock converts(StockData data) {
        Stock stock = new Stock();
        stock.setProductId(data.getProductId());
        stock.setDomestic(data.isDomestic());
        stock.setAvailableStock(data.getAvailableStock());
        stock.setOrderStock(data.getOrderStock());
        stock.setBadStock(data.getBadStock());
        stock.setAlert(data.isAlert());
        stock.setAlertStock(data.getAlertStock());
        stock.setUpdateId(data.getUpdateId());
        stock.setCreateId(data.getCreateId());
        stock.setUpdateDate(data.getUpdateDate());
        stock.setCreateDate(data.getCreateDate());
        return stock;
    }

    private StockData converts(Stock stock) {
        StockData data = new StockData();
        data.setProductId(stock.getProductId());
        data.setDomestic(stock.isDomestic());
        data.setAvailableStock(stock.getAvailableStock());
        data.setOrderStock(stock.getOrderStock());
        data.setBadStock(stock.getBadStock());
        data.setAlert(stock.isAlert());
        data.setAlertStock(stock.getAlertStock());
        data.setUpdateId(stock.getUpdateId());
        data.setCreateId(stock.getCreateId());
        data.setUpdateDate(stock.getUpdateDate());
        data.setCreateDate(stock.getCreateDate());
        return data;
    }
}
