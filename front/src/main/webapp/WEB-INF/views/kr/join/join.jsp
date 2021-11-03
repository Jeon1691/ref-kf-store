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
			<input type="hidden" id="name" name="name">
			<input type="hidden" id="email" name="email">
			<input type="hidden" id="password" name="password">
			<input type="hidden" id="phoneNumber" name="phoneNumber">
			<input type="hidden" id="phoneAuth" name="phoneAuth"/>
			<input type="hidden" id="country" name="country" value="kr">
			<input type="hidden" id="providerId" name="providerId">
			<input type="hidden" id="providerUserId" name="providerUserId">
			<input type="hidden" id="birthyear" name="birthyear">
			<input type="hidden" id="birthday" name="birthday">
			<input type="hidden" id="gender" name="gender">
			<input type="hidden" name="_csrf" value="${_csrf.token}"/>
			<input type="hidden" name="_csrf_header" value="${_csrf.headerName}"/>
			<fieldset>
				<legend class="screen_out">회원가입 입력 양식</legend>
				<div class="group_join">
					<h3 class="tit_join">정보입력</h3>
					<!-- 2017-11-01 이메일 입력폼 수정 -->
					<dl class="list_inp">
						<dt><label class="lab_tf screen_out" for="tfId">아이디 (이메일) 입력</label></dt><!-- 아이디 입력시 screen_out 클래스 추가 -->
						<dd>
							<input type="text" class="tf_g tf_id" id="tfId" placeholder="아이디 (이메일) 입력" onkeyup="joinInputLengthCheck(this)">
							<span class="txt_email">@</span>
							<div class="opt_g opt_email opt_directwhite"><!-- 클릭시 .opt_on 추가 --><!-- 직접입력시 .opt_directwhite 추가 -->
								<div class="write_domain">
									<label class="lab_tf screen_out" for="tfDomain">직접입력</label><!-- 직접입력시 screen_out 클래스 추가 -->
									<input type="text" class="tf_g tf_domain" placeholder="직접입력" id="tfDomain" onkeyup="joinInputLengthCheck(this);"><!-- 직접입력시 value에 값 넣어주세요 -->
								</div>
								<a href="#none" class="link_selected">
									<strong class="screen_out">이메일 항목 선택</strong>
									<%--									<span class="txt_opt">daum.net</span>
                                                                        <span class="screen_out">선택됨</span>--%>
									<span class="ico_newfriends_v1 ico_opt"></span>
								</a>
								<div class="box_opt">
									<em class="screen_out">선택 옵션</em>
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
							<span class="txt_error mailError1" style="display:none">잘못된 이메일 형식입니다. 확인 후 다시 입력해 주세요.</span>
							<span class="txt_error mailError2" style="display:none">이미 사용중인 이메일입니다. 다른 이메일을 입력해 주세요.</span>
						</dd>
					</dl>
					<!-- //2017-11-01 이메일 입력폼 수정 -->
					<dl class="list_inp">
						<dt><label class="lab_tf screen_out" for="tfPw">비밀번호</label></dt><!-- 비밀번호 입력시 screen_out 클래스 추가 -->
						<dd class="info_password"> <!-- 2017-10-20 수정 : info_password 클래스 추가 -->
							<input type="password" class="tf_g" id="tfPw" placeholder="비밀번호" maxlength="15" onkeyup="joinInputLengthCheck(this);">
							<span class="ico_newfriends_v1 ico_lock"></span>
							<span class="txt_error" style="display:none">비밀번호를 영문 / 숫자 조합 6~15자 이내로 입력해 주세요.</span>
						</dd>
					</dl>
					<dl class="list_inp">
						<dt><label class="lab_tf screen_out" for="tfPwconfirm">비밀번호 확인</label></dt><!-- 비밀번호 입력시 screen_out 클래스 추가 -->
						<dd class="info_password"> <!-- 2017-10-20 수정 : info_password 클래스 추가 -->
							<input type="password" class="tf_g" id="tfPwconfirm" placeholder="비밀번호 확인" maxlength="15" onkeyup="joinInputLengthCheck(this);">
							<span class="ico_newfriends_v1 ico_lockchk"></span>
							<span class="txt_error" style="display:none">비밀번호가 다릅니다. 다시 확인해주세요.</span>
						</dd>
					</dl>
					<dl class="list_inp">
						<dt class="screen_out">국가선택</dt>
						<dd>
							<div class="opt_g opt_country"><!-- 클릭시 .opt_on 추가 -->
								<strong class="screen_out">국가 항목 선택</strong>
								<a href="#none" class="link_selected">
									<span class="txt_opt">한국</span>
									<span class="screen_out">선택됨</span>
									<span class="ico_newfriends_v1 ico_opt"></span>
								</a>
								<div class="box_opt">
									<em class="screen_out">선택 옵션</em>
									<ul class="list_opt">
										<li>
											<a href="javascript:changeNation('KR', '82', '한국')" class="link_opt">한국</a>
										</li>
										<c:forEach items="${countryList}" var="country">
											<li>
												<a href="javascript:changeNation('${country.EC_CODE}', '${country.EC_PHONECODE}', '${country.EC_COUNTRY}')" class="link_opt">${country.EC_COUNTRY}</a>
											</li>
										</c:forEach>
									</ul>
									<input type="hidden" id="globalType" value="">
								</div>
							</div>
						</dd>
					</dl>
					<dl class="list_inp">
						<dt><label class="lab_tf screen_out"  for="tfName">이름</label></dt><!-- 이름 입력시 screen_out 클래스 추가 -->
						<dd>
							<input type="text" class="tf_g" id="tfName" placeholder="이름" name="userName" onkeyup="joinInputLengthCheck(this);">
							<span class="txt_error" style="display:none">이름을 두글자 이상 입력해주세요.</span>
						</dd>
					</dl>
					<dl class="list_inp">
						<dt class="screen_out">생년월일</dt>
						<dd>
							<div class="sort_year">
								<label class="lab_tf screen_out" for="thBirth">생년 (4자리)</label><!-- 생년 입력시 screen_out 클래스 추가 -->
								<input type="text" class="tf_g tf_birth" placeholder="예시) 2001" id="thBirth" maxlength="4" onkeypress="onlyNumber();" onkeyup="joinInputLengthCheck(this);">
							</div>
							<div class="opt_g opt_date month"><!-- 클릭시 .opt_on 추가 -->
								<strong class="screen_out">태어난 달 선택</strong>
								<a href="#none" class="link_selected">
									<span class="txt_opt month" >월</span>
									<span class="screen_out">선택됨</span>
									<span class="ico_newfriends_v1 ico_opt"></span>
								</a>
								<div class="box_opt">
									<em class="screen_out">선택 옵션</em>
									<ul class="list_opt">
										<c:forEach var="i" begin="1" end="12">
											<li><a href="javascript:changeMonth('${i}')" class="link_opt">${i}</a></li>
										</c:forEach>
									</ul>
								</div>
							</div>
							<div class="opt_g opt_date day"><!-- 클릭시 .opt_on 추가 -->
								<strong class="screen_out">태어난 일자 선택</strong>
								<a href="#none" class="link_selected">
									<span class="txt_opt day" >일</span>
									<span class="screen_out">선택됨</span>
									<span class="ico_newfriends_v1 ico_opt"></span>
								</a>
								<div class="box_opt">
									<em class="screen_out">선택 옵션</em>
									<ul class="list_opt">
										<c:forEach var="j" begin="1" end="31">
											<li><a href="javascript:changeDay('${j}')" class="link_opt">${j}</a></li>
										</c:forEach>
									</ul>
								</div>
							</div>
							<span class="txt_error birthError1" style="display:none">생년월일을 입력해주세요.</span>
							<span class="txt_error birthError2" style="display:none">회원가입은 만 14세 이상 가능합니다.</span>
						</dd>
					</dl>
					<dl class="list_inp list_phone">
						<dt><label class="lab_tf lab_phone screen_out" for="tfPhone">휴대전화</label></dt><!-- 휴대전화 입력시 screen_out 클래스 추가 -->
						<dd>
							<div class="sort_country">
								<input type="text" class="tf_g tf_country" id="tfPhonecountry" value="82" title="국가번호" readonly>
							</div>
							<input type="text" class="tf_g tf_phone" placeholder="휴대폰전화(숫자만 입력해 주세요)" id="tfPhone" maxlength="11" onkeypress="onlyNumber();" onkeyup="joinInputLengthCheck(this);">
							<div class="sort_btn">
								<button onclick="javascript:isExistPhone(); return false;" class="btn_confirm tfPhoneAuth" >번호인증</button>
							</div>
							<span class="txt_success phoneSuccess" style="display:none">번호인증 완료</span>
							<span class="txt_error phoneError1" style="display:none">휴대폰 번호를 정확히 입력해 주세요.</span>
							<span class="txt_error phoneError2" style="display:none">이미 가입된 휴대폰번호 입니다.</span>
							<span class="txt_error phoneError3" style="display:none">휴대폰번호를 인증해 주세요.</span>
						</dd>
					</dl>
					<!-- 전화번호 입력 시 인증번호 입력 노출 -->
					<dl class="list_inp list_phone" style="display: none;">
						<dt><label class="lab_tf screen_out" for="tfConfirmnum">인증번호 입력 (숫자 6자리)</label></dt><!-- 인증번호 입력시 screen_out 클래스 추가 -->
						<dd>
							<input type="text" class="tf_g tf_confirm" placeholder="인증번호 입력" id="tfConfirmnum" onkeyup="joinInputLengthCheck(this);">
							<div class="sort_btn">
								<button onclick="javascript:checkAuth(); return false;" class="btn_confirm">확인</button>
							</div>
							<span class="txt_info">인증번호가 전송되었습니다. <em class="emph_info" id="authTimer">(05:00)</em><br>
								1일 제한 5회 <em class="emph_info" id="authCount">(1/5)</em>
							</span>
							<span class="txt_error authTimeExpire" style="display:none">인증번호 유효시간이 초과되었습니다.</span>
						</dd>
					</dl>
					<!-- //전화번호 입력 시 인증번호 입력 노출 -->
					<dl class="list_inp list_inp_type1">
						<dt>선택사항 <span class="screen_out">성별선택</span></dt>
						<dd>
							<div class="choice_g">
								<label for="inpMale" class="lab_g">남성</label>
								<input type="radio" id="inpMale" class="inp_g" name="genderType" value="M">
								<span class="ico_newfriends_v1 ico_choice"></span>
							</div>
							<div class="choice_g">
								<label for="inpFemale" class="lab_g">여성</label>
								<input type="radio" id="inpFemale" class="inp_g" name="genderType" value="F">
								<span class="ico_newfriends_v1 ico_choice"></span>
							</div>
						</dd>
					</dl>
					<strong class="screen_out">입력시 유의 사항</strong>
					<ul class="list_info">
						<li>이름과 휴대폰 번호는 아이디 또는 비밀번호를 찾기 위한 정보이므로 정확하게 입력해주세요.</li>
						<li>회원가입은 만 14세 이상 가능합니다.</li>
					</ul>
				</div>
				<div class="group_join">
					<h3 class="tit_join">약관동의</h3>
					<ul class="list_agree">
						<li>
							<strong class="tit_agree">
								아래 내용에 모두 동의합니다.
								<span class="txt_info">이용약관, 개인정보 수집 및 이용, 성별 수집 및 이용(선택), <br class="rw_show">이메일 마케팅 수신 (선택)에 모두 동의</span>
							</strong>
							<div class="chk_agree">
								<div class="area_agree">
									<input type="checkbox" id="allAgree" name="saveId" class="inp_g" onchange="agreeAllProvision(this);">
									<label for="allAgree" class="lab_g"><span class="ico_newfriends_v1">동의</span></label>
								</div>
							</div>
						</li>
						<c:forEach items="${provision}" var="item" varStatus="status">
							<li>
								<strong class="tit_agree"> ${item.title}
									<c:choose>
										<c:when test="${item.necessary eq false}">
											<em class="emph_option"> (선택)</em>
										</c:when>
										<c:when test="${item.necessary eq true}">
											<em class="emph_important"> (필수)</em>
										</c:when>
									</c:choose>
									<c:if test="${item.readMore eq true}"><a class="link_agree" onclick="provisionPopup('${item.code}')">자세히보기</a></c:if>
									<input type="hidden" name="agreeChk" value="${item.necessary}">
								</strong>
								<div class="chk_agree">
									<div class="area_agree provisions">
										<input type="hidden" name="provisionAgreements[${status.index}].provisionCountry" value="${item.country}"/>
										<input type="hidden" name="provisionAgreements[${status.index}].provisionCode" value="${item.code}"/>
										<input type="hidden" name="provisionAgreements[${status.index}].provisionVersion" value="${item.version}"/>
										<input type="checkbox" name="provisionAgreements[${status.index}].agreement" class="inp_g " onchange="checkProvision(this);">
										<label class="lab_g"><span class="ico_newfriends_v1">동의</span></label>
									</div>
								</div>
							</li>
						</c:forEach>
					</ul>
					<div class="desc_privacy">
						<strong class="tit_privacy"><span class="ico_newfriends_v1"></span>개인정보 수집 및 이용안내</strong>
						<div class="privacy_table">
							<table class="tbl_privacy">
								<caption class="ir_caption">개인정보 수집 및 이용안내표</caption>
								<colgroup>
									<col style="width:16%">
									<col style="width:28%">
									<col style="width:28%">
									<col style="width:28%">
								</colgroup>
								<thead>
								<tr>
									<th scope="col">구분</th>
									<th scope="col">목적</th>
									<th scope="col">항목</th>
									<th scope="col">보유 &amp; 이용기간</th>
								</tr>
								</thead>
								<tbody>
								<tr>
									<th scope="row" class="lst" rowspan="2">필수<br>항목</th>
									<td>이용자식별, 서비스이용을 위한 연락, 쿠폰/포인트관리</td>
									<td>
										아이디(이메일주소), 비밀번호, 이름, 국가, 휴대폰번호<br>
										소셜계정 연결시 : 카카오 계정 또는 페이스북 계정
									</td>
									<td class="lst" rowspan="2">회원 탈퇴 후 5일이내 지체없이 삭제</td>
								</tr>
								<tr>
									<td class="lst">서비스 가입을 위한 연령확인</td>
									<td class="lst">생년월일</td>
								</tr>
								<tr>
									<th scope="row" class="lst" rowspan="2">선택<br>항목</th>
									<td class="lst" rowspan="2">맞춤정보제공, 마케팅, 이벤트 활용</td>
									<td class="lst" rowspan="2">이메일 주소, 휴대폰번호, 성별</td>
									<td>동의 철회 시 즉시 활용중지</td>
								</tr>
								<tr>
									<td class="lst">회원탈퇴 시 지체없이 5일이내 삭제</td>
								</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<div class="group_btn">
					<div class="inner_group joinStop">
						<span class="img_emoticon img_joindisabled"></span>
						<button type="button" class="btn_signup btn_disabled">아직은 가입이 되지 않아요</button>
					</div>

					<div class="inner_group joinGo" style="display:none;">
						<!-- 가입가능 시 노출 -->
						<span class="img_emoticon img_joinconfirm"></span>
						<button type="button" class="btn_signup bg_yellow">카카오프렌즈 가입하기</button>
						<!-- //가입가능 시 노출 -->
					</div>
				</div>
			</fieldset>
		</form>
	</div>
