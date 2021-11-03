<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="si" uri="http://www.kakaofriends.com/si" %>
<div id="mArticle">

    <div class="view_brand view_download">
        <div class="head_view">
            <h3 class="tit_view">2018년 10월의 배경화면</h3>
            <em class="txt_category">Wallpaper</em>
        </div>
        <!-- 이미지 브라우저 너비 -->
        <div class="img_fullfit img_fullfit1">
            <img src="https://t1.kakaocdn.net/friends/prod/brand/201810_type1_2880.jpg" class="thumb_g rw_show" alt="2018년 10월의 배경화면"><!-- PC : alt 값 넣어주세요 -->
            <img src="https://t1.kakaocdn.net/friends/kfo-common/mo/m640/brand/thumb_wallpaper_201810_type1.jpg" class="thumb_g rw_hide" alt="2018년 10월의 배경화면"><!-- Moblie : alt 값 넣어주세요 -->
        </div>
        <ul class="list_download">
            <li>
                <a href="/download?url=https://t1.kakaocdn.net/friends/prod/brand/201810_type1_750.jpg" class="link_download" target="_blank" download>
                    <span class="ico_download"><span class="ico_newfriends_v1">2018년 10월의 배경화면 다운로드</span></span>
                    <span class="ico_newfriends_v1 txt_cate cate_ios"></span>
                    <strong class="tit_download">Mobile (iOS)</strong>
                    <span class="screen_out">해상도</span>
                    <span class="txt_spec">750 x 1334</span>
                </a>
            </li>
            <li>
                <a href="/download?url=https://t1.kakaocdn.net/friends/prod/brand/201810_type1_1440.jpg" class="link_download" target="_blank" download>
                    <span class="ico_download"><span class="ico_newfriends_v1">2018년 10월의 배경화면 다운로드</span></span>
                    <span class="ico_newfriends_v1 txt_cate cate_android"></span>
                    <strong class="tit_download">Mobile (Android)</strong>
                    <span class="screen_out">해상도</span>
                    <span class="txt_spec">1440 x 2560</span>
                </a>
            </li>
            <li>
                <a href="/download?url=https://t1.kakaocdn.net/friends/prod/brand/201810_type1_1920.jpg" class="link_download link_pc" target="_blank" download>
                    <span class="ico_download"><span class="ico_newfriends_v1">2018년 10월의 배경화면 다운로드</span></span>
                    <span class="ico_newfriends_v1 txt_cate cate_pc"></span>
                    <strong class="tit_download">PC (16:9)</strong>
                    <span class="screen_out">해상도</span>
                    <span class="txt_spec">1920 x 1080</span>
                </a>
            </li>
            <li>
                <a href="/download?url=https://t1.kakaocdn.net/friends/prod/brand/201810_type1_2880.jpg" class="link_download link_pc" target="_blank" download>
                    <span class="ico_download"><span class="ico_newfriends_v1">2018년 10월의 배경화면 다운로드</span></span>
                    <span class="ico_newfriends_v1 txt_cate cate_pc"></span>
                    <strong class="tit_download">PC (16:10)</strong>
                    <span class="screen_out">해상도</span>
                    <span class="txt_spec">2880 x 1800</span>
                </a>
            </li>
        </ul>
        <!-- 이미지 브라우저 너비 -->
        <div class="img_fullfit img_fullfit1">
            <img src="https://t1.kakaocdn.net/friends/prod/brand/201810_type2_2880.jpg" class="thumb_g rw_show" alt="2018년 10월의 배경화면(달력)"><!-- PC : alt 값 넣어주세요 -->
            <img src="https://t1.kakaocdn.net/friends/kfo-common/mo/m640/brand/thumb_wallpaper_201810_type2.jpg" class="thumb_g rw_hide" alt="2018년 10월의 배경화면(달력)"><!-- Moblie : alt 값 넣어주세요 -->
        </div>
        <ul class="list_download">
            <li>
                <a href="/download?url=https://t1.kakaocdn.net/friends/prod/brand/201810_type2_750.jpg" class="link_download" target="_blank" download>
                    <span class="ico_download"><span class="ico_newfriends_v1">2018년 10월의 배경화면(달력) 다운로드</span></span>
                    <span class="ico_newfriends_v1 txt_cate cate_ios"></span>
                    <strong class="tit_download">Mobile (iOS)</strong>
                    <span class="screen_out">해상도</span>
                    <span class="txt_spec">750 x 1334</span>
                </a>
            </li>
            <li>
                <a href="/download?url=https://t1.kakaocdn.net/friends/prod/brand/201810_type2_1440.jpg" class="link_download" target="_blank" download>
                    <span class="ico_download"><span class="ico_newfriends_v1">2018년 10월의 배경화면(달력) 다운로드</span></span>
                    <span class="ico_newfriends_v1 txt_cate cate_android"></span>
                    <strong class="tit_download">Mobile (Android)</strong>
                    <span class="screen_out">해상도</span>
                    <span class="txt_spec">1440 x 2560</span>
                </a>
            </li>
            <li>
                <a href="/download?url=https://t1.kakaocdn.net/friends/prod/brand/201810_type2_1920.jpg" class="link_download link_pc" target="_blank" download>
                    <span class="ico_download"><span class="ico_newfriends_v1">2018년 10월의 배경화면(달력) 다운로드</span></span>
                    <span class="ico_newfriends_v1 txt_cate cate_pc"></span>
                    <strong class="tit_download">PC (16:9)</strong>
                    <span class="screen_out">해상도</span>
                    <span class="txt_spec">1920 x 1080</span>
                </a>
            </li>
            <li>
                <a href="/download?url=https://t1.kakaocdn.net/friends/prod/brand/201810_type2_2880.jpg" class="link_download link_pc" target="_blank" download>
                    <span class="ico_download"><span class="ico_newfriends_v1">2018년 10월의 배경화면(달력) 다운로드</span></span>
                    <span class="ico_newfriends_v1 txt_cate cate_pc"></span>
                    <strong class="tit_download">PC (16:10)</strong>
                    <span class="screen_out">해상도</span>
                    <span class="txt_spec">2880 x 1800</span>
                </a>
            </li>
        </ul>
        <!-- 연관 상품 -->
        <c:if test="${!empty brdRecommdationList}">
            <div class="section_goods">
                <h3 class="tit_main" style="color:#000"><!--텍스트 컬러 인라인으로 적용-->연관 상품</h3>
                <ul class="list_goods">
                    <c:forEach items="${brdRecommdationList}" var="brdRecommdationList">
                        <li>
                            <a href="/en/products/${brdRecommdationList.product.prCode}" class="link_goods">
                                <span class="frame_thumb"><si:tenthImageTag type="product" imageName="${brdRecommdationList.product.prImage1}" altVal=""/></span>
                                <div class="info_item">
                                    <strong class="tit_item">${brdRecommdationList.product.prName1}</strong>
                                    <span class="txt_price">
										<span class="screen_out">금액</span><span class="num_price"><em class="emph_g"><fmt:formatNumber value="${brdRecommdationList.productLevelPrice.prlpSaleprice1}" type="number"/></em>KRW <span class="usd_price"><fmt:formatNumber value="${brdRecommdationList.productLevelPrice.exchangePrice}" type="number"/> USD</span></span>
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
    				<a href="/en/brand/ryanmood" class="link_brand">
    					<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_ryanmood.jpg" class="thumb_g" alt="라이언 무드조명">
    					<span class="info_brand">VIDEO</span>
    					<strong class="tit_brand">라이언 무드조명과 함께 <br>Relaxing time</strong>
    					<span class="ico_brand ico_play"><span class="ico_newfriends_v1">재생하기</span></span>
    				</a>
    			</li>
                <!-- video type -->
                <li>
                    <a href="/en/brand/jaygshowtime" class="link_brand">
                        <img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_jaygshowtime.jpg" class="thumb_g" alt="제이지의 쇼타임">
                        <span class="info_brand">VIDEO</span>
                        <strong class="tit_brand">레츠기릿! 제이지의 쇼타임</strong>
                        <span class="ico_brand ico_play"><span class="ico_newfriends_v1">재생하기</span></span>
                    </a>
                </li>
                <!-- issue type feed -->
                <li class="item_feed item_type2">
                    <a href="/en/brand/wearekakaofriends" class="link_brand">
                        <img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_aboutfriends_v2.jpg" class="thumb_g" alt="">
                        <img src="https://t1.kakaocdn.net/friends/kfo-common/mo/m640/bg_white.jpg" class="bg_white" alt="">
                        <span class="info_brand info_issue">KAKAO FRIENDS</span>
                        <strong class="tit_brand tit_issue">We are Friends!</strong>
                    </a>
                </li>
            </ul>
            <a href="/en/brand/home" class="link_viewall">전체보기</a>
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
