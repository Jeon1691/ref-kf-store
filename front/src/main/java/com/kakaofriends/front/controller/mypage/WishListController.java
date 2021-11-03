package com.kakaofriends.front.controller.mypage;

import com.kakaofriends.core.common.pagination.PaginationInfo;
import com.kakaofriends.core.utils.KakaoFriendsConstants;
import com.kakaofriends.front.common.annotation.FriendsGlobal;
import com.kakaofriends.front.domain.WishlistDto;
import com.kakaofriends.front.service.mypage.WishlistService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import static com.kakaofriends.core.utils.KakaoFriendsUtil.getPaginationInfo;
import static com.kakaofriends.front.utils.FriendsUtil.getFriendsMemberId;
import static com.kakaofriends.front.utils.FriendsUtil.stringConcatPath;

@Slf4j
@Controller
@FriendsGlobal
@RequestMapping(value = "/{language}")
public class WishListController extends MyPageTopController {

	@Autowired
	private WishlistService wishlistService;

	//찜
	@RequestMapping(value = "/mypage/wishlist/insert")
	public ModelAndView wishListInsertProduct(WishlistDto.Request request) {
		wishlistService.insertProduct(request);
		RedirectView redirectView = new RedirectView("/" + request.getLanguage() + "/products/" + request.getDisplayGoodsId());
		redirectView.setExposeModelAttributes(false);
		ModelAndView mav = new ModelAndView();
		mav.setView(redirectView);
		return mav;
	}

	@RequestMapping(value = "/mypage/wishlist/delete")
	public ModelAndView wishListDelete(WishlistDto.Request request) {
		wishlistService.deleteProduct(request);
		RedirectView redirectView = new RedirectView("/" + request.getLanguage() + "/mypage/wishlist");
		redirectView.setExposeModelAttributes(false);
		ModelAndView mav = new ModelAndView();
		mav.setView(redirectView);
		return mav;
	}

	@RequestMapping(value = {"/mypage/wishlist", "/mypage/wishlist/pages/{pageIndex}"})
	public ModelAndView wishList(WishlistDto.Request request) {

		Integer totalCount = wishlistService.findCountByOwnerId(getFriendsMemberId());
		PaginationInfo pagination = getPaginationInfo(totalCount, request.getPageIndex(), KakaoFriendsConstants.pageUnit, KakaoFriendsConstants.pageSize);

		ModelAndView mav = new ModelAndView();
		mav.addObject("wishlist", wishlistService.findByOwnerId(getFriendsMemberId(), pagination));
		mav.addObject("totalCount", totalCount);
		mav.addObject("pagination", pagination);
		mav.addObject("pageLink", stringConcatPath("", request.getLanguage(), "mypage/wishlist"));
		mav.setViewName(request.getLanguage() + "/mypage/wishlist");
		return mav;
	}
}