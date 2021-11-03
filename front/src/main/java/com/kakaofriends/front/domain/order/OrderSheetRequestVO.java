package com.kakaofriends.front.domain.order;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.kakaofriends.front.domain.BasketVO;
import com.kakaofriends.front.domain.Member;
import com.kakaofriends.front.domain.MemberAddress;
import com.kakaofriends.front.domain.common.CountryVO;
import com.kakaofriends.front.domain.mypage.MembershipVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * OrderSheetRequestVO
 *
 * Author  layla
 * Date    2018. 01. 10.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderSheetRequestVO implements Serializable {
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
    private boolean anonymousUser;
    private List<OrderAddressDto.request> deliveryaddress;

    private OrderCommonVO orderCommonVO;
    private BasketVO basketVO;
    private CountryVO countryVO;
    private MembershipVO membershipVO;

    private String errMsg;
}
