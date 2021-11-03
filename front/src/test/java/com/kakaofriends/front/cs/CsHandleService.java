package com.kakaofriends.front.cs;

import com.kakaofriends.core.common.configuration.persistence.type.OrderStatusType;
import com.kakaofriends.front.common.configuration.*;
import com.kakaofriends.front.domain.order.OrderSubHistoryData;
import com.kakaofriends.front.domain.payment.PaymentAction;
import com.kakaofriends.front.domain.payment.PaymentHistoryType;
import com.kakaofriends.front.domain.sales.SalesData;
import com.kakaofriends.front.repository.OrderSubHistoryRepository;
import com.kakaofriends.front.repository.SalesRepository;
import com.kakaofriends.front.service.order.cancel.OrderCancelProcessService;
import com.kakaofriends.front.service.order.main.OrderMainService;
import com.kakaofriends.front.service.order.sub.OrderSubService;
import com.kakaofriends.front.service.order.vo.OrderMain;
import com.kakaofriends.front.service.order.vo.OrderSub;
import com.kakaofriends.front.service.payment.PaymentHistoryService;
import com.kakaofriends.front.service.payment.accounting.AccountingService;
import com.kakaofriends.front.service.payment.accounting.vo.Accounting;
import com.kakaofriends.front.service.sales.KfoSalesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * CsHandleService
 *
 * Author  april
 * Date    2017. 12. 18.
 */
@ActiveProfiles("production")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
//@Ignore
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class, SecurityConfig.class, DatabaseConfig.class, SchedulingConfig.class})
public class CsHandleService {
    @Autowired
    private OrderCancelProcessService orderCancelProcessService;

    @Autowired
    private OrderSubHistoryRepository orderSubHistoryRepository;

    @Autowired
    private SalesRepository salesRepository;

    @Autowired
    private OrderMainService orderMainService;

    @Autowired
    private OrderSubService orderSubService;

    @Autowired
    private PaymentHistoryService paymentHistoryService;

    @Autowired
    private AccountingService accountingService;

    @Autowired
    private KfoSalesService salesService;

    String memberId = "25790";
    String orderId = "K1801292019416187";
    LocalDateTime requestDate = LocalDateTime.parse("2018-03-20T00:00:00");
    // -Dspring.profiles.active=production -Dfile.encoding=UTF-8

    /**
     * 환불을 수기 처리하는 코드
     * @Ignore 를 삭제하고, 회원아이디와 주문아이디를 입력한다.
     */
    @Test
    public void paymentRefund() {
        try {
            orderCancelProcessService.orderRefund(memberId, orderId);
            this.updateOrderSubHistory();
            this.selectInsertSales();
            System.out.println("success");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * 특정일로 주문취소일을 갱신한다.
     * requestDate 를 입력하여 특정일을 설정한다.
     */
    private void updateOrderSubHistory() {
        OrderSubHistoryData orderSubHistory = new OrderSubHistoryData();
        orderSubHistory.setOshOmNum(orderId);
        orderSubHistory.setOshOsStatus(OrderStatusType.RETURN_COMPLETED.getCode());
        orderSubHistory.setOshMoDate(requestDate);
        orderSubHistoryRepository.update(orderSubHistory);
    }

    /**
     * Sales 테이블에 주문 취소 이력을 등록한다.
     * requestDate 를 입력하여 특정일로 주문취소 이력을 등록한다.
     */
    private void selectInsertSales() {
        SalesData salesData = new SalesData();
        salesData.setSsOmNum(orderId);
        List<SalesData> salesDataList = salesRepository.selectList(salesData);
        for (SalesData data : salesDataList) {
            BigDecimal minus = new BigDecimal(-1);
            data.setSsCardMoney(minus.multiply(data.getSsCardMoney()));
            data.setSsCouponMoney(minus.multiply(data.getSsCouponMoney()));
            data.setSsLaterMoney(minus.multiply(data.getSsLaterMoney()));
            data.setSsBudgetMoney(minus.multiply(data.getSsSaveMoney()));
            data.setSsSaveMoney(minus.multiply(data.getSsCouponMoney()));
            data.setSsPointMoney(minus.multiply(data.getSsPointMoney()));
            data.setSsVirtualAccountMoney(minus.multiply(data.getSsVirtualAccountMoney()));
            data.setSsOriginalMoney(minus.multiply(data.getSsOriginalMoney()));
            data.setSsSaleMoney(minus.multiply(data.getSsSaleMoney()));
            data.setSsTotOriginalMoney(minus.multiply(data.getSsTotOriginalMoney()));
            data.setSsTotSaleMoney(minus.multiply(data.getSsTotSaleMoney()));
            data.setSsType("2");
            data.setSsMoDate(requestDate);
            data.setSsInDate(requestDate);
            data.setSsAccountMoney(minus.multiply(data.getSsAccountMoney()));
            data.setSsKakaoMoney(minus.multiply(data.getSsKakaoMoney()));
            data.setSsPhoneMoney(minus.multiply(data.getSsPhoneMoney()));
            data.setSsPaypalMoney(minus.multiply(data.getSsPaypalMoney()));
            data.setSsDuzonDate(null);
            data.setSsDuzonFlag(null);
            salesRepository.insert(data);
        }
        System.out.println();
    }

    /**
     * 취소 결제 이력을 입력한다.
     */
    @Test
    public void add() {
        OrderMain orderMain = orderMainService.get(orderId);
        OrderSub searchCondition = new OrderSub();
        searchCondition.setOrderNumber(orderId);
        List<OrderSub> orderSubList = orderSubService.getList(searchCondition);

        paymentHistoryService.add(PaymentHistoryType.ORDER, PaymentAction.CANCEL, orderMain);
        accountingService.addList(orderMain.getPayType(), PaymentAction.CANCEL, orderSubList);

        /**
         * 매출 취소 정보 입력
         */
        List<Accounting> accountingList = accountingService.getList(orderId, PaymentAction.CANCEL);
        for (Accounting accounting : accountingList) {
            salesService.add(accounting);
        }
    }



}
