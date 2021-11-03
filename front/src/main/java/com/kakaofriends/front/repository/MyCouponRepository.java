package com.kakaofriends.front.repository;

import com.kakaofriends.core.common.pagination.PaginationInfo;
import com.kakaofriends.front.common.annotation.PrimaryMapper;
import com.kakaofriends.front.domain.mypage.TbKfoMbsCouponHistory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@PrimaryMapper
public interface MyCouponRepository {

    List<TbKfoMbsCouponHistory> myAvailableCouponList(String userId); // 사용가능 쿠폰 정보

    List<TbKfoMbsCouponHistory> myCouponHistory(@Param("userId") String userId, @Param("pagination") PaginationInfo pagination); // 쿠폰 히스토리내역

    int myCouponHistoryAllCount(String userId); // 쿠폰내역 Count

    int myCouponInsert(TbKfoMbsCouponHistory kfoMbsCouponHistory); // 온라인쿠폰 등록 (지류 Num)

    int myAvailableCouponUpdate(TbKfoMbsCouponHistory.Request request); // 쿠폰상태 업데이트 (사용자가 쿠폰 삭제 했을 시)

    int myAvailableCouponHistoryInsert(TbKfoMbsCouponHistory.Request request); //

    List<TbKfoMbsCouponHistory> usrCouponExpirationList(); // 쿠폰 만료 리스트

    int usrCouponExpirationListInsert(); // 쿠폰 만료 적용

    TbKfoMbsCouponHistory myCouponHistoryOrderTitle(String omNum); // 쿠폰 사용내역의 주문정보 타이틀

    List<String> getMyAvailableCouponCategoryListByPrct(@Param(value = "bsPrCodes") List<String> bsPrCodes, @Param(value = "categoryNum") int categoryNum); //카테고리 쿠폰 중 상품과 비교 후 사용 가능 쿠폰 추출
}
