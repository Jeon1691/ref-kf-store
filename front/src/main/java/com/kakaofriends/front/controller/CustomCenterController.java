package com.kakaofriends.front.controller;

import com.kakaofriends.core.common.pagination.PaginationInfo;
import com.kakaofriends.core.domain.BoardCategory;
import com.kakaofriends.core.utils.KakaoFriendsConstants;
import com.kakaofriends.front.common.annotation.FriendsGlobal;
import com.kakaofriends.front.common.configuration.persistence.type.BoardCategoryType;
import com.kakaofriends.front.common.configuration.persistence.type.BoardType;
import com.kakaofriends.front.domain.FriendsListing;
import com.kakaofriends.front.service.BoardArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

import static com.kakaofriends.core.utils.KakaoFriendsUtil.getPaginationInfo;

@Slf4j
@Controller
@FriendsGlobal
@RequestMapping(value = "/{language}")
public class CustomCenterController {

	@Autowired
	private BoardArticleService boardArticleService;

	// 공지사항
	@RequestMapping(value = {"/customcenter/bnotice", "/customcenter/bnotice/pages/{pageIndex}"})
	public ModelAndView getBoardArticleByBnotice(FriendsListing friendsListing, HttpServletRequest request) {
		int totalCount = boardArticleService.findByArticleNameToCount(friendsListing.getBoardType().getName());
		PaginationInfo pagination = getPaginationInfo(totalCount, friendsListing.getPageIndex(), KakaoFriendsConstants.pageUnitForArticle, KakaoFriendsConstants.pageSize);

		ModelAndView mav = new ModelAndView();
		getBoardArticles(boardArticleService.findByArticleName(friendsListing.getBoardType().getName(), pagination), totalCount, pagination, mav);
		mav.addObject("pageLink", "/"+friendsListing.getLanguage()+"/customcenter/bnotice");
		mav.setViewName(friendsListing.getLanguage() + "/articles/" + friendsListing.getBoardType().getName());
		return mav;
	}

	// FAQ 전체 보기
	@RequestMapping(value = {"/customcenter/faq", "/customcenter/faq/pages/{pageIndex}"})
	public ModelAndView getBoardArticleByArticleFaqAll(FriendsListing friendsListing) {
		return getFaqArticles(friendsListing).addObject("pageLink", "/"+friendsListing.getLanguage()+"/customcenter/faq");
	}

	// FAQ 카테고리 선택 보기
	@RequestMapping(value = {"/customcenter/faq/{boardCategory}", "/customcenter/faq/{boardCategory}/pages/{pageIndex}"})
	public ModelAndView getBoardArticleByArticleFaqCategory(FriendsListing friendsListing) {
		return getFaqArticles(friendsListing).addObject("pageLink", "/"+friendsListing.getLanguage()+"/customcenter/faq/"+friendsListing.getBoardCategory());
	}

	private ModelAndView getFaqArticles(FriendsListing friendsListing) {
		friendsListing.setBoardType(BoardType.FAQ);
		int totalCount = boardArticleService.findByArticleWithCategoryToCount(friendsListing.getBoardType().getName(), friendsListing.getBoardCategory());
		PaginationInfo pagination = getPaginationInfo(totalCount, friendsListing.getPageIndex(), KakaoFriendsConstants.pageUnitForArticle, KakaoFriendsConstants.pageSize);
		ModelAndView mav = new ModelAndView();
		List<BoardCategory> boardCategories = boardArticleService.findByBoardCategoryAll();
		Arrays.asList(BoardCategoryType.values()).forEach(e -> System.out.println(e.getCode()));
		mav.addObject("categoryName", friendsListing.getBoardCategory() == null ? "전체" : boardCategories.stream().filter(e -> e.getBdcSeq().intValue() == friendsListing.getBoardCategory()).findFirst().get().getBdcName());
		mav.addObject("categoryEname", friendsListing.getBoardCategory() == null ? "All" : boardCategories.stream().filter(e -> e.getBdcSeq().intValue() == friendsListing.getBoardCategory()).findFirst().get().getBdcEname());
		mav.addObject("boardCategories", boardCategories);
		getBoardArticles(boardArticleService.findByArticleWithCategory(friendsListing.getBoardType().getName(), friendsListing.getBoardCategory(), pagination), totalCount, pagination, mav);
		mav.setViewName(friendsListing.getLanguage() + "/articles/" + friendsListing.getBoardType().getName());
		return mav;
	}

	private void getBoardArticles(List<?> boardArticles, int totalCount, PaginationInfo pagination, ModelAndView mav) {
		mav.addObject("boardArticles", boardArticles);
		mav.addObject("pagination", pagination);
		mav.addObject("totalCount", totalCount);
	}
}