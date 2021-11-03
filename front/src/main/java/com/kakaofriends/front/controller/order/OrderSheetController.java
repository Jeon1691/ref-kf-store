package com.kakaofriends.front.controller.order;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kakaofriends.core.domain.Basket;
import com.kakaofriends.core.domain.Config;
import com.kakaofriends.core.domain.Product;
import com.kakaofriends.core.utils.KakaoFriendsConstants;
import com.kakaofriends.core.utils.KakaoFriendsUtil;
import com.kakaofriends.front.common.annotation.FriendsGlobal;
import com.kakaofriends.front.common.event.GlobalEmsEvent;
import com.kakaofriends.front.common.exception.SessionTimeOutException;
import com.kakaofriends.front.common.external.ExchangeRateComponent;
import com.kakaofriends.front.domain.*;
import com.kakaofriends.front.domain.basket.BasketExpansion;
import com.kakaofriends.front.domain.common.CountryVO;
import com.kakaofriends.front.domain.mypage.MembershipVO;
import com.kakaofriends.front.domain.mypage.MyCouponCode;
import com.kakaofriends.front.domain.mypage.TbKfoMbsCouponHistory;
import com.kakaofriends.front.domain.order.OrderSheetDto;
import com.kakaofriends.front.domain.order.OrderSheetExpansion;
import com.kakaofriends.front.domain.order.OrderSheetRequestVO;
import com.kakaofriends.front.repository.ConfigRepository;
import com.kakaofriends.front.repository.ProductRepository;
import com.kakaofriends.front.service.EmsService;
import com.kakaofriends.front.service.EventService;
import com.kakaofriends.front.service.MemberService;
import com.kakaofriends.front.service.mypage.MyCouponService;
import com.kakaofriends.front.service.mypage.MyOrderedService;
import com.kakaofriends.front.service.mypage.MyPointService;
import com.kakaofriends.front.service.order.BasketService;
import com.kakaofriends.front.service.order.DeprecatedOrderService;
import com.kakaofriends.front.service.order.OrderCommonService;
import com.kakaofriends.front.service.product.stock.StockService;
import com.kakaofriends.front.service.product.stock.vo.Stock;
import com.kakaofriends.front.utils.BoxUtil;
import com.kakaofriends.front.utils.FriendsUtil;
import com.kakaofriends.front.utils.LocaleUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.ToDoubleFunction;
import java.util.function.ToLongFunction;

import static com.kakaofriends.core.domain.OrderAddress.OA_DEFAULT_ADDRESS_TYPE;
import static com.kakaofriends.core.domain.OrderAddress.OA_NEW_ADDRESS_TYPE;
import static com.kakaofriends.core.utils.KakaoFriendsConstants.*;
import static com.kakaofriends.front.domain.EventDto.EVENT_USE_FLAG;
import static com.kakaofriends.front.domain.order.OrderSheetDto.CHANGE_NATION_SHIPPING_TYPE;
import static com.kakaofriends.front.utils.FriendsUtil.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

@Slf4j
@Controller
@FriendsGlobal
@RequestMapping( value = "/{language}" )
public class OrderSheetController {
    @Autowired
    private BasketService basketService;

    @Autowired
    private DeprecatedOrderService deprecatedOrderService;

    @Autowired
    private ConfigRepository configRepository;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private EmsService emsService;

    @Autowired
    private ExchangeRateComponent exchangeRateComponent;

    @Autowired
    private GlobalEmsEvent globalEmsEvent;

    @Autowired
    private MemberService memberService;

    @Autowired
    private MyPointService myPointService;

    @Autowired
    private MyCouponService myCouponService;

    @Autowired
    private EventService eventService;

    @Autowired
    private OrderCommonService orderCommonService;

    @Autowired
    private MyOrderedService myOrderedService;

    @Autowired
    private StockService stockService;

    @Autowired
    private LocaleUtils localeUtils;

    @Autowired
    private ProductRepository productRepository;

    private ToLongFunction<OrderSheetExpansion> longFunction = i -> i.getIsDiscountPeriod() ? i.getProductLevelPrice().getPrlpDiscountprice1() * i.getBsEa() : i.getProductLevelPrice().getPrlpSaleprice1() * i.getBsEa();
    private ToDoubleFunction<OrderSheetExpansion> doubleFunction = i -> i.getIsDiscountPeriod() ? i.getProductLevelPrice().getExchangeDiscountPrice() * i.getBsEa() : i.getProductLevelPrice().getExchangePrice() * i.getBsEa();

    /**
     * 장바구니 > 주문하기 페이지
     *
     * @param language
     * @param httpServletRequest
     * @param orderSheetRequest
     * @param redirectAttributes
     * @param httpServletResponse
     * @return
     */
    @PostMapping( value = "/order/sheet" )
    public ModelAndView ordersSheetPost( @PathVariable( "language" ) String language, HttpServletRequest httpServletRequest, OrderSheetDto.OrderSheetRequest orderSheetRequest, RedirectAttributes redirectAttributes, HttpServletResponse httpServletResponse ) {
        HttpSession httpSession = httpServletRequest.getSession();
        orderSheetRequest.setOrderDirect( BASKET_DIRECT_NO );
        httpSession.setAttribute( ORDER_SESSION_CHECK_KEY, ORDER_SESSION_CHECK_VALUE );
        httpSession.setAttribute( "orderSheetRequest", orderSheetRequest );
        ModelAndView mav = getModelAndViewForBasket( httpServletRequest, language, orderSheetRequest, redirectAttributes, httpServletResponse );
        return mav;
    }

