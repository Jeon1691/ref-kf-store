package com.kakaofriends.front.controller;

import com.kakaofriends.core.domain.Basket;
import com.kakaofriends.core.domain.Config;
import com.kakaofriends.core.domain.Product;
import com.kakaofriends.core.utils.KakaoFriendsConstants;
import com.kakaofriends.core.utils.KakaoFriendsUtil;
import com.kakaofriends.front.common.annotation.FriendsGlobal;
import com.kakaofriends.front.common.event.GlobalEmsEvent;
import com.kakaofriends.front.common.external.ExchangeRateComponent;
import com.kakaofriends.front.domain.*;
import com.kakaofriends.front.domain.basket.BasketDto;
import com.kakaofriends.front.domain.basket.BasketExpansion;
import com.kakaofriends.front.domain.product.ProductDto;
import com.kakaofriends.front.repository.BasketRepository;
import com.kakaofriends.front.repository.ConfigRepository;
import com.kakaofriends.front.service.EmsService;
import com.kakaofriends.front.service.EventService;
import com.kakaofriends.front.service.order.BasketService;
import com.kakaofriends.front.service.order.DeprecatedOrderService;
import com.kakaofriends.front.utils.BoxUtil;
import com.kakaofriends.front.utils.FriendsUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.function.ToDoubleFunction;
import java.util.function.ToLongFunction;

import static com.kakaofriends.core.utils.KakaoFriendsConstants.BASKET_DIRECT_NO;
import static com.kakaofriends.front.domain.EventDto.EVENT_USE_FLAG;
import static com.kakaofriends.front.utils.FriendsUtil.getFriendsMemberId;
import static java.util.stream.Collectors.toList;

@Slf4j
@Controller
@FriendsGlobal
@RequestMapping(value = "/{language}")
public class BasketController {

    @Autowired
    private BasketService basketService;

    @Autowired
    private BasketRepository basketRepository;

    @Autowired
    private ConfigRepository configRepository;

    @Autowired
    private EmsService emsService;

    @Autowired
    private ExchangeRateComponent exchangeRateComponent;

    @Autowired
    private GlobalEmsEvent globalEmsEvent;

    @Autowired
    private EventService eventService;

    @Autowired
    private DeprecatedOrderService deprecatedOrderService;


    private ToLongFunction<BasketExpansion> longFunction = i -> i.getIsDiscountPeriod() ? i.getProductLevelPrice().getPrlpDiscountprice1() * i.getBasket().getBsEa() : i.getProductLevelPrice().getPrlpSaleprice1() * i.getBasket().getBsEa();
    private ToDoubleFunction<BasketExpansion> doubleFunction = i -> i.getIsDiscountPeriod() ? i.getProductLevelPrice().getExchangeDiscountPrice() * i.getBasket().getBsEa() : i.getProductLevelPrice().getExchangePrice() * i.getBasket().getBsEa();

    @PostMapping(value = "/basket/basket/insert")
    public ModelAndView basketInsert(BasketDto.Request request, RedirectAttributes redirectAttributes) {
        int insertResult = 0;
        if (request.getProductList() != null) {
            insertResult = basketService.basketInsertProductList(request, getFriendsMemberId(), BASKET_DIRECT_NO, true);
        } else {
            insertResult = basketService.basketInsertProduct(request, getFriendsMemberId(), BASKET_DIRECT_NO, true);
        }
        redirectAttributes.addFlashAttribute("basketPopup", insertResult > 0);
        RedirectView redirectView = new RedirectView("/" + request.getLanguage() + "/products/" + request.getDisplayGoodsId());
        redirectView.setExposeModelAttributes(false);
        ModelAndView mav = new ModelAndView();
        mav.setView(redirectView);
        return mav;
    }

