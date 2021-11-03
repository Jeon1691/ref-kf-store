<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="si" uri="http://www.kakaofriends.com/si" %>
<div id="mArticle">

    <div class="view_brand view_video">
        <div class="head_view">
            <h3 class="tit_view">라이언의 Hello 2019</h3>
            <em class="txt_category">Video</em>
        </div>
        <div class="box_vod box_fbvod">
            <div class="inner_vod">
                <iframe src="https://www.youtube.com/embed/WdnmKTe4v9U?rel=0&amp;showinfo=0" title="라이언의 Hello 2019" frameborder="0" allowfullscreen></iframe>
            </div>
        </div>
        <p class="desc_video">
            라이언 해돋이 보고 새해 소원을 빌어요!<br>
            여러분이 계시는 곳 어디든 환한 빛으로 새해복 가득 보내드릴께요!<br>
            HAPPY NEW YEAR!
        </p>
        <!-- 연관 상품 -->
        <c:if test="${!empty brdRecommdationList}">
            <div class="section_goods">
                <h3 class="tit_main" style="color:#000"><!--텍스트 컬러 인라인으로 적용-->연관 상품</h3>
                <ul class="list_goods">
                    <c:forEach items="${brdRecommdationList}" var="brdRecommdationList">
                        <li>
                            <a href="/kr/products/${brdRecommdationList.product.prCode}" class="link_goods">
                                <span class="frame_thumb"><si:tenthImageTag type="product" imageName="${brdRecommdationList.product.prImage1}" altVal=""/></span>
                                <div class="info_item">
                                    <strong class="tit_item">${brdRecommdationList.product.prName}</strong>
                                    <span class="txt_price">
                                        <span class="screen_out">금액</span><span class="num_price"><em class="emph_g"><fmt:formatNumber value="${brdRecommdationList.productLevelPrice.prlpSaleprice1}" type="number"/></em>원 <span class="usd_price"><fmt:formatNumber value="${brdRecommdationList.productLevelPrice.exchangePrice}" type="number"/> USD</span></span>
                                    </span>
                                </div>
                            </a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </c:if>
        <!-- //연관 상품 -->
        <!-- 더 많은 브랜드 스토리 -->
        <div class="section_brandstory">
            <h3 class="tit_main" style="color:#000"><!--텍스트 컬러 인라인으로 적용-->더 많은 브랜드 스토리</h3>
            <ul class="list_brand">
                <!-- video type -->
                <li>
                    <a href="/kr/brand/wallpaper201901" class="link_brand">
                        <img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_wallpaper_201901.jpg" class="thumb_g" alt="2019년 1월의 배경화면">
                        <span class="info_brand">WALLPAPER</span>
                        <strong class="tit_brand">2019년 <br>1월의 배경화면</strong>
                        <span class="ico_brand ico_down"><span class="ico_newfriends_v1">다운받기</span></span>
                    </a>
                </li>
                <!-- issue type feed -->
                <li class="item_feed item_type2">
                    <a href="/kr/brand/wearekakaofriends" class="link_brand">
                        <img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_aboutfriends_v2.jpg" class="thumb_g" alt="">
                        <img src="https://t1.kakaocdn.net/friends/kfo-common/mo/m640/bg_white.jpg" class="bg_white" alt="">
                        <span class="info_brand info_issue">KAKAO FRIENDS</span>
                        <strong class="tit_brand tit_issue">We are Friends!</strong>
                    </a>
                </li>
                <!-- download type -->
    			<li>
    				<a href="/kr/brand/screen2019" class="link_brand">
    					<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_screen_201901.jpg" class="thumb_g" alt="라이언 해돋이 화면보호기">
    					<span class="info_brand">SCREENSAVER</span>
    					<strong class="tit_brand">라이언 해돋이<br>화면보호기</strong>
    					<span class="ico_brand ico_down"><span class="ico_newfriends_v1">다운받기</span></span>
    				</a>
    			</li>
            </ul>
            <a href="/kr/brand/home" class="link_viewall">전체보기</a>
        </div>
        <!-- //더 많은 브랜드 스토리 -->
        <!-- 공유하기 --
        <div class="share_view">
            <div class="inner_share">
                <strong class="screen_out">SNS 공유하기</strong>
                <a href="#none" class="link_share">
                    <span class="ico_newfriends_v1 ico_facebook">페이스북</span>
                </a>
                <a href="#none" class="link_share">
                    <span class="ico_newfriends_v1 ico_twitter">트위터</span>
                </a>
                <a href="#none" class="link_share">
                    <span class="ico_newfriends_v1 ico_kakaostory">카카오스토리</span>
                </a>
                <a href="#none" class="link_share">
                    <span class="ico_newfriends_v1 ico_kakaotalk">카카오톡</span>
                </a>
            </div>
        </div>
        <!-- //공유하기 -->
    </div>
</div><!--// mArticle -->
