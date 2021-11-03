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
			<li>
				<a href="/en/mypage/couponlist" class="link_tab">Coupon</a>
			</li>
			<li>
				<a href="/en/mypage/onetoone" class="link_tab">Contact Us</a>
			</li>
			<li class="on">
				<a href="/en/mypage/myinfo" class="link_tab">Account <span class="screen_out">selected</span></a>
			</li>
		</ul>
	</div>
	<!--// 2017-10-19 수정 끝 : 마이페이지 탭메뉴 변경 -->
	<div class="privacy_edit">
		<form id="frm">
			<input type="hidden" id="id" name="id" value="${user.id}"/>
			<input type="hidden" id="oldName" name="oldName" value="${user.name}" />
			<input type="hidden" id="oldEmail" name="oldEmail" value="${user.email}" />
			<input type="hidden" id="oldCountry" name="oldCountry" value="${user.country}" />
			<input type="hidden" id="oldPhoneNumber" name="oldPhoneNumber" value="${user.phoneNumber}" />
			<input type="hidden" id="email" name="email" value="${user.email}"/>
			<input type="hidden" id="name" name="name" value="${user.name}"/>
			<input type="hidden" id="country" name="country" value="${user.country}"/>
			<input type="hidden" id="phoneNumber" name="phoneNumber" value="${user.phoneNumber}"/>
			<input type="hidden" id="phoneAuth" name="phoneAuth" value="false"/>
			<input type="hidden" name="_csrf" value="${_csrf.token}"/>
			<input type="hidden" name="_csrf_header" value="${_csrf.headerName}"/>

			<fieldset>
				<legend class="screen_out">Your Account form</legend>
				<h3 class="tit_detial">Your Account</h3>
				<div class="group_join group_join2">
					<dl class="list_inp">
						<dt class="screen_out"><label class="lab_tf" for="tfId">ID (e-mail)<span class="screen_out"> input necessary</span></label></dt>
						<dd>
							<input type="text" class="tf_g tf_id" id="tfId" value="${email.address}" onkeyup="toggleLabel(this, 'screen_out');">
							<span class="txt_email">@</span>
							<div class="opt_g opt_email opt_directwhite"><!-- 클릭시 .opt_on 추가 --><!-- 직접입력시 .opt_directwhite 추가 -->
								<div class="write_domain">
									<label class="lab_tf screen_out" for="tfDomain">Input directly</label><!-- 직접입력시 screen_out 클래스 추가 -->
									<input type="text" class="tf_g tf_domain" id="tfDomain" onkeyup="toggleLabel(this, 'screen_out');" value="${email.domain}"><!-- 직접입력시 value에 값 넣어주세요 -->
								</div>
								<a href="#none" class="link_selected">
									<strong class="screen_out">select email</strong>
									<%--									<span class="txt_opt">daum.net</span>
                                                                        <span class="screen_out">선택됨</span>--%>
									<span class="ico_newfriends_v1 ico_opt"></span>
								</a>
								<div class="box_opt">
									<em class="screen_out">select option</em>
									<ul class="list_opt">
										<li><a href="javascript:changeMailDomain('daum.net')" class="link_opt">daum.net</a></li>
										<li><a href="javascript:changeMailDomain('hanmail.net')" class="link_opt">hanmail.net</a></li>
										<li><a href="javascript:changeMailDomain('naver.com')" class="link_opt">naver.com</a></li>
										<li><a href="javascript:changeMailDomain('gmail.com')" class="link_opt">gmail.com</a></li>
										<li><a href="javascript:changeMailDomain('nate.com')" class="link_opt">nate.com</a></li>
										<li><a href="javascript:changeMailDomain('hotmail.com')" class="link_opt">hotmail.com</a></li>
										<li><a href="javascript:changeMailDomain('paran.com')" class="link_opt">paran.com</a></li>
										<li><a href="javascript:changeMailDomain('chol.com')" class="link_opt">chol.com</a></li>
										<li><a href="javascript:changeMailDomain('korea.com')" class="link_opt">korea.com</a></li>
										<li><a href="javascript:changeMailDomain('dreamwiz.com')" class="link_opt">dreamwiz.com</a></li>
										<li><a href="javascript:changeMailDomain('empal.com')" class="link_opt">empal.com</a></li>
										<li><a href="javascript:changeMailDomain('freechal.com')" class="link_opt">freechal.com</a></li>
										<li><a href="javascript:changeMailDomain('hanafos.com')" class="link_opt">hanafos.com </a></li>
									</ul>
								</div>
							</div>
							<span class="txt_error mailError1">Invalid email address. Please try again.</span>
							<span class="txt_error mailError2">This email address is already in use. Please enter a different email address.</span>
						</dd>
					</dl>
					<dl class="list_inp">
						<dt><label class="lab_tf screen_out"  for="tfName">Name</label></dt><!-- 이름 입력시 screen_out 클래스 추가 -->
						<dd>
							<input type="text" class="tf_g" id="tfName" placeholder="Name" name="userName" value="${user.name}">
							<span class="txt_error" style="display:none">Please enter at least two letters for name.</span>
						</dd>
					</dl>
					<dl class="list_inp">
						<dt class="screen_out">select country<span class="screen_out"> input necessary</span></dt>
						<dd>
							<div class="opt_g opt_country"><!-- 클릭시 .opt_on 추가 -->
								<strong class="screen_out">select country</strong>
								<a href="#none" class="link_selected">
									<span class="txt_opt">
										${user.countryName}
									</span>
									<span class="screen_out">selected</span>
									<span class="ico_newfriends_v1 ico_opt"></span>
								</a>
								<div class="box_opt">
									<em class="screen_out">select option</em>
									<ul class="list_opt">
										<li>
											<a href="javascript:changeNation('US', '1', 'United States')" class="link_opt">United States</a>
										</li>
										<c:forEach items="${countryList}" var="country">
											<li>
												<a href="javascript:changeNation('${country.EC_CODE}', '${country.EC_PHONECODE}', '${country.EC_COUNTRYENG}')" class="link_opt">${country.EC_COUNTRYENG}</a>
											</li>
										</c:forEach>
									</ul>
									<input type="hidden" id="globalType" value="">
								</div>
							</div>
						</dd>
					</dl>
					<dl class="list_inp list_phone">
						<dt><label class="lab_tf lab_phone screen_out" for="tfPhone">Phone<span class="screen_out"> input necessary</span></label></dt><!-- 휴대전화 입력시 screen_out 클래스 추가 -->
						<dd>
							<div class="sort_country">
								<input type="text" class="tf_g tf_country" id="tfPhonecountry" value="${user.countryNumber}" title="country" readonly>
							</div>
							<input type="text" class="tf_g tf_phone" id="tfPhone" maxlength="11" onkeypress="onlyNumber();" onkeyup="javascript:checkPhoneNumber(); toggleLabel(this, 'screen_out');" value="${user.phoneNumber}">
							<div class="sort_btn">
								<!-- 전화번호 입력 시 번호인증 버튼 노출 -->
								<button onclick="javascript:isExistPhone(); return false;" class="btn_confirm tfPhoneAuth" >Verify</button>
								<!-- //전화번호 입력 시 번호인증 버튼 노출 -->
							</div>
							<span class="txt_success phoneSuccess" style="display:none">Number verification completed</span>
							<span class="txt_error phoneError1">Please check your cellphone number again.</span>
							<span class="txt_error phoneError2">This number has been already registered.</span>
							<span class="txt_error phoneError3">Please verify your phone number.</span>
						</dd>
					</dl>
					<!-- 전화번호 입력 시 인증번호 입력 노출 -->
					<dl class="list_inp list_phone" style="display: none;">
						<dt><label class="lab_tf" for="tfConfirmnum">Enter verification code (6-digit code)<span class="screen_out"> input necessary</span></label></dt><!-- 인증번호 입력시 screen_out 클래스 추가 -->
						<dd>
							<input type="text" class="tf_g tf_confirm" id="tfConfirmnum" onkeyup="toggleLabel(this, 'screen_out');">
							<div class="sort_btn">
								<button onclick="javascript:checkAuth(); return false;" class="btn_confirm">OK</button>
							</div>
							<span class="txt_info">The verification code has been sent. <em class="emph_info" id="authTimer">(05:00)</em><br>
								Limited to 5 times a day <em class="emph_info" id="authCount">(1/5)</em>
							</span>
							<span class="txt_error authTimeExpire">The verification code has expired.</span>
						</dd>
					</dl>
					<strong class="screen_out">Precautions for entering information</strong>
				</div>

				<div class="group_join">
					<c:choose>
						<c:when test="${user.providerId eq 'kakao'}">
							<strong class="tit_sns"><span class="ico_newfriends_v1 ico_talk"></span>Kakao Talk Account</strong>
						</c:when>
						<c:when test="${user.providerId eq 'facebook'}">
							<strong class="tit_sns"><span class="ico_newfriends_v1 ico_facebook"></span>Facebook Account</strong>
						</c:when>
					</c:choose>
					<dl class="list_inp list_readonly">
						<dt>Birth</dt>
						<dd>${user.birthString}</dd>
					</dl>
					<dl class="list_inp list_readonly">
						<dt>Gender</dt>
						<dd><c:if test="${user.gender eq 'M'}">Male</c:if><c:if test="${user.gender eq 'F'}">Female</c:if></dd>
					</dl>
					<ul class="list_agree">
						<c:forEach items="${provision}" var="item" varStatus="status">
							<li>
								<strong class="tit_agree"> ${item.title}
									<c:choose>
										<c:when test="${item.necessary eq false}"><em class="emph_option"> (Optional)</em>
										</c:when>
										<c:when test="${item.necessary eq true}"><em class="emph_important"> (Required)</em>
											<a href="#none" class="link_agree">Details</a>
										</c:when>
									</c:choose>
									<input type="hidden" name="agreeChk" value="${item.necessary}">
								</strong>
								<div class="chk_agree">
									<div class="area_agree provisions">
										<input type="hidden" name="provisionAgreements[${status.index}].provisionCountry" value="${item.country}"/>
										<input type="hidden" name="provisionAgreements[${status.index}].provisionCode" value="${item.code}"/>
										<input type="hidden" name="provisionAgreements[${status.index}].provisionVersion" value="${item.version}"/>
										<input type="checkbox" name="provisionAgreements[${status.index}].agreement" class="inp_g" <c:if test="${item.agreement == true}">checked</c:if>>
										<label class="lab_g"><span class="ico_newfriends_v1">동의</span></label>
									</div>
								</div>
							</li>
						</c:forEach>
					</ul>
					<div class="desc_privacy">
						<strong class="tit_privacy"><span class="ico_newfriends_v1"></span>Agree to use events and marketing(Optional)</strong>
						<div class="privacy_table">
							<table class="tbl_privacy">
								<caption class="ir_caption">Agree to use events and marketing(Optional)</caption>
								<colgroup>
									<col style="width:16%">
									<col style="width:38%">
									<col style="width:46%">
								</colgroup>
								<thead>
								<tr>
									<th scope="col">Category</th>
									<th class="lst" scope="col" colspan="2">Optional field</th>
								</tr>
								</thead>
								<tbody>
								<tr>
									<th scope="row">Purpose</th>
									<td colspan="2">Customized information provision, marketing, event</td>
								</tr>
								<tr>
									<th scope="row">Items</th>
									<td colspan="2">e-mail, cellphone number, Date of birth, gender</td>
								</tr>
								<tr class="lst">
									<th scope="row">Storage<br>period</th>
									<td>Will suspend using the information immediatly at the time of the agreemnt withdrawl</td>
									<td>Within five days of cancellation</td>
								</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<div class="group_btn">
					<button class="btn_signup bg_yellow" onclick="modify(); return false;">Save changes</button>
					<p class="desc_noti">
						<span class="txt_noti">If you want to close your account,</span>
						<a class="link_withdraw" onclick="termination()"><span class="ico_newfriends_v1"></span>Membership cancellation</a>
					</p>
				</div>
			</fieldset>
		</form>
	</div>