    /**
     * 장바구니 > 주문하기 페이지
     *
     * @param language
     * @param httpServletRequest
     * @param redirectAttributes
     * @param httpServletResponse
     * @return
     */
    @GetMapping( value = "/order/sheet" )
    public ModelAndView ordersSheetGet( @PathVariable( "language" ) String language, HttpServletRequest httpServletRequest, RedirectAttributes redirectAttributes, HttpServletResponse httpServletResponse ) {
        HttpSession httpSession = httpServletRequest.getSession();
        httpSession.setAttribute( ORDER_SESSION_CHECK_KEY, ORDER_SESSION_CHECK_VALUE );
        ModelAndView mav;
        OrderSheetDto.OrderSheetRequest orderSheetRequest = (OrderSheetDto.OrderSheetRequest) httpSession.getAttribute( "orderSheetRequest" );
        if ( orderSheetRequest == null ) {
            throw new SessionTimeOutException();
        }
        orderSheetRequest.setOrderDirect( BASKET_DIRECT_NO );
        mav = getModelAndViewForBasket( httpServletRequest, language, orderSheetRequest, redirectAttributes, httpServletResponse );
        return mav;
    }

    @PostMapping( value = "/order/directsheet" )
    public ModelAndView directOrdersSheetPost( @PathVariable( "language" ) String language, HttpServletRequest httpServletRequest, OrderSheetDto.OrderSheetRequest orderSheetRequest, RedirectAttributes redirectAttributes, HttpServletResponse httpServletResponse ) {
        HttpSession httpSession = httpServletRequest.getSession();
        orderSheetRequest.setBsSeq( orderSheetRequest.getBsSeq() );
        orderSheetRequest.setOrderDirect( BASKET_DIRECT_YES );

        if ( orderSheetRequest.getPrEas().size() == 0 && httpServletRequest.getParameter( "prEa" ) != null ) {
            orderSheetRequest.getPrEas().add( Long.valueOf( httpServletRequest.getParameter( "prEa" ) ) );

            if ( orderSheetRequest.getDisplayGoodsIds() == null ) {
                ArrayList<Long> displayGoodsIdsList = new ArrayList<>();
                displayGoodsIdsList.add( Long.valueOf( httpServletRequest.getParameter( "displayGoodsId" ) ) );
                orderSheetRequest.setDisplayGoodsIds( displayGoodsIdsList );
            }
        }

        httpSession.setAttribute( ORDER_SESSION_CHECK_KEY, ORDER_SESSION_CHECK_VALUE );
        httpSession.setAttribute( "orderSheetRequest", orderSheetRequest );
        ModelAndView mav = getModelAndViewForBasket( httpServletRequest, language, orderSheetRequest, redirectAttributes, httpServletResponse );
        return mav;
    }

    /**
     * 상품 상세 > 주문하기 페이지
     *
     * @param language
     * @param httpServletRequest
     * @param redirectAttributes
     * @param httpServletResponse
     * @return
     */
    @GetMapping( value = "/order/directsheet" )
    public ModelAndView directOrdersSheetGet( @PathVariable( "language" ) String language, HttpServletRequest httpServletRequest, RedirectAttributes redirectAttributes, HttpServletResponse httpServletResponse ) {
        HttpSession httpSession = httpServletRequest.getSession();
        httpSession.setAttribute( ORDER_SESSION_CHECK_KEY, ORDER_SESSION_CHECK_VALUE );
        OrderSheetDto.OrderSheetRequest orderSheetRequest = (OrderSheetDto.OrderSheetRequest) httpSession.getAttribute( "orderSheetRequest" );
        if ( orderSheetRequest == null ) {
            throw new SessionTimeOutException();
        }
        orderSheetRequest.setBsSeq( orderSheetRequest.getBsSeq() );
        orderSheetRequest.setOrderDirect( BASKET_DIRECT_YES );
        ModelAndView mav = getModelAndViewForBasket( httpServletRequest, language, orderSheetRequest, redirectAttributes, httpServletResponse );
        return mav;
    }

