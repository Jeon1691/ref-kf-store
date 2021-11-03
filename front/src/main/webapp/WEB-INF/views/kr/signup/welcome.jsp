<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="si" uri="http://www.kakaofriends.com/si" %>

<div id="mArticle">
		<div class="cont_welcome">
			<%--<dl class="info_membership">--%>
				<%--<dt><span class="ico_newfriends_v1 img_membership">카카오 프렌즈 멤버쉽</span></dt>--%>
				<%--<dd>--%>
				<%--<a href="#" class="link_barcode">--%>
					<%--<span class="thumb_barcoe"><img src="/kakaofriends-2017/service/resources/images/temp/img_barcode.jpg" class="img_barcode" alt="멤버쉽 바코드 다운로드"></span>--%>
				<%--</a>--%>
				<%--</dd>--%>
			<%--</dl>--%>
			<strong class="screen_out">회원가입 혜택</strong>
			<ul class="list_welcome">
				<%--<li>회원가입 시 <em class="emph_g">3,000포인트</em>를 지급해드려요.</li>--%>
				<li>상품 구매 시 특정 포인트가 지급됩니다.</li>
				<li>다양한 이벤트와 쿠폰 제공 혜택을 받으실 수 있어요.</li>
				<li>카카오프렌즈 신규상품 정보를 제공해드려요.</li>
				<%--<li>오프라인 샵에서 상품 구매하시면 온라인 스토어에서 사용 가능한 포인트를 지급해드려요</li>--%>
			</ul>
			<%--<strong class="screen_out">바코드 이용 안내</strong>--%>
			<%--<ul class="list_membership">--%>
				<%--<li>- 마이페이지에 있는 바코드로 카카오프렌즈 회원임을 인증</li>--%>
				<%--<li>- 바코드 이미지 선택시 이미지로 다운받아 사용 할 수 있습니다</li>--%>
			<%--</ul>--%>

			<div class="group_btn">
				<form action="/temp-logout" method="get">
					<button type="submit" class="btn_signup bg_yellow" formmethod="get">
						<span class="txt_signup">${welcome}</span>
					</button>
				</form>
			</div>
		</div>
</div>
<!--// mArticle -->

