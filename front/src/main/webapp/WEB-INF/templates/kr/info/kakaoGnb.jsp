<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set value="${requestScope['javax.servlet.forward.servlet_path']}" var="requestPath"/>
<c:set value="${requestScope['javax.servlet.forward.query_string']}" var="queryString"/>
<div class="inner_head">
    <h1 class="tit_head">
        <a href="/kr/index" id="kakaoServiceLogo" class="img_gnb link_friends">KAKAO FRIENDS</a>
    </h1>
    <!-- ko -->
    <div class="wrap_link lang_on" lang="ko">
        <a href="/kr/info/charInfo" class="link_info link_on">캐릭터소개</a><!-- 선택 시 link_on 클래스 추가 -->
        <a href="/kr/info/storeInfo" class="link_info">매장안내</a>
    </div>
    <!-- ko -->

    <!-- en, ja, zh-Hans, zh-Hant -->
    <div class="wrap_link" lang="en">
        <a href="/kr/info/charInfo" class="link_info link_on">Character</a>
        <a href="/kr/info/storeInfo" class="link_info">Store</a>
    </div>
    <!-- // en, ja, zh-Hans, zh-Hant -->
</div>