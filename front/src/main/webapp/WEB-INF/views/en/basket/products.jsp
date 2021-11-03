<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="si" uri="http://www.kakaofriends.com/si" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:eval expression="@environment['deploy.version']" var="deployVersion"/>

<%--<div class="banner_page">--%>
	<%--<sec:authorize access="isAnonymous()">--%>
		<%--&lt;%&ndash;비회원&ndash;%&gt;--%>
		<%--<a href="https://store.kakaofriends.com/en/promotions/promotion/204" class="nomember">--%>
			<%--지금 1000P 즉시 지금! 포인트 2배 적립!--%>
		<%--</a>--%>
	<%--</sec:authorize>--%>
	<%--<sec:authorize access="isAuthenticated()">--%>
		<%--&lt;%&ndash;회원&ndash;%&gt;--%>
		<%--<a href="https://store.kakaofriends.com/en/promotions/promotion/204" class="member">--%>
			<%--지금 구매하고 포인트 2배 6% 적립받자!--%>
		<%--</a>--%>
	<%--</sec:authorize>--%>

	<%--<button class="banner_close">닫기</button>--%>
<%--</div>--%>

<div id="mArticle">
	<c:if test="${empty(basketExpansions)}">
		<div id="cont_nodate">
			<div class="info_basket">
				<p class="desc_total">Total <em class="emph_total">${fn:length(basketExpansions)}</em> results.</p>
				<p class="desc_nodata">There is no shopping cart</p>
			</div>
			<div class="continue_btn">
				<a href="/en/index" class="btn_basket btn_continue"><span class="txt_g">Go Home</span></a>
			</div>
			<div class="basket_btn basket_empty">
				<div class="inner_basket">
					<div class="buy_btn">
						<a href="/en/index" class="btn_basket btn_continue"><span class="txt_g">Check out</span></a>
					</div>
				</div>
			</div>
		</div>
	</c:if>
	<c:if test="${!empty(basketExpansions)}">
		<form id="frm" name="frm" action="/en/order/sheet" method="post">
			<input type="hidden" name="_csrf" value="${_csrf.token}"/>
			<input type="hidden" name="_csrf_header" value="${_csrf.headerName}"/>
			<input type="hidden" name="oaCountryName" id="countryName" value="${oaCountryName}"/>
			<input type="hidden" name="basketProductEa" value="${basketProductEa}"/>
			<input type="hidden" name="prCode" id="prCode" value=""/>
			<input type="hidden" name="displayGoodsId" id="displayGoodsId" value=""/>
			<input type="hidden" name="prEa" id="prEa" value=""/>
			<input type="hidden" name="ctSeq" id="ctSeq" value=""/>
			<input type="hidden" name="checkBoxFlags" id="checkBoxFlags" />
			<input type="hidden" name="bsSeq" id="bsSeq" value=""/>
			<fieldset>
				<legend class="screen_out">Shopping Cart Order Form</legend>

				<div class="info_basket">
					<p class="desc_total">Total <em class="emph_total">${fn:length(basketExpansions)}</em> results.</p>
					<span class="chk_g choice_all">
						<input type="checkbox" id="checkAll" class="inp_g" checked>
						<label for="checkAll" class="lab_g">
							<span class="ico_friends ico_check"></span>
							Select All
						</label>
					</span>
					<button type="button" class="btn_del">Delete Selection</button>

					<ul data-select-group class="list_basket list_option">
						<c:forEach items="${basketExpansions}" var="basketExpansion">
							<c:choose>
								<%--해외 배송 불가 상품--%>
								<c:when test="${(not empty oaCountryName and oaCountryName ne 'Korea') and basketExpansion.basketInProduct.prForeigndeliyn == 'N'}">
									<li class="item_soldout">
										<div class="basket_info">
											<strong class="txt_soldout"><span class="ico_friends ico_noglobal"></span>This product is not eligible for global shipping.</strong> <!-- 해외배송불가 상품 ico_noglobal 클래스 추가 -->
											<span class="chk_g choice_basket">
												<input type="checkbox" id="checkCart_${basketExpansion.basket.bsSeq}" name="prCodes" class="inp_g" value="${basketExpansion.basket.bsPrCode}" disabled>
												<label for="checkCart_${basketExpansion.basket.bsSeq}" class="lab_g">
													<span class="ico_friends ico_check"></span>
													<span class="screen_out">${empty basketExpansion.basketInProduct.prName1 ? basketExpansion.basketInProduct.prName : basketExpansion.basketInProduct.prName1}</span>
												</label>
												<input type="hidden" name="isGiftBag" value="${basketExpansion.isGiftBag}">
												<input type="hidden" name="bsSeq" value="${basketExpansion.basket.bsSeq}">
											</span>
											<a href="/en/products/${basketExpansion.basket.displayGoodsId}" class="link_thumb">
												<img src="${kakaoFriendsCdn.product}/${empty basketExpansion.basketInProduct.prImage12 ? basketExpansion.basketInProduct.prImage1 : basketExpansion.basketInProduct.prImage12}" class="thumb_g" alt="${empty basketExpansion.basketInProduct.prName1 ? basketExpansion.basketInProduct.prName : basketExpansion.basketInProduct.prName1}">
											</a>
											<div class="desc_basket">
												<strong class="tit_product"><a href="/kr/products/${basketExpansion.basket.displayGoodsId}" class="link_product">${empty basketExpansion.basketInProduct.prName1 ? basketExpansion.basketInProduct.prName : basketExpansion.basketInProduct.prName1}</a></strong>
												<ul class="list_append">
													<li>
														<em class="tit_append">Price :</em>
														<span class="desc_append"><!-- 2017-06-16 추가 -->
														<c:if test="${!basketExpansion.isDiscountPeriod}">
															<span class="screen_out">Price</span><span class="current_price"><fmt:formatNumber value="${basketExpansion.productLevelPrice.prlpSaleprice1}" type="number"/>KRW <span class="usd_price">(<fmt:formatNumber value="${basketExpansion.productLevelPrice.exchangePrice}" type="number"/> USD)</span></span><!-- 2017-06-16 수정 -->
															<input type="hidden" class="inp_price" value="${basketExpansion.productLevelPrice.prlpSaleprice1}">
														</c:if>
														<c:if test="${basketExpansion.isDiscountPeriod}">
															<span class="screen_out">Sale Price</span><span class="current_price"><fmt:formatNumber value="${basketExpansion.productLevelPrice.prlpDiscountprice1}" type="number"/>KRW <span class="usd_price">(<fmt:formatNumber value="${basketExpansion.productLevelPrice.exchangeDiscountPrice}" type="number"/> USD)</span></span><!-- 2017-06-16 수정 -->
															<span class="screen_out">Price</span><span class="prev_price"><fmt:formatNumber value="${basketExpansion.productLevelPrice.prlpSaleprice1}" type="number"/>KRW <span class="usd_price">(<fmt:formatNumber value="${basketExpansion.productLevelPrice.exchangePrice}" type="number"/> USD)</span></span><!-- 2017-06-16 수정 -->
															<input type="hidden" class="inp_price" value="${basketExpansion.productLevelPrice.prlpDiscountprice1}">
														</c:if>
														</span>
													</li>
													<li><em class="tit_append">Option :</em>${basketExpansion.goodsOptionTitle.nameEn}</li>
												</ul>
												<%-- pay only markup sample --%>
												<c:if test="${fn:contains(payOnlyPrcodeSet, basketExpansion.basket.bsPrCode)}">
													<p class="txt_pay_only">You can buy exclusive products only.                                                    </p>
												</c:if>
											</div>
											<button type="button" class="link_delete" value="${basketExpansion.basket.bsSeq}"><span class="ico_friends ico_delete">delete</span></button>
										</div>
									</li>
								</c:when>
								<%--판매 하지 않는 상품--%>
								<c:when test="${(basketExpansion.basketInProduct.prKrview eq 'N') or (basketExpansion.displayGoodsKrView eq 'N')}">
									<li class="item_soldout">
										<div class="basket_info">
											<strong class="txt_soldout"><span class="ico_friends ico_soldout"></span>Unavailable</strong>
											<span class="chk_g choice_basket">
												<input type="checkbox" id="checkCart_${basketExpansion.basket.bsSeq}" name="prCodes" class="inp_g" value="${basketExpansion.basket.bsPrCode}" disabled>
												<label for="checkCart_${basketExpansion.basket.bsSeq}" class="lab_g">
													<span class="ico_friends ico_check"></span>
													<span class="screen_out">${empty basketExpansion.basketInProduct.prName1 ? basketExpansion.basketInProduct.prName : basketExpansion.basketInProduct.prName1}</span>
												</label>
												<input type="hidden" name="isGiftBag" value="${basketExpansion.isGiftBag}">
												<input type="hidden" name="bsSeq" value="${basketExpansion.basket.bsSeq}">
											</span>
											<a href="#none" class="link_thumb">
												<si:tenthImageTag type="product" imageName="${basketExpansion.basketInProduct.prImage1}" altVal="${empty basketExpansion.basketInProduct.prName1 ? basketExpansion.basketInProduct.prName : basketExpansion.basketInProduct.prName1}"/>
											</a>
											<div class="desc_basket">
												<strong class="tit_product"><a href="#none" class="link_product">${empty basketExpansion.basketInProduct.prName1 ? basketExpansion.basketInProduct.prName : basketExpansion.basketInProduct.prName1}</a></strong>
												<ul class="list_append">
													<li>
														<em class="tit_append">Price :</em>
														<span class="desc_append"><!-- 2017-06-16 추가 -->
														<c:if test="${!basketExpansion.isDiscountPeriod}">
															<span class="screen_out">Price</span><span class="current_price"><fmt:formatNumber value="${basketExpansion.productLevelPrice.prlpSaleprice1}" type="number"/>KRW <span class="usd_price">(<fmt:formatNumber value="${basketExpansion.productLevelPrice.exchangePrice}" type="number"/> USD)</span></span><!-- 2017-06-16 수정 -->
														</c:if>
														<c:if test="${basketExpansion.isDiscountPeriod}">
															<span class="screen_out">Sale Price</span><span class="current_price"><fmt:formatNumber value="${basketExpansion.productLevelPrice.prlpDiscountprice1}" type="number"/>KRW <span class="usd_price">(<fmt:formatNumber value="${basketExpansion.productLevelPrice.exchangeDiscountPrice}" type="number"/> USD)</span></span><!-- 2017-06-16 수정 -->
															<span class="screen_out">Price</span><span class="prev_price"><fmt:formatNumber value="${basketExpansion.productLevelPrice.prlpSaleprice1}" type="number"/>KRW <span class="usd_price">(<fmt:formatNumber value="${basketExpansion.productLevelPrice.exchangePrice}" type="number"/> USD)</span></span><!-- 2017-06-16 수정 -->
														</c:if>
														</span>
													</li>
													<li><em class="tit_append">Option :</em>${basketExpansion.goodsOptionTitle.nameEn}</li>
												</ul>
                                                <%-- pay only markup sample --%>
												<c:if test="${fn:contains(payOnlyPrcodeSet, basketExpansion.basket.bsPrCode)}">
													<p class="txt_pay_only">You can buy exclusive products only.</p>
												</c:if>
											</div>
											<button type="button" class="link_delete" value="${basketExpansion.basket.bsSeq}"><span class="ico_friends ico_delete">delete</span></button>
										</div>
									</li>
								</c:when>
								<%-- 커스텀 상시 판매 상품, 이벤트 상품(마카롱) --%>
								<c:when test="${basketExpansion.isCustomProduct or basketExpansion.isEventProduct}">
									<li class="item_soldout">
										<div class="basket_info">
											<strong class="txt_soldout"><span class="ico_friends ico_soldout"></span>Only direct purchase</strong>
											<span class="chk_g choice_basket">
												<input type="checkbox" id="checkCart_${basketExpansion.basket.bsSeq}" name="prCodes" class="inp_g" value="${basketExpansion.basket.bsPrCode}" disabled>
												<label for="checkCart_${basketExpansion.basket.bsSeq}" class="lab_g">
													<span class="ico_friends ico_check"></span>
													<span class="screen_out">${empty basketExpansion.basketInProduct.prName1 ? basketExpansion.basketInProduct.prName : basketExpansion.basketInProduct.prName1}</span>
												</label>
												<input type="hidden" name="isGiftBag" value="${basketExpansion.isGiftBag}">
												<input type="hidden" name="bsSeq" value="${basketExpansion.basket.bsSeq}">
											</span>
											<a href="#none" class="link_thumb">
													<%--<img src="${kakaoFriendsCdn.product}/${empty basketExpansion.basketInProduct.prImage12 ? basketExpansion.basketInProduct.prImage1 : basketExpansion.basketInProduct.prImage12}" class="thumb_g" alt="${empty basketExpansion.basketInProduct.prName1 ? basketExpansion.basketInProduct.prName : basketExpansion.basketInProduct.prName1}">--%>
												<si:tenthImageTag type="product" imageName="${basketExpansion.basketInProduct.prImage1}" altVal="${empty basketExpansion.basketInProduct.prName1 ? basketExpansion.basketInProduct.prName : basketExpansion.basketInProduct.prName1}"/>
											</a>
											<div class="desc_basket">
												<strong class="tit_product"><a href="/en/products/${basketExpansion.basket.displayGoodsId}" class="link_product">${empty basketExpansion.basketInProduct.prName1 ? basketExpansion.basketInProduct.prName : basketExpansion.basketInProduct.prName1}</a></strong>
												<ul class="list_append">
													<li>
														<em class="tit_append">Price :</em>
														<span class="desc_append"><!-- 2017-06-16 추가 -->
														<c:if test="${!basketExpansion.isDiscountPeriod}">
															<span class="screen_out">Price</span><span class="current_price"><fmt:formatNumber value="${basketExpansion.productLevelPrice.prlpSaleprice1}" type="number"/>KRW <span class="usd_price">(<fmt:formatNumber value="${basketExpansion.productLevelPrice.exchangePrice}" type="number"/> USD)</span></span><!-- 2017-06-16 수정 -->
														</c:if>
														<c:if test="${basketExpansion.isDiscountPeriod}">
															<span class="screen_out">Sale Price</span><span class="current_price"><fmt:formatNumber value="${basketExpansion.productLevelPrice.prlpDiscountprice1}" type="number"/>KRW <span class="usd_price">(<fmt:formatNumber value="${basketExpansion.productLevelPrice.exchangeDiscountPrice}" type="number"/> USD)</span></span><!-- 2017-06-16 수정 -->
															<span class="screen_out">Price</span><span class="prev_price"><fmt:formatNumber value="${basketExpansion.productLevelPrice.prlpSaleprice1}" type="number"/>KRW <span class="usd_price">(<fmt:formatNumber value="${basketExpansion.productLevelPrice.exchangePrice}" type="number"/> USD)</span></span><!-- 2017-06-16 수정 -->
														</c:if>
														</span>
													</li>
													<li><em class="tit_append">Option :</em>${basketExpansion.goodsOptionTitle.nameEn}</li>
												</ul>
                                                <%-- pay only markup sample --%>
												<c:if test="${fn:contains(payOnlyPrcodeSet, basketExpansion.basket.bsPrCode)}">
													<p class="txt_pay_only">You can buy exclusive products only.</p>
												</c:if>
											</div>
											<button type="button" class="link_delete" value="${basketExpansion.basket.bsSeq}"><span class="ico_friends ico_delete">delete</span></button>
										</div>
									</li>
								</c:when>
								<c:otherwise>
									<c:choose>
										<%--재고 없는 상품--%>
										<c:when test="${basketExpansion.isSoldOut}">
											<li class="item_soldout">
												<div class="basket_info">
													<strong class="txt_soldout"><span class="ico_friends ico_soldout"></span>Out of stock</strong>
													<span class="chk_g choice_basket">
														<input type="checkbox" id="checkCart_${basketExpansion.basket.bsSeq}" name="prCodes" class="inp_g" value="${basketExpansion.basket.bsPrCode}" disabled>
														<label for="checkCart_${basketExpansion.basket.bsSeq}" class="lab_g">
															<span class="ico_friends ico_check"></span>
															<span class="screen_out">${empty basketExpansion.basketInProduct.prName1 ? basketExpansion.basketInProduct.prName : basketExpansion.basketInProduct.prName1}</span>
														</label>
														<input type="hidden" name="isGiftBag" value="${basketExpansion.isGiftBag}">
														<input type="hidden" name="bsSeq" value="${basketExpansion.basket.bsSeq}">
													</span>
													<a href="#none" class="link_thumb">
															<%--<img src="${kakaoFriendsCdn.product}/${empty basketExpansion.basketInProduct.prImage12 ? basketExpansion.basketInProduct.prImage1 : basketExpansion.basketInProduct.prImage12}" class="thumb_g" alt="${empty basketExpansion.basketInProduct.prName1 ? basketExpansion.basketInProduct.prName : basketExpansion.basketInProduct.prName1}">--%>
														<si:tenthImageTag type="product" imageName="${basketExpansion.basketInProduct.prImage1}" altVal="${empty basketExpansion.basketInProduct.prName1 ? basketExpansion.basketInProduct.prName : basketExpansion.basketInProduct.prName1}"/>
													</a>
													<div class="desc_basket">
														<strong class="tit_product"><a href="/en/products/${basketExpansion.basket.displayGoodsId}" class="link_product">${empty basketExpansion.basketInProduct.prName1 ? basketExpansion.basketInProduct.prName : basketExpansion.basketInProduct.prName1}</a></strong>
														<ul class="list_append">
															<li>
																<em class="tit_append">Price :</em>
																<span class="desc_append"><!-- 2017-06-16 추가 -->
																<c:if test="${!basketExpansion.isDiscountPeriod}">
																	<span class="screen_out">Price</span><span class="current_price"><fmt:formatNumber value="${basketExpansion.productLevelPrice.prlpSaleprice1}" type="number"/>KRW <span class="usd_price">(<fmt:formatNumber value="${basketExpansion.productLevelPrice.exchangePrice}" type="number"/> USD)</span></span><!-- 2017-06-16 수정 -->
																</c:if>
																<c:if test="${basketExpansion.isDiscountPeriod}">
																	<span class="screen_out">Sale Price</span><span class="current_price"><fmt:formatNumber value="${basketExpansion.productLevelPrice.prlpDiscountprice1}" type="number"/>KRW <span class="usd_price">(<fmt:formatNumber value="${basketExpansion.productLevelPrice.exchangeDiscountPrice}" type="number"/> USD)</span></span><!-- 2017-06-16 수정 -->
																	<span class="screen_out">Price</span><span class="prev_price"><fmt:formatNumber value="${basketExpansion.productLevelPrice.prlpSaleprice1}" type="number"/>KRW <span class="usd_price">(<fmt:formatNumber value="${basketExpansion.productLevelPrice.exchangePrice}" type="number"/> USD)</span></span><!-- 2017-06-16 수정 -->
																</c:if>
																</span>
															</li>
															<li><em class="tit_append">Option :</em>${basketExpansion.goodsOptionTitle.nameEn}</li>
														</ul>
                                                        <%-- pay only markup sample --%>
														<c:if test="${fn:contains(payOnlyPrcodeSet, basketExpansion.basket.bsPrCode)}">
															<p class="txt_pay_only">You can buy exclusive products only.</p>
														</c:if>
													</div>
													<button type="button" class="link_delete" value="${basketExpansion.basket.bsSeq}"><span class="ico_friends ico_delete">delete</span></button>
												</div>
											</li>
										</c:when>
										<c:otherwise>
											<c:choose>
												<%--기프트 백--%>
												<c:when test="${basketExpansion.isGiftBag}">
													<li class="check_on">
														<input type="hidden" name="displayGoodsIds" value="${basketExpansion.basket.displayGoodsId}">
														<div class="basket_info">
															<strong class="txt_giftbag"><span class="ico_friends ico_giftbag"></span>The Gift Bag cannot be purchased separately.</strong>
															<c:if test="${basketExpansion.basket.bsEa > basketExpansion.stEa}">
																<strong class="txt_soldout txt_lack"><span class="ico_friends ico_soldout"></span>We don’t have enough stock</strong>
															</c:if>
															<span class="choice_g choice_basket">
																<input type="checkbox" id="checkCart_${basketExpansion.basket.bsSeq}" name="prCodes" class="inp_g" value="${basketExpansion.basket.bsPrCode}" checked>
																<label for="checkCart_${basketExpansion.basket.bsSeq}" class="lab_g">
																	<span class="ico_friends ico_check"></span>
																	<span class="screen_out">${empty basketExpansion.basketInProduct.prName1 ? basketExpansion.basketInProduct.prName : basketExpansion.basketInProduct.prName1}</span>
																</label>
																<input type="hidden" name="isGiftBag" value="${basketExpansion.isGiftBag}">
																<input type="hidden" name="bsSeq" value="${basketExpansion.basket.bsSeq}">
															</span>
															<a href="/en/products/${basketExpansion.basket.displayGoodsId}" class="link_thumb">
																<si:tenthImageTag type="product" imageName="${basketExpansion.basketInProduct.prImage1}" altVal="${basketExpansion.basketInProduct.prName}"/>
															</a>
															<div class="desc_basket">
																<strong class="tit_product"><a href="/en/products/${basketExpansion.basket.displayGoodsId}" class="link_product">${empty basketExpansion.basketInProduct.prName1 ? basketExpansion.basketInProduct.prName : basketExpansion.basketInProduct.prName1}</a></strong>
																<ul class="list_append">
																	<li>
																		<em class="tit_append">Price :</em>
																		<span class="desc_append"><!-- 2017-06-16 추가 -->
																		<c:if test="${!basketExpansion.isDiscountPeriod}">
																			<span class="screen_out">Price</span><span class="current_price"><fmt:formatNumber value="${basketExpansion.productLevelPrice.prlpSaleprice1}" type="number"/>KRW <span class="usd_price">(<fmt:formatNumber value="${basketExpansion.productLevelPrice.exchangePrice}" type="number"/> USD)</span></span><!-- 2017-06-16 수정 -->
																			<input type="hidden" class="inp_price" value="${basketExpansion.productLevelPrice.prlpSaleprice1}">
																		</c:if>
																		<c:if test="${basketExpansion.isDiscountPeriod}">
																			<span class="screen_out">Sale Price</span><span class="current_price"><fmt:formatNumber value="${basketExpansion.productLevelPrice.prlpDiscountprice1}" type="number"/>KRW <span class="usd_price">(<fmt:formatNumber value="${basketExpansion.productLevelPrice.exchangeDiscountPrice}" type="number"/> USD)</span></span><!-- 2017-06-16 수정 -->
																			<span class="screen_out">Price</span><span class="prev_price"><fmt:formatNumber value="${basketExpansion.productLevelPrice.prlpSaleprice1}" type="number"/>KRW <span class="usd_price">(<fmt:formatNumber value="${basketExpansion.productLevelPrice.exchangePrice}" type="number"/> USD)</span></span><!-- 2017-06-16 수정 -->
																			<input type="hidden" class="inp_price" value="${basketExpansion.productLevelPrice.prlpDiscountprice1}">
																		</c:if>
																		</span>
																	</li>
																	<li><em class="tit_append">Option :</em>${basketExpansion.goodsOptionTitle.nameEn}</li>
																	<li><em class="tit_append">Quantity :</em>${basketExpansion.basket.bsEa}</li>
																</ul>
                                                                <%-- pay only markup sample --%>
																<c:if test="${fn:contains(payOnlyPrcodeSet, basketExpansion.basket.bsPrCode)}">
																	<p class="txt_pay_only">You can buy exclusive products only.</p>
																</c:if>
															</div>
															<button type="button" class="btn_option">Change Option<span class="ico_newfriends_v1 ico_arrow">open</span></button><!-- 'open' 후 'close'로 텍스트 수정 -->
															<button type="button" class="link_delete" value="${basketExpansion.basket.bsSeq}"><span class="ico_friends ico_delete">delete</span></button>
														</div>

														<div class="basket_option" style="display: none;" data-qty="${basketExpansion.basket.bsEa}">
															<div class="option_info">
																<span class="box_quantity">
																	<input type="hidden" name="_bsea" value="${basketExpansion.basket.bsEa}"/>
																	<label class="screen_out" for="prEa_${basketExpansion.basket.displayGoodsId}">Quantity</label>
																	<input type="text" id="prEa_${basketExpansion.basket.displayGoodsId}" class="inp_quantity giftbag_bsEa" name="prEas" value="${basketExpansion.basket.bsEa}">
																	<button type="button" class="btn_g btn_minus"><span class="ico_newfriends_v1 ico_minus">minus</span></button>
																	<button type="button" class="btn_g btn_plus"><span class="ico_newfriends_v1 ico_plus">plus</span></button>
																</span>
																<span class="txt_price">
																	<span class="screen_out">Price</span>
																	<span class="num_price">
																		<em class="emph_g" data-price="${basketExpansion.productLevelPrice.prlpSaleprice1}"><fmt:formatNumber value="${basketExpansion.productLevelPrice.prlpSaleprice1}" type="number"/></em>KRW
																		<span class="usd_price" data-price="${basketExpansion.productLevelPrice.exchangePrice}">(<fmt:formatNumber value="${basketExpansion.productLevelPrice.exchangePrice}" type="number"/> USD)</span>
																	</span>
																</span>
															</div>
															<div class="option_btn">
																<button type="button" class="btn_basket btn_cancel"><span class="txt_g">Cancel</span></button>
																<button type="button" data-btn-change class="btn_basket btn_change2" value="${basketExpansion.basket.bsPrCode}" data-ctseq="${basketExpansion.basket.bsCtSeq}" data-goods-id="${basketExpansion.basket.displayGoodsId}">
																	<span class="txt_g">Change</span>
																</button>
															</div>
														</div>
													</li>
												</c:when>
												<c:otherwise>
													<li class="check_on">
														<input type="hidden" name="displayGoodsIds" value="${basketExpansion.basket.displayGoodsId}">
														<div class="basket_info">
															<c:if test="${(!empty oaCountryName) and (basketExpansion.basket.bsEa > basketExpansion.stEa)}">
																<strong class="txt_soldout txt_lack"><span class="ico_friends ico_soldout"></span>We don’t have enough stock</strong>
															</c:if>
															<span class="choice_g choice_basket">
																<input type="checkbox" id="checkCart_${basketExpansion.basket.bsSeq}" name="prCodes" class="inp_g" value="${basketExpansion.basket.bsPrCode}" checked>
																<label for="checkCart_${basketExpansion.basket.bsSeq}" class="lab_g">
																	<span class="ico_friends ico_check"></span>
																	<span class="screen_out">${empty basketExpansion.basketInProduct.prName1 ? basketExpansion.basketInProduct.prName : basketExpansion.basketInProduct.prName1}</span>
																</label>
																<input type="hidden" name="isGiftBag" value="${basketExpansion.isGiftBag}">
																<input type="hidden" name="bsSeq" value="${basketExpansion.basket.bsSeq}">
															</span>
															<a href="/en/products/${basketExpansion.basket.displayGoodsId}" class="link_thumb">
																<si:tenthImageTag type="product" imageName="${basketExpansion.basketInProduct.prImage1}" altVal="${empty basketExpansion.basketInProduct.prName1 ? basketExpansion.basketInProduct.prName : basketExpansion.basketInProduct.prName1}"/>
															</a>
															<div class="desc_basket">
																<strong class="tit_product"><a href="/en/products/${basketExpansion.basket.displayGoodsId}" class="link_product">${empty basketExpansion.basketInProduct.prName1 ? basketExpansion.basketInProduct.prName : basketExpansion.basketInProduct.prName1}</a></strong>
																<ul class="list_append">
																	<li>
																		<em class="tit_append">Price :</em>
																		<span class="desc_append"><!-- 2017-06-16 추가 -->
																		<c:if test="${!basketExpansion.isDiscountPeriod}">
																			<span class="screen_out">Price</span><span class="current_price"><fmt:formatNumber value="${basketExpansion.productLevelPrice.prlpSaleprice1}" type="number"/>KRW <span class="usd_price">(<fmt:formatNumber value="${basketExpansion.productLevelPrice.exchangePrice}" type="number"/> USD)</span></span><!-- 2017-06-16 수정 -->
																			<input type="hidden" class="inp_price" value="${basketExpansion.productLevelPrice.prlpSaleprice1}">
																		</c:if>
																		<c:if test="${basketExpansion.isDiscountPeriod}">
																			<span class="screen_out">Sale Price</span><span class="current_price"><fmt:formatNumber value="${basketExpansion.productLevelPrice.prlpDiscountprice1}" type="number"/>KRW <span class="usd_price">(<fmt:formatNumber value="${basketExpansion.productLevelPrice.exchangeDiscountPrice}" type="number"/> USD)</span></span><!-- 2017-06-16 수정 -->
																			<span class="screen_out">Price</span><span class="prev_price"><fmt:formatNumber value="${basketExpansion.productLevelPrice.prlpSaleprice1}" type="number"/>KRW <span class="usd_price">(<fmt:formatNumber value="${basketExpansion.productLevelPrice.exchangePrice}" type="number"/> USD)</span></span><!-- 2017-06-16 수정 -->
																			<input type="hidden" class="inp_price" value="${basketExpansion.productLevelPrice.prlpDiscountprice1}">
																		</c:if>
																		</span>
																	</li>
																	<li><em class="tit_append">Option :</em>${empty(basketExpansion.goodsOptionTitle.nameEn) ? '-' : basketExpansion.goodsOptionTitle.nameEn}</li>
																	<li><em class="tit_append">Quantity :</em>${basketExpansion.basket.bsEa}</li>
																</ul>
																<c:if test="${fn:contains(payOnlyPrcodeSet, basketExpansion.basket.bsPrCode)}">
																	<p class="txt_pay_only rw_show">You can buy exclusive products only.</p>
																</c:if>
															</div>
															<p class="section_btn">
																<button type="button" class="btn_option">옵션/수량 변경<span class="ico_newfriends_v1 ico_arrow">펼치기</span></button>
															</p>
															<button type="button" class="link_delete" value="${basketExpansion.basket.bsSeq}"><span class="ico_friends ico_delete">상품 삭제</span></button>
                                                             <%--pay only markup sample--%>
                                                            <c:if test="${fn:contains(payOnlyPrcodeSet, basketExpansion.basket.bsPrCode)}">
																<p class="txt_pay_only rw_hide">You can buy exclusive products only.</p>
                                                            </c:if>
														</div>

														<div class="basket_option" style="display: none;">
															<c:set var="isMainType" value="${basketExpansion.basket.addonType == 'M'}"></c:set>
															<c:set var="goodsList" value="${isMainType ? basketExpansion.displayGoodsGroup.mainGoodsList : basketExpansion.displayGoodsGroup.subGoodsList}"></c:set>
															<c:set var="goodsOptionList" value="${isMainType ? basketExpansion.displayGoodsGroup.mainGoodsOptionList : basketExpansion.displayGoodsGroup.subGoodsOptionList}"></c:set>
															<c:set var="goodsOptionTitleList" value="${isMainType ? basketExpansion.displayGoodsGroup.mainGoodsOptionTitleList : basketExpansion.displayGoodsGroup.subGoodsOptionTitleList}"></c:set>

															<c:if test="${basketExpansion.displayGoodsGroup.isHasOption && fn:length(goodsOptionTitleList) > 0}">
																<div class="option_select" data-bs-seq="${basketExpansion.basket.bsSeq}" data-options-length="${fn:length(goodsOptionTitleList)}">
																	<div class="opt_g opt_selected" data-id="0" data-display-goods-id="${goodsList[0].displayGoodsId}">
																		<strong class="screen_out">Select a ${goodsOptionTitleList[0].nameEn}</strong>
																		<a href="#none" class="link_selected" data-toggle>
																			<span class="txt_opt">${goodsOptionTitleList[0].nameEn}</span>
																			<span class="screen_out">selected</span>
																			<span class="ico_newfriends_v1 ico_opt"></span>
																		</a>
																		<div class="box_opt">
																			<em class="screen_out">select option</em>
																			<ul class="list_opt" style="display: none;">
																				<c:forEach items="${goodsOptionList}" var="option" varStatus="optionStatus">
																					<li>
																						<a href="#none" class="link_opt" data-value="${optionStatus.index}" data-id="${option.id}" data-goods-id="${option.goodsId}">
																							<span class="tit_option">${option.nameEn}</span>
																						</a>
																					</li>
																				</c:forEach>
																			</ul>
																		</div>
																	</div>

																	<c:if test="${fn:length(goodsOptionTitleList) == 2}">
																		<div class="opt_g opt_selected" style="display: none;" data-id="1" data-label="${goodsOptionTitleList[1].nameEn}">
																			<strong class="screen_out">Select a${goodsOptionTitleList[1].nameEn}</strong>
																			<a href="#none" class="link_selected" data-toggle>
																				<span class="txt_opt">${goodsOptionTitleList[1].nameEn}</span>
																				<span class="screen_out">selected</span>
																				<span class="ico_newfriends_v1 ico_opt"></span>
																			</a>
																			<div class="box_opt">
																				<em class="screen_out">select option</em>
																				<ul class="list_opt" style="display: none;"></ul>
																			</div>
																		</div>
																	</c:if>
																</div>
															</c:if>

															<div class="option_info">
																<span class="box_quantity">
																	<input type="hidden" name="_bsea" value="${basketExpansion.basket.bsEa}"/>
																	<label class="screen_out" for="prEa_${basketExpansion.basket.displayGoodsId}">Quantity</label>
																	<input type="text" id="prEa_${basketExpansion.basket.displayGoodsId}" class="inp_quantity" name="prEas" value="${basketExpansion.basket.bsEa}">
																	<button type="button" class="btn_g btn_minus"><span class="ico_newfriends_v1 ico_minus">minus</span></button>
																	<button type="button" class="btn_g btn_plus"><span class="ico_newfriends_v1 ico_plus">plus</span></button>
																</span>
																<span class="txt_price">
																	<span class="screen_out">Price</span>
																	<span class="num_price">
																		<em class="emph_g" data-price="${basketExpansion.productLevelPrice.prlpSaleprice1}"><fmt:formatNumber value="${basketExpansion.productLevelPrice.prlpSaleprice1}" type="number"/></em>KRW
																		<span class="usd_price" data-price="${basketExpansion.productLevelPrice.exchangePrice}">(<fmt:formatNumber value="${basketExpansion.productLevelPrice.exchangePrice}" type="number"/> USD)</span>
																	</span>
																</span>
															</div>
															<div class="option_btn">
																<button type="button" class="btn_basket btn_cancel"><span class="txt_g">Cancel</span></button>
																<button type="button" data-btn-change class="btn_basket btn_change2" value="${basketExpansion.basket.bsPrCode}" data-ctseq="${basketExpansion.basket.bsCtSeq}" data-goods-id="${basketExpansion.basket.displayGoodsId}">
																	<span class="txt_g">Change</span>
																</button>
															</div>
														</div>
													</li>
												</c:otherwise>
											</c:choose>
										</c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</ul>
				</div>

				<div class="info_price">
					<dl class="list_price">
						<dt>Cart items :</dt>
						<dd><span id="basketFee"><fmt:formatNumber value="${basketAccount}" type="number"/></span> KRW <span class='usd_price'>(${exchangeBasketAccount} USD)</span></dd><!-- 2017-06-16 수정 -->
						<dt>Shopping to :</dt>
						<dd><span id="shipFee"><fmt:formatNumber value="${deliveryCharge}" type="number"/></span> KRW <span class='usd_price'>(${exchangeDeliveryCharge} USD)</span></dd><!-- 2017-06-16 수정 -->
					</dl>
					<dl class="list_price price_total">
						<dt>Cart Subtotal</dt>
						<dd><strong><span id="totalFee"><fmt:formatNumber value="${paymentAccount}" type="number"/></span> KRW <span class='usd_price'>(${exchangePaymentAccount} USD)</span></strong></dd><!-- 2017-06-16 수정 -->
					</dl>
				</div>

				<div class="basket_btn">
					<div class="inner_basket">
						<div class="opt_nation">
							<strong class="screen_out">select country</strong>
							<a href="#none" class="link_selected">
								<span class="ico_friends ico_global"></span>
								<em>Country : </em>
								<span class="txt_nation">${oaCountryName}</span>
								<span class="screen_out">selected</span>
							</a>
							<div class="box_nation">
								<em class="tit_nation">Select delivery country</em><!-- 2017-06-14 수정 -->
								<div class="box_scroll">
									<ul class="list_nation"><!-- 2016-06-14 21개국 추가 -->
										<c:forEach items="#{countryList}" var="country">
											<li><a href="javascript:changeNation('${country.EC_COUNTRYENG}')" class="link_nation">${country.EC_COUNTRYENG}</a></li>
										</c:forEach>
									</ul>
								</div>
								<button type="button" class="btn_close"><span class="ico_friends ico_close">Close</span></button>
							</div>
							<div class="dimmed_g"></div>
						</div>
						<div class="buy_btn">
							<a href="/en/index" class="btn_basket btn_continue"><span class="txt_g">Go Home</span></a>
							<button type="button" class="btn_basket btn_buy"><span class="txt_g">Check out</span></button>
							<span class="btn_basket btn_dimmed" style="display: none"><span class="txt_g">Check out</span></span>
						</div>
					</div>
				</div>

				<div class="continue_btn">
					<a href="/en/index" class="btn_basket btn_continue"><span class="txt_g">Go Home</span></a>
				</div>
			</fieldset>
		</form>

		<c:if test="${!empty(suggestedProducts)}">
			<div class="cont_product">
			<h3 class="tit_sub">Featured Collection</h3>
			<ul class="list_product">
				<c:forEach items="${suggestedProducts}" var="suggestedProduct">
				<li <c:if test="${suggestedProduct.isCustomProduct or suggestedProduct.isEventProduct}">class="item_optnone"</c:if>>
					<a href="/en/products/${suggestedProduct.product.prCode}" class="link_product">
						<span class="wrap_thumb">
							<%--<img src="${kakaoFriendsCdn.product}/${empty suggestedProduct.product.prImage12 ? suggestedProduct.product.prImage1 : suggestedProduct.product.prImage12}" class="thumb_g" alt="">--%>
							<si:tenthImageTag type="product" imageName="${suggestedProduct.product.prImage1}" altVal=""/>
								<c:if test="${suggestedProduct.isSoldOut}">
							<span class="ico_friends ico_soldout">Out of stock</span>
							</c:if>
							<c:if test="${!suggestedProduct.isSoldOut and suggestedProduct.isDiscountPeriod}">
								<span class="ico_friends ico_sale">Discounted item</span>
							</c:if>
						</span>
						<strong class="tit_product">${empty suggestedProduct.product.prName1 ? suggestedProduct.product.prName : suggestedProduct.product.prName1}</strong>
						<c:if test="${!suggestedProduct.isDiscountPeriod}">
							<em class="emph_price">
								<span class="screen_out">Price</span><span class="current_price"><fmt:formatNumber value="${suggestedProduct.productLevelPrice.prlpSaleprice1}" type="number"/>KRW <span class="usd_price">(<fmt:formatNumber value="${suggestedProduct.productLevelPrice.exchangePrice}" type="number"/> USD)</span></span><!-- 2017-06-16 수정 -->
							</em>
						</c:if>
						<c:if test="${suggestedProduct.isDiscountPeriod}">
							<em class="emph_price">
								<span class="screen_out">Sale Price</span><span class="current_price"><fmt:formatNumber value="${suggestedProduct.productLevelPrice.prlpDiscountprice1}" type="number"/>KRW <span class="usd_price">(<fmt:formatNumber value="${suggestedProduct.productLevelPrice.exchangeDiscountPrice}" type="number"/> USD)</span></span><!-- 2017-06-16 수정 -->
								<span class="screen_out">Price</span><span class="prev_price"><fmt:formatNumber value="${suggestedProduct.productLevelPrice.prlpSaleprice1}" type="number"/>KRW <span class="usd_price">(<fmt:formatNumber value="${suggestedProduct.productLevelPrice.exchangePrice}" type="number"/> USD)</span></span><!-- 2017-06-16 수정 -->
							</em>
						</c:if>
					</a>

					<c:choose>
						<c:when test="${suggestedProduct.isCustomProduct or suggestedProduct.isEventProduct}"></c:when>

						<c:when test="${suggestedProduct.isGiftBag}">
							<div class="util_btn">
								<c:if test="${empty suggestedProduct.product.defaultPrcode}">
									<span class="wrap_btn"><button type="button" class="btn_g btn_dimmed" disabled>장바구니</button></span>
								</c:if>
								<c:if test="${!empty suggestedProduct.product.defaultPrcode}">
									<span class="wrap_btn"><button type="button" data-prcode="${suggestedProduct.product.prCode}" data-defaultprcode="${suggestedProduct.product.defaultPrcode}" data-ctseq="${suggestedProduct.category.ctSeq}" class="btn_g btn_basket_in">Add to Cart</button></span>
								</c:if>
								<span class="wrap_btn"><button type="button" class="btn_g btn_dimmed" disabled>Check out</button></span>
							</div>
						</c:when>
						<c:otherwise>
							<div class="util_btn">
								<c:if test="${empty suggestedProduct.product.defaultPrcode}">
									<span class="wrap_btn"><button type="button" class="btn_g btn_dimmed" disabled>Add to Cart</button></span>
								</c:if>
								<c:if test="${!empty suggestedProduct.product.defaultPrcode}">
									<span class="wrap_btn"><button type="button" data-prcode="${suggestedProduct.product.prCode}" data-defaultprcode="${suggestedProduct.product.defaultPrcode}" data-ctseq="${suggestedProduct.category.ctSeq}" class="btn_g btn_basket_in">Add to Cart</button></span>
								</c:if>
								<c:if test="${suggestedProduct.isSoldOut or (empty suggestedProduct.product.defaultPrcode)}">
									<span class="wrap_btn"><button type="button" class="btn_g btn_dimmed" disabled>Check out</button></span>
								</c:if>
								<c:if test="${!suggestedProduct.isSoldOut and (!empty suggestedProduct.product.defaultPrcode)}">
									<span class="wrap_btn"><button type="button" class="btn_g btn_oder_in" data-defaultprcode="${suggestedProduct.product.defaultPrcode}" value = ${suggestedProduct.product.prCode} data-ctseq="${suggestedProduct.category.ctSeq}">Check out</button></span>
								</c:if>
							</div>
						</c:otherwise>
					</c:choose>
				</li>
				</c:forEach>
			</ul>

			<form id="directFrm" name="directFrm" action="/en/order/directsheet" method="post">
				<input type="hidden" name="prCode">
				<input type="hidden" name="prCodes">
				<input type="hidden" name="prEas">
				<input type="hidden" name="ctSeq">
				<input type="hidden" name="bsSeq">
				<input type="hidden" name="isGiftBag" value="false">
				<input type="hidden" name="displayGoodsId"/>
				<input type="hidden" name="_csrf" value="${_csrf.token}"/>
				<input type="hidden" name="_csrf_header" value="${_csrf.headerName}"/>
			</form>
		</div>
		</c:if>
	</c:if>