    /**
     * 장바구니 목록 사용하여 MAV셋팅
     *
     * @param httpServletRequest
     * @param language
     * @param orderSheetRequest
     * @param redirectAttributes
     * @param httpServletResponse
     * @return
     */
    private ModelAndView getModelAndViewForBasket( HttpServletRequest httpServletRequest, String language, OrderSheetDto.OrderSheetRequest orderSheetRequest, RedirectAttributes redirectAttributes, HttpServletResponse httpServletResponse ) {
        OrderSheetRequestVO orderSheetRequestVo = new OrderSheetRequestVO();
        List<Boolean> isNotGiftBag = new ArrayList<>();
        String userId = getFriendsMemberId();
        Boolean isBasketDirect = isBasketDirect( orderSheetRequest.getOrderDirect() );
        String oaCountryName = Country.getCountryNameByCode( Country.getCountryCodeByName( orderSheetRequest.getOaCountryName() != null ? orderSheetRequest.getOaCountryName() : "한국" ), language );
        //기본배송지 설정되어 있을시 배송지국가 새로 셋팅 2018.02.05 layla
        String countryCode = Country.getCountryCodeByName( oaCountryName );

        // 기본 배송지 정보 셋팅
        this.setMemberDefaultAddress( orderSheetRequestVo, orderSheetRequest, language );
        if ( orderSheetRequestVo.getMemberAddress() != null && orderSheetRequestVo.getMemberAddress().getCountryCode() != null ) {
            countryCode = orderSheetRequestVo.getMemberAddress().getCountryCode();
            oaCountryName = Country.getCountryNameByCode( orderSheetRequestVo.getMemberAddress().getCountryCode(), language );
        }
        orderSheetRequest.setOaCountryName( oaCountryName );
        orderSheetRequestVo.setOaCountryName( oaCountryName );


        //상품 리스트
        List<OrderSheetExpansion> orderSheetExpansionList = deprecatedOrderService.findByOrderSheetCodeListFromBasketSeq( orderSheetRequest.getBsSeq(), userId, countryCode );
        if ( orderSheetExpansionList.size() == 0 ) {
            throw new SessionTimeOutException();
        }

        orderSheetRequestVo.setProductName( deprecatedOrderService.getProductName( orderSheetExpansionList, language ) );
        orderSheetRequestVo.setOaAddressType( StringUtils.isEmpty( orderSheetRequest.getOaAddressType() ) ? OA_DEFAULT_ADDRESS_TYPE : orderSheetRequest.getOaAddressType() );
        orderSheetRequestVo.setMemberId( userId );
        orderSheetRequestVo.setMember( getFriendsMemberOrderInfo() );
        orderSheetRequestVo.setMemberCountryName( Country.getCountryNameByCode( Country.getCountryCodeByName( getFriendsMember().getCountry() ), language ) );

        String email = getFriendsMember().getEmail();

        // 4탭 여부에 상관없이 임의로 생성된 메일일 경우에는 공백 처리
        if ( !email.equals( KakaoFriendsConstants.NONMEMBER ) && email.startsWith( "kakao" ) && email.endsWith( "@kakao.com" ) ) {
            email = "";
        }

        if ( email.equals( KakaoFriendsConstants.NONMEMBER ) ) {
            email = "";
        }
        orderSheetRequestVo.setMemberEmail( email.isEmpty() ? "" : email.substring( 0, getFriendsMember().getEmail().indexOf( "@" ) ) );
        orderSheetRequestVo.setMemberEmailDomain( email.isEmpty() ? "" : email.substring( getFriendsMember().getEmail().indexOf( "@" ) + 1, getFriendsMember().getEmail().length() ) );

        orderSheetRequestVo.setExchangeRate( exchangeRateComponent.getExchangeRate() );
        orderSheetRequestVo.setAnonymousUser( isAnonymousUser() );
        orderSheetRequestVo.setDeliveryaddress( myOrderedService.findRecentOrderAddress( userId ).stream().distinct().limit( RECENT_ORDER_ADDRESS_LIMIT ).collect( toList() ) );
        getModelAndViewObject( httpServletRequest, orderSheetExpansionList, httpServletResponse, language, countryCode, orderSheetRequestVo );

        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion( JsonInclude.Include.NON_NULL );
        String orderSheetRequestVoData = null;
        try {
            orderSheetRequestVoData = mapper.writeValueAsString( orderSheetRequestVo );
        } catch ( IOException e ) {
            System.out.println( "주문화면 Json 에러" );
        }

        ModelAndView mav = new ModelAndView();
        mav.addObject( "orderSheetRequestVo", orderSheetRequestVoData );

        //		pay only
        String oaCountryCode;
        if (oaCountryName != null) {
            // 국문 영문 이동시 oaCountryName을 지닌 상태로 이동하는 경우가 있어 국가명 -> 국가코드 -> 언어에 맞는 국가명
            oaCountryName = Country.getCountryNameByCode(Country.getCountryCodeByName(oaCountryName), language.toLowerCase());
        } else {
            oaCountryName = language.toLowerCase().equals("kr") ? "한국" : "Korea";
        }
        oaCountryCode = Country.getCountryCodeByName(oaCountryName);

        List<BasketExpansion> basketExpansions = basketService.findByBsOwnerId(getFriendsMemberId(), oaCountryCode);

        boolean isPayOnlyItemContains = false;
        boolean isNormalItemContains = false;
        boolean isPayOnlyDispcode = false;


        if ( !isBasketDirect) {

            Iterator<BasketExpansion> itr = basketExpansions.iterator();

            while ( itr.hasNext() ) {
                BasketExpansion basketExpansion = itr.next();
                String prcode = basketExpansion.getBasket().getBsPrCode();
                boolean isPayOnly = KakaoFriendsUtil.isPayOnlyPrcode( prcode );

                // pay only가 1개라도 있는지 채크
                if ( !isPayOnlyItemContains && isPayOnly ) {
                    isPayOnlyItemContains = isPayOnly;
                }

                // 일반 상품이 1개라도 있는지 채크
                if ( !isNormalItemContains && !isPayOnly ) {
                    isNormalItemContains = !isPayOnly;
                }

                if ( KakaoFriendsUtil.getPayOnlyDispCodes().contains( basketExpansion.getDisplayGoodsId() )){
                    isPayOnlyDispcode = true;
                }

            }
        }
        else {
            Iterator<OrderSheetExpansion> itr = orderSheetExpansionList.iterator();
            while ( itr.hasNext() ) {
                OrderSheetExpansion orderSheetExpansion = itr.next();
                String prcode = orderSheetExpansion.getProduct().getPrCode();
                boolean isPayOnly = KakaoFriendsUtil.isPayOnlyPrcode( prcode );

                // pay only가 1개라도 있는지 채크
                if ( !isPayOnlyItemContains && isPayOnly ) {
                    isPayOnlyItemContains = isPayOnly;
                }

                // 일반 상품이 1개라도 있는지 채크
                if ( !isNormalItemContains && !isPayOnly ) {
                    isNormalItemContains = !isPayOnly;
                }

                if ( KakaoFriendsUtil.getPayOnlyDispCodes().contains( orderSheetExpansion.getDisplayGoodsId() )){
                    isPayOnlyDispcode = true;
                }
            }
        }
        mav.addObject("canPurchasePayOnly", isPayOnlyItemContains && !isNormalItemContains);
        mav.addObject("isPayOnlyItemContains", isPayOnlyItemContains );
        mav.addObject("isNormalItemContains", isNormalItemContains );
        mav.addObject("payOnlyPrcodeSet", KakaoFriendsUtil.getPayOnlyPrcodes());
        mav.addObject("isPayOnlyDispcode", isPayOnlyDispcode);

        mav.setViewName( language + "/order/sheet" );
        return mav;
    }

