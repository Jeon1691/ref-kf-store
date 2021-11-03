package com.kakaofriends.front.controller.order.api;

import com.kakaofriends.core.common.configuration.persistence.type.DeliInOutType;
import com.kakaofriends.core.common.configuration.persistence.type.DeliveryType;
import com.kakaofriends.core.common.configuration.persistence.type.OrderAccessType;
import com.kakaofriends.core.common.configuration.persistence.type.PayType;
import com.kakaofriends.core.utils.KakaoFriendsConstants;
import com.kakaofriends.core.utils.KakaoFriendsUtil;
import com.kakaofriends.front.common.api.OrderPath;
import com.kakaofriends.front.common.api.PaymentGateway;
import com.kakaofriends.front.common.constants.Usable;
import com.kakaofriends.front.common.exception.*;
import com.kakaofriends.front.common.external.ExchangeRateComponent;
import com.kakaofriends.front.common.social.FrontUserDetail;
import com.kakaofriends.front.controller.login.vo.UserCreateRequestVO;
import com.kakaofriends.front.controller.order.vo.OrderPayment;
import com.kakaofriends.front.controller.order.vo.OrderPreparation;
import com.kakaofriends.front.controller.order.vo.OrderSession;
import com.kakaofriends.front.controller.order.vo.PaymentGatewayPreparation;
import com.kakaofriends.front.domain.Country;
import com.kakaofriends.front.domain.Currency;
import com.kakaofriends.front.domain.Member;
import com.kakaofriends.front.domain.order.OrderAction;
import com.kakaofriends.front.service.MemberService;
import com.kakaofriends.front.service.basket.vo.Basket;
import com.kakaofriends.front.service.basket.vo.BasketProduct;
import com.kakaofriends.front.service.delivery.DeliveryService;
import com.kakaofriends.front.service.giftcard.GiftCardService;
import com.kakaofriends.front.service.giftcard.vo.GiftCard;
import com.kakaofriends.front.service.giftcard.vo.GiftCardMaster;
import com.kakaofriends.front.service.giftcard.vo.GiftCardMasterOptionType;
import com.kakaofriends.front.service.member.MemberAddressService;
import com.kakaofriends.front.service.mypage.MyPointService;
import com.kakaofriends.front.service.notification.OrderNotificationService;
import com.kakaofriends.front.service.order.BasketService;
import com.kakaofriends.front.service.order.api.OrderService;
import com.kakaofriends.front.service.order.api.PreOrderService;
import com.kakaofriends.front.service.order.constants.OrderSubType;
import com.kakaofriends.front.service.order.constants.PaymentStatus;
import com.kakaofriends.front.service.order.main.PreOrderMainService;
import com.kakaofriends.front.service.order.sub.PreOrderSubService;
import com.kakaofriends.front.service.order.vo.*;
import com.kakaofriends.front.service.payment.PaymentHandler;
import com.kakaofriends.front.service.payment.vo.*;
import com.kakaofriends.front.service.product.stock.StockService;
import com.kakaofriends.front.service.product.stock.vo.Stock;
import com.kakaofriends.front.service.product.vo.Product;
import com.kakaofriends.front.utils.FriendsUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * OrderController : 주문을 처리하는 RestController
 * <p>
 * Author  april
 * Date    2018. 1. 14.
 */
@RestController
@Slf4j
@RequestMapping( "/order" )
@AllArgsConstructor( onConstructor = @_( @Autowired ) )
public class OrderController {
    private PaymentHandler paymentHandler;
    private BasketService basketService;
    private DeliveryService deliveryService;
    private GiftCardService giftCardService;
    private MyPointService pointService;
    private ExchangeRateComponent exchangeRateComponent;
    private StockService stockService;
    private OrderService orderService;
    private PreOrderService preOrderService;
    private PreOrderMainService preOrderMainService;
    private PreOrderSubService preOrderSubService;

    private MemberService memberService;
    private MemberAddressService memberAddressService;
    private OrderNotificationService orderNotificationService;

    private HttpServletRequest request;
    private MessageSource messageSource;

