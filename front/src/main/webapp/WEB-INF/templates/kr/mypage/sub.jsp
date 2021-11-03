<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div id="mSub">
	<div class="visual_intro mypage_intro" style="background-color:#ffdc00"><!-- 인라인스타일로 배경컬러값 변경 -->
		<div class="inner_intro">
			<h2 id="kakaoBody" class="screen_out">마이페이지</h2>
			<h3 class="screen_out">내 정보</h3>
			<div class="profile_user">
				<strong class="tit_username">안녕하세요,</br> <span class="txt_name">${!empty myInfoTop.myInfo.name ? myInfoTop.myInfo.name : '고객'}</span>님</strong>
				<dl class="info_account">
					<dt class="screen_out">계정 </dt>
					<dd>
						<!-- 2017-11-01 페북,카카오로그인용 이미지 추가 -->
						<c:choose>
							<c:when test="${empty myInfoTop.myInfo.providerId}"><!-- 프렌즈 계정일 경우 -->
								<span class="ico_newfriends_v1 ico_user"></span>${myInfoTop.myInfo.email}
							</c:when>
							<c:when test="${myInfoTop.myInfo.providerId eq 'kakao'}"><!-- 카카오 계정일 경우 -->
								<c:if test="${fn:startsWith(myInfoTop.myInfo.email, 'kakao') eq false || fn:endsWith(myInfoTop.myInfo.email, '@kakao.com' ) eq false}">
									<span class="ico_newfriends_v1 ico_kt"></span>${myInfoTop.myInfo.email}
								</c:if>
							</c:when>
							<c:when test="${myInfoTop.myInfo.providerId eq 'facebook'}"><!-- 페이스북 계정일 경우 -->
								<span class="ico_newfriends_v1 ico_fb"></span>${myInfoTop.myInfo.email}
							</c:when>
						</c:choose>
						<!-- //2017-11-01 페북,카카오로그인용 이미지 추가 -->
					</dd>
				</dl>
			</div>
			<div class="membership_point">
				<div class="point_section">
					<strong>멤버십 포인트</strong>
                    <p class="txt_point gotopoint_kr">
						<span class="txt_point_numbers">0</span>
						<span class="ico_point"></span>
					</p>
				</div>
                <c:if test = "${!fn:startsWith(myInfo.barcode, 'BARCODE') && myInfo.barcode != null}">

                <div class="barcode_section">
					<button type="button">바코드보기</button>
				</div>

                </c:if>
			</div>

			<div class="membership_barcode">
				<div class="barcode_dim"></div>
				<div class="barcode_inner">
					<strong class="tit_user">카카오프렌즈</strong>
					<p class="txt_info">MEMBERSHIP</p>

					<div class="article_card">
						<div class="img_barcode">
							<div class="lds-ellipsis">
								<div></div>
								<div></div>
								<div></div>
								<div></div>
							</div>
						</div>
						<div class="article_card_bottom">
							<p class="img_gnb">
								KAKAO FRIENDS
							</p>
							<p class="txt_point">
								<span class="point"></span>
								<span class="ico_point"></span>
							</p>
						</div>
					</div>

					<button type="button" class="membership_close">멤버십창 닫기</button>
					<button type="button" class="membership_x">멤버십창 닫기</button>
				</div>
			</div>

			<%--<span class="img_emoticon ico_con"></span><!-- 2017-11-01 콘 아이콘 추가 -->--%>
		</div>
	</div>

	<script>
      function numberWithCommas(x) {
        return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
      }

	  var availablePoint = numberWithCommas(parseInt('${myInfo.availablePoint}', 10));
	</script>
	<script src="/resources/js/JsBarcode.all.min.js" defer></script>
	<script src="/resources/js/membership.js" defer></script>

	<div class="box_useinfo">
		<!-- <dl class="info_membership">
            <dt><span class="ico_newfriends_v1 img_membership">카카오 프렌즈 멤버쉽</span></dt>
            <dd>
                <span class="img_emoticon ico_con"></span>
                <a href="#" class="link_barcode">
                    <%--<span class="thumb_barcoe"><img src="/kakaofriends-2017/service/resources/images/temp/img_barcode.jpg" class="img_barcode" alt="멤버쉽 바코드 다운로드"></span>--%>
                <%--</a>--%>
            <%--</dd>--%>
        </dl> 2017-11-01 삭제 -->
		<dl class="info_mypoint">
			<dt class="tit_info">적립 포인트</dt>
			<dd class="item_total"><a href="/${pageContext.response.locale.language.equals('en') ? 'en' : 'kr'}/mypage/pointlist" class="link_point"><em class="num_point"><fmt:formatNumber value="${myInfoTop.myPageTopData.MYPOINTREST}" type="number"/></em><span class="ico_newfriends_v1 ico_point"></span></a></dd>
			<dt class="screen_out">사용가능 포인트 </dt>
			<dd><em class="num_point"><fmt:formatNumber value="${myInfoTop.myPageTopData.MYPOINTREST >= 0 ? myInfoTop.myPageTopData.MYPOINTREST : 0}" type="number"/> P</em> 사용 가능</dd>
			<%--<dd><em class="num_point"><fmt:formatNumber value="${myInfoTop.myPageTopData.MYPOINTREST >= 3000 ? myInfoTop.myPageTopData.MYPOINTREST : 0}" type="number"/> P</em> 사용 가능</dd>--%>
		</dl>

		<div class="group_infobox">
			<dl class="info_coll">
				<dt>배송중 </dt>
				<!-- 2017-10-24 수정 : a태그 추가 및 숫자 0일때 dd에 num_basic 클래스 추가 -->
				<dd class=${myInfoTop.myPageTopData.MYOMCNT == 0 ? 'num_basic' : ''}><a href="/${pageContext.response.locale.language.equals('en') ? 'en' : 'kr'}/mypage/orderlist" class="link_info">${myInfoTop.myPageTopData.MYOMCNT}</a></dd>
			</dl>
			<dl class="info_coll">
				<dt>취소 및 교환 </dt>
				<!-- 2017-10-24 수정 : a태그 추가 및 숫자 0일때 dd에 num_basic 클래스 추가 -->
				<dd class=${myInfoTop.myPageTopData.MYDELICNT == 0 ? 'num_basic' : ''}><a href="/${pageContext.response.locale.language.equals('en') ? 'en' : 'kr'}/mypage/cancellist" class="link_info">${myInfoTop.myPageTopData.MYDELICNT}</a></dd>
			</dl>
			<dl class="info_coll">
				<dt>쿠폰 </dt>
				<!-- 2017-10-24 수정 : a태그 추가 및 숫자 0일때 dd에 num_basic 클래스 추가 -->
				<dd class=${myInfoTop.myPageTopData.MYCOUPONCNT == 0 ? 'num_basic' : ''}><a href="/${pageContext.response.locale.language.equals('en') ? 'en' : 'kr'}/mypage/couponlist" class="link_info">${myInfoTop.myPageTopData.MYCOUPONCNT}</a></dd>
			</dl>
		</div>
	</div>
</div>