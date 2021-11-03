<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="kf" uri="http://www.kakaofriends.com" %>
<%@ taglib prefix="si" uri="http://www.kakaofriends.com/si" %>
<c:set value="${requestScope['javax.servlet.forward.servlet_path']}" var="requestPath"/>
<c:set value="${requestScope['javax.servlet.forward.query_string']}" var="queryString"/>
<div id="mArticle">
	<div class="cont_product">
		<div class="head_product">
			<c:if test="${productRequest.ctGroup == 'categories' and (productRequest.ctSeq ne '3' and productRequest.ctSeq ne '87')}">
			<strong class="screen_out">상품 상세분류 선택</strong>
			<div class="wrap_tab">
				<ul class="tab_friends">
					<c:forEach items="${subCategoryMenu}" var="subMenu">
						<li class="${subMenu.ctSeq eq productRequest.ctSeq ? 'on' : ''}"><a href="/kr/products/groups/categories/${subMenu.ctSeq}?requestCategory=${subMenu.ctSeq}" class="link_tab">${subMenu.ctNode ne '3' ? '전체' : subMenu.ctName}<c:if test="${subMenu.ctSeq eq productRequest.ctSeq}"><span class="screen_out">선택됨</span></c:if></a></li>
					</c:forEach>
				</ul>
			</div>
			</c:if>
			<div class="wrap_opt">
				<c:if test="${productRequest.ctGroup == 'categories'}">
				<div class="opt_sort">
					<strong class="screen_out">캐릭터 선택</strong>
					<a href="#none" class="link_selected">
						<span class="txt_sort" id="characterText">${kf:findByCategorySeq(categoryMenu[4], productRequest.requestCharacter)}</span>
						<span class="screen_out">선택됨</span>
						<span class="ico_friends ico_arr"></span>
					</a>
					<div class="box_sort">
						<em class="screen_out">선택옵션</em>
						<ul class="list_sort">
							<li>
								<a href="javascript:sortList()" class="link_sort">전체 캐릭터</a>
							</li>
							<c:forEach items="${categoryMenu[4]}" var="menu">
							<li>
								<a href="javascript:sortList()" class="link_sort">${empty(menu.ctSeq) ? '전체 캐릭터' : menu.ctName}</a>
							</li>
							</c:forEach>
						</ul>
					</div>
				</div>
				</c:if>
				<div class="opt_sort opt_product">
					<strong class="screen_out">상품 정렬 선택</strong>
					<a href="#none" class="link_selected">
						<span class="txt_sort txt_order">${productRequest.sort.name}</span>
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
		<ul class="list_product">
			<c:forEach items="${productExpansions}" var="productExpansion" varStatus="status">
				<c:choose>
					<c:when test="${productExpansion.product.prCode eq '9791196121303' and today <= 201707092359}">
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
</div>
<script>
    function sortList(){
        var sortQuery = getSortQuery();
        var filterQuery = getFilterQuery();
        var characterQuery = getCharacterQuery();

        <c:set value="${queryString.replaceAll('(&)?sort=[A-Z,a-z,_]*','').replaceAll('(&)?filter=[A-Z,a-z,_]*','').replaceAll('(&)?requestCharacter=[A-Z,a-z,_,0-9]*','')}" var="query"/>
        if(filterQuery == ""){
            window.location.href = "${requestPath}" + "?"+ "${query}" + "${empty(query) ? '' : '&'}" + characterQuery + "&" + sortQuery;
        }else{
            window.location.href = "${requestPath}" + "?"+ "${query}" + "${empty(query) ? '' : '&'}" + characterQuery + "&" + sortQuery + "&" + filterQuery;
        }
    }

    $("#checkDelivery").change( function () {
        sortList();
    });

    function getCharacterQuery() {
        var sortName = $("#characterText").text();

        if(sortName.trim() == "전체 캐릭터") return "requestCharacter=";
        if(sortName.trim() == "라이언") return "requestCharacter=23";
        if(sortName.trim() == "무지") return "requestCharacter=5";
        if(sortName.trim() == "어피치") return "requestCharacter=6";
        if(sortName.trim() == "프로도") return "requestCharacter=7";
        if(sortName.trim() == "네오") return "requestCharacter=8";
        if(sortName.trim() == "튜브") return "requestCharacter=9";
        if(sortName.trim() == "제이지") return "requestCharacter=10";
        if(sortName.trim() == "콘") return "requestCharacter=11";


    }

    function getSortQuery() {
        var sortName = $("span.txt_order").text();

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