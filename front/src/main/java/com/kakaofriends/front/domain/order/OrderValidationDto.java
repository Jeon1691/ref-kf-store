package com.kakaofriends.front.domain.order;

import com.kakaofriends.front.domain.Member;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dominic.lee on 2016. 10. 22..
 */
@Data
@NoArgsConstructor
@ToString(of = { "bsSeqIds", "paymentAmount", "giftCardAmount", "pointPrice" })
public class OrderValidationDto implements Serializable {
    private static final long serialVersionUID = 2930189720039519952L;
    private static final String DELIMITER = ",";

    private Long basketAmount;     // 장바구니합계
    private Long deliveryAmount;   // 배송비
    private Long paymentAmount;    // 총결제금액
    private Long giftCardAmount;   // 쿠폰사용금액
    private String bsSeqList;
    private String giftCardNumber;
    @JsonIgnore private boolean owner;
    @JsonIgnore private boolean soldOut;
    @JsonIgnore private boolean unavailableProduct;
    private String mobileNotiParams;
    private Member member;
    private String friendsMemberId;
    private String payMethodType;
    private Long price;
    private Long Amt;
    private Long P_AMT;
    private String oaCountryName;

    private String odOmNum;        // 해당 상품 OrderNumber    (CS) SELECT
    private Integer odOsSeq;       // OrderAddDeli 시퀀스      (CS)
    private Integer odOsSerial;    // 해당 상품 OderSubSerial  (CS)

    private Long pointPrice;        // 포인트결제금액
    private List<String> giftCardCodes; //쿠폰리스트

    public List<String> getBsSeqIds() {
        return Arrays.asList(StringUtils.delimitedListToStringArray(this.bsSeqList, DELIMITER));
    }

}
