<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="si" uri="http://www.kakaofriends.com/si" %>

<div id="mArticle">
	<h2 id="kakaoBody" class="screen_out">아이디 비밀번호 찾기</h2>
	<div class="cont_find">
	<span class="thumb_g thumb_emoticon">
		<span class="img_emoticon  "></span><!-- 아이디찾기_완료시, 비밀번호찾기_변경시 emoticon_complete 클래스 추가 -->
	</span>
		<strong class="screen_out">아이디 비밀번호 찾기 메뉴</strong>
		<div class="menu_tab menu_tab_type2">
			<ul class="tab_nav">
				<li><a href="/kr/usr/findid" class="link_tab">아이디 <span class="txt_normal">(이메일)</span> 찾기</a></li><!-- 클릭시 on 클래스 추가 -->
				<li class="on" ><a href="/kr/usr/findpw" class="link_tab">비밀번호 찾기</a></li>
			</ul>
		</div>
		<div class="info_find">
			<form>
				<fieldset>
					<legend class="screen_out">비밀번호 찾기</legend>
					<div class="find_pw">
						<div class="find_way wayPhone open"><!-- 라디오버튼 클릭시 open클래스 추가 -->
							<div class="choice_g">
								<label for="findPhonePw" class="lab_g">휴대폰 번호로 찾기</label>
								<input type="radio" checked="checked" id="findPhonePw" class="inp_g" name="findPw" onclick="openClose('phone');">
								<span class="ico_newfriends_v1 ico_choice"></span>
							</div>
							<div class="group_find">
								<dl class="list_inp">
									<dt>
										<label for="pwPhoneId" class="lab_tf">아이디</label><!-- 텍스트 입력시 screen_out 클래스 추가 -->
									</dt>
									<dd>
										<input type="text" id="pwPhoneId" class="tf_g" onkeyup="toggleLabel(this, 'screen_out');">
									</dd>
								</dl>
								<dl class="list_inp">
									<dt>
										<label for="pwPhoneName" class="lab_tf">이름</label><!-- 텍스트 입력시 screen_out 클래스 추가 -->
									</dt>
									<dd>
										<input type="text" id="pwPhoneName" class="tf_g" onkeyup="toggleLabel(this, 'screen_out');">
									</dd>
								</dl>
								<dl class="list_inp list_ph">
									<dt>
										<label for="pwPhoneNum" class="lab_tf">핸드폰 번호</label><!-- 텍스트 입력시 screen_out 클래스 추가 -->
									</dt>
									<dd>
										<input type="text" id="pwPhoneNum" class="tf_g" onkeyup="toggleLabel(this, 'screen_out');">
										<button onclick="isResendable('MESSAGE', $('#pwPhoneId').val(), $('#pwPhoneNum').val(), $('#pwPhoneName').val()); return false;" class="btn_g tfPhoneAuth">번호인증</button>
										<span class="txt_success phoneSuccess" style="display:none">번호인증 완료</span>
										<span class="txt_error phoneError1" style="display:none">휴대폰 번호를 정확히 입력해 주세요.</span>
										<span class="txt_error phoneError3" style="display:none">휴대폰번호를 인증해 주세요.</span>
									</dd>
								</dl>
								<dl class="list_inp list_phone" style="display: none;">
									<dt><label class="lab_tf" for="tfConfirmnum">인증번호 입력 (숫자 6자리)</label></dt><!-- 인증번호 입력시 screen_out 클래스 추가 -->
									<dd>
										<input type="text" class="tf_g tf_confirm" id="tfConfirmnum" onkeyup="toggleLabel(this, 'screen_out');">
										<div class="sort_btn">
											<button onclick="checkAuth('MESSAGE', $('#pwPhoneName').val(), $('#pwPhoneNum').val(), $('#tfConfirmnum').val()); return false;" class="btn_confirm">확인</button>
										</div>
										<span class="txt_info">인증번호가 전송되었습니다. <em class="emph_info" id="authTimer">(05:00)</em><br>
										1일 제한 5회 <em class="emph_info" id="authCount">(1/5)</em>
										</span>
										<span class="txt_error authTimeExpire" style="display:none">인증번호 유효시간이 초과되었습니다.</span>
									</dd>
								</dl>
							</div>
							<span class="txt_find">
							<span class="ico_newfriends_v1"></span>
							<span class="txt_g">가입 시 등록한 아이디(이메일), 이름, 휴대폰 번호를 통해 비밀번호를 변경할 수 있습니다.</span>
						</span>
						</div>
						<div class="find_way wayEmail"><!-- 라디오버튼 클릭시 open클래스 추가 -->
							<div class="choice_g">
								<label for="findEmailPw" class="lab_g">아이디 (이메일) 로 찾기</label>
								<input type="radio" id="findEmailPw" class="inp_g" name="findPw" onclick="openClose('email');">
								<span class="ico_newfriends_v1 ico_choice"></span>
							</div>
							<div class="group_find">
								<dl class="list_inp">
									<dt>
										<label for="pwEmailName" class="lab_tf">이름</label><!-- 텍스트 입력시 screen_out 클래스 추가 -->
									</dt>
									<dd>
										<input type="text" id="pwEmailName" class="tf_g" onkeyup="toggleLabel(this, 'screen_out');">
									</dd>
								</dl>
								<dl class="list_inp list_ph">
									<dt>
										<label for="pwEmailId" class="lab_tf">아이디(이메일)</label><!-- 텍스트 입력시 screen_out 클래스 추가 -->
									</dt>
									<dd>
										<input type="text" id="pwEmailId" class="tf_g" onkeyup="toggleLabel(this, 'screen_out');">
										<button onclick="isResendable('EMAIL', $('#pwEmailId').val(), $('#pwEmailId').val(), $('#pwEmailName').val()); return false;" class="btn_g tfEmailAuth">이메일인증</button>
										<span class="txt_success emailSuccess" style="display:none">이메일인증 완료</span>
										<span class="txt_error emailError1" style="display:none">이메일을 정확히 입력해 주세요.</span>
										<span class="txt_error emailError3" style="display:none">이메일을 인증해 주세요.</span>
									</dd>
								</dl>
								<dl class="list_inp list_email" style="display: none;">
									<dt><label class="lab_tf" for="tfEmailConfirm">인증번호 입력 (숫자 8자리)</label></dt><!-- 인증번호 입력시 screen_out 클래스 추가 -->
									<dd>
										<input type="text" class="tf_g tf_confirm" id="tfEmailConfirm" onkeyup="toggleLabel(this, 'screen_out');">
										<div class="sort_btn">
											<button onclick="checkAuth('EMAIL', $('#pwEmailName').val(), $('#pwEmailId').val(), $('#tfEmailConfirm').val()); return false;" class="btn_confirm">확인</button>
										</div>
										<span class="txt_certnum txt_certinfo">인증번호는 발송 후 30분 내에만 유효합니다.</span>
									</dd>
								</dl>
							</div>
							<span class="txt_find">
							<span class="ico_newfriends_v1"></span>
							<span class="txt_g">가입 시 등록한 아이디(이메일), 이름을 통해 비밀번호를 찾을 수 있습니다.</span>
						</span>
						</div>
					</div>
					<button onclick="complete(); return false;" class="btn_signup">확인</button>
				</fieldset>
			</form>
		</div>
	</div>
