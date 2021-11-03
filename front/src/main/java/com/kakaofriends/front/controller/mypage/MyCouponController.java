package com.kakaofriends.front.controller.mypage;

import com.kakaofriends.core.common.pagination.PaginationInfo;
import com.kakaofriends.core.utils.KakaoFriendsConstants;
import com.kakaofriends.front.common.annotation.FriendsGlobal;
import com.kakaofriends.front.domain.FriendsListing;
import com.kakaofriends.front.domain.mypage.MyCouponCode;
import com.kakaofriends.front.domain.mypage.MyMbsGubun;
import com.kakaofriends.front.domain.mypage.TbKfoMbsCouponHistory;
import com.kakaofriends.front.service.mypage.MyCouponService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static com.kakaofriends.core.utils.KakaoFriendsUtil.getPaginationInfo;
import static com.kakaofriends.front.utils.FriendsUtil.getFriendsMemberId;

@Slf4j
@Controller
@FriendsGlobal
@RequestMapping(value = "/{language}")
public class MyCouponController extends MyPageTopController {

	@Autowired
	private MyCouponService myCouponService;

	// 쿠폰 화면
	@RequestMapping(value = {"/mypage/couponlist", "/mypage/couponlist/pages/{pageIndex}"})
	public ModelAndView getCouponList(FriendsListing friendsListing) {
		String ownerId = getFriendsMemberId();
		String contury = friendsListing.getLanguage();

		int totalCount = myCouponService.myCouponHistoryAllCount(ownerId);
		PaginationInfo pagination = getPaginationInfo(totalCount, friendsListing.getPageIndex(), KakaoFriendsConstants.pageUnitForCoupons, KakaoFriendsConstants.pageSize);

		List<TbKfoMbsCouponHistory> myAvailableCouponList = myCouponService.myAvailableCouponList(ownerId);
		List<TbKfoMbsCouponHistory> myCouponHistory = myCouponService.myCouponHistory(ownerId, pagination);

		myAvailableCouponList.forEach(e -> {
			String cphName = MyCouponCode.getMyCouponCodeName(e.getCPH_TYPE(), contury);
			String cphOptionName = MyCouponCode.getMyCouponCodeName(e.getCPH_OPTION_TYPE(), contury);
			e.setCPH_TYPE_NM(cphName);
			e.setCPH_OPTION_TYPE_NM(cphOptionName);
		});

		myCouponHistory.forEach(e -> {
			String cphName = MyCouponCode.getMyCouponCodeName(e.getCPH_TYPE(), contury);
			String cphOptionName = MyCouponCode.getMyCouponCodeName(e.getCPH_OPTION_TYPE(), contury);
			String cphGubun = MyMbsGubun.getMyMbsGubun(e.getCPH_USE(), contury);
			e.setCPH_TYPE_NM(cphName);
			e.setCPH_OPTION_TYPE_NM(cphOptionName);
			e.setCPH_ROW_GUBUN(cphGubun);
		});

		ModelAndView mav = new ModelAndView();
		mav.addObject("myAvailableCouponCount", myAvailableCouponList.size());
		mav.addObject("myAvailableCouponList", myAvailableCouponList);
		mav.addObject("pagination", pagination);
		mav.addObject("myCouponHistory", myCouponHistory);
		mav.addObject("pageLink", "/" + contury + "/mypage/couponlist");
		mav.setViewName(contury + "/mypage/couponlist");
		return mav;
	}

	// 쿠폰 삭제
/*	@RequestMapping(value = "/mypage/couponlist/delete")
	public ModelAndView couponListDelete(TbKfoMbsCouponHistory.Request request) {
		myCouponService.myAvailableCouponUpdate(request);
		RedirectView redirectView = new RedirectView("/" + request.getLanguage() + "/mypage/couponlist");
		redirectView.setExposeModelAttributes(false);
		ModelAndView mav = new ModelAndView();
		mav.setView(redirectView);
		return mav;
	}*/

	// 유효 쿠폰 확인
	@ResponseBody
	@RequestMapping(value = "/mypage/applyOnlineCoupon")
	public Object confirmOnlineCouponNumber(String couponNum) {
		return myCouponService.confirmOnlineCouponNumber(couponNum);
	}
}