package com.kakaofriends.front.controller.mypage;

import com.kakaofriends.core.common.configuration.persistence.type.BoardReplyType;
import com.kakaofriends.core.common.pagination.PaginationInfo;
import com.kakaofriends.core.utils.KakaoFriendsConstants;
import com.kakaofriends.front.common.annotation.FriendsGlobal;
import com.kakaofriends.front.domain.BoardArticleDto;
import com.kakaofriends.front.domain.FriendsListing;
import com.kakaofriends.front.service.BoardArticleService;
import com.kakaofriends.front.service.mypage.OneToOneService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.io.File;
import java.util.stream.Collectors;

import static com.kakaofriends.core.utils.KakaoFriendsUtil.getPaginationInfo;
import static com.kakaofriends.core.utils.KakaoFriendsConstants.B2CGROUP;
import static com.kakaofriends.front.utils.FriendsUtil.*;

@Slf4j
@Controller
@FriendsGlobal
@RequestMapping(value = "/{language}")
public class MyPageController extends MyPageTopController {

	@Autowired
	private OneToOneService oneToOneService;

	@Autowired
	private BoardArticleService boardArticleService;

	@Autowired
	private MessageSource messageSource;

	// 1:1문의
	@RequestMapping(value = {"/mypage/onetoone", "/mypage/onetoone/pages/{pageIndex}"})
	public ModelAndView oneToOne(FriendsListing friendsListing) {

		String ownerId = getFriendsMemberId();

		int totalCount = oneToOneService.findOneToOneArticlesCountByUserId(ownerId);
		PaginationInfo pagination = getPaginationInfo(totalCount, friendsListing.getPageIndex(), KakaoFriendsConstants.pageUnitForArticle, KakaoFriendsConstants.pageSize);
		ModelAndView mav = new ModelAndView();
		mav.addObject("oneToOneList", oneToOneService.findOneToOneArticlesByUserId(ownerId, pagination));
		mav.addObject("oneToOneAnswer", oneToOneService.findOneToOneAnswersByUserId(ownerId, pagination));
		mav.addObject("totalCount", totalCount);
		mav.addObject("pagination", pagination);
		mav.addObject("pageLink", "/" + friendsListing.getLanguage() + "/mypage/onetoone");
		mav.setViewName(friendsListing.getLanguage() + "/mypage/onetoone/list");
		return mav;
	}

	@RequestMapping(value = "/mypage/onetoone/form")
	public ModelAndView oneToOneWrite(@PathVariable(value = "language") String language, BoardArticleDto.BoardArticleOneToOneRequest request, BindingResult bindingResult) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardCategories", boardArticleService.findByBoardCategoryAll());
		mav.addObject("request", request);
		mav.addObject("bindingResult", bindingResult.getFieldErrors().stream().map(e -> e.getDefaultMessage()).collect(Collectors.joining(", ", "{", "}")));
		mav.setViewName(language + "/mypage/onetoone/write");
		return mav;
	}

	@PostMapping(value = "/mypage/onetoone/register")
	public ModelAndView oneToOneWriteRegister(@PathVariable(value = "language") String language, @Valid BoardArticleDto.BoardArticleOneToOneRequest request, BindingResult bindingResult, RedirectAttributes redirectAttributes) throws Exception {

		if (bindingResult.hasErrors()) {
			throw new Exception();
		}
        int fileNameIdx = 0;
		try {
		    fileNameIdx = request.getBdaFile().getOriginalFilename().lastIndexOf( "\\" );
            request.setOriginalFileName(request.getBdaFile().getOriginalFilename().substring(fileNameIdx + 1));
        }catch ( Exception e ){
		    ;
        }
		request.setBdaLanguage(language);
		request.setBdaOwnerid(getFriendsMemberId());
		request.setBdaPhone(request.getBdaPhone().replaceAll("[-]", ""));
		request.setBdaCpCode(B2CGROUP);
		request.setBdaEtc3(BoardReplyType.RECEPTION_COMPLETION);
		oneToOneService.registerOneToOneArticle(request);

		ModelAndView mav = new ModelAndView();
		redirectAttributes.addFlashAttribute("writeResult", "alert_onetoone_write_success");
		RedirectView redirectView = new RedirectView("/" + language + "/mypage/onetoone");
		mav.setView(redirectView);
		return mav;
	}

	@RequestMapping(value = "/mypage/onetoone/filesize")
	@ResponseBody
	public String sizeCheck(@RequestParam("size") String size) {
		File file = new File(size);
		return String.valueOf(file.length());
	}
}