<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="si" uri="http://www.kakaofriends.com/si" %>
<div id="mArticle">
	<div class="cont_product">
		<div class="menu_tab">
			<ul class="tab_nav">
				<!-- 탭 메뉴 활성화시 li에 on클래스 부여 및 선택됨 대체텍스트 제공 -->
				<li>
					<a href="/en/mypage/orderlist" class="link_tab">Order List</a>
				</li>
				<li class="on">
					<a href="/en/mypage/wishlist" class="link_tab">Wish List <span class="screen_out">selected</span></a>
				</li>
				<li>
					<a href="/en/mypage/cancellist" class="link_tab">Returns</a>
				</li>
				<li>
					<a href="/en/mypage/pointlist" class="link_tab">Point</a>
				</li>
				<li>
					<a href="/en/mypage/couponlist" class="link_tab">Coupon</a>
				</li>
				<li>
					<a href="/en/mypage/onetoone" class="link_tab">Contact Us</a>
				</li>
				<li>
					<a href="/en/mypage/myinfo" class="link_tab">Account</a>
				</li>
			</ul>
		</div>

		<h3 class="screen_out">wish list</h3>
		<c:if test="${empty(wishlist)}">
		<p class="desc_nodata">There are no items in your wish list.</p>
		</c:if>
		<c:if test="${!empty(wishlist)}">
		<p class="desc_total">Total <em class="emph_total">${totalCount}</em> results have been inquired</p>
		<ul class="list_product">
			<form id="frm" name="frm" method="post">
				<input type="hidden" id="prCode" name="prCode">
				<input type="hidden" id="prCodes" name="prCodes">
				<input type="hidden" id="prEa" name="prEa">
				<input type="hidden" id="prEas" name="prEas">
				<input type="hidden" id="ctSeq" name="ctSeq">
				<input type="hidden" id="bsSeq" name="bsSeq">
				<input type="hidden" id="isGiftBag" name="isGiftBag">
				<input type="hidden" id="displayGoodsId" name="displayGoodsId">
				<input type="hidden" name="_csrf" value="${_csrf.token}"/>
				<input type="hidden" name="_csrf_header" value="${_csrf.headerName}"/>
			</form>
			<c:forEach items="${wishlist}" var="wish">
			<li>
				<c:choose>
					<c:when test="${wish.wishlistInProduct.prKrview eq 'N'}">
						<a href="#none" class="link_product">
					</c:when>
					<c:otherwise>
						<a href="/en/products/${wish.wishlist.displayGoodsId}" class="link_product">
					</c:otherwise>
				</c:choose>
					<span class="wrap_thumb">
						<%--<img src="${kakaoFriendsCdn.product}/${empty wish.wishlistInProduct.prImage12 ? wish.wishlistInProduct.prImage1 : wish.wishlistInProduct.prImage12}" class="thumb_g" alt="">--%>
						<si:tenthImageTag type="product" imageName="${wish.wishlistInProduct.prImage1}" altVal=""/>
					</span>
					<strong class="tit_product">
						<c:choose>
							<c:when test="${wish.wishlistInProduct.prKrview eq 'N'}">
								<span class='state_soldout'>[Unavailable]&nbsp;</span>
							</c:when>
							<c:when test="${wish.isSoldOut}">
								<span class='state_soldout'>[Sold out]&nbsp;</span>
							</c:when>
						</c:choose>${empty wish.wishlistInProduct.prName1 ? wish.wishlistInProduct.prName : wish.wishlistInProduct.prName1}
					</strong>
					<c:if test="${!wish.isDiscountPeriod}">
						<em class="emph_price">
							<span class="screen_out">Price</span><span class="current_price"><fmt:formatNumber value="${wish.productLevelPrice.prlpSaleprice1}" type="number"/> KRW <span class="usd_price">(<fmt:formatNumber value="${wish.productLevelPrice.exchangePrice}" type="number"/> USD)</span></span><!-- 2017-06-16 수정 -->
						</em>
					</c:if>
					<c:if test="${wish.isDiscountPeriod}">
						<em class="emph_price">
							<span class="screen_out">Sale Price</span><span class="current_price"><fmt:formatNumber value="${wish.productLevelPrice.prlpDiscountprice1}" type="number"/> KRW <span class="usd_price">(<fmt:formatNumber value="${wish.productLevelPrice.exchangeDiscountPrice}" type="number"/> USD)</span></span><!-- 2017-06-16 수정 -->
							<span class="screen_out">Price</span><span class="prev_price"><fmt:formatNumber value="${wish.productLevelPrice.prlpSaleprice1}" type="number"/> KRW <span class="usd_price">(<fmt:formatNumber value="${wish.productLevelPrice.exchangePrice}" type="number"/> USD)</span></span><!-- 2017-06-16 수정 -->
						</em>
					</c:if>
				</a>
				<div class="util_btn">
					<c:choose>
						<c:when test="${empty wish.wishlist.displayGoodsId}">
							<span class="wrap_btn"><button type="button" class="btn_g btn_dimmed" disabled>Add to Cart</button></span>
						</c:when>
						<c:otherwise>
							<span class="wrap_btn">
								<c:choose>
									<c:when test="${not empty (wish.wishlist.wsPrCode) || wish.wishlistInProduct.prKrview eq 'N'}">
										<button type="button" class="btn_g btn_addBasket ${(wish.wishlistInProduct.prKrview eq 'N') or (empty wish.wishlist.wsPrCode) ? 'btn_dimmed' : ''}" value="${wish.wishlist.wsPrCode}" ${(wish.wishlistInProduct.prKrview eq 'N') or (empty wish.wishlist.wsPrCode)? 'disabled' : ''} data-isgiftbag="${wish.isGiftBag}" data-displaygoodsid="${wish.wishlist.displayGoodsId}" data-ctseq="${wish.wishlist.wsCtseq}">Add to Cart</button>
									</c:when>
									<c:otherwise>
										<a href="/en/products/${wish.wishlist.displayGoodsId}" class="btn_g btn_addBasket">Add to Cart</a>
									</c:otherwise>
								</c:choose>
							</span>
						</c:otherwise>
					</c:choose>

					<c:choose>
						<c:when test="${wish.isGiftBag or wish.isSoldOut}">
							<span class="wrap_btn"><button type="button" class="btn_g btn_doOrder btn_dimmed" disabled>Check out</button></span>
						</c:when>
						<c:otherwise>
							<span class="wrap_btn">
								<c:choose>
									<c:when test="${not empty (wish.wishlist.wsPrCode) || wish.wishlistInProduct.prKrview eq 'N'}">
										<button type="button" class="btn_g btn_doOrder ${(wish.wishlistInProduct.prKrview eq 'N') or (empty wish.wishlist.wsPrCode) ? 'btn_dimmed' : ''}" value="${wish.wishlist.wsPrCode}" ${(wish.wishlistInProduct.prKrview eq 'N') or (empty wish.wishlist.wsPrCode) ? 'disabled' : ''} data-isgiftbag="${wish.isGiftBag}" data-displaygoodsid="${wish.wishlist.displayGoodsId}" data-ctseq="${wish.wishlist.wsCtseq}">Check out</button>
									</c:when>
									<c:otherwise>
										<a href="/en/products/${wish.wishlist.displayGoodsId}" class="btn_g btn_doOrder">Check out</a>
									</c:otherwise>
								</c:choose>
							</span>
						</c:otherwise>
					</c:choose>
				</div>
				<button type="button" class="btn_delete" value="${wish.wishlist.displayGoodsId}"><span class="ico_newfriends_v1 ico_delete">delete product</span></button>
			</li>
			</c:forEach>
		</ul>
		<tiles:insertTemplate template="/WEB-INF/templates/en/sub/paging.jsp" flush="true"/>
		</c:if>
	</div>
