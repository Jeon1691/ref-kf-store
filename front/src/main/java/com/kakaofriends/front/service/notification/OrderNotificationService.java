package com.kakaofriends.front.service.notification;

import com.kakaofriends.core.common.configuration.persistence.type.DeliInOutType;
import com.kakaofriends.front.common.external.DaumMailSenderComponent;
import com.kakaofriends.front.common.external.KakaoIntegratedMessagingComponent;
import com.kakaofriends.front.repository.ProductRepository;
import com.kakaofriends.front.service.order.vo.Order;
import com.kakaofriends.front.service.order.vo.OrderAddress;
import com.kakaofriends.front.service.order.vo.OrderMain;
import com.kakaofriends.front.service.order.vo.OrderSub;
import com.kakaofriends.front.service.product.stock.StockService;
import com.kakaofriends.front.service.product.stock.vo.Stock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Locale;

/**
 * OrderNotificationService
 *
 * Author  april
 * Date    2018. 1. 31.
 */
@Service
@Slf4j
public class OrderNotificationService {
    @Value("${active}")
    private String active;
    @Autowired
    private KakaoIntegratedMessagingComponent messagingComponent;
    @Autowired
    private DaumMailSenderComponent mailSenderComponent;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private StockService stockService;

    public void notify(Order order, Locale locale) {
        log.debug("#### order notification = locale = {}, order = {}", locale, order);
        try {
            OrderMain orderMain = order.getOrderMain();
            OrderAddress orderAddress = order.getOrderAddress();
            messagingComponent.sendOrderCompleteSms(orderAddress.getOrderNumber(),
                    orderAddress.getBuyerName(), orderAddress.getBuyerPhone(), orderAddress.getBuyerCountry());
            mailSenderComponent.sendCompleteMail(order, locale);
            //글로벌 배송 여부 확인 하여 관리자에게 문자 발송 하도록 처리(국가, 상품수, 배송비, 총금액) -- 임시 기능임


            if (orderMain.getDeliveryInOutType().equals(DeliInOutType.OVERSEAS) && active.equals("production")) {
                messagingComponent.sendAdminSms("010-5494-8135", adminSmsMessage(order));
            }

            //주문의 모든단계 완료 후 재고 확인 하여 문자발송
            if (active.equals("production")) {
                stockSMSCheck(orderMain.getDeliveryInOutType().equals(DeliInOutType.DOMESTIC), order.getOrderSubList());
            }
        } catch (Exception e) {
            log.error("#### Order notification failure : order = {}", order);
        }
    }

    private String adminSmsMessage(Order order) {
        OrderMain orderMain = order.getOrderMain();
        OrderAddress orderAddress = order.getOrderAddress();
        String countryName = orderAddress.getCountry().getName();
        BigDecimal deliveryMoney = orderMain.getDeliveryMoney();
        BigDecimal amountMoney = orderMain.getCardMoney().add(orderMain.getPaypalMoney());
        BigDecimal productMoney = amountMoney.subtract(deliveryMoney);
        int productCount = 0;
        List<OrderSub> orderSubList = order.getOrderSubList();
        for (int i = 0; i < orderSubList.size(); i++) {
            int count = orderSubList.get(i).getEa();
            if (orderSubList.get(i).getProductCode() != null && !orderSubList.get(i).getProductCode().equalsIgnoreCase("")) {
                productCount += count;
            }
        }

        String paypalOrder = "";
        if(orderMain.getPaypalMoney().compareTo(BigDecimal.ZERO) > 0)
            paypalOrder = " (P)";

        DecimalFormat df = new DecimalFormat("#,###");

        String messageStr = "국가 : " + countryName + "\n";
        messageStr += "상품수 : " + productCount + "\n";
        messageStr += "상품가 : " + df.format(productMoney) + "\n";
        messageStr += "배송비 : " + df.format(deliveryMoney) + "\n";
        messageStr += "총금액" + paypalOrder + " : " + df.format(amountMoney) + "\n";

        return messageStr;
    }

    private void stockSMSCheck(boolean isDomestic, List<OrderSub> orderSubList) {
        try {
            orderSubList.stream().forEach(e -> {
                if (e.getProductCode() != null) {
                    String stCountry = "해외";
                    //재고 및 SMS설정 조회 [domestic >> 국내 1, 해외 0]
                    Stock stock = stockService.getAlertStock(e.getProductCode(), isDomestic);

                    // domestic >> 국내 1, 해외 2
                    if (isDomestic) {
                        stCountry = "국내";
                    }

                    if (stock != null) {
                        int availableStock = stock.getAvailableStock(); //가용재고
                        int alertStock = stock.getAlertStock(); //문자발송 설정 기준값
                        boolean alert = stock.isAlert(); //문자발송 설정
                        String productName = stock.getProductName(); //상품명
                        int osEa = e.getEa(); //주문완료 후 현재 가용재고

                        //문자수신 에슐리, 잭
                        if (alert && alertStock >= availableStock) {
                            boolean isSms = false;
                            int smsSt = availableStock; // 결제 전 재고를 거슬러 올라가기 위한 재고변수
                            for (int i=0; i<= osEa; i++) {
                                if(smsSt % 10 == 0) {
                                    isSms = true;
                                    break;
                                }
                                smsSt = smsSt + 1;
                            }

                            if(isSms) {
                                messagingComponent.sendAdminSms("010-5494-8135", adminStockSmsMessage(productName, availableStock, e.getProductCode(), stCountry));
                                messagingComponent.sendAdminSms("010-7162-3337", adminStockSmsMessage(productName, availableStock, e.getProductCode(), stCountry));
                            }
                        }
                    }
                }
            });
        } catch (Exception e) {
            log.info("## 주문의 모든 단계 완료 후 재고확인 시 오류 : orderCheckOutHanding : " + e);
        }
    }

    private String adminStockSmsMessage(String prName, long prCount, String prCode, String prCountry) {
        DecimalFormat df = new DecimalFormat("#,###");

        String messageStr = "상품 : " + prName + "(" + prCode + ")\n";
        messageStr += "구분 : " + prCountry + "\n";
        messageStr += "재고수 : " + df.format(prCount) + "\n";

        return messageStr;
    }
}
