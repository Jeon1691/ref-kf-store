package com.kakaofriends.front.common.event;

import com.kakaofriends.core.domain.Product;
import com.kakaofriends.front.common.external.ExchangeRateComponent;
import com.kakaofriends.front.common.external.KakaoIntegratedMessagingComponent;
import com.kakaofriends.front.domain.BoxItem;
import com.kakaofriends.front.domain.EventDto;
import com.kakaofriends.front.domain.order.OrderResultDto;
import com.kakaofriends.front.domain.product.ProductExpansion;
import com.kakaofriends.front.repository.BoxRepository;
import com.kakaofriends.front.repository.ProductRepository;
import com.kakaofriends.front.service.EventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * 작성자 : dave
 * 작성일 : 2017. 6. 26.
 *
 * 2017.07.01 시작하는 글로벌 배송 사은품 이벤트
 * 이벤트가 적용된 부분은 "사은품 이벤트" 전체검색
 *
 * @author dave
 * @version 버전, 작성일 작업내용 (ex. 메소드 추가)
 */

@Slf4j
@Component
public class GlobalEmsEvent {

    @Value("${redis.host}")
    private String hostIP;

    @Autowired
    BoxRepository boxRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ExchangeRateComponent exchangeRateComponent;

    @Autowired
    private EventService eventService;

    @Value("${active}")
    private String active;

    @Autowired
    private KakaoIntegratedMessagingComponent kakaoIntegratedMessagingComponent;

    protected int eventTotalSalesMoney;

    /**
     * 3만원 사은품
     */
    private String eventProducts3 = "FRPBRYTOP0005";

    /**
     * 5만원 사은품
     */
    private String eventProducts5 = "FRPBTBTOP0004";


    public void addEventProduct(OrderResultDto.OrderSubInit orderSubInit){
        setTotalSalesMoney(orderSubInit);

        if(isEventTime() && eventTotalSalesMoney >= 30000){
            // 모바일 이니시스인 경우 list들이 Arrays.asList 로 만들어져서 add, remove가 안되기 때문에 새로 객체 만들어서 넣어줌
            List<String> prCodes = new ArrayList<>();
            prCodes.addAll(orderSubInit.getPrCodes());
            prCodes.add(getEventProduct(orderSubInit));
            orderSubInit.setPrCodes(prCodes);

            List<Boolean> isDiscountPeriods = new ArrayList<>();
            isDiscountPeriods.addAll(orderSubInit.getIsDiscountPeriods());
            isDiscountPeriods.add(false);
            orderSubInit.setIsDiscountPeriods(isDiscountPeriods);

            List<Integer> prEa = new ArrayList<>();
            prEa.addAll(orderSubInit.getPrEa());
            prEa.add(1);
            orderSubInit.setPrEa(prEa);
        }
    }

    public void adjustedPrice(List<BoxItem> boxItems){
        boolean isEventProduct = false;
        for(BoxItem boxItem : boxItems) {
            if(boxItem.getProductCode().equalsIgnoreCase(eventProducts3) || boxItem.getProductCode().equalsIgnoreCase(eventProducts5)) {
                isEventProduct = true;
                break;
            }
        }

        if(isEventTime() && isEventProduct) {
            // 사은품 가격 1$로 변경
            boxItems.stream().forEach(i -> {
                if(isEventProduct(i.getProductCode()))
                    boxRepository.updateBoxItemAmount(i.getBoxPk(), i.getProductCode(), 1.00);
            });

            // 사은품 제외한 1$ 이상인 상품 중 한 상품 가격을 "상품 가격 - 1$"로 변경
            for(BoxItem boxItem : boxItems){
                if(!isEventProduct(boxItem.getProductCode()) && boxItem.getAmount() > 1) {
                    boxRepository.updateBoxItemAmount(boxItem.getBoxPk(), boxItem.getProductCode(), boxItem.getAmount() - 1.00);
                    break;
                }
            }
        }
    }

    /**
     *
     * 작성자 : dave
     * 날짜 : 2017. 6. 27.
     *
     * redis에서 이전 사은품 코드를 갖고와서 다음 사은품 코드를 리턴해줌
     *
     * FRPBMZTOP0002 무지
     * FRPBAPTOP0003 어피치
     * FRPBTBTOP0004 튜브
     * FRPBRYTOP0005 라이언
     *
     * @return 사은품 코드
     */
    public String getEventProduct(OrderResultDto.OrderSubInit orderSubInit){
        String eventPrCode = "";
        if (eventTotalSalesMoney >= 30000 && eventTotalSalesMoney < 50000) {
            eventPrCode = getRandomProduct(eventProducts3);
        } else if (eventTotalSalesMoney >= 50000) {
            eventPrCode = getRandomProduct(eventProducts5);
        }

        return eventPrCode;
    }

