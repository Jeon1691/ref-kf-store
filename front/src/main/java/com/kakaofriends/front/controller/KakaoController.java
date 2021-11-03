package com.kakaofriends.front.controller;

import com.kakaofriends.core.common.configuration.persistence.type.BannerType;
import com.kakaofriends.core.common.configuration.persistence.type.ProductDisplayType;
import com.kakaofriends.core.domain.Banner;
import com.kakaofriends.core.domain.BoardArticle;
import com.kakaofriends.front.common.annotation.FriendsGlobal;
import com.kakaofriends.front.common.cache.FriendsCacheBuilder;
import com.kakaofriends.front.common.external.ExchangeRateComponent;
import com.kakaofriends.front.controller.common.RedisController;
import com.kakaofriends.front.domain.product.ProductDto;
import com.kakaofriends.front.domain.product.ProductExpansion;
import com.kakaofriends.front.domain.theme.ThemeData;
import com.kakaofriends.front.domain.theme.ThemeProductData;
import com.kakaofriends.front.service.BoardArticleService;
import com.kakaofriends.front.service.KakaoService;
import com.kakaofriends.front.service.product.ProductService;
import com.kakaofriends.front.service.theme.ThemeService;
import com.kakaofriends.front.utils.StringUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static com.kakaofriends.core.utils.KakaoFriendsConstants.*;
import static com.kakaofriends.front.utils.FriendsUtil.getFriendsMemberId;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

@Slf4j
@Controller
@FriendsGlobal
@RequestMapping( value = "/{language}" )
@AllArgsConstructor( onConstructor = @_( @Autowired ) )

public class KakaoController {

    @Autowired
    private BoardArticleService boardArticleService;

    @Autowired
    private ProductService productService;

    @Autowired
    FriendsCacheBuilder friendsCacheBuilder;

    @Autowired
    private ExchangeRateComponent exchangeRateComponent;

    @Autowired
    private RedisController redisController;

    @Autowired
    private KakaoService kakaoService;

    @Autowired
    private ThemeService themeService;

