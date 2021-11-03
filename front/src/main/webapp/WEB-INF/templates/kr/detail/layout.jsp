<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set value="${kakaoWebView}" var="kakaoWebView"/>

<c:set var="req" value="${pageContext.request}" />
<c:set var="baseURL" value="${fn:replace(req.requestURL, req.requestURI, '')}" />
<c:set var="params" value="${requestScope['javax.servlet.forward.query_string']}"/>
<c:set var="requestPath" value="${requestScope['javax.servlet.forward.request_uri']}"/>
<c:set var="pageUrl" value="${ baseURL }${ requestPath }${ not empty params?'?'+=params:'' }"/>

<!doctype html>
<html lang="ko" class="${userAgent.os.name } ${' '} ${userAgent.browser.name } ${' '} ${userAgent.platform}">
<head>
    <title>${displayGoodsDetail.displayGoods.name} :: 카카오 프렌즈샵</title>
    <tiles:insertTemplate template="/WEB-INF/templates/kr/sub/layoutHeader.jsp" flush="true"/>
	<!-- 페이스북 -->
	<meta property="og:title" content="${displayGoodsDetail.displayGoods.name}">
	<meta property="og:description" content="${displayGoodsDetail.displayGoods.name} :: 카카오 프렌즈샵">
	<c:if test="${!empty(displayGoodsDetail.displayGoods.image1)}">
		<meta property="og:image" content="${kakaoFriendsCdn.product}/${displayGoodsDetail.displayGoods.image1}">
	</c:if>
	<meta property="og:image:width" content="500">
	<meta property="og:image:height" content="500">
    <!-- 트위터 -->
	<meta name="twitter:card" content="summary">
	<meta name="twitter:title" content="${displayGoodsDetail.displayGoods.name} :: 카카오 프렌즈샵">
	<c:if test="${!empty(displayGoodsDetail.displayGoods.image1)}">
		<meta property="twitter:image" content="${kakaoFriendsCdn.product}/${displayGoodsDetail.displayGoods.image1}">
	</c:if>
</head>
<body>
<script type="application/ld+json">
    {
    "@context":"https://schema.org",
    "@type":"Product",
    "productID":"${productRequest.product.prCode}",
    "name":"${displayGoodsDetail.displayGoods.name}",
    "description":"${displayGoodsDetail.displayGoods.name}",
    "url":"${pageUrl}",
    "image": "${kakaoFriendsCdn.product}/${displayGoodsDetail.displayGoods.image1}",
    "brand":"카카오프렌즈",
    "offers":[
    {
    "@type":"Offer",
    "price":"${displayGoodsDetail.displayGoods.salePrice}",
    "priceCurrency":"KRW",
    "itemCondition":"https://schema.org/NewCondition",
    "availability":"https://schema.org/InStock"
    }
    ]
    }
    </script>

<script>
  fbq('track', 'ViewContent', {
    value: ${displayGoodsDetail.displayGoods.salePrice},
    currency: 'KRW',
    content_ids: ['${productRequest.product.prCode}'],
    content_name: '${displayGoodsDetail.displayGoods.name}',
    content_type: 'product',
    content_category: '${displayGoodsDetail.category.ctName}',
  });
  ga('send', {
    hitType: 'event',
    eventCategory: 'ecommerce',
    eventAction: 'ViewContent',
    eventLabel: 'productCode',
    eventValue : '${productRequest.product.prCode}',
  });

</script>
<div id="kakaoIndex">
	<a href="#kakaoBody">본문 바로가기</a>
	<a href="#kakaoGnb">메뉴 바로가기</a>
</div>
<div id="kakaoWrap">
	<tiles:insertAttribute name="header" flush="true"/>
	<hr class="hide">
	<div id="kakaoContent" class="cont_item <c:if test="${kakaoWebView > 0}">kakaotalk</c:if> " role="main">
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
<c:if test="${productDetail.isCustomProduct}">
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
<div class="friends_layer int_layer">
	<div class="inner_layer">
		<div class="layer_head">
			<strong class="tit_int">주문 후 취소, 반품, 배송지<br> 변경이 불가합니다.</strong>
		</div>
		<div class="layer_body">
			<strong class="screen_out">안내사항</strong>
			<ul class="list_int">
				<li>- 배송일 지정은 불가하며 주문 12~14일 후 배송됩니다.</li>
				<li>- 각인 메세지는 영문 알파벳만 가능합니다.</li>
				<li>- 영문 대,소문자를 구분하여 입력해주세요.</li>
				<li>- 자수 모양으로 인한 교환은 불가합니다.</li>
			</ul>
		</div>
		<div class="fn_custom layer_foot">
			<button type="button" class="fn_cancel btn_int">취소</button>
			<button type="button" class="fn_agree btn_int">동의</button>
		</div>
	</div>
</div>
</c:if>
<c:if test="${productDetail.isEventProduct}">
<div class="friends_layer int_layer">
	<div class="inner_layer">
		<div class="layer_head">
			<strong class="tit_int">주문 후 취소, 반품,<br> 배송지 변경이 불가합니다.</strong>
		</div>
		<div class="layer_body">
			<strong class="screen_out">안내사항</strong>
			<ul class="list_int list_type2">
				<li>- 제조사에서 별도 발송하는 상품으로 단독구매만 가능합니다.</li>
				<li>- 주문 후 1~3일 (영업일 기준) 내에 받아보실 수 있습니다.</li>
			</ul>
		</div>
		<div class="fn_event layer_foot">
			<button type="button" class="fn_cancel btn_int">취소</button>
			<button type="button" class="fn_agree btn_int">동의</button>
		</div>
	</div>
</div>
</c:if>
<c:if test="${productDetail.product.prForeigndeliyn == 'Y'}">

</c:if>
</body>
</html>