    /**
     * 장바구니 insert 수정 2018.08.23 layla
     * 기존의 PR_CODE에 추가로 DISPLAY_GOODS_ID(전시상품아이디)를 받는다
     *
     * @param
     * @return
     */
    @GetMapping(value = "/basket/basket/insert/{displayGoodsId}/{prCode}")
    public ModelAndView basketInsertFromList(@PathVariable String prCode, @PathVariable Long displayGoodsId, HttpServletRequest httpServletRequest, RedirectAttributes redirectAttributes) throws MalformedURLException {
        BasketDto.Request request = new BasketDto.Request();
        request.setPrCode(prCode);
        request.setDisplayGoodsId(displayGoodsId);
        int insertResult = basketService.basketInsertProduct(request, getFriendsMemberId(), BASKET_DIRECT_NO, true);
        redirectAttributes.addFlashAttribute("basketPopup", insertResult > 0);

        String refererUrl = httpServletRequest.getHeader("referer");
        URL url = new URL(refererUrl);

        String redirectUrlQuery = url.getQuery();
        String redirectUrl = url.getPath();

        if (!StringUtils.isEmpty(redirectUrlQuery)) {
            redirectUrl = url.getPath() + "?" + redirectUrlQuery;
        }

        RedirectView redirectView = new RedirectView(redirectUrl);
        redirectView.setExposeModelAttributes(false);
        ModelAndView mav = new ModelAndView();
        mav.setView(redirectView);
        return mav;
    }

    @GetMapping(value = "/basket/basket/insert_async/{displayGoodsId}/{prCode}")
    @ResponseBody
    public String basketInsertFromListAsync(@PathVariable String prCode, @PathVariable Long displayGoodsId) throws MalformedURLException {
        BasketDto.Request request = new BasketDto.Request();
        request.setPrCode(prCode);
        request.setDisplayGoodsId(displayGoodsId);
        int insertResult = basketService.basketInsertProduct(request, getFriendsMemberId(), BASKET_DIRECT_NO, true);

        return String.valueOf(insertResult);
    }

    @PostMapping(value = "/basket/basket/suggested")
    public ModelAndView basketSuggestedInsert(BasketDto.Request request, RedirectAttributes redirectAttributes) {
        request.setPrEa(1L);
        int insertResult = basketService.basketInsertProduct(request, getFriendsMemberId(), BASKET_DIRECT_NO, true);
        redirectAttributes.addFlashAttribute("basketPopup", insertResult > 0);
        ModelAndView mav = getModelAndView(request);
        return mav;
    }

    @PostMapping(value = "/basket/basket/update")
    public ModelAndView basketUpdate(BasketDto.Request request, RedirectAttributes redirectAttributes) {
        int insertResult = basketService.basketInsertProduct(request, getFriendsMemberId(), BASKET_DIRECT_NO, false);
        redirectAttributes.addFlashAttribute("basketPopup", insertResult > 0);
        ModelAndView mav = getModelAndView(request);
        return mav;
    }

    //장바구니에 기프트백만 존재할 때 수량 변경요청 시 안내팝업노출을 하기 위함
    //기존 사용하고있던 /basket/basket/update에 적용하게 되면 상품리스트 또는 상품정보화면에서 기프트백 추가할때 아무리 추가해도 1로 적용되게 되기 때문에 따로 하나 만듬
    //어디서 넣었는지 구분불가
    @PostMapping(value = "/basket/basket/updateGiftBag")
    public ModelAndView updateGiftBag(BasketDto.Request request, RedirectAttributes redirectAttributes) {
        int insertResult = basketService.basketInsertProduct(request, getFriendsMemberId(), BASKET_DIRECT_NO, false);
        redirectAttributes.addFlashAttribute("basketPopup", false);
        ModelAndView mav = getModelAndView(request);
        return mav;
    }