</div>
<!--// mArticle -->

<!-- 디자인용 스크립트 -->
<script type="text/javascript">
    function openClose(check) {
        if(check === 'phone') {
            $('.wayPhone').addClass('open'); $('.wayEmail').removeClass('open');
		} else {
            $('.wayEmail').addClass('open'); $('.wayPhone').removeClass('open');
		}
	}
</script>


<script type="text/javascript">
    /**
     * 재전송 가능 여부 조회. 2017.11.09 Breeze
     */
    function isResendable(authWay, authId, authReceiver, memberName) {
        var authService = 'FIND_PW';
        var authMethod = authWay;
        var receiver = authReceiver;
        $('.btn_signup').removeClass('bg_yellow');

        $.ajax({
            headers: {'X-CSRF-TOKEN': '${_csrf.token}'},
            url: "/usr/auth/isResendable",
            type: "POST",
            dataType: "json",
            data: { authService:authService, authMethod:authMethod, receiver:receiver},
            success: function (data) {
                if (data.statusCode == '0000') {
                    sendAuth(authMethod, authId, receiver, memberName);
                } else if(data.statusCode == '0001') {
                    if(authMethod === 'MESSAGE') {
                        alertNoti("error.auth.resend");
                    } else {
                        alertNoti("error.auth.resend.email");
                    }
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
    function sendAuth(authWay, authId, authReceiver, memberName){
        var authService = 'FIND_PW';
        var authMethod = $.trim(authWay);
        var email = $.trim(authId);
        var receiver = $.trim(authReceiver);
        var name = $.trim(memberName);
        var authDepth = 3;

        var re_tel = /^[0-9]{10,11}$/; // 모든전화번호 검사식
        var re_mail = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/; // 이메일 검사식

		if(authMethod === 'MESSAGE') {
            // 전화번호 Validation Check
            if (re_tel.test($("#pwPhoneNum").val()) != true) {
                $("#pwPhoneNum").siblings(".phoneError1").css('display','block');
                return false;
            } else {
                $("#pwPhoneNum").siblings(".phoneError1").css('display','none');
            }
		} else {
            if (re_mail.test($("#pwEmailId").val()) != true) {
                $(".emailError1").css("display","block");
                return false;
            } else {
                $(".emailError1").css("display","none");
            }
		}

        $.ajax({
            headers: {'X-CSRF-TOKEN': '${_csrf.token}'},
            url: "/usr/auth",
            type: "POST",
            dataType: "json",
            data: { authService:authService, authMethod:authMethod, email:email, receiver:receiver, name:name, authDepth:authDepth},
            success: function (data) {
                if (data.statusCode == '0000') {
                    if(authMethod === 'MESSAGE') {
                        if(timeoutTimer != null) {
                            clearTimeout(timeoutTimer);
                        }
                        $(".authTimeExpire").css('display','none');
                        $(".tfPhoneAuth").html('재전송');
                        $("#authCount").html("(" + data.countAuth + "/5)");
                        $("#authTimer").html("(05:00)");
                        $(".list_phone:last").css("display","block");
                        $("#limitAuth").css("display", "block");
                        refreshTimer();
                    } else {
                        $(".tfEmailAuth").html('재전송');
                        $(".list_email:last").css("display","block");
                    }
                } else if (data.statusCode == '0001') {
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
    function checkAuth(authWay, memberName, authReceiver, number){
        var authService = 'FIND_PW';
        var authMethod = $.trim(authWay);
        var receiver = $.trim(authReceiver);
        var authNumber = $.trim(number);
        var name = $.trim(memberName);
        var authDepth = 3;
        var email;

        if($('#findPhonePw').is(':checked')) {
            email = $.trim($("#pwPhoneId").val());
        } else {
            email = $.trim($("#pwEmailId").val());
        }

        $.ajax({
            headers: {'X-CSRF-TOKEN': '${_csrf.token}'},
            url: "/usr/auth/check",
            type: "POST",
            dataType: "json",
            data: { authService:authService, email:email, name:name, authMethod:authMethod, receiver:receiver, authNumber:authNumber, authDepth:authDepth},
            success: function (data) {
                if (data.statusCode == '0000') {
                    if(authMethod == 'MESSAGE') {
                        $('#pwPhoneNum').prop('readonly', true);
                        $(".tfPhoneAuth").css('display', 'none');
                        $('.phoneSuccess').css('display', 'block');
                        $(".list_phone:last").css("display","none");
                    } else {
                        $('#pwEmailId').prop('readonly', true);
                        $(".tfEmailAuth").css('display', 'none');
                        $('.emailSuccess').css('display', 'block');
                        $(".list_email:last").css("display","none");
                    }
                    $('#pwPhoneNum').prop('readonly', true);
                    $(".tfPhoneAuth").css('display', 'none');

                    $("#phoneAuth").val(true);
                    $("#phoneNumber").val(receiver);
                    $('.btn_signup').addClass('bg_yellow');
                    sessionStorage.setItem('id', data.id);
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

    function complete() {
        var id = sessionStorage.getItem('id');
        if(id != null && id.length > 0) {
            location.href = "/kr/usr/findpwChange";
        } else {
            alertNoti("error.auth.need");
        }
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
</script>