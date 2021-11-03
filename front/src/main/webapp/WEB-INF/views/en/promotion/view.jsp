<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="si" uri="http://www.kakaofriends.com/si" %>
<%--${promotionExpansion.promotion.prmContent}--%>
<div id="mArticle">
    <div class="cont_landing">
        <!-- 랜딩페이지 PC -->
        <div class="landing_pc">
            ${promotionExpansion.promotion.prmContent}
        </div>
        <!-- // 랜딩페이지 PC -->
        <!-- 랜딩페이지 모바일 -->
        <div class="landing_mw">
            ${promotionExpansion.promotion.prmEtc2}
        </div>
        <!-- // 랜딩페이지 모바일 -->
    </div>
    <!-- 추천상품영역 -->
    <c:if test="${!empty(promotionExpansion.suggestedProducts)}">
    <div class="cont_detail detail_product">
        <div class="inner_detail">
            <strong class="tit_item">Related Friends</strong>
            <ul class="list_product">
                <c:forEach items="${promotionExpansion.suggestedProducts}" var="suggestedProduct">
                    <li>
                        <a href="/en/products/${suggestedProduct.product.prCode}" class="link_product">
                            <span class="wrap_thumb">
                               <%--<img src="${kakaoFriendsCdn.product}/${empty suggestedProduct.product.prImage12 ? suggestedProduct.product.prImage1 : suggestedProduct.product.prImage12}" class="thumb_g" alt="">--%>
                               <si:tenthImageTag type="product" imageName="${suggestedProduct.product.prImage1}" altVal=""/>
                               <c:if test="${suggestedProduct.isSoldOut}">
                                   <span class="ico_friends ico_soldout">soldout</span>
                               </c:if>
                               <c:if test="${!suggestedProduct.isSoldOut and suggestedProduct.isDiscountPeriod}">
                                    <span class="ico_friends ico_sale">sale</span>
                               </c:if>
                            </span>
                            <strong class="tit_product">${empty suggestedProduct.product.prName1 ? suggestedProduct.product.prName : suggestedProduct.product.prName1}</strong>
                            <c:if test="${!suggestedProduct.isDiscountPeriod}">
                            <em class="emph_price">
                                <span class="screen_out">Price</span><span class="current_price"><fmt:formatNumber value="${suggestedProduct.productLevelPrice.prlpSaleprice1}" type="number"/>KRW <span class="usd_price">(<fmt:formatNumber value="${suggestedProduct.productLevelPrice.exchangePrice}" type="number"/> USD)</span></span><!-- 2017-06-21 수정 -->
                            </em>
                            </c:if>
                            <c:if test="${suggestedProduct.isDiscountPeriod}">
                            <em class="emph_price">
                                <span class="screen_out">Sale Price</span><span class="current_price"><fmt:formatNumber value="${suggestedProduct.productLevelPrice.prlpDiscountprice1}" type="number"/>KRW <span class="usd_price">(<fmt:formatNumber value="${suggestedProduct.productLevelPrice.exchangeDiscountPrice}" type="number"/> USD)</span></span><!-- 2017-06-21 수정 -->
                                <span class="screen_out">Price</span><span class="prev_price"><fmt:formatNumber value="${suggestedProduct.productLevelPrice.prlpSaleprice1}" type="number"/>KRW <span class="usd_price">(<fmt:formatNumber value="${suggestedProduct.productLevelPrice.exchangePrice}" type="number"/> USD)</span></span><!-- 2017-06-21 수정 -->
                            </em>
                            </c:if>
                        </a>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
    </c:if>
    <!-- // 추천상품영역 -->
</div>

<c:set var="prmSeq" value="164"></c:set>
<c:if test="${promotionExpansion.promotion.prmSeq == prmSeq}">
    <script type="text/javascript" charset="UTF-8" src="//t1.daumcdn.net/adfit/static/kp.js"></script>
    <script>kakaoPixel('5931839826969542280').pageView();</script>
</c:if>