    // 주문화면 로드 시 필요 데이터 셋팅
    private void getModelAndViewObject( HttpServletRequest httpServletRequest, List<OrderSheetExpansion> orderSheetExpansionList, HttpServletResponse httpServletResponse, String language, String countryCode, OrderSheetRequestVO orderSheetRequestVo ) {
        httpServletResponse.setHeader( "Pragma", "no-cache" ); //HTTP 1.0
        httpServletResponse.setHeader( "Cache-Control", "no-cache" ); //HTTP 1.1
        httpServletResponse.setHeader( "Cache-Control", "no-store" ); //HTTP 1.1
        httpServletResponse.setDateHeader( "Expires", 0L ); // Do not cache in proxy server

        BasketVO basketVo = makeBasketVo( orderSheetExpansionList, countryCode );

        orderSheetRequestVo.setBasketVO( basketVo );
        orderSheetRequestVo.setMembershipVO( makeMembershipVo( language, orderSheetExpansionList, basketVo, countryCode ) );
        orderSheetRequestVo.setCountryVO( makeCountryVo( language, countryCode ) );
        orderSheetRequestVo.setErrMsg( setRequestErrMsg( httpServletRequest ) );

        orderSheetRequestVo.setOrderCommonVO( orderCommonService.getOrderCommonData( getUserAgent( httpServletRequest ), getFriendsLocale( httpServletRequest ) ) );
    }

    /*
    쿠폰 하나와 상품들 조회
     */
    private Long getCouponMoneyByCategory( List<OrderSheetExpansion> sheetList, List<String> couponCategoryList ) {
        Long brAccountByCategory = 0L;
        for ( OrderSheetExpansion ose : sheetList ) {
            log.debug( "ct_seq " + ose.getBsCtSeq() );
            //쿠폰 별 카테고리 상품만 뽑아서 금액ㅍ 계산
            log.debug( "result: " + couponCategoryList.indexOf( ose.getBsCtSeq() ) );
            if ( !ose.getIsSoldOut() && couponCategoryList.indexOf( ose.getProduct().getPrCode() ) >= 0 ) {
                if ( ose.getIsDiscountPeriod() ) {
                    brAccountByCategory += ose.getProductLevelPrice().getPrlpDiscountprice1() * ose.getBsEa();
                } else {
                    brAccountByCategory += ose.getProductLevelPrice().getPrlpSaleprice1() * ose.getBsEa();
                }
            }
        }
        return brAccountByCategory;
    }

