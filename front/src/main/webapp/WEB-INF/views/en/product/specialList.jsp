<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="si" uri="http://www.kakaofriends.com/si" %>
<c:set value="${requestScope['javax.servlet.forward.servlet_path']}" var="requestPath"/>
<div id="mArticle">
	<div class="cont_product product_type1">
		<div class="head_product">
			<div class="opt_sort"><!--펼침시 클래스 sort_open 부여-->
				<strong class="screen_out">sort by product</strong>
				<a href="#none" class="link_selected">
					<span class="txt_sort">${productRequest.sort.ename}</span>
					<span class="screen_out">selected</span>
					<span class="ico_friends ico_arr"></span>
				</a>
				<div class="box_sort">
					<em class="screen_out">select option</em>
					<ul class="list_sort">
						<c:forEach items="${sortTypes}" var="sort">
							<li class="${sort eq productRequest.sort ? 'on' : ''}">
								<a href="javascript:sortList()" class="link_sort">${sort.ename}</a>
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div class="check_delivery">
				<c:if test="${globalFilter}">
					<input type="checkbox" id="checkDelivery" name="chk" class="inp_g" checked>
				</c:if>
				<c:if test="${!globalFilter}">
					<input type="checkbox" id="checkDelivery" name="chk" class="inp_g">
				</c:if>
				<label for="checkDelivery" class="lab_g">
					<span class="ico_friends ico_check"></span>
					<span class="ico_friends ico_delivery"></span>View global shipping products
				</label>
			</div>
			<p class="desc_total">Total <em class="emph_total">${pagination.totalRecordCount}</em> results.</p>
		</div>
		<strong class="screen_out">product list</strong>
		<ul class="list_product"> <!-- 모바일에선 10개만 노출 -->
			<c:forEach items="${productExpansions}" var="item" varStatus="status">
				<c:choose>
					<c:when test="${item.product.prCode == '9791196121303' and today <= 201707092359}">
						<li>
							<a href="/en/products/${item.product.prCode}" class="link_product">
								<span class="wrap_thumb">
									<%--<img src="${kakaoFriendsCdn.product}/${empty item.product.prImage12 ? item.product.prImage1 : item.product.prImage12}" class="thumb_g" alt="">--%>
									<si:tenthImageTag type="product" imageName="${item.product.prImage1}" altVal=""/>
									<c:if test="${item.isSoldOut}">
										<span class="ico_friends ico_soldout">sold out</span>
									</c:if>
									<c:if test="${!item.isSoldOut and item.isDiscountPeriod}">
										<span class="ico_friends ico_sale">sale</span>
									</c:if>
								</span>
											<strong class="tit_product">${empty item.product.prName1 ? item.product.prName : item.product.prName1}</strong>
											<c:if test="${!item.isDiscountPeriod}">
												<em class="emph_price">
													<span class="screen_out">Price</span><span class="current_price"><fmt:formatNumber value="${item.productLevelPrice.prlpSaleprice1}" type="number"/>KRW <span class="usd_price">(<fmt:formatNumber value="${item.productLevelPrice.exchangePrice}" type="number"/> USD)</span></span><!-- 2017-06-16 수정 -->
												</em>
											</c:if>
											<c:if test="${item.isDiscountPeriod}">
												<em class="emph_price">
													<span class="screen_out">Sale Price</span><span class="current_price"><fmt:formatNumber value="${item.productLevelPrice.prlpDiscountprice1}" type="number"/>KRW <span class="usd_price">(<fmt:formatNumber value="${item.productLevelPrice.exchangeDiscountPrice}" type="number"/> USD)</span></span><!-- 2017-06-16 수정 -->
													<span class="screen_out">Price</span><span class="prev_price"><fmt:formatNumber value="${item.productLevelPrice.prlpSaleprice1}" type="number"/>KRW <span class="usd_price">(<fmt:formatNumber value="${item.productLevelPrice.exchangePrice}" type="number"/> USD)</span></span><!-- 2017-06-16 수정 -->
												</em>
											</c:if>
										</a>
										<span class="item_state">
								<c:if test="${item.foreigndeliCheck == 0}">
									<span class="ico_friends ico_nodelivery">This product cannot be shipped internationally.</span> <!-- 해외배송 불가일때 -->
								</c:if>
								<c:if test="${item.foreigndeliCheck > 0}">
									<a href="javascript:globalNationPopup()"><span class="ico_friends ico_delivery">This product can be shipped internationally.</span></a><!-- 해외배송 가능일때 -->
								</c:if>
								<a href="javascript:alertPopup('alert_noBasket_product')"/><span class="ico_friends ${(item.basketCheck > 0) ? 'ico_cart' : 'ico_nocart'}">장바구니 담기</span></a>
							</span>
						</li>
					</c:when>
					<c:otherwise>
						<li>
							<a href="/en/products/${item.product.prCode}" class="link_product">
								<span class="wrap_thumb">
									<%--<img src="${kakaoFriendsCdn.product}/${empty item.product.prImage12 ? item.product.prImage1 : item.product.prImage12}" class="thumb_g" alt="">--%>
									<si:tenthImageTag type="product" imageName="${item.product.prImage1}" altVal=""/>
									<c:if test="${item.isSoldOut}">
										<span class="ico_friends ico_soldout">sold out</span>
									</c:if>
									<c:if test="${!item.isSoldOut and item.isDiscountPeriod}">
										<span class="ico_friends ico_sale">sale</span>
									</c:if>
								</span>
								<strong class="tit_product">${empty item.product.prName1 ? item.product.prName : item.product.prName1}</strong>
								<c:if test="${!item.isDiscountPeriod}">
									<em class="emph_price">
										<span class="screen_out">Price</span><span class="current_price"><fmt:formatNumber value="${item.productLevelPrice.prlpSaleprice1}" type="number"/>KRW <span class="usd_price">(<fmt:formatNumber value="${item.productLevelPrice.exchangePrice}" type="number"/> USD)</span></span><!-- 2017-06-16 수정 -->
									</em>
								</c:if>
								<c:if test="${item.isDiscountPeriod}">
									<em class="emph_price">
										<span class="screen_out">Sale Price</span><span class="current_price"><fmt:formatNumber value="${item.productLevelPrice.prlpDiscountprice1}" type="number"/>KRW <span class="usd_price">(<fmt:formatNumber value="${item.productLevelPrice.exchangeDiscountPrice}" type="number"/> USD)</span></span><!-- 2017-06-16 수정 -->
										<span class="screen_out">Price</span><span class="prev_price"><fmt:formatNumber value="${item.productLevelPrice.prlpSaleprice1}" type="number"/>KRW <span class="usd_price">(<fmt:formatNumber value="${item.productLevelPrice.exchangePrice}" type="number"/> USD)</span></span><!-- 2017-06-16 수정 -->
									</em>
								</c:if>
							</a>
							<span class="item_state">
								<c:if test="${item.foreigndeliCheck == 0}">
									<span class="ico_friends ico_nodelivery">This product cannot be shipped internationally.</span> <!-- 해외배송 불가일때 -->
								</c:if>
								<c:if test="${item.foreigndeliCheck > 0}">
									<a href="javascript:globalNationPopup()"><span class="ico_friends ico_delivery">This product can be shipped internationally.</span></a><!-- 해외배송 가능일때 -->
								</c:if>
								<c:if test="${!empty item.product.defaultPrcode}">
									<a href="/en/basket/basket/insert/${item.product.prCode}/${item.product.defaultPrcode}"/><!-- 대표상품 설정되있을때 -->
								</c:if>
								<c:if test="${empty item.product.defaultPrcode}">
									<a href="/en/products/${item.product.prCode}"/><!-- 대표상품 설정 안되있을때 -->
								</c:if>
								<span class="ico_friends ${(item.basketCheck > 0) ? 'ico_cart' : 'ico_nocart'}">Add to cart</span></a>
							</span>
						</li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</ul>
		<tiles:insertTemplate template="/WEB-INF/templates/en/sub/paging.jsp" flush="true"/>
	</div>
</div>

<script type="application/javascript">
    function fnPaging(location, pageIndex) {
        window.location.href = location + "?pageIndex=" + pageIndex;
    }


    function sortList(){
        var sortQuery = getSortQuery();
        var filterQuery = getFilterQuery();

        if(filterQuery == ""){
            window.location.href = "${requestPath}" + "?"+ sortQuery;
        }else{
            window.location.href = "${requestPath}" + "?"+ sortQuery + "&" + filterQuery;
        }
    }

    $("#checkDelivery").change( function () {
        sortList();
    });

    function getSortQuery() {
        var sortName = $(".txt_sort").text();

        if(sortName.trim() == "Newly stocked") return "sort=NEW";
        if(sortName.trim() == "Price low to high") return "sort=PRICE_ASC";
        if(sortName.trim() == "Price high to low") return "sort=PRICE_DESC";

    }

    function getFilterQuery() {
        if($("#checkDelivery").is(":checked")){
            return "filter=global";
        }else{
            return "";
        }
    }

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