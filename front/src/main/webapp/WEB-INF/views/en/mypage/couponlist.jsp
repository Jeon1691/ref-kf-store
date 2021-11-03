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
			<li class="on">
				<a href="/en/mypage/couponlist" class="link_tab">Coupon <span class="screen_out">selected</span></a>
			</li>
			<li>
				<a href="/en/mypage/onetoone" class="link_tab">Contact Us</a>
			</li>
			<li>
				<a href="/en/mypage/myinfo" class="link_tab">Account</a>
			</li>
		</ul>
	</div>
	<!--// 2017-10-19 수정 끝 : 마이페이지 탭메뉴 변경 -->
	<div class="mypoint_detail">
		<h3 class="screen_out">Coupon</h3>
		<div class="detail_coupon">
			<div class="group_formpoint">
				<!-- 모바일에서 포인트 등록하기 체크시 등록폼 활성화 coupon_on 클래스 부여 -->
				<div class="choice_g chk_g">
					<input type="checkbox" id="checkCoupon" class="inp_g">
					<label for="checkCoupon" class="lab_g"> <span class="ico_newfriends_v1 ico_choice"></span> Use a Kakao Friends coupon</label>
				</div>
				<form action="#none" class="form_point">
					<fieldset>
						<legend class="screen_out">Use a Kakao Friends coupon form</legend>
						<strong class="tit_pointjoin">Use a Kakao Friends coupon</strong>
						<div class="coupon_code point_code">
							<div class="box_input">
								<label class="screen_out" for="cpnNum1">First 4 digits of Coupons</label>
								<input type="text" id="cpnNum1" name="couponNum1" class="tf_g" maxlength="4" placeholder="0000">
								<span class="txt_bar"></span>
							</div>
							<div class="box_input">
								<label class="screen_out" for="cpnNum2">Second 4 digits of Coupons</label>
								<input type="text" id="cpnNum2" name="couponNum2" class="tf_g" maxlength="4" placeholder="0000">
								<span class="txt_bar"></span>
							</div>
							<div class="box_input">
								<label class="screen_out" for="cpnNum3">Third 4 digits of Coupons</label>
								<input type="text" id="cpnNum3" name="couponNum3" class="tf_g" maxlength="4" placeholder="0000">
								<span class="txt_bar"></span>
							</div>
							<div class="box_input">
								<label class="screen_out" for="cpnNum4">Last 4 digits of Coupons</label>
								<input type="text" id="cpnNum4" name="couponNum4" class="tf_g" maxlength="4" placeholder="0000">
								<span class="txt_bar"></span>
							</div>
							<button type="button" class="btn_apply"><span class="txt_g">Apply</span></button>
						</div>
						<ul class="list_info">
							<li>Enter 16-digit number to register Kakao Friends coupon.</li>
							<li>Registered coupon cannot be transferred to another member.</li>
						</ul>
					</fieldset>
				</form>
			</div>

			<h4 class="tit_detial">Possessed coupons : <em class="num_coupon">${myAvailableCouponCount}</em></h4>
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
										<c:when test="${myAvailableCouponList.CT_ENAME == null && myAvailableCouponList.CPH_OPTION_TYPE ne 'D'}">
											${myAvailableCouponList.CPH_DUPLICATION == 'N' ? 'Regular' : 'Overlap'}
										</c:when>
										<c:otherwise>
											${myAvailableCouponList.CT_ENAME}
										</c:otherwise>
									</c:choose>
									<c:if test="${myAvailableCouponList.CPH_OPTION_TYPE eq 'D'}">FREE<br>SHIPPING</c:if>
									<c:if test="${myAvailableCouponList.CPH_OPTION_TYPE ne 'D'}"><br>discount</c:if>
								</strong>
							</div>
						</div>
						<div class="body_coupon">
							<dl class="info_name">
								<dt class="screen_out">Coupon name : </dt>
								<dd>
								<span class="txt_name">
									<c:if test="${!empty myAvailableCouponList.CPH_OPTION_VALUE && myAvailableCouponList.CPH_OPTION_VALUE != 0}">Purchase over <fmt:formatNumber value="${myAvailableCouponList.CPH_OPTION_VALUE}" type="number" /></c:if>
									<c:if test="${empty myAvailableCouponList.CPH_OPTION_VALUE || myAvailableCouponList.CPH_OPTION_VALUE == 0}">No limit on amount</c:if>
								</span>
								<span class="txt_price"><span class="num_price">
									<c:if test="${myAvailableCouponList.CPH_PRICE == 0}">FREESHIPPING</c:if>
									<c:if test="${myAvailableCouponList.CPH_PRICE != 0}"><fmt:formatNumber value="${myAvailableCouponList.CPH_PRICE}" type="number" /></span>WON</c:if>
								</span>
								</dd>
							</dl>
							<dl class="info_desc">
								<dt>Purchase over : </dt>
								<dd>${!empty myAvailableCouponList.CT_ENAME ? myAvailableCouponList.CT_ENAME : myAvailableCouponList.CPH_OPTION_TYPE_NM}<c:if test="${myAvailableCouponList.CPH_OPTION_CATEGORY != 0}"> Category</c:if></dd>
								<dt>Expiration date : </dt>
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
			<h4 class="tit_detial">Details of coupon</h4>
			<c:if test="${empty myCouponHistory}">
				<p class="desc_nodata"><span class="ico_newfriends_v1 ico_nodata"></span>There are no coupon details available.</p>
			</c:if>
			<c:if test="${!empty myCouponHistory}">
				<ul class="list_mypoint list_mycoupon">
					<c:forEach items="${ myCouponHistory }" var="myCouponHistory">
						<c:if test="${myCouponHistory.CPH_USE eq '1' || myCouponHistory.CPH_USE eq '4' || myCouponHistory.CPH_USE eq '6' }">
							<li>
								<span class="txt_date"><fmt:formatDate value="${myCouponHistory.REG_DTTM}" pattern="yyyy.MM.dd HH:mm:ss" /></span>
								<div class="wrap_tit">
									<span class="clip_g">${ myCouponHistory.CPH_ROW_GUBUN }</span>
									<strong class="tit_product">${ myCouponHistory.CPH_ENAME }</strong>
								</div>
								<dl class="info_price">
									<dt>Earn method :</dt>
									<dd>${myCouponHistory.CPH_TYPE_NM}</dd>
									<dt>Coupon category :</dt>
									<dd>${myCouponHistory.CPH_DUPLICATION == 'N' ? 'Regular' : 'Overlap'}</dd>
									<dt>Eligible for discount  :</dt>
									<dd>${!empty myCouponHistory.CT_ENAME ? myCouponHistory.CT_ENAME : myCouponHistory.CPH_OPTION_TYPE_NM}<c:if test="${myCouponHistory.CPH_OPTION_CATEGORY != 0}"> Category</c:if></dd>
									<!-- 2017-11-01 제한사항 추가 -->
									<dt>Restrictions :</dt>
									<dd>
										<c:if test="${!empty myCouponHistory.CPH_OPTION_VALUE && myCouponHistory.CPH_OPTION_VALUE != 0}">Purchase over <fmt:formatNumber value="${myCouponHistory.CPH_OPTION_VALUE}" type="number" /></c:if>
										<c:if test="${empty myCouponHistory.CPH_OPTION_VALUE || myCouponHistory.CPH_OPTION_VALUE == 0}">-</c:if>
									</dd>
									<!-- //2017-11-01 제한사항 추가 -->
									<dt>Expiration date :</dt>
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
									<strong class="tit_product">${ myCouponHistory.CPH_ENAME }</strong>
								</div>
								<dl class="info_price">
									<dt>Coupon category :</dt>
									<dd>${myCouponHistory.CPH_TYPE_NM}</dd>
									<dt>Eligible for discount :</dt>
									<dd>${!empty myCouponHistory.CT_ENAME ? myCouponHistory.CT_ENAME : myCouponHistory.CPH_OPTION_TYPE_NM}<c:if test="${myCouponHistory.CPH_OPTION_CATEGORY != 0}"> Category</c:if></dd>
									<dt>Order ID :</dt>
									<dd><c:if test="${!empty myCouponHistory.CPH_OMNUM}"><a href="/en/order/shipping/${myCouponHistory.CPH_OMNUM}" class="link_num"></c:if>
											${!empty myCouponHistory.CPH_OMNUM ? myCouponHistory.CPH_OMNUM : '-'}<c:if test="${!empty myCouponHistory.CPH_OMNUM}"></a></c:if></dd>
									<dt>Items :</dt>
									<dd>${!empty myCouponHistory.CPH_OMNUM && !empty myCouponHistory.CPH_ETITLE ? myCouponHistory.CPH_ETITLE : '-'}</dd>
								</dl>
							</li>
						</c:if>
						<c:if test="${myCouponHistory.CPH_USE eq '5' || myCouponHistory.CPH_USE eq '2'}">
							<li class="type_end">
								<!-- 만료된 쿠폰시 li에 type_end 클래스 부여 -->
								<span class="txt_date"><fmt:formatDate value="${myCouponHistory.CPH_USE eq '2' ? myCouponHistory.CPH_USEDATE : myCouponHistory.CPH_EDATE}" pattern="yyyy.MM.dd HH:mm:ss" /></span>
								<div class="wrap_tit">
									<span class="clip_g">${ myCouponHistory.CPH_ROW_GUBUN }</span>
									<strong class="tit_product">${ myCouponHistory.CPH_ENAME }</strong>
								</div>
								<dl class="info_price">
									<dt>Coupon category :</dt>
									<dd>${myCouponHistory.CPH_TYPE_NM}</dd>
									<dt>Eligible for discount :</dt>
									<dd>${!empty myCouponHistory.CT_ENAME ? myCouponHistory.CT_ENAME : myCouponHistory.CPH_OPTION_TYPE_NM}<c:if test="${myCouponHistory.CPH_OPTION_CATEGORY != 0}"> Category</c:if></dd>
									<dt>Order ID :</dt>
									<dd><c:if test="${!empty myCouponHistory.CPH_OMNUM}"><a href="/en/order/shipping/${myCouponHistory.CPH_OMNUM}" class="link_num"></c:if>
											${!empty myCouponHistory.CPH_OMNUM ? myCouponHistory.CPH_OMNUM : '-'}<c:if test="${!empty myCouponHistory.CPH_OMNUM}"></a></c:if></dd>
									<dt>Items :</dt>
									<dd>${!empty myCouponHistory.CPH_OMNUM && !empty myCouponHistory.CPH_ETITLE ? myCouponHistory.CPH_ETITLE : '-'}</dd>
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
            $("#frm").attr("action", "/en/mypage/couponlist/delete");
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
            url: "/en/mypage/applyOnlineCoupon",
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