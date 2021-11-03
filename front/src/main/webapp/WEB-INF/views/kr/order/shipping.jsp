<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="si" uri="http://www.kakaofriends.com/si" %>
<spring:eval expression="@environment['kakaofriends.cdn.product']" var="cdn"/>

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
<spring:eval expression="@environment['deploy.version']" var="deployVersion"/>

<div id="mArticle"></div>

<script type="text/javascript" src="https://spi.maps.daum.net/imap/map_js_init/postcode.v2.js"></script>
<script type="text/javascript" src="https://plugin.inicis.com/pay61_secunissl_cross.js"></script>
<script>
window.LANG = 'kr';
window.__INITIAL_STATE__ = ${orderCompleteVo};
window.PG_INI_PAY_50 = {
    mid: '${mid}',
    P_NEXT_URL: '${P_NEXT_URL}',
    P_NOTI_URL: '${P_NOTI_URL}',
    P_RETURN_URL: '${P_RETURN_URL}',
    P_NEXT_URL_ADD: '${P_NEXT_URL_ADD}',
    P_NOTI_URL_ADD: '${P_NOTI_URL_ADD}',
    P_RETURN_URL_ADD: '${P_RETURN_URL_ADD}',
};
window.CSRF_TOKEN = '${_csrf.token}';
window.CSRF_HEADER_NAME = '${_csrf.headerName}';
</script>
<script src="/resources/js/dist/shipping.js?${deployVersion}"></script>