    private LinkedList<BoxItem> getItemList( List<OrderSheetExpansion> orderSheetExpansionList ) {
        LinkedList<BoxItem> itemList = new LinkedList<>();

        orderSheetExpansionList.forEach( e -> {
            long amount = e.getIsDiscountPeriod() ? e.getProductLevelPrice().getPrlpDiscountprice1() : e.getProductLevelPrice().getPrlpSaleprice1();
            for ( int i = 0; i < e.getBsEa(); i++ ) {
                Product product = e.getProduct();
                itemList.add( new BoxItem( product, amount, null ) );
            }
        } );

        // 사은품 행사: 박스 측정할때 여권 포함
        globalEmsEvent.addBoxItem( itemList );

        return itemList;
    }

    /**
     * 9월 글로벌 무료 배송 이벤트
     * basketAccount 추가 후 총 합계 비교해서 박스 가격 합치지 않음.
     *
     * @return
     */
    private Long getNationalDeliveryCharge( String countryCode, ArrayList<BoxItem> boxs, long basketAccount, EventDto globalEvent ) {
        Long nationalDeliveryCharge = new Long( 0L );
        if ( countryCode == null )
            return nationalDeliveryCharge;

        if ( !countryCode.equals( "KR" ) && !(countryCode.equals( "한국" ) || countryCode.toLowerCase().equals( "korea" )) ) {
            //글로벌 무료 배송 이벤트
            if ( globalEvent != null )
                return nationalDeliveryCharge;

            for ( int i = 0; i < boxs.size(); i++ ) {
                BoxItem box = boxs.get( i );
                Long emsPrice = emsService.getEmsPrice( countryCode, box.getWeight() );
                // 박스가격에 배송비 입력
                box.setAmount( emsPrice );
                if ( emsPrice != null ) {
                    nationalDeliveryCharge += emsPrice;
                }
            }
        }
        return nationalDeliveryCharge;
    }

    /**
     * 9월 글로벌 무료 배송 이벤트
     * 해외배송 국가 체크
     *
     * @param countryCode
     * @return
     */
    private boolean isGlobalDelivery( String countryCode ) {
        return !StringUtils.isEmpty( countryCode )
            && !countryCode.equals( "KR" )
            && !(countryCode.equals( "한국" )
            || countryCode.toLowerCase().equals( "korea" ));
    }

    private boolean isPointUse( double pointPrice ) {
        // 포인트 글로벌 변수 필요
        return pointPrice >= 0;
    }

    private void setMemberDefaultAddress( OrderSheetRequestVO orderSheetRequestVo, OrderSheetDto.OrderSheetRequest orderSheetRequest, String language ) {
        // 기본 배송지 정보 셋팅
        if ( isAnonymousUser() || (StringUtils.isNotEmpty( orderSheetRequest.getOaAddressType() ) && orderSheetRequest.getOaAddressType().equals( OA_NEW_ADDRESS_TYPE )) ) {
            orderSheetRequestVo.setMemberAddress( new MemberAddress() );
        } else {
            MemberAddress memberAddress = memberService.findMemberAddress( Integer.valueOf( getFriendsMemberId() ) );
            if ( memberAddress != null ) {
                if ( StringUtils.isEmpty( orderSheetRequest.getChangeNationType() ) || orderSheetRequest.getChangeNationType().equals( CHANGE_NATION_SHIPPING_TYPE ) ) {
                    orderSheetRequestVo.setMemberAddress( memberAddress );
                }
            }
        }
    }

