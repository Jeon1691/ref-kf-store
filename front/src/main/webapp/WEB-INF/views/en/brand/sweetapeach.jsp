<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="si" uri="http://www.kakaofriends.com/si" %>
<div id="mArticle">

	<div class="view_brand view_sns">
		<div class="head_view">
			<h3 class="tit_view">SNS</h3>
			<div class="txt_category">
				<a href="https://www.instagram.com/p/BiOiS8JlCYK/?hl=ko&taken-by=kakaofriends_official" class="link_txt" target="_blank"><span class="ico_newfriends_v1 ico_insta">인스타그램</span>kakaofriends_official</a>
				<a href="https://www.facebook.com/kakaofriends/photos/pcb.1698021900311468/1698021846978140/?type=3&theater" class="link_txt" target="_blank"><span class="ico_newfriends_v1 ico_facebook">페이스북</span>kakaofriends</a>
			</div>
		</div>
		<div class="slide_friends slide_view">
			<div class="slide_panel">
				<span class="link_slide">
					<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/brand_sweetapeach1.jpg" class="thumb_g" alt="">
				</span>
			</div>
			<div class="slide_panel">
				<span class="link_slide">
					<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/brand_sweetapeach2.jpg" class="thumb_g" alt="">
				</span>
			</div>
			<div class="slide_panel">
				<span class="link_slide">
					<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/brand_sweetapeach3.jpg" class="thumb_g" alt="">
				</span>
			</div>
			<div class="slide_panel">
				<span class="link_slide">
					<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/brand_sweetapeach4.jpg" class="thumb_g" alt="">
				</span>
			</div>
			<div class="slide_panel">
				<span class="link_slide">
					<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/brand_sweetapeach5.jpg" class="thumb_g" alt="">
				</span>
			</div>
			<div class="slide_panel">
				<span class="link_slide">
					<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/brand_sweetapeach6.jpg" class="thumb_g" alt="">
				</span>
			</div>
			<div class="slide_panel">
				<span class="link_slide">
					<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/brand_sweetapeach7.jpg" class="thumb_g" alt="">
				</span>
			</div>
		</div>
		<p class="info_slide">
			모두가 기대하던 쏘-스윗 콜라보레이션, 카카오프렌즈 X 더페이스샵 달콤한 ‘스위트 어피치’ NEW 에디션으로 피치못할 예쁨 뿜뿜 5월 7일에 만나요!
			<em class="emph_info">#카카오프렌즈 #더페이스샵 #콜라보레이션 #스윗어피치 #5월은우리와 #예뻐져요 #뷰티스타그램 #어피치 #일상 #데일리</em>
		</p>
		<!-- 더 많은 브랜드 스토리 -->
		<div class="section_brandstory">
			<h3 class="tit_main" style="color:#000"><!--텍스트 컬러 인라인으로 적용-->더 많은 브랜드 스토리</h3>
			<ul class="list_brand">
				<!-- download type -->
				<li>
					<a href="/en/brand/wallpaper201806" class="link_brand">
						<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_wallpaper_201806.jpg" class="thumb_g" alt="2018년 6월의 배경화면">
						<span class="info_brand">WALLPAPER</span>
						<strong class="tit_brand">2018년 <br>6월의 배경화면</strong>
						<span class="ico_brand ico_down"><span class="ico_newfriends_v1">다운받기</span></span>
					</a>
				</li>
				<!-- video type -->
				<li>
					<a href="/en/brand/flyingryan" class="link_brand">
						<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_flyingryan.jpg" class="thumb_g" alt="하늘을 나는 플라잉 라이언!">
						<span class="info_brand">VIDEO</span>
						<strong class="tit_brand">하늘을 나는 플라잉 라이언!</strong>
						<span class="ico_brand ico_play"><span class="ico_newfriends_v1">재생하기</span></span>
					</a>
				</li>
				<!-- video type -->
				<li>
					<a href="/en/brand/gentlemanryan" class="link_brand">
						<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_gentlemanryan.jpg" class="thumb_g" alt="젠틀맨 라이언의 하루">
						<span class="info_brand">VIDEO</span>
						<strong class="tit_brand">젠틀맨 라이언의 하루</strong>
						<span class="ico_brand ico_play"><span class="ico_newfriends_v1">재생하기</span></span>
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
