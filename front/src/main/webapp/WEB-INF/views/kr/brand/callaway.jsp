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
				<a href="https://www.instagram.com/p/BZk0yNJHcCx/?taken-by=kakaofriends_official" class="link_txt" target="_blank"><span class="ico_newfriends_v1 ico_insta">인스타그램</span>kakaofriends_official</a>
				<a href="https://www.facebook.com/kakaofriends/photos/a.535555719891431.1073741828.534554896658180/1471091003004560/?type=3&theater" class="link_txt" target="_blank"><span class="ico_newfriends_v1 ico_facebook">페이스북</span>kakaofriends</a>
			</div>
		</div>
		<div class="img_txtfit">
			<img src="https://t1.kakaocdn.net/friends/kfo-common/pc/brand/brand_callaway.jpg" class="thumb_g" alt="">
		</div>
		<p class="desc_view txt_medium">
			설레는 가을, 카카오프렌즈와 캘러웨이의 필드 나들이! 프렌즈와 함께 더욱 색다른 골프 라이프를 즐겨보세요!
			<em class="emph_info">#카카오프렌즈 #캘러웨이 #콜라보레이션 #골프라이프 #기대해주세요 #일상 #데일리 #라이프스타일 #즐거움 #라이언 #어피치 #신나요 #골프스타그램 #골프</em>
		</p>
		<!-- 연관 상품 -->
		<c:if test="${!empty brdRecommdationList}">
			<div class="section_goods">
				<h3 class="tit_main" style="color:#000"><!--텍스트 컬러 인라인으로 적용-->연관 상품</h3>
				<ul class="list_goods">
					<c:forEach items="${brdRecommdationList}" var="brdRecommdationList">
						<li>
							<a href="/kr/products/${brdRecommdationList.product.prCode}" class="link_goods">
								<span class="frame_thumb"><si:tenthImageTag type="product" imageName="${brdRecommdationList.product.prImage1}" altVal=""/></span>
								<div class="info_item">
									<strong class="tit_item">${brdRecommdationList.product.prName}</strong>
									<span class="txt_price">
										<span class="screen_out">금액</span><span class="num_price"><em class="emph_g"><fmt:formatNumber value="${brdRecommdationList.productLevelPrice.prlpSaleprice1}" type="number"/></em>원 <span class="usd_price"><fmt:formatNumber value="${brdRecommdationList.productLevelPrice.exchangePrice}" type="number"/> USD</span></span>
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
					<a href="/kr/brand/warmryan" class="link_brand">
						<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_warmryan.jpg" class="thumb_g" alt="춥지마 라이언!">
						<span class="info_brand">VIDEO</span>
						<strong class="tit_brand">춥지마 라이언!</strong>
						<span class="ico_brand ico_play"><span class="ico_newfriends_v1">재생하기</span></span>
					</a>
				</li>
				<!-- video type -->
				<li>
					<a href="/kr/brand/friendsfactory" class="link_brand">
						<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_friendsfactory.jpg" class="thumb_g" alt="프렌즈 팩토리">
						<span class="info_brand">VIDEO</span>
						<strong class="tit_brand">크리스마스를 기다리는<br>카카오프렌즈!</strong>
						<span class="ico_brand ico_play"><span class="ico_newfriends_v1">재생하기</span></span>
					</a>
				</li>
				<!-- download type -->
				<li>
					<a href="/kr/brand/wallpaper" class="link_brand">
						<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_wallpaper_201712.jpg" class="thumb_g" alt="2017년 12월 배경화면">
						<span class="info_brand">WALLPAPER</span>
						<strong class="tit_brand"><span class="screen_out">2017년 </span>12월의 배경화면</strong>
						<span class="ico_brand ico_down"><span class="ico_newfriends_v1">다운받기</span></span>
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
