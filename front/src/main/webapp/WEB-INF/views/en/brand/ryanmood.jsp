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
			<h3 class="tit_view">라이언 무드조명과 함께 <br class="rw_hide">Relaxing time</h3>
			<em class="txt_category">Video</em>
		</div>
		<div class="box_vod box_fbvod">
			<div class="inner_vod">
				<iframe src="https://www.youtube.com/embed/RZBvSuqSoko?rel=0&amp;showinfo=0" title="카카오프렌즈 - 라이언 무드램프와 포근한 휴식을" frameborder="0" allowfullscreen></iframe>
			</div>
		</div>
		<p class="desc_video">Relax, Love, Comfort. 마음까지 밝혀주는 나만의 친구, 라이언 무드조명. 아무 말 없이 옆에만 있어도 위로가 되는 그런 든든한 친구가 되어주고 싶었어요. 따스한 라이언의 마음까지 느껴보세요!</p>
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
