package com.kakaofriends.front.controller.common;

import com.google.common.collect.ImmutableMap;
import com.kakaofriends.front.common.exception.OrderManageException;
import com.kakaofriends.front.domain.*;
import com.kakaofriends.front.domain.mypage.TbKfoMbsCouponHistoryList;
import com.kakaofriends.front.domain.order.OrderSubDto;
import com.kakaofriends.front.service.mypage.MyCouponService;
import com.kakaofriends.front.service.mypage.MyOrderedService;
import com.kakaofriends.front.service.mypage.OrderTrackingService;
import com.kakaofriends.front.utils.FriendsUtil;
import com.kakaofriends.front.utils.LocaleUtils;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.kakaofriends.core.utils.KakaoFriendsConstants.RECENT_ORDER_ADDRESS_LIMIT;
import static com.kakaofriends.front.utils.FriendsUtil.getFriendsMemberId;
import static com.kakaofriends.front.utils.FriendsUtil.processMessage;
import static java.util.stream.Collectors.toList;

@Slf4j
@Controller
public class PopupController {

    @Autowired
    private MyOrderedService myOrderedService;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private OrderTrackingService orderTrackingService;

    @Autowired
    private MyCouponService myCouponService;

    @Autowired
    private LocaleUtils localeUtils;

    @GetMapping(value="/popup/noti")
    public ModelAndView notiPopup(@RequestParam(value="messageCode") String messageCode, @RequestParam(value="returnUrl") String returnUrl) throws MalformedURLException {
        ModelAndView mav = new ModelAndView();
        mav.addObject("popupMessage", messageSource.getMessage(messageCode, null, new Locale(localeUtils.whereAreYou())));
        mav.addObject("returnUrl", returnUrl);
        if(returnUrl.equals("undefined")) {
            mav.setViewName("common/popup/alert");
        } else {
            mav.setViewName("common/popup/notice");
        }
        return mav;
    }

    @GetMapping(value = "/popup/provision/{provisionCode}")
    public ModelAndView provisionPopup(@PathVariable(value="provisionCode") String provisionCode) throws MalformedURLException {
        ModelAndView mav = new ModelAndView();
        Locale locale = new Locale(localeUtils.whereAreYou());

        String provision = "common/popup/provision" + provisionCode;

        if(!locale.getLanguage().equals("") && !locale.getLanguage().equals("kr")) {
            provision += "En";
        }
        mav.setViewName(provision);
        return mav;
    }

    @GetMapping(value = "/popup/alert")
    public ModelAndView alertPopup(String popupMessage, HttpServletRequest httpServletRequest) throws MalformedURLException {
        String refererUrl = httpServletRequest.getHeader("referer");
        URL url = new URL(refererUrl);
        String [] pathSplitArr = url.getPath().split("/");
        String language = pathSplitArr[1];

        ModelAndView mav = new ModelAndView();
        String message;

        if(language.equals("") || language.equals("en")){
            message = messageSource.getMessage(popupMessage, null, Locale.US);
        } else {
            message = messageSource.getMessage(popupMessage, null, Locale.KOREA);
        }
        mav.addObject("popupMessage",  message);
        mav.setViewName("common/popup/alert");
        return mav;
    }

