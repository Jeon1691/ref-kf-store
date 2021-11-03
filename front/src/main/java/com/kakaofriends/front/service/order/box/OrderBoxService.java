package com.kakaofriends.front.service.order.box;

import com.kakaofriends.core.common.configuration.persistence.type.DeliInOutType;
import com.kakaofriends.front.common.external.ExchangeRateComponent;
import com.kakaofriends.front.domain.BoxItem;
import com.kakaofriends.front.repository.BoxRepository;
import com.kakaofriends.front.service.order.vo.OrderMain;
import com.kakaofriends.front.service.order.vo.OrderSub;
import com.kakaofriends.front.service.product.ProductService;
import com.kakaofriends.front.service.product.vo.Product;
import com.kakaofriends.front.utils.BoxUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * OrderBoxService :  기존 박스에 상품을 담는 로직을 옮겨온 서비스
 *
 * Author  april
 * Date    2018. 1. 30.
 */
@Service
@Slf4j
@AllArgsConstructor(onConstructor = @_(@Autowired))
public class OrderBoxService {
    private ExchangeRateComponent exchangeRateComponent;
    private ProductService productService;
    private BoxRepository boxRepository;

    @Transactional
    public void add(OrderMain orderMain, List<OrderSub> orderSubList) {
        DeliInOutType delivery = orderMain.getDeliveryInOutType();

        if (delivery.equals(DeliInOutType.OVERSEAS)) {
            BigDecimal currentUsd = exchangeRateComponent.get();
            // 박스정보 묶기
            BoxUtil boxUtil = new BoxUtil();
            ArrayList<BoxItem> boxes = boxUtil.getBoxs(getItemList(orderSubList, currentUsd), orderMain.getOrderNumber());

            // 박스 및 박스 item 정보 insert
            boxes.forEach(box -> {
                box.setBoxPk(box.getOrderPk() + "-" + box.getSeq());
                box.setItemName(box.getItemList().get(0).getItemName() + (box.getItemList().size() > 1 ? " and others (" + String.valueOf(box.getItemList().stream().count() - 1) + ")" : ""));
                log.info("#### orderBox : {}", box);
                boxRepository.orderBoxInsert(box);
                box.getItemList().forEach(item -> {
                    item.setBoxPk(box.getBoxPk());
                    log.info("#### orderBoxItem : {}", item);
                    boxRepository.orderItemInsert(item);
                });
            });
        }
    }

    private LinkedList<BoxItem> getItemList(List<OrderSub> orderSubList, BigDecimal currentUsd) {
        LinkedList<BoxItem> itemList = new LinkedList<>();

        orderSubList.forEach(e -> {
            BigDecimal amount = e.getSaleMoney();
            for(int i=0; i< e.getEa(); i++){
                if (e.getProductCode() != null) {
                    Product product = productService.get(e.getProductCode());
                    itemList.add(new BoxItem(product, amount.divide(currentUsd, 2, RoundingMode.HALF_UP).longValue() , String.valueOf(e.getSequence())));
                }
            }
        });
        return itemList;
    }
}
