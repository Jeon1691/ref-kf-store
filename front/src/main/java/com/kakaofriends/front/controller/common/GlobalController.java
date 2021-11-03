package com.kakaofriends.front.controller.common;

import com.daumcorp.commons.useragentutil.UserAgent;
import com.google.common.collect.ImmutableMap;
import com.kakaofriends.core.common.configuration.persistence.type.BannerType;
import com.kakaofriends.core.domain.Banner;
import com.kakaofriends.core.utils.KakaoFriendsUtil;
import com.kakaofriends.front.common.annotation.FriendsGlobal;
import com.kakaofriends.front.common.cache.FriendsCacheBuilder;
import com.kakaofriends.front.common.cache.FriendsCacheMenu;
import com.kakaofriends.front.domain.CategoryMenu;
import com.kakaofriends.front.domain.Member;
import com.kakaofriends.front.service.BannerService;
import com.kakaofriends.front.service.mypage.MyPointService;
import com.kakaofriends.front.service.order.BasketService;
import com.kakaofriends.front.utils.FriendsUtil;
import com.kakaofriends.front.utils.LocaleUtils;
import com.maxmind.geoip.Country;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.Charset;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

import static com.kakaofriends.core.utils.KakaoFriendsConstants.*;
import static com.kakaofriends.front.utils.FriendsUtil.getFriendsMemberId;
import static com.sun.scenario.Settings.set;
/*
import static com.kakaofriends.front.utils.FriendsUtil.getFriendsMemberId;
*/

@Slf4j
@ControllerAdvice(annotations = {FriendsGlobal.class})
public class GlobalController {

    @Value(value = "${kakaofriends.cdn.product}")
    private String kakaoFriendsCdnProduct;

    @Value(value = "${kakaofriends.cdn.promotion.share}")
    private String kakaoFriendsCdnPromotionShare;

    @Value(value = "${kakaofriends.cdn.banner}")
    private String kakaoFriendsCdnBanner;

    @Value(value = "${kakaofriends.cdn.category}")
    private String kakaoFriendsCdnCategory;

    @Value(value = "${kakaofriends.cdn.recmd.banner}")
    private String kakaoFriendsCdnRecmdBanner;

    @Value(value = "${kakaofriends.cdn.store}")
    private String kakaoFriendsCdnStore;

    @Value(value = "${kakaofriends.cdn.theme}")
    private String kakaoFriendsCdnTheme;

    @Value(value = "${kakaofriends.default.ko.uri}")
    private String defaultKoURI;

    @Value(value = "${kakaofriends.default.en.uri}")
    private String defaultEnURI;

    @Autowired
    MyPointService myPointService;

    @Autowired
    private Resource geoIP;

    @Autowired
    private FriendsCacheBuilder friendsCacheBuilder;

    @Autowired
    private FriendsCacheMenu friendsCacheMenu;

    @Autowired
    private BasketService basketService;

    @Autowired
    private BannerService bannerService;

    @Autowired
    private LocaleUtils localeUtils;

    @Autowired
    private MessageSource messageSource;

    @PostConstruct
    public void friendsCacheInit() throws Exception {
        friendsCacheBuilder.buildCategoryMenuCache(Instant.now());
        friendsCacheBuilder.buildCategoryMenuCache(Instant.now().plus(10, ChronoUnit.MINUTES));

        //friendsCacheBuilder.buildInstagramCache(Instant.now());
        //friendsCacheBuilder.buildInstagramCache(Instant.now().plus(1, ChronoUnit.HOURS));
    }

    @ModelAttribute("userAgent")
    public UserAgent getUserAgent(HttpServletRequest request) {
        return KakaoFriendsUtil.getUserAgent(request);
    }

