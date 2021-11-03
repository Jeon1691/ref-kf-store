<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="si" uri="http://www.kakaofriends.com/si" %>

<c:set value="${kakaoWebView}" var="kakaoWebView"/>

<spring:eval expression="@environment['pgIniPay50.mid']" var="mid"/>
<spring:eval expression="@environment['pgIniPay50.P_NEXT_URL']" var="P_NEXT_URL"/>
<spring:eval expression="@environment['pgIniPay50.P_NOTI_URL']" var="P_NOTI_URL"/>
<spring:eval expression="@environment['pgIniPay50.P_RETURN_URL']" var="P_RETURN_URL"/>
<spring:eval expression="@environment['pgIniPay50.P_NEXT_URL_ADD']" var="P_NEXT_URL_ADD"/>
<spring:eval expression="@environment['pgIniPay50.P_NOTI_URL_ADD']" var="P_NOTI_URL_ADD"/>
<spring:eval expression="@environment['pgIniPay50.P_RETURN_URL_ADD']" var="P_RETURN_URL_ADD"/>
<spring:eval expression="@environment['pgKakaopay.merchantId']" var="pgKakaopayMerchantId"/>
<spring:eval expression="@environment['pgKakaopay.merchantUrl']" var="pgKakaopayMerchantUrl"/>
<spring:eval expression="@environment['pgKakaopay.webPath']" var="pgKakaopayWebPath"/>
<spring:eval expression="@environment['pgKakaopay.msgName']" var="pgKakaopayMsgName"/>
<spring:eval expression="@environment['pgKakaopay.merchantEncKey']" var="pgKakaopayMerchantEncKey"/>
<spring:eval expression="@environment['pgKakaopay.merchantHashKey']" var="pgKakaopayMerchantHashKey"/>
<spring:eval expression="@environment['mail.smtp.sender.name']" var="kakaoFriendsOnlineStore"/>
<spring:eval expression="@environment['paypal.button.mode']" var="paypalButton"/>
<spring:eval expression="@environment['deploy.version']" var="deployVersion"/>

<% response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
    response.setHeader("Pragma","no-cache"); //HTTP 1.0
    response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>

<div class="banner_page" style="display: none;">
    <sec:authorize access="isAnonymous()">
        <%--비회원--%>
        <a href="/kr/promotions/promotion/204" class="nomember">
            지금 1000P 즉시 지금! 포인트 2배 적립!
        </a>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <%--회원--%>
        <a href="/kr/promotions/promotion/204" class="member">
            지금 구매하고 포인트 2배 6% 적립받자!
        </a>
    </sec:authorize>

    <button class="banner_close">닫기</button>
</div>


<div id="mSub">
    <div class="order_intro">
        <div class="inner_intro">
            <h2 id="kakaoBody" class="tit_intro"><sec:authorize access="isAnonymous()">비회원</sec:authorize>주문하기</h2>
            <span class="txt_intro">Order &amp; Shipping Information</span>
            <span class="img_emoticon ico_musi"></span>
        </div>
    </div>
</div> <!--// mSub -->

