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
			<h3 class="tit_view">레츠기릿! 제이지의 쇼타임</h3>
			<em class="txt_category">Video</em>
		</div>
		<div class="box_vod box_fbvod">
			<div class="inner_vod">
				<iframe src="https://www.youtube.com/embed/DvCS2oijbz8?rel=0&amp;showinfo=0" title="카카오프렌즈-비밀요원 두더지 제이지의 모든 것 (The secretive undercover agent Jay-G)" frameborder="0" allowfullscreen></iframe>
			</div>
		</div>
		<p class="desc_video">Turn Up, 제이지! 힙합을 사랑하는 제이지의 꿈을 향한 끊임없는 도전. 지금 바로 감상하세요!</p>
		<!-- 더 많은 브랜드 스토리 -->
		<div class="section_brandstory">
			<h3 class="tit_main" style="color:#000"><!--텍스트 컬러 인라인으로 적용-->더 많은 브랜드 스토리</h3>
			<ul class="list_brand">
				<!-- sns type -->
				<li class="item_type3">
					<a href="/kr/brand/tmoney" class="link_brand">
						<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_tmoney.jpg" class="thumb_g" alt="티머니">
						<span class="info_brand">SNS</span>
					</a>
				</li>
				<!-- sns type -->
				<li>
					<a href="/kr/brand/emoticon3d" class="link_brand">
						<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_emoticon3d.jpg" class="thumb_g" alt="카카오프렌즈 3D 이모티콘">
						<span class="info_brand">SNS</span>
						<span class="ico_brand ico_play"><span class="ico_newfriends_v1">재생하기</span></span>
					</a>
				</li>
				<!-- video type -->
				<li>
					<a href="/kr/brand/ryanmood" class="link_brand">
						<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_ryanmood.jpg" class="thumb_g" alt="라이언 무드조명">
						<span class="info_brand">VIDEO</span>
						<strong class="tit_brand">라이언 무드조명과 함께 <br>Relaxing time</strong>
						<span class="ico_brand ico_play"><span class="ico_newfriends_v1">재생하기</span></span>
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
