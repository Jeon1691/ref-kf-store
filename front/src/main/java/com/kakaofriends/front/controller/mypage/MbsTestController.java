/*
package com.kakaofriends.front.controller.mypage;

import com.kakaofriends.front.common.annotation.FriendsGlobal;
import com.kakaofriends.front.common.response.ApiSuccess;
import com.kakaofriends.front.domain.FriendsListing;
import com.kakaofriends.front.domain.mypage.TbKfoMbsCouponHistory;
import com.kakaofriends.front.domain.mypage.TbKfoMbsPoint;
import com.kakaofriends.front.service.MemberService;
import com.kakaofriends.front.service.mypage.MbsTestService;
import com.kakaofriends.front.service.mypage.MyCouponService;
import com.kakaofriends.front.service.mypage.MyPointService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

*/
/**
 * 멤버십 테스트 화면 layla.rae 2017.11.15
 *//*

@Slf4j
@Controller
@FriendsGlobal
@RequestMapping(value = "/{language}")
public class MbsTestController extends MyPageTopController {

    @Autowired
    private MyPointService myPointService;

    @Autowired
    private MyCouponService myCouponService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private MbsTestService mbsTestService;


    // 포인트 쿠폰 테스트페이자
    @RequestMapping(value = {"/testMbs"})
    public ModelAndView getCouponList(FriendsListing friendsListing) {
        String contury = friendsListing.getLanguage();

        ModelAndView mav = new ModelAndView();
        mav.addObject("userList", mbsTestService.userList());
        mav.addObject("categoryList", mbsTestService.categoryList());
        mav.addObject("masterList", mbsTestService.masterList());
        mav.addObject("examCouponNum", make());
        mav.setViewName(contury + "/mypage/testMbs");
        return mav;
    }

    // 포인트 등록
    @ResponseBody
    @RequestMapping(value = {"/addPoint"})
    public ResponseEntity<ApiSuccess> addPoint(String MP_USERID, String MP_AMOUNT, String MP_REST, String MP_SDATE, String MP_EDATE) {
        ApiSuccess apiSuccess = new ApiSuccess();

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String sTime = sdf.format(new java.util.Date());

        MP_SDATE = MP_SDATE + " " + sTime;
        MP_EDATE = MP_EDATE + " " + sTime;

        TbKfoMbsPoint testPoint = new TbKfoMbsPoint();
        testPoint.setMP_USERID(MP_USERID);
        testPoint.setMP_AMOUNT(Integer.parseInt(MP_AMOUNT));
        testPoint.setMP_REST(Integer.parseInt(MP_REST));
        testPoint.setMP_SDATE(java.sql.Timestamp.valueOf(MP_SDATE));
        testPoint.setMP_EDATE(java.sql.Timestamp.valueOf(MP_EDATE));
        mbsTestService.addPoint(testPoint);
        return new ResponseEntity<>(apiSuccess, new HttpHeaders(), apiSuccess.getStatus());
    }

    // 마스터코드 정보
    @ResponseBody
    @RequestMapping(value = {"/selectMasterCodeInfo"})
    public Map<String, Object> selectMasterCodeInfo(String GCM_CODE) {
        TbKfoMbsCouponHistory mInfo = mbsTestService.selectMasterCodeInfo(GCM_CODE);


        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String sdate = format.format(mInfo.getCPH_SDATE());
        String edate = format.format(mInfo.getCPH_EDATE());

        if (mInfo.getCPH_TYPE().equals("6")) {
            mInfo.setCPH_TYPE("N");
        } else {
            mInfo.setCPH_TYPE("Y");
        }

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("mData", mInfo);
        resultMap.put("mSdate", sdate);
        resultMap.put("mEdate", edate);
        return resultMap;
    }

    // 마스터쿠폰 등록
    @ResponseBody
    @RequestMapping(value = {"/addMasterCoupon"}, method = RequestMethod.POST)
    public ResponseEntity<ApiSuccess> addMasterCoupon(String CPH_GCMCODE, String CPH_NAME, String  CPH_ENAME, String  CPH_SDATE, String CPH_EDATE,
                                                      String CPH_PRICE, String CPH_DUPLICATION, String CPH_OPTION_TYPE, String CPH_OPTION_VALUE, String CPH_OPTION_CATEGORY, String CPH_PAPER) {
        ApiSuccess apiSuccess = new ApiSuccess();

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String sTime = sdf.format(new java.util.Date());

        CPH_SDATE = CPH_SDATE + " " + sTime;
        CPH_EDATE = CPH_EDATE + " " + sTime;

        TbKfoMbsCouponHistory testMasterCoupon = new TbKfoMbsCouponHistory();
        testMasterCoupon.setCPH_GCMCODE(CPH_GCMCODE);
        testMasterCoupon.setCPH_NAME(CPH_NAME);
        testMasterCoupon.setCPH_ENAME(CPH_ENAME);
        testMasterCoupon.setCPH_SDATE(java.sql.Timestamp.valueOf(CPH_SDATE));
        testMasterCoupon.setCPH_EDATE(java.sql.Timestamp.valueOf(CPH_EDATE));
        if (!CPH_PRICE.equals("")) {
            testMasterCoupon.setCPH_PRICE(Integer.parseInt(CPH_PRICE));
        }
        if (CPH_PAPER.equals("Y")) {
            testMasterCoupon.setCPH_TYPE("7");
        } else {
            testMasterCoupon.setCPH_TYPE("6");
        }
        testMasterCoupon.setCPH_DUPLICATION(CPH_DUPLICATION);
        testMasterCoupon.setCPH_OPTION_TYPE(CPH_OPTION_TYPE);
        testMasterCoupon.setCPH_OPTION_VALUE(CPH_OPTION_VALUE);
        if (!CPH_OPTION_CATEGORY.equals("")) {
            testMasterCoupon.setCPH_OPTION_CATEGORY(Integer.parseInt(CPH_OPTION_CATEGORY));
        }

        mbsTestService.addMasterCoupon(testMasterCoupon);
        return new ResponseEntity<>(apiSuccess, new HttpHeaders(), apiSuccess.getStatus());
    }

    // 서브쿠폰 등록
    @ResponseBody
    @RequestMapping(value = {"/addSubCoupon"}, method = RequestMethod.POST)
    public ResponseEntity<ApiSuccess> addSubCoupon(String m_name, String m_ename, String m_price, String m_duplication, String m_gcmcode, String m_optiontype,
                                                   String m_optionvalue, String m_optinoCategory, String m_sdate, String m_edate, String s_use_id, String c_code, String m_type) {
        ApiSuccess apiSuccess = new ApiSuccess();

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String sTime = sdf.format(new java.util.Date());

        m_sdate = m_sdate + " " + sTime;
        m_edate = m_edate + " " + sTime;

        TbKfoMbsCouponHistory testSubCoupon = new TbKfoMbsCouponHistory();
        testSubCoupon.setCPH_GCMCODE(m_gcmcode);
        testSubCoupon.setCPH_NAME(m_name);
        testSubCoupon.setCPH_ENAME(m_ename);
        testSubCoupon.setCPH_SDATE(java.sql.Timestamp.valueOf(m_sdate));
        testSubCoupon.setCPH_EDATE(java.sql.Timestamp.valueOf(m_edate));
        testSubCoupon.setCPH_PRICE(Integer.parseInt(m_price));
        testSubCoupon.setCPH_DUPLICATION(m_duplication);
        testSubCoupon.setCPH_OPTION_TYPE(m_optiontype);
        testSubCoupon.setCPH_OPTION_VALUE(m_optionvalue);
        testSubCoupon.setCPH_OPTION_CATEGORY(Integer.parseInt(m_optinoCategory));
        if (m_type.equals("N")) {
            testSubCoupon.setCPH_USERID(s_use_id);
            testSubCoupon.setCPH_TYPE("6");
        } else {
            testSubCoupon.setCPH_TYPE("7");
        }
        testSubCoupon.setCPH_CODE(c_code);

        mbsTestService.addSubCoupon(testSubCoupon);
        if (m_type.equals("N")) {
            mbsTestService.insertUserCouponHistory(testSubCoupon);
        }
        return new ResponseEntity<>(apiSuccess, new HttpHeaders(), apiSuccess.getStatus());
    }

    public String make() {
        StringBuffer value = new StringBuffer();
        Random rnd = new Random();
        for (int i = 1; i < 17; i++) {
            int rIndex = rnd.nextInt(3);
            switch (rIndex) {
                case 0:
                    // a-z
                    value.append((char) ((int) (rnd.nextInt(26)) + 97));
                    break;
                case 1:
                    // A-Z
                    value.append((char) ((int) (rnd.nextInt(26)) + 65));
                    break;
                case 2:
                    // 0-9
                    value.append((rnd.nextInt(10)));
                    break;
            }

            if (i%4 == 0 && i != 16) {
                value.append('-');
            }
        }
        return value.toString();
    }

}*/