<div id="mArticle">
    <%--
    <form action="">
        <div class="order_cart">
            <h3 class="tit_order on"><a href="javascript:;">01 주문상품</a></h3>
            <ul class="list_cart">
                <li>
                    <span class="wrap_thumb">
                        <img alt="2018 리미티드 스노우볼" class="thumb_g" src="https://img1.daumcdn.net/thumb/R300x300/?fname=https%3A%2F%2Ft1.daumcdn.net%2Ffriends%2Fprod%2Fproduct%2FFRPBFRLSG0001_AW_00.jpg">
                    </span>
                    <div class="desc_cart">
                        <strong class="tit_product">2018 리미티드 스노우볼</strong>
                        <dl class="list_append">
                            <dt>금액</dt>
                            <dd class="usd_check usd_show">49,000 원</dd>
                            <dd class="usd_check">45.65 USD</dd>
                            <dt>옵션</dt>
                            <dd>-</dd>
                        </dl>
                        <dl class="list_append list_amount">
                            <dt>수량</dt>
                            <dd>1 개</dd>
                        </dl>
                    </div>
                    <div class="">
                        <div class="box_quantity">
                            <em class="screen_out">수량 :</em>
                            <input type="text" name="bsEa" class="inp_quantity" value="1">
                            <button type="button" class="btn_g btn_minus">
                                <span class="ico_newfriends_v1 ico_minus">빼기</span>
                            </button>
                            <button type="button" class="btn_g btn_plus">
                                <span class="ico_newfriends_v1 ico_plus">더하기</span>
                            </button>
                        </div>
                        <button type="button" disabled="disabled" class="btn_change">
                            <span class="txt_g">변경</span>
                        </button>
                    </div>
                </li>
                <li>
                    <span class="wrap_thumb">
                        <img alt="2018 리미티드 스노우볼" class="thumb_g" src="https://img1.daumcdn.net/thumb/R300x300/?fname=https%3A%2F%2Ft1.daumcdn.net%2Ffriends%2Fprod%2Fproduct%2FFRPBFRLSG0001_AW_00.jpg">
                    </span>
                    <div class="desc_cart">
                        <strong class="tit_product">2018 리미티드 스노우볼</strong>
                        <dl class="list_append">
                            <dt>금액</dt>
                            <dd class="usd_check usd_show">49,000 원</dd>
                            <dd class="usd_check">45.65 USD</dd>
                            <dt>옵션</dt>
                            <dd>-</dd>
                        </dl>
                        <dl class="list_append list_amount">
                            <dt>수량</dt>
                            <dd>1 개</dd>
                        </dl>
                    </div>
                    <div class="">
                        <div class="box_quantity">
                            <em class="screen_out">수량 :</em>
                            <input type="text" name="bsEa" class="inp_quantity" value="1">
                            <button type="button" class="btn_g btn_minus">
                                <span class="ico_newfriends_v1 ico_minus">빼기</span>
                            </button>
                            <button type="button" class="btn_g btn_plus">
                                <span class="ico_newfriends_v1 ico_plus">더하기</span>
                            </button>
                        </div>
                        <button type="button" disabled="disabled" class="btn_change">
                            <span class="txt_g">변경</span>
                        </button>
                    </div>
                </li>
            </ul>
            <ul class="list_info_price">
                <li>
                    <strong>상품가</strong>
                    <p><span class="txt_number">48,000</span>원</p>
                </li>
                <li>
                    <strong>배송비</strong>
                    <p><span class="txt_free">무료</span></p>
                </li>
                <li class="total_price">
                    <strong>총합</strong>
                    <p><span class="txt_number">48,000</span>원</p>
                </li>
            </ul>
        </div>

        <div class="order_detail">
            <h3 class="tit_order on"><a href="javascript:;">02 배송지 입력</a></h3>
            <h4>받으시는 분</h4>
            <div class="btn_copy_info area_checkbox">
                <label for="chkCopyInfo" class="txt_label">주문고객과 동일</label>
                <div class="chk_common">
                    <input type="checkbox" id="chkCopyInfo" />
                    <label for="chkCopyInfo"></label>
                </div>
            </div>

            <dl class="info_shipping">
                <dt>나라</dt>
                <dd>
                    <p class="select_box">
                        <label for="optCountry">한국</label>
                        <select name="opt_country" id="optCountry">
                            <option value="">한국</option>
                            <option value="">일본</option>
                            <option value="">중국</option>
                        </select>
                    </p>
                </dd>
                <dt>이름</dt>
                <dd>
                    <input type="text" title="이름" placeholder="이름">
                </dd>
                <dt>전화번호</dt>
                <dd>
                    <input type="text" title="전화번호" placeholder="전화번호">
                </dd>
                <dt>주소</dt>
                <dd>
                    <input type="text" title="주소" placeholder="주소">
                    <button type="button" class="ico_search">찾기</button>
                </dd>
                <dt>상세주소</dt>
                <dd>
                    <input type="text" title="상세주소" placeholder="상세주소">
                </dd>
                <dt>내 정보 및 최근 배송지로 저장</dt>
                <dd class="area_checkbox">
                    <div class="chk_common">
                        <input type="checkbox" id="chkSaveInfo" />
                        <label for="chkSaveInfo"></label>
                    </div>
                    <label for="chkSaveInfo" class="txt_label">내 정보 및 최근 배송지로 저장</label>
                </dd>
                <dt>배송 메모</dt>
                <dd>
                    <textarea name="osDeliMemo" id="osDeliMemo" cols="30" rows="10"></textarea>
                    <p class="txt_memo">50자 이내로 입력해주세요 (50/50자)</p>
                </dd>
            </dl>
            <button type="button" class="btn_order on">수정하기</button>
        </div>

        <div class="order_pay">
            <h3 class="tit_order on"><a href="javascript:;">03 결제수단 선택</a></h3>
            <button class="btn_coupon_info">쿠폰/포인트 안내</button>
            <ul class="list_info_price">
                <li>
                    <strong>상품가</strong>
                    <p class="txt_price"><span class="txt_number">48,000</span>원</p>
                </li>
                <li>
                    <strong>배송비</strong>
                    <p><span class="txt_free">무료</span></p>
                </li>
                <li class="area_pay_group">
                    <strong>쿠폰 <span>(2장)</span></strong>
                    <p class="select_box">
                        <label for="optCoupon"><span>10% 할인</span> - 2,134,800</label>
                        <select name="opt_coupon" id="optCoupon">
                            <option value="">10%할인</option>
                            <option value="">20%할인</option>
                            <option value="">30%할인</option>
                        </select>
                    </p>
                </li>
                <li class="area_pay_group">
                    <strong>포인트 <span>(313,000P)</span></strong>
                    <p>
                        <input type="text" value="- 3,000">
                    </p>
                </li>
                <li class="total_price">
                    <strong>최종 결제금액</strong>
                    <p><span class="txt_number">1,150,200</span>원</p>
                </li>
            </ul>
            <div class="area_choice_pay">
                <strong>결제수단 선택</strong>
                <div class="group_order">
                    <label for="payKakaopay">
                        <span class="ico_kakaopay"></span>
                        <span class="txt_pay">카카오페이</span>
                    </label>
                    <label for="payCard">
                        <span class="ico_card"></span>
                        <span class="txt_pay">신용카드</span>
                    </label>
                    <input type="radio" id="payKakaopay" class="screen_out">
                    <input type="radio" id="payCard" class="screen_out">
                </div>
                <ul class="list_agree">
                    <li class="area_checkbox">
                        <div class="chk_common">
                            <input type="checkbox" id="chkAgree1" />
                            <label for="chkAgree1"></label>
                        </div>
                        <label for="chkAgree1" class="txt_label"><a href="javascript:;">상품 주문 및 배송정보 수집</a>에 동의합니다 <span>[필수]</span></label>
                    </li>
                    <li class="area_checkbox">
                        <div class="chk_common">
                            <input type="checkbox" id="chkAgree2" />
                            <label for="chkAgree2"></label>
                        </div>
                        <label for="chkAgree2" class="txt_label">주문 상품의 명시내용과 사용조건을 확인하였으며, 취소환불 규정에 동의합니다 <span>[필수]</span></label>
                    </li>
                </ul>
            </div>
            <button type="button" class="btn_order" disabled>결제하기</button>
        </div>
    </form>
    --%>
