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
				<a href="https://www.instagram.com/p/BR40LY0AuCy/?taken-by=kakaofriends_official" class="link_txt" target="_blank"><span class="ico_newfriends_v1 ico_insta">인스타그램</span>kakaofriends_official</a>
				<a href="https://www.facebook.com/kakaofriends/videos/1278786098901719/" class="link_txt" target="_blank"><span class="ico_newfriends_v1 ico_facebook">페이스북</span>kakaofriends</a>
			</div>
		</div>
		<div class="box_vod box_fbvod">
			<div class="inner_vod">
				<iframe src="https://www.youtube.com/embed/7ylEmNMM9eQ?rel=0&amp;showinfo=0" title="카카오프렌즈 - 생생한 3D이모티콘 출시 2" frameborder="0" allowfullscreen></iframe>
			</div>
		</div>
		<p class="desc_video">
			카카오프렌즈의 첫 3D 이모티콘으로 오늘 하루를 더 즐겁고 생생하게! 새로운 변화를, 지금 바로 만나보세요!<br>
			[이모티콘 만나러가기]&nbsp;&nbsp;<a href="https://e.kakao.com/t/real-friends" class="link_emoticon" target="_blank">https://e.kakao.com/t/real-friends</a>
			<em class="emph_info">#카카오프렌즈 #카카오톡 #3D이모티콘 #24종 #라이언 #어피치 #무지 #이모티콘</em>
		</p>
		<!-- 더 많은 브랜드 스토리 -->
		<div class="section_brandstory">
			<h3 class="tit_main" style="color:#000"><!--텍스트 컬러 인라인으로 적용-->더 많은 브랜드 스토리</h3>
			<ul class="list_brand">
				<!-- issue type feed -->
				<li class="item_feed item_type2">
					<a href="/en/brand/louisvuitton" class="link_brand">
						<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_louisvuitton.jpg" class="thumb_g" alt="카카오프렌즈 & 루이 비통">
						<img src="https://t1.kakaocdn.net/friends/kfo-common/mo/m640/bg_white.jpg" class="bg_white" alt="">
						<span class="info_brand info_issue">ISSUE</span>
						<strong class="tit_brand tit_issue">카카오프렌즈와 루이 비통,<br>서울에서 만나다</strong>
					</a>
				</li>
				<!-- sns type -->
				<li class="item_type3">
					<a href="/en/brand/kiehls" class="link_brand">
						<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_kiehls.jpg" class="thumb_g" alt="카카오프렌즈 & 키엘">
						<span class="info_brand">SNS</span>
					</a>
				</li>
				<!-- sns type -->
				<li class="item_type3">
					<a href="/en/brand/tmoney" class="link_brand">
						<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_tmoney.jpg" class="thumb_g" alt="티머니">
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
