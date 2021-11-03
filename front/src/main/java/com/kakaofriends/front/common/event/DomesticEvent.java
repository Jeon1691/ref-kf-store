package com.kakaofriends.front.common.event;

import com.kakaofriends.front.common.external.KakaoIntegratedMessagingComponent;
import com.kakaofriends.front.domain.EventDto;
import com.kakaofriends.front.domain.order.OrderResultDto;
import com.kakaofriends.front.domain.product.ProductExpansion;
import com.kakaofriends.front.repository.ProductRepository;
import com.kakaofriends.front.service.EventService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.kakaofriends.front.domain.EventDto.EVENT_USE_FLAG;

@Component
public class DomesticEvent extends GlobalEmsEvent {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private KakaoIntegratedMessagingComponent kakaoIntegratedMessagingComponent;

    @Autowired
    private EventService eventService;

    @Value("${active}")
    private String active;

    /**
     * 3만원 사은품
     */
    private String eventProducts3 = "ONLINEGWP0005";

    /**
     * 5만원 사은품
     */
    private String eventProducts5 = "ONLINEGWP0006";

    @Override
    public void addEventProduct(OrderResultDto.OrderSubInit orderSubInit){
        setTotalSalesMoney(orderSubInit);
        String eventCode = getEventProduct(orderSubInit);

        if(isEventTime() && eventTotalSalesMoney >= 30000 && StringUtils.isNotEmpty(eventCode)){
            // 모바일 이니시스인 경우 list들이 Arrays.asList 로 만들어져서 add, remove가 안되기 때문에 새로 객체 만들어서 넣어줌
            List<String> prCodes = new ArrayList<>();
            prCodes.addAll(orderSubInit.getPrCodes());
            prCodes.add(eventCode);
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

    @Override
    public String getEventProduct(OrderResultDto.OrderSubInit orderSubInit){
        String eventPrCode = "";
        int totalMoney = 0;

        if(orderSubInit.getPrCodes() != null && orderSubInit.getPrCodes().size() > 0) {
            List<ProductExpansion> productExpansions = productRepository.findByPrCodes(orderSubInit.getPrCodes());

            for (int i = 0; i < productExpansions.size(); i++) {
                ProductExpansion productExpansion = productExpansions.get(i);
                totalMoney += productExpansion.getProductLevelPrice().getPrlpSaleprice1() * (orderSubInit.getPrEa().get(i));
            }
        }

        if (totalMoney >= 30000 && totalMoney < 50000) {
            eventPrCode = getRandomProduct(eventProducts3);
        } else if (totalMoney >= 50000) {
            eventPrCode = getRandomProduct(eventProducts5);
        }

        return eventPrCode;
    }

    @Override
    protected String getRandomProduct(String prCode) {
        String eventPrCode = "";

        ProductExpansion eventProduct = productRepository.viewEventProductByPrCode(prCode);
        if (eventProduct.getProduct().getPrStock() > 0) {
            eventPrCode = eventProduct.getProduct().getPrCode();
        }
        return eventPrCode;
    }

    /**
     * 이벤트 기간 여부 체크
     * @return
     */
    @Override
    public boolean isEventTime() {
        LocalDate current = LocalDate.now();
        LocalDate startDate = LocalDate.of(2017, 9, 23); // 시작일 미정
        LocalDate endDate = LocalDate.of(2017, 10, 9);

        if((current.isEqual(startDate) || current.isAfter(startDate)) && (current.isEqual(endDate) || current.isBefore(endDate))) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isEventProduct(String prCode){
        if(prCode.equalsIgnoreCase(eventProducts3) || prCode.equalsIgnoreCase(eventProducts5))
            return true;

        return false;
    }

    @Override
    public EventDto getAddPointEvent(EventDto eventDto) {
        return eventService.findEvent(eventDto.getOrderType(), eventDto.getEventType(), eventDto.getOrderPrice(), EVENT_USE_FLAG, eventDto.getEventDate());
    }
}