    private final String ORDER_SESSION_KEY = "order";

    private final BigDecimal MIN_PRICE = BigDecimal.valueOf( 1000 );


    @PostMapping( value = "/preparation", produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
    @ResponseBody
    public PaymentGatewayPreparation prepare( @RequestParam( "payment" ) PaymentGateway paymentGateway,
                                              @RequestBody @Valid OrderPreparation preparation,
                                              BindingResult bindingResult, Locale locale, HttpSession session ) throws IOException {
        log.info( "#### PARAM : pg = {}, locale = {}, body = {}", paymentGateway, locale, preparation );
        // validation
        if ( bindingResult.hasErrors() ) {
            throw new InvalidBindingException( bindingResult );
        }
        if ( session.getAttribute( KakaoFriendsConstants.ORDER_SESSION_CHECK_KEY ) == null ) {
            throw new OrderTimeOutException();
        }
        Country country = Country.getCountry( preparation.getReceiverCountry() );
        Device device = DeviceUtils.getCurrentDevice( request );
        if ( paymentGateway.equals( PaymentGateway.INICIS ) && (!device.isNormal()) ) {
            paymentGateway = PaymentGateway.INICIS_MOBILE;
        }
        List<BasketProduct> basketProductList = basketService.getBasketProductList( preparation.getBasketSequenceList() );
        BigDecimal deliveryPrice = deliveryService.getDeliveryFee( country, basketProductList );

        BigDecimal productPrice = this.validateProduct( locale, country, basketProductList );
        BigDecimal pointPrice = this.validatePoint( productPrice, preparation.getPointUsedPrice() );
        BigDecimal giftCardPrice = this.validateGiftCard( productPrice, preparation.getGiftCardCodeList() );
        BigDecimal discountPrice = giftCardPrice.add( pointPrice );
        BigDecimal discountedPrice = this.validatePrice( productPrice, discountPrice );

        // create data for payment
        final String orderNumber = KakaoFriendsUtil.getOrderNumber( KakaoFriendsConstants.KAKAO_FRIENDS_ORDER_NUMBER_PREFIX );
        PaymentPreparation paymentPreparation = this.getPaymentPreparation( paymentGateway, basketProductList,
            preparation, deliveryPrice, discountPrice, orderNumber, locale );
        PaymentPreparationResult response = paymentHandler.prepare( paymentGateway, paymentPreparation );


        PreOrderMain orderMain = this.getPreOrderMain( paymentGateway, preparation,
            discountedPrice, deliveryPrice, giftCardPrice, locale, device );
        List<PreOrderSub> orderSubList = this.getPreOrderSubList( paymentGateway, preparation,
            basketProductList, deliveryPrice, giftCardPrice );
        PreOrderAddress orderAddress = new PreOrderAddress( preparation );
        PreOrder order = new PreOrder( orderMain, orderSubList, orderAddress );
        order.setOrderNumber( orderNumber );
        preOrderService.add( order );

        // 결제 정보를 세션에 입력하여 결제 실행부에서 꺼낸다.
        session.setAttribute( ORDER_SESSION_KEY, this.toJson( orderNumber, response.getSessionId(), preparation.getBasketSequenceList() ) );

        if ( preparation.isSaveDefaultAddress() && !FriendsUtil.isAnonymousUser() ) {
            memberAddressService.merge( preparation );

            String phoneNumber = "";
            String[] buyerPhoneNumber = preparation.getBuyerPhone().split( "-" );

            if ( 0 < buyerPhoneNumber.length ) {
                phoneNumber = buyerPhoneNumber[buyerPhoneNumber.length - 1];
            }
            memberService.update(
                UserCreateRequestVO.builder()
                    .id( Long.valueOf( FriendsUtil.getFriendsMemberId() ) )
                    .name( preparation.getBuyerName() )
                    .phoneNumber( phoneNumber )
                    .build()
            );

            Member member = new Member().setId( Long.valueOf( FriendsUtil.getFriendsMemberId() ) );

            FrontUserDetail frontUserDetail = new FrontUserDetail( memberService.get( member ) );
            Authentication authentication = new UsernamePasswordAuthenticationToken( frontUserDetail, frontUserDetail.getPassword(), frontUserDetail.getAuthorities() );
            SecurityContextHolder.getContext().setAuthentication( authentication );
        }

        return PaymentGatewayPreparation.converts( device, paymentGateway, orderNumber, response );
    }

    @PostMapping( value = "/payment", produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
    @ResponseBody
    public ResponseEntity<PaymentResult> execute( @RequestParam( "payment" ) PaymentGateway paymentGateway,
                                                  @RequestBody OrderPayment orderPayment, Locale locale, HttpSession session ) {
        log.info( "#### PARAM : pg = {}, locale = {}, body = {}", paymentGateway, locale, orderPayment );
        PaymentExecution paymentExecution = PaymentExecution.converts( paymentGateway, orderPayment );
        OrderSession orderSession = this.getOrderSession( session );
        String sessionId = orderSession.getPaymentSessionId();
        String sessionOrderNumber = orderSession.getOrderNumber();

        paymentExecution.setSessionId( sessionId );
        log.debug( "#### order number from session = {}", sessionOrderNumber );

        List<PreOrderSub> preOrderSubList = preOrderSubService.getList( sessionOrderNumber );
        this.validateStock( preOrderSubList );
        preOrderService.editPaymentStatus( sessionOrderNumber, PaymentStatus.PROCESSING );
        PaymentResult result = paymentHandler.pay( paymentGateway, paymentExecution );
        preOrderService.editPaymentStatus( sessionOrderNumber, PaymentStatus.COMPLETE );

        // FIXME : 이니시스 모바일 세션 비정상 처리를 방어하기 위한 긴급 코드
        if ( !result.getOrderNumber().equals( sessionOrderNumber ) ) {
            PreOrderMain preOrderMain = preOrderMainService.get( sessionOrderNumber );
            log.error( "#### OrderNumber not matched = PG OrderNumber = {}, Session OrderNumber = {}", result.getOrderNumber(), sessionOrderNumber );
            CancelExecution cancelExecution = new CancelExecution();
            cancelExecution.setTid( result.getTid() );
            cancelExecution.setPrice( preOrderMain.getPaymentAmount() );
            cancelExecution.setCurrency( Currency.getCurrency( paymentGateway ).name() );
            cancelExecution.setCancelType( CancelType.ALL_CANCEL );
            cancelExecution.setRemainPrice( BigDecimal.ZERO );
            paymentHandler.cancel( paymentGateway, cancelExecution );
            throw new PaymentException( FriendsUtil.processMessage( messageSource, "pay.network.error" ) );
        }

        orderService.addByPreOrder( result.getOrderNumber(), result.getTid() );
        Order order = orderService.get( result.getOrderNumber() );

        //재고 정보 update 2018.02.27
        stockService.updateList( setOrderStockList( order.getOrderSubList() ) );

        basketService.removeList( orderSession.getBasketSequenceList() );
        orderNotificationService.notify( order, locale );

        // FIXME : 주문완료 페이지로 가기 위한 작업
        OrderAddress orderAddress = order.getOrderAddress();
        session.setAttribute( "oId", orderAddress.getOrderNumber() );
        session.setAttribute( "ownerName", orderAddress.getBuyerName() );
        session.setAttribute( "orderMail", orderAddress.getBuyerEmail() );

        return new ResponseEntity<>( result, HttpStatus.OK );
    }

    @PostMapping( "/cancel" )
    public ResponseEntity cancel( @RequestParam String orderNumber ) {
        // get order data
        // validate order status
        // validate buyer name
        // cancel
        // update ordersub
        // insert ordersubhistory
        // add payment history
        return null;
    }

    /**
     * 상품 유효성을 검사한다.
     * <p>
     * 1. 상품 재고를 확인한다
     * 2. 판매 가능 상품인지 확인한다.
     *
     * @param locale            현재 로케일
     * @param country           배송 국가
     * @param basketProductList 장바구니 상품 목록
     */
    private BigDecimal validateProduct( Locale locale, Country country, List<BasketProduct> basketProductList ) {
        BigDecimal productPrice = new BigDecimal( 0 );
        for ( BasketProduct basketProduct : basketProductList ) {
            Product product = basketProduct.getProduct();
            Basket basket = basketProduct.getBasket();
            // productPrice += price * quantity
            productPrice = productPrice.add( product.getCurrentPrice().multiply( BigDecimal.valueOf( basket.getEa() ) ) );
            try {
                stockService.validateStock( product.getProductCode(), Country.isDomestic( country ), basket.getEa() );
            } catch ( InvalidateException e ) {
                throw new InvalidOrderException( e.getMessage(), new Object[]{ product.getProductName( locale ) } );
            }

            if ( product.getKrView().equals( Usable.NOT_USE ) ) {
                throw new InvalidOrderException( "unavailableProduct.invalid" );
            }
        }
        return productPrice;
    }

    /**
     * 사용할 수 있는 쿠폰을 입력했는지 유효성 검사한다.
     * 1. 쿠폰의 유효성을 확인한다.
     * 2. 상품 금액을 초과히지 않는지 확인한다.
     *
     * @param productPrice     상품 총액
     * @param giftCardCodeList 쿠폰코드 리스트
     * @return
     */
    private BigDecimal validateGiftCard( BigDecimal productPrice, List<String> giftCardCodeList ) {
        try {
            giftCardService.validate( giftCardCodeList );
        } catch ( InvalidateException ie ) {
            throw new InvalidOrderException( ie.getMessage() );
        }
        BigDecimal giftCardPrice = new BigDecimal( 0 );
        for ( String code : giftCardCodeList ) {
            GiftCard giftCard = giftCardService.getWithMaster( code );
            GiftCardMaster master = giftCard.getGiftCardMaster();
            if ( master.getOptionType().equals( GiftCardMasterOptionType.AMOUNT ) ) {
                giftCardPrice = giftCardPrice.add( giftCard.getPrice() );
            }
        }
        if ( giftCardPrice.compareTo( productPrice ) > 0 ) {
            throw new InvalidOrderException( "giftCard.error.message.06" );
        }
        return giftCardPrice;
    }

    /**
     * 사용할수 있는 포인트를 입력했는지 유효성 검사한다.
     * 1. 사용자가 가진 포인트보다 큰 값이 입력되었는지 확인한다.
     * 2. 상품 총액 보다 큰 값이 입력되었는지 확인한다.
     *
     * @param productPrice   상품 총액
     * @param userInputPoint 사용자가 입력한 포인트 사용량
     */
    private BigDecimal validatePoint( BigDecimal productPrice, BigDecimal userInputPoint ) {
        double point = pointService.getAvailablePointByUser( FriendsUtil.getFriendsMemberId() );
        BigDecimal availablePoint = BigDecimal.valueOf( point );
        if ( userInputPoint.compareTo( availablePoint ) > 0 ) {
            throw new InvalidOrderException( "mypoint.coupon.message.02" );
        }
        if ( userInputPoint.compareTo( productPrice ) > 0 ) {
            throw new InvalidOrderException( "point.policy.invalid.01" );
        }
        return userInputPoint;
    }

    /**
     * 상품 최소금액 조건을 검사한다.
     * {상품 총액} - {할인총액} 이 상품 최소금액 조건보다 적으면 안된다.
     * 배송비는 상품 최소금액 조건에 포함되지 않는다.
     *
     * @param productPrice  상품 총액
     * @param discountPrice 할인 총액
     * @return 최종 상품 결제 금액
     */
    private BigDecimal validatePrice( BigDecimal productPrice, BigDecimal discountPrice ) {
        BigDecimal totalPrice = productPrice.subtract( discountPrice );
        if ( MIN_PRICE.compareTo( totalPrice ) > 0 ) {
            throw new InvalidOrderException( "paymentAmount.min.invalid", new Object[]{ MIN_PRICE } );
        }
        return totalPrice;
    }

    /**
     * 재고 유효성을 검사한다.
     * - 최종 결제 전 한번 더 재고를 확인한다.
     *
     * @param orderSubList 주문 상세 목록
     */
    private void validateStock( List<PreOrderSub> orderSubList ) {
        try {
            for ( PreOrderSub orderSub : orderSubList ) {
                if ( orderSub.getOrderType().equals( OrderSubType.ORDER ) ) {
                    stockService.validateStock( orderSub.getProductCode(), orderSub.getDomestic(), orderSub.getQuantity() );
                }
            }
        } catch ( InvalidateException ie ) {
            throw new InvalidOrderException( ie.getMessage() );
        }
    }

    private String toJson( String orderNumber, String sessionId, List<Long> basketSequenceList ) throws IOException {
        OrderSession orderSession = new OrderSession();
        orderSession.setOrderNumber( orderNumber );
        orderSession.setPaymentSessionId( sessionId );
        orderSession.setBasketSequenceList( basketSequenceList );
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString( orderSession );
    }

    private OrderSession getOrderSession( HttpSession session ) {
        OrderSession orderSession = null;
        String orderString = (String) session.getAttribute( ORDER_SESSION_KEY );
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            orderSession = objectMapper.readValue( orderString, OrderSession.class );
        } catch ( Exception e ) {
            log.error( "#### Exception caught during parse OrderSession = {}", e.getMessage() );
            log.error( "#### Exception caught during parse OrderSession = {}", e );
            throw new OrderTimeOutException();
        }
        return orderSession;
    }


    private void exchangePrice( PaymentPreparation paymentPreparation ) {
        Currency currency = paymentPreparation.getCurrency();
        if ( currency.equals( Currency.USD ) ) {
            List<PaymentItem> paymentItemList = paymentPreparation.getPaymentItem();
            BigDecimal deliveryPrice = paymentPreparation.getDeliveryPrice();
            BigDecimal discountPrice = paymentPreparation.getDiscountPrice();
            for ( PaymentItem item : paymentItemList ) {
                item.setPrice( exchangeRateComponent.exchangeToUSD( item.getPrice() ) );
            }
            paymentPreparation.setDeliveryPrice( exchangeRateComponent.exchangeToUSD( deliveryPrice ) );
            paymentPreparation.setDiscountPrice( exchangeRateComponent.exchangeToUSD( discountPrice ) );
        }
    }

    private PaymentItem converts( BasketProduct basketProduct, Locale locale ) {
        PaymentItem item = new PaymentItem();
        Product product = basketProduct.getProduct();
        Basket basket = basketProduct.getBasket();
        item.setProductCode( product.getProductCode() );
        item.setName( product.getProductName( locale ) );
        item.setPrice( product.getCurrentPrice() );
        item.setQuantity( basket.getEa() );
        return item;
    }

    private PaymentPreparation getPaymentPreparation( PaymentGateway paymentGateway,
                                                      List<BasketProduct> basketProductList,
                                                      OrderPreparation preparation,
                                                      BigDecimal deliveryPrice, BigDecimal discountPrice,
                                                      String orderNumber, Locale locale ) {
        PaymentPreparation paymentPreparation = new PaymentPreparation();
        paymentPreparation.setOrderNumber( orderNumber );
        if ( !FriendsUtil.isAnonymousUser() ) {
            paymentPreparation.setMemberId( FriendsUtil.getFriendsMember().getId() );
        }
        paymentPreparation.setPaymentItem( this.convertsToPaymentItemList( basketProductList, locale ) );
        paymentPreparation.setDeliveryPrice( deliveryPrice );
        paymentPreparation.setDiscountPrice( discountPrice );
        paymentPreparation.setCurrency( Currency.getCurrency( paymentGateway ) );
        paymentPreparation.setMemberEmail( preparation.getBuyerEmail() );
        paymentPreparation.setMemberName( preparation.getBuyerName() );
        paymentPreparation.setOrderPath( OrderPath.ORDER );
        this.exchangePrice( paymentPreparation );
        return paymentPreparation;
    }

    private List<PaymentItem> convertsToPaymentItemList( List<BasketProduct> basketProductList, Locale locale ) {
        List<PaymentItem> paymentItemList = new ArrayList<>();
        for ( BasketProduct basketProduct : basketProductList ) {
            paymentItemList.add( this.converts( basketProduct, locale ) );
        }
        return paymentItemList;
    }

    private PreOrderMain getPreOrderMain( PaymentGateway paymentGateway, OrderPreparation preparation,
                                          BigDecimal discountedPrice, BigDecimal deliveryPrice, BigDecimal giftCardPrice,
                                          Locale locale, Device device ) {
        Country country = Country.getCountry( preparation.getReceiverCountry() );
        PreOrderMain orderMain = new PreOrderMain();
        orderMain.setMemberId( FriendsUtil.getFriendsMemberId() );
        orderMain.setMemberName( preparation.getBuyerName() );
        orderMain.setDeliveryMemo( preparation.getDeliveryMemo() );
        if ( FriendsUtil.isAnonymousUser() ) {
            orderMain.setCreateId( KakaoFriendsConstants.NONMEMBER );
            orderMain.setUpdateId( KakaoFriendsConstants.NONMEMBER );
        } else {
            String email = FriendsUtil.getFriendsMember().getEmail();
            orderMain.setCreateId( email );
            orderMain.setUpdateId( email );
        }
        orderMain.setPaymentType( PayType.getPayType( paymentGateway ) );
        orderMain.setCurrency( Currency.getCurrency( paymentGateway ) );
        orderMain.setExchangeRate( exchangeRateComponent.getExchangeRate( paymentGateway ) );
        orderMain.setLanguage( locale.getLanguage() );
        orderMain.setAccessType( OrderAccessType.getAccessType( locale, device ) );
        orderMain.setDeliveryType( DeliveryType.getDeliveryType( country ) );
        orderMain.setDomestic( DeliInOutType.getDeliveryInOutType( country ).isDomestic() );
        orderMain.setCouponCodeList( preparation.getGiftCardCodeList() );
        orderMain.setPointAmount( preparation.getPointUsedPrice() );
        orderMain.setCouponAmount( giftCardPrice );
        orderMain.setDeliveryAmount( deliveryPrice );
        orderMain.setPaymentAmount( discountedPrice.add( deliveryPrice ) );
        return orderMain;
    }

    private List<PreOrderSub> getPreOrderSubList( PaymentGateway paymentGateway, OrderPreparation preparation,
                                                  List<BasketProduct> basketProductList,
                                                  BigDecimal deliveryPrice, BigDecimal giftCardPrice ) {
        List<PreOrderSub> orderSubList = new ArrayList<>();
        int i = 1;
        BigDecimal leftPoint = preparation.getPointUsedPrice();
        BigDecimal leftCoupon = giftCardPrice;
        Usable deliveryMoneyUse = deliveryPrice.compareTo( BigDecimal.ZERO ) > 0 ? Usable.USE : Usable.NOT_USE;

        for ( BasketProduct basketProduct : basketProductList ) {
            Basket basket = basketProduct.getBasket();
            Product product = basketProduct.getProduct();
            PreOrderSub orderSub = this.getDefaultOrderSub( paymentGateway, preparation, i++ );
            // from product
            orderSub.setOrderType( OrderSubType.ORDER );
            orderSub.setProductCode( product.getProductCode() );
            orderSub.setCategorySequence( product.getCategorySequence() );
            orderSub.setProductAmount( product.getOriginalPrice() );
            orderSub.setSalesAmount( product.getCurrentPrice() );
            // from basket
            orderSub.setQuantity( basket.getEa() );
            orderSub.setTotalProductAmount( product.getOriginalPrice().multiply( BigDecimal.valueOf( basket.getEa() ) ) );
            orderSub.setTotalSalesAmount( basketProduct.getPrice() );
            // reduced point and price
            BigDecimal orderSubPrice = basketProduct.getPrice();
            BigDecimal usedPoint = new BigDecimal( 0 );
            if ( leftPoint.compareTo( BigDecimal.ZERO ) > 0 ) { // 쿠폰 사용
                if ( orderSubPrice.compareTo( leftPoint ) > 0 ) { // 상품 가격이 클때
                    orderSubPrice = orderSubPrice.subtract( leftPoint );
                    usedPoint = leftPoint; // 모든 포인트 사용
                    leftPoint = BigDecimal.ZERO;
                } else { // 포인트 가격이 클때
                    leftPoint = leftPoint.subtract( orderSubPrice );
                    usedPoint = orderSubPrice; // 상품만큼 사용
                    orderSubPrice = BigDecimal.ZERO;
                }
            }
            // reduced coupon and price
            BigDecimal usedCoupon = new BigDecimal( 0 );
            if ( leftCoupon.compareTo( BigDecimal.ZERO ) > 0 ) {
                if ( orderSubPrice.compareTo( leftCoupon ) > 0 ) {
                    orderSubPrice = orderSubPrice.subtract( leftCoupon );
                    usedCoupon = leftCoupon;
                    leftCoupon = BigDecimal.ZERO;
                } else {
                    leftCoupon = leftCoupon.subtract( orderSubPrice );
                    usedCoupon = orderSubPrice;
                    orderSubPrice = BigDecimal.ZERO;
                }
            }
            orderSub.setCouponAmount( usedCoupon );
            orderSub.setPointAmount( usedPoint );
            orderSub.setPaymentAmount( orderSubPrice );
            orderSubList.add( orderSub );
        }
        // set delivery fee
        if ( deliveryMoneyUse.equals( Usable.USE ) ) {
            PreOrderSub orderSub = this.getDefaultOrderSub( paymentGateway, preparation, i );
            orderSub.setOrderType( OrderSubType.DELIVERY_FEE );
            orderSub.setQuantity( 1 );
            orderSub.setCategorySequence( 0l );
            orderSub.setProductAmount( deliveryPrice );
            orderSub.setSalesAmount( deliveryPrice );
            orderSub.setTotalProductAmount( deliveryPrice );
            orderSub.setTotalSalesAmount( deliveryPrice );
            orderSub.setPaymentAmount( deliveryPrice );
            orderSubList.add( orderSub );
        }
        return orderSubList;
    }

    private PreOrderSub getDefaultOrderSub( PaymentGateway pg, OrderPreparation preparation, int serial ) {
        PreOrderSub orderSub = new PreOrderSub();
        Country country = Country.getCountry( preparation.getReceiverCountry() );
        orderSub.setExchangeRate( exchangeRateComponent.getExchangeRate( pg ) );
        orderSub.setPaymentStatus( PaymentStatus.PREPARATION );
        orderSub.setSerial( serial );
        orderSub.setPaymentType( PayType.getPayType( pg ) );
        orderSub.setMemberId( FriendsUtil.getFriendsMemberId() );
        orderSub.setMemberName( preparation.getBuyerName() );

        orderSub.setCreateId( FriendsUtil.getFriendsMemberId() );
        orderSub.setUpdatedId( FriendsUtil.getFriendsMemberId() );
        orderSub.setDomestic( country.isDomestic() );
        return orderSub;
    }

    /**
     * 주문에 따른 재고 정보 생성
     *
     * @param orderSubList 주문정보
     * @return
     */
    private List<Stock> setOrderStockList( List<OrderSub> orderSubList ) {
        List<Stock> stockList = new ArrayList<>();
        for ( OrderSub orderSub : orderSubList ) {
            if ( orderSub.getProductCode() != null ) {
                Stock stock = new Stock();
                stock.setProductId( orderSub.getProductCode() );
                stock.setAvailableStock( orderSub.getEa() * (-1) );
                stock.setOrderStock( orderSub.getEa() );
                stock.setDomestic( orderSub.getDeliveryInOutType().isDomestic() );
                stock.setOrderNumber( orderSub.getOrderNumber() );
                stock.setMemberId( orderSub.getMemberId() );
                stock.setOrderAction( OrderAction.ORDER );
                stockList.add( stock );
            }
        }
        return stockList;
    }
}