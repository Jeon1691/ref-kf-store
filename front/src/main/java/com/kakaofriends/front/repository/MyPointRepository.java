package com.kakaofriends.front.repository;

import com.kakaofriends.core.common.pagination.PaginationInfo;
import com.kakaofriends.front.common.annotation.PrimaryMapper;
import com.kakaofriends.front.domain.mypage.TbKfoMbsPoint;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 마이페이지 포인트 layla.rae 2017.10.20
 */
@Repository
@PrimaryMapper
public interface MyPointRepository {

    List<TbKfoMbsPoint> myPointHistory(@Param("userId") String userId, @Param("pagination") PaginationInfo pagination); // 포인트 히스토리내역

    Map<String, Object> getMyPointInfo(String userId); // 나의 포인트정보 가져오기 소멸예정포인트 등

    int myPointHistoryAllCount(String userId); // 포인트내역 Count

    int myPointInsert(TbKfoMbsPoint kfoMbsPoint); // 포인트 등록

    double getAvailablePointByUser(String userId);

    List<TbKfoMbsPoint> listAvailablePointByUser(String userId);

    List<TbKfoMbsPoint> listAddablePointByUser(String userId);

    int getMaxSeqMemberPoint();

    void modifyPointByUse(TbKfoMbsPoint tbKfoMbsPoint);

    int registPointByUser(TbKfoMbsPoint mbsPoint);

    List<TbKfoMbsPoint> usrPointExpirationList(); // 포인트 만료 리스트

    int usrPointExpirationListInsert(); // 포인트 만료 적용

    TbKfoMbsPoint myPointHistoryOrderTitle(String omNum); // 포인트 사용내역의 주문정보 타이틀
}