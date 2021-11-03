<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="si" uri="http://www.kakaofriends.com/si" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set value="${kakaoWebView}" var="kakaoWebView" />
<c:set value="${requestScope['javax.servlet.forward.servlet_path']}" var="requestPath" />
<c:set value="${requestScope['javax.servlet.forward.query_string']}" var="queryString" />
<c:set value="${displayGoodsDetail.isHasOption}" var="hasOptions" />
<c:set value="${pageContext.response.locale.language.equals('en') ? 'en' : 'kr'}" var="language" />
<spring:eval expression="@environment['deploy.version']" var="deployVersion" />

<div class="banner_page" style="display: none;">
  <sec:authorize access="isAnonymous()">
    <%--비회원--%>
    <a href="/kr/promotions/promotion/204" class="nomember">
      지금 1000P 즉시 지금! 포인트 2배 적립!
    </a>
  </sec:authorize>
  <sec:authorize access="isAuthenticated()">
    <%--회원--%>
    <a href="/kr/promotions/promotion/204" class="member">
      지금 구매하고 포인트 2배 6% 적립받자!
    </a>
  </sec:authorize>

  <button class="banner_close">닫기</button>
</div>

<div id="mArticle">
  <h2 id="kakaoBody" class="screen_out">제품 상세정보</h2>

  <div class="cont_detail">
    <div class="inner_detail">
      <strong class="tit_cate"><a href="/kr/index" class="link_cate">홈</a> <span class="txt_bar">/</span>
        <a href="/kr/products/groups/${displayGoodsDetail.categoryGroup.name}/${displayGoodsDetail.category.ctCode}"
           class="link_cate">${displayGoodsDetail.category.ctName}</a>
      </strong>

      <h3 class="tit_detail">${displayGoodsDetail.displayGoods.name}</h3>

      <span class="price_info">
				<c:choose>
                  <c:when test="${!displayGoodsDetail.isDiscountPeriod}">
                    <span class="screen_out">금액</span>
                    <span class="current_price" data-regular-price="${displayGoodsDetail.displayGoods.salePrice}">
							<fmt:formatNumber value="${displayGoodsDetail.displayGoods.salePrice}" type="number"/>원
							<%--<span class="usd_price">(<fmt:formatNumber value="${displayGoodsDetail.displayGoods.exchangePrice}" type="number" /> USD)</span>--%>

                            <c:if test="${displayGoodsDetail.foreigndeliCheck > 0}">
                              <span class="ico_friends ico_delivery">글로벌 배송 가능</span>
                            </c:if>
						</span>
                  </c:when>
                  <c:otherwise>
                    <span class="screen_out">할인금액</span>
                    <span class="current_price" data-discount-price="${displayGoodsDetail.displayGoods.discountPrice}">
							<fmt:formatNumber value="${displayGoodsDetail.displayGoods.discountPrice}" type="number"/>원
							<%--<span class="usd_price">(<fmt:formatNumber value="${displayGoodsDetail.displayGoods.exchangeDiscountPrice}" type="number" /> USD)</span>--%>
                            <c:if test="${displayGoodsDetail.foreigndeliCheck > 0}">
                              <span class="ico_friends ico_delivery">글로벌 배송 가능</span>
                            </c:if>
						</span>
                    <span class="screen_out">기존금액</span>
                    <span class="prev_price" data-regular-price="${displayGoodsDetail.displayGoods.salePrice}">
							<fmt:formatNumber value="${displayGoodsDetail.displayGoods.salePrice}" type="number"/>원
							<%--<span class="usd_price">(<fmt:formatNumber value="${displayGoodsDetail.displayGoods.exchangePrice}" type="number" /> USD)</span>--%>
                            <c:if test="${displayGoodsDetail.foreigndeliCheck > 0}">
                              <span class="ico_friends ico_delivery">글로벌 배송 가능</span>
                            </c:if>
						</span>
                  </c:otherwise>
                </c:choose>
			</span>

      <div class="cont_about">${displayGoodsDetail.displayGoods.content}</div>


      <strong class="screen_out">SNS로 공유하기</strong>
      <ul class="list_sns">
        <li class="fst">
          <a href="#none" class="link_sns" title="새창 열림"><span class="ico_friends ico_kt"></span>카카오톡</a>
        </li>
        <c:if test="${kakaoWebView == 0}">
          <li>
            <a href="#none" class="link_sns" title="새창 열림"><span class="ico_friends ico_ks"></span>카카오스토리</a>
          </li>
          <li>
            <a href="#none" class="link_sns" title="새창 열림"><span class="ico_friends ico_twi"></span>트위터</a>
          </li>
          <li>
            <a href="#none" class="link_sns" title="새창 열림"><span class="ico_friends ico_face"></span>페이스북</a>
          </li>
        </c:if>
      </ul>

    </div>
  </div>

  <div class="box_purchase ${hasOptions ? ' box_option' : ''}">
    <!-- 임시저장 상태 중 옵션이 닫힌상태 option_open / 옵션이 열린상태 option_close -->

    <c:if test="${false}">
      <%--해외배송 가능할때--%>
      <c:if test="${displayGoodsDetail.foreigndeliCheck > 0}">
        <div class="state_global">
          <em class="emph_global">
            <span class="ico_friends ico_global"></span>
            <span class="txt_global" onclick="globalNationPopup()" style="cursor:pointer">글로벌 배송이 가능한 상품입니다.</span>
          </em>
        </div>
      </c:if>
      <%--해외배송 불가능할때--%>
      <c:if test="${displayGoodsDetail.foreigndeliCheck == 0}">
        <div class="state_global state_noglobal">
          <em class="emph_global">
            <span class="ico_friends ico_global"></span>
            <span class="txt_global">글로벌 배송이 불가능한 상품입니다.</span>
          </em>
        </div>
      </c:if>
    </c:if>

    <%-- pay only markup sample --%>
    <c:if test="${isPayOnlyPrcode||isPayOnlyDispcode}">
    <div class="alert_payonly"><p>결제 전용 상품은 단독 구매만 가능합니다.</p></div>
    </c:if>
    <%--<c:if test="${not isPayOnlyPrcode}">--%>
    <%--<div>normal product</div>--%>
    <%--</c:if>--%>
    <div class="inner_purchase">
      <h3 class="screen_out">제품 구매하기</h3>
      <form id="frm" action="/kr/order/directsheet" method="post">
        <fieldset>
          <legend class="screen_out">제품 구매양식</legend>
          <input type="hidden" name="_csrf" value="${_csrf.token}"/>
          <input type="hidden" name="_csrf_header" value="${_csrf.headerName}"/>
          <c:if test="${productRequest != null}">
            <input type="hidden" name="prCode" value="${productRequest.product.prCode}">
            <input type="hidden" name="prCodes" value="${productRequest.product.prCode}">
          </c:if>
          <c:if test="${productRequest == null}">
            <input type="hidden" name="prCode" value="${displayGoodsDetail.displayGoods.defaultPrcode}">
            <input type="hidden" name="prCodes" value="${displayGoodsDetail.displayGoods.defaultPrcode}">
          </c:if>
          <input type="hidden" name="prEas" id="prEas">
          <input type="hidden" name="ctSeq" value="${displayGoodsDetail.category.ctSeq}">
          <input type="hidden" name="bsSeq" id="bsSeq">
          <input type="hidden" name="isGiftBag" value="${displayGoodsDetail.isGiftBag}">
          <input type="hidden" name="displayGoodsId" value="${displayGoodsDetail.displayGoods.id}">

          <c:choose>
            <c:when test="${displayGoodsDetail.isGiftBag}">
              <input type="hidden" id="prEa" class="inp_quantity " name="prEa" value="1">
              <div class="check_btn" style="${isPayOnlyPrcode||isPayOnlyDispcode ? 'display:none;' : ''}">
                <button
                  type="button" ${!empty displayGoodsDetail.wsSeq ? 'class="btn_wish wish_on" disabled="disabled"' : 'class="btn_wish"'} >
                  <span class="ico_friends ico_wish">제품 찜하기</span>
                </button>
                <button type="button" class="btn_basket ${displayGoodsDetail.basketCheck > 0 ? 'basket_on' : ''}">
                  <span class="ico_friends ico_basket">제품</span>
                  <span class="txt_basket">장바구니 담기</span>
                </button>
              </div>
              <em class="emph_state emph_giftbag"><span class="ico_friends ico_giftbag"></span>기프트백은 단독 구매 불가한 상품입니다.<br
                class="rw_hide"> 장바구니에 담은 뒤 다른 상품과 함께 구매해주세요.</em>
            </c:when>
            <c:when test="${displayGoodsDetail.isEventProduct}">
              <c:choose>
                <c:when test="${!displayGoodsDetail.isSoldOut}">
                  <div class="item_option">
                    <div class="box_quantity">
                      <label class="screen_out" for="prEa">수량 :</label>
                      <input type="text" id="prEa" class="inp_quantity " name="prEa" value="1">
                      <button type="button" class="btn_g btn_minus"><span class="ico_newfriends_v1 ico_minus">빼기</span>
                      </button>
                      <button type="button" class="btn_g btn_plus"><span class="ico_newfriends_v1 ico_plus">더하기</span>
                      </button>
                    </div>
                    <div class="pay_price">
                      <span class="txt_price">상품 금액</span>
                      <em class="emph_price">
                        <fmt:formatNumber
                          value="${displayGoodsDetail.isDiscountPeriod ? displayGoodsDetail.displayGoods.discountPrice : displayGoodsDetail.displayGoods.salePrice}"
                          type="number"/>
                        <span class="txt_won">원
												<span class='usd_price'>(<fmt:formatNumber
                                                  value="${displayGoodsDetail.isDiscountPeriod ? displayGoodsDetail.displayGoods.discountPrice : displayGoodsDetail.displayGoods.exchangeDiscountPrice}"
                                                  type="number"/> USD)</span>
											</span>
                      </em>
                    </div>
                    <button type="button" class="btn_close"><span class="ico_friends ico_close">옵션 닫기</span></button>
                  </div>
                  <button type="button" class="btn_eventproduct btn_open"><span class="txt_g">구매하기</span></button>
                  <button type="button" class="btn_eventproduct btn_buy"><span class="txt_g">구매하기</span></button>
                </c:when>
                <c:otherwise>
                  <em class="emph_state emph_soldout"><span class="ico_friends ico_soldout"></span>품절된 상품입니다.</em>
                </c:otherwise>
              </c:choose>
            </c:when>
            <c:otherwise>
              <fmt:formatNumber
                value="${displayGoodsDetail.isDiscountPeriod ? displayGoodsDetail.displayGoods.discountPrice : displayGoodsDetail.displayGoods.salePrice}"
                type="number" var="krwPrice"/>
              <fmt:formatNumber
                value="${displayGoodsDetail.isDiscountPeriod ? displayGoodsDetail.displayGoods.exchangeDiscountPrice : displayGoodsDetail.displayGoods.exchangePrice}"
                type="number" var="usdPrice"/>

              <c:choose>
                <c:when test="${hasOptions}">
                  <div class="group_option" style="display: none;">
                    <div data-select-group class="area_option">
                      <div data-option-type="options"></div>
                      <div data-option-type="additional" class="opt_addition" style="display: none;">
                        <p class="desc_addition">추가 구성품을 별도로 구매할 수 있어요.</p>
                      </div>
                    </div>
                    <ul class="list_option" data-ctseq="${displayGoodsDetail.category.ctSeq}"></ul>
                  </div>

                  <button type="button" class="btn_optionbar"><span class="ico_newfriends_v1 ico_option">옵션 펼치기</span>
                  </button>
                  <!-- 펼쳐진 상태에서는 옵션 닫기로 텍스트 변경 -->

                  <div class="group_purchase">
                    <div class="check_btn" style="${isPayOnlyPrcode||isPayOnlyDispcode ? 'display:none;' : ''}">
                      <button
                        type="button" ${!empty displayGoodsDetail.wsSeq ? 'class="btn_wish wish_on" disabled="disabled"' : 'class="btn_wish"'} >
                        <span class="ico_friends ico_wish">제품 찜하기</span>
                      </button>

                      <button type="button"
                              class="btn_basket ${displayGoodsDetail.basketCheck > 0 ? 'basket_on' : ''}" ${!displayGoodsDetail.displayGoods.defaultPrcode && displayGoodsDetail.isSoldOut ? "disabled" : ""}>
                        <span class="ico_friends ico_basket">제품</span>
                        <span class="txt_basket">장바구니 담기</span>
                      </button>
                    </div>
                    <c:choose>
                      <c:when test="${!displayGoodsDetail.isSoldOut}">
                        <div class="item_option">
                          <div class="pay_price">
                            <span class="txt_price">총 결제금액</span>
                            <em class="emph_price" data-saleprice="${krwPrice}" data-exchangeprice="${usdPrice}">
                                ${krwPrice}
                              <span class="txt_won">원
																<span class='usd_price'>(${usdPrice} USD)</span>
															</span>
                            </em>
                          </div>
                          <button type="button" class="btn_close"><span class="ico_friends ico_close">옵션 닫기</span>
                          </button>
                        </div>

                        <button type="button" class="btn_open" style="display: block;"><span class="txt_g">구매하기</span>
                        </button>
                        <button type="button" class="btn_buy" style="display: none;"><span class="txt_g">구매하기</span>
                        </button>
                      </c:when>
                      <c:otherwise>
                        <em class="emph_state emph_soldout"><span class="ico_friends ico_soldout"></span>품절된 상품입니다.</em>
                      </c:otherwise>
                    </c:choose>
                  </div>
                </c:when>
                <c:otherwise>
                  <div class="check_btn" style="${isPayOnlyPrcode||isPayOnlyDispcode ? 'display:none;' : ''}">
                    <button
                      type="button" ${!empty displayGoodsDetail.wsSeq ? 'class="btn_wish wish_on" disabled="disabled"' : 'class="btn_wish"'} >
                      <span class="ico_friends ico_wish">제품 찜하기</span>
                    </button>
                    <button type="button" class="btn_basket ${displayGoodsDetail.basketCheck > 0 ? 'basket_on' : ''}">
                      <span class="ico_friends ico_basket">제품</span>
                      <span class="txt_basket">장바구니 담기</span>
                    </button>
                  </div>

                  <c:choose>
                    <c:when test="${!displayGoodsDetail.isSoldOut}">
                      <div class="item_option">
                        <div class="box_quantity">
                          <label class="screen_out" for="prEa">수량 :</label>
                          <input type="text" id="prEa" class="inp_quantity" name="prEa" value="1">
                          <button type="button" class="btn_g btn_minus"><span
                            class="ico_newfriends_v1 ico_minus">빼기</span></button>
                          <button type="button" class="btn_g btn_plus"><span
                            class="ico_newfriends_v1 ico_plus">더하기</span></button>
                        </div>
                        <div class="pay_price">
                          <span class="txt_price">상품 금액</span>
                          <em class="emph_price">
                              ${krwPrice}
                            <span class="txt_won">원
															<span class='usd_price'>(${usdPrice} USD)</span>
														</span>
                          </em>
                        </div>
                        <button type="button" class="btn_close"><span class="ico_friends ico_close">옵션 닫기</span>
                        </button>
                      </div>
                      <button type="button" class="btn_open"><span class="txt_g">구매하기</span></button>
                      <button type="button" class="btn_buy"><span class="txt_g">구매하기</span></button>
                    </c:when>
                    <c:otherwise>
                      <em class="emph_state emph_soldout"><span class="ico_friends ico_soldout"></span>품절된 상품입니다.</em>
                    </c:otherwise>
                  </c:choose>
                </c:otherwise>
              </c:choose>
            </c:otherwise>
          </c:choose>
        </fieldset>
      </form>
    </div>
  </div>
  <div class="dimmed_option" style="display: none;"></div>

  <%-- 최근 본 상품 --%>
  <div class="cont_detail detail_product">
    <div class="inner_detail">
      <strong class="tit_item tit_recent">최근 본 상품</strong>
      <ul class="list_item" id="recentProducts"></ul>
    </div>
  </div>

  <%-- 배너 --%>
  <div class="cont_detail detail_product">
    <div class="inner_detail">
      <c:if test="${kakaoWebView == 0}">
        <c:forEach items="${banners['5']}" var="banner">
          <c:if test="${banner.bnLinkUse eq 'Y'}">
            <a href="/kr/promotions/recruit" class="link_bnr rw_show"><img
              src="${kakaoFriendsCdn.banner}/${banner.bnImage}" class="img_bnr" alt="${banner.bnAlt}"></a>
          </c:if>
          <c:if test="${banner.bnLinkUse eq 'N'}">
            <img src="${kakaoFriendsCdn.banner}/${banner.bnImage}" class="img_bnr rw_hide" alt="${banner.bnAlt}">
          </c:if>
        </c:forEach>
        <c:forEach items="${banners['15']}" var="banner">
          <c:if test="${banner.bnLinkUse eq 'Y'}">
            <a href="/kr/promotions/recruit" class="link_bnr rw_hide"><img
              src="${kakaoFriendsCdn.banner}/${banner.bnImage}" class="img_bnr" alt="${banner.bnAlt}"></a>
          </c:if>
          <c:if test="${banner.bnLinkUse eq 'N'}">
            <img src="${kakaoFriendsCdn.banner}/${banner.bnImage}" class="img_bnr rw_hide" alt="${banner.bnAlt}">
          </c:if>
        </c:forEach>
      </c:if>
      <c:if test="${!empty(suggestedProducts)}">
        <strong class="tit_item">추천 상품</strong>
        <ul class="list_product">
          <c:forEach items="${suggestedProducts}" var="suggestedProduct">
            <li>
              <a href="/kr/products/${suggestedProduct.product.prCode}" class="link_product">
								<span class="wrap_thumb">
									<si:tenthImageTag type="product" imageName="${suggestedProduct.product.prImage1}"
                                                      altVal=""/>
									<c:if test="${suggestedProduct.isSoldOut}">
                                      <span class="ico_friends ico_soldout">품절</span>
                                    </c:if>
									<c:if test="${!suggestedProduct.isSoldOut and suggestedProduct.isDiscountPeriod}">
                                      <span class="ico_friends ico_sale">세일</span>
                                    </c:if>
								</span>

                <strong class="tit_product">${suggestedProduct.product.prName}</strong>
                <c:if test="${!suggestedProduct.isDiscountPeriod}">
                  <em class="emph_price">
                    <span class="screen_out">금액</span>
                    <span class="current_price">
											<fmt:formatNumber
                                              value="${suggestedProduct.productLevelPrice.prlpSaleprice1}"
                                              type="number"/>원
											<span class="usd_price">(<fmt:formatNumber
                                              value="${suggestedProduct.productLevelPrice.exchangePrice}"
                                              type="number"/> USD)</span>
										</span>
                  </em>
                </c:if>
                <c:if test="${suggestedProduct.isDiscountPeriod}">
                  <em class="emph_price">
                    <span class="screen_out">할인금액</span>
                    <span class="current_price">
											<fmt:formatNumber
                                              value="${suggestedProduct.productLevelPrice.prlpDiscountprice1}"
                                              type="number"/>원
											<span class="usd_price">(<fmt:formatNumber
                                              value="${suggestedProduct.productLevelPrice.exchangeDiscountPrice}"
                                              type="number"/> USD)</span>
										</span>

                    <span class="screen_out">기존금액</span>
                    <span class="prev_price">
											<fmt:formatNumber
                                              value="${suggestedProduct.productLevelPrice.prlpSaleprice1}"
                                              type="number"/>원
											<span class="usd_price">(<fmt:formatNumber
                                              value="${suggestedProduct.productLevelPrice.exchangePrice}"
                                              type="number"/> USD)</span>
										</span>
                  </em>
                </c:if>
              </a>
            </li>
          </c:forEach>
        </ul>
      </c:if>
    </div>
  </div>
