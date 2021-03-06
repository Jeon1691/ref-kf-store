package com.kakaofriends.front.controller.mypage;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kakaofriends.core.common.configuration.persistence.type.OrderStatusType;
import com.kakaofriends.core.common.configuration.persistence.typeHandler.ShippingStatusTypeHandler;
import com.kakaofriends.core.common.pagination.PaginationInfo;
import com.kakaofriends.core.domain.OrderAddDeli;
import com.kakaofriends.core.utils.KakaoFriendsConstants;
import com.kakaofriends.front.common.annotation.FriendsGlobal;
import com.kakaofriends.front.common.exception.OrderManageException;
import com.kakaofriends.front.common.external.ExchangeRateComponent;
import com.kakaofriends.front.domain.BasketVO;
import com.kakaofriends.front.domain.Country;
import com.kakaofriends.front.domain.FriendsListing;
import com.kakaofriends.front.domain.common.CountryVO;
import com.kakaofriends.front.domain.mypage.MembershipVO;
import com.kakaofriends.front.domain.order.OrderCompleteVO;
import com.kakaofriends.front.domain.order.OrderShippingInfo;
import com.kakaofriends.front.domain.order.OrderSubDto;
import com.kakaofriends.front.service.EmsService;
import com.kakaofriends.front.service.mypage.MyOrderedService;
import com.kakaofriends.front.service.order.OrderAddDeliService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

import static com.kakaofriends.core.utils.KakaoFriendsConstants.KAKAO_FRIENDS_ORDER_PAYMENT_PERIOD;
import static com.kakaofriends.core.utils.KakaoFriendsUtil.getPaginationInfo;
import static com.kakaofriends.front.utils.FriendsUtil.getFriendsMemberId;
import static com.kakaofriends.front.utils.FriendsUtil.stringConcatPath;

@Slf4j
@Controller
@FriendsGlobal
@SessionAttributes("orderName")
@RequestMapping(value = "/{language}")
public class OrderedController extends MyPageTopController {

	@Autowired
	private MyOrderedService myOrderedService;

	@Autowired
	private OrderAddDeliService orderAddDeliService;

	@Autowired
	private EmsService emsService;

	@Autowired
	private ExchangeRateComponent exchangeRateComponent;

	private ShippingStatusTypeHandler shippingStatusTypeHandler = new ShippingStatusTypeHandler();

	private ToDoubleFunction<OrderSubDto.OrderSubShipping> doubleFunction = i -> i.getOrderSub().getExchangeSaleMoney() * i.getOrderSub().getOsEa();

	// ?????? ?????? ?????????
	@RequestMapping(value = {"/mypage/orderlist", "/mypage/orderlist/pages/{pageIndex}"})
	public ModelAndView orderList(FriendsListing friendsListing) {
		String ownerId = getFriendsMemberId();

		int totalCount = myOrderedService.findByMyOrderListAllCount(ownerId);
		PaginationInfo pagination = getPaginationInfo(totalCount, friendsListing.getPageIndex(), KakaoFriendsConstants.pageUnitForOrders, KakaoFriendsConstants.pageSize);

		ModelAndView mav = new ModelAndView();
		mav.addObject("totalCount", totalCount);
		mav.addObject("pagination", pagination);
		mav.addObject("orderList", myOrderedService.findByMyOrderListAll(ownerId, pagination));
		mav.addObject("pageLink", "/" + friendsListing.getLanguage() + "/mypage/orderlist");
		mav.setViewName(friendsListing.getLanguage() + "/mypage/orderlist");
		return mav;
	}

	// ?????? ??? ?????? ?????????
	@RequestMapping(value = {"/mypage/cancellist", "/mypage/cancellist/pages/{pageIndex}"})
	public ModelAndView cancelList(FriendsListing friendsListing) {
		String ownerId = getFriendsMemberId();

		int totalCount = myOrderedService.findByMyCancelListAllCount(ownerId, shippingStatusTypeHandler.getCancelListViewConditionArr());
		PaginationInfo pagination = getPaginationInfo(totalCount, friendsListing.getPageIndex(), KakaoFriendsConstants.pageUnitForOrders, KakaoFriendsConstants.pageSize);

		ModelAndView mav = new ModelAndView();
		mav.addObject("totalCount", totalCount);
		mav.addObject("pagination", pagination);
		mav.addObject("cancelList", myOrderedService.findByMyCancelListAll(ownerId, shippingStatusTypeHandler.getCancelListViewConditionMap(), pagination));
		mav.addObject("pageLink", stringConcatPath("", friendsListing.getLanguage(), "mypage/cancellist"));
		mav.setViewName(friendsListing.getLanguage() + "/mypage/cancellist");
		return mav;
	}

