<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="si" uri="http://www.kakaofriends.com/si" %>
<c:set value="${requestScope['javax.servlet.forward.servlet_path']}" var="requestPath"/>
<c:set value="${requestScope['javax.servlet.forward.query_string']}" var="queryString"/>
<div id="mArticle">
	<h2 id="kakaoBody" class="screen_out">검색 결과</h2>
	<div class="cont_product cont_result">
	<c:choose>
	<c:when test="${empty productExpansions}">
		<p class="desc_nodata">검색하신 내용이 존재하지 않습니다.</p>
	</c:when>
	<c:otherwise>
		<h3 class="tit_result">&ldquo; ${param.keyword} &rdquo;</h3>
		<div class="head_result">
			<p class="desc_total">총 <em class="emph_total">${totalCount}개</em> 의 상품이 조회되었습니다.</p>
			<div class="opt_sort">
				<strong class="screen_out">상품 정렬 선택</strong>
				<a href="#none" class="link_selected">
					<span class="txt_sort">${searchRequest.sort.name}</span>
					<span class="screen_out">선택됨</span>
					<span class="ico_friends ico_arr"></span>
				</a>
				<div class="box_sort">
					<em class="screen_out">선택옵션</em>
					<ul class="list_sort">
						<c:forEach items="${sortTypes}" var="sort">
						<li class="${sort eq productRequest.sort ? 'on' : ''}">
							<c:set value="${queryString.replaceAll('(&)?sort=[A-Z,a-z,_]*','')}" var="query"/>
							<a href="${pageLink}?${query}${empty(query) ? '' : '&'}sort=${sort}" class="link_sort">${sort.name}</a>
						</li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
		<strong class="screen_out">상품 목록</strong>
		<ul class="list_product">
			<c:forEach items="${productExpansions}" var="productExpansion">
				<c:choose>
					<c:when test="${productExpansion.product.prCode == '9791196121303' and today <= 201707092359}">
						<li>
							<a href="/kr/products/${productExpansion.product.prCode}" class="link_product">
						<span class="wrap_thumb">
							<%--<img src="${kakaoFriendsCdn.product}/${empty productExpansion.product.prImage12 ? productExpansion.product.prImage1 : productExpansion.product.prImage12}" class="thumb_g" alt="">--%>
							<si:tenthImageTag type="product" imageName="${productExpansion.product.prImage1}" altVal=""/>
				 			<c:if test="${productExpansion.isSoldOut}">
								<span class="ico_friends ico_soldout">품절</span>
							</c:if>
							<c:if test="${!productExpansion.isSoldOut and productExpansion.isDiscountPeriod}">
								<span class="ico_friends ico_sale">할인</span>
							</c:if>
						</span>
								<strong class="tit_product">${productExpansion.product.prName}</strong>
								<c:if test="${!productExpansion.isDiscountPeriod}">
									<em class="emph_price">
										<span class="screen_out">금액</span><span class="current_price"><fmt:formatNumber value="${productExpansion.productLevelPrice.prlpSaleprice1}" type="number"/>원 <span class="usd_price">(<fmt:formatNumber value="${productExpansion.productLevelPrice.exchangePrice}" type="number"/> USD)</span></span><!-- 2017-06-21 수정 -->
									</em>
								</c:if>
								<c:if test="${productExpansion.isDiscountPeriod}">
									<em class="emph_price">
										<span class="screen_out">할인금액</span><span class="current_price"><fmt:formatNumber value="${productExpansion.productLevelPrice.prlpDiscountprice1}" type="number"/>원 <span class="usd_price">(<fmt:formatNumber value="${productExpansion.productLevelPrice.exchangeDiscountPrice}" type="number"/> USD)</span></span><!-- 2017-06-21 수정 -->
										<span class="screen_out">기존금액</span><span class="prev_price"><fmt:formatNumber value="${productExpansion.productLevelPrice.prlpSaleprice1}" type="number"/>원 <span class="usd_price">(<fmt:formatNumber value="${productExpansion.productLevelPrice.exchangePrice}" type="number"/> USD)</span></span><!-- 2017-06-21 수정 -->
									</em>
								</c:if>
							</a>
							<span class="item_state">
								<c:if test="${productExpansion.foreigndeliCheck == 0}">
									<span class="ico_friends ico_nodelivery">글로벌 배송 불가</span> <!-- 해외배송 불가일때 -->
								</c:if>
								<c:if test="${productExpansion.foreigndeliCheck > 0}">
									<a href="javascript:globalNationPopup()"><span class="ico_friends ico_delivery">글로벌 배송 가능</span></a><!-- 해외배송 가능일때 -->
								</c:if>
								<a href="javascript:alertPopup('alert_noBasket_product')"/><span class="ico_friends ${(productExpansion.basketCheck > 0) ? 'ico_cart' : 'ico_nocart'}">장바구니 담기</span></a>
							</span>
						</li>
					</c:when>
					<c:otherwise>
						<li>
							<a href="/kr/products/${productExpansion.product.prCode}" class="link_product">
						<span class="wrap_thumb">
							<%--<img src="${kakaoFriendsCdn.product}/${empty productExpansion.product.prImage12 ? productExpansion.product.prImage1 : productExpansion.product.prImage12}" class="thumb_g" alt="">--%>
							<si:tenthImageTag type="product" imageName="${productExpansion.product.prImage1}" altVal=""/>
				 			<c:if test="${productExpansion.isSoldOut}">
								<span class="ico_friends ico_soldout">품절</span>
							</c:if>
							<c:if test="${!productExpansion.isSoldOut and productExpansion.isDiscountPeriod}">
								<span class="ico_friends ico_sale">할인</span>
							</c:if>
						</span>
								<strong class="tit_product">${productExpansion.product.prName}</strong>
								<c:if test="${!productExpansion.isDiscountPeriod}">
									<em class="emph_price">
										<span class="screen_out">금액</span><span class="current_price"><fmt:formatNumber value="${productExpansion.productLevelPrice.prlpSaleprice1}" type="number"/>원 <span class="usd_price">(<fmt:formatNumber value="${productExpansion.productLevelPrice.exchangePrice}" type="number"/> USD)</span></span><!-- 2017-06-21 수정 -->
									</em>
								</c:if>
								<c:if test="${productExpansion.isDiscountPeriod}">
									<em class="emph_price">
										<span class="screen_out">할인금액</span><span class="current_price"><fmt:formatNumber value="${productExpansion.productLevelPrice.prlpDiscountprice1}" type="number"/>원 <span class="usd_price">(<fmt:formatNumber value="${productExpansion.productLevelPrice.exchangeDiscountPrice}" type="number"/> USD)</span></span><!-- 2017-06-21 수정 -->
										<span class="screen_out">기존금액</span><span class="prev_price"><fmt:formatNumber value="${productExpansion.productLevelPrice.prlpSaleprice1}" type="number"/>원 <span class="usd_price">(<fmt:formatNumber value="${productExpansion.productLevelPrice.exchangePrice}" type="number"/> USD)</span></span><!-- 2017-06-21 수정 -->
									</em>
								</c:if>
							</a>
							<span class="item_state">
								<c:if test="${productExpansion.foreigndeliCheck == 0}">
									<span class="ico_friends ico_nodelivery">글로벌 배송 불가</span> <!-- 해외배송 불가일때 -->
								</c:if>
								<c:if test="${productExpansion.foreigndeliCheck > 0}">
									<a href="javascript:globalNationPopup()"><span class="ico_friends ico_delivery">글로벌 배송 가능</span></a><!-- 해외배송 가능일때 -->
								</c:if>
								<c:if test="${!empty productExpansion.product.defaultPrcode}">
									<a href="/kr/basket/basket/insert/${productExpansion.product.prCode}/${productExpansion.product.defaultPrcode}"/><!-- 대표상품 설정되있을때 -->
								</c:if>
								<c:if test="${empty productExpansion.product.defaultPrcode}">
									<a href="/kr/products/${productExpansion.product.prCode}"/><!-- 대표상품 설정 안되있을때 -->
								</c:if>
								<span class="ico_friends ${(productExpansion.basketCheck > 0) ? 'ico_cart' : 'ico_nocart'}">장바구니 담기</span></a>
							</span>
						</li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</ul>
		<tiles:insertTemplate template="/WEB-INF/templates/kr/sub/paging.jsp" flush="true"/>
	</div>
	</c:otherwise>
	</c:choose>
</div>
<script>
    $(function () {
        <c:if test="${!empty basketPopup}">
        <c:choose>
        <c:when test="${basketPopup}">
        basketPopup();
        </c:when>
        <c:otherwise>
        alertPopup('alert_alreadyBasket_giftBag_detail');
        </c:otherwise>
        </c:choose>
        </c:if>
    })
</script>