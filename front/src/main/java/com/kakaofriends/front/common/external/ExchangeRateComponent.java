package com.kakaofriends.front.common.external;

import com.kakaofriends.front.common.api.PaymentGateway;
import com.kakaofriends.front.repository.ExchangeRateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * 작성자 : dave
 * 작성일 : 2017. 6. 17.
 *
 * @author dave
 *
 * 환율 component
 * 환율 초기화 시점 : WAS 뜰때 , /kr/exchangeRate 요청 들어올때
 *
 */

@Slf4j
@Component
public class ExchangeRateComponent {

    private double exchangeRate;

    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    private static final int USD_SCALE_UNIT = 2;

    @PostConstruct
    public void init(){
        exchangeRate = exchangeRateRepository.getExchangeRate("USD");
        log.info("##### 적용 환율 : {} ", exchangeRate);
    }

    /**
     *  @deprecated
     * get() 메소드를 활용한다.
     */
    @Deprecated
    public double getExchangeRate(){
        return exchangeRate;
    }

    public BigDecimal get() {
        return BigDecimal.valueOf(exchangeRate);
    }

    /**
     *  @deprecated
     */
    @Deprecated
    public double exchangeToUSD(double price){
        return Math.round(price / this.getExchangeRate() * 100d ) / 100d;
    }

    public BigDecimal exchangeToUSD(BigDecimal krw) {
        BigDecimal rate = BigDecimal.valueOf(this.getExchangeRate());
        return ExchangeRateComponent.exchange(krw, rate);
    }

    public static float exchangeToFloat(BigDecimal krw, BigDecimal usdRate) {
        return ExchangeRateComponent.exchange(krw, usdRate).floatValue();
    }

    public static BigDecimal exchange(BigDecimal krw, BigDecimal usdRate) {
        return krw.divide(usdRate, USD_SCALE_UNIT, RoundingMode.HALF_UP);
    }

    public BigDecimal getExchangeRate(PaymentGateway paymentGateway) {
        boolean oversea = paymentGateway.equals(PaymentGateway.PAYPAL);
        if (oversea) {
            return this.get();
        }
        return BigDecimal.ONE;
    }
}