	// ?????? ?????? ?????? ?????????
	@RequestMapping(value = "/order/shipping/{orderNumber}")
	public ModelAndView shipping(HttpServletRequest httpServletRequest, @PathVariable("language") String language, @PathVariable("orderNumber") String orderNumber) throws OrderManageException {
		HttpSession httpSession = httpServletRequest.getSession();
		httpSession.setAttribute("oId", orderNumber);
		return getModelAndView(httpServletRequest, myOrderedService.findOrderShippingInfoByUserIdAndOrderNumber(getFriendsMemberId(), orderNumber), language);
	}

	// ????????? ?????? ?????? ?????? Ajax
	@ResponseBody
	@RequestMapping(value = "/order/shippingNnonmember/orderCheck")
	public boolean checkShippingInfoForNonmember(String orderNum, String orderName, String orderMail) {
		return myOrderedService.findOrderShippingInfoByNonmemberNameAndOrderNumber(orderName, orderNum, orderMail) != null ? true : false;
	}

	// ????????? ?????? ?????? ?????????
	@RequestMapping(value = "/order/shippingNonmember")
	public ModelAndView shippingForNonmember(@PathVariable("language") String language, HttpServletRequest request) throws UnsupportedEncodingException, OrderManageException {
		OrderShippingInfo myOrderShippingInfo = getShippingForNonMember(request);
		return getModelAndView(request, myOrderShippingInfo, language);
	}

	// ??????, ????????? ?????? ?????? ?????? ?????????
	@RequestMapping(value = "/order/complete")
	public ModelAndView shippingComplete(@PathVariable("language") String language, HttpServletRequest request) throws OrderManageException {
		return getModelAndViewForComplete(language, request);
	}

	// ?????? ?????? ??? ModelAndView ??????
	private ModelAndView getModelAndView(HttpServletRequest httpServletRequest, OrderShippingInfo myOrderShippingInfo, String language) throws OrderManageException {
		if (myOrderShippingInfo == null) {
			log.error("?????? ?????? ?????? ?????? ?????? ??????.");
			throw new OrderManageException("?????? ?????? ?????? ?????? ?????? ??????.");
		}
		System.out.println("## ?????? ?????? " + myOrderShippingInfo.getOrderInfo().getOmNum());
		String oaCountryName = myOrderShippingInfo.getOrderAddressRequest().getOaCountryName();
		myOrderShippingInfo.getOrderAddressRequest().setOaCountryName(Country.getCountryNameByCode(Country.getCountryCodeByName(oaCountryName), language.toLowerCase()));

		OrderCompleteVO orderCompleteVO = new OrderCompleteVO();
		orderCompleteVO.setErrMsg(setRequestMsg(httpServletRequest, "errMsg"));
		orderCompleteVO.setComplete(setRequestMsg(httpServletRequest, "complete"));
		orderCompleteVO.setStatusChangedFail(setRequestMsg(httpServletRequest, "statusChangedFail"));
		orderCompleteVO.setCancelResult(setRequestCancelResult(httpServletRequest));
		orderCompleteVO.setExchangeDeliveryMoney(getExchangePrice(myOrderShippingInfo.getOrderInfo().getCompleteExchangeDeliveryMoney()));
		setModelAndViewObject(myOrderShippingInfo, orderCompleteVO);

		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		String orderCompleteVoData = null;
		try {
			orderCompleteVoData = mapper.writeValueAsString(orderCompleteVO);
		} catch (IOException e) {
			System.out.println("???????????? Json ??????");
		}

		ModelAndView mav = new ModelAndView();
		mav.addObject("orderCompleteVo", orderCompleteVoData);
		mav.setViewName(language + "/order/shipping");
		return mav;
	}

