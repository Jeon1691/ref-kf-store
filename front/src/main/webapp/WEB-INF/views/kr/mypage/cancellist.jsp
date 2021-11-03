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
                <a href="/kr/mypage/orderlist" class="link_tab">주문내역</a>
            </li>
            <li>
                <a href="/kr/mypage/wishlist" class="link_tab">찜</a>
            </li>
            <li class="on">
                <a href="/kr/mypage/cancellist" class="link_tab">취소/교환 <span class="screen_out">선택됨</span></a>
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
        <h3 class="screen_out">취소 / 교환</h3>
        <c:if test="${empty(cancelList)}">
        <p class="desc_nodata">취소 및 교환 내역이 존재하지 않습니다.</p>
        </c:if>
        <c:if test = "${!empty cancelList}">
        <p class="desc_total">총 <em class="emph_total">${totalCount}개</em> 의 상품이 조회되었습니다.</p>
        <ul class="list_order">
            <c:forEach items="${cancelList}" var="cancel" varStatus="status">
            <li>
                <span class="txt_order"><em class="screen_out">주문날짜 :</em><fmt:formatDate value="${cancel.orderInfo.omInDate}" pattern="yyyy.MM.dd HH:mm:ss" /></span>
                <span class="txt_order txt_num"><em class="tit_num">주문번호 :</em><a href="/kr/order/shipping/${cancel.orderInfo.omNum}" class="link_num">${cancel.orderInfo.omNum}</a></span><!-- PC화면에서만 노출  -->
                <span class="txt_order txt_desc"><em class="screen_out">취소/교환내역 :</em>
                <c:choose>
                    <c:when test="${cancel.cancelSubmitCnt > 0}"><span class="txt_progress"> 취소중 : ${cancel.cancelSubmitCnt}개 </span> </c:when>
                    <c:when test="${cancel.returnSubmitCnt > 0}"><span class="txt_progress"> 반품중 : ${cancel.returnSubmitCnt}개 </span> </c:when>
                    <c:when test="${cancel.exchangeSubmitCnt > 0}"><span class="txt_progress"> 교환중 : ${cancel.exchangeSubmitCnt}개 </span> </c:when>
                    <c:when test="${cancel.cancelSubmitCnt eq 0 and cancel.cancelCompleteCnt > 0}"> 취소 완료 </c:when>
                    <c:when test="${cancel.returnSubmitCnt eq 0 and cancel.returnCompleteCnt > 0}"> 반품 완료 </c:when>
                    <c:when test="${cancel.exchangeSubmitCnt eq 0 and cancel.exchangeCompleteCnt > 0}"> 교환 완료 </c:when>
                </c:choose>
                </span><!-- 취소중인경우 txt_cancel 클래스 추가  -->
                <span class="wrap_thumb">
                    <%--<img src="${cdn}/${empty cancel.orderInfo.prImage12 ? cancel.orderInfo.prImage1 : cancel.orderInfo.prImage12}" class="thumb_g" alt="${cancel.orderInfo.prName}">--%>
                    <si:tenthImageTag type="product" imageName="${cancel.orderInfo.prImage1}" altVal="${cancel.orderInfo.prName}"/>
                </span>
                <div class="desc_order">
                    <strong class="tit_product">${cancel.orderInfo.prName}<span class="txt_more"> <c:if test="${cancel.orderInfo.orderSubPrTotCnt > 1}"> 외 ${cancel.orderInfo.orderSubPrTotCnt - 1}개 </c:if> </span></strong>
                    <dl class="list_price">
                        <dt class="txt_num">주문번호 :</dt><!-- mobile화면에서만 노출  -->
                        <dd class="txt_num"><a href="/kr/order/shipping/${cancel.orderInfo.omNum}" class="link_num">${cancel.orderInfo.omNum}</a></dd><!-- mobile화면에서만 노출  -->
                        <c:choose>
                        <c:when test="${cancel.orderInfo.omPayType.code == 7}">
                        <dt>총 상품 가격 :</dt>
                        <dd><fmt:formatNumber value="${cancel.orderInfo.exchangeItemsMoney}" type="number"/> USD</dd>
                        <c:if test="${cancel.orderInfo.omCouponMoney > 0}">
                            <dt>할인금액 :</dt>
                            <dd>-<fmt:formatNumber value="${cancel.orderInfo.exchangeCouponMoney}" type="number"/> USD</dd>
                        </c:if>
                        <dt>총 배송비 :</dt>
                        <dd><fmt:formatNumber value="${cancel.orderInfo.exchangeDeliveryMoney}" type="number"/> USD</dd>
                        </dl>
                        <dl class="list_price price_total">
                            <dt>총 결제금액 :</dt>
                            <dd><fmt:formatNumber value="${cancel.orderInfo.exchangeItemsMoney + cancel.orderInfo.exchangeDeliveryMoney - cancel.orderInfo.exchangeCouponMoney}" type="number"/> USD</dd>
                        </dl>
                        </c:when>
                        <c:otherwise>
                        <dt>총 상품 가격 :</dt>
                            <dd><fmt:formatNumber value="${cancel.orderInfo.totalMoney + cancel.orderInfo.omCouponMoney - cancel.orderInfo.omDeliveryMoney}" type="number"/> 원</dd>
                        <c:if test="${cancel.orderInfo.omCouponMoney > 0}">
                            <dt>할인금액 :</dt>
                            <dd>-<fmt:formatNumber value="${cancel.orderInfo.omCouponMoney}" type="number"/> 원</dd>
                        </c:if>
                        <dt>총 배송비 :</dt>
                            <dd><fmt:formatNumber value="${cancel.orderInfo.omDeliveryMoney}" type="number"/> 원</dd>
                        </dl>
                        <dl class="list_price price_total">
                            <dt>총 결제금액 :</dt>
                                <dd><strong><fmt:formatNumber value="${cancel.orderInfo.totalMoney}" type="number"/> 원</strong></dd>
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