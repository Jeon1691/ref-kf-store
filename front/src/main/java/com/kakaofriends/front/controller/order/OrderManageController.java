package com.kakaofriends.front.controller.order;

import com.kakaofriends.front.common.exception.OrderManageException;
import com.kakaofriends.front.domain.order.OrderAddressDto;
import com.kakaofriends.front.domain.order.OrderSubDto;
import com.kakaofriends.front.service.order.OrderManageService;
import com.kakaofriends.front.service.product.stock.StockService;
import lombok.extern.slf4j.Slf4j;
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

import static com.kakaofriends.front.utils.FriendsUtil.*;
import static com.kakaofriends.front.utils.OrderUtil.setRedirectViewForNonMemberByOrderAddress;
import static com.kakaofriends.front.utils.OrderUtil.setRedirectViewForNonMemberByShippingRequest;

@Slf4j
@Controller
@RequestMapping(value = "/{language}")
public class OrderManageController {

	@Autowired
	private OrderManageService orderManageService;

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private StockService stockService;

	// 구매 확정
	@PostMapping(value = "/order/shipping/purchaseFinalized")
	public ModelAndView orderSubPurchaseFinalized(HttpServletRequest httpServletRequest, RedirectAttributes redirectAttributes, OrderSubDto.OrderSubShippingRequest shippingRequest) throws OrderManageException {
		ModelAndView mav = new ModelAndView();
		if (isAnonymousUser()) {
			HttpSession httpSession = httpServletRequest.getSession();
			String sessionOwnerName = (String) httpSession.getAttribute("ownerName");
			String sessionOId = (String) httpSession.getAttribute("oId");

			addRedirectAttributesByStatusChangedFail(redirectAttributes, orderManageService.purchaseFinalizedToOrderSubForNonMember(getFriendsMemberId(), sessionOwnerName, sessionOId, shippingRequest));

			mav = setRedirectViewForNonMemberByShippingRequest(mav, sessionOwnerName, shippingRequest);
		} else {
			addRedirectAttributesByStatusChangedFail(redirectAttributes, orderManageService.purchaseFinalizedToOrderSub(getFriendsMemberId(), shippingRequest));
			mav.setView(new RedirectView("/" + shippingRequest.getLanguage() + "/order/shipping/" + shippingRequest.getOrderNumber()));
		}
		return mav;
	}

	// 전체 반품 신청
	@PostMapping(value = "/order/shipping/returnRequestAll")
	public ModelAndView orderSubReturnRequestAll(OrderSubDto.OrderSubShippingRequest shippingRequest, RedirectAttributes redirectAttributes, HttpServletRequest httpServletRequest) throws Exception {
		HttpSession httpSession = httpServletRequest.getSession();
		String ownerName = (String) httpSession.getAttribute("ownerName");
		String oId = (String) httpSession.getAttribute("oId");
		String orderMail = (String) httpSession.getAttribute("orderMail");

		ModelAndView mav = new ModelAndView();

		if (isAnonymousUser()) {
			addRedirectAttributesByStatusChangedFail(redirectAttributes, orderManageService.orderSubReturnRequestAllForNonMember(getFriendsMemberId(), ownerName, oId, orderMail, shippingRequest));
			mav = setRedirectViewForNonMemberByShippingRequest(mav, ownerName, shippingRequest);
		} else {
			addRedirectAttributesByStatusChangedFail(redirectAttributes, orderManageService.orderSubReturnRequestAll(getFriendsMemberId(),  oId, shippingRequest));
			mav.setView(new RedirectView("/" + shippingRequest.getLanguage() + "/order/shipping/" + shippingRequest.getOrderNumber()));
		}
		return mav;
	}

	// 반품 신청
	@PostMapping(value = "/order/shipping/returnRequest")
	public ModelAndView orderSubReturnRequest(HttpServletRequest httpServletRequest, RedirectAttributes redirectAttributes, OrderSubDto.OrderSubShippingRequest shippingRequest) throws OrderManageException {
		ModelAndView mav = new ModelAndView();
		if (isAnonymousUser()) {
			HttpSession httpSession = httpServletRequest.getSession();
			String sessionOwnerName = (String) httpSession.getAttribute("ownerName");
			String sessionOId = (String) httpSession.getAttribute("oId");

			log.info("### 반품 신청 : returnRequest : 비회원 : Session_name : {}, Session_oId : {}, name : {}, oid : {}, OrderSubseq : {} ", sessionOwnerName, sessionOId, shippingRequest.getOwnerName(), shippingRequest.getOrderNumber(), shippingRequest.getOrderSubSequence() );

			addRedirectAttributesByStatusChangedFail(redirectAttributes, orderManageService.orderSubReturnRequestForNonMember(getFriendsMemberId(), sessionOwnerName, sessionOId, shippingRequest));
			mav = setRedirectViewForNonMemberByShippingRequest(mav, sessionOwnerName, shippingRequest);
		} else {

			log.info("### 반품 신청 : returnRequest : 회원 : name : {}, oId : {}, OrderSubseq : {}", shippingRequest.getOwnerName(), shippingRequest.getOrderNumber(), shippingRequest.getOrderSubSequence() );
			addRedirectAttributesByStatusChangedFail(redirectAttributes, orderManageService.orderSubReturnRequest(getFriendsMemberId(), shippingRequest));
			mav.setView(new RedirectView("/" + shippingRequest.getLanguage() + "/order/shipping/" + shippingRequest.getOrderNumber()));
		}
		return mav;
	}

