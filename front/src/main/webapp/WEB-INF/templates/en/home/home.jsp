<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="si" uri="http://www.kakaofriends.com/si" %>
<%@ taglib prefix="ll" uri="http://www.kakaofriends.com/ll" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set value="${kakaoWebView}" var="kakaoWebView" />

<c:set var="cartPath" value="/en/basket/basket/insert/"/>
<c:if test="${requestScope['javax.servlet.forward.request_uri'] == '/en/index'}">
    <c:set var="cartPath" value="/en/basket/basket/insert_async/"/>
</c:if>

<div style="position: relative;">
    <div class="intro_main">
        <div class="slide_friends slide_main">
            <c:forEach items="${mainRollingsMap}" var="mainRollingMap" varStatus="loop">
                <div class="slide_pannel">
                    <a href="${mainRollingMap.value[0].bnLink}" onclick="mainAreaCounting(this.href, 'rolling'+'${loop.index}')" class="link_slide" target="${mainRollingMap.value[0].bnTarget eq 'self' ? '_self' : (kakaoWebView == 0 ? '_blank' : '_self')}"
                       style="background-color:transparent"><!-- 배경 인라인으로 백그라운드 처리해주세요. -->
                        <div class="bg_option">
                            <img src="https://t1.daumcdn.net/friends/prod/banner/Rbanner_trans_W_2X.png" class="thumb_g rw_show" alt="">
                            <img src="https://t1.daumcdn.net/friends/prod/banner/Rbanner_trans_M.png" class="thumb_g rw_hide" alt="">
                        </div>
                        <div class="frame_thumb">
                            <img src="${kakaoFriendsCdn.banner}/${mainRollingMap.value[2].bnImage}" class="thumb_g rw_show" alt="${mainRollingMap.value[0].bnAlt}">
                            <img src="${kakaoFriendsCdn.banner}/${mainRollingMap.value[3].bnImage}" class="thumb_g rw_hide" alt="${mainRollingMap.value[0].bnAlt}">
                        </div>
                        <div class="info_slide rw_show">
                            <span class="txt_slide" style="color:#000">${mainRollingMap.value[0].bnSubTitle}</span>
                            <strong class="tit_slide" style="color:#000">${mainRollingMap.value[0].bnTitle}</strong>
                        </div>
                        <div class="info_slide rw_hide screen_out">
                            <span class="txt_slide" style="color:#000">${mainRollingMap.value[0].bnSubTitle}</span>
                            <strong class="tit_slide" style="color:#000">${mainRollingMap.value[0].bnTitle}</strong>
                        </div>
                        <span class="main-slide-text-1">${mainRollingMap.value[1].bnTitle}</span>
                        <span class="main-slide-text-2">${mainRollingMap.value[1].bnSubTitle}</span>
                    </a>
                </div>
            </c:forEach>
        </div>
    </div>
    <div class="main-slide-indicator-container">
        <div class="main-slide-indicator"></div>
    </div>
</div>


<c:if test="${fn:length(mainCardWideMap) > 0}">
    <!-- 미니 카드 배너 -->
    <div class="section_bnr">
        <h3 class="tit_main"><a href="javascript:;">Check this out</a></h3>
        <ul class="list_bnr">
            <c:forEach items="${mainCardWideMap}" var="mainCardWide" varStatus="status">
                <li>
                    <a href="${mainCardWide.value[0].bnLink}" onclick="mainAreaCounting(this.href, 'mainCardWide'+'${status.index}')" class="link_bnr">
                        <p class="title">${mainCardWide.value[1].bnTitle}</p>
                        <img src="${kakaoFriendsCdn.banner}/${mainCardWide.value[0].bnImage}" class="thumb_g rw_show" alt="${mainCardWide.value[0].bnAlt}">
                        <img src="${kakaoFriendsCdn.banner}/${mainCardWide.value[1].bnImage}" class="thumb_g rw_hide" alt="${mainCardWide.value[1].bnAlt}">
                            <%--<img src="https://t1.daumcdn.net/friends/prod/banner/201800918_travel_Wcard_W.jpg" class="thumb_g rw_hide" alt="${mainCardWide.value[0].bnAlt}">--%>
                    </a>
                </li>
            </c:forEach>
        </ul>
    </div>
    <!-- // 미니 카드 배너 -->
