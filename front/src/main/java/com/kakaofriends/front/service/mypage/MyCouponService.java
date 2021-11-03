package com.kakaofriends.front.service.mypage;


import com.kakaofriends.core.common.pagination.PaginationInfo;
import com.kakaofriends.front.domain.mypage.TbKfoMbsCouponHistory;

import java.util.List;
import java.util.Map;

/**
 * 마이페이지 쿠폰 layla.rae 2017.10.25
 */
public interface MyCouponService {

    List<TbKfoMbsCouponHistory> myAvailableCouponList(String userId); // 사용가능 쿠폰 정보

    List<TbKfoMbsCouponHistory> myCouponHistory(String userId, PaginationInfo pagination); // 쿠폰 히스토리내역

    Map<String, Object> confirmOnlineCouponNumber(String couponNum); // 나의 지류쿠폰 확인

    int myCouponHistoryAllCount(String userId); // 쿠폰내역 Count

    int myCouponInsert(TbKfoMbsCouponHistory kfoMbsCouponHistory); // 온라인쿠폰 등록 (지류 Num)

    int myAvailableCouponUpdate(TbKfoMbsCouponHistory.Request request); // 온라인쿠폰 상태 업데이트 (사용자가 쿠폰 삭제 했을 시)

    int myAvailableCouponHistoryInsert(TbKfoMbsCouponHistory.Request request); // 쿠폰상태 업데이트 후 히스토리 쌓음

    List<String> getMyAvailableCouponCategoryListByPrct(List<String> bsPrCodes, int categoryNum); //카테고리 쿠폰 중 상품과 비교 후 사용 가능 쿠폰 추출
}