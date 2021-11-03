package com.kakaofriends.front.controller.mypage;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableMap;
import com.kakaofriends.core.common.pagination.PaginationInfo;
import com.kakaofriends.core.utils.KakaoFriendsConstants;
import com.kakaofriends.front.common.annotation.FriendsGlobal;
import com.kakaofriends.front.common.external.ExchangeRateComponent;
import com.kakaofriends.front.controller.common.PopupController;
import com.kakaofriends.front.controller.order.api.OrderAddDeliRestController;
import com.kakaofriends.front.domain.FriendsListing;
import com.kakaofriends.front.domain.Member;
import com.kakaofriends.front.domain.mypage.MyPointCode;
import com.kakaofriends.front.domain.mypage.TbKfoMbsPoint;
import com.kakaofriends.front.service.mypage.MyPointService;
import com.kakaofriends.front.utils.FriendsUtil;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.kakaofriends.core.utils.KakaoFriendsUtil.getPaginationInfo;
import static com.kakaofriends.front.utils.FriendsUtil.getFriendsMemberId;

@Slf4j
@Controller
@FriendsGlobal
@RequestMapping(value = "/{language}")
public class MyPointController extends MyPageTopController {

    @Autowired
    private MyPointService myPointService;

    @Autowired
    private ExchangeRateComponent exchangeRateComponent;

    @Autowired
    private PopupController popupController;

    // 마이페이지 - 포인트
    @RequestMapping(value = {"/mypage/pointlist", "/mypage/pointlist/pages/{pageIndex}"})
    public ModelAndView getCouponList(FriendsListing friendsListing) throws Exception {
        String ownerId = getFriendsMemberId();
        String contury = friendsListing.getLanguage();

        int totalCount = myPointService.myPointHistoryAllCount(ownerId);
        PaginationInfo pagination = getPaginationInfo(totalCount, friendsListing.getPageIndex(), KakaoFriendsConstants.pageUnitForOrders, KakaoFriendsConstants.pageSize);
        List<TbKfoMbsPoint> myPointHistoryList = myPointService.myPointHistory(ownerId, pagination);


        myPointHistoryList.forEach(e -> {
            String mpName = MyPointCode.getMyPointCodeName(e.getMP_TYPE(), contury);
            e.setMP_TYPE_NM(mpName);
            e.setTOTALMONEY_EXCHANGE(getExchangePrice(e.getTOTALMONEY()));
            e.setPAYMONEY_EXCHANGE(getExchangePrice(e.getPAYMONEY()));
        });

        ModelAndView mav = new ModelAndView();
        mav.addObject("pagination", pagination);
        mav.addObject("myPointInfo", myPointService.getMyPointInfo(ownerId));
        mav.addObject("myPointHistory", myPointHistoryList);
        mav.addObject("pageLink", "/" + contury + "/mypage/pointlist");

        Map[] pointHistory = popupController.getPointHistory();
        mav.addObject("pointHistory", pointHistory);

        String crmMembershipJson = popupController.getMembershipBarcode();
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        Map<String, Object> crmMembership = mapper.readValue(
                crmMembershipJson.getBytes(),
                new TypeReference<Map>() {
                }
        );
        mav.addObject("crmMembership", crmMembership);

        mav.setViewName(contury + "/mypage/pointlist");

        return mav;
    }


    // 유효 쿠폰 확인
    @ResponseBody
    @RequestMapping(value = "/mypage/applyPointCoupon")
    public Object confirmGiftPointCard(String couponNum) {
        String userId = getFriendsMemberId();
        return myPointService.confirmPointCouponNumber(couponNum, userId);
    }

    private double getExchangePrice(Integer price) {
        return Math.round(price / exchangeRateComponent.getExchangeRate() * 100d) / 100d;
    }
}