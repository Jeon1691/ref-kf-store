<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="si" uri="http://www.kakaofriends.com/si" %>
<%@ taglib prefix="ll" uri="http://www.kakaofriends.com/ll" %>
<c:set value="${kakaoWebView}" var="kakaoWebView" />

<!-- 세일 상품 -->
<div class="section_sale">
    <ul class="list_goods_full">
        <li>
            <a href="https://store.kakaofriends.com/en/products/5020"
               onclick="mainAreaCounting(this.href, 'saleProduct'+'${status.index}')">
                <p class="label_sale">40%</p>
                <span class="frame_thumb">
                    <img src="http://t1.daumcdn.net/friends/prod/product/FRPBRYTMS1014_AW_01.jpg" alt="">
                </span>
                <div class="sale_info">
                    <strong>유자차 세트_라이언</strong>
                    <span class="txt_price">20,000원</span>
                    <span class="prev_price">28,000원</span>

                    <p class="item_state">
                        <%--<c:if test="${!empty bestProduct.product.defaultPrcode}">--%>
                        <a href="${cartPath}${bestProduct.product.prCode}/${bestProduct.product.defaultPrcode}"
                           class="link_cart link_cart_img ${(bestProduct.basketCheck > 0) ? 'on link_cart_on_img' : ''}">
                            <%--<!-- 대표상품 설정되있을때 -->--%>
                            <%--</c:if>--%>
                            <%--<c:if test="${empty bestProduct.product.defaultPrcode}">--%>
                            <%--<a href="/kr/products/${bestProduct.product.prCode}"--%>
                            <%--class="link_cart link_cart_img ${(bestProduct.basketCheck > 0) ? 'on link_cart_on_img' : ''}">--%>
                            <%--<!-- 대표상품 설정 안되있을때 -->--%>
                            <%--</c:if>--%>
                            <span class="screen_out">장바구니</span>
                        </a>
                    </p>
                </div>
            </a>
        </li>
        <li>
            <a href="https://store.kakaofriends.com/en/products/5070"
               onclick="mainAreaCounting(this.href, 'saleProduct'+'${status.index}')">
                <p class="label_sale">40%</p>
                <span class="frame_thumb">
                    <img src="http://t1.daumcdn.net/friends/prod/editor/0debc17c-5edf-49db-a9f6-2466e979f52a.jpg" alt="">
                </span>
                <div class="sale_info">
                    <strong>청소용 슬리퍼_어피치</strong>
                    <span class="txt_price">10,000원</span>
                    <span class="prev_price">18,000원</span>

                    <p class="item_state">
                        <%--<c:if test="${!empty bestProduct.product.defaultPrcode}">--%>
                        <a href="${cartPath}${bestProduct.product.prCode}/${bestProduct.product.defaultPrcode}"
                           class="link_cart link_cart_img ${(bestProduct.basketCheck > 0) ? 'on link_cart_on_img' : ''}">
                            <%--<!-- 대표상품 설정되있을때 -->--%>
                            <%--</c:if>--%>
                            <%--<c:if test="${empty bestProduct.product.defaultPrcode}">--%>
                            <%--<a href="/kr/products/${bestProduct.product.prCode}"--%>
                            <%--class="link_cart link_cart_img ${(bestProduct.basketCheck > 0) ? 'on link_cart_on_img' : ''}">--%>
                            <%--<!-- 대표상품 설정 안되있을때 -->--%>
                            <%--</c:if>--%>
                            <span class="screen_out">장바구니</span>
                        </a>
                    </p>
                </div>
            </a>
        </li>
        <li>
            <a href="https://store.kakaofriends.com/en/products/5058"
               onclick="mainAreaCounting(this.href, 'saleProduct'+'${status.index}')">
                <p class="label_sale">40%</p>
                <span class="frame_thumb">
                    <img src="http://t1.daumcdn.net/friends/prod/editor/6d228d35-3ea3-4ef6-8ad4-c7614f22d189.jpg" alt="">
                </span>
                <div class="sale_info">
                    <strong>메리프렌즈_크리스마스오르골함</strong>
                    <span class="txt_price">19,000원</span>
                    <span class="prev_price">59,000원</span>

                    <p class="item_state">
                        <%--<c:if test="${!empty bestProduct.product.defaultPrcode}">--%>
                        <a href="${cartPath}${bestProduct.product.prCode}/${bestProduct.product.defaultPrcode}"
                           class="link_cart link_cart_img ${(bestProduct.basketCheck > 0) ? 'on link_cart_on_img' : ''}">
                            <%--<!-- 대표상품 설정되있을때 -->--%>
                            <%--</c:if>--%>
                            <%--<c:if test="${empty bestProduct.product.defaultPrcode}">--%>
                            <%--<a href="/kr/products/${bestProduct.product.prCode}"--%>
                            <%--class="link_cart link_cart_img ${(bestProduct.basketCheck > 0) ? 'on link_cart_on_img' : ''}">--%>
                            <%--<!-- 대표상품 설정 안되있을때 -->--%>
                            <%--</c:if>--%>
                            <span class="screen_out">장바구니</span>
                        </a>
                    </p>
                </div>
            </a>
        </li>
        <li>
            <a href="https://store.kakaofriends.com/en/products/5073"
               onclick="mainAreaCounting(this.href, 'saleProduct'+'${status.index}')">
                <p class="label_sale">40%</p>
                <span class="frame_thumb">
                    <img src="https://t1.daumcdn.net/friends/prod/product/FRPBMZSQT0003_AW_00_.jpg" alt="">
                </span>
                <div class="sale_info">
                    <strong>스퀴즈미니인형_무지</strong>
                    <span class="txt_price">1,000원</span>
                    <span class="prev_price">8,000원</span>

                    <p class="item_state">
                        <%--<c:if test="${!empty bestProduct.product.defaultPrcode}">--%>
                        <a href="${cartPath}${bestProduct.product.prCode}/${bestProduct.product.defaultPrcode}"
                           class="link_cart link_cart_img ${(bestProduct.basketCheck > 0) ? 'on link_cart_on_img' : ''}">
                            <%--<!-- 대표상품 설정되있을때 -->--%>
                            <%--</c:if>--%>
                            <%--<c:if test="${empty bestProduct.product.defaultPrcode}">--%>
                            <%--<a href="/kr/products/${bestProduct.product.prCode}"--%>
                            <%--class="link_cart link_cart_img ${(bestProduct.basketCheck > 0) ? 'on link_cart_on_img' : ''}">--%>
                            <%--<!-- 대표상품 설정 안되있을때 -->--%>
                            <%--</c:if>--%>
                            <span class="screen_out">장바구니</span>
                        </a>
                    </p>
                </div>
            </a>
        </li>
        <li>
            <a href="https://store.kakaofriends.com/en/products/4532"
               onclick="mainAreaCounting(this.href, 'saleProduct'+'${status.index}')">
                <p class="label_sale">40%</p>
                <span class="frame_thumb">
                    <img src="https://t1.daumcdn.net/friends/prod/product/FRPBNEHPP0004_AW_00.jpg" alt="">
                </span>
                <div class="sale_info">
                    <strong>스마일_핸드퍼펫 네오</strong>
                    <span class="txt_price">10,000원</span>
                    <span class="prev_price">17,000원</span>

                    <p class="item_state">
                        <%--<c:if test="${!empty bestProduct.product.defaultPrcode}">--%>
                        <a href="${cartPath}${bestProduct.product.prCode}/${bestProduct.product.defaultPrcode}"
                           class="link_cart link_cart_img ${(bestProduct.basketCheck > 0) ? 'on link_cart_on_img' : ''}">
                            <%--<!-- 대표상품 설정되있을때 -->--%>
                            <%--</c:if>--%>
                            <%--<c:if test="${empty bestProduct.product.defaultPrcode}">--%>
                            <%--<a href="/kr/products/${bestProduct.product.prCode}"--%>
                            <%--class="link_cart link_cart_img ${(bestProduct.basketCheck > 0) ? 'on link_cart_on_img' : ''}">--%>
                            <%--<!-- 대표상품 설정 안되있을때 -->--%>
                            <%--</c:if>--%>
                            <span class="screen_out">장바구니</span>
                        </a>
                    </p>
                </div>
            </a>
        </li>
    </ul>
    <h3 class="tit_main"><a href="javascript:;">어머! 이것도 할인해?</a></h3>
    <ul class="list_goods">
        <c:forEach items="${newSaleProducts}" var="newSaleProducts" varStatus="status">
        <%--<c:forEach items="${bestProducts}" var="newSaleProducts" varStatus="status">--%>
            <li>
                <a href="/en/products/${newSaleProducts.product.prCode}"
                   onclick="mainAreaCounting(this.href, 'bestProduct'+'${status.index}')">
                    <c:if test="${newSaleProducts.productLevelPrice.prlpDiscountprice1 ne '0'}">
                        <c:set var="percent" value="${(newSaleProducts.productLevelPrice.prlpSaleprice1-newSaleProducts.productLevelPrice.prlpDiscountprice1)/newSaleProducts.productLevelPrice.prlpSaleprice1}"/>
                    </c:if>
                    <span class="frame_thumb">
                        <c:choose>
                            <c:when test="${newSaleProducts.isSoldOut}">
                                <p class="label_out">Sold<br>Out</p>
                            </c:when>
                            <c:when test="${newSaleProducts.isDiscountPeriod}">
                                <p class="label_sale"><fmt:formatNumber value="${percent}" type="percent" pattern=""/></p>
                            </c:when>
                            <%--<c:when test="${newProduct.isLimited}"><em class="emph_sticker emph_limited">한정</em></c:when>--%>
                            <%--<c:when test="${newProduct.isPopular}"><em class="emph_sticker emph_popular">인기</em></c:when>--%>
                        </c:choose>
                        <ll:tenthImageTagForLl type="product" imageName="${newSaleProducts.product.prImage1}"
                                          altVal=""/>
                    </span>
                    <strong class="tit_item">${newSaleProducts.product.prName1}</strong>
                    <c:choose>
                        <c:when test="${!newSaleProducts.isDiscountPeriod}">
                            <p class="txt_price">
                                <span class="screen_out">금액</span>
                                <span>
                                    <fmt:formatNumber
                                            value="${newSaleProducts.productLevelPrice.exchangePrice}"
                                            type="number"/>USD
                                    <%--<span class="usd_price"><fmt:formatNumber value="${bestProduct.productLevelPrice.exchangePrice}" type="number"/> USD</span>--%>
                                </span>
                                <%--<span class="prev_price"><fmt:formatNumber--%>
                                        <%--value="${newSaleProducts.productLevelPrice.prlpSaleprice1}"--%>
                                        <%--type="number"/>원</span>--%>
                            </p>
                        </c:when>
                        <c:otherwise>
                            <p class="txt_price">
                                <span class="screen_out">금액</span>
                                <span>
                                    <fmt:formatNumber value="${newSaleProducts.productLevelPrice.exchangeDiscountPrice}" type="number"/>USD
                                </span>
                                <span class="prev_price"><fmt:formatNumber
                                        value="${newSaleProducts.productLevelPrice.exchangePrice}"
                                        type="number"/>USD</span>
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
                    <c:if test="${!empty newSaleProducts.product.defaultPrcode}">
                    <a href="${cartPath}${newSaleProducts.product.prCode}/${newSaleProducts.product.defaultPrcode}"
                       class="link_cart link_cart_img ${(bestProduct.basketCheck > 0) ? 'on link_cart_on_img' : ''}">
                    <!-- 대표상품 설정되있을때 -->
                    </c:if>
                    <c:if test="${empty newSaleProducts.product.defaultPrcode}">
                    <a href="/en/products/${newSaleProducts.product.prCode}"
                       class="link_cart link_cart_img ${(newSaleProducts.basketCheck > 0) ? 'on link_cart_on_img' : ''}">
                        <!-- 대표상품 설정 안되있을때 -->
                    </c:if>
                        <span class="screen_out">Cart</span>
                    </a>
                </p>
            </li>
        </c:forEach>
    </ul>
</div>
<!-- // 인기 상품 -->