    @GetMapping( value = { "", "/index" } )
    public ModelAndView helloKakaoFriends( @PathVariable( "language" ) String language, HttpServletRequest request ) {

	    String ownerId = getFriendsMemberId();

        ProductDto.ProductRequest productRequest = new ProductDto.ProductRequest();
        productRequest.setPrStatus( 1 );
        productRequest.setPrUse( "Y" );
        productRequest.setPrKrView( "Y" );
        productRequest.setStartRow( 1 );
        productRequest.setEndRow( 20 );
        productRequest.setOwnerId( ownerId );

        Map<String, Object> data = kakaoService.findFriendsMain( language, ownerId );
        List<Banner> bannerList = (List<Banner>) data.get( "bannerList" );
        List<Banner> mainTopBanner = (List<Banner>) data.get( "mainTopBanner" );
        List<ProductExpansion> productExpansions = (List<ProductExpansion>) data.get( "productExpansions" );
        BoardArticle boardArticle = ((List<BoardArticle>) data.get( "boardArticle" )).get( 0 );

        ModelAndView mav = new ModelAndView();
        mav.addObject( "notice", boardArticle );
        mav.addObject( "exchangeRate", exchangeRateComponent.getExchangeRate() );

        //메인탑
        mav.addObject( "mainTopMap", mainTopBanner.stream().filter( e -> e.getBnAreaType().equals( language.equalsIgnoreCase( "kr" ) ? BannerType.MAIN_TOP : BannerType.MAIN_TOP_EN ) || e.getBnAreaType().equals( language.equalsIgnoreCase( "kr" ) ? BannerType.MAIN_TOP_MOBILE : BannerType.MAIN_TOP_MOBILE_EN ) ).sorted( comparing( Banner::getBnArea ) ).collect( Collectors.groupingBy( e -> e.getBnOrder() ) ) );

        //신상품
        mav.addObject( "mainNewProductMap", bannerList.stream().filter( e -> e.getBnAreaType().equals( language.equalsIgnoreCase( "kr" ) ? BannerType.MAIN_NEW_PRODUCT : BannerType.MAIN_NEW_PRODUCT_EN ) || e.getBnAreaType().equals( language.equalsIgnoreCase( "kr" ) ? BannerType.MAIN_NEW_PRODUCT_MOBILE : BannerType.MAIN_NEW_PRODUCT_MOBILE_EN ) ).sorted( comparing( Banner::getBnArea ) ).collect( Collectors.groupingBy( e -> e.getBnOrder() ) ) );

        //테마
        mav.addObject( "mainThemeMap", bannerList.stream().filter(
                e -> e.getBnAreaType().equals( language.equalsIgnoreCase( "kr" ) ? BannerType.MAIN_THEME : BannerType.MAIN_THEME_EN )
                        || e.getBnAreaType().equals( language.equalsIgnoreCase( "kr" ) ? BannerType.MAIN_THEME_MOBILE : BannerType.MAIN_THEME_MOBILE_EN )
                        || e.getBnAreaType().equals( language.equalsIgnoreCase( "kr" ) ? BannerType.MAIN_THEME_BG : BannerType.MAIN_THEME_BG_EN )
                        || e.getBnAreaType().equals( language.equalsIgnoreCase( "kr" ) ? BannerType.MAIN_THEME_MOBILE_BG : BannerType.MAIN_THEME_MOBILE_BG_EN ) )
                .sorted( comparing( Banner::getBnArea ) ).collect( Collectors.groupingBy( e -> e.getBnOrder() ) ) );

        //메인 롤링
        mav.addObject( "mainRollingsMap", bannerList.stream().filter(
                e -> e.getBnAreaType().equals( language.equalsIgnoreCase( "kr" ) ? BannerType.MAIN_ROLLING : BannerType.MAIN_ROLLING_EN )
                        || e.getBnAreaType().equals( language.equalsIgnoreCase( "kr" ) ? BannerType.MAIN_ROLLING_MOBILE : BannerType.MAIN_ROLLING_MOBILE_EN )
                        || e.getBnAreaType().equals( language.equalsIgnoreCase( "kr" ) ? BannerType.MAIN_ROLLING_BG : BannerType.MAIN_ROLLING_BG_EN )
                        || e.getBnAreaType().equals( language.equalsIgnoreCase( "kr" ) ? BannerType.MAIN_ROLLING_MOBILE_BG : BannerType.MAIN_ROLLING_MOBILE_BG_EN ) )
                .sorted( comparing( Banner::getBnArea ) ).collect( Collectors.groupingBy( e -> e.getBnOrder() ) ) );

        if ( language.equalsIgnoreCase( "kr" ) ) {
            //메인 카드 노말
            mav.addObject( "mainCardNormalMap", bannerList.stream().filter( e -> e.getBnAreaType().equals( BannerType.MAIN_CARD_NORMAL ) || e.getBnAreaType().equals( BannerType.MAIN_CARD_NORMAL_MOBILE ) ).sorted( comparing( Banner::getBnArea ).reversed() ).collect( Collectors.groupingBy( Banner::getBnOrder ) ) );
            //메인 카드 와이드
            mav.addObject( "mainCardWideMap", bannerList.stream().filter( e -> e.getBnAreaType().equals( BannerType.MAIN_CARD_WIDE ) || e.getBnAreaType().equals( BannerType.MAIN_CARD_WIDE_MOBILE ) ).sorted( comparing( Banner::getBnArea ).reversed() ).collect( Collectors.groupingBy( Banner::getBnOrder ) ) );
        } else {
            //메인 카드 노말
            mav.addObject( "mainCardNormalMap", bannerList.stream().filter( e -> e.getBnAreaType().equals( BannerType.MAIN_CARD_NORMAL_EN ) || e.getBnAreaType().equals( BannerType.MAIN_CARD_NORMAL_MOBILE_EN ) ).sorted( comparing( Banner::getBnArea ) ).collect( Collectors.groupingBy( e -> e.getBnOrder() ) ) );
            //메인 카드 와이드
            mav.addObject( "mainCardWideMap", bannerList.stream().filter( e -> e.getBnAreaType().equals( BannerType.MAIN_CARD_WIDE_EN ) || e.getBnAreaType().equals( BannerType.MAIN_CARD_WIDE_MOBILE_EN ) ).sorted( comparing( Banner::getBnArea ) ).collect( Collectors.groupingBy( Banner::getBnOrder ) ) );
        }

        mav.addObject( "mainBandMap", bannerList.stream().filter( e -> e.getBnAreaType().equals( BannerType.MAIN_BAND ) || e.getBnAreaType().equals( BannerType.MAIN_BAND_MOBILE ) ).sorted( comparing( Banner::getBnArea ).reversed() ).collect( Collectors.groupingBy( Banner::getBnOrder ) ) );

        //신상품
        mav.addObject( "newProducts", productExpansions.stream().filter( e -> e.getProductDisplay().getPrdType().equals( ProductDisplayType.NEW_ITEM ) ).limit( MAIN_BESTNEW_DISPLAY_CNT ).collect( toList() ) );
        //인기 상품
        mav.addObject( "bestProducts", productExpansions.stream().filter( e -> e.getProductDisplay().getPrdType().equals( ProductDisplayType.BEST_SELLER_ITEM ) ).limit( MAIN_BEST_DISPLAY_CNT ).collect( toList() ) );
        mav.addObject( "bestProducts_mobile", productExpansions.stream().filter( e -> e.getProductDisplay().getPrdType().equals( ProductDisplayType.BEST_SELLER_ITEM ) ).limit( 100L ).collect( toList() ) );
        //테마 상품
        mav.addObject( "themeProducts", productExpansions.stream().filter( e -> e.getProductDisplay().getPrdType().equals( ProductDisplayType.THEME_ITEM ) ).limit( MAIN_THEME_DISPLAY_CNT ).collect( toList() ) );
        mav.addObject( "officialInstagram", friendsCacheBuilder.instagramCache.asMap().get( friendsCacheBuilder.getCacheKey( Instant.now(), FRIENDS_OFFICIAL_INSTAGRAM_CACHE_NAME, TimeUnit.HOURS, FRIENDS_INSTAGRAM_CACHE_PERIOD ) ) );
        mav.addObject( "labInstagram", friendsCacheBuilder.instagramCache.asMap().get( friendsCacheBuilder.getCacheKey( Instant.now(), FRIENDS_LAB_INSTAGRAM_CACHE_NAME, TimeUnit.HOURS, FRIENDS_INSTAGRAM_CACHE_PERIOD ) ) );

        Map<String, List<ThemeProductData>> themeProductMap = themeService.getThemeProductList( ownerId, exchangeRateComponent.get() );
        mav.addObject( "themeProductMap", themeProductMap );
        mav.addObject( "themeMap", removeNoProductTheme( themeService.getThemeList( language.toLowerCase() ), themeProductMap.keySet() ) );
        mav.addObject("newSaleProducts", productExpansions.stream().filter(e -> e.getProductDisplay().getPrdType().equals(ProductDisplayType.NEW_SALE_ITEM)).limit(100L).collect(toList()));

        mav.setViewName( language + "/index" );


        /**
         * 메인접속수저장(오류발생해도시스템영향없도록함)
         */
        redisController.accessCountring();

        return mav;
    }

