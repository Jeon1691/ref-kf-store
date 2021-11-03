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
				<a href="https://www.instagram.com/p/BZLMOyjHfSe/?taken-by=kakaofriends_official" class="link_txt" target="_blank"><span class="ico_newfriends_v1 ico_insta">인스타그램</span>kakaofriends_official</a>
				<a href="https://www.facebook.com/kakaofriends/photos/a.535555719891431.1073741828.534554896658180/1462785617168432/?type=3&theater" class="link_txt" target="_blank"><span class="ico_newfriends_v1 ico_facebook">페이스북</span>kakaofriends</a>
			</div>
		</div>
		<div class="img_txtfit">
			<img src="https://t1.kakaocdn.net/friends/kfo-common/pc/brand/brand_thefaceshop.jpg" class="thumb_g" alt="">
		</div>
		<p class="desc_view txt_medium">
			후디라이언 X 더페이스샵의 즐거운 만남! 세상에서 가장 귀여운 특별한 뷰티 아이템을 만나보세요-
			<em class="emph_info">#카카오프렌즈 #후디라이언 #더페이스샵 #콜라보레이션 #후디라이언콜라보레이션 #라이언 #세젤귀 #소장각 #뷰티아이템 #뷰티스타그램 #일상 #데일리</em>
		</p>
		<!-- 더 많은 브랜드 스토리 -->
		<div class="section_brandstory">
			<h3 class="tit_main" style="color:#000"><!--텍스트 컬러 인라인으로 적용-->더 많은 브랜드 스토리</h3>
			<ul class="list_brand">
				<!-- video type -->
				<li>
					<a href="/en/brand/friendsfactory" class="link_brand">
						<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_friendsfactory.jpg" class="thumb_g" alt="프렌즈 팩토리">
						<span class="info_brand">VIDEO</span>
						<strong class="tit_brand">크리스마스를 기다리는<br>카카오프렌즈!</strong>
						<span class="ico_brand ico_play"><span class="ico_newfriends_v1">재생하기</span></span>
					</a>
				</li>
				<!-- download type -->
				<li>
					<a href="/en/brand/wallpaper" class="link_brand">
						<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_wallpaper_201712.jpg" class="thumb_g" alt="2017년 12월 배경화면">
						<span class="info_brand">WALLPAPER</span>
						<strong class="tit_brand"><span class="screen_out">2017년 </span>12월의 배경화면</strong>
						<span class="ico_brand ico_down"><span class="ico_newfriends_v1">다운받기</span></span>
					</a>
				</li>
				<!-- sns type -->
				<li class="item_type3">
					<a href="/en/brand/callaway" class="link_brand">
						<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_callaway.jpg" class="thumb_g" alt="카카오프렌즈 & 캘러웨이">
						<span class="info_brand">SNS</span>
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