</c:if>

<c:if test="${fn:length(mainNewProductMap) > 0}">
    <!-- 최신 상품 -->
    <div id="hotStuff" class="section_goods">
        <h3 class="tit_main"><a href="/en/products/groups/new">New Friends</a></h3>
        <ul class="list_goods">
            <c:forEach items="${newProducts}" var="newProduct" varStatus="status">
                <li>
                    <a href="/en/products/${newProduct.product.prCode}"
                       onclick="mainAreaCounting(this.href, 'newProduct'+'${status.index}')">
                        <span class="frame_thumb">
                            <c:choose>
                                <c:when test="${newProduct.isSoldOut}">
                                    <p class="label_out">Sold<br>out</p>
                                </c:when>
                                <c:when test="${newProduct.isDiscountPeriod}">
                                    <p class="label_sale">Sale</p>
                                </c:when>
                                <%--<c:when test="${newProduct.isLimited}"><em class="emph_sticker emph_limited">한정</em></c:when>--%>
                                <%--<c:when test="${newProduct.isPopular}"><em class="emph_sticker emph_popular">인기</em></c:when>--%>
                            </c:choose>
                            <ll:tenthImageTagForLl type="product" imageName="${newProduct.product.prImage1}" altVal=""/>
                        </span>
                    </a>

                    <strong class="tit_item">${newProduct.product.prName1}</strong>
                    <c:if test="${!newProduct.isDiscountPeriod}">
                        <p class="txt_price">
                            <span class="screen_out">price</span>
                            <span>
                                <fmt:formatNumber value="${newProduct.productLevelPrice.exchangePrice}" type="number"/>USD
                                <%--<span class="usd_price"><fmt:formatNumber value="${newProduct.productLevelPrice.exchangePrice}" type="number"/> USD</span>--%>
                            </span>
                        </p>
                    </c:if>
                    <c:if test="${newProduct.isDiscountPeriod}">
                        <p class="txt_price">
                            <span class="screen_out">price</span>
                            <span>
                                <fmt:formatNumber value="${newProduct.productLevelPrice.exchangeDiscountPrice}" type="number"/>USD
                                <%--<span class="usd_price"><fmt:formatNumber value="${newProduct.productLevelPrice.exchangeDiscountPrice}" type="number"/> USD</span>--%>
                            </span>
                        </p>
                    </c:if>
                    <p class="item_state">
                        <c:if test="${!empty newProduct.product.defaultPrcode}">
                        <a href="${cartPath}${newProduct.product.prCode}/${newProduct.product.defaultPrcode}" class="link_cart link_cart_img ${(newProduct.basketCheck > 0) ? 'on link_cart_on_img' : ''}">
                        <!-- 대표상품 설정되있을때 -->
                        </c:if>
                        <c:if test="${empty newProduct.product.defaultPrcode}">
                        <a href="/en/products/${newProduct.product.prCode}" class="link_cart link_cart_img ${(newProduct.basketCheck > 0) ? 'on link_cart_on_img' : ''}">
                            <!-- 대표상품 설정 안되있을때 -->
                        </c:if>
                            <span class="screen_out">cart</span>
                        </a>
                    </p>
                </li>
            </c:forEach>
        </ul>
        <a href="/en/products/groups/new" class="link_more">
        <%--<a href="/kr/products/groups/new" id="btn_more_new" class="link_more">--%>
            More
            <i class="ico_more_product"></i>
        </a>
    </div>
    <!-- // 최신 상품 -->
</c:if>