    protected void setTotalSalesMoney(OrderResultDto.OrderSubInit orderSubInit) {
        eventTotalSalesMoney = 0;
        if(orderSubInit.getPrCodes() != null && orderSubInit.getPrCodes().size() > 0) {
            List<ProductExpansion> productExpansions = productRepository.findByPrCodes(orderSubInit.getPrCodes());
            for (int i = 0; i < productExpansions.size(); i++) {
                ProductExpansion productExpansion = productExpansions.get(i);
                eventTotalSalesMoney += productExpansion.getProductLevelPrice().getPrlpSaleprice1() * (orderSubInit.getPrEa().get(i));
            }
        }
    }

    protected String getRandomProduct(String prCode) {
        String eventPrCode = "";
        String eventPrName = "";
        long prCount = 0;

        ProductExpansion eventProduct = productRepository.viewEventGlobalProductByPrCode(prCode);
        if (eventProduct.getProduct().getPrStock() > 0) {
            eventPrCode = eventProduct.getProduct().getPrCode();
            eventPrName = eventProduct.getProduct().getPrName();
            prCount = eventProduct.getProduct().getPrStock();
        }

        sendStockSms(prCode, prCount, eventPrName);

        return eventPrCode;
    }

    protected void sendStockSms(String eventPrCode, long prCount, String eventPrName) {
        if (!eventPrCode.equals("")) {
            try {
                if (active.equals("production") && (prCount % 50) == 0) {
                    kakaoIntegratedMessagingComponent.sendAdminSms("010-5494-8135", adminSmsMessage(eventPrCode, prCount, eventPrName));
                }
            } catch (Exception e) {
                log.error(">>> sendStockSms Exception : " + e.getMessage());
            }
        }
    }

    public boolean isEventProduct(String prCode){
        if(prCode.equalsIgnoreCase(eventProducts3) || prCode.equalsIgnoreCase(eventProducts5))
            return true;

        return false;
    }


    public boolean isEventTime(){
//        LocalDate current = LocalDate.now();
//        LocalDate startDate = LocalDate.of(2017, 9, 3); // 시작일 미정
//        LocalDate endDate = LocalDate.of(2017, 10, 9);
//
//        if((current.isEqual(startDate) || current.isAfter(startDate)) && (current.isEqual(endDate) || current.isBefore(endDate))) {
//            return true;
//        }
        return false;
    }

    public void addBoxItem(LinkedList<BoxItem> itemList) {
        if (isEventTime()) {
            List<String> prCodes = new ArrayList<>();
            int idx = 0;
            for(BoxItem boxItem : itemList) {
                prCodes.add(idx, boxItem.getProductCode());
                idx++;
            }

            eventTotalSalesMoney = 0;
            if(prCodes != null && prCodes.size() > 0) {
                List<ProductExpansion> productExpansions = productRepository.findByPrCodes(prCodes);
                for (int i = 0; i < productExpansions.size(); i++) {
                    ProductExpansion productExpansion = productExpansions.get(i);
                    eventTotalSalesMoney += productExpansion.getProductLevelPrice().getPrlpSaleprice1() * (itemList.get(i).getEa());
                }
            }


            if(isEventTime() && eventTotalSalesMoney >= 30000) {
                Product product = new Product();
                product.setPrHeight(110);
                product.setPrWidth(224);
                product.setPrDepth(28);
                product.setPrWeight(124);
                if (eventTotalSalesMoney >= 30000 && eventTotalSalesMoney < 50000) {
                    product.setPrCode(eventProducts3); // 박스 측정 할땐 임시로 상품 코드값 고정
                } else if (eventTotalSalesMoney >= 50000) {
                    product.setPrCode(eventProducts5); // 박스 측정 할땐 임시로 상품 코드값 고정
                }

                product.setPrName("쿠폰");
                product.setPrName1("Passport Wallet");

                itemList.add(new BoxItem(product,1, null));
            }
        }
    }

    /**
     * 9월 글로벌 무료 배송 이벤트
     * 100달러 기준
     * @return
     */
    private long getGlobalEventFreeDeliDollar() {
        return Math.round(exchangeRateComponent.getExchangeRate() * 100d );
    }

    /**
     * 관리자SMS 발송 메시지 작성 -- 임시 기능임
     * @param prCode
     * @param prCount
     * @return
     */
    protected String adminSmsMessage(String prCode, long prCount, String prName) {
        DecimalFormat df = new DecimalFormat("#,###");

        String messageStr = "사은품 : " + prName + "(" + prCode + ")\n";
        messageStr += "재고수 : " + df.format(prCount) + "\n";

        return messageStr;
    }

    public EventDto getAddPointEvent(EventDto eventDto) {
        return null;
    }
}
