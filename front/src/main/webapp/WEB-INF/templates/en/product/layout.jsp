<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!doctype html>
<html lang="${language}" class="${userAgent.os.name } ${' '} ${userAgent.browser.name } ${' '} ${userAgent.platform}">
<head>
	<tiles:insertTemplate template="/WEB-INF/templates/en/sub/layoutHeader.jsp" flush="true"/>
	<c:if test="${!empty mSubInfo.ctImage1 and !empty mSubInfo.ctEname}">
		<meta property="og:title" content="KAKAO FRIENDS - ${mSubInfo.ctEname}">
		<meta property="og:description" content="ONLINE SHOPPING">
		<meta property="og:image" content="${kakaoFriendsCdn.category}/${mSubInfo.ctImage1}">
		<meta property="og:image:width" content="500">
		<meta property="og:image:height" content="500">
	</c:if>
</head>
<body class="en">
<div id="kakaoIndex">
	<a href="#kakaoBody">Content Shortcuts</a>
	<a href="#kakaoGnb">Menu Shortcuts</a>
</div>
<div id="kakaoWrap">
	<tiles:insertAttribute name="header" flush="true"/>
	<hr class="hide">
	<div id="kakaoContent" class="cont_list" role="main">
		<div id="cMain">
			<tiles:insertTemplate template="/WEB-INF/templates/en/sub/feature.jsp" flush="true"/>
			<tiles:insertAttribute name="sub" flush="true"/>
			<tiles:insertAttribute name="article" flush="true"/>
		</div>
		<tiles:insertTemplate template="/WEB-INF/templates/en/sub/etc.jsp" flush="true"/>
	</div>
	<hr class="hide">
	<tiles:insertTemplate template="/WEB-INF/templates/en/sub/footer.jsp" flush="true"/>
</div>
<div class="dimmed_layer"></div>
</body>
</html>