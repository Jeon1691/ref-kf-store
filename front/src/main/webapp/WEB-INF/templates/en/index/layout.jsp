<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!doctype html>
<html lang="en" class="${userAgent.os.name}  ${' '}  ${userAgent.browser.name}  ${' '}  ${userAgent.platform}">
<head>
	<tiles:insertTemplate template="/WEB-INF/templates/en/sub/layoutHeader.jsp" flush="true"/>
    <meta name="robots" content="index,follow">
    <meta property="og:type" content="website">
    <meta property="og:url" content="https://store.kakaofriends.com">
    <meta property="og:title" content="KAKAO FRIENDS">
    <meta property="og:description" content="ONLINE SHOPPING">
	<meta property="og:image" content="https://t1.daumcdn.net/friends/www/talk/kakaofriends_talk_2018.png">
    <meta name="google-site-verification" content="ydE6xYGjHv_-G-3nx2wX_iu7LW28mFfkyChFkJ61pLM" />
	<!--[if lte IE 8]>
	<script>
		location.href = "/common/ie8";
	</script>
	<![endif]-->
	<script type="application/ld+json">
		{
			"@context": "http://schema.org",
			"@type": "Person",
			"name": "KAKAO FRIENDS ONLINE STORE",
			"url": "http://store.kakaofriends.com",
			"sameAs": [
				"https://www.facebook.com/kakaofriends",
				"https://www.instagram.com/kakaofriends_official/?hl=ko",
				"https://www.youtube.com/channel/UCFnuC4E0kzpJF6vv1OJ7B3Q/featured"
			]
		}
	</script><!-- 네이버 통검 연관채널 노출을 위한 대응 -->
</head>
<body id="indexBody" class="en ${empty mainTopMap ? '' : 'global_bnr'}">

<div id="kakaoIndex">
	<a href="#kakaoBody">Content Shortcuts</a>
	<a href="#kakaoGnb">Menu Shortcuts</a>
</div>
<div id="kakaoWrap">
        <!-- 메인 TOP 배너 -->
        <c:forEach items="${mainTopMap}" var="mainTopMap" varStatus="status">
        <div class="bnr_notice bnr_global">
            <div class="inner_bnr">
                <a href="${mainTopMap.value[0].bnLink}" onclick="mainAreaCounting(this.href, 'mainTopWide'+'${status.index}')" class="link_bnr">
                    <img src="${kakaoFriendsCdn.banner}/${mainTopMap.value[0].bnImage}" class="rw_show" alt="${mainTopMap.value[0].bnAlt}">
                    <img src="${kakaoFriendsCdn.banner}/${mainTopMap.value[1].bnImage}" class="rw_hide" alt="${mainTopMap.value[1].bnAlt}">
                    <strong>${mainTopMap.value[0].bnTitle}</strong>
                    <span>${mainTopMap.value[0].bnSubTitle}</span>
                </a>
                <button type="button" class="btn_close"><span class="ico_friends ico_close">배너 닫기</span></button>
            </div>
        </div>
        </c:forEach>
	<tiles:insertAttribute name="header" flush="true"/>
	<hr class="hide">
	<div id="kakaoContent" class="cont_main" role="main">
        <tiles:insertAttribute name="sub" flush="true"/>
		<div id="cMain">
            <tiles:insertTemplate template="/WEB-INF/templates/en/sub/feature.jsp" flush="true"/>
			<tiles:insertAttribute name="article" flush="true"/>
		</div>
		<tiles:insertTemplate template="/WEB-INF/templates/en/sub/etc.jsp" flush="true"/>
	</div>
	<hr class="hide">
	<tiles:insertTemplate template="/WEB-INF/templates/en/sub/footer.jsp" flush="true"/>
</div>
<div class="dimmed_layer"></div>
<script>var noticeText = '${notice.bdaName}';</script>
<script>var cartSuccessText = 'Added to cart';</script>
<div class="toast"></div>
<div class="goto_top">TOP</div>

<script>
  var promotionText = '';
  <%--<sec:authorize access="isAnonymous()">--%>
  <%--promotionText = 'test';--%>
  <%--promotionText = '<a href="https://store.kakaofriends.com/en/promotions/promotion/204"><img src="http://t1.kakaocdn.net/friends/new_store/banner_nomember.png" alt="지금 멤버십 가입하면 1000P 즉시 지급!"></a>';--%>
  <%--</sec:authorize>--%>
  <%--<sec:authorize access="isAuthenticated()">--%>
  <%--promotionText = 'aaa';--%>
  <%--promotionText = '<a href="https://store.kakaofriends.com/en/promotions/promotion/204"><img src="http://t1.kakaocdn.net/friends/new_store/banner_member.png" alt="지금 프렌즈 상품 구매하고 포인트 2배 6% 적립받자!"></a>';--%>
  <%--</sec:authorize>--%>
</script>
</body>

<script type="text/javascript">
	$(document).ready(function() {
        var bannerRandom = Math.floor(Math.random() * $('.bnr_random').length);
        $('.bnr_random').removeClass('bnr_on');
        $('.bnr_random').eq(bannerRandom).addClass('bnr_on');
	});
	function mainAreaCounting(url, area) {
	    $.ajax({
            headers: {'X-CSRF-TOKEN': '${_csrf.token}'},
            url: "/area/counting",
            type: "POST",
            dataType: "json",
            data: {area:area, localeVal:'kr'},
            async:false,
            success: function () {
                $(location).attr('href', url);
            }
		});
	}
</script>
</html>