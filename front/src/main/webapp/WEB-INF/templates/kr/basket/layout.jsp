<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!doctype html>
<html lang="ko" class="${userAgent.os.name } ${' '} ${userAgent.browser.name } ${' '} ${userAgent.platform}">
<head>
	<tiles:insertTemplate template="/WEB-INF/templates/kr/sub/layoutHeader.jsp" flush="true"/>
    <c:if test="${!empty mSubInfo.ctImage1 and !empty mSubInfo.ctName}">
		<meta property="og:title" content="카카오프렌즈 - ${mSubInfo.ctName}">
		<meta property="og:description" content="공식 온라인스토어">
        <meta property="og:image" content="https://t1.daumcdn.net/friends/www${mSubInfo.ctImage1}">
        <meta property="og:image:width" content="500">
        <meta property="og:image:height" content="500">
    </c:if>
</head>
<body>
<div id="kakaoIndex">
	<a href="#kakaoBody">본문 바로가기</a>
	<a href="#kakaoGnb">메뉴 바로가기</a>
</div>
<div id="kakaoWrap">
	<tiles:insertAttribute name="header" flush="true"/>
	<hr class="hide">
	<div id="kakaoContent" class="cont_basket <c:if test="${kakaoWebView > 0}">kakaotalk</c:if> " role="main">
		<div id="cMain">
			<tiles:insertTemplate template="/WEB-INF/templates/kr/sub/feature.jsp" flush="true"/>
			<tiles:insertAttribute name="sub" flush="true"/>
			<tiles:insertAttribute name="article" flush="true"/>
		</div>
		<tiles:insertTemplate template="/WEB-INF/templates/kr/sub/etc.jsp" flush="true"/>
	</div>
	<hr class="hide">
	<tiles:insertTemplate template="/WEB-INF/templates/kr/sub/footer.jsp" flush="true"/>
</div>
<div class="dimmed_layer"></div>
</body>
</html>