package com.kakaofriends.front.domain.mypage;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * MembershipVO
 *
 * Author  layla
 * Date    2018. 01. 10.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MembershipVO implements Serializable {
    private double pointPrice;
    private boolean pointPriceUse;
    private double exchangePointPrice;
    private int myAvailableCouponCount;
    private List<TbKfoMbsCouponHistory> myAvailableCouponList;
}
