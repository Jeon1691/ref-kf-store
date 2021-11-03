package com.kakaofriends.front.controller;

import com.kakaofriends.front.common.annotation.FriendsGlobal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@FriendsGlobal
@RequestMapping(value = "/{language}")
public class InfoController {

	@RequestMapping(value = "/info/charInfo")
	public ModelAndView charInfoPage(@PathVariable("language") String language) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(language + "/info/charInfo");
		return mav;
	}

	@RequestMapping(value = "/info/storeInfo")
	public ModelAndView storeInfoPage(@PathVariable("language") String language) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(language + "/info/storeInfo");
		return mav;
	}
}