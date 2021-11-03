<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!doctype html>
<html lang="${language}" class="${userAgent.os.name } ${' '} ${userAgent.browser.name } ${' '} ${userAgent.platform}">
<head>
	<tiles:insertTemplate template="/WEB-INF/templates/en/sub/layoutHeader.jsp" flush="true"/>

    <c:choose>
        <c:when test="${!empty promotionExpansion.promotion.prmOgTitle and !empty promotionExpansion.promotion.prmOgImage}">
            <meta property="og:title" content="KAKAO FRIENDS - ${promotionExpansion.promotion.prmOgTitle}">
            <meta property="og:description" content="ONLINE SHOPPING">
            <meta property="og:image" content="${kakaoFriendsCdn.promotionShare}/${promotionExpansion.promotion.prmOgImage}">
            <meta property="og:image:width" content="500">
            <meta property="og:image:height" content="500">
        </c:when>
        <c:otherwise>
            <meta property="og:title" content="KAKAO FRIENDS">
            <meta property="og:description" content="ONLINE SHOPPING">
            <meta property="og:image" content="https://t1.daumcdn.net/friends/www/talk/kakaofriends_talk_2018.png">
            <meta property="og:image:width" content="500">
            <meta property="og:image:height" content="500">
        </c:otherwise>
    </c:choose>
</head>
<body class="en">
<div id="kakaoIndex">
	<a href="#kakaoBody">본문 바로가기</a>
	<a href="#kakaoGnb">메뉴 바로가기</a>
</div>
<div id="kakaoWrap">
	<tiles:insertAttribute name="header" flush="true"/>
	<hr class="hide">
	<div id="kakaoContent" class="cont_promotion" role="main">
		<div id="cMain">
			<tiles:insertTemplate template="/WEB-INF/templates/en/sub/feature.jsp" flush="true"/>
			<tiles:insertAttribute name="article" flush="true"/>
		</div>
	</div>
	<hr class="hide">
	<tiles:insertTemplate template="/WEB-INF/templates/en/sub/footer.jsp" flush="true"/>
</div>
<div class="dimmed_layer"></div>
</body>
</html>