<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="si" uri="http://www.kakaofriends.com/si" %>
<div id="mArticle">

	<div class="view_brand">
		<div class="head_view">
			<h3 class="tit_view">We are Friends!</h3>
			<em class="txt_category">Kakao Friends</em>
		</div>
		<!-- 이미지 브라우저 너비 -->
		<div class="img_fullfit">
			<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/brand_wearefriends1_171130.jpg" class="thumb_g rw_show" alt="">
			<img src="https://t1.kakaocdn.net/friends/kfo-common/mo/m640/brand/brand_wearefriends1_171130.png" class="thumb_g rw_hide" alt="">
		</div>
		<!-- 이미지 텍스트 너비 -->
		<div class="img_txtfit">
			<img src="https://t1.kakaocdn.net/friends/kfo-common/pc/brand/brand_wearefriends2.jpg" class="thumb_g" alt="카카오프렌즈">
		</div>
		<p class="desc_view txt_medium">
			카카오프렌즈가 우리와 친구가 된지도 벌써 몇해가 지났어요. 카카오톡 메신저의 이모티콘으로 처음 등장하여 이제는 메신저 창으로부터 나와 제품, 공간, 전시 등 일상생활 이곳 저곳에서 만나볼 수 있죠. 카카오프렌즈는 그렇게 우리 곁에 스며들어 즐거운 일상을 함께 만들어가고 싶었답니다.<br>
			둥둥섬에서 오느라 다른 친구들보다 조금 늦게 합류한 라이언까지, 총 여덟 친구들은 저마다 다른 외모와 독특한 개성을 가지고 있어요. 뿐만 아니라 여덟 친구들에게는 각기 말못할 콤플렉스가 하나씩 있다죠. 이미 알 사람은 다 안다는 콤플렉스라지만, 프렌즈를 위해 앞에서는 짐짓 모르는 척 넘어가주세요. 아마도 이런게 우정이겠죠.
		</p>
		<!-- 구분선 타입 1 -->
		<div class="line_type line_type1"></div>
		<!-- 강조 타입 3 -->
		<div class="txt_quote txt_quote3">
			저마다의 개성과 인간적인 매력을 지닌 <br>여덟 친구들, 카카오프렌즈
			<span class="ico_newfriends_v1 ico_quote"></span>
			<span class="ico_newfriends_v1 ico_quote"></span>
		</div>
		<!-- 이미지 텍스트 너비 -->
		<div class="img_txtfit img_txtfit1">
			<img src="https://t1.kakaocdn.net/friends/kfo-common/pc/brand/brand_wearefriends3.jpg" class="thumb_g rw_show" alt="라이언">
			<img src="https://t1.kakaocdn.net/friends/kfo-common/mo/m640/brand/brand_wearefriends3.jpg" class="thumb_g rw_hide" alt="라이언">
			<span class="info_img">
			갈기가 없는 것이 콤플렉스인 수사자, 라이언.<br>
			큰 덩치와 무뚝뚝한 표정으로 오해를 많이 사지만,<br>
			사실 누구보다도 여리고 섬세한 소녀감성을 지닌 반전 매력의 소유자!<br>
			원래 아프리카 둥둥섬 왕위 계승자였으나, 자유로운 삶을 동경해 탈출!<br>
			카카오프렌즈의 든든한 조언자 역할을 맡고 있습니다.<br>
			꼬리가 길면 잡히기 때문에, 꼬리가 짧습니다.
		</span>
		</div>
		<!-- 이미지 텍스트 너비 -->
		<div class="img_txtfit img_txtfit1">
			<img src="https://t1.kakaocdn.net/friends/kfo-common/pc/brand/brand_wearefriends4.jpg" class="thumb_g rw_show" alt="무지와 콘">
			<img src="https://t1.kakaocdn.net/friends/kfo-common/mo/m640/brand/brand_wearefriends4.jpg" class="thumb_g rw_hide" alt="무지와 콘">
			<span class="info_img">
			호기심 많은 장난꾸러기 무지의 정체는 사실 토끼 옷을 입은 단무지!<br>
			토끼 옷을 벗으면 부끄러움을 많이 탑니다.<br>
			단무지를 키워 무지를 만든 정체불명의 악어 콘!<br>
			이제는 복숭아를 키우고 싶어 어피치를 찾아 다닙니다.
		</span>
		</div>
		<!-- 이미지 텍스트 너비 -->
		<div class="img_txtfit img_txtfit1">
			<img src="https://t1.kakaocdn.net/friends/kfo-common/pc/brand/brand_wearefriends5.jpg" class="thumb_g rw_show" alt="어피치">
			<img src="https://t1.kakaocdn.net/friends/kfo-common/mo/m640/brand/brand_wearefriends5.jpg" class="thumb_g rw_hide" alt="어피치">
			<span class="info_img">
			유전자 변이로 자웅동주가 된 것을 알고 <i class="rw_hide"></i>복숭아 나무에서 탈출한 악동 복숭아 어피치!<br>
			섹시한 뒷태로 사람들을 매혹시키며, <i class="rw_hide"></i>성격이 매우 급하고 과격합니다.
		</span>
		</div>
		<!-- 이미지 텍스트 너비 -->
		<div class="img_txtfit img_txtfit1">
			<img src="https://t1.kakaocdn.net/friends/kfo-common/pc/brand/brand_wearefriends6.jpg" class="thumb_g rw_show" alt="프로도와 네오">
			<img src="https://t1.kakaocdn.net/friends/kfo-common/mo/m640/brand/brand_wearefriends6.jpg" class="thumb_g rw_hide" alt="프로도와 네오">
			<span class="info_img">
			프로도와 네오는 카카오프렌즈 공식 커플로 알콩달콩 깨볶는 중!<br>
			부잣집 도시개 프로도는 사실 잡종. 태생에 대한 콤플렉스가 많습니다.<br>
			자기자신을 가장 사랑하는 새침한 고양이 네오. <i class="rw_hide"></i>쇼핑을 좋아하는 이 구역의 대표 패셔니스타입니다.<br>
			하지만 도도한 자신감의 근원이 단발머리 ‘가발’에서 나온다는 건 비밀!
		</span>
		</div>
		<!-- 이미지 텍스트 너비 -->
		<div class="img_txtfit img_txtfit1">
			<img src="https://t1.kakaocdn.net/friends/kfo-common/pc/brand/brand_wearefriends7.jpg" class="thumb_g rw_show" alt="튜브">
			<img src="https://t1.kakaocdn.net/friends/kfo-common/mo/m640/brand/brand_wearefriends7.jpg" class="thumb_g rw_hide" alt="튜브">
			<span class="info_img">
			겁 많고 마음 약한 오리 튜브.<br>
			극도의 공포를 느끼면 미친 오리로 변신합니다.<br>
			작은 발이 콤플렉스이기 때문에 큰 오리발을 착용합니다.<br>
			미운 오리 새끼가 먼 친척입니다.
		</span>
		</div>
		<!-- 이미지 텍스트 너비 -->
		<div class="img_txtfit img_txtfit1">
			<img src="https://t1.kakaocdn.net/friends/kfo-common/pc/brand/brand_wearefriends8.jpg" class="thumb_g rw_show" alt="제이지">
			<img src="https://t1.kakaocdn.net/friends/kfo-common/mo/m640/brand/brand_wearefriends8.jpg" class="thumb_g rw_hide" alt="제이지">
			<span class="info_img">
			땅속 나라 고향에 대한 향수병이 있는 비밀요원 제이지!<br>
			사명의식이 투철하여 냉철해보이고 싶으나, 실은 어리버리합니다.<br>
			겉모습과 달리 알고보면 외로움을 많이 타는 여린 감수성의 소유자.<br>
			힙합 가수 Jay-Z의 열혈팬입니다.
		</span>
		</div>
		<!-- 구분선 타입 1 -->
		<div class="line_type line_type1"></div>
		<!-- 강조 타입 3 -->
		<div class="txt_quote txt_quote3">
			카카오프렌즈는 즐거운 일상을 위해 <i class="rw_hide"></i>다양한 물건과 공간을 <i class="rw_show"></i>
			다시 고민하고 제안하는 <i class="rw_hide"></i>라이프 엔터테인먼트 브랜드입니다.
			<span class="ico_newfriends_v1 ico_quote"></span>
			<span class="ico_newfriends_v1 ico_quote"></span>
		</div>
		<!-- 이미지 텍스트 너비 -->
		<div class="img_txtfit">
			<img src="https://t1.kakaocdn.net/friends/kfo-common/pc/brand/brand_wearefriends9.jpg" class="thumb_g" alt="">
			<span class="info_img">부산 플래그십 스토어</span>
		</div>
		<!-- 이미지 텍스트 너비 -->
		<div class="img_txtfit">
			<img src="https://t1.kakaocdn.net/friends/kfo-common/pc/brand/brand_wearefriends10.jpg" class="thumb_g" alt="">
			<img src="https://t1.kakaocdn.net/friends/kfo-common/pc/brand/brand_wearefriends11.jpg" class="thumb_g" alt="">
			<span class="info_img">매장 전경 (홍대, 강남 플래그십 스토어)</span>
		</div>
		<!-- 이미지 GNB 너비 타입 2 -->
		<div class="img_gnbfit img_gnbfit2">
			<div class="frame_gnbfit">
				<img src="https://t1.kakaocdn.net/friends/kfo-common/pc/brand/brand_wearefriends12.jpg" class="thumb_g" alt=""><img src="https://t1.kakaocdn.net/friends/kfo-common/pc/brand/brand_wearefriends13.jpg" class="thumb_g" alt="">
			</div>
			<span class="info_img">라이언 카페 (강남 플래그십 스토어 내)</span>
		</div>
		<!-- 이미지 GNB 너비 타입 3 -->
		<div class="img_gnbfit img_gnbfit3">
			<div class="frame_gnbfit">
				<img src="https://t1.kakaocdn.net/friends/kfo-common/pc/brand/brand_wearefriends14.jpg" class="thumb_g" alt=""><img src="https://t1.kakaocdn.net/friends/kfo-common/pc/brand/brand_wearefriends15.jpg" class="thumb_g" alt="">
			</div>
			<span class="info_img">어피치 카페 (부산 플래그십 스토어 내)</span>
		</div>
		<!-- 이미지 GNB 너비 -->
		<div class="img_gnbfit">
			<img src="https://t1.kakaocdn.net/friends/kfo-common/pc/brand/brand_wearefriends16.jpg" class="thumb_g" alt="">
			<span class="info_img">카카오프렌즈 컨셉 뮤지엄</span>
		</div>
		<!-- 더 많은 브랜드 스토리 -->
		<div class="section_brandstory">
			<h3 class="tit_main" style="color:#000"><!--텍스트 컬러 인라인으로 적용-->더 많은 브랜드 스토리</h3>
			<ul class="list_brand">
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
				<!-- video type -->
				<li>
					<a href="/kr/brand/jaygshowtime" class="link_brand">
						<img src="https://t1.kakaocdn.net/friends/kfo-common/pcrtn/brand/thumb_jaygshowtime.jpg" class="thumb_g" alt="제이지의 쇼타임">
						<span class="info_brand">VIDEO</span>
						<strong class="tit_brand">레츠기릿! 제이지의 쇼타임</strong>
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