    @GetMapping(value = "/popup/confirm")
    public ModelAndView confirmPopup(PopupRequestDto.CommonConfirmRequest request) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("popupMessage", processMessage(messageSource, request.getPopupMessage()));
        mav.addObject("returnUrl", request.getReturnUrl());
        mav.setViewName("common/popup/confirm");
        return mav;
    }

    @GetMapping(value = "/popup/globalNation")
    public String globalNationPopup(HttpServletRequest httpServletRequest) throws MalformedURLException {
        String refererUrl = httpServletRequest.getHeader("referer");
        URL url = new URL(refererUrl);
        String [] pathSplitArr = url.getPath().split("/");
        String language = pathSplitArr[1];
        if(language.equals("") || language.equals("kr"))
            return "common/popup/globalNation";
        else
            return "common/popup/globalNationEn";
    }

    @GetMapping(value = "/popup/orderalert")
    public String orderAlertPopup(HttpServletRequest httpServletRequest) throws MalformedURLException {
        String refererUrl = httpServletRequest.getHeader("referer");
        URL url = new URL(refererUrl);
        String [] pathSplitArr = url.getPath().split("/");
        String language = pathSplitArr[1];
        if(language.equals("") || language.equals("kr"))
            return "common/popup/orderAlert";
        else
            return "common/popup/orderAlertEn";
    }

    @GetMapping(value = "/popup/orderinfo")
    public String orderInfoPopup(HttpServletRequest httpServletRequest) throws MalformedURLException {
        String refererUrl = httpServletRequest.getHeader("referer");
        URL url = new URL(refererUrl);
        String [] pathSplitArr = url.getPath().split("/");
        String language = pathSplitArr[1];
        if(language.equals("") || language.equals("kr"))
            return "common/popup/orderInfo";
        else
            return "common/popup/orderInfoEn";
    }

    @GetMapping(value = "/popup/login")
    public String loginPopup(HttpServletRequest httpServletRequest) throws MalformedURLException {
        String language = localeUtils.whereAreYou();
        if(language.equals("") || language.equals("kr"))
            return "common/popup/login";
        else
            return "common/popup/loginEn";
    }

    @GetMapping(value = "/popup/basket")
    public String basketPopup() { return "common/popup/basket"; }

    @GetMapping(value = "/popup/deliverysearch")
    public String deliverySearchPopup() {
        return "common/popup/deliverySearch";
    }

    @GetMapping(value = "/popup/privacywrite")
    public String privacyWritePopup(HttpServletRequest httpServletRequest) throws MalformedURLException {
        String refererUrl = httpServletRequest.getHeader("referer");
        URL url = new URL(refererUrl);
        String [] pathSplitArr = url.getPath().split("/");
        String language = pathSplitArr[1];
        if(language.equals("") || language.equals("kr"))
            return "common/popup/privacyWrite";
        else
            return "common/popup/privacyWriteEn";

    }

    @GetMapping(value = "/popup/privacyorder/{privacyType}")
    public ModelAndView privacyOrderPopup(@PathVariable String privacyType, HttpServletRequest httpServletRequest) throws MalformedURLException {
        System.out.println(privacyType);
        String refererUrl = httpServletRequest.getHeader("referer");
        URL url = new URL(refererUrl);
        String [] pathSplitArr = url.getPath().split("/");
        String language = pathSplitArr[1];
        ModelAndView mav = new ModelAndView();
        if(language.equals("") || language.equals("kr"))
            mav.setViewName("common/popup/privacyOrder");
        else
            mav.setViewName("common/popup/privacyOrderEn");

        mav.addObject("privacyType", privacyType);
        return mav;
    }

    @GetMapping(value = "/popup/orderAttention")
    public String orderAttentionPopup(HttpServletRequest httpServletRequest) throws MalformedURLException {
        String language = localeUtils.whereAreYou();
        if(language.equals("") || language.equals("kr"))
            return "common/popup/orderAttention";
        else
            return "common/popup/orderAttentionEn";
    }

    @GetMapping(value = "/popup/nonmember")
    public String nonMemberPopup(HttpServletRequest httpServletRequest) throws MalformedURLException {
        String language = localeUtils.whereAreYou();
        if(language.equals("") || language.equals("kr"))
            return "common/popup/nonMember";
        else
            return "common/popup/nonMemberEn";
    }

    @GetMapping(value = "/popup/myPage")
    public ModelAndView myPagePopup(PopupRequestDto.CommonConfirmRequest request) {

        log.info("### myPagePopup : request : "+ request);
        ModelAndView mav = new ModelAndView();
        mav.addObject("popupMessage", processMessage(messageSource, request.getPopupMessage()));
        mav.addObject("returnUrl", request.getReturnUrl());
        mav.setViewName("common/popup/myPage");
        return mav;
    }

    @GetMapping(value = "/popup/orderCancel")
    public ModelAndView orderCancel(PopupRequestDto.OrderManageRequest request) {

        log.info("### orderCancel : request : "+ request);
        ModelAndView mav = new ModelAndView();
        mav.addObject("popupMessage", processMessage(messageSource, request.getPopupMessage()));
        mav.addObject("orderManageRequest", request);
        mav.addObject("returnUrl", request.getReturnUrl());
        mav.setViewName("common/popup/orderPurchaseFinalized");
        return mav;
    }

    @GetMapping(value = "/popup/orderReturnAll")
    public ModelAndView orderReturnAll(PopupRequestDto.OrderManageRequest request) {

        log.info("### orderReturnAll : request : "+ request);

        ModelAndView mav = new ModelAndView();
        mav.addObject("popupMessage", processMessage(messageSource, request.getPopupMessage()));
        mav.addObject("orderManageRequest", request);
        mav.addObject("returnUrl", request.getReturnUrl());
        mav.setViewName("common/popup/orderReturnAll");
        return mav;
    }

    @GetMapping(value = "/popup/orderPurchaseFinalized")
    public ModelAndView orderPurchaseFinalized(PopupRequestDto.OrderManageRequest request) {

        log.info("### orderPurchaseFinalized : request : "+ request);
        ModelAndView mav = new ModelAndView();
        mav.addObject("popupMessage", processMessage(messageSource, request.getPopupMessage()));
        mav.addObject("orderManageRequest", request);
        mav.addObject("returnUrl", request.getReturnUrl());
        mav.setViewName("common/popup/orderPurchaseFinalized");
        return mav;
    }


    @GetMapping(value = "/popup/orderExchangeReturn")
    public ModelAndView orderExchangeReturn(PopupRequestDto.OrderManageRequest request, HttpServletRequest httpServletRequest) throws OrderManageException, MalformedURLException {

        log.info("### orderExchangeReturn : request : "+ request);

        String refererUrl = httpServletRequest.getHeader("referer");
        URL url = new URL(refererUrl);
        String [] pathSplitArr = url.getPath().split("/");
        String language = pathSplitArr[1];

        OrderSubDto.OrderSubShipping orderSubShipping = myOrderedService.findOrderSubWithPrImageByOrderSubSequence(request.getOrderSubSequence());
        ModelAndView mav = new ModelAndView();
        mav.addObject("orderSubShipping", orderSubShipping);
        mav.addObject("popupMessage", processMessage(messageSource, request.getPopupMessage()));
        mav.addObject("returnUrl", request.getReturnUrl());
        if(language.equals("") || language.equals("kr"))
            mav.setViewName("common/popup/orderExchangeReturn");
        else
            // properties 설정 되어있어서 일단 kr과 동일하게
            mav.setViewName("common/popup/orderExchangeReturn");
        return mav;
    }

    @GetMapping(value = "/popup/nonpayment")
    public String nonPaymentlPopup() {
        return "common/popup/nonPayment";
    }

    @GetMapping(value = "/popup/deliveryaddress")
    public ModelAndView deliveryAddressPopup() {
        String memberId = getFriendsMemberId();
        ModelAndView mav = new ModelAndView();
        mav.addObject("deliveryaddress", myOrderedService.findRecentOrderAddress(memberId).stream().distinct().limit(RECENT_ORDER_ADDRESS_LIMIT).collect(toList()));
        mav.setViewName("common/popup/deliveryAddress");
        return mav;
    }

    @GetMapping(value = "/popup/globalShipSearch/{orderNum}")
    public ModelAndView globalShipSearchPopup(@PathVariable String orderNum, HttpServletRequest httpServletRequest) throws OrderManageException, MalformedURLException {

        String refererUrl = httpServletRequest.getHeader("referer");
        URL url = new URL(refererUrl);
        String [] pathSplitArr = url.getPath().split("/");
        String language = pathSplitArr[1];

        List<OrderTracking> orderTracking = orderTrackingService.getTrakingBoxInfoByOrderNum(orderNum);
        ModelAndView mav = new ModelAndView();
        mav.addObject("orderTrackingList", orderTracking);
        if(language.equals("") || language.equals("kr"))
            mav.setViewName("common/popup/globalShipSearch");
        else
            mav.setViewName("common/popup/GlobalShipSearchEn");

        return mav;
    }

    @GetMapping(value = "/popup/globalShipTracking/{boxPk}")
    public ModelAndView globalShipTrackingPopup(@PathVariable String boxPk, HttpServletRequest httpServletRequest) throws OrderManageException, MalformedURLException {

        String refererUrl = httpServletRequest.getHeader("referer");
        URL url = new URL(refererUrl);
        String [] pathSplitArr = url.getPath().split("/");
        String language = pathSplitArr[1];

        List<OrderTracking> orderTrackingList = orderTrackingService.getTrakingBoxDetailInfoByBoxPk(boxPk);
        ModelAndView mav = new ModelAndView();

        mav.addObject("orderTrackingDetailList", getOrderTrackingDetail(orderTrackingList, language));

        if(language.equals("") || language.equals("kr"))
            mav.setViewName("common/popup/globalShipTracking");
        else
            mav.setViewName("common/popup/globalShipTrackingEn");
        return mav;
    }

    @GetMapping(value = "/popup/coupon")
    public ModelAndView couponPopup(HttpServletRequest httpServletRequest, @ModelAttribute TbKfoMbsCouponHistoryList couponList) throws MalformedURLException {
        String refererUrl = httpServletRequest.getHeader("referer");
        URL url = new URL(refererUrl);
        String [] pathSplitArr = url.getPath().split("/");
        String language = pathSplitArr[1];
        String memberId = getFriendsMemberId();
        ModelAndView mav = new ModelAndView();

        mav.addObject("myAvailableCouponList", couponList.getCouponHistoryList());
        if(language.equals("") || language.equals("kr"))
            mav.setViewName("common/popup/coupon");
        else
            mav.setViewName("common/popup/couponEn");
        return mav;
    }

    @GetMapping(value = "/popup/payonly")
    public String payonlyPopup(HttpServletRequest httpServletRequest) throws MalformedURLException {
        String refererUrl = httpServletRequest.getHeader("referer");
        URL url = new URL(refererUrl);
        String [] pathSplitArr = url.getPath().split("/");
        String language = pathSplitArr[1];
        if(language.equals("") || language.equals("kr"))
            return "common/popup/payonly";
        else
            return "common/popup/payonlyEn";
    }

    @GetMapping(value = "/popup/benefit")
    public String benefitPopup(HttpServletRequest httpServletRequest) throws MalformedURLException {
        String refererUrl = httpServletRequest.getHeader("referer");
        URL url = new URL(refererUrl);
        String [] pathSplitArr = url.getPath().split("/");
        String language = pathSplitArr[1];
        if(language.equals("") || language.equals("kr"))
            return "common/popup/benefit";
        else
            return "common/popup/benefitEn";
    }

    public List<OrderTrackingDetail> getOrderTrackingDetail(List<OrderTracking> orderTrackingList, String language){
        List<OrderTrackingDetail> orderTrackingDetailList = new ArrayList<>();
        String titleDate = null;

        for(OrderTracking orderTracking : orderTrackingList){
            String formattedDate = trackingDateFormatter(orderTracking.getTrackingDate(), language);
            orderTracking.setTrackingTime(trackingTimeFormatter(orderTracking.getTrackingDate()));
            if(language.equals("en")){
                orderTracking.setTrackingStatusKr(EmsDeliStatusType.getStatusEnByStatusCode(orderTracking.getTrackingStatus()));
            }

            if(titleDate == null || !titleDate.equals(formattedDate)){
                List<OrderTracking> orderTrackings = new ArrayList<>();
                orderTrackings.add(orderTracking);
                orderTrackingDetailList.add(new OrderTrackingDetail(formattedDate, orderTrackings));
            }else{
                orderTrackingDetailList.get(orderTrackingDetailList.size()-1).getOrderTrackingList().add(orderTracking);
            }
            titleDate = formattedDate;
        }

        return orderTrackingDetailList;
    }

    public String trackingDateFormatter(Date date, String language){
        StringBuilder dateString = new StringBuilder();
        if(language.equals("kr")) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 ");
            dateString.append(simpleDateFormat.format(date)).append(getDay(date, language)).append("요일");
        }else{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(" MM dd, yyyy");
            dateString.append(getDay(date, language)).append(simpleDateFormat.format(date));
        }
        return dateString.toString();
    }

    public String trackingTimeFormatter(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        StringBuilder formattedTime = new StringBuilder();
        if(calendar.get(Calendar.AM_PM) == Calendar.AM)
            formattedTime.append("AM ");
        else
            formattedTime.append("PM ");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
        return formattedTime.append(simpleDateFormat.format(date)).toString();
    }

    public String getDay(Date date, String language){
        String day = null;
        Calendar cal = Calendar.getInstance() ;
        cal.setTime(date);
        int dayNum = cal.get(Calendar.DAY_OF_WEEK) ;

        switch(dayNum){
            case 1:
                if(language.equals("kr"))
                    day = "일";
                else
                    day = "Sunday";
                break ;
            case 2:
                if(language.equals("kr"))
                    day = "월";
                else
                    day = "Monday";
                break ;
            case 3:
                if(language.equals("kr"))
                    day = "화";
                else
                    day = "Tuesday";
                break ;
            case 4:
                if(language.equals("kr"))
                    day = "수";
                else
                    day = "Wednesday";
                break ;
            case 5:
                if(language.equals("kr"))
                    day = "목";
                else
                    day = "Thursday";
                break ;
            case 6:
                if(language.equals("kr"))
                    day = "금";
                else
                    day = "Friday";
                break ;
            case 7:
                if(language.equals("kr"))
                    day = "토";
                else
                    day = "Sa";
                break ;
        }
        return day;
    }


    @GetMapping(value = "/popup/int")
    public String initialPopup() {
        return "common/popup/int";
    }

    @GetMapping(value = "/popup/withdraw")
    public String withdraw() {
        String locale = localeUtils.whereAreYou();
        String url = "";
        if("kr".equalsIgnoreCase(locale)) {
            url = "common/popup/withdraw";
        } else {
            url = "common/popup/withdrawEn";
        }
        return url;
    }

    @GetMapping(value="/membership/barcode")
    @ResponseBody
    public String getMembershipBarcode() throws Exception {
        Member friendsMember = FriendsUtil.getFriendsMember();
        Long memberId = friendsMember.getId();
        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(this.callCrm("/api/store/memberships/" + memberId, Map.class));

        if (result instanceof String)
            return (String)result;
        else
            return "";
    }

    public Map[] getPointHistory() throws Exception {
        Member friendsMember = FriendsUtil.getFriendsMember();
        Long memberId = friendsMember.getId();

        Object result = this.callCrm("/api/store/memberships/" + memberId + "/history", Map[].class);

        if (result instanceof Map[])
            return (Map[])result;
        else
            return new Map[]{};
    }

    private Object callCrm(String api, Class returnType) throws Exception {
        Member friendsMember = FriendsUtil.getFriendsMember();
        Long memberId = friendsMember.getId();

        if (memberId != null) {
            String profile = System.getProperties().getProperty("spring.profiles.active", "");
            String serverUri;
            String authId;
            String authPw;

            if (profile.equalsIgnoreCase("local") || profile.equalsIgnoreCase("development")) {
                serverUri = "https://dev-crm.kakaofriends.com";
                authId = "store";
                authPw = "pwstore";
            } else if (profile.equalsIgnoreCase("stage")) {
                serverUri = "https://stage-crm.kakaofriends.com";
                authId = "store";
                authPw = "$2a$10$BsTjnFMV5IGo2lXyVmH2k.eqfxh/S1ENYYVHMZSKZtAlAQYyEL5WS";
            } else {
                serverUri = "https://crm.kakaofriends.com";
                authId = "store";
                authPw = "$2a$10$BsTjnFMV5IGo2lXyVmH2k.eqfxh/S1ENYYVHMZSKZtAlAQYyEL5WS";
            }

            Object resp = null;

            try {
                RestTemplate restTemplate = new RestTemplate();

                restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(authId, authPw));
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

                resp = restTemplate.getForObject(serverUri + api, returnType);
            } catch (HttpStatusCodeException e) {
                log.info("resp = " + resp);
                log.info("e.getStatusCode() = " + e.getStatusCode());
                log.info("e.getStatusText() = " + e.getStatusText());
                log.info("e.getResponseBodyAsString() = " + e.getResponseBodyAsString());

                e.printStackTrace();

                resp = ImmutableMap.of(
                        "error",
                        "서버와의 통신에 실패했습니다. " +
                                profile + ", " +
                                e.getStatusCode() + ", " +
                                e.getStatusText() + ", " +
                                e.getStatusText()
                );
            } catch (Exception e) {
                e.printStackTrace();

                resp = ImmutableMap.of("error", "서버에러가 발생했습니다.");
            }

            return resp;
        }

        return ImmutableMap.of("error", "멤버십에 가입되어있지 않습니다.");
    }
}