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
                <a href="/kr/mypage/orderlist" class="link_tab">주문내역 <span class="screen_out">선택됨</span></a>
            </li>
            <li>
                <a href="/kr/mypage/wishlist" class="link_tab">찜</a>
            </li>
            <li>
                <a href="/kr/mypage/cancellist" class="link_tab">취소/교환</a>
            </li>
            <li>
                <a href="/kr/mypage/pointlist" class="link_tab">포인트</a>
            </li>
            <li>
                <a href="/kr/mypage/couponlist" class="link_tab">쿠폰</a>
            </li>
            <li>
                <a href="/kr/mypage/onetoone" class="link_tab">1:1문의</a>
            </li>
            <li>
                <a href="/kr/mypage/myinfo" class="link_tab">개인정보</a>
            </li>
        </ul>
    </div>
    <!--// 2017-10-19 수정 끝 : 마이페이지 탭메뉴 변경 -->
    <div class="cont_product">
        <h3 class="screen_out">주문 내역</h3>
        <c:if test="${empty orderList}">
        <p class="desc_nodata">주문 내역이 존재하지 않습니다.</p>
        </c:if>
        <c:if test="${!empty orderList}">
        <p class="desc_total">총 <em class="emph_total">${totalCount}개</em> 의 상품이 조회되었습니다.</p>
        <ul class="list_order">
            <c:forEach items="${orderList}" var="order" varStatus="status">
                <li>
                    <span class="txt_order"><em class="screen_out">주문날짜 :</em><fmt:formatDate value="${order.omInDate}" pattern="yyyy.MM.dd HH:mm:ss" /></span>
                    <span class="txt_order txt_num"><em class="tit_num">주문번호 :</em><a href="/kr/order/shipping/${order.omNum}" class="link_num">${order.omNum}</a></span><!-- PC화면에서만 노출  -->
                    <span class="wrap_thumb">
                        <%--<img src="${cdn}/${empty order.prImage12 ? order.prImage1 : order.prImage12}" class="thumb_g" alt="${order.prName}">--%>
                        <si:tenthImageTag type="product" imageName="${order.prImage1}" altVal="${order.prName}"/>
                    </span>
                    <div class="desc_order">
                        <strong class="tit_product">${order.prName}<span class="txt_more"> <c:if test="${order.orderSubPrTotCnt > 1}"> 외 ${order.orderSubPrTotCnt - 1}개 </c:if> </span></strong>
                            <dl class="list_price">
                                <dt class="txt_num">주문번호 :</dt><!-- mobile화면에서만 노출  -->
                                <dd class="txt_num"><a href="/kr/order/shipping/${order.omNum}" class="link_num">${order.omNum}</a></dd><!-- mobile화면에서만 노출  -->
                                <c:choose>
                                <c:when test="${order.omPayType.code == 7}">
                                    <dt>총 상품 가격 :</dt>
                                    <dd><fmt:formatNumber value="${order.exchangeItemsMoney}" type="number"/> USD</dd>
                                    <dt>할인금액 :</dt>
                                    <dd>${order.omCouponMoney + order.exchangePointMoney > 0 ? "-" : ""}<fmt:formatNumber value="${order.exchangeCouponMoney + order.exchangePointMoney}" type="number"/> USD</dd>
                                    <dt>총 배송비 :</dt>
                                    <dd><fmt:formatNumber value="${order.exchangeDeliveryMoney}" type="number"/> USD</dd>
                            </dl>
                            <dl class="list_price price_total">
                                <dt>총 결제금액 :</dt>
                                <dd><fmt:formatNumber value="${order.exchangeItemsMoney + order.exchangeDeliveryMoney - order.exchangeCouponMoney - order.exchangePointMoney}" type="number"/> USD</dd>
                            </dl>
                            </c:when>
                            <c:otherwise>
                                <dt>총 상품 가격 :</dt>
                                <dd><fmt:formatNumber value="${order.exchangeItemsMoney}" type="number"/> 원</dd>
                                <dt>할인금액 :</dt>
                                <dd>${order.omCouponMoney + order.exchangePointMoney > 0 ? "-" : ""}<fmt:formatNumber value="${order.omCouponMoney + order.exchangePointMoney}" type="number"/> 원</dd>
                                <dt>총 배송비 :</dt>
                                <dd><fmt:formatNumber value="${order.omDeliveryMoney}" type="number"/> 원</dd>
                                </dl>
                                <dl class="list_price price_total">
                                    <dt>총 결제금액 :</dt>
                                    <dd><fmt:formatNumber value="${order.exchangeItemsMoney + order.exchangeDeliveryMoney - order.exchangeCouponMoney - order.exchangePointMoney}" type="number"/> 원</dd>
                                </dl>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </li>
            </c:forEach>
        </ul>
        <tiles:insertTemplate template="/WEB-INF/templates/kr/sub/paging.jsp" flush="true"/>
        </c:if>
    </div>
</div><!--// mArticle -->