package com.kakaofriends.front.service.giftcard;

import com.kakaofriends.front.domain.GiftCardExpansion;
import com.kakaofriends.front.domain.mypage.TbKfoMbsCouponHistory;
import com.kakaofriends.front.service.giftcard.vo.GiftCard;

import java.util.List;
import java.util.Map;

/**
 * Created by dominic.lee on 2016. 10. 23..
 */
public interface GiftCardService {

    GiftCardExpansion findOneByGiftCardCode(String gcCode);

    Map<String, Object> confirmGiftCardNumber(String language, String couponNum, int totalAmt, int totalAmtNoDeli);

    GiftCardExpansion findOneByGiftPointCardCode(String gcCode); // 마이페이지 포인트 쿠폰 유효체크 2017.10.23

    TbKfoMbsCouponHistory findOneByOnlineCouponCode(String gcCode); // 마이페이지 온라인 지류 쿠폰 유효체크 2017.10.30

    /**
     * 쿠폰을 조회한다.
     *
     * @param giftCardCode 쿠폰 코드
     * @return 쿠폰 정보
     */
    GiftCard get(String giftCardCode);

    /**
     * 쿠폰과 쿠폰 마스터 정보를 함께 조회한다.
     *
     * @param giftCardCode 쿠폰 코드
     * @return 쿠폰 정보와 매핑되는 쿠폰 마스터 정보
    */
    GiftCard getWithMaster(String giftCardCode);

    /**
     * 쿠폰을 수정한다.
     *
     * @param giftCard 쿠폰 정보
     */
    void edit(GiftCard giftCard);

    /**
     * 쿠폰을 사용한다.
     * @param memberId 회원 아이디
     * @param orderNumber 주문 번호
     * @param codeList 쿠폰번호 리스트
     */
    void redeemGiftCard(Long memberId, String orderNumber, List<String> codeList);

    /**
     * 사용할 수 있는 쿠폰을 입력했는지 유효성 검사한다
     *  1. 기프트카드가 유효한지 확인한다.(사용여부/사용기한)
     *  2. 2장 사용할 경우 중복쿠폰인지 확인한다.
     *
     * @param giftCardCodeList 쿠폰코드 리스트
     */
    void validate(List<String> giftCardCodeList);
}
