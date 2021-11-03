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
				<a href="https://www.instagram.com/p/BTYn7NegeKI/?taken-by=kakaofriends_official" class="link_txt" target="_blank"><span class="ico_newfriends_v1 ico_insta">인스타그램</span>kakaofriends_official</a>
				<a href="https://www.facebook.com/kakaofriends/photos/a.535555719891431.1073741828.534554896658180/1320268971420098/?type=3&theater" class="link_txt" target="_blank"><span class="ico_newfriends_v1 ico_facebook">페이스북</span>kakaofriends</a>
			</div>
		</div>
		<div class="img_txtfit">
			<img src="https://t1.kakaocdn.net/friends/kfo-common/pc/brand/brand_kiehls.jpg" class="thumb_g" alt="">
		</div>
		<p class="desc_view txt_medium">
			네오와 프로도는 지금, 뉴욕에서 로맨틱한 데이트 중- 카카오프렌즈와 키엘의 콜라보레이션. 사랑스러운 이야기를 함께해요
			<em class="emph_info">#키엘부티크 #4개매장과 #키엘공식온라인몰에서 #만나요 #카카오프렌즈 #키엘 #스페셜에디션 #네오 #프로도</em>
		</p>
		<!-- 더 많은 브랜드 스토리 -->
		<div class="section_brandstory">
			<h3 class="tit_main" style="color:#000"><!--텍스트 컬러 인라인으로 적용-->더 많은 브랜드 스토리</h3>
			<ul class="list_brand">
				<!-- video type -->
				<li class="item_type3">
					<a href="/kr/brand/pandaapeach" class="link_brand">
						<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_pandaapeach.jpg" class="thumb_g" alt="팬더 어피치">
						<span class="info_brand info_issue">VIDEO</span>
						<strong class="tit_brand tit_issue">대나무 숲의<br>팬더 어피치</strong>
						<span class="ico_brand ico_play"><span class="ico_newfriends_v1">재생하기</span></span>
					</a>
				</li>
				<!-- sns type -->
				<li>
					<a href="/kr/brand/ohmyfriends" class="link_brand">
						<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_ohmyfriends.jpg" class="thumb_g" alt="오 마이 프렌즈">
						<span class="info_brand">SNS</span>
					</a>
				</li>
				<!-- issue type feed -->
				<li class="item_feed item_type2">
					<a href="/kr/brand/louisvuitton" class="link_brand">
						<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_louisvuitton.jpg" class="thumb_g" alt="카카오프렌즈 & 루이 비통">
						<img src="https://t1.kakaocdn.net/friends/kfo-common/mo/m640/bg_white.jpg" class="bg_white" alt="">
						<span class="info_brand info_issue">ISSUE</span>
						<strong class="tit_brand tit_issue">카카오프렌즈와 루이 비통,<br>서울에서 만나다</strong>
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