    /**
     * 작성자 : layla
     * 날짜 : 2018. 1. 15.
     * <p>
     * 장바구니 상품 수량 업데이트
     *
     * @return
     */
    @RequestMapping( value = "/sheet/basketUpdate", method = RequestMethod.POST )
    public ResponseEntity<OrderSheetRequestVO> sheetBasketUpdateAjax( Basket basket, HttpServletRequest httpServletRequest ) {
        HttpSession httpSession = httpServletRequest.getSession();
        boolean haveMsg = false;
        OrderSheetDto.OrderSheetRequest orderSheetRequest = (OrderSheetDto.OrderSheetRequest) httpSession.getAttribute( "orderSheetRequest" );

        OrderSheetRequestVO orderSheetRequestVo = new OrderSheetRequestVO();
        orderSheetRequestVo.setExchangeRate( exchangeRateComponent.getExchangeRate() );
        String oaCountryCode = basket.getOaCountryCode();

        //판매 불가 상품 체크(스토어 노출 X)
        String productKrView = productRepository.getProductKrView( basket.getBsPrCode() );
        Stock stock = stockService.get( basket.getBsPrCode(), Country.isDomestic( oaCountryCode ) );


        if ( "N".equals( productKrView ) ) {
            //품절된 상품이 있을 경우 (스토어 노출 X)
            orderSheetRequestVo.setErrMsg( processMessage( messageSource, "unavailableProduct.invalid" ) );
            haveMsg = true;
        } else if ( stock != null && stock.getAvailableStock() <= 0 ) {
            //재고 없는 상품이 있을 경우
            orderSheetRequestVo.setErrMsg( processMessage( messageSource, "alert_stockEmtpy_products" ) );
            haveMsg = true;
        }

        //장바구니 수량 세션에 담겨있는 정보를 UPDATE해준다.
        if ( orderSheetRequest != null && orderSheetRequest.getPrCodes() != null && orderSheetRequest.getPrCodes().size() > 0 && orderSheetRequest.getPrEas() != null && orderSheetRequest.getPrEas().size() > 0 ) {
            int idx = 0;
/*            for (String prCode : orderSheetRequest.getPrCodes()) {

                if (prCode.equalsIgnoreCase(basket.getBsPrCode())) {
                    orderSheetRequest.getPrEas().set(idx, basket.getBsEa());
                    break;
                }
                idx++;
            }*/
            if ( orderSheetRequest.getDisplayGoodsIds() != null && (orderSheetRequest.getPrCodes().size() == orderSheetRequest.getDisplayGoodsIds().size()) ) {
                for ( String prCode : orderSheetRequest.getPrCodes() ) {

                    if ( prCode.equalsIgnoreCase( basket.getBsPrCode() ) && orderSheetRequest.getDisplayGoodsIds().get( idx ).equals( basket.getDisplayGoodsId() ) ) {
                        orderSheetRequest.getPrEas().set( idx, basket.getBsEa() );
                        break;
                    }
                    idx++;
                }
            }
        }

        int resultCode = deprecatedOrderService.basketPrEaUpdateToBasket( orderSheetRequest.getPrCodes(), orderSheetRequest, orderSheetRequest.getCustomProductMsg(), oaCountryCode );
        if ( resultCode == 1 && !haveMsg ) { // 장바구니 기프트백 체크 시 장바구니수량이 더 많음
            orderSheetRequestVo.setErrMsg( processMessage( messageSource, "alert_onlyGiftBag" ) );
        }

        List<OrderSheetExpansion> orderSheetExpansionList = deprecatedOrderService.findByOrderSheetCodeListFromBasketSeq( orderSheetRequest.getBsSeq(), getFriendsMemberId(), oaCountryCode );
        orderSheetRequestVo.setBasketVO( makeBasketVo( orderSheetExpansionList, oaCountryCode ) );
        httpSession.setAttribute( "orderSheetRequest", orderSheetRequest );
        return new ResponseEntity<>( orderSheetRequestVo, new HttpHeaders(), HttpStatus.OK );
    }

    /**
     * 작성자 : layla
     * 날짜 : 2018. 1. 28.
     * <p>
     * 국가선택 배송정보 업데이트 (상품가격, 상자, 중량, 배송비 등)
     *
     * @return
     */
    @RequestMapping( value = "/sheet/deliUpdate", method = RequestMethod.POST )
    public ResponseEntity<BasketVO> sheetDeliUpdateAjax( @RequestParam( value = "countryCode" ) String countryCode, HttpServletRequest httpServletRequest ) {
        BasketVO basketVo = new BasketVO();
        boolean haveMsg = false;
        OrderSheetDto.OrderSheetRequest orderSheetRequest = (OrderSheetDto.OrderSheetRequest) httpServletRequest.getSession().getAttribute( "orderSheetRequest" );
        orderSheetRequest.setOaCountryName( Country.getCountryNameByCode( countryCode, localeUtils.whereAreYou() ) );

        //상품 리스트
        List<OrderSheetExpansion> orderSheetExpansionList = deprecatedOrderService.findByOrderSheetCodeListFromBasketSeq( orderSheetRequest.getBsSeq(), getFriendsMemberId(), countryCode );
        //판매 불가 상품 리스트
        List<OrderSheetExpansion> unavailableProductList = orderSheetExpansionList.stream().filter( e -> "N".equals( e.getProduct().getPrKrview() ) ).collect( toList() );

        basketVo = makeBasketVo( orderSheetExpansionList, countryCode );

        //해외배송 불가 상품이 있을경우
        if ( !countryCode.equals( "KR" ) ) {
            for ( OrderSheetExpansion orderSheetExpansion : orderSheetExpansionList ) {
                if ( "N".equals( orderSheetExpansion.getProduct().getPrForeigndeliyn() ) ) {
                    haveMsg = true;
                    basketVo.setErrMsg( processMessage( messageSource, "alert_not_globalproduct" ) );
                }
            }
        }
        if ( !unavailableProductList.isEmpty() && !haveMsg ) {
            //품절된 상품이 있을 경우
            basketVo.setErrMsg( processMessage( messageSource, "unavailableProduct.invalid" ) );
        }
        //재고 없는 상품이 있을 경우
        for ( OrderSheetExpansion orderSheetExpansion : orderSheetExpansionList ) {
            if ( orderSheetExpansion.getStEa() <= 0 && !haveMsg ) {
                basketVo.setErrMsg( processMessage( messageSource, "alert_stockEmtpy_products" ) );
            }
        }

        return new ResponseEntity<>( basketVo, new HttpHeaders(), HttpStatus.OK );
    }

    /**
     * 작성자 : layla
     * 날짜 : 2018. 1. 30.
     * <p>
     * Sheet Direct진입 체크
     *
     * @param direct
     * @return
     */
    private boolean isBasketDirect( String direct ) {
        if ( BASKET_DIRECT_NO.equals( direct ) ) {
            return false;
        }
        return true;
    }

