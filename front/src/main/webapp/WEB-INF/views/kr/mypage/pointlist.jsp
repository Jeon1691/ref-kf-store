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
				<a href="/kr/mypage/orderlist" class="link_tab">주문내역</a>
			</li>
			<li>
				<a href="/kr/mypage/wishlist" class="link_tab">찜</a>
			</li>
			<li>
				<a href="/kr/mypage/cancellist" class="link_tab">취소/교환</a>
			</li>
			<li class="on">
				<a href="/kr/mypage/pointlist" class="link_tab">포인트 <span class="screen_out">선택됨</span></a>
			</li>
			<li>
				<a href="/kr/mypage/couponlist" class="link_tab">쿠폰</a>
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
		<h3 class="screen_out">포인트</h3>
		<div class="group_point">
			<h4 class="screen_out">내 포인트 정보</h4>
			<c:if test="${not empty crmMembership and not empty crmMembership.point and empty crmMembership.error}">
				<c:set value="${crmMembership.point.accumPoint}" var="pointTotal" />
				<c:set value="${crmMembership.point.availablePoint}" var="pointAvailable" />
				<c:set value="${crmMembership.point.expiringPoint}" var="pointExpiring" />
				<fmt:parseDate value="${crmMembership.point.expiringDate}" pattern="yyyy.MM.dd" var="expiringDate"/>
			</c:if>
			<c:if test="${empty crmMembership or empty crmMembership.point or not empty crmMembership.error}">
				<c:set value="${myPointInfo.RESTTOTAL}" var="pointTotal" />
				<c:set value="${myPointInfo.RESTTOTAL >= 0 ? myPointInfo.RESTTOTAL : 0}" var="pointAvailable" />
				<c:set value="${'-' + myPointInfo.MP_REST}" var="pointExpiring" />
				<c:set value="${myPointInfo.MP_EDATE}" var="expiringDate" />
			</c:if>

			<dl class="info_coll fst">
				<dt>현재 적립된 포인트 </dt>
				<dd><fmt:formatNumber value="${pointTotal}" type="number"/>P</dd>
			</dl>
			<dl class="info_coll">
				<dt>사용 가능 포인트 </dt>
				<dd><fmt:formatNumber value="${pointAvailable}" type="number"/></dd>
			</dl>
			<dl class="info_coll">
				<dt>소멸 예정 포인트 </dt>
				<dd>
					<em class="emph_nump"><fmt:formatNumber value="${pointExpiring}" type="number"/></em>
				</dd>
				<dd class="txt_vanish">
					<span class="screen_out">소멸 예정일 </span><fmt:formatDate value="${expiringDate}" pattern="yyyy.MM.dd" />까지
				</dd>
			</dl>
			<strong class="screen_out">포인트 유의사항</strong>
			<ul class="list_info">
				<%--<li>적립 된 포인트는 3,000포인트 부터 상품결제 시 사용 가능합니다.</li>--%>
				<li>포인트 종류에 따라 사용 가능기간이 설정되어 기간내 사용을 하지 않을 시 소멸될 수 있습니다.</li>
			</ul>
		</div>
		<div class="group_formpoint">
			<!-- 모바일에서 포인트 등록하기 체크시 등록폼 활성화 coupon_on 클래스 부여 -->
			<div class="choice_g chk_g">
				<input type="checkbox" id="checkCoupon" class="inp_g">
				<label for="checkCoupon" class="lab_g"> <span class="ico_newfriends_v1 ico_choice"></span> 포인트 등록하기 </label>
			</div>
			<form action="#none" class="form_point">
				<fieldset>
					<legend class="screen_out">포인트 등록폼</legend>
					<strong class="tit_pointjoin">포인트 등록하기</strong>
					<div class="coupon_code point_code">
						<div class="box_input">
							<label class="screen_out" for="cpnNum1">포인트 첫번째 4자리</label>
							<input type="text" id="cpnNum1" name="couponNum1" class="tf_g" maxlength="4" placeholder="0000">
							<span class="txt_bar"></span>
						</div>
						<div class="box_input">
							<label class="screen_out" for="cpnNum2">포인트 두번째 4자리</label>
							<input type="text" id="cpnNum2" name="couponNum2" class="tf_g" maxlength="4" placeholder="0000">
							<span class="txt_bar"></span>
						</div>
						<div class="box_input">
							<label class="screen_out" for="cpnNum3">포인트 세번째 4자리</label>
							<input type="text" id="cpnNum3" name="couponNum3" class="tf_g" maxlength="4" placeholder="0000">
							<span class="txt_bar"></span>
						</div>
						<div class="box_input">
							<label class="screen_out" for="cpnNum4">포인트 마지막 4자리</label>
							<input type="text" id="cpnNum4" name="couponNum4" class="tf_g" maxlength="4" placeholder="0000">
							<span class="txt_bar"></span>
						</div>
						<button type="button" class="btn_apply"><span class="txt_g">적용</span></button>
					</div>
					<ul class="list_info">
						<li>16자리 번호를 입력하여 카카오프렌즈 포인트로 등록합니다.</li>
						<li>등록된 포인트는 본인 외 타인에게 양도할 수 없습니다.</li>
					</ul>
				</fieldset>
			</form>
		</div>

		<div class="detail_list">
          <h4 class="tit_detial">포인트 상세 내역</h4>

          <%--<c:if test="${empty pointHistory}">--%>
            <%--<div>포인트 내역이 없음.</div>--%>
          <%--</c:if>--%>

          <%--<c:if test="${!empty pointHistory}">--%>
            <%--<c:forEach var="point" items="${pointHistory}">--%>
              <%--<div style="display: flex; flex-direction: row;">--%>
                <%--<c:if test="${point.mpType eq 'G'}">--%>
                  <%--<div style="flex: 1;">기프트</div>--%>
                <%--</c:if>--%>
                <%--<c:if test="${point.mpType eq 'R'}">--%>
                  <%--<div style="flex: 1;">적립예정</div>--%>
                <%--</c:if>--%>
                <%--<c:if test="${point.mpType eq 'X'}">--%>
                  <%--<div style="flex: 1;">적립취소</div>--%>
                <%--</c:if>--%>
                <%--<c:if test="${point.mpType eq 'U'}">--%>
                  <%--<div style="flex: 1;">사용</div>--%>
                <%--</c:if>--%>
                <%--<c:if test="${point.mpType eq 'C'}">--%>
                  <%--<div style="flex: 1;">사용취소</div>--%>
                <%--</c:if>--%>
                <%--<c:if test="${point.mpType eq 'O'}">--%>
                  <%--<div style="flex: 1;">적립</div>--%>
                <%--</c:if>--%>

                <%--<div style="flex: 1;">${point.mpAmount}</div>--%>
                <%--<div style="flex: 1;">${point.mpTypeNm}</div>--%>
                <%--<c:if test="${point.regLocation eq 'OLN'}">--%>
                  <%--<div style="flex: 1;">온라인</div>--%>
                <%--</c:if>--%>
                <%--<c:if test="${point.regLocation eq 'POS'}">--%>
                  <%--<div style="flex: 1;">오프라인</div>--%>
                <%--</c:if>--%>
                <%--<div style="flex: 1;">${point.mpSdate}</div>--%>
              <%--</div>--%>
            <%--</c:forEach>--%>
          <%--</c:if>--%>

			<c:if test="${empty myPointHistory}">
				<p class="desc_nodata">
					<span class="ico_newfriends_v1 ico_nodata"></span>포인트 상세 내역이 없습니다.
				</p>
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
                                      <c:if test="${empty(pointHistoryCrm.mpTypeNm)}">
                                        ${ myPointHistory.MP_TYPE_NM }
                                      </c:if>
                                      <c:if test="${not empty(pointHistoryCrm.mpTypeNm)}">
                                        ${pointHistoryCrm.mpTypeNm}
                                      </c:if>
                                    </span>
									<strong class="tit_product">${ myPointHistory.MP_TITLE }</strong>
									<dl class="info_store">
										<dt class="screen_out">적립된 포인트 : </dt>
										<dd>
											<span class="num_price">
												<c:if test="${myPointHistory.MP_AMOUNT > 0}">+</c:if>
												<fmt:formatNumber value="${myPointHistory.MP_AMOUNT}" type="number"/>
											</span>
										</dd>
									</dl>
								</div>
								<dl class="info_price">
									<dt>주문번호 :</dt>
									<dd>
										<c:if test="${!empty myPointHistory.MP_OMNUM}">
											<a href="/kr/order/shipping/${myPointHistory.MP_OMNUM}" class="link_num">${myPointHistory.MP_OMNUM}</a>
										</c:if>
										<c:if test="${empty myPointHistory.MP_OMNUM}">-</c:if>
									</dd>
									<dt>결제금액 :</dt>
									<dd>
										<c:if test="${myPointHistory.TOTALMONEY != 0}">
											<fmt:formatNumber value="${myPointHistory.TOTALMONEY}" type="number"/> 원
											 (<fmt:formatNumber value="${myPointHistory.TOTALMONEY_EXCHANGE}" type="number"/> USD)
										</c:if>
										<c:if test="${myPointHistory.TOTALMONEY == 0}">-</c:if>
									</dd>
									<dt>소멸예정일 :</dt>
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
										<c:if test="${empty(pointHistoryCrm.mpTypeNm)}">
											${ myPointHistory.MP_TYPE_NM }
										</c:if>
                                        <c:if test="${not empty(pointHistoryCrm.mpTypeNm)}">
										    ${pointHistoryCrm.mpTypeNm}
									    </c:if>
									</span>
									<strong class="tit_product">${ myPointHistory.MP_TITLE }</strong>
									<dl class="info_store">
										<dt class="screen_out">적립된 포인트 : </dt>
										<dd>
											<span class="num_price">
												<c:if test="${myPointHistory.MP_AMOUNT > 0}">+</c:if>
												<fmt:formatNumber value="${myPointHistory.MP_AMOUNT}" type="number"/>
											</span>
										</dd>
									</dl>
								</div>
								<dl class="info_price">
									<dt>주문번호 :</dt>
									<dd>
										<c:if test="${!empty myPointHistory.MP_OMNUM}">
											<a href="/kr/order/shipping/${myPointHistory.MP_OMNUM}" class="link_num">${myPointHistory.MP_OMNUM}</a>
										</c:if>
										<c:if test="${empty myPointHistory.MP_OMNUM}">-</c:if>
									</dd>
									<dt>상품금액 :</dt>
									<dd>
										<c:if test="${myPointHistory.TOTALMONEY != 0}">
											<fmt:formatNumber value="${myPointHistory.TOTALMONEY}" type="number"/> 원
											(<fmt:formatNumber value="${myPointHistory.TOTALMONEY_EXCHANGE}" type="number"/> USD)
										</c:if>
										<c:if test="${myPointHistory.TOTALMONEY == 0}">-</c:if>
									</dd>
									<c:if test="${myPointHistory.COUPONMONEY != 0}">
										<dt>쿠폰할인 :</dt>
										<dd>-<fmt:formatNumber value="${myPointHistory.COUPONMONEY}" type="number"/> 원</dd>
									</c:if>
									<dt>결제금액 :</dt>
									<dd>
										<c:if test="${myPointHistory.PAYMONEY != 0}">
											<fmt:formatNumber value="${myPointHistory.PAYMONEY}" type="number"/> 원
											(<fmt:formatNumber value="${myPointHistory.PAYMONEY_EXCHANGE}" type="number"/> USD)
										</c:if>
										<c:if test="${myPointHistory.PAYMONEY == 0}">-</c:if>
									</dd>
								</dl>
							</li>
						</c:if>
					</c:forEach>
				</ul>
				<tiles:insertTemplate template="/WEB-INF/templates/kr/sub/paging.jsp" flush="true"/>
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
            url: "/kr/mypage/applyPointCoupon",
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
