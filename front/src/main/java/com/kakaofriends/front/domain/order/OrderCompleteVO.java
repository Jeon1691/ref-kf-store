package com.kakaofriends.front.domain.order;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.kakaofriends.core.common.configuration.persistence.type.ShippingStatusType;
import com.kakaofriends.core.domain.OrderAddDeli;
import com.kakaofriends.front.domain.BasketVO;
import com.kakaofriends.front.domain.Member;
import com.kakaofriends.front.domain.MemberAddress;
import com.kakaofriends.front.domain.common.CountryVO;
import com.kakaofriends.front.domain.mypage.MembershipVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * OrderCompleteVO
 *
 * Author  layla
 * Date    2018. 01. 11.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderCompleteVO implements Serializable {
    private String productName;
    private String oaAddressType;
    private String oaCountryName;
    private String memberId;
    private Member member;
    private String memberCountryName;
    private String memberEmail;
    private String memberEmailDomain;
    private MemberAddress memberAddress;
    private double exchangeRate;
    private boolean isAnonymousUser;

    private OrderShippingInfo orderShippingInfo;
    private ShippingStatusType shippingStatusType;
    private OrderAddDeli orderAddDeli;

    private double exchangeProdAmountCharge;
    private double exchangeDiscountMoney;
    private double exchangeDeliveryMoney;
    private double exchangeTotalMoney;

    private OrderCommonVO orderCommonVO;
    private BasketVO basketVO;
    private CountryVO countryVO;
    private MembershipVO membershipVO;

    private String errMsg;
    private String complete;
    private boolean cancelResult;
    private String statusChangedFail;
}
