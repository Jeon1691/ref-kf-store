package com.kakaofriends.front.service.mypage;


import com.kakaofriends.front.domain.Member;
import com.kakaofriends.front.domain.mypage.TbKfoMbsCouponHistory;
import com.kakaofriends.front.domain.mypage.TbKfoMbsPoint;

import java.util.List;
import java.util.Map;

/**
 /**
 * 멤버십 테스트 화면 layla.rae 2017.11.15
 */
public interface MbsTestService {

    List<Member> userList();

    List<Map<String, Object>> categoryList();

    int addPoint(TbKfoMbsPoint testPoint);

    List<TbKfoMbsCouponHistory> masterList();

    TbKfoMbsCouponHistory selectMasterCodeInfo(String gcmCode);

    int addMasterCoupon(TbKfoMbsCouponHistory testMasterCoupon);

    int addSubCoupon(TbKfoMbsCouponHistory testSubCoupon);

    int insertUserCouponHistory(TbKfoMbsCouponHistory userCouponHistory);
}