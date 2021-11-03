package com.kakaofriends.front.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.kakaofriends.core.common.configuration.persistence.type.BannerType;
import com.kakaofriends.core.common.pagination.PaginationInfo;
import com.kakaofriends.core.domain.Banner;
import com.kakaofriends.core.utils.KakaoFriendsConstants;
import com.kakaofriends.core.utils.KakaoFriendsUtil;
import com.kakaofriends.front.common.annotation.FriendsGlobal;
import com.kakaofriends.front.common.cache.FriendsCacheBuilder;
import com.kakaofriends.front.common.configuration.persistence.type.CategoryGroup;
import com.kakaofriends.front.common.configuration.persistence.type.SortType;
import com.kakaofriends.front.domain.CategoryMenu;
import com.kakaofriends.front.domain.product.*;
import com.kakaofriends.front.service.BannerService;
import com.kakaofriends.front.service.product.DisplayGoodsService;
import com.kakaofriends.front.service.product.ProductService;
import com.kakaofriends.front.service.product.vo.GoodsOptionType;
import com.kakaofriends.front.utils.DateUtil;
import com.kakaofriends.front.utils.TenthUtill;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.time.Instant;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.kakaofriends.core.utils.KakaoFriendsConstants.*;
import static com.kakaofriends.core.utils.KakaoFriendsUtil.getPaginationInfo;
import static com.kakaofriends.front.utils.FriendsUtil.*;
import static java.util.stream.Collectors.toList;