<c:if test="${fn:length(mainThemeMap) > 0}">
    <c:forEach items="${mainThemeMap}" var="mainThemeMap" varStatus="status">
        <div class="section_goods">
        <a href="${mainThemeMap.value[0].bnLink}" class="link_theme">
            <h3 class="tit_main">${mainThemeMap.value[0].bnTitle}</h3>
            <div class="bg_option rw_show">
                <img data-src="${kakaoFriendsCdn.banner}/${mainThemeMap.value[0].bnImage}" class="thumb_g"
                     alt="${mainThemeMap.value[0].bnAlt}">
            </div>
            <div class="bg_option rw_hide">
                <img data-src="${kakaoFriendsCdn.banner}/${mainThemeMap.value[1].bnImage}" class="thumb_g"
                     alt="${mainThemeMap.value[0].bnAlt}">
            </div>

            <div class="frame_thumb rw_show"><!-- PC -->
                <img data-src="${kakaoFriendsCdn.banner}/${mainThemeMap.value[2].bnImage}" class="thumb_g"
                     alt="${mainThemeMap.value[2].bnAlt}">
            </div>
            <div class="frame_thumb rw_hide"><!-- 모바일 -->
                <img data-src="${kakaoFriendsCdn.banner}/${mainThemeMap.value[3].bnImage}" class="thumb_g"
                     alt="${mainThemeMap.value[3].bnAlt}">
            </div>
            <p class="txt_info">${mainThemeMap.value[0].bnSubTitle}</p>
        </a>

        <ul class="list_goods"><!-- 가로형일 경우 .list_type2 부여 -->
            <c:forEach items="${themeProducts}" var="themeProduct" varStatus="status">
                <li>
                    <a href="/en/products/${themeProduct.product.prCode}"
                       onclick="mainAreaCounting(this.href, 'themeProduct'+'${status.index}')">
                        <span class="frame_thumb">
                            <c:choose>
                                <c:when test="${themeProduct.isSoldOut}">
                                    <p class="label_out">Sold<br>Out</p>
                                </c:when>
                                <c:when test="${themeProduct.isDiscountPeriod}">
                                    <p class="label_sale">Sale</p>
                                </c:when>
                                <%--<c:when test="${newProduct.isLimited}"><em class="emph_sticker emph_limited">한정</em></c:when>--%>
                                <%--<c:when test="${newProduct.isPopular}"><em class="emph_sticker emph_popular">인기</em></c:when>--%>
                            </c:choose>
                            <ll:tenthImageTagForLl type="product" imageName="${themeProduct.product.prImage1}"
                                                   altVal=""/>
                        </span>
                    </a>

                    <strong class="tit_item">${empty themeProduct.product.prName1 ? themeProduct.product.prName : themeProduct.product.prName1}</strong>
                    <c:if test="${!themeProduct.isDiscountPeriod}">
                        <p class="txt_price">
                            <span class="screen_out">Price</span>
                            <span>
                                <fmt:formatNumber value="${themeProduct.productLevelPrice.exchangePrice}" type="number"/>USD
                                <%--<span class="usd_price"><fmt:formatNumber value="${themeProduct.productLevelPrice.exchangePrice}" type="number"/> USD</span>--%>
                            </span>
                        </p>
                    </c:if>
                    <c:if test="${themeProduct.isDiscountPeriod}">
                        <p class="txt_price">
                            <span class="screen_out">Price</span>
                            <span>
                                <fmt:formatNumber value="${themeProduct.productLevelPrice.exchangeDiscountPrice}" type="number"/>USD
                                <%--<span class="usd_price"><fmt:formatNumber value="${themeProduct.productLevelPrice.exchangeDiscountPrice}" type="number"/> USD</span>--%>
                            </span>
                        </p>
                    </c:if>
                    <!-- 2017-10-12 스프라이트 공통클래스 네임 변경 ico_newfriends_v1 -->
                    <p class="item_state">
                        <%--
                        <c:choose>
                            <c:when test="${themeProduct.foreigndeliCheck == 0}">
                                <span class="ico_newfriends_v1 ico_nodelivery">글로벌 배송 불가</span>
                            </c:when>
                            <c:otherwise>
                                <a href="javascript:globalNationPopup()" class="link_delivery">
                                    <span class="ico_newfriends_v1 ico_delivery">글로벌 배송 가능! 안내 팝업 보기</span>
                                </a>
                            </c:otherwise>
                        </c:choose>
                        --%>
                        <c:if test="${!empty themeProduct.product.defaultPrcode}">
                            <a href="${cartPath}${themeProduct.product.prCode}/${themeProduct.product.defaultPrcode}" class="link_cart  ${(themeProduct.basketCheck > 0) ? 'on' : ''}"><!-- 대표상품 설정되있을때 -->
                        </c:if>
                        <c:if test="${empty themeProduct.product.defaultPrcode}">
                            <a href="/en/products/${themeProduct.product.prCode}" class="link_cart ${(themeProduct.basketCheck > 0) ? 'on' : ''}"><!-- 대표상품 설정 안되있을때 -->
                        </c:if>
                        <span class="screen_out">cart</span></a>
                    </p>
                </li>
            </c:forEach>
        </ul>

        <a href="${mainThemeMap.value[0].bnLink}"
           onclick="mainAreaCounting(this.href, 'themeProduct'+'${status.index}')" class="link_more">
            More
            <i class="ico_more_product"></i>
        </a>
    </c:forEach>

    </div>
