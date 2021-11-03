package com.kakaofriends.front.service.mypage;


import com.kakaofriends.front.domain.Member;
import com.kakaofriends.front.domain.mypage.TbKfoMbsCouponHistory;
import com.kakaofriends.front.domain.mypage.TbKfoMbsPoint;
import com.kakaofriends.front.repository.MbsTestRepository;
import com.kakaofriends.front.repository.MyPointRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 멤버십 테스트 화면 layla.rae 2017.11.15
 */
@Slf4j
@Service
public class MbsTestServiceImpl implements MbsTestService {

    @Autowired
    private MbsTestRepository mbsTestRepository;

    @Autowired
    private MyPointRepository myPointRepository;

    @Override
    public List<Member> userList() {
        return mbsTestRepository.userList();
    }

    @Override
    public List<Map<String, Object>> categoryList() {
        return mbsTestRepository.categoryList();
    }

    @Override
    public int addPoint(TbKfoMbsPoint testPoint) {
        return mbsTestRepository.addPoint(testPoint);
    }

    @Override
    public List<TbKfoMbsCouponHistory> masterList() {
        return mbsTestRepository.masterList();
    }

    @Override
    public TbKfoMbsCouponHistory selectMasterCodeInfo(String gcmCode) {
        return mbsTestRepository.selectMasterCodeInfo(gcmCode);
    }

    @Override
    public int addMasterCoupon(TbKfoMbsCouponHistory testMasterCoupon) {
        return mbsTestRepository.addMasterCoupon(testMasterCoupon);
    }

    @Override
    public int addSubCoupon(TbKfoMbsCouponHistory testSubCoupon) {
        return mbsTestRepository.addSubCoupon(testSubCoupon);
    }

    @Override
    public int insertUserCouponHistory(TbKfoMbsCouponHistory userCouponHistory) {
        return mbsTestRepository.insertUserCouponHistory(userCouponHistory);
    }
}
