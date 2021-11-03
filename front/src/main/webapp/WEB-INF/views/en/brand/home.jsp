<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="si" uri="http://www.kakaofriends.com/si" %>
<div id="mSub">
	<div class="feature_brand">
		<h2 id="kakaoBody" class="screen_out">BRAND STORY - 즐겁고 신나는 카카오프렌즈의 이야기</h2>
		<a href="/en/info/charInfo#/en">
			<span class="screen_out">Shortcut - Kakao friends introdution</span>
			<div class="bg_brand"></div>
		</a>
	</div>
</div> <!--// mSub -->

<div id="mArticle">
	<!-- 2017-10-27 실데이터 반영 -->
	<div class="brand_list">
		<strong class="screen_out">컨텐츠 리스트</strong>
		<ul class="list_brand">
			<!-- video type -->
			<li>
				<a href="/en/brand/hello2019" class="link_brand">
					<img src="http://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_hello2019.jpg" class="thumb_g" alt="라이언의 Hello 2019">
					<span class="info_brand">VIDEO</span>
					<strong class="tit_brand">라이언의<br>Hello 2019</strong>
					<span class="ico_brand ico_play"><span class="ico_newfriends_v1">재생하기</span></span>
				</a>
			</li>
			<!-- download type -->
			<li>
				<a href="/en/brand/screen2019" class="link_brand">
					<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_screen_201901.jpg" class="thumb_g" alt="2019년 화면 보호기">
					<span class="info_brand">SCREENSAVER</span>
					<strong class="tit_brand">라이언 해돋이<br>화면보호기</strong>
					<span class="ico_brand ico_down"><span class="ico_newfriends_v1">다운받기</span></span>
				</a>
			</li>
			<!-- download type -->
			<li>
				<a href="/en/brand/wallpaper201901" class="link_brand">
					<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_wallpaper_201901.jpg" class="thumb_g" alt="2019년 1월의 배경화면">
					<span class="info_brand">WALLPAPER</span>
					<strong class="tit_brand">2019년 <br>1월의 배경화면</strong>
					<span class="ico_brand ico_down"><span class="ico_newfriends_v1">다운받기</span></span>
				</a>
			</li>
			<!-- download type -->
			<li>
				<a href="/en/brand/wallpaper201812" class="link_brand">
					<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_wallpaper_201812.jpg" class="thumb_g" alt="2018년 12월의 배경화면">
					<span class="info_brand">WALLPAPER</span>
					<strong class="tit_brand">2018년 <br>12월의 배경화면</strong>
					<span class="ico_brand ico_down"><span class="ico_newfriends_v1">다운받기</span></span>
				</a>
			</li>
            <!-- download type -->
            <li>
                <a href="/en/brand/wallpaper201811" class="link_brand">
                    <img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_wallpaper_201811.jpg" class="thumb_g" alt="2018년 11월의 배경화면">
                    <span class="info_brand">WALLPAPER</span>
                    <strong class="tit_brand">2018년 <br>11월의 배경화면</strong>
                    <span class="ico_brand ico_down"><span class="ico_newfriends_v1">다운받기</span></span>
                </a>
            </li>
			<!-- download type -->
			<li>
				<a href="/en/brand/wallpaper201810" class="link_brand">
					<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_wallpaper_201810.jpg" class="thumb_g" alt="2018년 10월의 배경화면">
					<span class="info_brand">WALLPAPER</span>
					<strong class="tit_brand">2018년 <br>10월의 배경화면</strong>
					<span class="ico_brand ico_down"><span class="ico_newfriends_v1">다운받기</span></span>
				</a>
			</li>
			<!-- video type -->
			<li>
				<a href="/en/brand/kconLA" class="link_brand">
					<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_kconLA.jpg" class="thumb_g" alt="KAKAO FRIENDS in Los Angeles, KCON18 LA">
					<span class="info_brand">VIDEO</span>
					<strong class="tit_brand">KAKAO FRIENDS in Los Angeles, KCON18 LA</strong>
					<span class="ico_brand ico_play"><span class="ico_newfriends_v1">재생하기</span></span>
				</a>
			</li>
			<!-- download type -->
			<li>
				<a href="/en/brand/wallpaper201809" class="link_brand">
					<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_wallpaper_201809.jpg" class="thumb_g" alt="2018년 9월의 배경화면">
					<span class="info_brand">WALLPAPER</span>
					<strong class="tit_brand">2018년 <br>9월의 배경화면</strong>
					<span class="ico_brand ico_down"><span class="ico_newfriends_v1">다운받기</span></span>
				</a>
			</li>
			<!-- video type -->
			<li>
				<a href="/en/brand/hotelDeRyan" class="link_brand">
					<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_hotelDeRyan.jpg" class="thumb_g" alt="라이언의 호캉스 즐기기">
					<span class="info_brand">VIDEO</span>
					<strong class="tit_brand">라이언의 호캉스 즐기기</strong>
					<span class="ico_brand ico_play"><span class="ico_newfriends_v1">재생하기</span></span>
				</a>
			</li>
			<!-- download type -->
			<li>
				<a href="/en/brand/wallpaper201808" class="link_brand">
					<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_wallpaper_201808.jpg" class="thumb_g" alt="2018년 8월의 배경화면">
					<span class="info_brand">WALLPAPER</span>
					<strong class="tit_brand">2018년 <br>8월의 배경화면</strong>
					<span class="ico_brand ico_down"><span class="ico_newfriends_v1">다운받기</span></span>
				</a>
			</li>
			<!-- video type -->
			<li>
				<a href="/en/brand/summerFriends3" class="link_brand">
					<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_summerfriends3.jpg" class="thumb_g" alt="프렌즈의 즐거운 여름 나기! ver. 비치볼">
					<span class="info_brand">VIDEO</span>
					<strong class="tit_brand">프렌즈의 즐거운 여름 나기! ver. 비치볼</strong>
					<span class="ico_brand ico_play"><span class="ico_newfriends_v1">재생하기</span></span>
				</a>
			</li>
			<!-- video type -->
			<li>
				<a href="/en/brand/summerFriends2" class="link_brand">
					<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_summerfriends2.jpg" class="thumb_g" alt="프렌즈의 즐거운 여름 나기! ver. 서핑보드">
					<span class="info_brand">VIDEO</span>
					<strong class="tit_brand">프렌즈의 즐거운 여름 나기! ver. 서핑보드</strong>
					<span class="ico_brand ico_play"><span class="ico_newfriends_v1">재생하기</span></span>
				</a>
			</li>
			<!-- video type -->
			<li>
				<a href="/en/brand/summerFriends1" class="link_brand">
					<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_summerfriends1.jpg" class="thumb_g" alt="프렌즈의 즐거운 여름 나기! ver. 매트튜브">
					<span class="info_brand">VIDEO</span>
					<strong class="tit_brand">프렌즈의 즐거운 여름 나기! ver. 매트튜브</strong>
					<span class="ico_brand ico_play"><span class="ico_newfriends_v1">재생하기</span></span>
				</a>
			</li>
			<!-- download type -->
			<li>
				<a href="/en/brand/wallpaper201807" class="link_brand">
					<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_wallpaper_201807.jpg" class="thumb_g" alt="2018년 7월의 배경화면">
					<span class="info_brand">WALLPAPER</span>
					<strong class="tit_brand">2018년 <br>7월의 배경화면</strong>
					<span class="ico_brand ico_down"><span class="ico_newfriends_v1">다운받기</span></span>
				</a>
			</li>
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
			<!-- sns type -->
			<li>
				<a href="/en/brand/banyantree" class="link_brand">
					<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_banyantree.jpg" class="thumb_g" alt="반얀트리 (트로피컬 디저트타임)">
					<span class="info_brand">SNS</span>
				</a>
			</li>
			<!-- download type -->
			<li class="item_type3">
				<a href="/en/brand/wallpaper201805" class="link_brand">
					<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_wallpaper_201805.jpg" class="thumb_g" alt="2018년 5월의 배경화면">
					<span class="info_brand">WALLPAPER</span>
					<strong class="tit_brand">2018년 <br>5월의 배경화면</strong>
					<span class="ico_brand ico_down"><span class="ico_newfriends_v1">다운받기</span></span>
				</a>
			</li>
			<!-- video type -->
			<li>
				<a href="/en/brand/friendsgarden" class="link_brand">
					<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_friendsgarden.jpg" class="thumb_g" alt="카카오프렌즈 비밀의 정원">
					<span class="info_brand">VIDEO</span>
					<strong class="tit_brand">카카오프렌즈 비밀의 정원</strong>
					<span class="ico_brand ico_play"><span class="ico_newfriends_v1">재생하기</span></span>
				</a>
			</li>
			<!-- download type -->
			<li>
				<a href="/en/brand/wallpaper201804" class="link_brand">
					<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_wallpaper_201804.jpg" class="thumb_g" alt="2018년 4월의 배경화면">
					<span class="info_brand">WALLPAPER</span>
					<strong class="tit_brand">2018년 <br>4월의 배경화면</strong>
					<span class="ico_brand ico_down"><span class="ico_newfriends_v1">다운받기</span></span>
				</a>
			</li>
			<!-- video type -->
			<li class="item_type3">
				<a href="/en/brand/apeachblossom" class="link_brand">
					<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_apeachblossom.jpg" class="thumb_g" alt="어피치 뷰티팁 공개!">
					<span class="info_brand">VIDEO</span>
					<strong class="tit_brand">어피치 뷰티팁 공개!</strong>
					<span class="ico_brand ico_play"><span class="ico_newfriends_v1">재생하기</span></span>
				</a>
			</li>
			<!-- download type -->
			<li class="item_type3">
				<a href="/en/brand/wallpaper201803" class="link_brand">
					<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_wallpaper_201803.jpg" class="thumb_g" alt="2018년 3월의 배경화면">
					<span class="info_brand">WALLPAPER</span>
					<strong class="tit_brand">2018년 <br>3월의 배경화면</strong>
					<span class="ico_brand ico_down"><span class="ico_newfriends_v1">다운받기</span></span>
				</a>
			</li>
			<!-- download type -->
			<li class="item_type3">
				<a href="/en/brand/wallpaper201802" class="link_brand">
					<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_wallpaper_201802.jpg" class="thumb_g" alt="2018년 2월의 배경화면">
					<span class="info_brand">WALLPAPER</span>
					<strong class="tit_brand">2018년 <br>2월의 배경화면</strong>
					<span class="ico_brand ico_down"><span class="ico_newfriends_v1">다운받기</span></span>
				</a>
			</li>
			<!-- video type -->
			<li>
				<a href="/en/brand/happynewyear2018" class="link_brand">
					<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_happynewyear2018.jpg" class="thumb_g" alt="카카오프렌즈가 전하는 복 받으세요!">
					<span class="info_brand">VIDEO</span>
					<strong class="tit_brand">카카오프렌즈가 전하는 <br>복 받으세요</strong>
					<span class="ico_brand ico_play"><span class="ico_newfriends_v1">재생하기</span></span>
				</a>
			</li>
			<!-- download type -->
			<li class="item_type3">
				<a href="/en/brand/wallpaper201801" class="link_brand">
					<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_wallpaper_201801.jpg" class="thumb_g" alt="2018년 1월의 배경화면">
					<span class="info_brand">WALLPAPER</span>
					<strong class="tit_brand">2018년 <br>1월의 배경화면</strong>
					<span class="ico_brand ico_down"><span class="ico_newfriends_v1">다운받기</span></span>
				</a>
			</li>
			<!-- video type -->
			<li>
				<a href="/en/brand/warmryan" class="link_brand">
					<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_warmryan.jpg" class="thumb_g" alt="춥지마 라이언!">
					<span class="info_brand">VIDEO</span>
					<strong class="tit_brand">춥지마 라이언!</strong>
					<span class="ico_brand ico_play"><span class="ico_newfriends_v1">재생하기</span></span>
				</a>
			</li>
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
					<!-- <strong class="tit_brand tit_sns">@kakaofriends_official</strong> -->
				</a>
			</li>
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
			<!-- sns type -->
			<li>
				<a href="/en/brand/samsonite" class="link_brand">
					<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_samsonite.jpg" class="thumb_g" alt="카카오프렌즈 & 샘소나이트">
					<span class="info_brand">SNS</span>
					<span class="ico_brand ico_play"><span class="ico_newfriends_v1">재생하기</span></span>
				</a>
			</li>
			<!-- video type -->
			<li class="item_type3">
				<a href="/en/brand/pandaapeach" class="link_brand">
					<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_pandaapeach.jpg" class="thumb_g" alt="팬더 어피치">
					<span class="info_brand info_issue">VIDEO</span>
					<strong class="tit_brand tit_issue">대나무 숲의<br>팬더 어피치</strong>
					<span class="ico_brand ico_play"><span class="ico_newfriends_v1">재생하기</span></span>
				</a>
			</li>
			<!-- sns type -->
			<li>
				<a href="/en/brand/ohmyfriends" class="link_brand">
					<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_ohmyfriends.jpg" class="thumb_g" alt="오 마이 프렌즈">
					<span class="info_brand">SNS</span>
				</a>
			</li>
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
			<!-- sns type -->
			<li>
				<a href="/en/brand/emoticon3d" class="link_brand">
					<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_emoticon3d.jpg" class="thumb_g" alt="카카오프렌즈 3D 이모티콘">
					<span class="info_brand">SNS</span>
					<span class="ico_brand ico_play"><span class="ico_newfriends_v1">재생하기</span></span>
				</a>
			</li>
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
		<!--<button type="botton" class="btn_more">더보기</button>-->
	</div>
	<!-- //2017-10-27 실데이터 반영 -->
</div>
<!--// mArticle -->