@Slf4j
@Controller
@FriendsGlobal
@RequestMapping(value = "/{language}")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private BannerService bannerService;

    @Autowired
    private FriendsCacheBuilder friendsCacheBuilder;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private TenthUtill tenthUtill;

    @Autowired
    private DisplayGoodsService displayGoodsService;

    // 카테고리 메뉴 하위 카테고리 번호
    @RequestMapping(value = {"/products/groups/categories/{ctSeq}", "/products/groups/categories/{ctSeq}/pages/{pageIndex}"})
    public ModelAndView getProductsByCategory(ProductDto.ProductRequest productRequest) {
        productRequest.setCtGroup("categories");
        productRequest.setOwnerId(getFriendsMemberId());
        return getProductList(productRequest).addObject("subCategoryMenu", getSubMenuList(productRequest));

    }

    // 캐릭터 메뉴 하위 카테고리 번호
    @RequestMapping(value = {"/products/groups/characters/{ctSeq}", "/products/groups/characters/{ctSeq}/pages/{pageIndex}"})
    public ModelAndView getProductsByCharacters(ProductDto.ProductRequest productRequest) {
        productRequest.setCtGroup("characters");
        productRequest.setOwnerId(getFriendsMemberId());
        return getProductList(productRequest);
    }

    /*
     * 2018.08.27 수정 layla
     * int totalCount
     * productExpansions
     * */
    // 신규 상품 및 베스트 상품
    @RequestMapping(value = {"/products/groups/{ctGroup}", "/products/groups/{ctGroup}/pages/{pageIndex}"})
    public ModelAndView getProductsByType(ProductDto.ProductRequest productRequest) {

        if (productRequest.getSort() == null) productRequest.setSort(SortType.NEW);
        if (productRequest.getPrUse() == null) productRequest.setPrUse("Y");
        if (productRequest.getPrKrView() == null) productRequest.setPrKrView("Y");
        productRequest.setOwnerId(getFriendsMemberId());
        boolean globalFilter = productRequest.getFilter() != null && productRequest.getFilter().equals("global") ? true : false;

        int totalCount = displayGoodsService.findProductCountByCategoryGroup(productRequest);
        PaginationInfo pagination = getPaginationInfo(totalCount, productRequest.getPageIndex(), KakaoFriendsConstants.pageUnit, KakaoFriendsConstants.pageSize);

        DateUtil dateUtil = new DateUtil();
        ModelAndView mav = new ModelAndView();
        mav.addObject("productExpansions", displayGoodsService.findProductsByCategoryGroup(productRequest, pagination));
        mav.addObject("totalCount", totalCount);
        mav.addObject("productRequest", productRequest);
        mav.addObject("sortTypes", SortType.values());
        mav.addObject("pagination", pagination);
        mav.addObject("pageLink", stringConcatPath("", productRequest.getLanguage(), "products/groups", String.valueOf(productRequest.getCtGroup())));
        mav.addObject("globalFilter", globalFilter);
        mav.addObject("today", dateUtil.getDateyyyyMMddHHmm());
        mav.setViewName(productRequest.getLanguage() + "/product/specialList");

        return mav;
    }

    // 카테고리, 캐릭터 메뉴 하위 카테고리 번호를 통한 상품 상세보기
    @RequestMapping(value = {"/products/{prCode}"})
    public ModelAndView getProductDetailByProductCodeToCategories(ProductDto.ProductRequest productRequest, RedirectAttributes redirectAttributes) {
        productRequest.setOwnerId(getFriendsMemberId());
        ModelAndView mav = getProductDetail(productRequest, redirectAttributes);
        return mav;
    }

    /*
     * 2018.08.24 수정 layla
     * ProductExpansion -> DisplayGoodsExpansion
     * getProduct() -> getDisplayGoods()
     * recentProducts.add item
     * */
    // 최근 본 상품 목록 보기
    @PostMapping(value = "/products/recentProducts")
    public @ResponseBody
    LinkedList<DisplayGoodsExpansion> getRecentProducts(HttpServletRequest request) throws UnsupportedEncodingException {

        Optional<Cookie> value = Arrays.asList(request.getCookies()).stream().filter(e -> e.getName().equals(RECENT_PRODUCTS_COOKIE_NAME)).findFirst();
        LinkedList<String> prCodes = Pattern.compile(",").splitAsStream(URLDecoder.decode(value.get().getValue(), "utf-8")).collect(Collectors.toCollection(LinkedList::new));

        LinkedList<DisplayGoodsExpansion> recentProducts = new LinkedList<>();
        prCodes.stream().limit(RECENT_PRODUCTS_COOKIE_LIMIT).forEach(e ->
        {
            //과거 제품코드가 쿠키에 있을때 조회하면 안되므로 숫자형 체크 2018.09.10.layla
            if (Pattern.matches("^[0-9]+$", e)) {
                ProductDto.ProductRequest dto = new ProductDto.ProductRequest();
                dto.setPrCode(e);
                productRequestDefault(dto);
                dto.setPrKrView("All");
                productRequestCategorySeqDefault(dto);
                recentProducts.add(displayGoodsService.findByDisplayGoodsId(dto));
            } else {
                //숫자아님
            }
        });

        recentProducts.stream().forEach(e -> {
            try {
                e.getDisplayGoods().setImage1(tenthUtill.tenth2ThumbnailPath(e.getDisplayGoods().getImage1(), "product"));
            } catch (NullPointerException n) {
            }
        });

        return recentProducts;

    }

    /*
     * 2018.08.22 수정 layla
     * int totalCount
     * productExpansions
     * */
    private ModelAndView getProductList(ProductDto.ProductRequest productRequest) {
        if (productRequest.getSort() == null) productRequest.setSort(SortType.NEW);
        if (productRequest.getRequestCategory() == null && productRequest.getCtGroup().equals("categories"))
            productRequest.setRequestCategory(productRequest.getCtSeq());
        if (productRequest.getRequestCharacter() == null && productRequest.getCtGroup().equals("characters"))
            productRequest.setRequestCharacter(productRequest.getCtSeq());

        //전체 카운트
        int totalCount = displayGoodsService.findProductCountByCategoryWithCharacter(productRequest);
        PaginationInfo pagination = getPaginationInfo(totalCount, productRequest.getPageIndex(), KakaoFriendsConstants.pageUnit, KakaoFriendsConstants.pageSize);
        boolean globalFilter = productRequest.getFilter() != null && productRequest.getFilter().equals("global") ? true : false;

        ModelAndView mav = new ModelAndView();
        //리스트 정보
        mav.addObject("productExpansions", displayGoodsService.findProductsByCategoryWithCharacter(productRequest, pagination));
        mav.addObject("totalCount", totalCount);
        mav.addObject("pagination", pagination);
        mav.addObject("productRequest", productRequest);
        mav.addObject("sortTypes", SortType.values());
        mav.addObject("pageLink", stringConcatPath("", productRequest.getLanguage(), "products/groups", String.valueOf(productRequest.getCtGroup()), String.valueOf(productRequest.getCtSeq())));
        mav.addObject("globalFilter", globalFilter);
        DateUtil dateUtil = new DateUtil();
        mav.addObject("today", dateUtil.getDateyyyyMMddHHmm());
        mav.setViewName(productRequest.getLanguage() + "/product/list");
        return mav;
    }

    /*
     * 2018.08.23 수정 layla
     * productExpansion -> displayGoodsExpansion
     * suggestedProducts 의 결과값 수정
     * */
    private ModelAndView getProductDetail(ProductDto.ProductRequest productRequest, RedirectAttributes redirectAttributes) {
        productRequestDefault(productRequest);
        productRequestCategorySeqDefault(productRequest);
        //상품상세화면 공통상세정보
        DisplayGoodsExpansion displayGoodsExpansion = displayGoodsService.findByDisplayGoodsId(productRequest);
        productRequestByCategoryGroup(productRequest, displayGoodsExpansion);

        ModelAndView mav = new ModelAndView();

        if (displayGoodsExpansion == null || displayGoodsExpansion.getDisplayGoods() == null) {
            redirectAttributes.addFlashAttribute("emptyMessage", processMessage(messageSource, "alert.product.unavailable"));
            RedirectView redirectView = new RedirectView("/" + productRequest.getLanguage() + "/index");
            mav.setView(redirectView);
        } else {
            //상품상세화면의 옵션정보 select
            DisplayGoodsGroup displayGoodsGroup = displayGoodsService.findByDisplayGoodsIdGoodsAsDetail(displayGoodsExpansion.getDisplayGoods().getId());
            //하나라도 옵션이있을경우에 플래그값 셋팅
            displayGoodsExpansion.setIsHasOption(displayGoodsGroup.getIsHasOption());

            ProductExpansion productInfo = null;
            //단품인경우
            if (displayGoodsGroup.getMainGoodsList().size() == 1 && displayGoodsGroup.getMainGoodsList().get(0).getOptionType().equals(GoodsOptionType.SINGLE.getCode())) {
                productInfo = displayGoodsService.findProducts(displayGoodsGroup.getMainGoodsOptionList().get(0).getId()).get(0);
                mav.addObject("productRequest", productInfo);
            } else {
                mav.addObject("productRequest", null);
            }

            ObjectMapper mapper = new ObjectMapper();
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            String displayGoodsGroupData = null;
            try {
                displayGoodsGroupData = mapper.writeValueAsString(displayGoodsGroup);
            } catch (IOException e) {
                System.out.println("상세정보 Json 에러");
            }
            mav.addObject("displayGoodsDetail", displayGoodsExpansion);
            mav.addObject("displayGoodsGroup", displayGoodsGroupData);
            //상품상세화면 추천상품
            mav.addObject("suggestedProducts", displayGoodsService.findSuggestedByDisplayGoodsId(productRequest));
            mav.addObject("banners", bannerService.findByBannerAreas(Lists.newArrayList(BannerType.PRODUCT_DETAIL, BannerType.PRODUCT_DETAIL_MOBILE)).stream().collect(Collectors.groupingBy(Banner::getBnArea)));
//			mav.addObject("productRequest", productRequest);
            DateUtil dateUtil = new DateUtil();
            mav.addObject("today", dateUtil.getDateyyyyMMddHHmm());

            // pay only
            Set<String> payOnlyPrcodes = KakaoFriendsUtil.getPayOnlyPrcodes();
//            String prcode = displayGoodsExpansion.getDisplayGoods().getCode();
            Set<Long> payOnlyDispCodes = KakaoFriendsUtil.getPayOnlyDispCodes();
            Long dispCode = displayGoodsExpansion.getDisplayGoods().getId();

            mav.addObject("payOnlyPrcodeSet", payOnlyPrcodes);

            if (productInfo != null) {
                mav.addObject("isPayOnlyPrcode", payOnlyPrcodes.contains(productInfo.getProduct().getPrCode()));
            } else {
                mav.addObject("isPayOnlyPrcode", payOnlyPrcodes.contains(displayGoodsExpansion.getDisplayGoods().getDefaultPrcode()));
            }
            mav.addObject("displayGoodsExpansion", displayGoodsExpansion);
            mav.addObject("payOnlyDispcodeSet", payOnlyDispCodes);
            mav.addObject("isPayOnlyDispcode", payOnlyDispCodes.contains(dispCode));

            try {
                recentProductsCookie(displayGoodsExpansion);
            } catch (Exception e) {
                e.printStackTrace();
            }
            mav.setViewName(productRequest.getLanguage() + "/product/detail");
        }
        return mav;
    }

    /*
     * 2018.08.24 수정 layla
     * ProductExpansion -> DisplayGoodsExpansion
     * getProduct().prCode -> getDisplayGoods().id
     * */
    private void recentProductsCookie(DisplayGoodsExpansion displayGoodsExpansion) throws Exception {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getResponse();
        Optional<Cookie> value = Optional.empty();
        LinkedList<String> prCodes = new LinkedList<>();
        if (request.getCookies() != null) {
            value = Arrays.asList(request.getCookies()).stream().filter(e -> e.getName().equals(RECENT_PRODUCTS_COOKIE_NAME)).findFirst();
        }

        if (Optional.empty().equals(value) || !value.isPresent()) {
            prCodes.push(displayGoodsExpansion.getDisplayGoods().getId().toString());
            response.addCookie(new Cookie(RECENT_PRODUCTS_COOKIE_NAME, (URLEncoder.encode(displayGoodsExpansion.getDisplayGoods().getId().toString(), "utf-8"))));
        } else {
            prCodes = Pattern.compile(",").splitAsStream(URLDecoder.decode(value.get().getValue(), "utf-8")).collect(Collectors.toCollection(LinkedList::new));

            if (!prCodes.stream().anyMatch(e -> e.equals(displayGoodsExpansion.getDisplayGoods().getId().toString()))) {
                prCodes.push(displayGoodsExpansion.getDisplayGoods().getId().toString());
                response.addCookie(new Cookie(RECENT_PRODUCTS_COOKIE_NAME, URLEncoder.encode(prCodes.stream().limit(RECENT_PRODUCTS_COOKIE_LIMIT).collect(Collectors.joining(",")), "utf-8")));
            }
        }
    }

    private void productRequestDefault(ProductDto.ProductRequest productRequest) {
        productRequest.setCpCode(getFriendsMember().getMbCpcode());
        productRequest.setPropPrType("4");
        productRequest.setPrUse("Y");
        productRequest.setPrKrView("Y");
        productRequest.setOwnerId(getFriendsMemberId());
    }

    private void productRequestCategorySeqDefault(ProductDto.ProductRequest productRequest) {
        if (null != productRequest.getCtSeq() && (productRequest.getCtSeq().equals(3L) || productRequest.getCtSeq().equals(4L))) {
            productRequest.setCtSeq(null);
        }
    }

    private void productRequestByCategoryGroup(ProductDto.ProductRequest productRequest, DisplayGoodsExpansion displayGoodsExpansion) {
        if (null != productRequest.getCtGroup()) {
            if (displayGoodsExpansion.getCategoryGroup().equals(CategoryGroup.CATEGORIES)) {
                productRequest.setRequestCategory(displayGoodsExpansion.getCategory().getCtCode());
            }
            if (displayGoodsExpansion.getCategoryGroup().getCode().equals("4")) {
                productRequest.setRequestCharacter(displayGoodsExpansion.getCategory().getCtCode());
            }
        }
    }

    private List<CategoryMenu> getSubMenuList(ProductDto.ProductRequest productRequest) {

        Map<Long, List<CategoryMenu>> categoryMenuMap = friendsCacheBuilder.categoryMenuCache.asMap().get(friendsCacheBuilder.getCacheKey(Instant.now(), FRIENDS_CATEGORY_CACHE_NAME));
        List<CategoryMenu> categoryMenus = categoryMenuMap.get(CATEGORY_MENU_NODE);

        CategoryMenu currentCategory = categoryMenus.stream().filter(e -> e.getCtSeq().equals(Long.valueOf(productRequest.getCtSeq()))).findFirst().get();

        Long ctPcode = currentCategory.getCtNode().equals(Long.valueOf(CATEGORY_MENU_NODE)) ? currentCategory.getCtPcode() : currentCategory.getCtSeq();

        return categoryMenus.stream().filter(e -> e.getCtSeq().equals(Long.valueOf(ctPcode)) || e.getCtPcode().equals(Long.valueOf(ctPcode))).collect(toList());

    }

    /**
     * 작성자 : layla
     * 날짜 : 2018. 8. 27.
     * 옵션 선택시 하위 옵션리스트 조회
     * )1옵션 선택시 parentGoodsOptionId = 0 / 2는 해당하는 1옵션의 id 전달 (goodsId x)
     *
     * @return
     */
    //http://localhost:8080/kr/displayGoods/findByDisplayGoodsIdOption?goodsId=13106&parentGoodsOptionId=0
    @RequestMapping(value = "/displayGoods/findByDisplayGoodsIdOption", method = {RequestMethod.POST})
    private ResponseEntity<List<GoodsOption>> findByDisplayGoodsIdOption(GoodsOption goodsOption) {
        List<GoodsOption> goodsOptionList = displayGoodsService.findByDisplayGoodsIdOption(goodsOption.getGoodsId(), goodsOption.getParentGoodsOptionId());

        return new ResponseEntity<>(goodsOptionList, new HttpHeaders(), HttpStatus.OK);
    }

    /**
     * 작성자 : layla
     * 날짜 : 2018. 8. 27.
     * 선택한 옵션의 제품 조회
     *
     * @return
     */
    //http://localhost:8080/kr/displayGoods/findProducts?goodsOptionId=13129
    @RequestMapping(value = "/displayGoods/findProducts", method = {RequestMethod.POST})
    public ResponseEntity<List<ProductExpansion>> findProducts(@RequestParam("goodsOptionId") Long goodsOptionId) {
        List<ProductExpansion> findProducts = displayGoodsService.findProducts(goodsOptionId);

        return new ResponseEntity<>(findProducts, new HttpHeaders(), HttpStatus.OK);
    }
}
