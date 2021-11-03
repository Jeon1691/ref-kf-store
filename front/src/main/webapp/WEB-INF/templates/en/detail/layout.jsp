<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set var="req" value="${pageContext.request}" />
<c:set var="baseURL" value="${fn:replace(req.requestURL, req.requestURI, '')}" />
<c:set var="params" value="${requestScope['javax.servlet.forward.query_string']}"/>
<c:set var="requestPath" value="${requestScope['javax.servlet.forward.request_uri']}"/>
<c:set var="pageUrl" value="${ baseURL }${ requestPath }${ not empty params?'?'+=params:'' }"/>

<!doctype html>
<html lang="${language}" class="${userAgent.os.name } ${' '} ${userAgent.browser.name } ${' '} ${userAgent.platform}">
<head>
    <title>KAKAO FRIENDS :: ${displayGoodsDetail.displayGoods.name}</title>
	<tiles:insertTemplate template="/WEB-INF/templates/en/sub/layoutHeader.jsp" flush="true"/>
    <!-- 페이스북 -->
	<meta property="og:title" content="${displayGoodsDetail.displayGoods.name1}">
	<meta property="og:description" content="${displayGoodsDetail.displayGoods.name1}">
	<c:if test="${!empty(displayGoodsDetail.displayGoods.image1)}">
		<meta property="og:image" content="${kakaoFriendsCdn.product}/${displayGoodsDetail.displayGoods.image1}">
	</c:if>
    <meta property="og:image:width" content="500">
    <meta property="og:image:height" content="500">
    <meta property="og:image:width" content="500">
	<meta property="og:image:height" content="500">
	<!-- 트위터 -->
	<meta name="twitter:card" content="summary">
	<meta name="twitter:title" content="${displayGoodsDetail.displayGoods.name1}">
	<c:if test="${!empty(displayGoodsDetail.displayGoods.image1)}">
		<meta property="twitter:image" content="${kakaoFriendsCdn.product}/${displayGoodsDetail.displayGoods.image1}">
	</c:if>

    <script type="application/ld+json">
    {
    "@context":"https://schema.org",
    "@type":"Product",
    "productID":"${productRequest.product.prCode}",
    "name":"${displayGoodsDetail.displayGoods.name1}",
    "description":"${displayGoodsDetail.displayGoods.name1}",
    "url":"${pageUrl}",
    "image": "${kakaoFriendsCdn.product}/${displayGoodsDetail.displayGoods.image1}",
    "brand":"KAKAOFRIENDS",
    "offers":[
    {
    "@type":"Offer",
    "price":"${displayGoodsDetail.displayGoods.exchangePrice}",
    "priceCurrency":"USD",
    "itemCondition":"https://schema.org/NewCondition",
    "availability":"https://schema.org/InStock"
    }
    ]
    }
    </script>
</head>
<body class="en">
<script>
  fbq('track', 'ViewContent', {
    value: '${displayGoodsDetail.displayGoods.exchangePrice}',
    currency: 'USD',
    content_ids: '${productRequest.product.prCode}',
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
	<a href="#kakaoBody">Content Shortcuts</a>
	<a href="#kakaoGnb">Menu Shortcuts</a>
</div>
<div id="kakaoWrap">
	<tiles:insertAttribute name="header" flush="true"/>
	<hr class="hide">
	<div id="kakaoContent" class="cont_item" role="main">
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
<c:if test="${productDetail.isCustomProduct}">
<div class="friends_layer alert_layer">
	<div class="inner_layer">
		<div class="layer_head">
			<strong class="screen_out">Information</strong>
		</div>
		<div class="layer_body">
			<div class="box_desc">
				<p class="desc_layer"></p>
			</div>
			<button type="button" class="btn_verify btn_confirm">OK</button>
		</div>
	</div>
</div>
<div class="friends_layer int_layer">
	<div class="inner_layer">
		<div class="layer_head">
			<strong class="tit_int">After placing your order,<br> you will not<br> be able to cancel,<br> return the item, or change<br> the delivery destination.</strong>
		</div>
		<div class="layer_body">
			<strong class="screen_out">Information</strong>
			<ul class="list_int">
				<%--<li>- 배송일 지정은 불가하며 주문 12~14일 후 배송됩니다.</li>--%>
				<%--<li>- 각인 메세지는 영문 알파벳만 가능합니다.</li>--%>
				<li>- The embroidered text must be in capital and lowercase English letters. Please differentiate between capital and lowercase letters in the delivery notes.</li>
				<li>- The look of the custom embroidery does not constitute a valid reason for an exchange.</li>
			</ul>
		</div>
		<div class="fn_custom layer_foot">
			<button type="button" class="fn_cancel btn_int">Cancel</button>
			<button type="button" class="fn_agree btn_int">Agree</button>
		</div>
	</div>
</div>
</c:if>
<c:if test="${productDetail.isEventProduct}">
<div class="friends_layer int_layer">
	<div class="inner_layer">
		<div class="layer_head">
			<strong class="tit_int">After placing your order,<br> you will not<br> be able to cancel,<br> return the item, or change<br> the delivery destination.</strong>
		</div>
		<div class="layer_body">
			<strong class="screen_out">Information</strong>
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
</body>
</html>