    @PostMapping(value = "/basket/basket/delete")
    public ResponseEntity<ModelAndView> basketDelete(BasketDto.Request request) {
        if (request.getBsSeq() != null) {
            basketService.basketDeleteProduct(Basket.builder().bsOwnerId(getFriendsMemberId()).bsSeq(request.getBsSeq()).bsDirect(BASKET_DIRECT_NO).build());
        }
        ModelAndView mav = getModelAndView(request);
        return new ResponseEntity<>(mav, HttpStatus.OK);
    }

    @PostMapping(value = "/basket/basket/multidelete")
    public ModelAndView basketMultiDelete(BasketDto.Request request) {
        if (null != request.getBsSeqs()) {
            basketService.basketDeleteProducts(request.getBsSeqs().stream().map(e -> Basket.builder().bsOwnerId(getFriendsMemberId()).bsSeq(e).bsDirect(BASKET_DIRECT_NO).build()).collect(toList()));
        }
        ModelAndView mav = getModelAndView(request);
        return mav;
    }

    @PostMapping(value = "/basket/basket/countryChange")
    public ModelAndView basketContryChange(HttpServletRequest httpServletRequest, BasketDto.Request request) {
        HttpSession httpSession = httpServletRequest.getSession();
        httpSession.setAttribute("basketDto", request);
        ModelAndView mav = getModelAndView(request);
        return mav;
    }