</div>

<script src="/resources/js/lodash.min.js"></script>
<script>
  var isEn = false
  var X_CSRF_TOKEN = "${_csrf.token}"
  var displayGoodsGroup = ${displayGoodsGroup};

  var $frm = $('#frm')
  var $boxPurchase = $('.box_purchase')

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
      case 'basket':
        var $btnOpen = $('.btn_open')
        var hasBasketItems = $btnOpen.is(':visible')

        if (displayGoodsGroup.isHasOption && hasBasketItems) {
          break;
        }
        setProductList();

        fbq('track', 'AddToCart', {
          value: '${displayGoodsDetail.displayGoods.salePrice}',
          currency: 'KRW',
          content_ids: ['${productRequest.product.prCode}'],
          content_type: 'product',
          content_category: '${displayGoodsDetail.category.ctName}',
        });
        ga('send', {
          hitType: 'event',
          eventCategory: 'ecommerce',
          eventAction: 'AddToCart',
          eventLabel: 'productCode',
          eventValue: '${productRequest.product.prCode}',
        });

        $frm.attr('action', '/${language}/basket/basket/insert');
        $frm.submit();
        break;
      case 'wish':
        fbq('track', 'AddToWishlist', {
          value: '${displayGoodsDetail.displayGoods.salePrice}',
          currency: 'KRW',
          content_ids: ['${productRequest.product.prCode}'],
          content_type: 'product',
          content_category: '${displayGoodsDetail.category.ctName}',
        });
        ga('send', {
          hitType: 'event',
          eventCategory: 'ecommerce',
          eventAction: 'AddToWishlist',
          eventLabel: 'productCode',
          eventValue: '${productRequest.product.prCode}',
        });

        <sec:authorize access="isFullyAuthenticated()">
        $frm.attr('action', '/${language}/mypage/wishlist/insert');
        $frm.submit();
        </sec:authorize>
        break;
      case 'buy':
        var $inputPrEa = $('#prEa')
        var $inputPrEas = $('.list_option').find('[name="prEa"]')
        var $prEas = $('#prEas')

        var prEa = parseInt($inputPrEa.val(), 10)
        var prEas = $.map($inputPrEas, function (input) {
          return parseInt(input.value, 10)
        })

        if (prEa < 1) {
          alertPopup('alert_basketEmpty')
          break;
        }

        if (prEa > 998) {
          break;
        }

        $prEas.val(prEas)

        directBeforeInsertBasket()
    }
  }

  $boxPurchase.on('click', '.btn_buy', submitBuy);

  $boxPurchase.on('click', '.btn_basket', function () {
    <sec:authorize access="isAnonymous()">
    var showNotice = localStorage.getItem("i_do_not_want_sign_up") !== new Date().toDateString();

    if (showNotice) {
      return benefitPopup(function() {
        $(".benefit_layer .buy_nomember").one("click", function() {
          // 비회원 구매
          localStorage.setItem("i_do_not_want_sign_up", new Date().toDateString());
          $('.dimmed_layer').hide();

          var $btnOpen = $('.btn_open')
          var hasBasketItems = $btnOpen.is(':visible')

          if (displayGoodsGroup.isHasOption && hasBasketItems) {
            return
          }
          setProductList();

          fbq('track', 'AddToCart', {
            value: '${displayGoodsDetail.displayGoods.salePrice}',
            currency: 'KRW',
            content_ids: ['${productRequest.product.prCode}'],
            content_type: 'product',
            content_category: '${displayGoodsDetail.category.ctName}',
          });
          ga('send', {
            hitType: 'event',
            eventCategory: 'ecommerce',
            eventAction: 'AddToCart',
            eventLabel: 'productCode',
            eventValue: '${productRequest.product.prCode}',
          });

          $frm.attr('action', '/${language}/basket/basket/insert');
          $frm.submit();
        });
        $(".benefit_layer .buy_member").one("click", function() {
          // 회원가입 또는 로그인
          $('.dimmed_layer').hide();
          location.href = '/auth/kakao?disable_approval_window=false&redirect_url=' +
            encodeURIComponent(window.location.href.split('?')[0] + '?action=basket');
        });
      });
    }
    </sec:authorize>

    var $btnOpen = $('.btn_open');
    var hasBasketItems = $btnOpen.is(':visible');

    if (displayGoodsGroup.isHasOption && hasBasketItems) {
      return;
    }
    setProductList();

    fbq('track', 'AddToCart', {
      value: '${displayGoodsDetail.displayGoods.salePrice}',
      currency: 'KRW',
      content_ids: ['${productRequest.product.prCode}'],
      content_type: 'product',
      content_category: '${displayGoodsDetail.category.ctName}',
    });
    ga('send', {
      hitType: 'event',
      eventCategory: 'ecommerce',
      eventAction: 'AddToCart',
      eventLabel: 'productCode',
      eventValue: '${productRequest.product.prCode}',
    });

    $frm.attr('action', '/${language}/basket/basket/insert');
    $frm.submit();
  });

  $boxPurchase.on('click', '.btn_wish', function () {
    fbq('track', 'AddToWishlist', {
      value: '${displayGoodsDetail.displayGoods.salePrice}',
      currency: 'KRW',
      content_ids: ['${productRequest.product.prCode}'],
      content_type: 'product',
      content_category: '${displayGoodsDetail.category.ctName}',
    });
    ga('send', {
      hitType: 'event',
      eventCategory: 'ecommerce',
      eventAction: 'AddToWishlist',
      eventLabel: 'productCode',
      eventValue: '${productRequest.product.prCode}',
    });

    <sec:authorize access="isAnonymous()">
    var showNotice = localStorage.getItem("i_do_not_want_sign_up") !== new Date().toDateString();

    if (showNotice) {
      return benefitPopup(function() {
        $(".benefit_layer .buy_nomember").one("click", function() {
          // 비회원 구매
          localStorage.setItem("i_do_not_want_sign_up", new Date().toDateString());
          $('.dimmed_layer').hide();
        });
        $(".benefit_layer .buy_member").one("click", function() {
          // 회원가입 또는 로그인
          $('.dimmed_layer').hide();
          location.href = '/auth/kakao?disable_approval_window=false&redirect_url=' +
            encodeURIComponent(window.location.href.split('?')[0] + '?action=wish');
        });
      });
    }
    </sec:authorize>
    <sec:authorize access="isFullyAuthenticated()">

    $frm.attr('action', '/${language}/mypage/wishlist/insert');
    $frm.submit();

    </sec:authorize>
  })

  $boxPurchase.on('keydown', '#prEa', function (e) {
    if (e.keyCode === 13) {
      submitBuy();
    }
  });

  function submitBuy() {
    <sec:authorize access="isAnonymous()">
    var showNotice = localStorage.getItem("i_do_not_want_sign_up") !== new Date().toDateString();

    if (showNotice) {
      return benefitPopup(function() {
        $(".benefit_layer .buy_nomember").one("click", function() {
          // 비회원 구매
          localStorage.setItem("i_do_not_want_sign_up", new Date().toDateString());
          $('.dimmed_layer').hide();

          var $inputPrEa = $('#prEa');
          var $inputPrEas = $('.list_option').find('[name="prEa"]');
          var $prEas = $('#prEas');

          var prEa = parseInt($inputPrEa.val(), 10);
          var prEas = $.map($inputPrEas, function (input) {
            return parseInt(input.value, 10);
          });

          if (prEa < 1) {
            alertPopup('alert_basketEmpty');
            return false;
          }

          if (prEa > 998) {
            return false;
          }

          $prEas.val(prEas);

          directBeforeInsertBasket();
        });
        $(".benefit_layer .buy_member").one("click", function() {
          // 회원가입 또는 로그인
          location.href = '/auth/kakao?disable_approval_window=false&redirect_url=' +
            encodeURIComponent(window.location.href.split('?')[0] + '?action=buy');
          $('.dimmed_layer').hide();
        });
      });
    }
    </sec:authorize>

    var $inputPrEa = $('#prEa');
    var $inputPrEas = $('.list_option').find('[name="prEa"]');
    var $prEas = $('#prEas');

    var prEa = parseInt($inputPrEa.val(), 10);
    var prEas = $.map($inputPrEas, function (input) {
      return parseInt(input.value, 10);
    })

    if (prEa < 1) {
      alertPopup('alert_basketEmpty');
      return false;
    }

    if (prEa > 998) {
      return false;
    }

    $prEas.val(prEas);

    directBeforeInsertBasket();
  }

  function fn_getRecentProduct() {
    $.ajax({
      headers: {'X-CSRF-TOKEN': '${_csrf.token}'},
      url: '/kr/products/recentProducts',
      type: 'POST',
      dataType: 'json',
      data: {},
      async: false,
      error: function (error) {
        console.error(error)
        // alert('처리중 에러가 발생하였습니다.')
        return false
      },
      success: function (data) {
        var html = ''
        var filterdData = _.filter(data, Boolean)

        for (var cnt in filterdData) {
          html += '<li>'

          if (data[cnt].displayGoods.krView == 'N') {
            html += "<a href='#none' class='link_product'>"
          } else {
            html +=
              "<a href='/kr/products/" +
              data[cnt].displayGoods.id +
              "' class='link_product'>"
          }

          html += "<span class='wrap_thumb'>"
          html +=
            "<img src='" +
            data[cnt].displayGoods.image1 +
            "' class='thumb_g' alt=''>"

          html += '</span>'
          html += "<strong class='tit_product'>"

          if (data[cnt].displayGoods.krView == 'N') {
            html += "<span class='state_soldout'>[판매불가]</span>" + ' '
          } else if (data[cnt].isSoldOut) {
            html += "<span class='state_soldout'>[품절]</span>" + ' '
          } else if (data[cnt].isDiscountPeriod) {
            html += "<span class='state_sale'>[할인]</span>" + ' '
          }

          html += data[cnt].displayGoods.name + '</strong>'
          html +=
            "<em class='emph_price'><span class='txt_price'>금액 : </span><span class='desc_price'>"

          if (data[cnt].isDiscountPeriod) {
            html += "<span class='screen_out'>할인금액</span> "
            html +=
              "<span class='current_price'>" +
              data[cnt].displayGoods.discountPrice
                .toString()
                .replace(/\B(?=(\d{3})+(?!\d))/g, ',') +
              "원 <span class='usd_price'>(" +
              data[cnt].displayGoods.exchangeDiscountPrice.toString() +
              ' USD)</span></span>'
            html += "<span class='screen_out'>기존금액</span> "
            html +=
              "<span class='prev_price'>" +
              data[cnt].displayGoods.salePrice
                .toString()
                .replace(/\B(?=(\d{3})+(?!\d))/g, ',') +
              "원 <span class='usd_price'>(" +
              data[cnt].displayGoods.exchangePrice.toString() +
              ' USD)</span></span>'
          } else {
            html +=
              "<span class='current_price'>" +
              data[cnt].displayGoods.salePrice
                .toString()
                .replace(/\B(?=(\d{3})+(?!\d))/g, ',') +
              "원 <span class='usd_price'>(" +
              data[cnt].displayGoods.exchangePrice.toString() +
              ' USD) </span></span>'
          }

          html += '</span></em></a></li>'
        }

        $('#recentProducts').append(html)
      }
    })
  }

  function directBeforeInsertBasket() {
    var $frm = $('#frm')
    setProductList();
    var formData = $frm.serialize()

    $.ajax({
      headers: {'X-CSRF-TOKEN': '${_csrf.token}'},
      url: '/kr/basket/basket/directInsert',
      type: 'POST',
      dataType: 'json',
      data: formData,
      async: false,
      error: function () {
        window.location.href = '/signin?sessionExpired=true'
        return false
      },
      success: function (data) {
        var $bsSeq = $('#bsSeq')

        if (data !== null) {
          $bsSeq.val(data.bsSeq == null ? data.bsSeqs : data.bsSeq);
          $frm.submit()

          return false
        }

        alertNoti('error.occurred')
      }
    })
  }

  function setProductList() {
    $("#frm input[name^='productList']").remove();

    var $prCodes = $('[data-prcode]')

    $prCodes.find('input').prop('disabled', false);
    $.map($prCodes, function (item, indx) {
      var $item = $(item)
      var prCode = $item.data('prcode')
      var prEa = parseInt($item.find('[name="prEa"]').val(), 10)

      $frm.append('<input type="hidden" name="productList[' + indx + '].prCode" value=\"' + prCode + '\">');
      $frm.append('<input type="hidden" name="productList[' + indx + '].prEa" value=\"' + prEa + '\">');
      $frm.append('<input type="hidden" name="productList[' + indx + '].oaCountry" value="KR">');
    })

    $prCodes.find('input').prop('disabled', true)
  }

  $(document).ready(function () {
    <c:if test="${!empty basketPopup}">
    <c:choose>
    <c:when test="${basketPopup}">
    basketPopup()
    </c:when>
    <c:otherwise>
    alertPopup('alert_alreadyBasket_giftBag_detail')
    </c:otherwise>
    </c:choose>
    </c:if>

    fn_getRecentProduct()

    <c:if test="${!empty emptyMessage}">
    var emptyMessage = '${emptyMessage}'
    alertPopup(emptyMessage)
    </c:if>
  })
</script>
<script src="/resources/js/friends-detail.js?${deployVersion}"></script>
<c:if test="${displayGoodsDetail.displayGoods.id == '4837'}">
  <script type="text/javascript" charset="UTF-8" src="//t1.daumcdn.net/adfit/static/kp.js"></script>
  <script type="text/javascript">kakaoPixel('5931839826969542280').pageView();</script>
</c:if>