<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="si" uri="http://www.kakaofriends.com/si" %>
<style>
.cont_product div {margin-top : 15px;}
.cont_product form {margin-top : 15px;border-top : 1px solid #000;}
.cont_product button {border: 1px solid;margin-top : 15px;}

</style>
<div id="mArticle">
	<div class="cont_product">
		<strong class="screen_out">멤버십 테스트화면</strong>
		<h3 class="screen_out">멤버십 테스트화면</h3>
		<div>
			<form action="#none" class="">
				<fieldset>
					<h3>포인트 적립</h3>
					<span>타입은 고정 (E - 이벤트)</span>
					<div>
						<span>사용자 선택 : </span>
						<select id="p_user">
							<c:forEach items="${userList}" var="userList">
								<option value="${userList.id}">${userList.email}</option>
							</c:forEach>
						</select>
					</div>
					<div>
						<span>날짜 선택 : </span>
						<span><input type="date" name="psdate"> ~ <input type="date" name="pedate"></span>
					</div>
					<div>
						<span>포인트 적립</span>
						<input type="text" class="point" id="tbPoint" placeholder="1,000" name="tbPoint">P
					</div>
					<button type="button" class="btn_point">포인트 넣기</button>
				</fieldset>
			</form>
			<form action="#none" class="">
				<fieldset>
					<h3>온라인쿠폰 마스터 생성</h3>
					<p>쿠폰등록시 오류가 나면 쿠폰넘버가 기존테이블에 등록되어있어서 일 가능성이 큽니다.<br>형식 맞춰서 넣어주시고 코드 바꿔서 적용해보세요<br>안되면 문의~<br><br>
					<%--무료배송쿠폰은 중복쿠폰에만 존재합니다--%>
					</p>
					<div>
						<p>발행목적 : </p>
						<p>
							<span>한글 : </span>
							<input type="text" name="goal">
						</p>
						<p>
							<span>영어 : </span>
							<input type="text" name="egoal">
						</p>
					</div>
					<div>
						<p>
							<span>할인금액 : </span>
							<input type="text" name="price">
						</p>
						<p>
							<span>금액제한 : </span>
							<input type="text" name="sales">
						</p>
					</div>
					<div>
						<p>쿠폰넘버 (예시 : C20171111111222222)</p>
						<p>
							<input type="text" name="mCoupon">
						</p>
					</div>
					<%--<div>
						<span>카테고리 선택 : </span>
						<select id="c_category">
							<c:forEach items="${categoryList}" var="categoryList">
								<option value="${categoryList.CT_CODE}">${categoryList.CT_NAME}</option>
							</c:forEach>
						</select>
					</div>--%>
					<div>
						<span>지류 / 온라인 선택</span>
						<span>
							<label for="cNoPaper">일반</label>
							<input type="radio" id="cNoPaper" name="couponType3" value="N" checked>
						</span>
						<span>
							<label for="cPaper">지류</label>
							<input type="radio" id="cPaper" name="couponType3" value="Y">
						</span>
					</div>
					<div>
						<span>쿠폰 종류 선택 :</span>
						<span>
							<label for="cBasic">일반</label>
							<input type="radio" id="cBasic" name="couponType1" value="N" checked>
						</span>
						<span>
							<label for="cDuplication">중복</label>
							<input type="radio" id="cDuplication" name="couponType1" value="Y">
						</span>
					</div>
					<div>
						<span>쿠폰 타입 선택 :</span>
						<span>
							<label for="cBasic">일반(금액)</label>
							<input type="radio" id="cSale" name="couponType2" value="A" checked>
						</span>
						<%--<span>
							<label for="cDuplication">배송</label>
							<input type="radio" id="cFree" name="couponType2" value="D" disabled>
						</span>
						<span>
							<label for="cDuplication">카테고리</label>
							<input type="radio" id="cCate" name="couponType2" value="C">
						</span>--%>
					</div>
					<div>
						<span>날짜 선택 : </span>
						<span><input type="date" name="csdate"> ~ <input type="date" name="cedate"></span>
					</div>
					<button type="button" class="btn_master_coupon">온라인 마스터쿠폰생성 넣기</button>
				</fieldset>
			</form>
			<form action="#none" class="">
				<fieldset>
					<h3>온라인쿠폰 서브 생성</h3>
					<p>쿠폰등록시 오류가 나면 쿠폰넘버가 기존테이블에 등록되어있어서 일 가능성이 큽니다.<br>형식 맞춰서 넣어주시고 코드 바꿔서 적용해보세요<br>안되면 문의해주세요~</p>
					<p>마스터 쿠폰 선택시 지류쿠폰(Y)이면 사용자에게 등록하지 않으므로 사용자를 선택할 수 없습니다.<br>쿠폰넘버를 넣어 등록하면 마이페이지에서 등록가능한 쿠폰이 발행됩니다.</p>
					<div>
						<span>쿠폰마스터 선택 : </span>
						<select id="c_master">
							<c:forEach items="${masterList}" var="masterList">
								<option value="${masterList.CPH_GCMCODE}">${masterList.CPH_GCMCODE}
									(<fmt:formatDate value="${masterList.CPH_SDATE}" pattern="yyyy.MM.dd" /> ~
									<fmt:formatDate value="${masterList.CPH_EDATE}" pattern="yyyy.MM.dd" />)

									<c:if test="${masterList.CPH_TYPE == '6'}"> / 일반</c:if>
									<c:if test="${masterList.CPH_TYPE == '7'}"> / 지류</c:if>
								</option>
							</c:forEach>
						</select>
						<div id="cm_info">
						</div>
					</div>
					<div>
						<span>사용자 선택 : </span>
						<select id="c_user">
							<c:forEach items="${userList}" var="userList">
								<option value="${userList.id}">${userList.email}</option>
							</c:forEach>
						</select>
					</div>
					<div>
						<p>쿠폰넘버 (예시 : xxxx-xxxx-xxxx-xxxx)</p>
						<p>
							<input type="text" name="c_code" value="${examCouponNum}">
						</p>
					</div>
					<button type="button" class="btn_sub_coupon">온라인쿠폰생성 넣기</button>
				</fieldset>
			</form>
			<form class="master_form">
				<input type="hidden" name="ss_mname" value="" />
				<input type="hidden" name="ss_mename" value="" />
				<input type="hidden" name="ss_mprice" value="" />
				<input type="hidden" name="ss_duplication" value="" />
				<input type="hidden" name="ss_gcmcode" value="" />
				<input type="hidden" name="ss_optiontype" value="" />
				<input type="hidden" name="ss_optionvalue" value="" />
				<input type="hidden" name="ss_optionCategory" value="" />
				<input type="hidden" name="ss_sdate" value="" />
				<input type="hidden" name="ss_edate" value="" />
				<input type="hidden" name="ss_type" value="" />
			</form>
		</div>
	</div>
</div><!--// mArticle -->



<script type="text/javascript">
    $(function() {
        /*$("input:radio[name=couponType1]").on("click", function () {
            var cptype = $("input:radio[name=couponType1]:checked").val();

            if (cptype == "N") {
            	document.getElementById("cFree").disabled = true;
            } else {
                document.getElementById("cFree").disabled = false;
			}
        });*/

        $(".btn_point").on("click", function () {
            var point_id = $("#p_user option:selected").val();
            var point = $("#tbPoint").val();
            var sdate = $("input[name=psdate]").val();
            var edate = $("input[name=pedate]").val();

            $.ajax({
                headers: {'X-CSRF-TOKEN': '${_csrf.token}'},
                url: "/kr/addPoint",
                type: "POST",
                dataType: "json",
                data: { MP_USERID:point_id, MP_AMOUNT:point, MP_REST:point, MP_SDATE:sdate, MP_EDATE:edate },
                async:false,
                success: function (data) {
                    if (data.statusCode == '0000') {
                        alert('등록');
                    } else if(data.statusCode == '0001') {
                        alert('처리중 에러가 발생하였습니다.');
                    }
                },
                error: function (e) {
                    console.log(e);
                    alert('처리중 에러가 발생하였습니다.');
                    return false;
                }
            });
        });

        $(".btn_master_coupon").on("click", function () {
            var cphGcmcode = $("input[name=mCoupon]").val();
            var cphName = $("input[name=goal]").val();
            var cphEname = $("input[name=egoal]").val();
            var cphSdate = $("input[name=csdate]").val();
            var cphEdate = $("input[name=cedate]").val();
            var cphPrice = $("input[name=price]").val();
            var cphDuplication = $("input:radio[name=couponType1]:checked").val();
            var cphOptionType = $("input:radio[name=couponType2]:checked").val();
            var cphOptionValue = $("input[name=sales]").val();
            var cphOptionCategory = '';
            var cphPaper = $("input:radio[name=couponType3]:checked").val();

            if (cphOptionType == 'C') {
                cphOptionCategory = $("#c_category option:selected").val();
			}

            $.ajax({
                headers: {'X-CSRF-TOKEN': '${_csrf.token}'},
                url: "/kr/addMasterCoupon",
                type: "POST",
                dataType: "json",
                data: {
                    CPH_GCMCODE:cphGcmcode, CPH_NAME:cphName, CPH_ENAME:cphEname, CPH_SDATE:cphSdate, CPH_EDATE:cphEdate, CPH_PRICE:cphPrice,
					CPH_DUPLICATION:cphDuplication, CPH_OPTION_TYPE:cphOptionType, CPH_OPTION_VALUE:cphOptionValue, CPH_OPTION_CATEGORY:cphOptionCategory, CPH_PAPER:cphPaper
                },
                async:false,
                success: function (data) {
                    if (data.statusCode == '0000') {
                        alert('등록');
                    } else if(data.statusCode == '0001') {
                        alert('처리중 에러가 발생하였습니다.');
                    }
                },
                error: function (e) {
                    console.log(e);
                    alert('처리중 에러가 발생하였습니다.');
                    return false;
                }
            });
        });

        $('#c_master').change(function(e) {
			var GCM_CODE = $(this).val();
            $.ajax({
                headers: {'X-CSRF-TOKEN': '${_csrf.token}'},
                url: "/kr/selectMasterCodeInfo",
                type: "POST",
                dataType: "json",
                data: { GCM_CODE:GCM_CODE },
                async:false,
                success: function (data) {
					alert('결과출력');
					var tResult = '<p>마스터코드 : ' + data.mData.cph_GCMCODE + '</p>'
                        + '<p>쿠폰유형(N:일반,Y:지류) : ' + data.mData.cph_TYPE + '</p>'
						+ '<p>쿠폰타입 : ' + data.mData.cph_OPTION_TYPE + '</p>'
						+ '<p>할인가격 : ' + data.mData.cph_PRICE + '</p>'
						+ '<p>금액제한 : ' + data.mData.cph_OPTION_VALUE + '</p>'
						+ '<p>중복여부 : ' + data.mData.cph_DUPLICATION + '</p>'
						+ '<p>쿠폰명 : ' + data.mData.cph_NAME + '</p>'
						+ '<p>쿠폰명(영문) : ' + data.mData.cph_ENAME + '</p>'
						+ '<p>쿠폰기한 : ' + data.mSdate + ' ~ ' + data.mEdate + '</p>'
						+ '<p>카테고리제한 : ' + data.mData.ct_NAME + '(' + data.mData.cph_OPTION_CATEGORY + ')</p>';

					document.getElementById("cm_info").innerHTML = tResult;

                    $("input[name=ss_mname]").val(data.mData.cph_NAME);
                    $("input[name=ss_mename]").val(data.mData.cph_ENAME);
                    $("input[name=ss_mprice]").val(data.mData.cph_PRICE);
                    $("input[name=ss_duplication]").val(data.mData.cph_DUPLICATION);
                    $("input[name=ss_gcmcode]").val(data.mData.cph_GCMCODE);
                    $("input[name=ss_optiontype]").val(data.mData.cph_OPTION_TYPE);
                    $("input[name=ss_optionvalue]").val(data.mData.cph_OPTION_VALUE);
                    $("input[name=ss_optionCategory]").val(data.mData.cph_OPTION_CATEGORY);
                    $("input[name=ss_sdate]").val(data.mSdate);
                    $("input[name=ss_edate]").val(data.mEdate);
                    $("input[name=ss_type]").val(data.mData.cph_TYPE);


                    if (data.mData.cph_TYPE == 'Y') {
                        $("#c_user").prop('disabled', true);
					} else {
                        $("#c_user").prop('disabled', false);
					}
                },
                error: function (e) {
                    console.log(e);
                    alert('처리중 에러가 발생하였습니다.');
                    return false;
                }
            });
        });

        $(".btn_sub_coupon").on("click", function () {
            var m_name = $("input[name=ss_mname]").val();
            var m_ename = $("input[name=ss_mename]").val();
            var m_price = $("input[name=ss_mprice]").val();
            var m_duplication = $("input[name=ss_duplication]").val();
            var m_gcmcode = $("input[name=ss_gcmcode]").val();
            var m_optiontype = $("input[name=ss_optiontype]").val();
            var m_optionvalue = $("input[name=ss_optionvalue]").val();
            var m_optinoCategory = $("input[name=ss_optionCategory]").val();
            var m_sdate = $("input[name=ss_sdate]").val();
            var m_edate = $("input[name=ss_edate]").val();
            var m_type = $("input[name=ss_type]").val();
            var s_use_id = $("#c_user option:selected").val();
            var c_code = $("input[name=c_code]").val();

            $.ajax({
                headers: {'X-CSRF-TOKEN': '${_csrf.token}'},
                url: "/kr/addSubCoupon",
                type: "POST",
                dataType: "json",
                data: {
                    m_name:m_name, m_ename:m_ename, m_price:m_price, m_duplication:m_duplication, m_gcmcode:m_gcmcode, m_optiontype:m_optiontype,
                    m_optionvalue:m_optionvalue, m_optinoCategory:m_optinoCategory, m_sdate:m_sdate, m_edate:m_edate, s_use_id:s_use_id, c_code:c_code, m_type: m_type
                },
                async:false,
                success: function (data) {
                    if (data.statusCode == '0000') {
                        alert('등록');
                    } else if(data.statusCode == '0001') {
                        alert('처리중 에러가 발생하였습니다.');
                    }
                },
                error: function (e) {
                    console.log(e);
                    alert('처리중 에러가 발생하였습니다.');
                    return false;
                }
            });
        });
    });
</script>