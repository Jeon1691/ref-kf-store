package com.kakaofriends.front.service.mypage;


import com.kakaofriends.core.common.pagination.PaginationInfo;
import com.kakaofriends.front.controller.order.validator.OrderValidator;
import com.kakaofriends.front.domain.mypage.TbKfoMbsCouponHistory;
import com.kakaofriends.front.repository.MyCouponRepository;
import com.kakaofriends.front.repository.giftcard.GiftCardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.kakaofriends.front.utils.FriendsUtil.getFriendsMemberId;

/**
 * 마이페이지 쿠폰 layla.rae 2017.10.25
 */
@Slf4j
@Service
public class MyCouponServiceImpl implements MyCouponService {

    @Autowired
    private MyCouponRepository myCouponRepository;

    @Autowired
    private GiftCardRepository giftCardRepository;

    @Autowired
    private OrderValidator orderValidator;

    /**
     * 사용가능쿠폰정보
     * @param userId
     * @return List<TbKfoMbsPoint>
     */
    @Override
    public List<TbKfoMbsCouponHistory> myAvailableCouponList(String userId) {
        return myCouponRepository.myAvailableCouponList(userId);
    }

    /**
     * 나의 쿠폰 내역
     * @param userId
     * @return List<TbKfoMbsPoint>
     */
    @Override
    public List<TbKfoMbsCouponHistory> myCouponHistory(String userId, PaginationInfo pagination) {
        List<TbKfoMbsCouponHistory> myCpHistory = myCouponRepository.myCouponHistory(userId, pagination);
        myCpHistory.forEach(e -> {
            if (e.getCPH_OMNUM() != null) {
                TbKfoMbsCouponHistory myCouponHistoryOrderTitle = myCouponRepository.myCouponHistoryOrderTitle(e.getCPH_OMNUM());

                int prcnt = myCouponHistoryOrderTitle.getOMCOUNT();
                String wprname = ((prcnt > 1 ) ? " 외 "+ (prcnt - 1) + "개" : "");
                String wprename = ((prcnt > 1 ) ? " and others " + (prcnt - 1): "");
                e.setCPH_TITLE(myCouponHistoryOrderTitle.getCPH_TITLE() + wprname);
                e.setCPH_ETITLE(myCouponHistoryOrderTitle.getCPH_ETITLE() + wprename);
            }
        });

        return myCpHistory;
    }

    /**
     * 나의 쿠폰 등록
     * @param couponNum
     * @return Map<String, Object>
     */
    @Override
    public Map<String, Object> confirmOnlineCouponNumber(String couponNum) {
        TbKfoMbsCouponHistory kfoMbsCouponHistory = giftCardRepository.findOneByOnlineCouponCode(couponNum);
        String userId = getFriendsMemberId();

        if (kfoMbsCouponHistory != null) {
            if ("1".equals(kfoMbsCouponHistory.getCPH_USE()) && !kfoMbsCouponHistory.getIsUsePeriodAfter() && !kfoMbsCouponHistory.getIsUsePeriodBefore()) {
                kfoMbsCouponHistory.setCPH_USERID(userId);
                myCouponRepository.myCouponInsert(kfoMbsCouponHistory);
                giftCardRepository.onlineCouponUpdateGcUse("4", userId, kfoMbsCouponHistory.getCPH_CODE(), userId);
            }
        }

        Map<String, Object> resultMap = new HashMap<>();
        String msg = orderValidator.getValidateMessageByMyOnlineCoupon(kfoMbsCouponHistory);
        resultMap.put("resultMsg", msg);
        return resultMap;
    }

    /**
     * 나의 쿠폰내역 전체카운드
     * @param userId
     * @return int
     */
    @Override
    public int myCouponHistoryAllCount(String userId) {
        return myCouponRepository.myCouponHistoryAllCount(userId);
    }

    /**
     * 나의 쿠폰 등록
     * @param kfoMbsCouponHistory
     * @return
     */
    @Override
    public int myCouponInsert(TbKfoMbsCouponHistory kfoMbsCouponHistory) {
        return myCouponRepository.myCouponInsert(kfoMbsCouponHistory);
    }

    /**
     * 온라인쿠폰 상태 업데이트
     * @param request
     * @return
     */
    @Override
    public int myAvailableCouponUpdate(TbKfoMbsCouponHistory.Request request) {
        request.setGcUserId(getFriendsMemberId());

        int updateRow = myCouponRepository.myAvailableCouponUpdate(request);

        if (updateRow != 0) {
            myCouponRepository.myAvailableCouponHistoryInsert(request);
        }

        return updateRow;
    }

    /**
     * 쿠폰상태 업데이트 후 히스토리 쌓음
     * @param request
     * @return
     */
    @Override
    public int myAvailableCouponHistoryInsert(TbKfoMbsCouponHistory.Request request) {
        return myCouponRepository.myAvailableCouponHistoryInsert(request);
    }

    @Override
    public List<String> getMyAvailableCouponCategoryListByPrct(List<String> bsPrCodes, int categoryNum) {
        return myCouponRepository.getMyAvailableCouponCategoryListByPrct(bsPrCodes, categoryNum);
    }
}
