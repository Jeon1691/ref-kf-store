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
				<li class="on"><a href="/kr/usr/findid" class="link_tab">아이디 <span class="txt_normal">(이메일)</span> 찾기</a></li><!-- 클릭시 on 클래스 추가 -->
				<li><a href="/kr/usr/findpw" class="link_tab">비밀번호 찾기</a></li>
			</ul>
		</div>
		<div class="info_find">
			<form>
				<fieldset>
					<legend class="screen_out">아이디 (이메일) 찾기</legend>
					<div class="group_find">
						<dl class="list_inp">
							<dt>
								<label for="memberName" class="lab_tf">이름</label><!-- 텍스트 입력시 screen_out 클래스 추가 -->
							</dt>
							<dd>
								<input type="text" id="memberName" name="memberName" class="tf_g" onkeyup="toggleLabel(this, 'screen_out');">
								<span class="txt_error" style="display:none">이름을 두글자 이상 입력해주세요.</span>
							</dd>
						</dl>
						<dl class="list_inp list_ph">
							<dt>
								<label for="receiver" class="lab_tf">핸드폰 번호</label><!-- 텍스트 입력시 screen_out 클래스 추가 -->
							</dt>
							<dd>
								<input type="text" id="receiver" name="receiver" class="tf_g" onkeyup="toggleLabel(this, 'screen_out');">
								<div class="sort_btn">
									<button onclick="isResendable(); return false;" class="btn_g tfPhoneAuth">번호인증</button>
								</div>
								<span class="txt_success phoneSuccess" style="display:none">번호인증 완료</span>
								<span class="txt_error phoneError1" style="display:none">휴대폰 번호를 정확히 입력해 주세요.</span>
								<span class="txt_error phoneError2" style="display:none">이미 가입된 휴대폰번호 입니다.</span>
								<span class="txt_error phoneError3" style="display:none">휴대폰번호를 인증해 주세요.</span>
							</dd>
						</dl>
						<dl class="list_inp list_phone" style="display:none;" >
							<dt><label class="lab_tf" for="tfConfirmnum">인증번호 입력 (숫자 6자리)</label></dt><!-- 인증번호 입력시 screen_out 클래스 추가 -->
							<dd>
								<input type="text" class="tf_g tf_confirm" id="tfConfirmnum" onkeyup="toggleLabel(this, 'screen_out');">
								<div class="sort_btn">
									<button onclick="checkAuth(); return false;" class="btn_confirm">확인</button>
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
					<span class="txt_g">가입 시 등록한 이름과 휴대폰 번호를 통해 아이디(이메일)를 찾을 수 있습니다.</span>
				</span>
					<button onclick="javascript:complete(); return false;" class="btn_signup">확인</button>
				</fieldset>
			</form>
		</div>
	</div>
</div>
<!--// mArticle -->

<script type="text/javascript">
    /**
     * 재전송 가능 여부 조회. 2017.11.09 Breeze
     */
    function isResendable() {
        var authService = 'FIND_ID';
        var authMethod = 'MESSAGE';
        var receiver = $("#receiver").val();
        $('.phoneSuccess').css('display', 'none');
        $('.btn_signup').removeClass('bg_yellow');

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
    function sendAuth(){
        var authService = 'FIND_ID';
        var authMethod = 'MESSAGE';
        var name = $.trim($("#memberName").val());
        var receiver = $.trim($("#receiver").val());
        var re_tel = /^[0-9]{10,11}$/; // 모든전화번호 검사식

        // 전화번호 Validation Check
        if (re_tel.test($("#receiver").val()) != true) {
            $("#receiver").siblings(".phoneError1").css('display','block');
            return false;
        } else {
            $("#receiver").siblings(".phoneError1").css('display','none');
        }

        $.ajax({
            headers: {'X-CSRF-TOKEN': '${_csrf.token}'},
            url: "/usr/auth",
            type: "POST",
            dataType: "json",
            data: { authService:authService, authMethod:authMethod, receiver:receiver, name:name},
            success: function (data) {
                if (data.statusCode == '0000') {
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
        var re_name = /^[가-힣a-zA-Z\s]{2,30}$/; // 이름, 주문자명 검사식
        var authService = 'FIND_ID';
        var authMethod = 'MESSAGE';
        var name = $.trim($("#memberName").val());
        var receiver = $.trim($("#receiver").val());
        var authNumber = $.trim($("#tfConfirmnum").val());
        var authDepth = 2;

        //console.log('이름 2자리이상 체크');
        //이름 2자리이상 체크
        if (re_name.test(name) != true) {
            $("#memberName").siblings(".txt_error").css('display','block');
            return false;
        } else {
            $("#memberName").siblings(".txt_error").css('display','none');
        }

        $.ajax({
            headers: {'X-CSRF-TOKEN': '${_csrf.token}'},
            url: "/usr/auth/check",
            type: "POST",
            dataType: "json",
            data: { authService:authService, authMethod:authMethod, receiver:receiver, authNumber:authNumber, name:name, authDepth:authDepth},
            success: function (data) {
                if (data.statusCode == '0000') {
                    $('#receiver').prop('readonly', true);
                    $(".tfPhoneAuth").css('display', 'none');
                    $('.phoneSuccess').css('display', 'block');
                    $(".list_phone:last").css("display","none");
                    $('.btn_signup').addClass('bg_yellow');
                    sessionStorage.setItem('email', data.email);
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

    function complete(){
        var email = sessionStorage.getItem('email');
        if(email != null && email.length > 0) {
            window.location.href = "/kr/usr/findidComplete";
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