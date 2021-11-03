<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="si" uri="http://www.kakaofriends.com/si" %>
<spring:eval expression="@environment['kakaofriends.cdn.product']" var="cdn"/>

<div id="mArticle">
    <!-- 2017-10-19 수정 시작 : 마이페이지 탭메뉴 변경 -->
    <div class="menu_tab">
        <ul class="tab_nav">
            <!-- 탭 메뉴 활성화시 li에 on클래스 부여 및 선택됨 대체텍스트 제공 -->
            <li class="on">
                <a href="/en/mypage/orderlist" class="link_tab">Order List <span class="screen_out">selected</span></a>
            </li>
            <li>
                <a href="/en/mypage/wishlist" class="link_tab">Wish List</a>
            </li>
            <li>
                <a href="/en/mypage/cancellist" class="link_tab">Returns</a>
            </li>
            <li>
                <a href="/en/mypage/pointlist" class="link_tab">Point</a>
            </li>
            <li>
                <a href="/en/mypage/couponlist" class="link_tab">Coupon</a>
            </li>
            <li>
                <a href="/en/mypage/onetoone" class="link_tab">Contact Us</a>
            </li>
            <li>
                <a href="/en/mypage/myinfo" class="link_tab">Account</a>
            </li>
        </ul>
    </div>
    <!--// 2017-10-19 수정 끝 : 마이페이지 탭메뉴 변경 -->
    <div class="cont_product">
        <h3 class="screen_out">order list</h3>
        <c:if test="${empty orderList}">
        <p class="desc_nodata">There are no items in your order list.</p>
        </c:if>
        <c:if test="${!empty orderList}">
        <p class="desc_total">Total <em class="emph_total">${totalCount}</em> results have been inquired</p>
        <ul class="list_order">
            <c:forEach items="${orderList}" var="order" varStatus="status">
                <li>
                    <span class="txt_order"><em class="screen_out">order date :</em><fmt:formatDate value="${order.omInDate}" pattern="yyyy.MM.dd HH:mm:ss" /></span>
                    <span class="txt_order txt_num"><em class="tit_num">Order ID :</em><a href="/en/order/shipping/${order.omNum}" class="link_num">${order.omNum}</a></span><!-- PC화면에서만 노출  -->
                    <span class="wrap_thumb">
                        <si:tenthImageTag type="product" imageName="${order.prImage1}" altVal="${empty order.prName1 ? order.prName : order.prName1}"/>
                    </span>
                    <div class="desc_order">
                        <strong class="tit_product">${empty order.prName1 ? order.prName : order.prName1}<span class="txt_more"> <c:if test="${order.orderSubPrTotCnt > 1}"> and others ${order.orderSubPrTotCnt - 1} </c:if> </span></strong>
                        <dl class="list_price">
                            <dt class="txt_num">order :</dt>
                            <dd class="txt_num"><a href="/en/order/shipping/${order.omNum}" class="link_num">${order.omNum}</a></dd>
                            <c:choose>
                            <c:when test="${order.omPayType.code == 7}">
                            <dt>Price :</dt>
                            <dd><fmt:formatNumber value="${order.exchangeItemsMoney}" type="number"/> USD</dd>
                                <dt>Discount :</dt>
                                <dd>${order.omCouponMoney + order.exchangePointMoney > 0 ? "-" : ""}<fmt:formatNumber value="${order.exchangeCouponMoney + order.exchangePointMoney}" type="number"/> USD</dd>
                            <dt>Shipping to :</dt>
                            <dd><fmt:formatNumber value="${order.exchangeDeliveryMoney}" type="number"/> USD</dd>
                        </dl>
                        <dl class="list_price price_total">
                            <dt>Total :</dt>
                            <dd><fmt:formatNumber value="${order.exchangeItemsMoney + order.exchangeDeliveryMoney - order.exchangeCouponMoney - order.exchangePointMoney}" type="number"/> USD</dd>
                        </dl>
                        </c:when>
                        <c:otherwise>
                            <dt>Price :</dt>
                            <dd><fmt:formatNumber value="${order.exchangeItemsMoney}" type="number"/> KRW</dd>
                            <dt>Discount :</dt>
                            <dd>${order.omCouponMoney + order.exchangePointMoney > 0 ? "-" : ""}<fmt:formatNumber value="${order.omCouponMoney + order.exchangePointMoney}" type="number"/> KRW</dd>
                            <dt>Shipping to :</dt>
                            <dd><fmt:formatNumber value="${order.omDeliveryMoney}" type="number"/> KRW</dd>
                            </dl>
                            <dl class="list_price price_total">
                                <dt>Total :</dt>
                                <dd><fmt:formatNumber value="${order.exchangeItemsMoney + order.exchangeDeliveryMoney - order.exchangeCouponMoney - order.exchangePointMoney}" type="number"/> KRW</dd>
                            </dl>
                        </c:otherwise>
                        </c:choose>
                    </div>
                </li>
            </c:forEach>
        </ul>
        <tiles:insertTemplate template="/WEB-INF/templates/en/sub/paging.jsp" flush="true"/>
        </c:if>
    </div>
</div><!--// mArticle -->