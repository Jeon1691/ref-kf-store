package com.kakaofriends.front.controller.order.api;


import com.kakaofriends.core.common.configuration.persistence.type.OrderStatusType;
import com.kakaofriends.core.common.configuration.persistence.type.PayType;
import com.kakaofriends.core.domain.OrderAddDeli;
import com.kakaofriends.core.utils.KakaoFriendsConstants;
import com.kakaofriends.core.utils.KakaoFriendsUtil;
import com.kakaofriends.front.common.api.OrderPath;
import com.kakaofriends.front.common.api.PaymentGateway;
import com.kakaofriends.front.common.exception.SessionTimeOutException;
import com.kakaofriends.front.controller.order.vo.OrderPayment;
import com.kakaofriends.front.controller.order.vo.OrderPreparation;
import com.kakaofriends.front.controller.order.vo.PaymentGatewayPreparation;
import com.kakaofriends.front.domain.Currency;
import com.kakaofriends.front.service.order.DefaultOrderAddDeliService;
import com.kakaofriends.front.service.order.OrderAddDeliService;
import com.kakaofriends.front.service.payment.PaymentHandler;
import com.kakaofriends.front.service.payment.vo.*;
import com.kakaofriends.front.utils.FriendsUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * OrderAddDeliRestController : 회수비를 처리하는 RestController
 *
 * 회수비는 국내 결제만 해당(페이팔 제외)
 *
 * Author  erica.k
 * Date    2018. 1. 29.
 */
@RestController
@Slf4j
@RequestMapping("/orderadddeli")
public class OrderAddDeliRestController {

    @Autowired
    private PaymentHandler paymentHandler;

    @Autowired
    private OrderAddDeliService orderAddDeliService;

    @Autowired
    private DefaultOrderAddDeliService defaultOrderAddDeliService;

    @Autowired
    private HttpServletRequest request;

    private final String ADDDELI_SESSION_KEY = "adddeli";
    private final String PAYMENT_SESSION_KEY = "payment_key";

    @PostMapping(value = "/preparation", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public PaymentGatewayPreparation prepare (@RequestParam("payment") PaymentGateway paymentGateway,
                                 @RequestBody OrderPreparation preparation, HttpSession session) {
        log.info("#### Controller /orderadddeli/preparation");
        log.info("#### payment: {}", paymentGateway);
        log.info("#### orderNumber: {}", preparation.getOrderNumber());

        Device device = DeviceUtils.getCurrentDevice(request);
        if (paymentGateway.equals(PaymentGateway.INICIS) && (!device.isNormal())) {
            paymentGateway = PaymentGateway.INICIS_MOBILE;
        }

        OrderAddDeli orderAddDeli = orderAddDeliService.findOrderAddDeliListByOrderNumberAndOrderStatus(preparation.getOrderNumber(), OrderStatusType.RECOVERY_WAITING);
        final String orderNumber = KakaoFriendsUtil.getOrderNumber(KakaoFriendsConstants.KAKAO_FRIENDS_ORDER_ADD_DELI_NUMBER_PREFIX);

        PaymentPreparation paymentPreparation = new PaymentPreparation();
        paymentPreparation.setOrderNumber(orderNumber);
        if (!FriendsUtil.isAnonymousUser()) {
            paymentPreparation.setMemberId(FriendsUtil.getFriendsMember().getId());
        }
        paymentPreparation.setMemberEmail(preparation.getBuyerEmail());
        paymentPreparation.setPaymentItem(this.convertsToAddDeliList());
        paymentPreparation.setDeliveryPrice(new BigDecimal(orderAddDeli.getOdReqMoney()));
        paymentPreparation.setCurrency(Currency.getCurrency(paymentGateway));
        paymentPreparation.setDiscountPrice(new BigDecimal(0));

        paymentPreparation.setOrderPath(OrderPath.ORDERADDDELI);
        PaymentPreparationResult response = paymentHandler.prepare(paymentGateway, paymentPreparation);

        // 결제 정보를 세션이 입력하여 execute 에서 DB에 insert 한다.
        session.setAttribute(PAYMENT_SESSION_KEY, response.getSessionId());
        session.setAttribute(ADDDELI_SESSION_KEY, orderAddDeli);

        return PaymentGatewayPreparation.converts(device, paymentGateway, orderNumber, response);
    }

    @PostMapping(value = "/payment", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity execute(@RequestParam("payment") PaymentGateway paymentGateway,
                                  @RequestBody OrderPayment orderPayment, HttpSession session) {
        log.info("#### Controller /orderadddeli/payment");
        log.debug("#### PARAM : pg = {}, body = {}", paymentGateway, orderPayment);
        PaymentExecution paymentExecution = PaymentExecution.converts(paymentGateway, orderPayment);

        String sessionId = (String) session.getAttribute(PAYMENT_SESSION_KEY);
        paymentExecution.setSessionId(sessionId);

        log.debug("#### orderadddeli from session = {}", sessionId);
        if (StringUtils.isEmpty(sessionId)) {
            throw new SessionTimeOutException();
        }

        PaymentResult result = paymentHandler.pay(paymentGateway, paymentExecution);

        OrderAddDeli orderAddDeli = (OrderAddDeli) session.getAttribute(ADDDELI_SESSION_KEY);
        orderAddDeli.setOdPayType(PayType.getPayType(paymentGateway));
        orderAddDeli.setOdOdNum(result.getOrderNumber());
        paymentExecution.setTid(result.getTid());
        defaultOrderAddDeliService.edit(paymentExecution, orderAddDeli);

        return new ResponseEntity(HttpStatus.OK);
    }

    private List<PaymentItem> convertsToAddDeliList() {
        List<PaymentItem> paymentItemList = new ArrayList<>();
        PaymentItem item = new PaymentItem();
        item.setName("추가 회수비");
        item.setPrice(new BigDecimal(0));
        item.setQuantity(1);
        paymentItemList.add(item);
        return paymentItemList;
    }
}
