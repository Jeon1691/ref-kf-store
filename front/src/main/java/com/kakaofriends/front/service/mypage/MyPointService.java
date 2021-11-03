package com.kakaofriends.front.service.mypage;


import com.kakaofriends.core.common.pagination.PaginationInfo;
import com.kakaofriends.front.domain.mypage.TbKfoMbsPoint;

import java.util.List;
import java.util.Map;

/**
 * 마이페이지 포인트 layla.rae 2017.10.20
 */
public interface MyPointService {

    List<TbKfoMbsPoint> myPointHistory(String userId, PaginationInfo pagination); // 포인트 사용/적립 리스트

    Map<String, Object> confirmPointCouponNumber(String couponNum, String userId); // 포인트쿠폰 확인

    Map<String, Object> getMyPointInfo(String userId); // 마이페이지 적립 포인트, 소멸 예정포인트, 소멸예정일

    int myPointHistoryAllCount(String userId);   // 포인트내역 Count

    int myPointInsert(TbKfoMbsPoint kfoMbsPoint); // 포인트 적립

    double getAvailablePointByUser(String userId);

    void modifyPointProcess(TbKfoMbsPoint mbsPoint);
}