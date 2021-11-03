<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="kf" uri="http://www.kakaofriends.com" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div id="mArticle">
	<!-- 2017-10-19 수정 시작 : 마이페이지 탭메뉴 변경 -->
	<div class="menu_tab">
		<ul class="tab_nav">
			<!-- 탭 메뉴 활성화시 li에 on클래스 부여 및 선택됨 대체텍스트 제공 -->
			<li>
				<a href="/en/mypage/orderlist" class="link_tab">Order List</a>
			</li>
			<li>
				<a href="/en/mypage/wishlist" class="link_tab">Wish List</a>
			</li>
			<li>
				<a href="/en/mypage/cancellist" class="link_tab">Returns</a>
			</li>
			<li>
				<a href="/en/mypage/pointlist" class="link_tab">Point</a>
			</li>
			<li>
				<a href="/en/mypage/couponlist" class="link_tab">Coupon</a>
			</li>
			<li class="on">
				<a href="/en/mypage/onetoone" class="link_tab">Contact Us <span class="screen_out">selected</span></a>
			</li>
			<li>
				<a href="/en/mypage/myinfo" class="link_tab">Account</a>
			</li>
		</ul>
	</div>
	<!--// 2017-10-19 수정 끝 : 마이페이지 탭메뉴 변경 -->

	<div class="cont_board">
		<h3 class="screen_out">Contact Us</h3>
		<c:choose>
			<c:when test="${empty oneToOneList}">
				<p class="desc_nodata">There are no items in your Contact Us.</p>
			</c:when>
			<c:otherwise>
				<ul class="list_board">
					<c:forEach items="${oneToOneList}" var="oneToOne" varStatus="status">
						<li>
							<a href="#none" class="link_board">
								<span class="txt_info">
									<span class="txt_cate">[${oneToOne.boardCategory.bdcEname}]</span>
									<span class="screen_out">date</span>
									<span class="txt_date"><fmt:formatDate value="${oneToOne.boardArticle.bdaIndate}" pattern="yyyy.MM.dd"/>&nbsp;
										<span class="txt_time"><span class="screen_out">time</span><fmt:formatDate value="${oneToOne.boardArticle.bdaIndate}" pattern="HH:mm"/></span>
									</span>
								</span>
								<strong class="tit_board">${oneToOne.boardArticle.bdaName}</strong>
								<c:if test="${oneToOne.boardArticle.bdaReplyyn eq 'N'}"><em class="emph_state ${oneToOne.boardArticle.bdaEtc3 eq 'ANSWER_COMPLETION' ? 'emph_complete' : ''}">${oneToOne.boardArticle.bdaEtc3.ename}</em></c:if> <!-- 답변완료일 경우 emph_complete 클래스 부여 -->
								<span class="ico_newfriends_v1 ico_arr">open</span>
							</a>
							<div class="subject_board">
								<p class="desc_quest">${oneToOne.boardArticle.bdaContent}</p>
								<c:forEach items="${oneToOneAnswer}" var="answer">
									<c:if test="${oneToOne.boardArticle.bdaGroupnum eq answer.bdaGroupnum}">
										<strong class="tit_answer">Answer :</strong>
										<p class="desc_board">${answer.bdaContent}</p>
									</c:if>
								</c:forEach>
							</div>
						</li>
					</c:forEach>
				</ul>
			</c:otherwise>
		</c:choose>
		<tiles:insertTemplate template="/WEB-INF/templates/en/sub/paging.jsp" flush="true"/>
		<a href="/en/mypage/onetoone/form" class="link_quest">Inquiry</a>
	</div>
</div>

<c:if test="${!empty writeResult}">
	<script language="JavaScript">
		$(document).ready(function () {
			alertPopup('${writeResult}');
		})
	</script>
</c:if>