    /*
     * 2018.08.28 수정 layla
     * basketExpansions
     * */
    @GetMapping(value = "/basket/products")
    public ModelAndView basketInProucts(@PathVariable("language") String language, HttpServletRequest httpServletRequest) {
        HttpSession httpSession = httpServletRequest.getSession();
        BasketDto.Request basketDto = (BasketDto.Request) httpSession.getAttribute("basketDto");
        Config deliverylimitmoney = configRepository.findByCfId("DELIVERYLIMITMONEY");
        //1만원 이상 무료배송 이벤트
        if (FriendsUtil.getFreeDeliveryFlag()) {
            deliverylimitmoney.setCfValue(10000);
        }

        String oaCountryName;
        String oaCountryCode;
        if (basketDto != null) {
            // 국문 영문 이동시 oaCountryName을 지닌 상태로 이동하는 경우가 있어 국가명 -> 국가코드 -> 언어에 맞는 국가명
            oaCountryName = Country.getCountryNameByCode(Country.getCountryCodeByName(basketDto.getOaCountryName()), language.toLowerCase());
        } else {
            oaCountryName = language.toLowerCase().equals("kr") ? "한국" : "Korea";
        }
        oaCountryCode = Country.getCountryCodeByName(oaCountryName);

        Config deliverymoney = configRepository.findByCfId("DELIVERYMONEY");
        List<BasketExpansion> basketExpansions = basketService.findByBsOwnerId(getFriendsMemberId(), oaCountryCode);
        List<ProductDto.SuggestedProduct> suggestedProducts = basketExpansions.stream().flatMap(e -> e.getSuggestedProducts().stream()).distinct().collect(toList());


        Long basketAccount = 0L;
        double exchangeBasketAccount = 0;
        //장바구니 쇼핑백과 품절상품을 제외한 나머지 상품들 갯수 합
        Long basketProductEa = 0L;
        if (StringUtils.isEmpty(oaCountryName) || oaCountryName.equals("한국") || oaCountryName.equals("Korea")) {
            basketAccount = basketExpansions.stream().filter(i -> !i.getIsSoldOut()).mapToLong(longFunction).sum();
            exchangeBasketAccount = basketExpansions.stream().filter(i -> !i.getIsSoldOut()).mapToDouble(doubleFunction).sum();
            basketProductEa = basketExpansions.stream().filter(i -> !i.getIsSoldOut() && !i.getIsGiftBag() && !i.getBasketInProduct().getPrKrview().equals("N")).mapToLong(i -> i.getBasket().getBsEa()).sum();
        } else {
            basketAccount = basketExpansions.stream().filter(i -> !i.getIsSoldOut() && !i.getBasketInProduct().getPrForeigndeliyn().equals("N")).mapToLong(longFunction).sum();
            exchangeBasketAccount = basketExpansions.stream().filter(i -> !i.getIsSoldOut() && !i.getBasketInProduct().getPrForeigndeliyn().equals("N")).mapToDouble(doubleFunction).sum();
            basketProductEa = basketExpansions.stream().filter(i -> !i.getIsSoldOut() && !i.getIsGiftBag() && !i.getBasketInProduct().getPrForeigndeliyn().equals("N") && !i.getBasketInProduct().getPrKrview().equals("N")).mapToLong(i -> i.getBasket().getBsEa()).sum();
        }
        exchangeBasketAccount = Math.round(exchangeBasketAccount * 100d) / 100d;

        Long paymentAccount = basketAccount < deliverylimitmoney.getCfValue() ? (basketAccount == 0L ? 0L : basketAccount + deliverymoney.getCfValue()) : basketAccount;
        Long deliveryCharge = basketAccount < deliverylimitmoney.getCfValue() ? (basketAccount == 0L ? 0L : deliverymoney.getCfValue()) : 0L;

        ModelAndView mav = new ModelAndView();

        // 박스 수량 및 무계 계산
        BoxUtil boxUtil = new BoxUtil();
        ArrayList<BoxItem> boxs = boxUtil.getBoxs(getItemList(basketExpansions), null);

        // 해외일시 배송비 수정
        Long nationalDeliveryCharge = getNationalDeliveryCharge(Country.getCountryCodeByName(oaCountryName), boxs, basketAccount);


        mav.addObject("basketProductEa", basketProductEa);
        mav.addObject("basketExpansions", basketExpansions);
        mav.addObject("suggestedProducts", suggestedProducts);
        mav.addObject("basketAccount", basketAccount);
        mav.addObject("oaCountryName", oaCountryName);
        mav.addObject("countryList", emsService.getCountryList(language));

        //9월 글로벌 무료 배송 이벤트
        if (nationalDeliveryCharge != 0L || isGlobalDelivery(Country.getCountryCodeByName(oaCountryName))) {
            mav.addObject("deliveryCharge", nationalDeliveryCharge);
            mav.addObject("paymentAccount", basketAccount + nationalDeliveryCharge);
        } else {
            mav.addObject("deliveryCharge", deliveryCharge);
            mav.addObject("paymentAccount", paymentAccount);
        }

        mav.addObject("exchangeDeliveryCharge", getExchangePrice((Long) mav.getModelMap().get("deliveryCharge")));
        mav.addObject("exchangePaymentAccount", getExchangePrice((Long) mav.getModelMap().get("paymentAccount")));
        mav.addObject("exchangeBasketAccount", exchangeBasketAccount);

        // pay only
        boolean isPayOnlyItemContains = false;
        boolean isNormalItemContains = false;

        Iterator<BasketExpansion> itr = basketExpansions.iterator();

        while (itr.hasNext()) {
            BasketExpansion basketExpansion = itr.next();
            String prcode = basketExpansion.getBasket().getBsPrCode();
            boolean isPayOnly = KakaoFriendsUtil.isPayOnlyPrcode(prcode);

            // pay only가 1개라도 있는지 채크
            if (!isPayOnlyItemContains && isPayOnly) {
                isPayOnlyItemContains = isPayOnly;
            }

            // 일반 상품이 1개라도 있는지 채크
            if (!isNormalItemContains && !isPayOnly) {
                isNormalItemContains = !isPayOnly;
            }
        }

        mav.addObject("canPurchasePayOnly", isPayOnlyItemContains && !isNormalItemContains);
        mav.addObject("isPayOnlyItemContains", isPayOnlyItemContains);
        mav.addObject("isNormalItemContains", isNormalItemContains);
        mav.addObject("payOnlyPrcodeSet", KakaoFriendsUtil.getPayOnlyPrcodes());

        mav.setViewName(language + "/basket/products");
        return mav;
    }

