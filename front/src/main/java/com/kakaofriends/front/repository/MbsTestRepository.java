package com.kakaofriends.front.repository;

import com.kakaofriends.front.common.annotation.PrimaryMapper;
import com.kakaofriends.front.domain.Member;
import com.kakaofriends.front.domain.mypage.TbKfoMbsCouponHistory;
import com.kakaofriends.front.domain.mypage.TbKfoMbsPoint;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 멤버십 테스트 화면 layla.rae 2017.11.15
 */
@Repository
@PrimaryMapper
public interface MbsTestRepository {

    List<Member> userList();

    List<Map<String, Object>> categoryList();

    int addPoint(TbKfoMbsPoint testPoint);

    List<TbKfoMbsCouponHistory> masterList();

    TbKfoMbsCouponHistory selectMasterCodeInfo(String gcmCode);

    int addMasterCoupon(TbKfoMbsCouponHistory testMasterCoupon);

    int addSubCoupon(TbKfoMbsCouponHistory testSubCoupon);

    int insertUserCouponHistory(TbKfoMbsCouponHistory userCouponHistory);
}