<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="si" uri="http://www.kakaofriends.com/si" %>
<spring:eval expression="@environment['kakaofriends.cdn.product']" var="cdn"/>

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
			<li class="on">
				<a href="/en/mypage/pointlist" class="link_tab">Point <span class="screen_out">selected</span></a>
			</li>
			<li>
				<a href="/en/mypage/couponlist" class="link_tab">Coupon</a>
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
		<h3 class="screen_out">Point</h3>
		<div class="group_point">
			<h4 class="screen_out">My Points information</h4>
			<dl class="info_coll fst">
				<dt>Earn points </dt>
				<dd><fmt:formatNumber value="${myPointInfo.RESTTOTAL}" type="number"/>P</dd>
			</dl>
			<dl class="info_coll">
				<dt>Available points </dt>
				<dd><fmt:formatNumber value="${myPointInfo.RESTTOTAL >= 0 ? myPointInfo.RESTTOTAL : 0}" type="number"/></dd>
			</dl>
			<dl class="info_coll">
				<dt>Points to be expired </dt>
				<dd>
					<em class="emph_nump">-<fmt:formatNumber value="${myPointInfo.MP_REST}" type="number"/></em>
				</dd>
				<dd class="txt_vanish"><span class="screen_out">Expiration date </span>Until <fmt:formatDate value="${myPointInfo.MP_EDATE}" pattern="yyyy.MM.dd" /></dd>
			</dl>
			<strong class="screen_out">Remarks on Points</strong>
			<ul class="list_info">
				<%--<li>You need to have at least 3,000 points accumulated to make a purchase with them.</li>--%>
				<li>Points may expire if not used within a certain period, and the period varies by point type.
				</li>
			</ul>
		</div>
		<div class="group_formpoint">
			<!-- 모바일에서 포인트 등록하기 체크시 등록폼 활성화 coupon_on 클래스 부여 -->
			<div class="choice_g chk_g">
				<input type="checkbox" id="checkCoupon" class="inp_g">
				<label for="checkCoupon" class="lab_g"> <span class="ico_newfriends_v1 ico_choice"></span> Register points </label>
			</div>
			<form action="#none" class="form_point">
				<fieldset>
					<legend class="screen_out">Register points form</legend>
					<strong class="tit_pointjoin">Register points</strong>
					<div class="coupon_code point_code">
						<div class="box_input">
							<label class="screen_out" for="cpnNum1">First 4 digits of Points</label>
							<input type="text" id="cpnNum1" name="couponNum1" class="tf_g" maxlength="4" placeholder="0000">
							<span class="txt_bar"></span>
						</div>
						<div class="box_input">
							<label class="screen_out" for="cpnNum2">Second 4 digits of Points</label>
							<input type="text" id="cpnNum2" name="couponNum2" class="tf_g" maxlength="4" placeholder="0000">
							<span class="txt_bar"></span>
						</div>
						<div class="box_input">
							<label class="screen_out" for="cpnNum3">Third 4 digits of Points</label>
							<input type="text" id="cpnNum3" name="couponNum3" class="tf_g" maxlength="4" placeholder="0000">
							<span class="txt_bar"></span>
						</div>
						<div class="box_input">
							<label class="screen_out" for="cpnNum4">Last 4 digits of Points</label>
							<input type="text" id="cpnNum4" name="couponNum4" class="tf_g" maxlength="4" placeholder="0000">
							<span class="txt_bar"></span>
						</div>
						<button type="button" class="btn_apply"><span class="txt_g">Apply</span></button>
					</div>
					<ul class="list_info">
						<li>Enter 16-digit number to register Kakao Friends coupon.</li>
						<li>Registered points cannot be transferred to another member.</li>
					</ul>
				</fieldset>
			</form>
		</div>

		<div class="detail_list">
			<h4 class="tit_detial">Point details</h4>

			<%--<c:if test="${empty pointHistory}">--%>
				<%--<div>포인트 내역이 없음.</div>--%>
			<%--</c:if>--%>
			<%--<c:if test="${!empty pointHistory}">--%>
				<%--<c:forEach var="point" items="${pointHistory}">--%>
					<%--<c:if test="${point.mpType eq 'G'}">--%>
						<%--<div style="flex: 1;">gift</div>--%>
					<%--</c:if>--%>
					<%--<c:if test="${point.mpType eq 'R'}">--%>
						<%--<div style="flex: 1;">reserved</div>--%>
					<%--</c:if>--%>
					<%--<c:if test="${point.mpType eq 'X'}">--%>
						<%--<div style="flex: 1;">point cancelled</div>--%>
					<%--</c:if>--%>
					<%--<c:if test="${point.mpType eq 'U'}">--%>
						<%--<div style="flex: 1;">used</div>--%>
					<%--</c:if>--%>
					<%--<c:if test="${point.mpType eq 'C'}">--%>
						<%--<div style="flex: 1;">usage cancelled</div>--%>
					<%--</c:if>--%>
					<%--<c:if test="${point.mpType eq 'O'}">--%>
						<%--<div style="flex: 1;">earned</div>--%>
					<%--</c:if>--%>

					<%--<div style="display: flex; flex-direction: row;">--%>
						<%--<div style="flex: 1;">${point.mpAmount}</div>--%>
						<%--<div style="flex: 1;">${point.mpTypeEnNm}</div>--%>
						<%--<c:if test="${point.regLocation eq 'OLN'}">--%>
							<%--<div style="flex: 1;">Online</div>--%>
						<%--</c:if>--%>
						<%--<c:if test="${point.regLocation eq 'POS'}">--%>
							<%--<div style="flex: 1;">Offline</div>--%>
						<%--</c:if>--%>
						<%--<div style="flex: 1;">${point.mpSdate}</div>--%>
					<%--</div>--%>
				<%--</c:forEach>--%>
			<%--</c:if>--%>

			<c:if test="${empty myPointHistory}">
				<p class="desc_nodata"><span class="ico_newfriends_v1 ico_nodata"></span>There are no point details available.</p>
			</c:if>
			<c:if test="${!empty myPointHistory}">
				<ul class="list_mypoint">
					<c:forEach items="${ myPointHistory }" var="myPointHistory" varStatus="myPointStatus">
						<c:set
							value="${pointHistory[(pagination.currentPageNo - 1) * pagination.pageSize + myPointStatus.index]}"
							var="pointHistoryCrm"
						/>
						<c:if test="${myPointHistory.MP_TYPE ne 'U' && myPointHistory.MP_TYPE ne 'P' && myPointHistory.MP_AMOUNT > 0 }">
							<li>
								<span class="txt_date">
									<fmt:formatDate value="${myPointHistory.REG_DTTM}" pattern="yyyy.MM.dd HH:mm:ss" />
								</span>
								<div class="wrap_tit">
									<span class="clip_g">
										<c:if test="${empty(pointHistoryCrm.mpTypeEnNm)}">
											${ myPointHistory.MP_TYPE_NM }
										</c:if>
										<c:if test="${not empty(pointHistoryCrm.mpTypeEnNm)}">
											${pointHistoryCrm.mpTypeEnNm}
										</c:if>
									</span>
									<strong class="tit_product">${ myPointHistory.MP_ETITLE }</strong>
									<dl class="info_store">
										<dt class="screen_out">Earn Points : </dt>
										<dd>
											<span class="num_price">
											    <c:if test="${myPointHistory.MP_AMOUNT > 0}">+</c:if>
											    <fmt:formatNumber value="${myPointHistory.MP_AMOUNT}" type="number"/>
											</span>
										</dd>
									</dl>
								</div>
								<dl class="info_price">
									<dt>Order ID :</dt>
									<dd>
										<c:if test="${!empty myPointHistory.MP_OMNUM}">
											<a href="/en/order/shipping/${myPointHistory.MP_OMNUM}" class="link_num">${myPointHistory.MP_OMNUM}</a>
										</c:if>
										<c:if test="${empty myPointHistory.MP_OMNUM}">-</c:if>
									</dd>
									<dt>Price :</dt>
									<dd>
										<c:if test="${myPointHistory.TOTALMONEY != 0}">
											<fmt:formatNumber value="${myPointHistory.TOTALMONEY}" type="number"/> KRW
											(<fmt:formatNumber value="${myPointHistory.TOTALMONEY_EXCHANGE}" type="number"/> USD)
										</c:if>
										<c:if test="${myPointHistory.TOTALMONEY == 0}">-</c:if>
									</dd>
									<dt>Expiration date :</dt>
									<dd>
										<c:if test="${!empty myPointHistory.MP_EDATE}">
											<fmt:formatDate value="${myPointHistory.MP_EDATE}" pattern="yyyy.MM.dd" />
										</c:if>
										<c:if test="${empty myPointHistory.MP_EDATE}">-</c:if>
									</dd>
								</dl>
							</li>
						</c:if>
						<c:if test="${myPointHistory.MP_TYPE eq 'U' || myPointHistory.MP_TYPE eq 'P' || myPointHistory.MP_AMOUNT < 0}">
							<li class=${myPointHistory.MP_TYPE eq 'U' or  myPointHistory.MP_AMOUNT < 0 ? 'type_use' : 'type_end'}>
								<span class="txt_date"><fmt:formatDate value="${myPointHistory.MP_TYPE eq 'U' ? myPointHistory.REG_DTTM : myPointHistory.MP_EDATE}" pattern="yyyy.MM.dd HH:mm:ss" /></span>
								<div class="wrap_tit">
									<span class="clip_g">
										<c:if test="${empty(pointHistoryCrm.mpTypeEnNm)}">
											${ myPointHistory.MP_TYPE_NM }
										</c:if>
									    <c:if test="${not empty(pointHistoryCrm.mpTypeEnNm)}">
											${pointHistoryCrm.mpTypeEnNm}
										</c:if>
									</span>
									<strong class="tit_product">${ myPointHistory.MP_ETITLE }</strong>
									<dl class="info_store">
										<dt class="screen_out">Earn Points : </dt>
										<dd>
											<span class="num_price">
												<c:if test="${myPointHistory.MP_AMOUNT > 0}">+</c:if>
												<fmt:formatNumber value="${myPointHistory.MP_AMOUNT}" type="number"/>
											</span>
										</dd>
									</dl>
								</div>
								<dl class="info_price">
									<dt>Order ID :</dt>
									<dd>
										<c:if test="${!empty myPointHistory.MP_OMNUM}">
											<a href="/en/order/shipping/${myPointHistory.MP_OMNUM}" class="link_num">${myPointHistory.MP_OMNUM}</a>
										</c:if>
										<c:if test="${empty myPointHistory.MP_OMNUM}">-</c:if>
									</dd>
									<dt>Price :</dt>
									<dd>
										<c:if test="${myPointHistory.TOTALMONEY != 0}">
											<fmt:formatNumber value="${myPointHistory.TOTALMONEY}" type="number"/> KRW
											(<fmt:formatNumber value="${myPointHistory.TOTALMONEY_EXCHANGE}" type="number"/> USD)
										</c:if>
										<c:if test="${myPointHistory.TOTALMONEY == 0}">-</c:if>
									</dd>
									<c:if test="${myPointHistory.COUPONMONEY != 0}">
										<dt>Coupon discount :</dt>
										<dd>-<fmt:formatNumber value="${myPointHistory.COUPONMONEY}" type="number"/> KRW</dd>
									</c:if>
									<dt>Total :</dt>
									<dd>
										<c:if test="${myPointHistory.PAYMONEY != 0}">
											<fmt:formatNumber value="${myPointHistory.PAYMONEY}" type="number"/> KRW
											(<fmt:formatNumber value="${myPointHistory.PAYMONEY_EXCHANGE}" type="number"/> USD)
										</c:if>
										<c:if test="${myPointHistory.PAYMONEY == 0}">-</c:if>
									</dd>
								</dl>
							</li>
						</c:if>
					</c:forEach>
				</ul>
				<tiles:insertTemplate template="/WEB-INF/templates/en/sub/paging.jsp" flush="true"/>
			</c:if>
		</div>
	</div>
</div>
<!--// 포인트 탭 상세 끝 -->

<script type="text/javascript">
    function applyMyCoupon(){

        var coupon1 = $("#cpnNum1").val();
        var coupon2 = $("#cpnNum2").val();
        var coupon3 = $("#cpnNum3").val();
        var coupon4 = $("#cpnNum4").val();
        var _couponNum = coupon1.concat("-",coupon2,"-",coupon3,"-",coupon4);

        $.ajax({
            headers: {'X-CSRF-TOKEN': '${_csrf.token}'},
            url: "/en/mypage/applyPointCoupon",
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
                    myPagePopup(data.resultMsg, 'pointlist');
                    return false;
                }
                alertNoti('error.occurred');
            }
        });
    }
</script>
