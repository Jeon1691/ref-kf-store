package com.kakaofriends.front.repository;

import com.kakaofriends.front.common.annotation.PrimaryMapper;
import org.springframework.stereotype.Repository;

/**
 * Created by Dave on 2017. 6. 15..
 */
@Repository
@PrimaryMapper
public interface ExchangeRateRepository {
    float getExchangeRate(String currency);
    
    void updateDefaultOrderMainExchangeRate();

    void updateDefaultOrderSubExchangeRate();
}
