package com.kakaofriends.front.controller;

import com.kakaofriends.front.common.annotation.FriendsGlobal;
import com.kakaofriends.front.domain.FriendsListing;
import com.kakaofriends.front.service.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@FriendsGlobal
@RequestMapping(value = "/{language}")
public class BrandController {

    @Autowired
    private BrandService brandService;

    /**
     * 브랜드스토리
     */
    @RequestMapping(value = "/brand/home")
    public ModelAndView brandHome(FriendsListing friendsListing) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(friendsListing.getLanguage() + "/brand/home");
        return mav;
    }

    /**
     * 브랜드스토리 루이비통
     */
    @RequestMapping(value = "/brand/louisvuitton")
    public ModelAndView brandLouisvuitton(FriendsListing friendsListing) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(friendsListing.getLanguage() + "/brand/louisvuitton");
        return mav;
    }

    /**
     * 브랜드스토리 리본라이언
     */
    @RequestMapping(value = "/brand/ribbonryan")
    public ModelAndView brandRibbonryan(FriendsListing friendsListing) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("brdRecommdationList", brandService.findProductBrdRecommdation("ribbonryan"));
        mav.setViewName(friendsListing.getLanguage() + "/brand/ribbonryan");
        return mav;
    }

    /**
     * 브랜드스토리 무드조명
     */
    @RequestMapping(value = "/brand/ryanmood")
    public ModelAndView brandRyanmood(FriendsListing friendsListing) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("brdRecommdationList", brandService.findProductBrdRecommdation("ryanmood"));
        mav.setViewName(friendsListing.getLanguage() + "/brand/ryanmood");
        return mav;
    }

    /**
     * 브랜드스토리 제이지쇼타임
     */
    @RequestMapping(value = "/brand/jaygshowtime")
    public ModelAndView brandJaygshowtime(FriendsListing friendsListing) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(friendsListing.getLanguage() + "/brand/jaygshowtime");
        return mav;
    }

    /**
     * 브랜드스토리 팬더어피치
     */
    @RequestMapping(value = "/brand/pandaapeach")
    public ModelAndView brandPandaapeach(FriendsListing friendsListing) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("brdRecommdationList", brandService.findProductBrdRecommdation("pandaapeach"));
        mav.setViewName(friendsListing.getLanguage() + "/brand/pandaapeach");
        return mav;
    }

    /**
     * 브랜드스토리 더페이스샵
     */
    @RequestMapping(value = "/brand/thefaceshop")
    public ModelAndView brandThefaceshop(FriendsListing friendsListing) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(friendsListing.getLanguage() + "/brand/thefaceshop");
        return mav;
    }

    /**
     * 브랜드스토리 샘소나이트
     */
    @RequestMapping(value = "/brand/samsonite")
    public ModelAndView brandSamsonite(FriendsListing friendsListing) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(friendsListing.getLanguage() + "/brand/samsonite");
        return mav;
    }

    /**
     * 브랜드스토리 오마이프렌즈
     */
    @RequestMapping(value = "/brand/ohmyfriends")
    public ModelAndView brandOhmyfriends(FriendsListing friendsListing) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("brdRecommdationList", brandService.findProductBrdRecommdation("ohmyfriends"));
        mav.setViewName(friendsListing.getLanguage() + "/brand/ohmyfriends");
        return mav;
    }

    /**
     * 브랜드스토리 이모티콘D
     */
    @RequestMapping(value = "/brand/emoticon3d")
    public ModelAndView brandEmoticon3d(FriendsListing friendsListing) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(friendsListing.getLanguage() + "/brand/emoticon3d");
        return mav;
    }

    /**
     * 브랜드스토리 이모티콘 트루러브
     */
    @RequestMapping(value = "/brand/truelove")
    public ModelAndView brandTruelove(FriendsListing friendsListing) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(friendsListing.getLanguage() + "/brand/truelove");
        return mav;
    }

    /**
     * 브랜드스토리 캘러웨이
     */
    @RequestMapping(value = "/brand/callaway")
    public ModelAndView brandCallaway(FriendsListing friendsListing) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("brdRecommdationList", brandService.findProductBrdRecommdation("callaway"));
        mav.setViewName(friendsListing.getLanguage() + "/brand/callaway");
        return mav;
    }

    /**
     * 브랜드스토리 키엘
     */
    @RequestMapping(value = "/brand/kiehls")
    public ModelAndView brandKiehls(FriendsListing friendsListing) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(friendsListing.getLanguage() + "/brand/kiehls");
        return mav;
    }

    /**
     * 브랜드스토리 티머니
     */
    @RequestMapping(value = "/brand/tmoney")
    public ModelAndView brandTmoney(FriendsListing friendsListing) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(friendsListing.getLanguage() + "/brand/tmoney");
        return mav;
    }

    /**
     * 브랜드스토리 월페이퍼 2017년 12월
     */
    @RequestMapping(value = "/brand/wallpaper")
    public ModelAndView brandWallpaper(FriendsListing friendsListing) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("brdRecommdationList", brandService.findProductBrdRecommdation("wallpaper"));
        mav.setViewName(friendsListing.getLanguage() + "/brand/wallpaper");
        return mav;
    }

    /**
     * 브랜드스토리 월페이퍼 2018년 1월
     */
    @RequestMapping(value = "/brand/wallpaper201801")
    public ModelAndView brandWallpaper201801(FriendsListing friendsListing) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("brdRecommdationList", brandService.findProductBrdRecommdation("wallpaper201801"));
        mav.setViewName(friendsListing.getLanguage() + "/brand/wallpaper201801");
        return mav;
    }

    /**
     * 브랜드스토리 카카오프렌즈
     */
    @RequestMapping(value = "/brand/wearekakaofriends")
    public ModelAndView brandWearekakaofriends(FriendsListing friendsListing) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(friendsListing.getLanguage() + "/brand/wearekakaofriends");
        return mav;
    }

    /**
     * 브랜드스토리 프렌즈팩토리
     */
    @RequestMapping(value = "/brand/friendsfactory")
    public ModelAndView brandFriendsfactory(FriendsListing friendsListing) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("brdRecommdationList", brandService.findProductBrdRecommdation("friendsfactory"));
        mav.setViewName(friendsListing.getLanguage() + "/brand/friendsfactory");
        return mav;
    }

    /**

     * 브랜드스토리 춥지마라이언
     */
    @RequestMapping(value = "/brand/warmryan")
    public ModelAndView brandWarmryan(FriendsListing friendsListing) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("brdRecommdationList", brandService.findProductBrdRecommdation("warmryan"));
        mav.setViewName(friendsListing.getLanguage() + "/brand/warmryan");
        return mav;
    }

    /**

     * 브랜드스토리 시즌 그리팅
     */
    @RequestMapping(value = "/brand/happynewyear2018")
    public ModelAndView brandHappynewyear2018(FriendsListing friendsListing) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("brdRecommdationList", brandService.findProductBrdRecommdation("happynewyear2018"));
        mav.setViewName(friendsListing.getLanguage() + "/brand/happynewyear2018");
        return mav;
    }

    /**
     * 브랜드스토리 월페이퍼 2018년 2월
     */
    @RequestMapping(value = "/brand/wallpaper201802")
    public ModelAndView brandWallpaper201802(FriendsListing friendsListing) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("brdRecommdationList", brandService.findProductBrdRecommdation("wallpaper201802"));
        mav.setViewName(friendsListing.getLanguage() + "/brand/wallpaper201802");
        return mav;
    }

    /**
     * 브랜드스토리 월페이퍼 2018년 3월
     */
    @RequestMapping(value = "/brand/wallpaper201803")
    public ModelAndView brandWallpaper201803(FriendsListing friendsListing) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("brdRecommdationList", brandService.findProductBrdRecommdation("wallpaper201803"));
        mav.setViewName(friendsListing.getLanguage() + "/brand/wallpaper201803");
        return mav;
    }

    /**
     * 브랜드스토리 어피치 뷰티팁 공개!
     */
    @RequestMapping(value = "/brand/apeachblossom")
    public ModelAndView apeachblossom(FriendsListing friendsListing) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("brdRecommdationList", brandService.findProductBrdRecommdation("apeachblossom"));
        mav.setViewName(friendsListing.getLanguage() + "/brand/apeachblossom");
        return mav;
    }

    /**
     * 브랜드스토리 월페이퍼 2018년 4월
     */
    @RequestMapping(value = "/brand/wallpaper201804")
    public ModelAndView brandWallpaper201804(FriendsListing friendsListing) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("brdRecommdationList", brandService.findProductBrdRecommdation("wallpaper201804"));
        mav.setViewName(friendsListing.getLanguage() + "/brand/wallpaper201804");
        return mav;
    }

    /**
     * 브랜드스토리 카카오프렌즈 비밀의 정원
     */
    @RequestMapping(value = "/brand/friendsgarden")
    public ModelAndView friendsgarden(FriendsListing friendsListing) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("brdRecommdationList", brandService.findProductBrdRecommdation("friendsgarden"));
        mav.setViewName(friendsListing.getLanguage() + "/brand/friendsgarden");
        return mav;
    }

    /**
     * 브랜드스토리 월페이퍼 2018년 5월
     */
    @RequestMapping(value = "/brand/wallpaper201805")
    public ModelAndView brandWallpaper201805(FriendsListing friendsListing) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("brdRecommdationList", brandService.findProductBrdRecommdation("wallpaper201805"));
        mav.setViewName(friendsListing.getLanguage() + "/brand/wallpaper201805");
        return mav;
    }

    /**
     * 브랜드스토리 반얀트리
     */
    @RequestMapping(value = "/brand/banyantree")
    public ModelAndView brandBanyantree(FriendsListing friendsListing) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(friendsListing.getLanguage() + "/brand/banyantree");
        return mav;
    }

    /**
     * 브랜드스토리 shake it (프렌즈다이어리)
     */
    @RequestMapping(value = "/brand/apeachdiary")
    public ModelAndView brandApeachdiary(FriendsListing friendsListing) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("brdRecommdationList", brandService.findProductBrdRecommdation("apeachdiary"));
        mav.setViewName(friendsListing.getLanguage() + "/brand/apeachdiary");
        return mav;
    }

    /**
     * 브랜드스토리 더페이스샵 (스윗어피치)
     */
    @RequestMapping(value = "/brand/sweetapeach")
    public ModelAndView brandSweetapeach(FriendsListing friendsListing) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(friendsListing.getLanguage() + "/brand/sweetapeach");
        return mav;
    }

    /**
     * 브랜드스토리 젠틀맨라이언
     */
    @RequestMapping(value = "/brand/gentlemanryan")
    public ModelAndView brandGentlemanryan(FriendsListing friendsListing) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("brdRecommdationList", brandService.findProductBrdRecommdation("gentlemanryan"));
        mav.setViewName(friendsListing.getLanguage() + "/brand/gentlemanryan");
        return mav;
    }

    /**
     * 브랜드스토리 플라잉라이언
     */
    @RequestMapping(value = "/brand/flyingryan")
    public ModelAndView brandFlyingryan(FriendsListing friendsListing) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("brdRecommdationList", brandService.findProductBrdRecommdation("flyingryan"));
        mav.setViewName(friendsListing.getLanguage() + "/brand/flyingryan");
        return mav;
    }

    /**
     * 브랜드스토리 월페이퍼 2018년 6월
     */
    @RequestMapping(value = "/brand/wallpaper201806")
    public ModelAndView brandWallpaper201806(FriendsListing friendsListing) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("brdRecommdationList", brandService.findProductBrdRecommdation("wallpaper201806"));
        mav.setViewName(friendsListing.getLanguage() + "/brand/wallpaper201806");
        return mav;
    }

    /**
     * 브랜드스토리 월페이퍼 2018년 7월
     */
    @RequestMapping(value = "/brand/wallpaper201807")
    public ModelAndView brandWallpaper201807(FriendsListing friendsListing) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("brdRecommdationList", brandService.findProductBrdRecommdation("wallpaper201807"));
        mav.setViewName(friendsListing.getLanguage() + "/brand/wallpaper201807");
        return mav;
    }

    /**
     * 브랜드스토리 프렌즈의 즐거운 여름 나기! ver. 매트튜브
     */
    @RequestMapping(value = "/brand/summerFriends1")
    public ModelAndView brandSummerFriends1(FriendsListing friendsListing) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("brdRecommdationList", brandService.findProductBrdRecommdation("summerFriends1"));
        mav.setViewName(friendsListing.getLanguage() + "/brand/summerFriends1");
        return mav;
    }

    /**
     * 브랜드스토리 프렌즈의 즐거운 여름 나기! ver. 서핑보드
     */
    @RequestMapping(value = "/brand/summerFriends2")
    public ModelAndView brandSummerFriends2(FriendsListing friendsListing) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("brdRecommdationList", brandService.findProductBrdRecommdation("summerFriends2"));
        mav.setViewName(friendsListing.getLanguage() + "/brand/summerFriends2");
        return mav;
    }

    /**
     * 브랜드스토리 프렌즈의 즐거운 여름 나기! ver. 비치볼
     */
    @RequestMapping(value = "/brand/summerFriends3")
    public ModelAndView brandSummerFriends3(FriendsListing friendsListing) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("brdRecommdationList", brandService.findProductBrdRecommdation("`"));
        mav.setViewName(friendsListing.getLanguage() + "/brand/summerFriends3");
        return mav;
    }

    /**
     * 브랜드스토리 월페이퍼 2018년 8월
     */
    @RequestMapping(value = "/brand/wallpaper201808")
    public ModelAndView brandWallpaper201808(FriendsListing friendsListing) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("brdRecommdationList", brandService.findProductBrdRecommdation("wallpaper201808"));
        mav.setViewName(friendsListing.getLanguage() + "/brand/wallpaper201808");
        return mav;
    }

    /**
     * 브랜드스토리 라이언의 호캉스 즐기기
     */
    @RequestMapping(value = "/brand/hotelDeRyan")
    public ModelAndView brandHotelDeRyan(FriendsListing friendsListing) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("brdRecommdationList", brandService.findProductBrdRecommdation("hotelDeRyan"));
        mav.setViewName(friendsListing.getLanguage() + "/brand/hotelDeRyan");
        return mav;
    }

    /**
     * 브랜드스토리 월페이퍼 2018년 9월
     */
    @RequestMapping(value = "/brand/wallpaper201809")
    public ModelAndView brandWallpaper201809(FriendsListing friendsListing) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("brdRecommdationList", brandService.findProductBrdRecommdation("wallpaper201809"));
        mav.setViewName(friendsListing.getLanguage() + "/brand/wallpaper201809");
        return mav;
    }

    /**
     * 브랜드스토리 KAKAO FRIENDS in Los Angeles, KCON18 LA
     */
    @RequestMapping(value = "/brand/kconLA")
    public ModelAndView brandKconLA(FriendsListing friendsListing) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("brdRecommdationList", brandService.findProductBrdRecommdation("kconLA"));
        mav.setViewName(friendsListing.getLanguage() + "/brand/kconLA");
        return mav;
    }

    /**
     * 브랜드스토리 월페이퍼 2018년 10월
     */
    @RequestMapping(value = "/brand/wallpaper201810")
    public ModelAndView brandWallpaper201810(FriendsListing friendsListing) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("brdRecommdationList", brandService.findProductBrdRecommdation("wallpaper201810"));
        mav.setViewName(friendsListing.getLanguage() + "/brand/wallpaper201810");
        return mav;
    }

    /**
     * 브랜드스토리 월페이퍼 2018년 11월
     */
    @RequestMapping(value = "/brand/wallpaper201811")
    public ModelAndView brandWallpaper201811(FriendsListing friendsListing) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("brdRecommdationList", brandService.findProductBrdRecommdation("wallpaper201811"));
        mav.setViewName(friendsListing.getLanguage() + "/brand/wallpaper201811");
        return mav;
    }

    /**
     * 브랜드스토리 월페이퍼 2018년 12월
     */
    @RequestMapping(value = "/brand/wallpaper201812")
    public ModelAndView brandWallpaper201812(FriendsListing friendsListing) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("brdRecommdationList", brandService.findProductBrdRecommdation("wallpaper201812"));
        mav.setViewName(friendsListing.getLanguage() + "/brand/wallpaper201812");
        return mav;
    }

    /**
     * 브랜드스토리 월페이퍼 2019년 1월
     */
    @RequestMapping(value = "/brand/wallpaper201901")
    public ModelAndView brandWallpaper201901(FriendsListing friendsListing) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("brdRecommdationList", brandService.findProductBrdRecommdation("wallpaper201901"));
        mav.setViewName(friendsListing.getLanguage() + "/brand/wallpaper201901");
        return mav;
    }

    /**
     * 브랜드스토리 화면보호기
     */
    @RequestMapping(value = "/brand/screen2019")
    public ModelAndView brandScreen2019(FriendsListing friendsListing) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("brdRecommdationList", brandService.findProductBrdRecommdation("screen2019"));
        mav.setViewName(friendsListing.getLanguage() + "/brand/screen2019");
        return mav;
    }

    /**
     * 브랜드스토리 라이언의 hello 2019
     */
    @RequestMapping(value = "/brand/hello2019")
    public ModelAndView brandHello2019(FriendsListing friendsListing) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("brdRecommdationList", brandService.findProductBrdRecommdation("hello2019"));
        mav.setViewName(friendsListing.getLanguage() + "/brand/hello2019");
        return mav;
    }

}
