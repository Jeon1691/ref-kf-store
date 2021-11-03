package com.kakaofriends.front.domain.order;

import com.daumcorp.commons.useragentutil.UserAgent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * OrderCommonVO
 *
 * Author  layla
 * Date    2018. 01. 11.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderCommonVO implements Serializable {
//    private String csrfToken;
//    private String headerName;

    private UserAgent userAgent;

    private String kakaoFriendsOnlineStore;

    private String pgKakaopayMerchantId;
    private String pgKakaopayMerchantUrl;
    private String pgKakaopayWebPath;
    private String pgKakaopayMsgName;
    private String pgKakaopayMerchantEncKey;
    private String pgKakaopayMerchantHashKey;

    private String paypalButton;

    private String friendsLocale;
}
