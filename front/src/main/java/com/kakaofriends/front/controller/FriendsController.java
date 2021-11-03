package com.kakaofriends.front.controller;

import com.daumcorp.commons.useragentutil.UserAgent;
import com.kakaofriends.core.domain.Friend;
import com.kakaofriends.front.common.annotation.FriendsGlobal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Map;

@Slf4j
@Controller
@FriendsGlobal
@RequestMapping(value = "/{language}")
public class FriendsController {

	@GetMapping(value = {"/friends/{name}", "/friends/{name}/pages/{page}"})
	public ModelAndView helloFriends(
			@PathVariable("language") String language,
			@MatrixVariable(value = "gender", defaultValue = "female") String gender,
			@MatrixVariable(value = "age", defaultValue = "genius") String age,
			@MatrixVariable(pathVar = "name") Map<String, Friend> friend,
			@ModelAttribute UserAgent userAgent,
			Friend muzi, HttpServletRequest request) {
		log.info("friends = " + friend);
		log.info("muzi = " + muzi);
		log.info("userAgent = " + userAgent.toString());
		ModelAndView mav = new ModelAndView();
		mav.addObject("now", LocalDateTime.now());
		mav.setViewName(language + "/index");
		return mav;
	}
}