</div>

<script type="text/javascript">
	/** 각인 서비스 상품 전용 추가 스크립트 시작 **/
	$('.naming_product').on('click', function(){
		$("#prCode").val(this.value);
		$("#ctSeq").val($(this).data().ctseq);
		$("#prEa").val(1);
		$("#frm").attr("action", "/en/order/directsheet");
		intPopup();
	})

	$(document).on('click', '.btn_initial', function () {
		$("#frm").submit();
	})
	/** 각인 서비스 상품 전용 추가 스크립트 끝 **/
</script>
<script type="text/javascript">
	function setCheckBoxFlag(){
		var checkBoxFlags = new Array();
		for(var i=0; i < $(".choice_basket .inp_g[name = prCodes]:enabled").length; i++){
			checkBoxFlags.push($(".choice_basket .inp_g[name = prCodes]:enabled")[i].checked == true ? 1 : 0);
		}

        //체크된 아이템만 수량 넣어서 주문화면으로 넘김
        for(var j=0; j < checkBoxFlags.length; j++){
            if (checkBoxFlags[j] == 0) {
                $(".box_quantity input[name = prEas]").eq(j).prop('disabled', true);
            }
        }

        //선택한 상품의 prcode와 giftbag여부 넘김
        for(var k=0; k < $(".choice_basket .inp_g[name = prCodes]").length; k++){
            if($(".choice_basket .inp_g[name = prCodes]")[k].checked == false) {
                $(".choice_basket input[name = isGiftBag]").eq(k).prop('disabled', true);
                $(".choice_basket input[name = bsSeq]").eq(k).prop('disabled', true);
            }
        }

		$('#checkBoxFlags').val(checkBoxFlags);

        $(".choice_basket .inp_g").on("change", function(e) {
            var $this = $(this)

            if (e.target.checked) {
                $this.siblings().prop('disabled', false);
            }
        });
	}
	function isOnlyGiftBag(){
		var onlyGiftBag = true;
		$(".choice_basket .inp_g[name = prCodes]:enabled").each(function(){
			if($(this).is(":checked") && $(this).closest("li").find("input[name=isGiftBag]").val() == 'false' || !$(this).is(":checked")){
				onlyGiftBag = false;
			}
		})

		//장바구니에 선택한 상품이 없을때 기프트백플래그 false 추가 2017.10.10
		if ($(".choice_basket .inp_g[name = prCodes]:enabled").length == 0) {
			onlyGiftBag = false;
		}
		return onlyGiftBag;
	}
    //장바구니에서 구매하기 버튼클릭시에 체크박스 체크된 상품들에 한해서 갯수확인
    function isCheckGiftBagCnt(){
        var cntGiftBag = 0;
        var cntNotGiftBag = 0;
        var isGiftBagCnt = false;
        var giftBagArray = new Array();

        //체크박스나 수량입력INPUT 갯수와 giftBagFlag갯수가 안맞아서(checkbox:enabled로는 루프가 꼬임) 비교용 array생성
        for(var j=0; j < $(".choice_basket .inp_g[name = prCodes]").length; j++){
            //if($(".choice_basket .inp_g[name = prCodes]")[j].checked) {
            if($(".choice_basket .inp_g[name = prCodes]:enabled")[j]) {
                giftBagArray.push($(".choice_basket input[name = isGiftBag]").eq(j).val());
            }
        }

        for(var i=0; i < $(".choice_basket .inp_g[name = prCodes]:enabled").length; i++){
            if ($(".choice_basket .inp_g[name = prCodes]:enabled")[i].checked) {
                if(giftBagArray[i].toString() == 'true'){
                    //장바구니 속 체크된 구매리스트중 쇼핑백
                    cntGiftBag = cntGiftBag + parseInt($(".box_quantity input[name = prEas]").eq(i).val());
                }else{
                    //장바구니 속 체크된 구매리스트중 일반상품
                    cntNotGiftBag = cntNotGiftBag + parseInt($(".box_quantity input[name = prEas]").eq(i).val());
                }
            }
        }

        if (cntNotGiftBag < cntGiftBag) {
            isGiftBagCnt = true;
        }

        return isGiftBagCnt;
    }


    function validate () {

        var result = true;
        var eventProducts = ['FRPBRYSPD0004', 'FRPBRYSPD0003'];
       // var productInCart = $('input[name=prCodes]');
        var productInCart = $(".choice_basket .inp_g:checked");

        var eventProductCountInCart = 0;
        productInCart.each(function () {
            if (eventProducts.indexOf($(this).val()) >= 0) {
                eventProductCountInCart++;
            }
        });

        if(eventProductCountInCart > 0  && productInCart.length !== eventProductCountInCart) {
            result = false;
        }
        console.log("장바구니 중 이벤트 상품 수 : " + eventProductCountInCart);
        console.log("장바구니 상품 수 : " + productInCart.length);

        return result;
    }

    // 배송국가 변경시 event
    function changeNation(countryName) {
        $("#countryName").val(countryName);
        $("#frm").attr("action","/en/basket/basket/countryChange");
        $("#frm").submit();
    }

	$(function() {
		$(".link_delete").on("click", function () {
            deleteAjax(this.value)
				.then(function(data) {
                    location.href = data.view.url;
				})
		});

		$(".btn_delete").on("click", function () {
            deleteAjax();
		});

        $('.btn_del').on('click', function() {
            var $frm = $('#frm');
            var $checkedInput = $('.choice_basket .inp_g:checked');

            if ($checkedInput.length < 1) {
                alertPopup('alert_selectEmpty');
                return false;
            }

            var $bsSeq = $frm.find('[name="bsSeq"]');
            var bsSeqs = $.map($bsSeq, function(input) {
				var $input = $(input);
				var $checkbox = $input.siblings('input:checkbox')

                if ($input.val() && $checkbox.is(':checked')) {
                    return $input.val();
                }
            });

            $frm.find('[name="bsSeqs"]').val(bsSeqs);

            $frm.attr('action', '/en/basket/basket/multidelete');
            $frm.submit();
        });

        $("[data-btn-change]").on("click", function () {
            var $this = $(this)

			if($(this).parent("li").find(".inp_quantity").val() < 1){
				alertPopup("alert_basketEmpty");
                $(this).parent("li").find(".inp_quantity").val(1);
				return false;
			}

            if($(this).parent("li").find(".inp_quantity").val() > 999){
                return false;
            }

            var prCnt =  $('input[name=basketProductEa]').val();
            var gbCnt = 0;
            var isGiftFlag = false;

            if($(this).closest("li").find("input[name=isGiftBag]").val() == 'true'){
                if (prCnt == 0) {
                    if ($("#prEa_" + $(this).val()).val() != 1) {
                        $("#prEa_" + $(this).val()).val(1);
                        isGiftFlag = true;
                    }
                } else {
                    for (var i = 0; i < $('.box_quantity .giftbag_bsEa').length; i++) {
                        gbCnt = gbCnt + parseInt($('.box_quantity .giftbag_bsEa').eq(i).val());
                    }
                    if(prCnt < gbCnt){
                        alertPopup('alert_alreadyBasket_giftBag_detail');
                        return false;
                    }
                }
            }

            if (isGiftFlag) {
                $("#frm").attr("action", "/en/basket/basket/updateGiftBag");
            } else {
                $("#frm").attr("action", "/en/basket/basket/update");
            }

			$("#prCode").val($(this).val());
            $('#displayGoodsId').val($(this).data('goodsId'))
            $("#prEa").val($(this).parents('li').find('[name="prEas"]').val());
			$("#ctSeq").val($(this).data().ctseq);

            if ($(this).data('isDiff')) {
                deleteAjax($(this).parents('li').find('[data-bs-seq]').data('bsSeq'))
                    .then(function() {
                        var $prEas = $this.parents('li').find('.inp_quantity')
                        var prEas = parseInt($prEas.val(), 10)

                        var $target = $('.inp_g').filter(function(index, item) {
                            return item.value === $this.val()
                        }).parents('li').find('.inp_quantity[name="prEas"]')

                        var targetPrEas = $target.length ? parseInt($target.val(), 10) : 0
                        var sum = targetPrEas + prEas

                        $target.val(sum)
                        $("#prEa").val(sum);
                        $("#frm").submit();
                    })
            } else {
                $("#frm").submit();
			}
		});

		$(".btn_basket_in").on("click", function () {
			$("#frm").attr("action", "/en/basket/basket/suggested");
            $("#displayGoodsId").val($(this).data().prcode);
            $("#prCode").val($(this).data().defaultprcode);
			$("#ctSeq").val($(this).data().ctseq);
			$("#frm").submit();
		});

        $(".btn_oder_in").on("click", function () {
            document.directFrm.prCode.value = $(this).data().defaultprcode;
            document.directFrm.prCodes.value = $(this).data().defaultprcode;
            document.directFrm.displayGoodsId.value = this.value;
            document.directFrm.prEas.value = 1;
            document.directFrm.ctSeq.value = $(this).data().ctseq;

            directBeforeInsertBasket();
        });

        $("button.btn_buy").on("click", function () {
			<sec:authorize access="isAnonymous()">
			var showNotice = localStorage.getItem("i_do_not_want_sign_up") !== new Date().toDateString();

			if (showNotice) {
				benefitPopup(function() {
					$(".benefit_layer .buy_nomember").one("click", function() {
						// 비회원 구매
						localStorage.setItem("i_do_not_want_sign_up", new Date().toDateString());
						$('.dimmed_layer').hide();
						$("button.btn_buy").trigger('click');
					});
					$(".benefit_layer .buy_member").one("click", function() {
						// 회원가입 또는 로그인
						$('.dimmed_layer').hide();
						location.href = '/auth/kakao?disable_approval_window=false&redirect_url=' +
							encodeURIComponent(window.location.href.split('?')[0] + '?action=pruchase');
					});
				});

				return false;
			}
			</sec:authorize>

            if(isOnlyGiftBag()){
                alertPopup('alert_onlyGiftBag');
                return false;
            }

            if(isCheckGiftBagCnt()){
                alertPopup('alert_alreadyBasket_giftBag_detail');
                return false;
            }

            if($(".choice_basket .inp_g:checked").length < 1){
                alertPopup("alert_selectEmpty");
                return false;
            }
            if($("#btnChange:enabled").length > 0){
                alertPopup("alert_changeEmpty");
                return false;
            }
            setCheckBoxFlag();
            $('#bsSeq').prop('disabled', true)

            fbq('track', 'InitiateCheckout', {value: '${exchangePaymentAccount}', currency: 'USD'});
            ga('send', {
            hitType: 'event',
            eventCategory: 'ecommerce',
            eventAction: 'InitiateCheckout',
            });

			$("#frm").submit();
		});
      	<c:if test="${isPayOnlyItemContains and not canPurchasePayOnly}">
      	$("button.btn_buy").on("click", function () {
          	// alertPopup("못사못사~")
          payonlyPopup()
        });
      	</c:if>

		$(function() {
            $('.list_basket').find("input:text").keydown(function(evt) {
				if (evt.keyCode == 13)
					return false;
			});
		});

		function parseQueryString(query) {
			var vars = query.split("&");
			var query_string = {};
			for (var i = 0; i < vars.length; i++) {
				var pair = vars[i].split("=");
				var key = decodeURIComponent(pair[0]);
				var value = decodeURIComponent(pair[1]);
				// If first entry with this name
				if (typeof query_string[key] === "undefined") {
					query_string[key] = decodeURIComponent(value);
					// If second entry with this name
				} else if (typeof query_string[key] === "string") {
					var arr = [query_string[key], decodeURIComponent(value)];
					query_string[key] = arr;
					// If third or later entry with this name
				} else {
					query_string[key].push(decodeURIComponent(value));
				}
			}
			return query_string;
		}

		var queryString = window.location.href.split('?')[1];

		if (queryString) {
			var parsedQs = parseQueryString(queryString);

			switch (parsedQs.action) {
				case 'pruchase':
				$("button.btn_buy").trigger('click');
			}
		}
	});

    //directsheet 가기 전 장바구니에 insert 후 이동 2018.03.08 layla
    function directBeforeInsertBasket(){
        var formData = $("#directFrm").serialize();

        $.ajax({
            headers: {'X-CSRF-TOKEN': '${_csrf.token}'},
            url: "/kr/basket/basket/directInsert",
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
                    document.directFrm.bsSeq.value = data.bsSeq;

                    $("#directFrm").submit();

                    return false;
                }
                alertNoti('error.occurred');
            }
        });
	}

	function deleteAjax(deleteBsSeq){
        $("#bsSeq").val(deleteBsSeq);

        return $.ajax({
            headers: {'X-CSRF-TOKEN': '${_csrf.token}'},
            url: "/en/basket/basket/delete",
            type: "POST",
            dataType: "json",
            data: $("#frm").serialize(),
            async:false,
            error: function () {
                alertNoti('error.occurred');
                return false;
            }
        });
		}