    /**
     * 작성자 : layla
     * 날짜 : 2018. 2. 1.
     * <p>
     * 구매상품정보 vo
     *
     * @param orderSheetExpansionList, countryCode
     * @return basketVo
     */
    private BasketVO makeBasketVo( List<OrderSheetExpansion> orderSheetExpansionList, String countryCode ) {
        BasketVO basketVo = new BasketVO();

        Config deliveryLimitMoney = configRepository.findByCfId( "DELIVERYLIMITMONEY" );
        //1만원 이상 무료배송 이벤트
        if ( FriendsUtil.getFreeDeliveryFlag() ) {
            deliveryLimitMoney.setCfValue( 10000 );
        }
        Config deliveryMoney = configRepository.findByCfId( "DELIVERYMONEY" );

        orderSheetExpansionList.forEach( e -> {
            // 주문 상품중 해외배송 불가 상품이 있을시 플래그 생성
            if ( e.getProduct().getPrForeigndeliyn().equals( "N" ) ) {
                basketVo.setHasForeigndelin( true );
            }
        } );

        BoxUtil boxUtil = new BoxUtil();
        ArrayList<BoxItem> boxs = boxUtil.getBoxs( getItemList( orderSheetExpansionList ), null );
        Long basketAccount = orderSheetExpansionList.stream().filter( i -> !i.getIsSoldOut() ).mapToLong( longFunction ).sum();

        //글로벌 배송 무료 이벤트
        EventDto globalEvent = eventService.findEvent( EventOrderType.GLOBAL.getCode(), EventType.DELIVERY.getCode(), basketAccount, EVENT_USE_FLAG, new Date() );

        Long nationalDeliveryCharge = getNationalDeliveryCharge( countryCode, boxs, basketAccount, globalEvent );

        boxs.stream().forEach( e -> e.setExchangeAmount( exchangeRateComponent.exchangeToUSD( e.getAmount() ) ) );
        basketVo.setBoxList( boxs );
        basketVo.setBsSeqList( orderSheetExpansionList.stream().map( e -> String.valueOf( e.getBsSeq() ) ).collect( joining( "," ) ) );
        basketVo.setPaymentDate( LocalDateTime.now().plusDays( KAKAO_FRIENDS_ORDER_PAYMENT_PERIOD ).format( DateTimeFormatter.ofPattern( "yyyyMMdd" ) ) );
        basketVo.setOrderSheetExpansions( orderSheetExpansionList );
        basketVo.setOwnerId( getFriendsMemberId() );
        basketVo.setTotalWeight( Math.round( boxs.stream().mapToDouble( i -> i.getWeight() ).sum() / 1000 * 1000d ) / 1000d );

        double exchangeBasketAccount = orderSheetExpansionList.stream().filter( i -> !i.getIsSoldOut() ).mapToDouble( doubleFunction ).sum();

        basketVo.setBasketAccount( basketAccount );
        basketVo.setExchangeBasketAccount( exchangeBasketAccount );

        boolean isFreeDelivery = false;
        long deliveryCharge = 0L; // 2018. 01. 10 추가

        //9월 글로벌 무료 배송 이벤트
        if ( nationalDeliveryCharge != 0L || isGlobalDelivery( countryCode ) ) {
            if ( nationalDeliveryCharge == 0L ) isFreeDelivery = true;
            deliveryCharge = nationalDeliveryCharge;
            basketVo.setDeliveryCharge( nationalDeliveryCharge );
            basketVo.setPaymentAccount( basketAccount + nationalDeliveryCharge );
        } else {
            if ( basketAccount >= deliveryLimitMoney.getCfValue() ) isFreeDelivery = true;
            deliveryCharge = basketAccount < deliveryLimitMoney.getCfValue() ? deliveryMoney.getCfValue() : 0L;
            basketVo.setDeliveryCharge( deliveryCharge );
            basketVo.setPaymentAccount( basketAccount < deliveryLimitMoney.getCfValue() ? (basketAccount + deliveryMoney.getCfValue()) : basketAccount );
        }

        basketVo.setPaymentAccountNotDeli( basketAccount );
        basketVo.setExchangeDeliveryCharge( exchangeRateComponent.exchangeToUSD( deliveryCharge ) );
        basketVo.setExchangePaymentAccount( exchangeBasketAccount + exchangeRateComponent.exchangeToUSD( deliveryCharge ) );
        basketVo.setFreeDelivery( isFreeDelivery );
        return basketVo;
    }