	// ?????? ?????? ??? ModelAndView ??????
	private ModelAndView getModelAndViewForComplete(String language, HttpServletRequest httpServletRequest) throws OrderManageException {

		HttpSession httpSession = httpServletRequest.getSession();
		String ownerName = (String) httpSession.getAttribute("ownerName");
		String orderNum = (String) httpSession.getAttribute("oId");

		if (ownerName == null || orderNum == null) {
			log.error("?????? ?????? ????????? ?????? - ????????? ??????, ???????????? ??????.");
			throw new OrderManageException("?????? ?????? ????????? ?????? - ????????? ??????, ???????????? ??????.");
		}

		OrderShippingInfo myOrderShippingInfo = myOrderedService.findOrderShippingInfoByOwnerNameAndOrderNumberForComplete(ownerName, orderNum);

		if (!myOrderShippingInfo.getOrderInfo().getOmOwnerId().equals(getFriendsMemberId())) {
			log.error("?????? ?????? ????????? ?????? - ????????? ??????, ?????? ????????? ??????.");
			throw new OrderManageException("?????? ?????? ????????? ?????? - ????????? ??????, ?????? ????????? ??????.");
		}

		OrderCompleteVO orderCompleteVO = new OrderCompleteVO();
		orderCompleteVO.setErrMsg(setRequestMsg(httpServletRequest, "errMsg"));
		orderCompleteVO.setComplete(setRequestMsg(httpServletRequest, "complete"));
		orderCompleteVO.setStatusChangedFail(setRequestMsg(httpServletRequest, "statusChangedFail"));
		orderCompleteVO.setCancelResult(setRequestCancelResult(httpServletRequest));
		orderCompleteVO.setExchangeProdAmountCharge(getExchangePrice(myOrderShippingInfo.getOrderInfo().getCompleteExchangeProdAmountCharge()));
		orderCompleteVO.setExchangeDiscountMoney(getExchangePrice(myOrderShippingInfo.getOrderInfo().getCompleteExchangeDiscountMoney()));
		orderCompleteVO.setExchangeDeliveryMoney(getExchangePrice(myOrderShippingInfo.getOrderInfo().getCompleteExchangeDeliveryMoney()));
		orderCompleteVO.setExchangeTotalMoney(getExchangePrice(myOrderShippingInfo.getOrderInfo().getCompleteExchangeTotalMoney()));
		setModelAndViewObject(myOrderShippingInfo, orderCompleteVO);

		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		String orderCompleteVoData = null;
		try {
			orderCompleteVoData = mapper.writeValueAsString(orderCompleteVO);
		} catch (IOException e) {
			System.out.println("???????????? Json ??????");
		}

		ModelAndView mav = new ModelAndView();
		mav.addObject("orderCompleteVo", orderCompleteVoData);
		mav.setViewName(language + "/order/complete");
		return mav;
	}

	// ????????? ???????????? ?????? - ??? ?????? ????????????, ???????????????
	//
	private OrderShippingInfo getShippingForNonMember(HttpServletRequest httpServletRequest) throws UnsupportedEncodingException, OrderManageException {
		HttpSession httpSession = httpServletRequest.getSession();
		String orderNum = (String) httpSession.getAttribute("oId");
		String nonMemberName = (String) httpSession.getAttribute("ownerName");
		String orderMail = (String) httpSession.getAttribute("orderMail");

		// ????????????, ????????? ?????? ??????
		if (httpServletRequest.getParameter("nonMemberName") == null && StringUtils.isEmpty(nonMemberName)) {
			log.error("????????? ?????? ?????? ????????? ?????? - ????????? ??????, ???????????? ??????.");
			throw new OrderManageException("????????? ?????? ?????? ????????? ?????? - ????????? ??????, ???????????? ??????.");
		}

		if (httpServletRequest.getParameter("nonMemberName") != null && httpServletRequest.getParameter("orderNum") != null) {
			nonMemberName = URLDecoder.decode(httpServletRequest.getParameter("nonMemberName"), "UTF-8");
			orderNum = httpServletRequest.getParameter("orderNum");
			orderMail = httpServletRequest.getParameter("orderMail");
			httpSession.setAttribute("ownerName", nonMemberName);
			httpSession.setAttribute("orderMail", orderMail);
			httpSession.setAttribute("oId", orderNum);
		}

		return myOrderedService.findOrderShippingInfoByNonmemberNameAndOrderNumber(nonMemberName, orderNum, orderMail);
	}