    private ModelAndView getModelAndView(BasketDto.Request request) {
        RedirectView redirectView = new RedirectView("/" + request.getLanguage() + "/basket/products");
        ModelAndView mav = new ModelAndView();
        mav.setView(redirectView);
        return mav;
    }

    private LinkedList<BoxItem> getItemList(List<BasketExpansion> basketExpansionList) {
        LinkedList<BoxItem> itemList = new LinkedList<>();

        basketExpansionList.forEach(e -> {
            long amount = e.getIsDiscountPeriod() ? e.getProductLevelPrice().getPrlpDiscountprice1() : e.getProductLevelPrice().getPrlpSaleprice1();
            for (int i = 0; i < e.getBasket().getBsEa(); i++) {
                Product product = e.getBasketInProduct();
                itemList.add(new BoxItem(product, amount, null));
            }
        });

        // 사은품 행사: 박스 측정할때 여권 포함
        globalEmsEvent.addBoxItem(itemList);

        return itemList;
    }

    /**
     * 9월 글로벌 무료 배송 이벤트
     * basketAccount 추가 후 총 합계 비교해서 박스 가격 합치지 않음.
     *
     * @return
     */
    private Long getNationalDeliveryCharge(String countryCode, ArrayList<BoxItem> boxs, long basketAccount) {
        Long nationalDeliveryCharge = new Long(0L);
        if (countryCode == null)
            return nationalDeliveryCharge;

        if (!countryCode.equals("KR") && !(countryCode.equals("한국") || countryCode.toLowerCase().equals("korea"))) {
            EventDto eventDto = eventService.findEvent(EventOrderType.GLOBAL.getCode(), EventType.DELIVERY.getCode(), basketAccount, EVENT_USE_FLAG, new Date());
            //9월 글로벌 무료 배송 이벤트
            if (eventDto != null)
                return nationalDeliveryCharge;

            for (BoxItem box : boxs) {
                Long emsPrice = emsService.getEmsPrice(countryCode, box.getWeight());
                if (emsPrice != null) {
                    nationalDeliveryCharge += emsPrice;
                }
            }
        }
        return nationalDeliveryCharge;
    }

    private double getExchangePrice(Long price) {
        return Math.round(price / exchangeRateComponent.getExchangeRate() * 100d) / 100d;
    }

    /**
     * 9월 글로벌 무료 배송 이벤트
     * 100달러 기준
     *
     * @return
     */
    private long getGlobalEventFreeDeliDollar() {
        return Math.round(exchangeRateComponent.getExchangeRate() * 100d);
    }

    /**
     * 9월 글로벌 무료 배송 이벤트
     * 해외배송 국가 체크
     *
     * @param countryCode
     * @return
     */
    private boolean isGlobalDelivery(String countryCode) {
        if (!StringUtils.isEmpty(countryCode) && !countryCode.equals("KR") && !(countryCode.equals("한국") || countryCode.toLowerCase().equals("korea"))) {
            return true;
        }
        return false;
    }

    /**
     * 작성자 : layla
     * 날짜 : 2018. 1. 30.
     * <p>
     * Direct로 주문화면 이동하기전에 Basket테이블에 데이터 Insert
     *
     * @return
     */
    @RequestMapping(value = "/basket/basket/directInsert", method = RequestMethod.POST)
    public ResponseEntity<BasketDto.Request> basketDirectInsertAjax(BasketDto.Request request) {
        long seq = 0;
        List<Long> seqList = new ArrayList<>();
        if (request.getProductList() != null) {
            seqList = basketService.basketInsertProductList(request, getFriendsMemberId());
            request.setBsSeqs(seqList);
        } else {
            seq = basketService.basketInsertProduct(request, getFriendsMemberId());
            request.setBsSeq(seq);
        }

        return new ResponseEntity<BasketDto.Request>(request, HttpStatus.OK);
    }
}