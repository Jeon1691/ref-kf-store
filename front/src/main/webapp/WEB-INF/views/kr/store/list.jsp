<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div id="mArticle">
	<h2 id="kakaoBody" class="screen_out">매장안내</h2>
	<div class="cont_store">
		<c:forEach items="${flagShips}" var="flagship" varStatus="status">
			<div class="cont_flagship">
				<strong class="tit_store">${flagship.stName}</strong>
				<dl class="store_info">
					<dt>매장전화 :</dt>
					<dd>${flagship.stTel}</dd>
					<dt>영업시간 :</dt>
					<dd>${flagship.stDay.name} ${flagship.stOpentime} - ${flagship.stClosetime} ${" "}${!empty flagship.stInfo ? flagship.stInfo : ""}</dd>
					<dt>매장주소 :</dt>
					<dd>${flagship.stAddr1} ${flagship.stAddr2}</dd>
				</dl>
				<a href="http://map.daum.net/?q=${flagship.stAddr1}" target="_blank" class="link_location"><span class="ico_friends ico_location"></span>위치 보기</a>
				<div class="store_map" id="map${flagship.stSeq}"></div>
			</div>
		</c:forEach>
		<h3 id="pcPlace" class="tit_all"><span class="txt_all">전체 지역 매장</span></h3>
		<ul class="tab_friends">
			<c:forEach items="${storeAreas}" var="storeArea">
				<li class="${area eq storeArea.staNum ? 'on':''}"><a href="/kr/stores/${storeArea.staNum}#pcPlace" class="link_tab">${storeArea.staArea}${area eq storeArea.staNum ? '<span class="screen_out">선택됨</span>':''}</a></li>
			</c:forEach>
		</ul>
		<div id="mPlace" class="opt_sort"><!--펼침시 클래스 sort_open 부여-->
			<strong class="screen_out">지역 선택</strong>
			<a href="#none" class="link_selected">
				<span class="txt_sort">${empty selectLocation ? '지역별 매장' : selectLocation}</span>
				<span class="screen_out">선택됨</span>
				<span class="ico_friends ico_arr"></span>
			</a>
			<div class="box_sort">
				<em class="screen_out">선택옵션</em>
				<ul class="list_sort">
					<c:forEach items="${storeAreas}" var="storeArea">
						<li class="${area eq storeArea.staNum ? 'on':''}">
							<a href="/kr/stores/${storeArea.staNum}#mPlace" class="link_sort">${storeArea.staArea}</a>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<ul class="list_store">
			<c:forEach items="${stores}" var="store">
			<li>
				<img src="${kakaoFriendsCdn.store}/${store.stImg}" class="img_store" alt="">
				<strong class="tit_store">${store.stName}</strong>
				<dl class="store_info">
					<dt>매장전화 :</dt>
					<dd>${store.stTel}</dd>
					<dt>영업시간 :</dt>
					<dd>${store.stDay.name} ${store.stOpentime} - ${store.stClosetime} ${" "}${!empty store.stInfo ? store.stInfo : ""}</dd>
					<dt>매장주소 :</dt>
					<dd>${store.stAddr1}<br> ${store.stAddr2}</dd>
				</dl>
				<a href="http://map.daum.net/?q=${store.stAddr1}" target="_blank" class="link_location"><span class="ico_friends ico_location"></span>위치 보기</a>
			</li>
			</c:forEach>
		</ul>
	</div>
</div>
<script type="text/javascript" src="https://apis.daum.net/maps/maps3.js?apikey=216a8c57246c336f35ff90c0c2df8e7e&amp;libraries&amp;libraries=services"></script>
<script type="text/javascript">
	mapRendering(${flagShipsJson});
</script>
<script type="text/javascript">
	$(window).on("load",function() {
		$(".store_map area").attr("tabindex", "-1");
		$(".store_map img[src='https://t1.daumcdn.net/localimg/localimages/07/mapjsapi/scalebar.png']").attr("tabindex", "-1");
	});
</script>