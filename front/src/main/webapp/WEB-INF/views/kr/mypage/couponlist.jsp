<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="si" uri="http://www.kakaofriends.com/si" %>

<div id="mArticle">
	<!-- 2017-10-19 수정 시작 : 마이페이지 탭메뉴 변경 -->
	<div class="menu_tab">
		<ul class="tab_nav">
			<!-- 탭 메뉴 활성화시 li에 on클래스 부여 및 선택됨 대체텍스트 제공 -->
			<li>
				<a href="/kr/mypage/orderlist" class="link_tab">주문내역</a>
			</li>
			<li>
				<a href="/kr/mypage/wishlist" class="link_tab">찜</a>
			</li>
			<li>
				<a href="/kr/mypage/cancellist" class="link_tab">취소/교환</a>
			</li>
			<li>
				<a href="/kr/mypage/pointlist" class="link_tab">포인트</a>
			</li>
			<li class="on">
				<a href="/kr/mypage/couponlist" class="link_tab">쿠폰 <span class="screen_out">선택됨</span></a>
			</li>
			<li>
				<a href="/kr/mypage/onetoone" class="link_tab">1:1문의</a>
			</li>
			<li>
				<a href="/kr/mypage/myinfo" class="link_tab">개인정보</a>
			</li>
		</ul>
	</div>
	<!--// 2017-10-19 수정 끝 : 마이페이지 탭메뉴 변경 -->
	<div class="mypoint_detail">
		<h3 class="screen_out">쿠폰</h3>
		<div class="detail_coupon">
			<div class="group_formpoint">
				<!-- 모바일에서 포인트 등록하기 체크시 등록폼 활성화 coupon_on 클래스 부여 -->
				<div class="choice_g chk_g">
					<input type="checkbox" id="checkCoupon" class="inp_g">
					<label for="checkCoupon" class="lab_g"> <span class="ico_newfriends_v1 ico_choice"></span> 쿠폰 등록하기</label>
				</div>
				<form action="#none" class="form_point">
					<fieldset>
						<legend class="screen_out">쿠폰 등록폼</legend>
						<strong class="tit_pointjoin">쿠폰 등록하기</strong>
						<div class="coupon_code point_code">
							<div class="box_input">
								<label class="screen_out" for="cpnNum1">쿠폰 첫번째 4자리</label>
								<input type="text" id="cpnNum1" name="couponNum1" class="tf_g" maxlength="4" placeholder="0000">
								<span class="txt_bar"></span>
							</div>
							<div class="box_input">
								<label class="screen_out" for="cpnNum2">쿠폰 두번째 4자리</label>
								<input type="text" id="cpnNum2" name="couponNum2" class="tf_g" maxlength="4" placeholder="0000">
								<span class="txt_bar"></span>
							</div>
							<div class="box_input">
								<label class="screen_out" for="cpnNum3">쿠폰 세번째 4자리</label>
								<input type="text" id="cpnNum3" name="couponNum3" class="tf_g" maxlength="4" placeholder="0000">
								<span class="txt_bar"></span>
							</div>
							<div class="box_input">
								<label class="screen_out" for="cpnNum4">쿠폰 마지막 4자리</label>
								<input type="text" id="cpnNum4" name="couponNum4" class="tf_g" maxlength="4" placeholder="0000">
								<span class="txt_bar"></span>
							</div>
							<button type="button" class="btn_apply"><span class="txt_g">등록</span></button>
						</div>
						<ul class="list_info">
							<li>16자리 번호를 입력하여 카카오프렌즈 쿠폰으로 등록합니다.</li>
							<li>등록된 포인트는 본인 외 타인에게 양도할 수 없습니다.</li>
						</ul>
					</fieldset>
				</form>
			</div>

			<h4 class="tit_detial">보유 쿠폰 : <em class="num_coupon">${myAvailableCouponCount}</em>개</h4>
			<div class="group_coupon">
				<form id="frm" name="frm" method="post">
					<input type="hidden" id="gcCode" name="gcCode">
					<input type="hidden" name="_csrf" value="${_csrf.token}"/>
					<input type="hidden" name="_csrf_header" value="${_csrf.headerName}"/>
				</form>
				<c:forEach items="${ myAvailableCouponList }" var="myAvailableCouponList">
				<div class="card_coupon">
					<div class="head_coupon" style=${myAvailableCouponList.CPH_OPTION_CATEGORY == 0? "background-color:#1fd080" : "background-color:#ffcd00"}>
						<div class="coupon_tit">
							<span class="ico_newfriends_v1 ico_w"></span>
							<strong class="tit_coupon">
								<c:choose>
									<c:when test="${myAvailableCouponList.CT_NAME == null && myAvailableCouponList.CPH_OPTION_TYPE ne 'D'}">
										${myAvailableCouponList.CPH_DUPLICATION == 'N' ? '일반' : '중복'}
									</c:when>
									<c:when test="${myAvailableCouponList.CT_NAME == null && myAvailableCouponList.CPH_OPTION_TYPE eq 'D'}">
										${myAvailableCouponList.CPH_OPTION_TYPE_NM}
									</c:when>
									<c:otherwise>
										${myAvailableCouponList.CT_NAME}
									</c:otherwise>
								</c:choose>
								<c:if test="${myAvailableCouponList.CPH_OPTION_TYPE ne 'D'}"><br>할인</c:if><br>
							</strong>
						</div>
					</div>
					<div class="body_coupon">
						<dl class="info_name">
							<dt class="screen_out">쿠폰명 : </dt>
							<dd>
								<span class="txt_name">
									<c:if test="${!empty myAvailableCouponList.CPH_OPTION_VALUE && myAvailableCouponList.CPH_OPTION_VALUE != 0}"><fmt:formatNumber value="${myAvailableCouponList.CPH_OPTION_VALUE}" type="number" /> 이상 구매시</c:if>
									<c:if test="${empty myAvailableCouponList.CPH_OPTION_VALUE || myAvailableCouponList.CPH_OPTION_VALUE == 0}">금액 제한없음</c:if>
								</span>
								<span class="txt_price"><span class="num_price">
									<c:if test="${myAvailableCouponList.CPH_PRICE == 0}">배송비</c:if>
									<c:if test="${myAvailableCouponList.CPH_PRICE != 0}"><fmt:formatNumber value="${myAvailableCouponList.CPH_PRICE}" type="number" /></span>원</c:if>
								</span>
							</dd>
						</dl>
						<dl class="info_desc">
							<dt>할인대상 : </dt>
							<dd>${!empty myAvailableCouponList.CT_NAME ? myAvailableCouponList.CT_NAME : myAvailableCouponList.CPH_OPTION_TYPE_NM}<c:if test="${myAvailableCouponList.CPH_OPTION_CATEGORY != 0}"> 카테고리</c:if></dd>
							<dt>유효기간 : </dt>
							<dd><fmt:formatDate value="${myAvailableCouponList.CPH_SDATE}" pattern="yyyy.MM.dd" /> ~ <fmt:formatDate value="${myAvailableCouponList.CPH_EDATE}" pattern="yyyy.MM.dd" /></dd>
						</dl>
					</div>
					<%--<button type="button" class="btn_del" value="${myAvailableCouponList.CPH_CODE}"><span class="ico_newfriends_v1 ico_del">쿠폰 삭제</span></button>--%>
				</div>
				<!--// card_coupon -->
				</c:forEach>
			</div>
		</div>

		<div class="detail_list">
			<h4 class="tit_detial">쿠폰 상세 내역</h4>
			<c:if test="${empty myCouponHistory}">
				<p class="desc_nodata"><span class="ico_newfriends_v1 ico_nodata"></span>쿠폰 상세 내역이 없습니다.</p>
			</c:if>
			<c:if test="${!empty myCouponHistory}">
				<ul class="list_mypoint list_mycoupon">
					<c:forEach items="${ myCouponHistory }" var="myCouponHistory">
						<c:if test="${myCouponHistory.CPH_USE eq '1' || myCouponHistory.CPH_USE eq '4'|| myCouponHistory.CPH_USE eq '6' }">
							<li>
								<span class="txt_date"><fmt:formatDate value="${myCouponHistory.REG_DTTM}" pattern="yyyy.MM.dd HH:mm:ss" /></span>
								<div class="wrap_tit">
									<span class="clip_g">${ myCouponHistory.CPH_ROW_GUBUN }</span>
									<strong class="tit_product">${ myCouponHistory.CPH_NAME }</strong>
								</div>
								<dl class="info_price">
									<dt>적립방식 :</dt>
									<dd>${myCouponHistory.CPH_TYPE_NM}</dd>
									<dt>쿠폰구분 :</dt>
									<dd>${myCouponHistory.CPH_DUPLICATION == 'N' ? '일반' : '중복'}</dd>
									<dt>할인대상 :</dt>
									<dd>${!empty myCouponHistory.CT_NAME ? myCouponHistory.CT_NAME : myCouponHistory.CPH_OPTION_TYPE_NM}<c:if test="${myCouponHistory.CPH_OPTION_CATEGORY != 0}"> 카테고리</c:if></dd>
									<!-- 2017-11-01 제한사항 추가 -->
									<dt>제한사항 :</dt>
									<dd>
										<c:if test="${!empty myCouponHistory.CPH_OPTION_VALUE && myCouponHistory.CPH_OPTION_VALUE != 0}"><fmt:formatNumber value="${myCouponHistory.CPH_OPTION_VALUE}" type="number" /> 이상 구매시</c:if>
										<c:if test="${empty myCouponHistory.CPH_OPTION_VALUE || myCouponHistory.CPH_OPTION_VALUE == 0}">-</c:if>
									</dd>
									<!-- //2017-11-01 제한사항 추가 -->
									<dt>유효기간 :</dt>
									<dd><em class="emph_nump">* <fmt:formatDate value="${myCouponHistory.CPH_SDATE}" pattern="yyyy.MM.dd" /> ~ <fmt:formatDate value="${myCouponHistory.CPH_EDATE}" pattern="yyyy.MM.dd" /></em></dd>
								</dl>
							</li>
						</c:if>
						<c:if test="${myCouponHistory.CPH_USE eq '3'}">
							<li class="type_use">
								<!-- 사용된 쿠폰시 li에 type_use 클래스 부여 -->
								<span class="txt_date"><fmt:formatDate value="${myCouponHistory.CPH_USEDATE}" pattern="yyyy.MM.dd HH:mm:ss" /></span>
								<div class="wrap_tit">
									<span class="clip_g">${ myCouponHistory.CPH_ROW_GUBUN }</span>
									<strong class="tit_product">${ myCouponHistory.CPH_NAME }</strong>
								</div>
								<dl class="info_price">
									<dt>적립방식 :</dt>
									<dd>${myCouponHistory.CPH_TYPE_NM}</dd>
									<dt>할인대상 :</dt>
									<dd>${!empty myCouponHistory.CT_NAME ? myCouponHistory.CT_NAME : myCouponHistory.CPH_OPTION_TYPE_NM}<c:if test="${myCouponHistory.CPH_OPTION_CATEGORY != 0}"> 카테고리</c:if></dd>
									<dt>주문번호 :</dt>
									<dd><c:if test="${!empty myCouponHistory.CPH_OMNUM}"><a href="/kr/order/shipping/${myCouponHistory.CPH_OMNUM}" class="link_num"></c:if>
											${!empty myCouponHistory.CPH_OMNUM ? myCouponHistory.CPH_OMNUM : '-'}<c:if test="${!empty myCouponHistory.CPH_OMNUM}"></a></c:if></dd>
									<dt>상품명 :</dt>
									<dd>${!empty myCouponHistory.CPH_OMNUM && !empty myCouponHistory.CPH_TITLE ? myCouponHistory.CPH_TITLE : '-'}</dd>
								</dl>
							</li>
						</c:if>
						<c:if test="${myCouponHistory.CPH_USE eq '5' || myCouponHistory.CPH_USE eq '2'}">
							<li class="type_end">
								<!-- 만료된 쿠폰시 li에 type_end 클래스 부여 -->
								<span class="txt_date"><fmt:formatDate value="${myCouponHistory.CPH_USE eq '2' ? myCouponHistory.CPH_USEDATE : myCouponHistory.CPH_EDATE}" pattern="yyyy.MM.dd HH:mm:ss" /></span>
								<div class="wrap_tit">
									<span class="clip_g">${ myCouponHistory.CPH_ROW_GUBUN }</span>
									<strong class="tit_product">${ myCouponHistory.CPH_NAME }</strong>
								</div>
								<dl class="info_price">
									<dt>적립방식 :</dt>
									<dd>${myCouponHistory.CPH_TYPE_NM}</dd>
									<dt>할인대상 :</dt>
									<dd>${!empty myCouponHistory.CT_NAME ? myCouponHistory.CT_NAME : myCouponHistory.CPH_OPTION_TYPE_NM}<c:if test="${myCouponHistory.CPH_OPTION_CATEGORY != 0}"> 카테고리</c:if></dd>
									<dt>주문번호 :</dt>
									<dd><c:if test="${!empty myCouponHistory.CPH_OMNUM}"><a href="/kr/order/shipping/${myCouponHistory.CPH_OMNUM}" class="link_num"></c:if>
											${!empty myCouponHistory.CPH_OMNUM ? myCouponHistory.CPH_OMNUM : '-'}<c:if test="${!empty myCouponHistory.CPH_OMNUM}"></a></c:if></dd>
									<dt>상품명 :</dt>
									<dd>${!empty myCouponHistory.CPH_OMNUM && !empty myCouponHistory.CPH_TITLE ? myCouponHistory.CPH_TITLE : '-'}</dd>
								</dl>
							</li>
						</c:if>
					</c:forEach>
				</ul>
				<tiles:insertTemplate template="/WEB-INF/templates/kr/sub/paging.jsp" flush="true"/>
			</c:if>
		</div>
	</div>
