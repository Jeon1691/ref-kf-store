<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="si" uri="http://www.kakaofriends.com/si" %>
<%@ taglib prefix="ll" uri="http://www.kakaofriends.com/ll" %>
<c:set value="${kakaoWebView}" var="kakaoWebView" />

<c:set var="cartPath" value="/kr/basket/basket/insert/"/>
<c:if test="${requestScope['javax.servlet.forward.request_uri'] == '/kr/index'}">
    <c:set var="cartPath" value="/kr/basket/basket/insert_async/"/>
</c:if>

<!-- 최신 상품 -->
<div class="section_new">
    <h3 class="tit_main">
        <a href="/kr/products/groups/new">MERRY FRIENDS<br>CHRISTMAS</a>
        <img src="http://t1.kakaocdn.net/friends/new_store/img1.png" alt="">
    </h3>
    <ul class="list_goods">
        <c:forEach items="${newProducts.subList(0,8)}" var="newProduct" varStatus="status">
            <li>
                <a href="/kr/products/${newProduct.product.prCode}"
                   onclick="mainAreaCounting(this.href, 'newProduct'+'${status.index}')">
                    <span class="frame_thumb">
                        <c:choose>
                            <c:when test="${newProduct.isSoldOut}">
                                <p class="label_out">품절</p>
                            </c:when>
                            <c:when test="${newProduct.isDiscountPeriod}">
                                <p class="label_sale">할인</p>
                            </c:when>
                            <%--<c:when test="${newProduct.isLimited}"><em class="emph_sticker emph_limited">한정</em></c:when>--%>
                            <%--<c:when test="${newProduct.isPopular}"><em class="emph_sticker emph_popular">인기</em></c:when>--%>
                        </c:choose>
                        <ll:tenthImageTagForLl type="product" imageName="${newProduct.product.prImage1}"
                                          altVal=""/>
                    </span>
                </a>

                <strong class="tit_item">${newProduct.product.prName}</strong>
                <c:if test="${!newProduct.isDiscountPeriod}">
                    <p class="txt_price">
                        <span class="screen_out">금액</span>
                        <span>
                            <fmt:formatNumber value="${newProduct.productLevelPrice.prlpSaleprice1}"
                                              type="number"/>원
                            <%--<span class="usd_price"><fmt:formatNumber value="${newProduct.productLevelPrice.exchangePrice}" type="number"/> USD</span>--%>
                        </span>
                    </p>
                </c:if>
                <c:if test="${newProduct.isDiscountPeriod}">
                    <p class="txt_price">
                        <span class="screen_out">금액</span>
                        <span>
                            <fmt:formatNumber value="${newProduct.productLevelPrice.prlpDiscountprice1}"
                                              type="number"/>원
                            <%--<span class="usd_price"><fmt:formatNumber value="${newProduct.productLevelPrice.exchangeDiscountPrice}" type="number"/> USD</span>--%>
                        </span>
                    </p>
                </c:if>
                <p class="item_state">
                    <c:if test="${!empty newProduct.product.defaultPrcode}">
                    <a href="${cartPath}${newProduct.product.prCode}/${newProduct.product.defaultPrcode}"
                       class="link_cart link_cart_img ${(newProduct.basketCheck > 0) ? 'on link_cart_on_img' : ''}">
                        <!-- 대표상품 설정되있을때 -->
                    </c:if>
                    <c:if test="${empty newProduct.product.defaultPrcode}">
                    <a href="/kr/products/${newProduct.product.prCode}"
                       class="link_cart link_cart_img ${(newProduct.basketCheck > 0) ? 'on link_cart_on_img' : ''}">
                        <!-- 대표상품 설정 안되있을때 -->
                    </c:if>
                        <span class="screen_out">장바구니</span>
                    </a>
                </p>
            </li>
        </c:forEach>
    </ul>
</div>
<div class="section_new">
    <h3 class="tit_sub">
        <img src="http://t1.kakaocdn.net/friends/new_store/img2.png" alt="">
    </h3>
    <ul class="list_goods">
        <%--<c:forEach items="${newProducts.subList(8,newProducts.size()-8)}" var="newProduct" varStatus="status">--%>
        <c:forEach items="${newProducts}" var="newProduct" varStatus="status">
            <li>
                <a href="/kr/products/${newProduct.product.prCode}"
                   onclick="mainAreaCounting(this.href, 'newProduct'+'${status.index}')">
                    <span class="frame_thumb">
                        <c:choose>
                            <c:when test="${newProduct.isSoldOut}">
                                <p class="label_out">품절</p>
                            </c:when>
                            <c:when test="${newProduct.isDiscountPeriod}">
                                <p class="label_sale">할인</p>
                            </c:when>
                            <%--<c:when test="${newProduct.isLimited}"><em class="emph_sticker emph_limited">한정</em></c:when>--%>
                            <%--<c:when test="${newProduct.isPopular}"><em class="emph_sticker emph_popular">인기</em></c:when>--%>
                        </c:choose>
                        <ll:tenthImageTagForLl type="product" imageName="${newProduct.product.prImage1}"
                                          altVal=""/>
                    </span>
                </a>

                <strong class="tit_item">${newProduct.product.prName}</strong>
                <c:if test="${!newProduct.isDiscountPeriod}">
                    <p class="txt_price">
                        <span class="screen_out">금액</span>
                        <span>
                            <fmt:formatNumber value="${newProduct.productLevelPrice.prlpSaleprice1}"
                                              type="number"/>원
                            <%--<span class="usd_price"><fmt:formatNumber value="${newProduct.productLevelPrice.exchangePrice}" type="number"/> USD</span>--%>
                        </span>
                    </p>
                </c:if>
                <c:if test="${newProduct.isDiscountPeriod}">
                    <p class="txt_price">
                        <span class="screen_out">금액</span>
                        <span>
                            <fmt:formatNumber value="${newProduct.productLevelPrice.prlpDiscountprice1}"
                                              type="number"/>원
                            <%--<span class="usd_price"><fmt:formatNumber value="${newProduct.productLevelPrice.exchangeDiscountPrice}" type="number"/> USD</span>--%>
                        </span>
                    </p>
                </c:if>
                <p class="item_state">
                    <c:if test="${!empty newProduct.product.defaultPrcode}">
                    <a href="${cartPath}${newProduct.product.prCode}/${newProduct.product.defaultPrcode}"
                       class="link_cart link_cart_img ${(newProduct.basketCheck > 0) ? 'on link_cart_on_img' : ''}">
                        <!-- 대표상품 설정되있을때 -->
                        </c:if>
                        <c:if test="${empty newProduct.product.defaultPrcode}">
                        <a href="/kr/products/${newProduct.product.prCode}"
                           class="link_cart link_cart_img ${(newProduct.basketCheck > 0) ? 'on link_cart_on_img' : ''}">
                            <!-- 대표상품 설정 안되있을때 -->
                            </c:if>
                            <span class="screen_out">장바구니</span>
                        </a>
                </p>
            </li>
        </c:forEach>
    </ul>
</div>
<!-- // 최신 상품 -->