</c:if>
<c:if test="${fn:length(themeMap) > 0}">
    <!-- 테마 기획전 -->
    <div id="sectionTheme" class="section_goods">
        <c:forEach items="${themeMap}" var="themeMap">
            <a href="/en${themeMap.link}" class="link_theme">
                <h3 class="tit_main">${themeMap.altM}</h3>
                <div class="bg_option rw_show">
                    <img data-src="${kakaoFriendsCdn.theme}/${themeMap.bgImage}" class="thumb_g"
                         alt="${themeMap.bgImage}">
                </div>
                <div class="bg_option rw_hide">
                    <img data-src="${kakaoFriendsCdn.theme}/${themeMap.bgImageM}" class="thumb_g"
                         alt="${themeMap.bgImageM}">
                </div>

                <div class="frame_thumb rw_show"><!-- PC -->
                    <img data-src="${kakaoFriendsCdn.theme}/${themeMap.image}" class="thumb_g"
                         alt="${themeMap.alt}">
                </div>
                <div class="frame_thumb rw_hide"><!-- 모바일 -->
                    <img data-src="${kakaoFriendsCdn.theme}/${themeMap.imageM}" class="thumb_g"
                         alt="${themeMap.altM}">
                </div>
                <p class="txt_info">${themeMap.altSubM}</p>
            </a>

            <c:forEach items="${themeProductMap}" var="themeProductMap" varStatus="status">
                <c:if test="${themeMap.themeCode eq themeProductMap.key}">

                    <ul class="list_goods"><!-- 가로형일 경우 .list_type2 부여 -->
                        <c:forEach items="${themeProductMap.value}" var="themeProductMapItem">
                            <li>
                                <a href="/en/products/${themeProductMapItem.prCode}" onclick="mainAreaCounting(this.href, 'themeProduct'+'${status.index}')">
                                    <span class="frame_thumb">
                                        <c:choose>
                                            <c:when test="${themeProductMapItem.isSoldOut}">
                                                <p class="label_out">Sold<br>Out</p>
                                            </c:when>
                                            <c:when test="${themeProductMapItem.isDiscountPeriod}">
                                                <p class="label_sale">Sale</p>
                                            </c:when>
                                            <%--<c:when test="${newProduct.isLimited}"><em class="emph_sticker emph_limited">한정</em></c:when>--%>
                                            <%--<c:when test="${newProduct.isPopular}"><em class="emph_sticker emph_popular">인기</em></c:when>--%>
                                        </c:choose>
                                        <ll:tenthImageTagForLl type="product"
                                                               imageName="${themeProductMapItem.prImage}"
                                                               altVal=""/>
                                    </span>
                                </a>

                                <strong class="tit_item">${themeProductMapItem.prEnName}</strong>
                                <c:if test="${!themeProductMapItem.isDiscountPeriod}">
                                    <p class="txt_price">
                                        <span class="screen_out">price</span>
                                        <span>
                                            <fmt:formatNumber value="${themeProductMapItem.exchangePrice}" type="number"/>USD
                                            <%--<span class="usd_price"><fmt:formatNumber value="${themeProduct.exchangePrice}" type="number"/> USD</span>--%>
                                        </span>
                                    </p>
                                </c:if>
                                <c:if test="${themeProductMapItem.isDiscountPeriod}">
                                    <p class="txt_price">
                                        <span class="screen_out">price</span>
                                        <span>
                                            <fmt:formatNumber value="${themeProductMapItem.exchangeDiscountPrice}" type="number"/>USD
                                            <%--<span class="usd_price"><fmt:formatNumber value="${themeProduct.exchangeDiscountPrice}" type="number"/> USD</span>--%>
                                        </span>
                                    </p>
                                </c:if>
                                <!-- 2017-10-12 스프라이트 공통클래스 네임 변경 ico_newfriends_v1 -->
                                <span class="item_state">
                                    <%--
                                    <c:choose>
                                        <c:when test="${themeProduct.foreigndeliCheck == 0}">
                                            <span class="ico_newfriends_v1 ico_nodelivery">글로벌 배송 불가</span>
                                        </c:when>
                                        <c:otherwise>
                                            <a href="javascript:globalNationPopup()" class="link_delivery">
                                                <span class="ico_newfriends_v1 ico_delivery">글로벌 배송 가능! 안내 팝업 보기</span>
                                            </a>
                                        </c:otherwise>
                                    </c:choose>
                                    --%>
                                    <c:if test="${!empty themeProductMapItem.defaultPrcode}">
                                        <a href="${cartPath}${themeProductMapItem.prCode}/${themeProductMapItem.defaultPrcode}"
                                           class="link_cart  ${(themeProduct.basketCheck > 0) ? 'on' : ''}"><!-- 대표상품 설정되있을때 -->
                                    </c:if>
                                    <c:if test="${empty themeProductMapItem.defaultPrcode}">
                                        <a href="/en/products/${themeProductMapItem.prCode}"
                                           class="link_cart ${(themeProductMapItem.basketCheck > 0) ? 'on' : ''}"><!-- 대표상품 설정 안되있을때 -->
                                    </c:if>
                                    <span class="screen_out">cart</span></a>
                                </span>
                            </li>
                        </c:forEach>
                    </ul>

                </c:if>
            </c:forEach>
            <a href="/en${themeMap.link}"
               onclick="mainAreaCounting(this.href, 'themeProduct'+'${status.index}')" class="link_more">
                More
                <i class="ico_more_product"></i>
            </a>

        </c:forEach>
    </div>