</div><!--// mArticle -->

<script type="text/javascript" src="/resources/js/jquery.json-2.6.0.min.js"></script>
<script type="text/javascript">
/*    $(function() {
        $(".btn_del").on("click", function () {
            $("#gcCode").val(this.value);
            $("#frm").attr("action", "/kr/mypage/couponlist/delete");
            $("#frm").submit();
        });
    });*/

    function applyMyCoupon(){

        var coupon1 = $("#cpnNum1").val();
        var coupon2 = $("#cpnNum2").val();
        var coupon3 = $("#cpnNum3").val();
        var coupon4 = $("#cpnNum4").val();
        var _couponNum = coupon1.concat("-",coupon2,"-",coupon3,"-",coupon4);

        $.ajax({
            headers: {'X-CSRF-TOKEN': '${_csrf.token}'},
            url: "/kr/mypage/applyOnlineCoupon",
            type: "POST",
            dataType: "json",
	        data: { couponNum:_couponNum},
            async:false,
            error: function () {
                alertNoti('error.occurred');
                return false;
            },
            success: function (data) {
                if (data.resultMsg != null) {
                    layerCenter();
                    myPagePopup(data.resultMsg, 'couponlist');
                    return false;
                }
                alertNoti('error.occurred');
            }
        });
    }
</script>