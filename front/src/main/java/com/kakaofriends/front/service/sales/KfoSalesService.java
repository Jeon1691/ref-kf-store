package com.kakaofriends.front.service.sales;

import com.kakaofriends.front.service.payment.accounting.vo.Accounting;
import com.kakaofriends.front.service.sales.vo.KfoSales;

/**
 * Created by eunduck on 2018. 3. 13..
 */
public interface KfoSalesService {

    /**
     * 매출을 등록한다.
     *
     * @param sales 매출 정보
     * @return 등록된 데이터의 수
     */
    int add(KfoSales sales);

    /**
     * 매출을 등록한다.
     *
     * @param accounting 회계 정보
     */
    void add(Accounting accounting);
}
