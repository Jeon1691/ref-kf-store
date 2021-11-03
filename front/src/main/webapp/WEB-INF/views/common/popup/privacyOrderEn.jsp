<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="friends_layer privacy_layer">
	<div class="inner_layer">
		<c:if test="${privacyType eq '1'}">
			<div class="layer_head">
				<strong class="tit_privacy">개인 정보 제3자 정보 제공 동의</strong>
			</div>
			<div class="layer_body">
				<div class="group_privacy">
					<table class="tbl_privacy">
						<caption class="screen_out">개인 정보 제3자 정보 제공 동의</caption>
						<thead>
						<tr>
							<th scope="col" style="width:26%">제공받는자</th>
							<th scope="col" style="width:25%">CJ올리브네트웍스(주)</th>
							<th scope="col" style="width:25%">CJ대한통운(주)</th>
							<th scope="col" style="width:24%">(주)KG로지스</th>
						</tr>
						</thead>
						<tbody>
						<tr>
							<th scope="row">목 적</th>
							<td colspan="3">구매한 상품의 배송</td>
						</tr>
						<tr>
							<th scope="row">항 목</th>
							<td colspan="3">성명, 휴대전화, 주소</td>
						</tr>
						<tr>
							<th scope="row" class="lst">보유 및 <br class="rw_hide">이용기간</th>
							<td class="lst" colspan="3">서비스 제공 완료 후 3개월 뒤 삭제</td>
						</tr>
						</tbody>
					</table>
					<p class="desc_privacy"><span class="ico_friends ico_bullet"></span>This is the minimum of personal information we need to provide you with the following services. Please select “Agree” to continue.</p>
				</div>
				<button type="button" class="btn_verify btn_confirm"><spring:message code="popup.common.confirm"/></button>
			</div>
		</c:if>
		<c:if test="${privacyType eq '2'}">
			<div class="layer_head">
				<strong class="tit_privacy">결제대행서비스 이용약관</strong>
			</div>
			<div class="layer_body">
				<div class="group_tab">
					<ul class="list_layer_tab"><!-- 선택 시 li에 .tab_on 클래스 추가 -->
						<li class="tab_on"><a href="#none" class="link_tab">기본 약관</a></li>
						<li><a href="#none" class="link_tab">개인 정보 수집 <br class="rw_hide">및 이용</a></li>
						<li><a href="#none" class="link_tab">개인 정보 제공 <br class="rw_hide">및 위탁</a></li>
					</ul>
				</div>
				<div class="group_privacy">
					<div class="area_privacy area_on">
						<c:forEach begin="1" end="100">
							기본 약관<br>
						</c:forEach>
					</div>
					<div class="area_privacy">
						<c:forEach begin="1" end="100">
							개인 정보 수집 및 이용<br>
						</c:forEach>
					</div>
					<div class="area_privacy">
						<c:forEach begin="1" end="100">
							개인 정보 제공 및 위탁<br>
						</c:forEach>
					</div>
				</div>
				<button type="button" class="btn_verify btn_confirm"><spring:message code="popup.common.confirm"/></button>
			</div>
		</c:if>
		<c:if test="${privacyType eq '3'}">
			<div class="layer_head">
				<strong class="tit_privacy">Collection and use of personal information <br>(Collecting shipping information)</strong>
			</div>
			<div class="layer_body">
				<div class="group_privacy">
					<table class="tbl_privacy">
						<caption class="screen_out">Collection and use of personal information (Collecting shipping information)</caption>
						<thead>
						<tr>
							<th scope="col" style="width:20%">Category</th>
							<th scope="col" style="width:80%">Required field</th>
						</tr>
						</thead>
						<tbody>
						<tr>
							<th scope="row">Purpose</th>
							<td>Product order delivery /  Customer contact us</td>
						</tr>
						<tr>
							<th scope="row">Items</th>
							<td>name, e-mail, cellphone number,  address</td>
						</tr>
						<tr>
							<th scope="row" class="lst">Storage <br class="rw_hide">period</th>
							<td class="lst">Will be terminated in 3 months after the shipping. <br>(Depending on the law of electronic commerce, the storage period could be extended to 5 years)</td>
						</tr>
						</tbody>
					</table>
					<p class="desc_privacy"><span class="ico_friends ico_bullet"></span>This is the minimum of personal information we need to provide you with the following services. Please select “Agree” to continue.</p>
				</div>
				<button type="button" class="btn_verify btn_confirm"><spring:message code="popup.common.confirm"/></button>
			</div>
		</c:if>
	</div>
</div>
<script type="text/javascript">
	$(".privacy_layer").show();
	popupCenter();
	$("#kakaoIndex, #kakaoWrap").attr("aria-hidden","true");
	$("#kakaoIndex a, #kakaoWrap a, #kakaoIndex button, #kakaoWrap button").attr("tabindex","-1");
	$(".privacy_layer").attr("tabindex","0").focus();
	$(".privacy_layer").removeAttr("tabindex");
	$(".privacy_layer .btn_verify").on("click",function(){
		$("#kakaoIndex, #kakaoWrap").removeAttr("aria-hidden");
		$("#kakaoIndex a, #kakaoWrap a, #kakaoIndex button, #kakaoWrap button").removeAttr("tabindex");
		$("body").attr("tabindex","0").focus();
		$("body").removeAttr("tabindex");
		$(".dimmed_layer").hide();
		$(".privacy_layer").hide();
	});
</script>