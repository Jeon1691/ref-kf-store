package com.kakaofriends.front.controller.order;

import com.kakaofriends.front.common.exception.SessionTimeOutException;
import com.kakaofriends.front.domain.order.OrderSubDto;
import com.kakaofriends.front.service.order.cancel.OrderCancelProcessService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.kakaofriends.front.utils.FriendsUtil.getFriendsMemberId;
import static com.kakaofriends.front.utils.FriendsUtil.isAnonymousUser;
import static com.kakaofriends.front.utils.OrderUtil.setRedirectViewForNonMemberByShippingRequest;

@Slf4j
@Controller
@RequestMapping(value = "/{language}")
public class OrderCancelProcessController {

	@Autowired
	OrderCancelProcessService orderCancelProcessService;

	@Autowired
	MessageSource messageSource;

    /**
     * 주문 취소
     * @param shippingRequest
     * @param redirectAttributes
     * @param httpServletRequest
     * @return
     * @throws Exception
     */
	@PostMapping(value = "/order/shipping/orderCancel")
	public ModelAndView orderCancel(OrderSubDto.OrderSubShippingRequest shippingRequest, RedirectAttributes redirectAttributes, HttpServletRequest httpServletRequest) throws Exception {
		HttpSession httpSession = httpServletRequest.getSession();
		String ownerName = (String) httpSession.getAttribute("ownerName");
		String orderMail = (String) httpSession.getAttribute("orderMail");
		String oId = (String) httpSession.getAttribute("oId");

		log.debug("#### orderCancel from oId = {}", oId);
		if (StringUtils.isEmpty(oId)) {
			throw new SessionTimeOutException();
		}

		ModelAndView mav = new ModelAndView();

		if (isAnonymousUser()) {
		    //비회원
			redirectAttributes.addFlashAttribute("cancelResult", orderCancelProcessService.orderCancelToOrderSubListForNonMember(httpServletRequest, getFriendsMemberId(), ownerName, oId, orderMail));
			mav = setRedirectViewForNonMemberByShippingRequest(mav, ownerName, shippingRequest);
		} else {
		    //회원
			redirectAttributes.addFlashAttribute("cancelResult", orderCancelProcessService.orderCancelToOrderSubList(httpServletRequest, getFriendsMemberId(), oId));
			mav.setView(new RedirectView("/" + shippingRequest.getLanguage() + "/order/shipping/" + shippingRequest.getOrderNumber()));
		}
		return mav;
	}
}