</div>
<script type="text/javascript">
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

	$(function() {
		$(".btn_delete").on("click", function () {
			$("#displayGoodsId").val(this.value);
			$("#frm").attr("action", "/en/mypage/wishlist/delete");
			$("#frm").submit();
		});
		$(".btn_addBasket").on("click", function () {
			$("#prCode").val(this.value);
            $("#displayGoodsId").val($(this).data().displaygoodsid);
			$("#prEa").val(1);
			$("#ctSeq").val($(this).data().ctseq);
            $("#frm").attr("action", "/en/basket/basket/insert/" + $(this).data().displaygoodsid + "/" + this.value);
            $("#frm").attr("method", "get");
			$("#frm").submit();
		});
		$(".btn_doOrder").on("click", function () {
            $("#prCode").val(this.value);
			$("#prCodes").val(this.value);
            $("#displayGoodsId").val($(this).data().displaygoodsid);
            $("#prEa").val(1);
			$("#prEas").val(1);
			$("#ctSeq").val($(this).data().ctseq);
            $("#isGiftBag").val($(this).data().isgiftbag);

            directBeforeInsertBasket();
		});
	});

    //directsheet 가기 전 장바구니에 insert 후 이동 2018.01.30 layla
    function directBeforeInsertBasket(){
        var formData = $("#frm").serialize();

        $.ajax({
            headers: {'X-CSRF-TOKEN': '${_csrf.token}'},
            url: "/en/basket/basket/directInsert",
            type: "POST",
            dataType: "json",
            data: formData,
            async:false,
            error: function () {
                alertNoti('error.occurred');
                return false;
            },
            success: function (data) {
                if (data != null) {
                    $("#bsSeq").val(data.bsSeq);
                    $("#frm").attr("action", "/en/order/directsheet");
                    $("#frm").submit();
                    return false;
                }
                alertNoti('error.occurred');
            }
        });
    }
</script>