    /**
     * 작성자 : layla
     * 날짜 : 2018. 2. 1.
     * <p>
     * 쿠폰 및 포인트 정보 vo
     *
     * @param orderSheetExpansionList, countryCode
     * @return basketVo
     */
    private MembershipVO makeMembershipVo( String language, List<OrderSheetExpansion> orderSheetExpansionList, BasketVO basketVo, String countryCode ) {
        String userId = getFriendsMemberId();
        MembershipVO membershipVo = new MembershipVO();

        ArrayList<String> bsPrCodes = new ArrayList<String>();
        orderSheetExpansionList.forEach( e -> {
            //상품코드 수집 (쿠폰 리스트 비교시 사용)
            bsPrCodes.add( e.getProduct().getPrCode() );
        } );

        //가용 포인트 조회
        double pointPrice = myPointService.getAvailablePointByUser( userId );
        membershipVo.setPointPrice( pointPrice );
        membershipVo.setPointPriceUse( isPointUse( pointPrice ) );
        membershipVo.setExchangePointPrice( exchangeRateComponent.exchangeToUSD( pointPrice ) );

        //쿠폰 조회
        List<TbKfoMbsCouponHistory> myAvailableCouponList = myCouponService.myAvailableCouponList( userId );
        List<TbKfoMbsCouponHistory> newCouponList = new ArrayList<TbKfoMbsCouponHistory>();

        for ( TbKfoMbsCouponHistory tbcoupon : myAvailableCouponList ) {
            int categoryNum = tbcoupon.getCPH_OPTION_CATEGORY();
            Long brAccountByCategory = 0L;
            List<String> couponCategoryList = myCouponService.getMyAvailableCouponCategoryListByPrct( bsPrCodes, categoryNum ); //상품중 사용가능 카테고리 조회

            //카테고리 o 금액제한 o  -> 금액 계산
            if ( tbcoupon.getCPH_OPTION_CATEGORY() != 0 && tbcoupon.getCPH_OPTION_VALUE() != null && couponCategoryList != null ) {
                brAccountByCategory = getCouponMoneyByCategory( orderSheetExpansionList, couponCategoryList );
            }

            //카테고리 x 금액제한 o
            if ( tbcoupon.getCPH_OPTION_CATEGORY() == 0 && tbcoupon.getCPH_OPTION_VALUE() != null && Long.valueOf( tbcoupon.getCPH_OPTION_VALUE() ) > basketVo.getBasketAccount() ) {
                continue;
                //카테고리 o 금액제한 o
            } else if ( tbcoupon.getCPH_OPTION_CATEGORY() != 0 && tbcoupon.getCPH_OPTION_VALUE() != null && couponCategoryList != null && (Long.valueOf( tbcoupon.getCPH_OPTION_VALUE() ) > brAccountByCategory || brAccountByCategory == 0) ) {
                continue;
                //무료배송 배송비
            } else if ( !isGlobalDelivery( countryCode ) && basketVo.isFreeDelivery() && tbcoupon.getCPH_OPTION_TYPE() != null && tbcoupon.getCPH_OPTION_TYPE().equalsIgnoreCase( MyCouponCode.OPTION_FREESHIPPING.getCode() ) ) { //"D"
                continue;
                //배송비
            } else if ( StringUtils.isNotEmpty( countryCode ) && !countryCode.equalsIgnoreCase( "KR" ) && !(countryCode.equals( "한국" ) || countryCode.equalsIgnoreCase( "korea" ))
                && tbcoupon.getCPH_DUPLICATION() != null && tbcoupon.getCPH_DUPLICATION().equalsIgnoreCase( "Y" )
                && tbcoupon.getCPH_OPTION_TYPE() != null && tbcoupon.getCPH_OPTION_TYPE().equalsIgnoreCase( "D" )
                && basketVo.getGlobalEvent() != null ) {
                continue;
            } else {
                tbcoupon.setCPH_PRICE_EXCHANGE( exchangeRateComponent.exchangeToUSD( tbcoupon.getCPH_PRICE() ) );
                tbcoupon.setCPH_TYPE_NM( MyCouponCode.getMyCouponCodeName( tbcoupon.getCPH_TYPE(), language ) );
                tbcoupon.setCPH_OPTION_TYPE_NM( MyCouponCode.getMyCouponCodeName( tbcoupon.getCPH_OPTION_TYPE(), language ) );
                newCouponList.add( tbcoupon );
            }
        }

        membershipVo.setMyAvailableCouponCount( newCouponList.size() );
        membershipVo.setMyAvailableCouponList( newCouponList );
        return membershipVo;
    }

    /**
     * 작성자 : layla
     * 날짜 : 2018. 2. 1.
     * <p>
     * 국가정보 vo
     *
     * @param language, countryCode
     * @return countryVo
     */
    private CountryVO makeCountryVo( String language, String countryCode ) {
        CountryVO countryVo = new CountryVO();
        countryVo.setCountryCode( countryCode );
        countryVo.setCountryList( emsService.getCountryList( language ) );
        countryVo.setUsStateList( emsService.getEmsState() );
        return countryVo;
    }


    /**
     * 작성자 : layla
     * 날짜 : 2018. 2. 6.
     * <p>
     * redirect errMsg set
     *
     * @param httpServletRequest
     * @return errMsg
     */
    private String setRequestErrMsg( HttpServletRequest httpServletRequest ) {
        Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap( httpServletRequest );
        if ( flashMap != null ) {
            String errMsg = (String) flashMap.get( "errMsg" );
            if ( errMsg != null && !errMsg.equals( "" ) ) {
                return errMsg;
            }
        }
        return null;
    }
}