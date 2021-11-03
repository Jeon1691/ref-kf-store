<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="si" uri="http://www.kakaofriends.com/si" %>
<%@ taglib prefix="ll" uri="http://www.kakaofriends.com/ll" %>
<c:set value="${kakaoWebView}" var="kakaoWebView" />

<!-- 최신 상품 -->
<div class="section_new">
    <h3 class="tit_main">
        <a href="/kr/products/groups/new">MERRY FRIENDS<br>CHRISTMAS</a>
        <img src="http://t1.kakaocdn.net/friends/new_store/img1.png" alt="">
    </h3>
    <ul class="list_goods"><!-- 가로형일 경우 .list_type2 부여 -->
        <c:forEach items="${newProducts.subList(0,8)}" var="themeProduct" varStatus="status">
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
</div>
<div class="section_new">
    <h3 class="tit_sub">
        <img src="http://t1.kakaocdn.net/friends/new_store/img2.png" alt="">
    </h3>
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
</div>
<!-- // 최신 상품 -->