</div>
<!--// mArticle -->

<script type="text/javascript">
    $(function() {
        //가입하기 클릭 시 벨리데이션 체크 후 화면이동
        $(".joinGo .btn_signup").on("click", function () {
            if(!joinValidationCheck()) {
                return false;
            }

            $("#frm").attr("action", "/signup");
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

        $('#thBirth').keyup(function(e) {
			if (!(e.keyCode >=37 && e.keyCode<=40)) {
				var v = $(this).val();
				$(this).val(v.replace(/[^a-z0-9]/gi,''));
			}
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

        $(txt).siblings(".txt_error").css('display','none');


        //화면에 갖고있는 class=tf_g 의 갯수와 각 input에 입력된 글자 길이를 비교하여 카운트
        for(var i = 0; i < inputLength; i++) {
            if ($(".tf_g").eq(i).val().length != 0 || ($('#tfConfirmnum').is($(".tf_g").eq(i)) )) {
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
        if(validationCheck() && !isExistEmail()) {
            return true;
        }
        $(window).scrollTop(0);
        return false;
    }

    //console.log('이메일 중복체크');
    //이메일 중복체크
    function isExistEmail(){
        var result = true;

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


    // 회원가입 validation check
    function validationCheck() {
        var result = true;
        var re_name = /^[가-힣a-zA-Z\s]{2,30}$/; // 이름, 주문자명 검사식
        var re_mail = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/; // 이메일 검사식
        var re_pw = /(?=.*[a-zA-Z])(?=.*[0-9]).{6,15}/g;
        var re_birth = /^[0-9]*$/;
        var genderType = $('input:radio[name="genderType"]:checked').val();

        $("#name").val($("#tfName").val());
        $("#email").val($("#tfId").val() + "@" + $("#tfDomain").val());
        $("#password").val($("#tfPw").val());
        $("#userProviderId").val(this.value); //userId
        $("#birthyear").val($("#thBirth").val());
        $("#birthday").val(pullZero($(".opt_date .month").text(), 2) + pullZero($(".opt_date .day").text(), 2));
        $("#gender").val(genderType);
        //console.log($("#frm").serialize());

        //console.log('이메일 형식체크');
        //이메일 형식체크
        if (re_mail.test($("#email").val()) != true) {
            $(".opt_email + .mailError1").css("display","block");
            result = false;
        } else {
            $(".opt_email + .mailError1").css("display","none");
        }

        //console.log('비밀번호 형식체크 (한영 6~15)');
        //비밀번호 형식체크 (한영 6~15)
        if (re_pw.test($("#password").val()) != true) {
            //console.log('비밀번호 형식체크 (한영 6~15) 1111');
            $("#tfPw").siblings(".txt_error").css('display','block');
            result = false;
        } else {
            //console.log('비밀번호 형식체크 (한영 6~15) 2222');
            $("#tfPw").siblings(".txt_error").css('display','none');
        }

        //console.log('비밀번호 비교');
        //비밀번호 비교
        if($("#tfPw").val() != $("#tfPwconfirm").val()) {
            $("#tfPwconfirm").siblings(".txt_error").css('display','block');
            result = false;
        } else {
            $("#tfPwconfirm").siblings(".txt_error").css('display','none');
        }

        //console.log('이름 2자리이상 체크');
        //이름 2자리이상 체크
        if (re_name.test($("#name").val()) != true) {
            $("#tfName").siblings(".txt_error").css('display','block');
            result = false;
        } else {
            $("#tfName").siblings(".txt_error").css('display','none');
        }

        //console.log('생년 4자리 체크');
        //생년 4자리 체크
        if ($.trim($('#thBirth').val()) == '' || $('#thBirth').val().length != 4 || !re_birth.test($('#thBirth').val()) || !re_birth.test($(".opt_date .month").text()) || !re_birth.test($(".opt_date .day").text())) {
            $(".opt_date").siblings(".birthError1").css('display','block');
            result = false;
        } else {
            $(".opt_date").siblings(".birthError1").css('display','none');
        }

        //console.log('생년 만14세 체크');
        //생년 만14세 체크
        var sYear = new Date().getFullYear();
        if (sYear - $("#thBirth").val() < 15) {
            $(".opt_date").siblings(".birthError2").css('display','block');
            result = false;
        } else {
            $(".opt_date").siblings(".birthError2").css('display','none');
        }

        if($('#phoneAuth').val() != 'true') {
            $('.phoneError3').css('display', 'block');
            result = false;
        } else {
            $('.phoneError3').css('display', 'none');
        }
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
        $("#tfPhonecountry").val(phoneCode);
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

    /**
     * 핸드폰 번호 중복 체크. 2017.11.05 Breeze
     */
    function isExistPhone() {
        var phoneNumber = $("#tfPhone").val();
        $("#tfPhone").siblings(".phoneError2").css('display','none');
        $("#tfPhone").siblings(".phoneError3").css('display','none');
        $('.phoneSuccess').css('display', 'none');

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
    function sendAuth(){
        var authService = 'SIGN_UP';
        var authMethod = 'MESSAGE';
        var countryNumber = $('#tfPhonecountry').val();
        var receiver = $("#tfPhone").val();
        var re_tel = /^[0-9]{10,11}$/; // 모든전화번호 검사식

        // 전화번호 Validation Check
        if (re_tel.test($("#tfPhone").val()) != true) {
            $("#tfPhone").siblings(".phoneError1").css('display','block');
            return false;
        } else {
            $("#tfPhone").siblings(".phoneError1").css('display','none');
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
                    $(".tfPhoneAuth").html('재전송');
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
					$(".opt_country .link_selected").off();
                    $('#tfPhone').prop('readonly', true);
                    $(".tfPhoneAuth").css('display', 'none');
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
</script>