	// 교환 신청
	@PostMapping(value = "/order/shipping/exchangeRequest")
	public ModelAndView orderSubExchangeRequest(HttpServletRequest httpServletRequest, RedirectAttributes redirectAttributes, OrderSubDto.OrderSubShippingRequest shippingRequest) throws OrderManageException {
		ModelAndView mav = new ModelAndView();
		boolean exchangeStockCheck = orderManageService.stockCheckForProductIdByOrderSub(shippingRequest.getOrderSubSequence(), shippingRequest.getRequestEa()); //재고 유효성 검사

		if (isAnonymousUser()) {
			HttpSession httpSession = httpServletRequest.getSession();
			String sessionOwnerName = (String) httpSession.getAttribute("ownerName");
			String sessionOId = (String) httpSession.getAttribute("oId");

			log.info("### 교환 신청 : exchangeRequest : 비회원 : Session_name : {}, Session_oId : {}, name : {}, oid : {}, OrderSubseq : {} ", sessionOwnerName, sessionOId, shippingRequest.getOwnerName(), shippingRequest.getOrderNumber(), shippingRequest.getOrderSubSequence() );
			if (exchangeStockCheck) {
				redirectAttributes.addFlashAttribute("statusChangedFail", processMessage(messageSource, "alert_stockEmtpy_product"));
			} else {
				addRedirectAttributesByStatusChangedFail(redirectAttributes, orderManageService.orderSubExchangeRequestForNonMember(getFriendsMemberId(), sessionOwnerName, sessionOId, shippingRequest)); //상태변경
			}
			mav = setRedirectViewForNonMemberByShippingRequest(mav, sessionOwnerName, shippingRequest);
		} else {

			log.info("### 교환 신청 : exchangeRequest : 회원 : name : {}, oId : {}, OrderSubseq : {}", shippingRequest.getOwnerName(), shippingRequest.getOrderNumber(), shippingRequest.getOrderSubSequence() );
			if (exchangeStockCheck) {
				redirectAttributes.addFlashAttribute("statusChangedFail", processMessage(messageSource, "alert_stockEmtpy_product"));
			} else {
				addRedirectAttributesByStatusChangedFail(redirectAttributes, orderManageService.orderSubExchangeRequest(getFriendsMemberId(), shippingRequest)); //상태변경
			}
			mav.setView(new RedirectView("/" + shippingRequest.getLanguage() + "/order/shipping/" + shippingRequest.getOrderNumber()));
		}
		return mav;
	}

	// 배송지 변경
	@PostMapping(value = "/order/shipping/address/change")
	public ModelAndView changeOrderAddress(HttpServletRequest httpServletRequest, RedirectAttributes redirectAttributes, OrderAddressDto.request orderAddressRequest) throws OrderManageException {
		HttpSession httpSession = httpServletRequest.getSession();
		String sessionOwnerName = (String) httpSession.getAttribute("ownerName");
		String sessionOrderMail = (String) httpSession.getAttribute("orderMail");
		String sessionOId = (String) httpSession.getAttribute("oId");

		log.info("## 배송지 변경: S_ownerName : {}, req_ownerName : {}, oid : {}, oaZoneCode : {}, addr1 : {}, addr2 : {}", sessionOwnerName, orderAddressRequest.getOaBuyerName(), sessionOId, orderAddressRequest.getOaZoneCode(), orderAddressRequest.getOaAddr1(), orderAddressRequest.getOaAddr2());
		orderAddressRequest.setUserId(getFriendsMemberId());
		addRedirectAttributesByStatusChangedFail(redirectAttributes, orderManageService.updateOrderAddressByOrderNumber(orderAddressRequest, sessionOwnerName, sessionOId, sessionOrderMail));
		ModelAndView mav = new ModelAndView();
		if (isAnonymousUser()) {
			mav = setRedirectViewForNonMemberByOrderAddress(mav, orderAddressRequest);
		} else {
			mav.setView(new RedirectView("/" + orderAddressRequest.getLanguage() + "/order/shipping/" + orderAddressRequest.getOaOmNum()));
		}
		return mav;
	}

    @PostMapping(value = "/order/complete/buyer/change")
    public ModelAndView changeOrderBuyerInfo(HttpServletRequest httpServletRequest, RedirectAttributes redirectAttributes, OrderAddressDto.request orderAddressRequest) throws OrderManageException {
        HttpSession httpSession = httpServletRequest.getSession();
        String sessionOwnerName = (String) httpSession.getAttribute("ownerName");
        String sessionOrderMail = (String) httpSession.getAttribute("orderMail");
        String sessionOId = (String) httpSession.getAttribute("oId");

        log.info("## 발송인 변경: S_ownerName : {}, req_ownerName : {}, oid : {}, orderMail : {}, req_mail : {}"
                , sessionOwnerName, orderAddressRequest.getOaBuyerName(), sessionOId, sessionOrderMail, orderAddressRequest.getOaBuyerEmail());
        orderAddressRequest.setUserId(getFriendsMemberId());
        addRedirectAttributesByStatusChangedFail(redirectAttributes, orderManageService.updateOrderBuyerInfo(httpServletRequest, orderAddressRequest, sessionOwnerName, sessionOId, sessionOrderMail));
        ModelAndView mav = new ModelAndView();
        if (isAnonymousUser()) {
            mav = setRedirectViewForNonMemberByOrderAddress(mav, orderAddressRequest);
        } else {
            mav.setView(new RedirectView("/" + orderAddressRequest.getLanguage() + "/order/shipping/" + orderAddressRequest.getOaOmNum()));
        }
        return mav;
    }

	private RedirectAttributes addRedirectAttributesByStatusChangedFail(RedirectAttributes redirectAttributes, Boolean changeSuccessFlag){
		if(!changeSuccessFlag){
			redirectAttributes.addFlashAttribute("statusChangedFail", processMessage(messageSource, "alert.order.message.01"));
		}
		return redirectAttributes;
	}
}
