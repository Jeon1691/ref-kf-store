<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="si" uri="http://www.kakaofriends.com/si" %>


<%--
	todo
	1. 필드 매핑
	2. providerId 에 따라서 화면을 보여준다.
	3. 문자 사용자 체크
--%>
<div id="mArticle">
	<div class="cont_join">
		<form id="frm" name="frm" method="post" autocomplete="true">
			<input type="hidden" id="email" name="email">
			<input type="hidden" id="country" name="country" value="us">
			<input type="hidden" id="providerId" name="providerId" value="${user.providerId}">
			<input type="hidden" id="providerUserId" name="providerUserId" value="${user.providerUserId}">
			<input type="hidden" id="birthyear" name="birthyear">
			<input type="hidden" id="birthday" name="birthday">
			<input type="hidden" id="gender" name="gender">
			<input type="hidden" name="_csrf" value="${_csrf.token}"/>
			<input type="hidden" name="_csrf_header" value="${_csrf.headerName}"/>
			<fieldset>
				<legend class="screen_out">Sign up form</legend>
				<div class="group_join">
					<h3 class="tit_join">Entering your information</h3>
					<!-- 2017-11-01 이메일 입력폼 수정 -->
					<dl class="list_inp">
						<dt><label class="lab_tf screen_out" for="tfId">ID (e-mail)<span class="screen_out"> input necessary</span></label></dt><!-- 아이디 입력시 screen_out 클래스 추가 -->
						<dd>
							<input type="text" class="tf_g tf_id" id="tfId" placeholder="ID (e-mail)" onkeyup="joinInputLengthCheck(this);">
							<span class="txt_email">@</span>
							<div class="opt_g opt_email opt_directwhite"><!-- 클릭시 .opt_on 추가 --><!-- 직접입력시 .opt_directwhite 추가 -->
								<div class="write_domain">
									<label class="lab_tf screen_out" for="tfDomain">Input directly</label><!-- 직접입력시 screen_out 클래스 추가 -->
									<input type="text" class="tf_g tf_domain" placeholder="Input directly" id="tfDomain" value="" onkeyup="joinInputLengthCheck(this); toggleLabel(this, 'screen_out');"><!-- 직접입력시 value에 값 넣어주세요 -->
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
							<span class="txt_error mailError1" style="display:none;">Invalid email address. Please try again.</span>
							<span class="txt_error mailError2" style="display:none">This email address is already in use. Please enter a different email address.</span>
						</dd>
					</dl>
					<!-- //2017-11-01 이메일 입력폼 수정 -->
					<dl class="list_inp">
						<dt class="screen_out">select country<span class="screen_out"> input necessary</span></dt>
						<dd>
							<div class="opt_g opt_country"><!-- 클릭시 .opt_on 추가 -->
								<strong class="screen_out">select country</strong>
								<a href="#none" class="link_selected">
									<span class="txt_opt">United States</span>
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
					<dl class="list_inp">
						<dt class="screen_out">Date of birth<span class="screen_out"> input necessary</span></dt>
						<dd>
							<div class="sort_year">
								<label class="lab_tf screen_out" for="thBirth">Year (4 digits)</label><!-- 생년 입력시 screen_out 클래스 추가 -->
								<input type="text" class="tf_g tf_birth" placeholder="Year (4 digits)" id="thBirth" maxlength="4" onkeypress="onlyNumber();" onkeyup="joinInputLengthCheck(this);">
							</div>
							<div class="opt_g opt_date month"><!-- 클릭시 .opt_on 추가 -->
								<strong class="screen_out">Select month</strong>
								<a href="#none" class="link_selected">
									<span class="txt_opt month">MM</span>
									<span class="screen_out">selected</span>
									<span class="ico_newfriends_v1 ico_opt"></span>
								</a>
								<div class="box_opt">
									<em class="screen_out">select option</em>
									<ul class="list_opt">
										<c:forEach var="i" begin="1" end="12">
											<li><a href="javascript:changeMonth('${i}')" class="link_opt">${i}</a></li>
										</c:forEach>
									</ul>
								</div>
							</div>
							<div class="opt_g opt_date day"><!-- 클릭시 .opt_on 추가 -->
								<strong class="screen_out">Select date</strong>
								<a href="#none" class="link_selected">
									<span class="txt_opt day">DD</span>
									<span class="screen_out">selected</span>
									<span class="ico_newfriends_v1 ico_opt"></span>
								</a>
								<div class="box_opt">
									<em class="screen_out">select option</em>
									<ul class="list_opt">
										<c:forEach var="j" begin="1" end="31">
											<li><a href="javascript:changeDay('${j}')" class="link_opt">${j}</a></li>
										</c:forEach>
									</ul>
								</div>
							</div>
							<span class="txt_error birthError1" style="display:none;">Please enter your date of birth.</span>
							<span class="txt_error birthError2" style="display:none">You must be at least 14 years of age to sign up for membership.</span>
						</dd>
					</dl>
					<dl class="list_inp list_inp_type1">
						<dt>Optional <span class="screen_out">select Gender</span></dt>
						<dd>
							<div class="choice_g">
								<label for="inpMale" class="lab_g">Male</label>
								<input type="radio" id="inpMale" name="genderType" class="inp_g" value="M">
								<span class="ico_newfriends_v1 ico_choice"></span>
							</div>
							<div class="choice_g">
								<label for="inpFemale" class="lab_g">Female</label>
								<input type="radio" id="inpFemale" name="genderType" class="inp_g" value="F">
								<span class="ico_newfriends_v1 ico_choice"></span>
							</div>
						</dd>
					</dl>
					<strong class="screen_out">Precautions for entering information</strong>
					<ul class="list_info">
						<li>You must be at least 14 years of age to sign up for membership.</li>
					</ul>
				</div>
				<div class="group_join">
					<h3 class="tit_join">Agree to Terms &amp; Condition</h3>
					<ul class="list_agree">
						<li>
							<strong class="tit_agree">
								I agree to all terms and conditions.
								<span class="txt_info">
									All agree to Terms & Condition, Collection and use of personal information, Agree to use events and marketing(Optional), Receive marketing emails & SMS (Optional)
								</span>
							</strong>
							<div class="chk_agree">
								<div class="area_agree">
									<input type="checkbox" id="allAgree" name="saveId" class="inp_g" onchange="javascript:agreeAllProvision(this);">
									<label for="allAgree" class="lab_g"><span class="ico_newfriends_v1">Agree</span></label>
								</div>
							</div>
						</li>
						<c:forEach items="${provision}" var="item" varStatus="status">
							<li>
								<strong class="tit_agree"> ${item.title}
									<c:choose>
										<c:when test="${item.necessary eq false}">
											<em class="emph_option"> (Optional)</em>
										</c:when>
										<c:when test="${item.necessary eq true}">
											<em class="emph_important"> (Required)</em>
										</c:when>
									</c:choose>
									<c:if test="${item.readMore eq true}"><a class="link_agree" onclick="provisionPopup('${item.code}')">Details</a></c:if>
									<input type="hidden" name="agreeChk" value="${item.necessary}">
								</strong>
								<div class="chk_agree">
									<div class="area_agree provisions">
										<input type="hidden" name="provisionAgreements[${status.index}].provisionCountry" value="${item.country}"/>
										<input type="hidden" name="provisionAgreements[${status.index}].provisionCode" value="${item.code}"/>
										<input type="hidden" name="provisionAgreements[${status.index}].provisionVersion" value="${item.version}"/>
										<input type="checkbox" name="provisionAgreements[${status.index}].agreement" class="inp_g " onchange="javascript:checkProvision(this);">
										<label class="lab_g"><span class="ico_newfriends_v1">Agree</span></label>
									</div>
								</div>
							</li>
						</c:forEach>
					</ul>
				</div>
				<div class="group_btn">
					<div class="inner_group joinStop">
						<span class="img_emoticon img_joindisabled"></span>
						<button type="button" class="btn_signup btn_disabled">You can’t sign up yet</button>
					</div>

					<div class="inner_group joinGo" style="display:none;">
						<!-- 가입가능 시 노출 -->
						<span class="img_emoticon img_joinconfirm"></span>
						<button type="button" class="btn_signup bg_yellow">
							<c:if test="${user.providerId eq 'kakao'}" >
								Sign up with kakao account
							</c:if>
							<c:if test="${user.providerId eq 'facebook'}" >
								Sign up with facebook account
							</c:if>
						</button>
						<!-- //가입가능 시 노출 -->
					</div>
				</div>
			</fieldset>
		</form>
	</div>