</div>

<%--<div>isPayOnlyItemContains: ${isPayOnlyItemContains}</div>--%>
<%--<div>isNormalItemContains: ${isNormalItemContains}</div>--%>
<%--<div>canPurchasePayOnly: ${canPurchasePayOnly}</div>--%>
<%--<div>payOnlyPrcodeSet: ${payOnlyPrcodeSet}</div>--%>

<script src="https://plugin.inicis.com/pay61_secunissl_cross.js"></script>
<script src="https://www.paypalobjects.com/api/checkout.js" data-version-4></script>
<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>
<script>
window.LANG = 'kr';
window.canPurchasePayOnly = ${canPurchasePayOnly};
window.isPayOnlyItemContains = ${isPayOnlyItemContains};
window.isNormalItemContains = ${isNormalItemContains};
window.isPayOnlyDispcode = ${isPayOnlyDispcode};

window.__INITIAL_STATE__ = ${orderSheetRequestVo};
window.PG_INI_PAY_50 = {
    mid: '${mid}',
    P_NEXT_URL: '${P_NEXT_URL}',
    P_NOTI_URL: '${P_NOTI_URL}',
    P_RETURN_URL: '${P_RETURN_URL}',
    P_NEXT_URL_ADD: '${P_NEXT_URL_ADD}',
    P_NOTI_URL_ADD: '${P_NOTI_URL_ADD}',
    P_RETURN_URL_ADD: '${P_RETURN_URL_ADD}',
}
window.CSRF_TOKEN = '${_csrf.token}'
window.CSRF_HEADER_NAME = '${_csrf.headerName}'
window.kakaotalkAgent = ${kakaoWebView}
</script>

<script src="/resources/js/dist/sheet.js?${deployVersion}"></script>
