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
				<a href="https://www.instagram.com/p/BWPZ96mFoSz/?taken-by=kakaofriends_official" class="link_txt" target="_blank"><span class="ico_newfriends_v1 ico_insta">인스타그램</span>kakaofriends_official</a>
				<a href="https://www.facebook.com/kakaofriends/photos/a.551388098308193.1073741829.534554896658180/1391456457634682/?type=3&theater" class="link_txt" target="_blank"><span class="ico_newfriends_v1 ico_facebook">페이스북</span>kakaofriends</a>
			</div>
		</div>
		<div class="slide_friends slide_view">
			<div class="slide_panel">
				<a href="#none" class="link_slide">
					<img src="https://t1.kakaocdn.net/friends/kfo-common/pc/brand/brand_ohmyfriends1.jpg" class="thumb_g" alt="">

				</a>
			</div>
			<div class="slide_panel">
				<a href="#none" class="link_slide">
					<img src="https://t1.kakaocdn.net/friends/kfo-common/pc/brand/brand_ohmyfriends2.jpg" class="thumb_g" alt="">

				</a>
			</div>
			<div class="slide_panel">
				<a href="#none" class="link_slide">
					<img src="https://t1.kakaocdn.net/friends/kfo-common/pc/brand/brand_ohmyfriends3.jpg" class="thumb_g" alt="">

				</a>
			</div>
			<div class="slide_panel">
				<a href="#none" class="link_slide">
					<img src="https://t1.kakaocdn.net/friends/kfo-common/pc/brand/brand_ohmyfriends4.jpg" class="thumb_g" alt="">

				</a>
			</div>
			<div class="slide_panel">
				<a href="#none" class="link_slide">
					<img src="https://t1.kakaocdn.net/friends/kfo-common/pc/brand/brand_ohmyfriends5.jpg" class="thumb_g" alt="">

				</a>
			</div>
			<div class="slide_panel">
				<a href="#none" class="link_slide">
					<img src="https://t1.kakaocdn.net/friends/kfo-common/pc/brand/brand_ohmyfriends6.jpg" class="thumb_g" alt="">

				</a>
			</div>
			<div class="slide_panel">
				<a href="#none" class="link_slide">
					<img src="https://t1.kakaocdn.net/friends/kfo-common/pc/brand/brand_ohmyfriends7.jpg" class="thumb_g" alt="">

				</a>
			</div>
			<div class="slide_panel">
				<a href="#none" class="link_slide">
					<img src="https://t1.kakaocdn.net/friends/kfo-common/pc/brand/brand_ohmyfriends8.jpg" class="thumb_g" alt="">

				</a>
			</div>
			<div class="slide_panel">
				<a href="#none" class="link_slide">
					<img src="https://t1.kakaocdn.net/friends/kfo-common/pc/brand/brand_ohmyfriends9.jpg" class="thumb_g" alt="">

				</a>
			</div>
			<div class="slide_panel">
				<a href="#none" class="link_slide">
					<img src="https://t1.kakaocdn.net/friends/kfo-common/pc/brand/brand_ohmyfriends10.jpg" class="thumb_g" alt="">

				</a>
			</div>
		</div>
		<span class="info_slide">
			위트 있는 주말의 시작, 'Oh, My Friends!' 매일 반복되는 평범한 일상에 ‘오마이프렌즈’가 찾아갑니다. 카카오프렌즈와 함께, 에너지 넘치는 데일리 라이프를 경험하세요!
			<em class="emph_info">#카카오프렌즈 #오마이프렌즈 #OhMyFriends #OMF #엑티브웨어 #오늘 #만나요 #강남점 #홍대점 #코엑스점 #DDP점 #온라인스토어 #위트 #주말 #휴식 #릴렉스 #에너지</em>
		</span>
		<!-- 연관 상품 -->
		<c:if test="${!empty brdRecommdationList}">
			<div class="section_goods">
				<h3 class="tit_main" style="color:#000"><!--텍스트 컬러 인라인으로 적용-->연관 상품</h3>
				<ul class="list_goods">
					<c:forEach items="${brdRecommdationList}" var="brdRecommdationList">
						<li>
							<a href="/en/products/${brdRecommdationList.product.prCode}" class="link_goods">
								<span class="frame_thumb"><si:tenthImageTag type="product" imageName="${brdRecommdationList.product.prImage1}" altVal=""/></span>
								<div class="info_item">
									<strong class="tit_item">${brdRecommdationList.product.prName1}</strong>
									<span class="txt_price">
										<span class="screen_out">금액</span><span class="num_price"><em class="emph_g"><fmt:formatNumber value="${brdRecommdationList.productLevelPrice.prlpSaleprice1}" type="number"/></em>KRW <span class="usd_price"><fmt:formatNumber value="${brdRecommdationList.productLevelPrice.exchangePrice}" type="number"/> USD</span></span>
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
