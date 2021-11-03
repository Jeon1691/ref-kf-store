package com.kakaofriends.front.utils;

import com.google.common.collect.Lists;
import com.kakaofriends.core.common.configuration.persistence.type.OrderStatusType;
import com.kakaofriends.core.common.configuration.persistence.type.ShippingStatusType;
import com.kakaofriends.front.common.exception.GetUsdException;
import com.kakaofriends.front.common.exception.OrderManageException;
import com.kakaofriends.front.domain.order.OrderAddressDto;
import com.kakaofriends.front.domain.order.OrderShippingInfo;
import com.kakaofriends.front.domain.order.OrderSubDto;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.util.UriComponentsBuilder;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.Comparator;

import static com.kakaofriends.front.utils.FriendsUtil.getFriendsMemberId;

@Slf4j
public class OrderUtil {

	public static ModelAndView setRedirectViewForNonMemberByOrderAddress(ModelAndView mav, OrderAddressDto.request orderAddressRequest) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		//주문자 정보 변경 시 session에 새로 정보 넣어줌 2018.02.19 layla
		String buyerName = StringUtils.isEmpty(request.getParameter("buyerName")) ? orderAddressRequest.getOaBuyerName() : request.getParameter("buyerName");
		String orderMail = StringUtils.isEmpty(request.getParameter("orderMail")) ? orderAddressRequest.getOaBuyerEmail() : request.getParameter("orderMail");
		request.getSession().setAttribute("ownerName", buyerName);
		request.getSession().setAttribute("orderMail", orderMail);

		RedirectView rv = new RedirectView("/" + orderAddressRequest.getLanguage() + "/order/shippingNonmember");
		FlashMap fm = RequestContextUtils.getOutputFlashMap(request);
		fm.put("orderNum", orderAddressRequest.getOaOmNum());
		fm.put("nonMemberName", buyerName);
		rv.setExposeModelAttributes(false);
		mav.setView(rv);
		return mav;
	}

	public static ModelAndView setRedirectViewForNonMemberByShippingRequest(ModelAndView mav, String ownerName, OrderSubDto.OrderSubShippingRequest shippingRequest) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

		RedirectView rv = new RedirectView("/" + shippingRequest.getLanguage() + "/order/shippingNonmember");
		FlashMap fm = RequestContextUtils.getOutputFlashMap(request);
		fm.put("orderNum", shippingRequest.getOrderNumber());
		fm.put("nonMemberName", ownerName);
		rv.setExposeModelAttributes(false);
		mav.setView(rv);
		return mav;
	}

	public static void isValidOwnerId(String ownerId, OrderStatusType orderStatusType) throws OrderManageException {
		if (!getFriendsMemberId().equals(ownerId)) {
			log.error("(회원) 주문 정보 조회 결과 값이 없음."+ orderStatusType.getName());
			throw new OrderManageException("(회원) 주문 정보 조회 결과 값이 없음." + orderStatusType.getName());
		}
	}

	public static void isValidOwnerId(String ownerId) throws OrderManageException {
		if (!getFriendsMemberId().equals(ownerId)) {
			log.error("(회원) 주문 정보 조회 결과 값이 없음.");
			throw new OrderManageException("(회원) 주문 정보 조회 결과 값이 없음.");
		}
	}

	public static void isValidOwnerName(String sessionOwnerName, String ownerName, String sessionOId, String oId, OrderStatusType orderStatusType) throws OrderManageException {
		if (!(sessionOwnerName.equals(ownerName) && sessionOId.equals(oId))) {
			log.error("(비 회원) 주문 정보 조회 결과 값이 없음." + orderStatusType.getName());
			throw new OrderManageException("(비 회원) 주문 정보 조회 결과 값이 없음." + orderStatusType.getName());
		}
	}

	public static void isValidOwnerName(String sessionOwnerName, String ownerName, String sessionOId, String oId) throws OrderManageException {
		if (!(sessionOwnerName.equals(ownerName) && sessionOId.equals(oId))) {
			log.error("(비 회원) 주문 정보 조회 결과 값이 없음.");
			throw new OrderManageException("(비 회원) 주문 정보 조회 결과 값이 없음.");
		}
	}

	public static boolean orderStatusValidateCheckForOrderManage(OrderStatusType myOrderSubStatus){
		return !myOrderSubStatus.equals(OrderStatusType.COMPLETION_DISPATCH) ? true : false ;
	}

	public static boolean orderStatusValidateCheckForShippingStatus(int maxOsStatusCode, ShippingStatusType compareShippingStatus){
		return !Lists.newArrayList(ShippingStatusType.values()).stream().filter(e -> e.getOrderStatusTypeCodes().contains(maxOsStatusCode)).findFirst().get().equals(compareShippingStatus) ? true : false;
	}

	public static OrderStatusType getMaxOrderSubByOrderSubList(OrderShippingInfo orderShippingInfo){
		return orderShippingInfo.getOrderSubList().stream().max(Comparator.comparing(e -> e.getOrderSub().getOsStatus().getCode())).get().getOrderSub().getOsStatus();
	}

	public static double getCurrentUsd() throws GetUsdException{
		RestTemplate restTemplate = new RestTemplate();
		URI uri = UriComponentsBuilder.newInstance().scheme("http").host("query.yahooapis.com")
				.path("/v1/public/yql")
				.queryParam("q", "select * from yahoo.finance.xchange where pair='USDKRW'")
				.queryParam("format", "json")
				.queryParam("diagnostics", true)
				.queryParam("env", "store://datatables.org/alltableswithkeys")
				.build().encode().toUri();

		String response = restTemplate.getForObject(uri, String.class);
		JSONObject jsonObject = JSONObject.fromObject(response);

		String currentUsdString = jsonObject.getJSONObject("query").getJSONObject("results").getJSONObject("rate").get("Rate").toString();
		if(StringUtils.isEmpty(currentUsdString))
			throw new GetUsdException("환율 조회에 실패하였습니다.");

		double currentUsd = Double.parseDouble(currentUsdString);
		if(currentUsd <= 0)
			throw new GetUsdException("조회한 환율 값이 0보다 같거나 작습니다.");

		return currentUsd;
	}
}