</c:if>

<c:if test="${fn:length(bestProducts) > 0}">
    <!-- 인기 상품 -->
    <div id="sectionBest" class="section_goods">
        <h3 class="tit_main"><a href="/en/products/groups/best">Best Friends</a></h3>
        <ul class="list_goods">
            <c:forEach items="${bestProducts}" var="bestProduct" varStatus="status">
                <li>
                    <a href="/en/products/${bestProduct.product.prCode}"
                       onclick="mainAreaCounting(this.href, 'bestProduct'+'${status.index}')">
                        <span class="frame_thumb">
                            <c:choose>
                                <c:when test="${bestProduct.isSoldOut}">
                                    <p class="label_out">Sold<br>Out</p>
                                </c:when>
                                <c:when test="${bestProduct.isDiscountPeriod}">
                                    <p class="label_sale">Sale</p>
                                </c:when>
                                <%--<c:when test="${newProduct.isLimited}"><em class="emph_sticker emph_limited">한정</em></c:when>--%>
                                <%--<c:when test="${newProduct.isPopular}"><em class="emph_sticker emph_popular">인기</em></c:when>--%>
                            </c:choose>
                            <ll:tenthImageTagForLl type="product" imageName="${bestProduct.product.prImage1}"
                                                   altVal=""/>
                        </span>
                        <strong class="tit_item">${bestProduct.product.prName1}</strong>
                        <c:choose>
                            <c:when test="${!bestProduct.isDiscountPeriod}">
                                <p class="txt_price">
                                    <span class="screen_out">Price</span>
                                    <span>
                                        <fmt:formatNumber value="${bestProduct.productLevelPrice.exchangePrice}" type="number"/>USD
                                        <%--<span class="usd_price"><fmt:formatNumber value="${bestProduct.productLevelPrice.exchangePrice}" type="number"/> USD</span>--%>
                                    </span>
                                </p>
                            </c:when>
                            <c:otherwise>
                                <p class="txt_price">
                                    <span class="screen_out">Price</span>
                                    <span>
                                        <fmt:formatNumber value="${bestProduct.productLevelPrice.exchangeDiscountPrice}" type="number"/>USD
                                        <%--<span class="usd_price"><fmt:formatNumber value="${bestProduct.productLevelPrice.exchangeDiscountPrice}" type="number"/> USD</span>--%>
                                    </span>
                                </p>
                            </c:otherwise>
                        </c:choose>
                    </a>
                    <p class="item_state">
                            <%--
                            <c:choose>
                                <c:when test="${bestProduct.foreigndeliCheck > 0}">
                                    <a href="javascript:globalNationPopup()" class="link_delivery">
                                        <span class="ico_newfriends_v1 ico_delivery">글로벌 배송 가능</span>
                                    </a>
                                </c:when>
                                <c:otherwise>
                                    <span class="ico_newfriends_v1 ico_nodelivery">글로벌 배송 불가</span>
                                </c:otherwise>
                            </c:choose>
                            --%>
                        <c:if test="${!empty bestProduct.product.defaultPrcode}">
                        <a href="${cartPath}${bestProduct.product.prCode}/${bestProduct.product.defaultPrcode}"
                           class="link_cart link_cart_img ${(bestProduct.basketCheck > 0) ? 'on link_cart_on_img' : ''}">
                            <!-- 대표상품 설정되있을때 -->
                            </c:if>
                            <c:if test="${empty bestProduct.product.defaultPrcode}">
                            <a href="/en/products/${bestProduct.product.prCode}"
                               class="link_cart link_cart_img ${(bestProduct.basketCheck > 0) ? 'on link_cart_on_img' : ''}">
                                <!-- 대표상품 설정 안되있을때 -->
                                </c:if>
                                <span class="screen_out">cart</span>
                            </a>
                    </p>
                </li>
            </c:forEach>
        </ul>
        <a href="/en/products/groups/best" class="link_more">
                <%--<a href="/en/products/groups/best" id="btn_more_best" class="link_more">--%>
            More
            <span class="ico_more_product"></span>
        </a>
    </div>
    <!-- // 인기 상품 -->
