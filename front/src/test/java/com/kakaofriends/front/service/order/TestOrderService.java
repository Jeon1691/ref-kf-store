package com.kakaofriends.front.service.order;

import com.kakaofriends.core.common.configuration.persistence.type.DeliInOutType;
import com.kakaofriends.core.common.configuration.persistence.type.DeliveryType;
import com.kakaofriends.core.common.configuration.persistence.type.OrderAccessType;
import com.kakaofriends.core.common.configuration.persistence.type.OrderStatusType;
import com.kakaofriends.front.common.configuration.*;
import com.kakaofriends.front.common.constants.Usable;
import com.kakaofriends.front.controller.order.vo.OrderSession;
import com.kakaofriends.front.domain.Country;
import com.kakaofriends.front.repository.product.stock.StockRepository;
import com.kakaofriends.front.service.member.MemberAddress;
import com.kakaofriends.front.service.member.MemberAddressService;
import com.kakaofriends.front.service.member.point.PointService;
import com.kakaofriends.front.service.order.constants.OrderSubType;
import com.kakaofriends.front.service.order.main.OrderMainService;
import com.kakaofriends.front.service.order.sub.OrderSubService;
import com.kakaofriends.front.service.order.vo.OrderMain;
import com.kakaofriends.front.service.order.vo.OrderSub;
import com.kakaofriends.front.service.product.stock.StockService;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

;

/**
 * TestPaymentHistoryService
 *
 * Author  april
 * Date    2018. 01. 22.
 */
@ActiveProfiles("development")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@Slf4j
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class, SecurityConfig.class, DatabaseConfig.class, SchedulingConfig.class})
public class TestOrderService {

    @Autowired
    private OrderMainService orderMainService;

    @Autowired
    private OrderSubService orderSubService;

    @Autowired
    private MemberAddressService memberAddressService;

    @Test
    public void getOrderMain() {
        OrderMain orderMain = orderMainService.get("K1802081639264900");
        System.out.println(orderMain);
    }

    @Test
    public void getOrderSubList() {
        OrderSub want = new OrderSub();
        want.setOrderNumber("K1802081639264900");
        List<OrderSub> orderSubList = orderSubService.getList(want);
        System.out.println(orderSubList);
    }

    @Test
    public void addOrderSub() {
        OrderSub orderSub = new OrderSub();
        orderSub.setOrderNumber("K999999999");
        orderSub.setSerial(1);
        orderSub.setPgTid("TIDDDDD");
        orderSub.setProductCode("productCode");
        orderSub.setSupplyCompanyCode("isupplied");
        orderSub.setBusinessGroupCode("business");
        orderSub.setBusinessPartCode("busipart");
        orderSub.setMemberId("im not a member");
        orderSub.setMemberName("not april");
        orderSub.setPointMoney(new BigDecimal(1000));
        orderSub.setOriginalMoney(new BigDecimal(100000));
        orderSub.setSaleMoney(new BigDecimal(100000));
        orderSub.setTotalOriginalMoney(new BigDecimal(100000));
        orderSub.setTotalSaleMoney(new BigDecimal(100000));
        orderSub.setKakaoMoney(new BigDecimal(100000));
        orderSub.setDeliveryType(DeliveryType.EMS);
        orderSub.setDeliveryMoneyUse(Usable.USE);
        orderSub.setStatus(OrderStatusType.RECEIVING_ORDER);
        orderSub.setType(OrderSubType.ORDER);
        orderSub.setAccessType(OrderAccessType.EN);
        orderSub.setDeliveryInOutType(DeliInOutType.OVERSEAS);
        List<OrderSub> orderSubList = new ArrayList<>();
        orderSubList.add(orderSub);
        orderSubService.addList(orderSubList);
        System.out.println(orderSub);
    }

    @Test
    public void addAddress() {
        MemberAddress memberAddress = new MemberAddress();
        long memberId =99999999l;
        memberAddress.setMemberId(memberId);
        memberAddress.setName("BPRIL");
        memberAddress.setAddress1("April world");
        memberAddress.setAddress2("April house");
        memberAddress.setAddress3("April room");
        memberAddress.setZipCode("9999");
        memberAddress.setPhone("01074732442");
        memberAddress.setEmail("april.shin@kakaocorp.com");
        memberAddress.setCountry(Country.Spain);
        memberAddress.setRegisteredMemberId(memberId);
        memberAddress.setUpdatedMemberId(memberId);

        memberAddressService.merge(memberAddress);
    }

    @Autowired
    private StockRepository stockRepository;

    @Test
    public void getStock() {
        System.out.println(stockRepository.get("FRPBNEMGP0003", true));
        System.out.println(stockRepository.get("FRPBNEMGP0003", false));

    }

    @Autowired
    private PointService pointService;

    @Test
    public void use() {
        pointService.redeemPoint(26563, "K1802021418203608", BigDecimal.valueOf(1000));
    }

    @Autowired
    private StockService stockService;

    @Test
    public void stocktest() {
        DeliInOutType type = null;
        stockService.get("FRPBNEMGP0003", type.isDomestic());
    }

    @Test
    public void parsingTest() {
        String orderString = "";
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.readValue(orderString, OrderSession.class);
        } catch (IOException e) {
            log.error("#### Exception = {}", e);
//            e.printStackTrace();
        }
    }
}