    @ModelAttribute("country")
    public Country getCountry(HttpServletRequest request) {
        try {
            String ip = request.getHeader(X_DAUM_IP) == null ? request.getRemoteAddr() : request.getHeader(X_DAUM_IP);
            return KakaoFriendsUtil.getCountry(ip, geoIP.getFile());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 한국어//영문 국가 변경 시 URI 변경
     *
     * @param request
     * @return
     */
    @ModelAttribute("linkLanguage")
    public Map<String, String> getLinkLanguage(HttpServletRequest request) {
        Map<String, String> map = new HashedMap();
        try {
            String reqURI = request.getRequestURI();
            String queryStr = StringUtils.isEmpty(request.getQueryString()) ? StringUtils.EMPTY : "?" + request.getQueryString();
            String linkURI = defaultKoURI;

            //Footer 언어변환
            if (reqURI.split("/")[1].equals("en")) {
                linkURI = reqURI.replace("/en/", "/kr/");
                map.put("koURI", linkURI + queryStr);
                map.put("enURI", reqURI + queryStr);
            } else {
                linkURI = reqURI.replace("/kr/", "/en/");
                map.put("koURI", reqURI + queryStr);
                map.put("enURI", linkURI + queryStr);
            }

            //상단 언어 변환
            map.put("URI", linkURI + queryStr);
        } catch (Exception e) {
            log.error("getLinkLanguage ERROR URI : {} , queryString : {} , message : {}", request.getRequestURI(), request.getQueryString(), e);
            map.put("koURI", defaultKoURI);
            map.put("enURI", defaultEnURI);
            map.put("URI", defaultKoURI);
        }
        return map;
    }

    @ModelAttribute("friendsLocale")
    public Map<String, String> getFriendsLocale(HttpServletRequest request) {
        String reqURI = request.getRequestURI();
        String langPath = reqURI.split("/")[1];
        Map<String, String> localeMap = new HashedMap();
        localeMap.put("locale", langPath.equalsIgnoreCase("kr") || langPath.equalsIgnoreCase("en") ? langPath : "kr");

        return localeMap;
    }

    @ModelAttribute("myInfo")
    public Map<String, Object> getMyInfo() {
        Member friendsMember = FriendsUtil.getFriendsMember();
        Map<String, Object> myInfo = new HashedMap();
        String myName = friendsMember.getName();
        String barcode = friendsMember.getBarcode();
        Locale locale = new Locale(localeUtils.whereAreYou());

        myInfo.put("availablePoint", myPointService.getAvailablePointByUser(getFriendsMemberId()));
        myInfo.put("myName", myName != null ? myName : messageSource.getMessage("desc.customer.name", null, locale));
        myInfo.put("barcode", barcode);

        return myInfo;
    }

    @ModelAttribute("kakaoFriendsCdn")
    public Map<String, String> getKakaoFriendsCdn() {
        Map<String, String> map = ImmutableMap.<String, String>builder()
                .put("product", kakaoFriendsCdnProduct)
                .put("banner", kakaoFriendsCdnBanner)
                .put("category", kakaoFriendsCdnCategory)
                .put("store", kakaoFriendsCdnStore)
                .put("promotionShare", kakaoFriendsCdnPromotionShare)
                .put("recommendation", kakaoFriendsCdnRecmdBanner)
                .put("theme", kakaoFriendsCdnTheme)
                .build();
        return map;
    }

    @ModelAttribute("categoryMenu")
    public Map<Long, List<CategoryMenu>> getGnbFriends() {
        return friendsCacheBuilder.categoryMenuCache.asMap().get(friendsCacheBuilder.getCacheKey(Instant.now(), FRIENDS_CATEGORY_CACHE_NAME))
                .entrySet().stream().flatMap(e -> e.getValue().stream()).filter(e -> e.getCtNode() > 1L).collect(Collectors.groupingBy(e -> e.getCtRoot()));
    }

    @ModelAttribute("categoryThemeMenu")
    public List<CategoryMenu> getGnbFriendsTheme() {
        Map<Long, List<CategoryMenu>> gnbThemeList = friendsCacheBuilder.categoryMenuCache.asMap().get(friendsCacheBuilder.getCacheKey(Instant.now(), FRIENDS_CATEGORY_CACHE_NAME))
                .entrySet().stream().flatMap(e -> e.getValue().stream()).filter(e -> (e.getCtNode() > 1L && e.getCtPcode() == FRIENDS_CATEGORY_THEME_CODE)).collect(Collectors.groupingBy(e -> e.getCtPcode()));
        return gnbThemeList.get(FRIENDS_CATEGORY_THEME_CODE);
    }

    @ModelAttribute("basketAllCount")
    public Map<String, Integer> getBasketAllCount() {
        int count = basketService.findByBsOwnerIdAllCount(getFriendsMemberId(), BASKET_DIRECT_NO);
        return ImmutableMap.of("count", count > BASKET_MAX_COUNT ? BASKET_MAX_COUNT : count);
    }

    @ModelAttribute("gnbBandMobile")
    public List<Banner> getGnbBandMobile(HttpServletRequest request) {
        String reqURI = request.getRequestURI();
        String bannerType = BannerType.GNB_BAND_MOBILE.getCode();
        if (reqURI.split("/")[1].equals("en")) {
            bannerType = BannerType.GNB_BAND_MOBILE_EN.getCode();
        }
        return bannerService.findByBannerArea(bannerType);
    }

    private static Map<String, CategoryMenu> categoryMenuMap = new HashedMap();

    static {
        categoryMenuMap.put("/*/products/groups/new/**", CategoryMenu.builder().subKey("new").ctColor("ffc600").ctImage1("/resources/images/pc/bg_new_170103.jpg").ctImage2("/resources/images/m640/bg_new_170103.jpg").ctName("신규상품").ctEname("New Arrival").build());
        categoryMenuMap.put("/*/products/groups/best/**", CategoryMenu.builder().subKey("best").ctColor("7fb9f4").ctImage1("/resources/images/pc/bg_best_170103.jpg").ctImage2("/resources/images/m640/bg_best_170103.jpg").ctName("인기상품").ctEname("Best").build());
        categoryMenuMap.put("/*/basket/products", CategoryMenu.builder().subKey("basket").ctColor("f08f8f").ctImage1("/resources/images/pc/bg_shopping_170103.jpg").ctImage2("/resources/images/m640/bg_shopping_170103.jpg").ctName("장바구니").ctEname("Shopping Cart").contentClass("cont_basket").build());
        categoryMenuMap.put("/*/order/sheet", CategoryMenu.builder().subKey("sheet").ctName("주문하기").ctEname("Order").build());
        categoryMenuMap.put("/*/order/directsheet", CategoryMenu.builder().subKey("directsheet").ctName("주문하기").ctEname("Order").build());
        categoryMenuMap.put("/*/order/complete", CategoryMenu.builder().subKey("complete").ctName("주문완료").ctEname("Order Success").build());
        categoryMenuMap.put("/*/order/shipping/*", CategoryMenu.builder().subKey("shipping").ctName("주문배송조회").ctEname("Order Tracking").build());
        categoryMenuMap.put("/*/products/*", CategoryMenu.builder().subKey("detail").ctName("제품 상세정보").ctEname("Product").build());
        categoryMenuMap.put("/*/index", CategoryMenu.builder().subKey("index").ctColor("").ctName("메인페이지").ctEname("Main").build());
        categoryMenuMap.put("/*/etc/event", CategoryMenu.builder().subKey("event").ctColor("").ctName("컨텐츠 기획전 카피 센터 정렬").ctImage1("bg_event.jpg").ctEname("이미지 납작쿠션").build());
        categoryMenuMap.put("/*/etc/charInfo", CategoryMenu.builder().subKey("charInfo").ctColor("").ctName("카카오프렌즈 캐릭터 소개").ctImage1("bg_char.jpg").ctEname("Korea NO.1 Character KAKAO FRIENDS").build());
        categoryMenuMap.put("/*/shoppingcart", CategoryMenu.builder().subKey("cart").ctColor("").ctImage1("bg_intro4.jpg").ctName("마이페이지").ctEname("My Page").build());
        categoryMenuMap.put("/*/mypage/**", CategoryMenu.builder().subKey("mypage").gnbFriends("mypage").ctColor("3966ac").ctImage1("/resources/images/pc/bg_mypage_170103.jpg").ctImage2("/resources/images/m640/bg_mypage_170103.jpg").ctName("마이페이지").ctEname("My Page").build());
        categoryMenuMap.put("/*/customcenter/**", CategoryMenu.builder().subKey("customcenter").gnbFriends("customcenter").ctColor("41b984").ctImage1("/resources/images/pc/bg_help_170103.jpg").ctImage2("/resources/images/m640/bg_help_170103.jpg").ctName("고객센터").ctEname("Help").build());
        categoryMenuMap.put("/*/stores/**", CategoryMenu.builder().subKey("stores").gnbFriends("stores").ctName("매장안내").ctEname("Store").build());
        categoryMenuMap.put("/*/policy/*", CategoryMenu.builder().subKey("policy").ctColor("5a6067").ctImage1("/resources/images/pc/bg_privacy_170103.jpg").ctImage2("/resources/images/m640/bg_privacy_170103.jpg").ctName("개인정보 보호").ctEname("Privacy").build());
        categoryMenuMap.put("/*/search", CategoryMenu.builder().subKey("search").ctName("상품검색").ctEname("Search").build());
        categoryMenuMap.put("/*/promotion/*", CategoryMenu.builder().subKey("promotion").build());
    }

    // DB 카테테고리 테이블에 CT_CODE 3(카테고리) 과 4(캐릭터)로 GNB 메뉴가 1차 구분됨
    @ModelAttribute("mSubInfo")
    public CategoryMenu mSubInfo(HttpServletRequest request) {
        Map<String, String> categoryMap = friendsCacheMenu.getCategoryMap(request);
        if (friendsCacheMenu.isCategoryGroup(categoryMap, "categories")) {
            String requestCategory = StringUtils.isEmpty(request.getParameter("requestCategory")) ? categoryMap.get("ctSeq") : request.getParameter("requestCategory");
            return friendsCacheMenu.getCategoryMenuByParam(3L, requestCategory);
        } else if (friendsCacheMenu.isCategoryGroup(categoryMap, "characters")) {
            String requestCharacter = StringUtils.isEmpty(request.getParameter("requestCharacter")) ? categoryMap.get("ctSeq") : request.getParameter("requestCharacter");
            return friendsCacheMenu.getCategoryMenuByParam(4L, requestCharacter);
        } else {
            AntPathMatcher antPathMatcher = new AntPathMatcher();
            Optional<String> mSubInfoKey = categoryMenuMap.keySet().stream().filter(e -> antPathMatcher.match(e, request.getServletPath())).findFirst();
            return categoryMenuMap.get(mSubInfoKey.isPresent() ? mSubInfoKey.get() : null);
        }
    }
}