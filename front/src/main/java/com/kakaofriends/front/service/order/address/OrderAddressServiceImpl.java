package com.kakaofriends.front.service.order.address;

import com.kakaofriends.core.common.configuration.persistence.type.DeliInOutType;
import com.kakaofriends.front.common.constants.Usable;
import com.kakaofriends.front.domain.Country;
import com.kakaofriends.front.domain.order.OrderAddressData;
import com.kakaofriends.front.repository.order.OrderAddressRepository;
import com.kakaofriends.front.service.order.constants.OrderAddressType;
import com.kakaofriends.front.service.order.vo.OrderAddress;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * OrderAddressService : 주문 배송지에 대한 비즈니스 로직을 처리하는 서비스
 *
 * Author  april
 * Date    2018. 1. 29.
 */
@Service
@Slf4j
@AllArgsConstructor(onConstructor = @_(@Autowired))
public class OrderAddressServiceImpl implements OrderAddressService {
    private OrderAddressRepository orderAddressRepository;

    @Override
    @Transactional(readOnly = true)
    public OrderAddress get(String orderNumber) {
        OrderAddressData data = orderAddressRepository.select(orderNumber);
        return this.converts(data);
    }

    @Override
    @Transactional
    public void add(OrderAddress orderAddress) {
        log.info("#### PARAM : {}", orderAddress);
        orderAddressRepository.insert(this.converts(orderAddress));
    }

    private OrderAddressData converts(OrderAddress address) {
        OrderAddressData data = new OrderAddressData();
        data.setOaUse(address.getUse().getCode());
        data.setOaSeq(address.getSequence());
        data.setOaOmNum(address.getOrderNumber());
        data.setOaName(address.getName());
        data.setOaAddr1(address.getAddress1());
        data.setOaAddr2(address.getAddress2());
        data.setOaAddr3(address.getAddress3());
        data.setOaCountryCode(address.getCountry().getCode());
        data.setOaCountryName(address.getCountry().getCountryName());
        data.setOaPhone(address.getPhone());
        data.setOaEmail(address.getEmail());
        data.setOaType(address.getDeliveryType().getCode());
        data.setOaZoneCode(address.getZipCode());
        data.setOaZipCode(address.getZipCode());
        data.setOaDeliMemo(address.getDeliveryMemo());
        data.setOaMoId(address.getModifiedId());
        data.setOaInId(address.getInsertedId());
        data.setOaOrdererTel(address.getBuyerPhone());
        data.setOaOrdererEmail(address.getBuyerEmail());
        data.setOaAddressType(address.getType().getCode());
        data.setOaBuyerName(address.getBuyerName());
        data.setOaBuyerPhone(address.getBuyerPhone());
        data.setOaBuyerEmail(address.getBuyerEmail());
        data.setOaBuyerCountryCode(address.getBuyerCountry().getCode());
        data.setOaBuyerCountryName(address.getBuyerCountry().getCountryName());
        return data;
    }

    private OrderAddress converts(OrderAddressData data) {
        OrderAddress address = new OrderAddress();
        address.setSequence(data.getOaSeq());
        address.setOrderNumber(data.getOaOmNum());
        address.setCountry(Country.getCountry(data.getOaCountryCode()));
        address.setName(data.getOaName());
        address.setAddress1(data.getOaAddr1());
        address.setAddress2(data.getOaAddr2());
        address.setAddress3(data.getOaAddr3());
        address.setDeliveryType(DeliInOutType.get(data.getOaType()));
        address.setZipCode(data.getOaZipCode());
        address.setPhone(data.getOaPhone());
        address.setEmail(data.getOaEmail());
        address.setDeliveryMemo(data.getOaDeliMemo());
        address.setBuyerName(data.getOaBuyerName());
        address.setBuyerPhone(data.getOaBuyerPhone());
        address.setBuyerEmail(data.getOaBuyerEmail());
        address.setBuyerCountry(Country.getCountry(data.getOaBuyerCountryCode()));
        address.setType(OrderAddressType.get(data.getOaAddressType()));
        address.setUse(Usable.get(data.getOaUse()));
        address.setModifiedId(data.getOaMoId());
        address.setInsertedId(data.getOaInId());
        address.setModifiedDate(data.getOaMoDate());
        address.setInsertedDate(data.getOaInDate());
        return address;
    }
}
