package com.kakaofriends.front.service.sales;

import com.kakaofriends.front.domain.sales.KfoSalesData;
import com.kakaofriends.front.repository.sales.KfoSalesRepository;
import com.kakaofriends.front.service.payment.accounting.vo.Accounting;
import com.kakaofriends.front.service.sales.constants.SalesStatus;
import com.kakaofriends.front.service.sales.vo.KfoSales;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by eunduck on 2018. 3. 13..
 */
@Slf4j
@Service
@AllArgsConstructor(onConstructor = @_(@Autowired))
public class KfoSalesServiceImpl implements KfoSalesService {

    private KfoSalesRepository kfoSalesRepository;

    @Override
    @Transactional
    public int add(KfoSales sales) {
        log.info("#### PARAM = {}", sales);
        int result = 0;
        KfoSalesData salesData = this.converts(sales);
        if (kfoSalesRepository.selectOne(salesData) == null) {
            result = kfoSalesRepository.insert(salesData);
        }
        return result;
    }

    @Override
    @Transactional
    public void add(Accounting accounting) {
        this.add(this.convertsToSales(accounting));
    }

    /* Accounting > SalesData */
    private KfoSales convertsToSales(Accounting accounting) {
        KfoSales sales = new KfoSales();
        sales.setId(accounting.getId());
        sales.setStatus(SalesStatus.READY);
        sales.setOrderNumber(accounting.getOrderNumber());
        sales.setOrderSerial(accounting.getOrderSerial());
        sales.setDomestic(accounting.getDomestic());
        sales.setPaymentAction(accounting.getPaymentAction());
        sales.setProductCode(accounting.getProductCode());
        sales.setQuantity(accounting.getQuantity());
        sales.setPrice(accounting.getPrice());
        sales.setCurrency(accounting.getCurrency());
        sales.setPaymentMethod(accounting.getPaymentMethod());
        sales.setPaymentAmount(accounting.getPaymentAmount());
        sales.setPointAmount(accounting.getPointAmount());
        sales.setCouponAmount(accounting.getCouponAmount());
        return sales;
    }

    /* Sales > SalesData */
    private KfoSalesData converts(KfoSales sales) {
        KfoSalesData data = new KfoSalesData();
        data.setId(sales.getId());
        data.setStatus(sales.getStatus().name());
        data.setOrderId(sales.getOrderNumber());
        data.setOrderSerial(sales.getOrderSerial());
        data.setDomestic(sales.getDomestic());
        data.setAction(sales.getPaymentAction().name());
        data.setProductId(sales.getProductCode());
        data.setQuantity(sales.getQuantity());
        data.setPrice(sales.getPrice());
        data.setCurrency(sales.getCurrency().name());
        data.setPaymentMethod(sales.getPaymentMethod().name());
        data.setPaymentAmount(sales.getPaymentAmount());
        data.setPoint(sales.getPointAmount());
        data.setCoupon(sales.getCouponAmount());
        return data;
    }
}
