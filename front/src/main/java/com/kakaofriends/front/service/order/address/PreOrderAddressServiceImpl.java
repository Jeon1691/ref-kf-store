package com.kakaofriends.front.service.order.address;

import com.kakaofriends.front.domain.Country;
import com.kakaofriends.front.domain.order.PreOrderAddressData;
import com.kakaofriends.front.repository.order.PreOrderAddressRepository;
import com.kakaofriends.front.service.order.constants.OrderAddressType;
import com.kakaofriends.front.service.order.vo.PreOrderAddress;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * PreOrderAddressServiceImpl
 *
 * Author  april
 * Date    2018. 3. 20.
 */
@Slf4j
@Service
@AllArgsConstructor(onConstructor = @_(@Autowired))
public class PreOrderAddressServiceImpl implements PreOrderAddressService {
    private PreOrderAddressRepository preOrderAddressRepository;

    @Override
    public PreOrderAddress get(String orderNumber) {
        PreOrderAddressData data = preOrderAddressRepository.select(orderNumber);
        return this.converts(data);
    }

    @Override
    @Transactional
    public void add(PreOrderAddress orderAddress) {
        preOrderAddressRepository.insert(this.converts(orderAddress));
    }

    private PreOrderAddressData converts(PreOrderAddress address) {
        PreOrderAddressData data = new PreOrderAddressData();
        data.setOrderId(address.getOrderNumber());
        data.setUse(address.getUse());
        data.setName(address.getName());
        data.setAddress1(address.getAddress1());
        data.setAddress2(address.getAddress2());
        data.setAddress3(address.getAddress3());
        data.setZipCode(address.getZipCode());
        data.setPhone(address.getPhone());
        data.setEmail(address.getEmail());
        data.setCountry(address.getCountry().getCode());
        data.setDomestic(address.getDomestic());
        data.setDeliveryMemo(address.getDeliveryMemo());
        data.setBuyerName(address.getBuyerName());
        data.setBuyerPhone(address.getBuyerPhone());
        data.setBuyerEmail(address.getBuyerEmail());
        data.setBuyerCountry(address.getBuyerCountry().getCode());
        data.setAddressType(address.getAddressType().getCode());
        data.setCreateId(address.getCreateId());
        data.setUpdateId(address.getUpdateId());
        return data;
    }

    private PreOrderAddress converts(PreOrderAddressData data) {
        PreOrderAddress address = new PreOrderAddress();
        address.setOrderNumber(data.getOrderId());
        address.setUse(data.getUse());
        address.setName(data.getName());
        address.setAddress1(data.getAddress1());
        address.setAddress2(data.getAddress2());
        address.setAddress3(data.getAddress3());
        address.setZipCode(data.getZipCode());
        address.setPhone(data.getPhone());
        address.setEmail(data.getEmail());
        address.setCountry(Country.getCountry(data.getCountry()));
        address.setDomestic(data.getDomestic());
        address.setDeliveryMemo(data.getDeliveryMemo());
        address.setBuyerName(data.getBuyerName());
        address.setBuyerPhone(data.getBuyerPhone());
        address.setBuyerEmail(data.getBuyerEmail());
        address.setBuyerCountry(Country.getCountry(data.getBuyerCountry()));
        address.setAddressType(OrderAddressType.get(data.getAddressType()));
        address.setCreateId(data.getCreateId());
        address.setUpdateId(data.getUpdateId());
        address.setCreateDate(data.getCreateDate());
        address.setUpdateDate(data.getUpdateDate());
        return address;
    }
}
