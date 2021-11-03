<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:eval expression="@environment['deploy.version']" var="deployVersion"/>

<!doctype html>
<html lang="ko" class="${userAgent.os.name } ${' '} ${userAgent.browser.name } ${' '} ${userAgent.platform}">
<head>
	<tiles:insertTemplate template="/WEB-INF/templates/kr/sub/layoutHeader.jsp" flush="true"/>

	<!-- 페이스북 -->
	<meta property="og:title" content="카카오프렌즈 매장정보">
	<meta property="og:description" content="카카오프렌즈 매장정보">
	<meta property="og:image" content="https://t1.daumcdn.net/friends/www/resources/images/m640/bg_char.jpg">
	<meta property="og:image:width" content="500">
	<meta property="og:image:height" content="500">
	<!-- 트위터 -->
	<meta name="twitter:card" content="summary">
	<meta name="twitter:title" content="카카오프렌즈 매장정보">
	<meta property="twitter:image" content="https://t1.daumcdn.net/friends/www/resources/images/m640/bg_char.jpg">
</head>
<body>
<div id="kakaoIndex">
	<a href="#kakaoBody">본문 바로가기</a>
	<a href="#kakaoGnb">메뉴 바로가기</a>
</div>
<div id="kakaoWrap"></div>

<script>
window.LANG = 'ko'
</script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCqtf9E4ix8ZXalC-U67wXddhOWHpffKt4"></script>
<script src="/resources/js/dist/info_store.js?${deployVersion}"></script>
</body>
</html>