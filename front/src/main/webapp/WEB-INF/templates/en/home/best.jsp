<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="si" uri="http://www.kakaofriends.com/si" %>
<%@ taglib prefix="ll" uri="http://www.kakaofriends.com/ll" %>
<c:set value="${kakaoWebView}" var="kakaoWebView" />

<!-- 인기 상품 -->
<div class="section_best">
    <ul class="list_goods_full">
        <li>
            <a href="/en/products/4647"
               onclick="mainAreaCounting(this.href, 'bestProduct'+'${status.index}')">
                <span class="frame_thumb">
                    <img src="http://t1.kakaocdn.net/friends/prod/product/AW_01_flyRY.jpg" alt="">
                </span>
                <div class="best_info">
                    <span class="label_tag">BEST 1</span>
                    <strong>플라잉 라이언<br>열쇠고리</strong>
                    <p>프렌즈와 함께하는 나날들</p>
                </div>
            </a>
        </li>
        <li>
            <a href="/en/products/5015"
               onclick="mainAreaCounting(this.href, 'bestProduct'+'${status.index}')">
                <span class="frame_thumb">
                    <img src="https://t1.daumcdn.net/friends/prod/product/AW_00_dollslipper_RY.jpg" alt="">
                </span>
                <div class="best_info">
                    <span class="label_tag">BEST 2</span>
                    <strong>라이언<br>봉제인형 슬리퍼</strong>
                    <p>프렌즈와 함께하는 나날들</p>
                </div>
            </a>
        </li>
        <li>
            <a href="/en/products/4830"
               onclick="mainAreaCounting(this.href, 'bestProduct'+'${status.index}')">
                <span class="frame_thumb">
                    <img src="https://t1.daumcdn.net/friends/prod/product/AW_00_hmidifierryan.jpg" alt="">
                </span>
                <div class="best_info">
                    <span class="label_tag">BEST 3</span>
                    <strong>라이언<br>가습기</strong>
                    <p>프렌즈와 함께하는 나날들</p>
                </div>
            </a>
        </li>
    </ul>
    <h3 class="tit_main">주간 베스트 100</h3>
    <ul class="list_goods">
        <c:forEach items="${bestProducts_mobile}" var="bestProduct" varStatus="status">
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
</div>
<!-- // 인기 상품 -->