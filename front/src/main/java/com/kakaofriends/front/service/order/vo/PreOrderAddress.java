package com.kakaofriends.front.service.order.vo;

import com.kakaofriends.front.controller.order.vo.OrderPreparation;
import com.kakaofriends.front.domain.Country;
import com.kakaofriends.front.service.order.constants.OrderAddressType;
import com.kakaofriends.front.utils.FriendsUtil;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * PreOrderAddress
 *
 * Author  april
 * Date    2018. 3. 20.
 */
@Data
@NoArgsConstructor
public class PreOrderAddress {
    private String orderNumber;
    private Boolean use;
    private String name;
    private String address1;
    private String address2;
    private String address3;
    private String zipCode;
    private String phone;
    private String email;
    private Country country;
    private Boolean domestic;
    private String deliveryMemo;
    private String buyerName;
    private String buyerPhone;
    private String buyerEmail;
    private Country buyerCountry;
    private OrderAddressType addressType;
    private String createId;
    private String updateId;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    private void setAddress(Country country, String state, String address, String detailAddress) {
        switch (country) {
            case Korea:
                this.setAddress1(address);
                this.setAddress2(detailAddress);
                this.setDomestic(Boolean.TRUE);
                break;
            default:
                this.setAddress1(state);
                this.setAddress2(address);
                this.setAddress3(detailAddress);
                this.setDomestic(Boolean.FALSE);
                break;
        }
        this.setCountry(country);
    }

    public PreOrderAddress(OrderPreparation preparation) {
        String memberId = FriendsUtil.getFriendsMemberId();
//        orderAddress.setMemberId(memberId);
        this.setCreateId(memberId);
        this.setUpdateId(memberId);
        this.setName(preparation.getReceiverName());
        this.setAddress(Country.getCountry(preparation.getReceiverCountry()), preparation.getReceiverState(),
                preparation.getReceiverAddress(), preparation.getReceiverDetailAddress());
        this.setZipCode(preparation.getReceiverZipCode());
        this.setPhone(preparation.getReceiverPhone());
        this.setEmail(preparation.getBuyerEmail());
        this.setDeliveryMemo(preparation.getDeliveryMemo());
        this.setBuyerName(preparation.getBuyerName());
        this.setBuyerPhone(preparation.getBuyerPhone());
        this.setBuyerEmail(preparation.getBuyerEmail());
        this.setBuyerCountry(Country.getCountry(preparation.getBuyerCountry()));
        this.setAddressType(OrderAddressType.get(preparation.isDefaultAddress()));
    }
}