	// ?????? ?????? Object, ?????? ?????? ?????? Object ADD
	private void setModelAndViewObject(OrderShippingInfo myOrderShippingInfo, OrderCompleteVO orderCompleteVO) {
		//???????????? ??????(?????? X)??? ??? ????????????
		OrderAddDeli orderAddDeli = orderAddDeliService.findOrderAddDeliListByOrderNumberAndOrderStatus(myOrderShippingInfo.getOrderInfo().getOmNum(), OrderStatusType.RECOVERY_WAITING);

		//???????????? ??????(?????? O)??? ?????? ?????? ????????????
		List<OrderAddDeli> orderAddDeliPaymentList = orderAddDeliService.findOrderAddDeliListByPaymentEndOrderNumberAndOrderStatus(myOrderShippingInfo.getOrderInfo().getOmNum(), OrderStatusType.RECOVERY_WAITING);

        //?????? ????????? ???????????? ????????? ?????????
        if (orderAddDeliPaymentList.size() > 0) {
            int sum = orderAddDeliPaymentList.stream().mapToInt(e -> e.getOdReqMoney()).sum();

            if (orderAddDeli == null) {
                orderAddDeli = orderAddDeliPaymentList.get(0);
                orderAddDeli.setOdEtc1(orderAddDeliPaymentList.size() != 1 ? String.valueOf(orderAddDeliPaymentList.size()-1) : orderAddDeli.getOdEtc1());
                orderAddDeli.setOdEtc2(orderAddDeliPaymentList.size() != 1 ? String.valueOf(sum) : orderAddDeli.getOdEtc2());
                orderAddDeli.setOdReqPayType(orderAddDeliPaymentList.get(0).getOdPayType());
            } else {
                orderAddDeli.setOdEtc1(orderAddDeliPaymentList.size() != 1 ? String.valueOf(orderAddDeliPaymentList.size()-1) : orderAddDeli.getOdEtc1());
                orderAddDeli.setOdEtc2(String.valueOf(sum));
                orderAddDeli.setOdReqPayType(orderAddDeliPaymentList.get(0).getOdPayType());
            }
        }

		BasketVO basketVo = new BasketVO();
		CountryVO countryVo = new CountryVO();
		MembershipVO membershipVo = new MembershipVO();

		double exchangeBasketAccount = myOrderShippingInfo.getOrderSubList().stream().filter(e -> e.getOrderSub().getOsPrCode() != null ).mapToDouble(doubleFunction).sum();
		basketVo.setExchangeBasketAccount(exchangeBasketAccount);

		// ????????? ?????? ?????? ???????????? ?????? ??????odReqMoney
		basketVo.setCustomProductFlag((myOrderShippingInfo.getOrderSubList().stream().filter(OrderSubDto.OrderSubShipping::getIsCustomProduct).count() > 0) ? true : false);
		basketVo.setEventProductFlag((myOrderShippingInfo.getOrderSubList().stream().filter(OrderSubDto.OrderSubShipping::getIsEventProduct).count() > 0) ? true : false);
		basketVo.setPaymentDate(LocalDateTime.now().plusDays(KAKAO_FRIENDS_ORDER_PAYMENT_PERIOD).format(DateTimeFormatter.ofPattern("yyyyMMdd")));

		// ?????? ???????????? flag
		String orderCountryCode = myOrderShippingInfo.getOrderAddressRequest().getOaCountryCode();
		basketVo.setGlobalOrder(orderCountryCode != null && !orderCountryCode.equals("KR") ? true : false);

		countryVo.setUsStateList(emsService.getEmsState());

		orderCompleteVO.setOrderShippingInfo(myOrderShippingInfo);
		orderCompleteVO.setShippingStatusType(shippingStatusTypeHandler.findShippingStatusTypeByCode(Collections.max(myOrderShippingInfo.getOrderSubList().stream().map(e -> e.getOrderSub().getOsStatus().getCode()).collect(Collectors.toList()))));
		orderCompleteVO.setOrderAddDeli(orderAddDeli);
		orderCompleteVO.setMemberId(getFriendsMemberId());
		orderCompleteVO.setExchangeRate(exchangeRateComponent.getExchangeRate());

		orderCompleteVO.setBasketVO(basketVo);
		orderCompleteVO.setCountryVO(countryVo);
		orderCompleteVO.setMembershipVO(membershipVo);
	}

	private OrderAddDeli getOrderAddDeliPayment(List<OrderAddDeli> orderAddDeliList) {
		for (int i = 0; i < orderAddDeliList.size(); i++) {
			if (!orderAddDeliList.get(i).getOdPgTid().equals(null) && !orderAddDeliList.get(i).getOdPayType().equals(null)) {
				return orderAddDeliList.get(i);
			}
		}
		return null;
	}

	private double getExchangePrice(double price){
		return Math.round(price / exchangeRateComponent.getExchangeRate() * 100d ) / 100d ;
	}

	/**
	 * ????????? : layla
	 * ?????? : 2018. 2. 6.
	 * <p>
	 * redirect msg set
	 * errMsg, complete, statusChangedFail
	 *
	 * @param httpServletRequest
	 * @return errMsg
	 */
	private String setRequestMsg(HttpServletRequest httpServletRequest, String msgKey) {
		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(httpServletRequest);
		if(flashMap != null){
			String requestMsg =  (String) flashMap.get(msgKey);
			if (requestMsg != null && !requestMsg.equals("")) {
				return requestMsg;
			}
		}
		return null;
	}

	/**
	 * ????????? : layla
	 * ?????? : 2018. 2. 6.
	 * <p>
	 * redirect errMsg set
	 *
	 * @param httpServletRequest
	 * @return cancelResult
	 */
	private boolean setRequestCancelResult(HttpServletRequest httpServletRequest) {
		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(httpServletRequest);
		if(flashMap != null){
			Boolean cancelResult =  (Boolean) flashMap.get("cancelResult");
			if (cancelResult != null) {
				return cancelResult;
			}
		}
		return false;
	}
}
