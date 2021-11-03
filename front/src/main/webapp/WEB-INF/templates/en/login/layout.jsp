<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!doctype html>
<html lang="${language}" class="${userAgent.os.name } ${' '} ${userAgent.browser.name } ${' '} ${userAgent.platform}">
<head>
	<tiles:insertTemplate template="/WEB-INF/templates/en/sub/layoutHeader.jsp" flush="true"/>
    <meta property="og:title" content="KAKAO FRIENDS - Friendly Kakao Friends’ characters that everybody loves">
    <meta property="og:image" content="https://t1.daumcdn.net/friends/www/talk/kakaofriends_talk_2018.png">
    <meta property="og:image:width" content="500">
    <meta property="og:image:height" content="500">
    <meta property="og:description" content="&nbsp;">
</head>
<body class="en">
<div id="kakaoIndex">
	<a href="#kakaoBody">Content Shortcuts</a>
	<a href="#kakaoGnb">Menu Shortcuts</a>
</div>
<div id="kakaoWrap">
	<tiles:insertAttribute name="header" flush="true"/>
	<hr class="hide">
	<div id="kakaoContent" class="cont_signup" role="main">
		<div id="cMain">
			<tiles:insertTemplate template="/WEB-INF/templates/en/sub/feature.jsp" flush="true"/>
			<tiles:insertAttribute name="sub" flush="true"/>
			<tiles:insertAttribute name="article" flush="true"/>
		</div>
		<tiles:insertTemplate template="/WEB-INF/templates/en/sub/etc.jsp" flush="true"/>
	</div>
	<hr class="hide">
	<tiles:insertTemplate template="/WEB-INF/templates/en/login/footer.jsp" flush="true"/>
</div>
<div class="dimmed_layer"></div>
<div class="friends_layer alert_layer">
	<div class="inner_layer">
		<div class="layer_head">
			<strong class="screen_out">안내</strong>
		</div>
		<div class="layer_body">
			<div class="box_desc">
				<p class="desc_layer"></p>
			</div>
			<button type="button" class="btn_verify btn_confirm">확인</button>
		</div>
	</div>
</div>
<script>
    (function() {
        $(window).on('load', function () {
            var errMsg = '${param.errMsg}';
            var descLayer = $('.desc_layer');
            var modalLayers = $('.dimmed_layer, .friends_layer');
            var btnConfirm = $('.btn_confirm');

            if (errMsg) {
                layerCenter();

                descLayer.text(errMsg);

                btnConfirm.on('click', function () {
                    modalLayers.hide();
                });
            }
        });
    })();
</script>
</body>
</html>