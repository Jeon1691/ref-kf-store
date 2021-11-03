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
<spring:eval expression="@environment['pgIniPay50.P_NEXT_URL_EN']" var="P_NEXT_URL"/>
<spring:eval expression="@environment['pgIniPay50.P_NOTI_URL_EN']" var="P_NOTI_URL"/>
<spring:eval expression="@environment['pgIniPay50.P_RETURN_URL_EN']" var="P_RETURN_URL"/>
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

<%--<div class="banner_page">--%>
	<%--<sec:authorize access="isAnonymous()">--%>
		<%--&lt;%&ndash;비회원&ndash;%&gt;--%>
		<%--<a href="https://store.kakaofriends.com/en/promotions/promotion/204" class="nomember">--%>
			<%--지금 1000P 즉시 지금! 포인트 2배 적립!--%>
		<%--</a>--%>
	<%--</sec:authorize>--%>
	<%--<sec:authorize access="isAuthenticated()">--%>
		<%--&lt;%&ndash;회원&ndash;%&gt;--%>
		<%--<a href="https://store.kakaofriends.com/en/promotions/promotion/204" class="member">--%>
			<%--지금 구매하고 포인트 2배 6% 적립받자!--%>
		<%--</a>--%>
	<%--</sec:authorize>--%>

	<%--<button class="banner_close">닫기</button>--%>
<%--</div>--%>

<div id="mSub">
	<div class="order_intro">
		<div class="inner_intro">
			<h2 id="kakaoBody" class="tit_intro"><sec:authorize access="isAnonymous()">Guest</sec:authorize> Order &amp; <br class="rw_hide">Shipping Information</h2>
			<span class="txt_intro"></span>
			<span class="img_emoticon ico_musi"></span>
		</div>
	</div>
</div> <!--// mSub -->

<div id="mArticle"></div>

<script src="https://plugin.inicis.com/pay61_secunissl_cross.js"></script>
<script src="https://www.paypalobjects.com/api/checkout.js" data-version-4></script>
<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>
<script>
window.LANG = 'en';
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
</script>
<script src="/resources/js/dist/sheet.js?${deployVersion}"></script>
