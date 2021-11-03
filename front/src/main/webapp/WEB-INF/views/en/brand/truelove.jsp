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
				<a href="https://www.instagram.com/p/BYHph1WFR1F/?taken-by=kakaofriends_official" class="link_txt" target="_blank"><span class="ico_newfriends_v1 ico_insta">인스타그램</span>kakaofriends_official</a>
				<a href="https://www.facebook.com/kakaofriends/videos/1435414709905523/" class="link_txt" target="_blank"><span class="ico_newfriends_v1 ico_facebook">페이스북</span>kakaofriends</a>
			</div>
		</div>
		<div class="box_vod box_fbvod">
			<div class="inner_vod">
				<iframe src="https://www.youtube.com/embed/xqgPfWg8w7o?rel=0&amp;showinfo=0" title="카카오프렌즈- 네오와 프로도의 러브 스토리, 3D 이모티콘!" frameborder="0" allowfullscreen></iframe>
			</div>
		</div>
		<p class="desc_video">
			공감 백배! 솔직한 연인들의 러브스토리<i class="rw_hide"></i>- 달콤 살벌 네오 프로도 커플을 통해 만나보세요!<br>
			[이모티콘 만나러가기]&nbsp;&nbsp;<a href="https://e.kakao.com/t/true-love" class="link_emoticon" target="_blank">https://e.kakao.com/t/true-love</a>
			<em class="emph_info">#카카오프렌즈_36번째_이모티콘_트루러브 #카카오프렌즈 #트루러브 #이모티콘 #럽스타그램 #남친여친소환 #커플템 #일상 #데일리 #즐거움 #네오 #프로도 #3D이모티콘</em>
		</p>
		<!-- 더 많은 브랜드 스토리 -->
		<div class="section_brandstory">
			<h3 class="tit_main" style="color:#000"><!--텍스트 컬러 인라인으로 적용-->더 많은 브랜드 스토리</h3>
			<ul class="list_brand">
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
				<!-- sns type -->
				<li class="item_type3">
					<a href="/en/brand/thefaceshop" class="link_brand">
						<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_thefaceshop.jpg" class="thumb_g" alt="카카오프렌즈 X 더페이스샵">
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