</c:if>

<c:if test="${kakaoWebView == 0}">
    <!-- 더 많은 브랜드 스토리 -->
</c:if>
<div class="section_nav">
    <h3 class="tit_main">Haven’t decided yet?</h3>
    <ul class="list_category">
        <c:forEach items="${categoryMenu[3]}" var="menu">
            <c:if test="${!empty menu.ctChildren and menu.ctSeq ne '87'}">
                <c:choose>
                    <c:when test="${menu.ctSeq eq '115'}"> <!-- NINIS Code RealDB : 115 , TestDB : 114 -->
                        <li>
                            <a href="/en/products/groups/categories/${menu.ctSeq}?requestCategory=${menu.ctSeq}">
                                <span class="img_gnb niniz">${menu.ctEname}</span>
                            </a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li>
                            <a href="/en/products/groups/categories/${menu.ctSeq}?requestCategory=${menu.ctSeq}">${menu.ctEname}</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </c:if>
        </c:forEach>
    </ul>
</div>

<div class="section_notice">
    <!-- 공지사항 -->
    <a href="/en/customcenter/bnotice/#${notice.bdaSeq}" class="link_news en">
        <span class="ico_newfriends_v1 ico_news"></span>
        <em>Notice</em>
        <span class="txt_news">${notice.bdaName}</span>
        <i class="ico_more_notice"></i>
    </a>
    <!-- // 공지사항 -->

    <sec:authorize access="isFullyAuthenticated()">
        <div class="section_kakaotalk">
            <strong>Discover Kakao Friends’<br>latest news<br>and special offers!</strong>
            <p>eceive notifications about Kakao Friends events<br>and information on Kakao Talk</p>
            <button id="btn_kakaotalk" class="btn_kakaotalk">Add Friend</button>
            <span class="friends"></span>
        </div>
    </sec:authorize>

    <sec:authorize access="isAnonymous()">
        <div class="section_kakaotalk">
            <strong>Discover Kakao Friends’<br>latest news<br>and special offers!</strong>
            <p>eceive notifications about Kakao Friends events<br>and information on Kakao Talk</p>
            <button id="btn_kakaotalk_login_kr" class="btn_kakaotalk">Add Friend</button>
            <span class="friends"></span>
        </div>
    </sec:authorize>


</div> <!-- //item -->
