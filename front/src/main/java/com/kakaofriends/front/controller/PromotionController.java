package com.kakaofriends.front.controller;

import com.kakaofriends.front.common.annotation.FriendsGlobal;
import com.kakaofriends.front.service.PromotionService;
import com.kakaofriends.front.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@FriendsGlobal
@RequestMapping(value = "/{language}")
public class PromotionController {

	@Autowired
	private PromotionService promotionService;

	@GetMapping(value = "/promotions/{promotion}")
	public ModelAndView promotionView(@PathVariable("language") String language, @PathVariable("promotion") String promotion) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(language + "/promotion/"+promotion);
		return mav;
	}

	@GetMapping(value = "/promotions/event/{promotion}")
	public ModelAndView promotionEventView(@PathVariable("language") String language, @PathVariable("promotion") String promotion) {
		ModelAndView mav = new ModelAndView();

		DateUtil dateUtil = new DateUtil();
		mav.addObject("today", dateUtil.getDateyyyyMMddHHmm());
		mav.setViewName(language + "/promotion/event/"+promotion);
		return mav;
	}

	@GetMapping(value = "/promotions/promotion/{prmSeq}")
	public ModelAndView promotionLandingPageView(@PathVariable("language") String language, @PathVariable("prmSeq") Long prmSeq) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("promotionExpansion", promotionService.findByPrmSeq(prmSeq));
		mav.setViewName(language + "/promotion/view");
		return mav;
	}
}