    //상품이 없는 테마배너 제거
    private List<ThemeData> removeNoProductTheme( List<ThemeData> themeDataList, Set<String> themeProductkeySet ) {
        List<String> themeProductkeySetList = new ArrayList<>( themeProductkeySet );
        List<ThemeData> themeList = new ArrayList<>();

        for ( ThemeData themeData : themeDataList ) {
            for ( String themeProductKey : themeProductkeySetList ) {
                if ( themeData.getThemeCode().equals( themeProductKey ) ) {
                    themeList.add( themeData );
                }
            }
        }

        return themeList;
    }

    @GetMapping( value = "/index/lang" )
    public ModelAndView langChangeKakaoFriends( @PathVariable( "language" ) String language, ServletRequest request ) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String firstLang;

        if ( httpServletRequest.getHeader( "Accept-Language" ) == null ) {
            firstLang = "ko";
        } else {
            firstLang = (httpServletRequest.getHeader( "Accept-Language" ).split( "," ))[0];
        }

        if ( firstLang.indexOf( "ko" ) == -1 ) {
            language = "en";
        }

        return (ModelAndView) new ModelAndView( "redirect:/" + language + "/index" );
    }

    /**
     * 작성자 : dave
     * 날짜 : 2017. 6. 17.
     * <p>
     * db상 환율 정보 변경 후 환율정보 reload
     *
     * @return 환율 변경 성공 여부
     */
    @ResponseBody
    @GetMapping( value = "/exchangeRate" )
    public boolean reloadExchangeRate() {
        try {
            exchangeRateComponent.init();
        } catch ( Exception e ) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}