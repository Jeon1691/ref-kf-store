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
            <li>
                <a href="/en/mypage/orderlist" class="link_tab">Order List</a>
            </li>
            <li>
                <a href="/en/mypage/wishlist" class="link_tab">Wish List</a>
            </li>
            <li class="on">
                <a href="/en/mypage/cancellist" class="link_tab">Returns <span class="screen_out">selected</span></a>
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
        <h3 class="screen_out">Returns</h3>
        <c:if test="${empty(cancelList)}">
        <p class="desc_nodata">There are no items in your returns.</p>
        </c:if>
        <c:if test = "${!empty cancelList}">
        <p class="desc_total">Total <em class="emph_total">${totalCount}</em> results have been inquired</p>
        <ul class="list_order">
            <c:forEach items="${cancelList}" var="cancel" varStatus="status">
            <li>
                <span class="txt_order"><em class="screen_out">order date :</em><fmt:formatDate value="${cancel.orderInfo.omInDate}" pattern="yyyy.MM.dd HH:mm:ss" /></span>
                <span class="txt_order txt_num"><em class="tit_num">Order ID :</em><a href="/en/order/shipping/${cancel.orderInfo.omNum}" class="link_num">${cancel.orderInfo.omNum}</a></span><!-- PC화면에서만 노출  -->
                <span class="txt_order txt_desc"><em class="screen_out">state :</em>
                <c:choose>
                    <c:when test="${cancel.cancelSubmitCnt > 0}"><span class="txt_progress"> Canceling : ${cancel.cancelSubmitCnt} </span> </c:when>
                    <c:when test="${cancel.returnSubmitCnt > 0}"><span class="txt_progress"> Returning : ${cancel.returnSubmitCnt} </span> </c:when>
                    <c:when test="${cancel.exchangeSubmitCnt > 0}"><span class="txt_progress"> Exchange : ${cancel.exchangeSubmitCnt} </span> </c:when>
                    <c:when test="${cancel.cancelSubmitCnt eq 0 and cancel.cancelCompleteCnt > 0}"> Cancel completed </c:when>
                    <c:when test="${cancel.returnSubmitCnt eq 0 and cancel.returnCompleteCnt > 0}"> Returning completed </c:when>
                    <c:when test="${cancel.exchangeSubmitCnt eq 0 and cancel.exchangeCompleteCnt > 0}"> Exchange completed </c:when>
                </c:choose>
                </span><!-- 취소중인경우 txt_cancel 클래스 추가  -->
                <span class="wrap_thumb">
                    <%--<img src="${cdn}/${empty cancel.orderInfo.prImage12 ? cancel.orderInfo.prImage1 : cancel.orderInfo.prImage12}" class="thumb_g" alt="${empty cancel.orderInfo.prName1 ? cancel.orderInfo.prName : cancel.orderInfo.prName1}">--%>
                    <si:tenthImageTag type="product" imageName="${cancel.orderInfo.prImage1}" altVal="${empty cancel.orderInfo.prName1 ? cancel.orderInfo.prName : cancel.orderInfo.prName1}"/>
                </span>
                <div class="desc_order">
                    <strong class="tit_product">${empty cancel.orderInfo.prName1 ? cancel.orderInfo.prName : cancel.orderInfo.prName1}<span class="txt_more"> <c:if test="${cancel.orderInfo.orderSubPrTotCnt > 1}"> and others(${cancel.orderInfo.orderSubPrTotCnt - 1}) </c:if> </span></strong>
                    <dl class="list_price">
                        <dt class="txt_num">Order ID :</dt><!-- mobile화면에서만 노출  -->
                        <dd class="txt_num"><a href="/en/order/shipping/${cancel.orderInfo.omNum}" class="link_num">${cancel.orderInfo.omNum}</a></dd><!-- mobile화면에서만 노출  -->
                        <c:choose>
                        <c:when test="${cancel.orderInfo.omPayType.code == 7}">
                        <dt>Price :</dt>
                        <dd><fmt:formatNumber value="${cancel.orderInfo.exchangeItemsMoney}" type="number"/> USD</dd>
                        <c:if test="${cancel.orderInfo.omCouponMoney > 0}">
                            <dt>Discount :</dt>
                            <dd>-<fmt:formatNumber value="${cancel.orderInfo.exchangeCouponMoney}" type="number"/> USD</dd>
                        </c:if>
                        <dt>Shipping to :</dt>
                        <dd><fmt:formatNumber value="${cancel.orderInfo.exchangeDeliveryMoney}" type="number"/> USD</dd>
                        </dl>
                        <dl class="list_price price_total">
                            <dt>Total :</dt>
                            <dd><fmt:formatNumber value="${cancel.orderInfo.exchangeItemsMoney + cancel.orderInfo.exchangeDeliveryMoney - cancel.orderInfo.exchangeCouponMoney}" type="number"/> USD</dd>
                        </dl>
                    </c:when>
                    <c:otherwise>
                        <dt>Price :</dt>
                        <dd><fmt:formatNumber value="${cancel.orderInfo.totalMoney + cancel.orderInfo.omCouponMoney - cancel.orderInfo.omDeliveryMoney}" type="number"/> KRW</dd>
                        <c:if test="${cancel.orderInfo.omCouponMoney > 0}">
                            <dt>Discount :</dt>
                            <dd>-<fmt:formatNumber value="${cancel.orderInfo.omCouponMoney}" type="number"/> KRW</dd>
                        </c:if>
                        <dt>Shipping to :</dt>
                        <dd><fmt:formatNumber value="${cancel.orderInfo.omDeliveryMoney}" type="number"/> KRW</dd>
                        </dl>
                        <dl class="list_price price_total">
                            <dt>Total :</dt>
                                <dd><strong><fmt:formatNumber value="${cancel.orderInfo.totalMoney}" type="number"/> KRW</strong></dd>
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