</div><!--// mArticle -->

<script>
    $(function() {
        //화면 로드 시에 모든 에러메세지 숨김 처리 -> style에 박는게 나을까..?
        $(".txt_error").css("display","none");

        $(".tf_phone + .sort_btn").css("display","none");

        $(".opt_country .link_selected, .opt_email .link_selected").click(function(e) {
            resetOptionOn();
            $(this).parent(".opt_g").addClass("opt_on");
            e.stopPropagation();
        });

        $("body").click(function() {
            resetOptionOn();
        });

    });

    function resetOptionOn() {
        $(".opt_country, .opt_email").removeClass("opt_on");
    }

    function modify() {
        if(!joinValidationCheck()) {
            return false;
        }
        var queryString = $("#frm").serialize();

        $.ajax({
            headers: {'X-CSRF-TOKEN': '${_csrf.token}'},
            url: "/mypage/updateMyInfo",
            type: "POST",
            dataType: "json",
            data: queryString,
            async:false,
            success: function (data) {
                //중복체크 후 결과값을 통해 에러문구 노출
                if (data.statusCode == '0000') {
                    alertNoti('noti.complete.myinfo.update', '/en/mypage/myinfo');
                } else if(data.statusCode == '0001') {
                    alertNoti('error.occurred');
                }
            },
            error: function () {
                alertNoti('error.occurred');
            }
        });
    }

    // 회원정보 수정 validation check
    function joinValidationCheck() {
        if(validationCheck() && !isExistEmail()) {
            return true;
        }
        $(window).scrollTop(400);
        return false;
    }

    function checkPhoneNumber() {
        if($('#tfPhone').val() != $('#oldPhoneNumber').val()) {
            $(".tf_phone + .sort_btn").css("display","block");
            $("#phoneAuth").val(false);
        } else {
            $(".tf_phone + .sort_btn").css("display","none");
            $("#phoneAuth").val(true);
        }
    }

    // 회원가입 validation check
    function validationCheck() {
        var result = true;
        var re_name = /^[가-힣a-zA-Z\s]{2,30}$/; // 이름, 주문자명 검사식
        var re_mail = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/; // 이메일 검사식
        var re_tel = /^[0-9]{10,11}$/; // 모든전화번호 검사식
        var re_pw = /(?=.*[a-zA-Z])(?=.*[0-9]).{6,15}/g;
        $("#email").val($.trim($("#tfId").val()) + "@" + $.trim($("#tfDomain").val()));
        $("#password").val($.trim($("#tfPw").val()));
        $("#phoneNumber").val($.trim($('#tfPhone').val()));
        $("#name").val($("#tfName").val());
        //console.log($("#frm").serialize());

        //console.log('이메일 형식체크');
        //이메일 형식체크
        if (re_mail.test($("#email").val()) != true) {
            $(".opt_email + .mailError1").css("display","block");
            result = false;
        } else {
            $(".opt_email + .mailError1").css("display","none");
        }

        //이름 2자리이상 체크
        if($('#oldName').val() != $('#name').val()) {
            if (re_name.test($("#name").val()) != true) {
                $("#tfName").siblings(".txt_error").css('display', 'block');
                result = false;
            } else {
                $("#tfName").siblings(".txt_error").css('display', 'none');
            }
        }

        //console.log('휴대전화 11자리 체크');
        //휴대전화 11자리 체크
        if($('#oldPhoneNumber').val() != $('#phoneNumber').val()) {
            if (re_tel.test($("#tfPhone").val()) != true || $("#tfPhone").val().length != 11) {
                $("#tfPhone").siblings(".phoneError1").css('display','block');
                result = false;
            } else {
                $("#tfPhone").siblings(".phoneError1").css('display','none');
            }
        }

        if($('#oldPhoneNumber').val() != $('#phoneNumber').val()) {
            if ($('#phoneAuth').val() != 'true') {
                $('.phoneError3').css('display', 'block');
                result = false;
            } else {
                $('.phoneError3').css('display', 'none');
            }
        }
        return result;
    }

    /**
     * 핸드폰 번호 중복 체크. 2017.11.05 Breeze
     */
    function isExistPhone() {
        var phoneNumber = $("#tfPhone").val();
        $("#tfPhone").siblings(".phoneError2").css('display','none');
        $("#tfPhone").siblings(".phoneError3").css('display','none');

        $('.phoneSuccess').css('display', 'none');
        $('.phoneError1').css('display', 'none');
        $.ajax({
            headers: {'X-CSRF-TOKEN': '${_csrf.token}'},
            url: "/uniqueIdCheck",
            type: "POST",
            dataType: "json",
            data: { phoneNumber:phoneNumber},
            success: function (data) {
                if (data.statusCode == '0000') {
                    isResendable();
                } else if(data.statusCode == '0001') {
                    $("#tfPhone").siblings(".phoneError2").css('display','block');
                }
            },
            error: function () {
                alertNoti('error.occurred');
                return false;
            },
        });
    }

    /**
     * 재전송 가능 여부 조회. 2017.11.09 Breeze
     */
    function isResendable() {
        var authService = 'SIGN_UP';
        var authMethod = 'MESSAGE';
        var receiver = $("#tfPhone").val();

        $.ajax({
            headers: {'X-CSRF-TOKEN': '${_csrf.token}'},
            url: "/usr/auth/isResendable",
            type: "POST",
            dataType: "json",
            data: { authService:authService, authMethod:authMethod, receiver:receiver},
            success: function (data) {
                if (data.statusCode == '0000') {
                    sendAuth();
                } else if(data.statusCode == '0001') {
                    alertNoti("error.auth.resend");
                }
            },
            error: function () {
                alertNoti('error.occurred');
                return false;
            },
        });
    }

    /**
     * 인증 문자 발송. 2017.11.05 Breeze
     */
    /**
     * 인증 문자 발송. 2017.11.05 Breeze
     */
    function sendAuth(){
        var authService = 'SIGN_UP';
        var authMethod = 'MESSAGE';
        var receiver = $("#tfPhone").val();
        var countryNumber = $('#tfPhonecountry').val();
        var re_tel = /^[0-9]{10,11}$/; // 모든전화번호 검사식

        // 전화번호 Validation Check
        if($("#tfPhone").val() != $('#oldPhoneNumber').val()) {
            if (re_tel.test($("#tfPhone").val()) != true) {
                $("#tfPhone").siblings(".phoneError1").css('display', 'block');
                return false;
            } else {
                $("#tfPhone").siblings(".phoneError1").css('display', 'none');
            }
        }


        $.ajax({
            headers: {'X-CSRF-TOKEN': '${_csrf.token}'},
            url: "/usr/auth",
            type: "POST",
            dataType: "json",
            data: { authService:authService, authMethod:authMethod, receiver:receiver, countryNumber:countryNumber},
            success: function (data) {
                if (data.statusCode == '0000') {
                    if(timeoutTimer != null) {
                        clearTimeout(timeoutTimer);
                    }
                    $(".authTimeExpire").css('display','none');
                    $(".tfPhoneAuth").html('Resend');
                    $("#authCount").html("(" + data.countAuth + "/5)");
                    $("#authTimer").html("(05:00)");
                    $(".list_phone:last").css("display","block");
                    refreshTimer();
                } else if(data.statusCode == '0001') {
                    alertNoti('error.auth.data.notfound');
                } else if(data.statusCode == '0002') {
                    $("#authCount").html("(5/5)");
                    alertNoti("error.auth.over.count");
                }
            },
            error: function () {
                alertNoti('error.occurred');
                return false;
            },
        });
    }

    /**
     * 전화번호 인증 시도.
     */
    function checkAuth(){
        var authService = 'SIGN_UP';
        var authMethod = 'MESSAGE';
        var receiver = $("#tfPhone").val();
        var authNumber = $("#tfConfirmnum").val();
        $('.phoneError3').css('display','none');

        $.ajax({
            headers: {'X-CSRF-TOKEN': '${_csrf.token}'},
            url: "/usr/auth/check",
            type: "POST",
            dataType: "json",
            data: { authService:authService, authMethod:authMethod, receiver:receiver, authNumber:authNumber},
            success: function (data) {
                if (data.statusCode == '0000') {
                    $('#tfPhone').prop('readonly', true);
                    $('.tfPhoneAuth').css('display', 'none');
                    $('.phoneSuccess').css('display', 'block');
                    $(".list_phone:last").css("display","none");
                    $("#phoneAuth").val(true);
                    $("#phoneNumber").val(receiver);
                } else if (data.statusCode == '0001') {
                    alertNoti('error.auth.data.notfound');
                } else if (data.statusCode == '0002') {
                    alertNoti('error.auth.number.difference');
                }
            },
            error: function () {
                alertNoti('error.occurred');
                return false;
            },
        });
    }

    var timeoutTimer;
    function refreshTimer() {
        var element = $("#authTimer");
        var presentTime = $(element).html();
        var time = presentTime.replace("(", "").replace(")", "");
        var sec = timeToSeconds(time);
        $(element).html("(" + secondsToTime(sec - 1) + ")");
        if(sec > 1) {
            timeoutTimer = setTimeout(refreshTimer, 1000);
        } else {
            $(".authTimeExpire").css('display','block');
        }
    }

    // 이메일 도메인 변경시 event
    function changeMailDomain(mailDomain) {
        $(".opt_email").removeClass("opt_on");
        $("#tfDomain").val(mailDomain);
        $("#tfDomain").parent().find("label").addClass("screen_out");
    }

    // 배송국가 변경시 event
    function changeNation(code, phoneCode, countryName) {
        $(".opt_country").removeClass("opt_on");
        $("#tfPhonecountry").val(phoneCode);
        $(".opt_country .txt_opt").text(countryName);
        $("#country").val(code);
    }

    //이메일 중복체크
    function isExistEmail(){
        var result = true;
        if($('#oldEmail').val() == $('#email').val()) {
            return false;
        }

        $.ajax({
            headers: {'X-CSRF-TOKEN': '${_csrf.token}'},
            url: "/uniqueIdCheck",
            type: "POST",
            dataType: "json",
            data: { email:$("#email").val()},
            async:false,
            error: function () {
                alertNoti('error.occurred');
                result = true;
            },
            success: function (data) {
                //중복체크 후 결과값을 통해 에러문구 노출
                if (data.statusCode == '0000') {
                    $(".mailError2").css("display","none");
                    result = false;
                } else if(data.statusCode == '0001') {
                    $(".mailError2").css("display","block");
                    result =  true;
                }
            }
        });
        return result;
    }

    /**
     * 회원 탈퇴
     */
    function termination() {
        $(".dimmed_layer").show();
        $(".dimmed_layer").load('/popup/withdraw');
    }
</script>