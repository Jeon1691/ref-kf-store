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
				<a href="https://www.instagram.com/p/BiLaMtolwEb/?hl=ko&taken-by=kakaofriends_official" class="link_txt" target="_blank"><span class="ico_newfriends_v1 ico_insta">인스타그램</span>kakaofriends_official</a>
				<a href="https://www.facebook.com/kakaofriends/photos/a.551388098308193.1073741829.534554896658180/1696689117111413/?type=3&theater" class="link_txt" target="_blank"><span class="ico_newfriends_v1 ico_facebook">페이스북</span>kakaofriends</a>
			</div>
		</div>
		<div class="img_txtfit">
			<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/brand_banyantree.jpg" class="thumb_g rw_show" alt="">
			<img src="https://t1.kakaocdn.net/friends/kfo-common/mo/m640/brand/brand_banyantree.jpg" class="thumb_g rw_hide" alt="">
		</div>
		<p class="desc_view txt_medium">
			카카오프렌즈와 트로피컬 디저트 타임! 반얀트리 서울에서 달콤한 카카오프렌즈 디저트를 만나보세요-
			<em class="emph_info">#카카오프렌즈 #반얀트리 #트로피컬디저트타임 #달콤한 #콜라보레이션 #어피치빙수 #튜브빙수 #라이언망고 #멜론뷔페 #일상 #데일리</em>
		</p>
		<!-- 더 많은 브랜드 스토리 -->
		<div class="section_brandstory">
			<h3 class="tit_main" style="color:#000"><!--텍스트 컬러 인라인으로 적용-->더 많은 브랜드 스토리</h3>
			<ul class="list_brand">
				<!-- video type -->
				<li>
					<a href="/en/brand/gentlemanryan" class="link_brand">
						<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_gentlemanryan.jpg" class="thumb_g" alt="젠틀맨 라이언의 하루">
						<span class="info_brand">VIDEO</span>
						<strong class="tit_brand">젠틀맨 라이언의 하루</strong>
						<span class="ico_brand ico_play"><span class="ico_newfriends_v1">재생하기</span></span>
					</a>
				</li>
				<!-- sns type -->
				<li class="item_type3">
					<a href="/en/brand/sweetapeach" class="link_brand">
						<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_sweetapeach.jpg" class="thumb_g" alt="더페이스샵 (스윗어피치)">
						<span class="info_brand">SNS</span>
					</a>
				</li>
				<!-- video type -->
				<li class="item_type3 item_frame">
					<a href="/en/brand/apeachdiary" class="link_brand">
						<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_apeachdiary.jpg" class="thumb_g" alt="댄싱머신 어피치의 트월킹 실력">
						<span class="info_brand">VIDEO</span>
						<strong class="tit_brand">댄싱머신 어피치의 <br>트월킹 실력</strong>
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
