<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set value="${kakaoWebView}" var="kakaoWebView"/>

<!doctype html>
<html lang="${language}" class="${userAgent.os.name } ${' '} ${userAgent.browser.name } ${' '} ${userAgent.platform}">
<head>
    <c:if test="${kakaoWebView > 0}">
        <tiles:insertTemplate template="/WEB-INF/templates/kr/sub/layoutHeader.jsp" flush="true" />
    </c:if>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <title>KAKAO FRIENDS</title>
    <link rel="shortcut icon" href="//t1.kakaocdn.net/kakaofriends_global/static/img/favicon.ico" type='image/x-ico' />
    <link rel="stylesheet" type="text/css" href="/resources/css/new_common.css">
</head>
<div id="kakaoWrap" class="wrap_error">
    <div id="kakaoHead" <c:if test="${kakaoWebView > 0}">style="padding-top: 0;" </c:if>>
        <c:if test="${kakaoWebView > 0}">
        <tiles:insertTemplate template="/WEB-INF/templates/kr/sub/kakaoGnbError.jsp" flush="true" />
        </c:if>
        <h1 class="screen_out">KAKAO FRIENDS</h1>
        <span class="ico_bg ico_type2"></span>
        <h2 class="tit_error"><spring:message code="error.title" /></h2>
    </div>
    <hr class="hide">
    <div id="kakaoContent">
        <p class="desc_error desc_type2">
            <em class="emph_500error">500 - Internal Server Error</em>
            <spring:message code="internalServerError.error.message.first" />
        </p>
        <div class="wrap_btn">
            <a href="javascript:history.back()" class="link_error link_prev"><spring:message code="button.back" /></a>
            <a href="/kr/index" class="link_error link_home"><spring:message code="button.home" /></a>
        </div>
    </div>
</div>
</html>