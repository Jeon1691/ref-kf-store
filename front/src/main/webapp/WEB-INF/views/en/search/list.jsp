<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="si" uri="http://www.kakaofriends.com/si" %>
<c:set value="${requestScope['javax.servlet.forward.servlet_path']}" var="requestPath"/>
<c:set value="${requestScope['javax.servlet.forward.query_string']}" var="queryString"/>
<div id="mArticle">
	<h2 id="kakaoBody" class="screen_out">Search Results</h2>
	<div class="cont_product cont_result">
	<c:choose>
	<c:when test="${empty productExpansions}">
		<p class="desc_nodata">No search results.</p>
	</c:when>
	<c:otherwise>
		<h3 class="tit_result">&ldquo; ${param.keyword} &rdquo;</h3>
		<div class="head_result">
			<p class="desc_total">Total <em class="emph_total">${totalCount}</em> results.</p>
			<div class="opt_sort">
				<strong class="screen_out">sort by product</strong>
				<a href="#none" class="link_selected">
					<span class="txt_sort">${searchRequest.sort.ename}</span>
					<span class="screen_out">selected</span>
					<span class="ico_friends ico_arr"></span>
				</a>
				<div class="box_sort">
					<em class="screen_out">select option</em>
					<ul class="list_sort">
						<c:forEach items="${sortTypes}" var="sort">
						<li class="${sort eq productRequest.sort ? 'on' : ''}">
							<c:set value="${queryString.replaceAll('(&)?sort=[A-Z,a-z,_]*','')}" var="query"/>
							<a href="${pageLink}?${query}${empty(query) ? '' : '&'}sort=${sort}" class="link_sort">${sort.ename}</a>
						</li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
		<strong class="screen_out">product list</strong>
		<ul class="list_product">
			<c:forEach items="${productExpansions}" var="productExpansion">
				<c:choose>
					<c:when test="${productExpansion.product.prCode == '9791196121303' and today <= 201707092359}">
						<li>
							<a href="/en/products/${productExpansion.product.prCode}" class="link_product">
						<span class="wrap_thumb">
							<%--<img src="${kakaoFriendsCdn.product}/${empty productExpansion.product.prImage12 ? productExpansion.product.prImage1 : productExpansion.product.prImage12}" class="thumb_g" alt="">--%>
							<si:tenthImageTag type="product" imageName="${productExpansion.product.prImage1}" altVal=""/>
				 			<c:if test="${productExpansion.isSoldOut}">
								<span class="ico_friends ico_soldout">sold out</span>
							</c:if>
							<c:if test="${!productExpansion.isSoldOut and productExpansion.isDiscountPeriod}">
								<span class="ico_friends ico_sale">sale</span>
							</c:if>
						</span>
								<strong class="tit_product">${empty productExpansion.product.prName1 ? productExpansion.product.prName : productExpansion.product.prName1}</strong>
								<c:if test="${!productExpansion.isDiscountPeriod}">
									<em class="emph_price">
										<span class="screen_out">Price</span><span class="current_price"><fmt:formatNumber value="${productExpansion.productLevelPrice.prlpSaleprice1}" type="number"/>KRW <span class="usd_price">(<fmt:formatNumber value="${productExpansion.productLevelPrice.exchangePrice}" type="number"/> USD)</span></span><!-- 2017-06-21 수정 -->
									</em>
								</c:if>
								<c:if test="${productExpansion.isDiscountPeriod}">
									<em class="emph_price">
										<span class="screen_out">Sale Price</span><span class="current_price"><fmt:formatNumber value="${productExpansion.productLevelPrice.prlpDiscountprice1}" type="number"/>KRW <span class="usd_price">(<fmt:formatNumber value="${productExpansion.productLevelPrice.exchangeDiscountPrice}" type="number"/> USD)</span></span><!-- 2017-06-21 수정 -->
										<span class="screen_out">Price</span><span class="prev_price"><fmt:formatNumber value="${productExpansion.productLevelPrice.prlpSaleprice1}" type="number"/>KRW <span class="usd_price">(<fmt:formatNumber value="${productExpansion.productLevelPrice.exchangePrice}" type="number"/> USD)</span></span><!-- 2017-06-21 수정 -->
									</em>
								</c:if>
							</a>
							<span class="item_state">
								<c:if test="${productExpansion.foreigndeliCheck == 0}">
									<span class="ico_friends ico_nodelivery">This product cannot be shipped internationally.</span> <!-- 해외배송 불가일때 -->
								</c:if>
								<c:if test="${productExpansion.foreigndeliCheck > 0}">
									<a href="javascript:globalNationPopup()"><span class="ico_friends ico_delivery">This product can be shipped internationally.</span></a><!-- 해외배송 가능일때 -->
								</c:if>
								<a href="javascript:alertPopup('alert_noBasket_product')"/><span class="ico_friends ${(productExpansion.basketCheck > 0) ? 'ico_cart' : 'ico_nocart'}">Add to cart</span></a>
							</span>
						</li>
					</c:when>
					<c:otherwise>
						<li>
							<a href="/en/products/${productExpansion.product.prCode}" class="link_product">
						<span class="wrap_thumb">
							<%--<img src="${kakaoFriendsCdn.product}/${empty productExpansion.product.prImage12 ? productExpansion.product.prImage1 : productExpansion.product.prImage12}" class="thumb_g" alt="">--%>
							<si:tenthImageTag type="product" imageName="${productExpansion.product.prImage1}" altVal=""/>
				 			<c:if test="${productExpansion.isSoldOut}">
								<span class="ico_friends ico_soldout">sold out</span>
							</c:if>
							<c:if test="${!productExpansion.isSoldOut and productExpansion.isDiscountPeriod}">
								<span class="ico_friends ico_sale">sale</span>
							</c:if>
						</span>
								<strong class="tit_product">${empty productExpansion.product.prName1 ? productExpansion.product.prName : productExpansion.product.prName1}</strong>
								<c:if test="${!productExpansion.isDiscountPeriod}">
									<em class="emph_price">
										<span class="screen_out">Price</span><span class="current_price"><fmt:formatNumber value="${productExpansion.productLevelPrice.prlpSaleprice1}" type="number"/>KRW <span class="usd_price">(<fmt:formatNumber value="${productExpansion.productLevelPrice.exchangePrice}" type="number"/> USD)</span></span><!-- 2017-06-21 수정 -->
									</em>
								</c:if>
								<c:if test="${productExpansion.isDiscountPeriod}">
									<em class="emph_price">
										<span class="screen_out">Sale Price</span><span class="current_price"><fmt:formatNumber value="${productExpansion.productLevelPrice.prlpDiscountprice1}" type="number"/>KRW <span class="usd_price">(<fmt:formatNumber value="${productExpansion.productLevelPrice.exchangeDiscountPrice}" type="number"/> USD)</span></span><!-- 2017-06-21 수정 -->
										<span class="screen_out">Price</span><span class="prev_price"><fmt:formatNumber value="${productExpansion.productLevelPrice.prlpSaleprice1}" type="number"/>KRW <span class="usd_price">(<fmt:formatNumber value="${productExpansion.productLevelPrice.exchangePrice}" type="number"/> USD)</span></span><!-- 2017-06-21 수정 -->
									</em>
								</c:if>
							</a>
							<span class="item_state">
								<c:if test="${productExpansion.foreigndeliCheck == 0}">
									<span class="ico_friends ico_nodelivery">This product cannot be shipped internationally.</span> <!-- 해외배송 불가일때 -->
								</c:if>
								<c:if test="${productExpansion.foreigndeliCheck > 0}">
									<a href="javascript:globalNationPopup()"><span class="ico_friends ico_delivery">This product can be shipped internationally.</span></a><!-- 해외배송 가능일때 -->
								</c:if>
								<c:if test="${!empty productExpansion.product.defaultPrcode}">
									<a href="/en/basket/basket/insert/${productExpansion.product.prCode}/${productExpansion.product.defaultPrcode}"/><!-- 대표상품 설정되있을때 -->
								</c:if>
								<c:if test="${empty productExpansion.product.defaultPrcode}">
									<a href="/en/products/${productExpansion.product.prCode}"/><!-- 대표상품 설정 안되있을때 -->
								</c:if>
								<span class="ico_friends ${(productExpansion.basketCheck > 0) ? 'ico_cart' : 'ico_nocart'}">Add to cart</span></a>
							</span>
						</li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</ul>
		<tiles:insertTemplate template="/WEB-INF/templates/en/sub/paging.jsp" flush="true"/>
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