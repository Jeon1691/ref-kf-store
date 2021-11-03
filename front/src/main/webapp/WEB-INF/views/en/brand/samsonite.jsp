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
				<a href="https://www.instagram.com/p/BXPy20HlS4p/?taken-by=kakaofriends_official" class="link_txt" target="_blank"><span class="ico_newfriends_v1 ico_insta">인스타그램</span>kakaofriends_official</a>
				<a href="https://www.facebook.com/kakaofriends/videos/1415819471865047/" class="link_txt" target="_blank"><span class="ico_newfriends_v1 ico_facebook">페이스북</span>kakaofriends</a>
			</div>
		</div>
		<div class="box_vod box_fbvod">
			<div class="inner_vod">
				<iframe src="https://www.facebook.com/plugins/video.php?href=https%3A%2F%2Fwww.facebook.com%2Fkakaofriends%2Fvideos%2F1415819471865047%2F&show_text=0" title="카카오프렌즈 쌤소나이트 영상" scrolling="no" frameborder="0"></iframe>
			</div>
		</div>
		<p class="desc_video">
			바쁜 일상을 즐거운 여행처럼! 카카오프렌즈와 함께 설레는 도시 여행을 떠나요
			<em class="emph_info">#카카오프렌즈 #쌤소나이트레드 #콜라보레이션 #러기지 #캐리어 #도시여행 #일상 #즐거움 #데일리 #라이언 #어피치 #네오 #여행스타그램 #여행</em>
		</p>
		<!-- 더 많은 브랜드 스토리 -->
		<div class="section_brandstory">
			<h3 class="tit_main" style="color:#000"><!--텍스트 컬러 인라인으로 적용-->더 많은 브랜드 스토리</h3>
			<ul class="list_brand">
				<!-- sns type -->
				<li class="item_type3">
					<a href="/en/brand/thefaceshop" class="link_brand">
						<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_thefaceshop.jpg" class="thumb_g" alt="카카오프렌즈 X 더페이스샵">
						<span class="info_brand">SNS</span>
					</a>
				</li>
				<!-- sns type -->
				<li class="item_type3">
					<a href="/en/brand/truelove" class="link_brand">
						<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_truelove.jpg" class="thumb_g" alt="이모티콘 트루러브">
						<span class="info_brand">SNS</span>
						<span class="ico_brand ico_play"><span class="ico_newfriends_v1">재생하기</span></span>
					</a>
				</li>
				<!-- video type -->
				<li class="item_type3">
					<a href="/en/brand/ribbonryan" class="link_brand">
						<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_ribbonryan.jpg" class="thumb_g" alt="리본 라이언">
						<span class="info_brand info_issue">VIDEO</span>
						<strong class="tit_brand tit_issue">리본을 두르면 행복해져요!</strong>
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
