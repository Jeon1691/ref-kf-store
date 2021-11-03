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
				<strong class="screen_out">상품 정렬 선택</strong>
				<a href="#none" class="link_selected">
					<span class="txt_sort">${productRequest.sort.name}</span>
					<span class="screen_out">선택됨</span>
					<span class="ico_friends ico_arr"></span>
				</a>
				<div class="box_sort">
					<em class="screen_out">선택옵션</em>
					<ul class="list_sort">
						<c:forEach items="${sortTypes}" var="sort">
							<li class="${sort eq productRequest.sort ? 'on' : ''}">
								<a href="javascript:sortList()" class="link_sort">${sort.name}</a>
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
					<span class="ico_friends ico_delivery"></span>글로벌 배송 가능 상품 보기
				</label>
			</div>
			<p class="desc_total">총 <em class="emph_total">${pagination.totalRecordCount}개</em> 의 상품이 조회되었습니다.</p>
		</div>
		<strong class="screen_out">상품 목록</strong>
		<ul class="list_product"> <!-- 모바일에선 10개만 노출 -->
			<c:forEach items="${productExpansions}" var="productExpansion" varStatus="status">
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
													<span class="screen_out">금액</span><span class="current_price"><fmt:formatNumber value="${productExpansion.productLevelPrice.prlpSaleprice1}" type="number"/>원 <span class="usd_price">(<fmt:formatNumber value="${productExpansion.productLevelPrice.exchangePrice}" type="number"/> USD)</span></span><!-- 2017-06-16 수정 -->
												</em>
											</c:if>
											<c:if test="${productExpansion.isDiscountPeriod}">
												<em class="emph_price">
													<span class="screen_out">할인금액</span><span class="current_price"><fmt:formatNumber value="${productExpansion.productLevelPrice.prlpDiscountprice1}" type="number"/>원 <span class="usd_price">(<fmt:formatNumber value="${productExpansion.productLevelPrice.exchangeDiscountPrice}" type="number"/> USD)</span></span><!-- 2017-06-16 수정 -->
													<span class="screen_out">기존금액</span><span class="prev_price"><fmt:formatNumber value="${productExpansion.productLevelPrice.prlpSaleprice1}" type="number"/>원 <span class="usd_price">(<fmt:formatNumber value="${productExpansion.productLevelPrice.exchangePrice}" type="number"/> USD)</span></span><!-- 2017-06-16 수정 -->
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
								<a href="javascript:alertPopup('alert_noBasket_product')"/><span class="ico_friends ${!empty(productExpansion.bsSeq) ? 'ico_cart' : 'ico_nocart'}">장바구니 담기</span></a>
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
										<span class="screen_out">금액</span><span class="current_price"><fmt:formatNumber value="${productExpansion.productLevelPrice.prlpSaleprice1}" type="number"/>원 <span class="usd_price">(<fmt:formatNumber value="${productExpansion.productLevelPrice.exchangePrice}" type="number"/> USD)</span></span><!-- 2017-06-16 수정 -->
									</em>
								</c:if>
								<c:if test="${productExpansion.isDiscountPeriod}">
									<em class="emph_price">
										<span class="screen_out">할인금액</span><span class="current_price"><fmt:formatNumber value="${productExpansion.productLevelPrice.prlpDiscountprice1}" type="number"/>원 <span class="usd_price">(<fmt:formatNumber value="${productExpansion.productLevelPrice.exchangeDiscountPrice}" type="number"/> USD)</span></span><!-- 2017-06-16 수정 -->
										<span class="screen_out">기존금액</span><span class="prev_price"><fmt:formatNumber value="${productExpansion.productLevelPrice.prlpSaleprice1}" type="number"/>원 <span class="usd_price">(<fmt:formatNumber value="${productExpansion.productLevelPrice.exchangePrice}" type="number"/> USD)</span></span><!-- 2017-06-16 수정 -->
									</em>
								</c:if>
							</a>

							<c:set var="cartPath" value="/kr/basket/basket/insert/"/>
							<c:if test="${requestScope['javax.servlet.forward.request_uri'] == '/kr/index'}">
								<c:set var="cartPath" value="/kr/basket/basket/insert_async/"/>
							</c:if>

							<span class="item_state">
								<c:if test="${productExpansion.foreigndeliCheck == 0}">
									<span class="ico_friends ico_nodelivery">글로벌 배송 불가</span> <!-- 해외배송 불가일때 -->
								</c:if>
								<c:if test="${productExpansion.foreigndeliCheck > 0}">
									<a href="javascript:globalNationPopup()"><span class="ico_friends ico_delivery">글로벌 배송 가능</span></a><!-- 해외배송 가능일때 -->
								</c:if>
								<c:if test="${!empty productExpansion.product.defaultPrcode}">
									<a href="${cartPath}${productExpansion.product.prCode}/${productExpansion.product.defaultPrcode}"/><!-- 대표상품 설정되있을때 -->
								</c:if>
								<c:if test="${empty productExpansion.product.defaultPrcode}">
									<a href="/kr/products/${productExpansion.product.prCode}"/><!-- 대표상품 설정 안되있을때 -->
								</c:if>
								<span class="ico_friends ${!empty(productExpansion.bsSeq) ? 'ico_cart' : 'ico_nocart'}">장바구니 담기</span></a>
							</span>
						</li>
					</c:otherwise>
				</c:choose>

			</c:forEach>
		</ul>
		<tiles:insertTemplate template="/WEB-INF/templates/kr/sub/paging.jsp" flush="true"/>
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

	    if(sortName.trim() == "신상품순") return "sort=NEW";
        if(sortName.trim() == "낮은가격순") return "sort=PRICE_ASC";
        if(sortName.trim() == "높은가격순") return "sort=PRICE_DESC";

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