</script>
<c:if test="${!empty emptyMessage}">
	<script language="JavaScript">
		$(document).ready(function () {
			alertPopup('${emptyMessage}');
		})
	</script>
</c:if>
<c:if test="${!empty basketPopup and !basketPopup}">
	<script language="JavaScript">
		$(document).ready(function () {
            alertPopup('alert_alreadyBasket_giftBag_detail');
		})
	</script>
</c:if>
<script>
    var isEn = true
    var X_CSRF_TOKEN = "${_csrf.token}"
</script>
<script src="https://t1.kakaocdn.net/friends/resources/js/lodash.min.js"></script>
<script>
  ;(function() {
    'use strict'

    var $listBasket = $('.list_basket')
    var $selectGroup = $('[data-select-group]')

    var optionTemplate = _.template(
      '<li class="${item.isSoldOut ? "item_soldout" : ""}">\
      <a href="#none" class="link_opt" data-${item.isSoldOut ? "_value" : "value"}="${index}" data-id="${item.id}" data-goods-id="${item.goodsId}" data-parent-goods-option-id="${item.parentGoodsOptionId}" data-name="${item.name}" data-name-en="${item.nameEn}">\
        <span class="tit_option">${isEn ? item.nameEn : item.name} ${item.isSoldOut ? isEn ? "(Sold Out)" : "(품절)" : ""}</span>\
      </a>\
    </li>'
    )
    var cloneBasket

    function toggleSelect(e) {
      e.preventDefault()

      var $target = $(e.currentTarget)
      var $parent = $target.parents('.opt_g')
      var $ul = $target.next().find('.list_opt')

      function hide(e) {
        if (!$parent.is(e.target) && !$parent.has(e.target).length) {
          $ul.hide()
          $parent.removeClass('opt_on')
        }
      }

      if ($parent.hasClass('opt_on')) {
        $ul.show()
        $(document.body).on('click', hide)
      } else {
        $ul.hide()
        $(document.body).off('click', hide)
      }
    }

    function toggleBasketOption(e) {
      var $target = $(e.currentTarget)
      var $parent = $target.parents('li')
      var $basketOption = $parent.find('.basket_option')
      var $optionSelect = $parent.find('.option_select')
      var isOpened = $basketOption.is(':visible')

      cloneBasket = $basketOption.clone(true)

      $target.find('.ico_arrow').text(isOpened ? '펼치기' : '접기')
      $basketOption.toggle()
      $parent.toggleClass('option_on')
    }

    function onChangeValue() {
      function init(e) {
        e.preventDefault()

        var $target = $(e.currentTarget)
        var $parent = $target.parents('[data-id]')

        $parent.find('ul.list_opt').hide()

        return [$target, $parent]
      }

      function setOptions(args) {
        var $target = args[0]
        var $parent = args[1]
        var $optionSelect = $parent.parents('.option_select')

        var order = $parent.data('id')

        $parent.addClass('opt_selected').removeClass('opt_on')
        $parent
        .find('[data-toggle]')
        .find('span.txt_opt')
        .text($target.text().trim())

        return [order, $target, $optionSelect]
      }

      function changeItems(args) {
        var order = args[0]
        var $target = args[1]
        var $optionSelect = args[2]
        var data = $target.data()
        var optionData = $optionSelect.data()
        var bsSeq = optionData.bsSeq
        var isLast = order + 1 === optionData.optionsLength
        var displayGoodsId = $('[data-display-goods-id]').data('displayGoodsId')

        if (isLast) {
          callApi({
            url: '/kr/displayGoods/findProducts',
            method: 'post',
            data: {
              goodsOptionId: data.id
            }
          }).then(function(productDetail) {
            if (productDetail.length === 0) {
              console.error('🚨')
              return
            }

            var $btnChange = $optionSelect
            .parents('.basket_option')
            .find('[data-ctseq]')
            var prevPrCode = $btnChange.val()
            var prCode = productDetail[0].product.prCode

            $btnChange
            .data('goodsId', displayGoodsId)
            .data('isDiff', prevPrCode !== prCode)
            .val(prCode)
          })
        } else {
          callApi({
            url: '/kr/displayGoods/findByDisplayGoodsIdOption',
            method: 'post',
            data: {
              goodsId: data.goodsId,
              parentGoodsOptionId: data.id || 0
            }
          }).then(function(options) {
            if (options.length === 0) {
              console.error('🚨')
              return
            }

            render(order + 1, options, $optionSelect)
          })
        }
      }

      return _.flow([init, setOptions, changeItems])
    }

    function render(index, options, target) {
      var $target = target
      var $options = $target.find('.opt_g[data-id]').eq(index)

      var isFirst = index === 0

      var optionsHtml = _.map(options, function(item, index) {
        return optionTemplate({ item: item, index: index })
      }).join('')

      $options.find('.txt_opt').text($options.data('label'))

      $options
      .show()
      .find('ul.list_opt')
      .html(optionsHtml)
    }

    function resetBasketOption(e) {
      var $target = $(e.currentTarget)
      var $parent = $target.parents('.basket_option')

      $parent.replaceWith(cloneBasket)
      $parent.hide()
    }

    function updateBasket(e) {
      var $target = $(e.currentTarget)
      var $parent = $target.parents('li')
      var $prCodes = $parent.find('[name="prCodes"]')

      var id = $target.val()

      $prCodes.val(id)
    }

    function preventReturnKey(e) {
      if (e.keyCode === 13) {
        return false
      }
    }

    function callApi(options) {
      var mergedOptions = $.extend(
        {
          headers: { 'X-CSRF-TOKEN': X_CSRF_TOKEN },
          dataType: 'json'
        },
        options
      )

      return $.ajax(mergedOptions)
    }

    function withComma(price) {
      return price.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',')
    }

    function changeQtyWithSummary(e) {
      var $target = $(e.currentTarget)
      var $parent = $target.parents('.option_info')

      var $krw = $parent.find('.emph_g')
      var $usd = $parent.find('.usd_price')
      var $qty = $parent.find('.inp_quantity')

      var krw = $krw.data('price')
      var usd = $usd.data('price')
      var qty = parseInt($qty.val(), 10)

      $krw.text(withComma(krw * qty))
      $usd.text('(' + (usd * qty).toFixed(2) + ' USD)')
    }

    function main() {
      var onChangeValue$ = onChangeValue()

      $selectGroup.on('click', '[data-toggle]', toggleSelect)
      $selectGroup.on('click', '[data-value]', onChangeValue$)

      $listBasket.on('click', '.btn_option', toggleBasketOption)
      $listBasket.on('click', '.btn_cancel', resetBasketOption)
      $listBasket.on('click', '[data-ctseq]', updateBasket)

      $listBasket.on('keydown', preventReturnKey)

      $listBasket.on('click', '.btn_g', changeQtyWithSummary)
      $listBasket.on('change', '.inp_quantity', changeQtyWithSummary)
    }

    main()
  })()

</script>