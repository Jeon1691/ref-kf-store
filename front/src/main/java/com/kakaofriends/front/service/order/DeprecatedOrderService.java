package com.kakaofriends.front.service.order;

import com.kakaofriends.front.domain.order.OrderSheetDto;
import com.kakaofriends.front.domain.order.OrderSheetExpansion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Deprecated
public interface DeprecatedOrderService {

	ModelAndView getModelAndViewForBasket(OrderSheetDto.OrderSheetRequest orderSheetRequest, RedirectAttributes redirectAttributes, HttpServletResponse httpServletResponse);

	ModelAndView getModelAndViewForDirect(OrderSheetDto.OrderSheetRequest orderSheetRequest, RedirectAttributes redirectAttributes, HttpServletResponse httpServletResponse);

	List<Long> getCheckedPrEas(List<Integer> checkBoxFlags, List<Long> prEas);

	long getBasketAccount(OrderSheetExpansion orderSheetExpansion);

	String getProductName(List<OrderSheetExpansion> orderSheetExpansionList, String locale);

	int basketPrEaUpdateToBasket(List<String> prCodes, OrderSheetDto.OrderSheetRequest orderSheetRequest, String customProductMsg, String oaCountryCode); //2018.01.16 수정

	/**
	 * 구매하고자 하는 상품 정보조회 (bs_seq 이용) 2018.01.28 layla
	 * @param orderSheetBsSeqList, ownerId
	 * @return List<OrderSheetExpansion> 구매하고자하는 상품정보
	 */
	List<OrderSheetExpansion> findByOrderSheetCodeListFromBasketSeq(List<Long> orderSheetBsSeqList, String ownerId, String countryCode);

}