</div>
<!--// mArticle -->

<script type="text/javascript" charset="UTF-8" src="//t1.daumcdn.net/adfit/static/kp.js"></script>
<script type="text/javascript">

    $(function() {
        //화면 로드 시에 모든 에러메세지 숨김 처리 -> style에 박는게 나을까..?
        $(".txt_error").css("display","none");

        //가입하기 클릭 시 벨리데이션 체크 후 화면이동
        $(".joinGo .btn_signup").on("click", function () {
            if(!joinValidationCheck()) {
                return false;
            }

            kakaoPixel('5931839826969542280').pageView();
            kakaoPixel('5931839826969542280').completeRegistration();

            $("#frm").attr("action", "/en/signup");
            $("#frm").submit();
        });

        $(".opt_country .link_selected, .opt_email .link_selected, .opt_date .link_selected").click(function(e) {
            resetOptionOn();
            $(this).parent(".opt_g").addClass("opt_on");
            e.stopPropagation();
        });

        $("body").click(function() {
            resetOptionOn();
        });

    });

    function resetOptionOn() {
        $(".opt_country, .opt_email, .opt_date").removeClass("opt_on");
    }

    //회원가입 입력 폼 length check 후 모든 필수값들의 길이가 0이 아니면 가입 버튼 변경
    function joinInputLengthCheck(txt) {
        var inputLength = $(".tf_g").length;
        var perfectCnt = 0;
        var agreeChk = true;

        //화면에 갖고있는 class=tf_g 의 갯수와 각 input에 입력된 글자 길이를 비교하여 카운트
        for(var i = 0; i < inputLength; i++) {
            if ($(".tf_g").eq(i).val().length != 0) {
                perfectCnt++;
            }
        }

        //필수 약관 체크했는지 확인
        for(var j = 0; j < $('input[name=agreeChk]').length; j++){
            if ($("input[name=agreeChk]")[j].value == 'true') {
                if (!$(".provisions input[type=checkbox]")[j].checked) {
                    agreeChk = false;
                    break;
                }
            }
        }

        //위에서 for문 돌린 값을 비교하여 회원가입 버튼 변경
        if ((perfectCnt == inputLength) && agreeChk) {
            $(".joinStop").css("display","none");
            $(".joinGo").css("display","block");
        } else {
            $(".joinStop").css("display","block");
            $(".joinGo").css("display","none");
        }
    }

    // 회원가입 validation check
    function joinValidationCheck() {
        if(validationCheck() && isExistEmail()) {
            return true;
        }
        $(window).scrollTop(0);
        return false;
    }

    // 회원가입 validation check
    function validationCheck() {
        var result = true;
        var re_birth = /^[0-9]*$/;
        var re_mail = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/; // 이메일 검사식

        var genderType = $('input:radio[name="genderType"]:checked').val();
        $("#email").val($("#tfId").val() + "@" + $("#tfDomain").val());
        $("#userProviderId").val(this.value); //userId
        $("#birthyear").val($("#thBirth").val());
        $("#birthday").val(pullZero($(".opt_date .month").text(), 2) + pullZero($(".opt_date .day").text(), 2));
        $("#gender").val(genderType);

        //이메일 형식체크
        if (re_mail.test($("#email").val()) != true) {
            $(".opt_email + .mailError1").css("display","block");
            result =  false;
        } else {
            $(".opt_email + .mailError1").css("display","none");
        }

        //생년 4자리 체크
        if ($.trim($('#thBirth').val()) == '' || $('#thBirth').val().length != 4 || !re_birth.test($('#thBirth').val()) || !re_birth.test($(".opt_date .month").text()) || !re_birth.test($(".opt_date .day").text())) {
            $(".opt_date").siblings(".birthError1").css('display','block');
            result = false;
        } else {
            $(".opt_date").siblings(".birthError1").css('display','none');
        }

        //생년 만14세 체크
        var sYear = new Date().getFullYear();
        if (sYear - $("#thBirth").val() < 15) {
            $(".opt_date").siblings(".birthError2").css('display','block');
            result = false;
        } else {
            $(".opt_date").siblings(".birthError2").css('display','none');
        }

        return result;
    }

    function isExistEmail(){
        var result = false;

        $.ajax({
            headers: {'X-CSRF-TOKEN': '${_csrf.token}'},
            url: "/uniqueIdCheck",
            type: "POST",
            dataType: "json",
            data: { email:$("#email").val()},
            async:false,
            error: function () {
                alertNoti('error.occurred');
                result = false;
            },
            success: function (data) {
                //중복체크 후 결과값을 통해 에러문구 노출
                if (data.statusCode == '0000') {
                    $(".mailError2").css("display","none");
                    result = true;
                } else if(data.statusCode == '0001') {
                    $(".mailError2").css("display","block");
                    result =  false;
                }
            }
        });
        return result;
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
        $(".opt_country .txt_opt").text(countryName);
        $("#country").val(code);
    }

    // 생일 월 변경시 event
    function changeMonth(month) {
        $(".opt_date").removeClass("opt_on");
        $(".opt_date .month").text(month);
    }

    // 생일 일 변경시 event
    function changeDay(day) {
        $(".opt_date").removeClass("opt_on");
        $(".opt_date .day").text(day);
    }

    // input에 숫자만 입력될 수 있도록 함
    function onlyNumber(){
        if((event.keyCode<48)||(event.keyCode>57))
            event.returnValue=false;
    }

    /** 2017.11.04 Breeze
     * 전체 동의 클릭 시, 모든 약관 동의 체크(혹은 모두 비동의)
     * @param element
     */
    function agreeAllProvision(element) {
        if($(element).is(":checked") == true) {
            $(".provisions").find('input[type=checkbox]').each(function() {
                $(this).prop("checked", true);
            });
        } else {
            $(".provisions").find('input[type=checkbox]').each(function() {
                $(this).prop("checked", false);
            });
        }

        //상태 바뀔때마다 validation체크 -> 필수값 동의 확인 후 버튼변경 위해
        joinInputLengthCheck();
    }

    /** 2017.11.04 Breeze
     * 모든 약관 약관 시, 전체 약관 동의 체크박스 체크(혹은 미체크)
     * @param element
     */
    function checkProvision(element){
        //상태 바뀔때마다 validation체크 -> 필수값 동의 확인 후 버튼변경 위해
        joinInputLengthCheck(element);

        if($(element).is(":checked") == false) {
            $("#allAgree").prop("checked", false);
        } else {
            $(".provisions").find('input[type=checkbox]').each(function() {
                if($(this).is(":checked") == false) {
                    result = false;
                    return false;
                } else {
                    result = true;
                }
            });

            if(result == true) {
                $("#allAgree").prop("checked", true);
            }
        }
    }
</script>