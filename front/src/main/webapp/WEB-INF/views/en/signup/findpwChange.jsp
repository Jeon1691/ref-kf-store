<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="si" uri="http://www.kakaofriends.com/si" %>

<div id="mArticle">
	<h2 id="kakaoBody" class="screen_out">Forgot your Id &amp; Password?</h2>
	<div class="cont_find">
	<span class="thumb_g thumb_emoticon">
		<span class="img_emoticon  "></span><!-- 아이디찾기_완료시, 비밀번호찾기_변경시 emoticon_complete 클래스 추가 -->
	</span>
		<strong class="screen_out">Find ID and password menu</strong>
		<div class="menu_tab menu_tab_type2">
			<ul class="tab_nav">
				<li><a href="/en/usr/findid" class="link_tab">Forgot your ID (e-mail)</a></li><!-- 클릭시 on 클래스 추가 -->
				<li class="on" ><a href="/en/usr/findpw" class="link_tab">Forgot your password</a></li>
			</ul>
		</div>
		<div class="info_find">
			<form>
				<div type="hidden" id="id"/>
				<fieldset>
					<legend class="screen_out">Change password</legend>
					<div class="find_pw find_change"><!-- 비밀번호 변경화면 노출시 find_change 클래스 추가 -->
						<div class="group_find">
							<strong class="tit_changepw">
								<span class="ico_newfriends_v1"></span>
								<span class="txt_change">Change password</span>
							</strong>
							<dl class="list_inp">
								<dt>
									<label for="newPw" class="lab_tf">Please enter you password</label><!-- 텍스트 입력시 screen_out 클래스 추가 -->
								</dt>
								<dd>
									<input type="password" id="newPw" class="tf_g" onkeyup="toggleLabel(this, 'screen_out');">
									<span class="txt_error" style="display:none">Please enter 6-15 digits including alphabet letters and numbers for your password.</span>
								</dd>
							</dl>
							<dl class="list_inp">
								<dt>
									<label for="pwConfirm" class="lab_tf">Re-enter password</label><!-- 텍스트 입력시 screen_out 클래스 추가 -->
								</dt>
								<dd>
									<input type="password" id="pwConfirm" class="tf_g" onkeyup="toggleLabel(this, 'screen_out');">
									<span class="txt_error" style="display:none">The password does not match. Please try again.</span>
								</dd>
							</dl>
						</div>
					</div>
					<button onclick="updatePassword(); return false;" class="btn_signup bg_yellow">Save change</button><!-- 버튼 텍스트 bold일때 클래스 추가 -->
				</fieldset>
			</form>
		</div>
	</div>
</div>
<!--// mArticle -->

<script type="text/javascript">
    $(document).ready(function () {
        var data = sessionStorage.getItem('id');
        if (data != null) {
            $("#id").val(data);
            sessionStorage.removeItem('id');
        } else {
            location.href = '/en/usr/findpw';
        }
    });

    function updatePassword() {
        var re_pw = /(?=.*[a-zA-Z])(?=.*[0-9]).{6,15}/g;
        var id = $("#id").val();
        var password = $("#newPw").val();
        var passwordConfirm = $("#pwConfirm").val();

        //console.log('비밀번호 형식체크 (한영 6~15)');
        //비밀번호 형식체크 (한영 6~15)
        if (re_pw.test(password) != true) {
            $("#newPw").siblings(".txt_error").css('display','block');
            return false;
        } else {
            $("#newPw").siblings(".txt_error").css('display','none');
        }

        //console.log('비밀번호 비교');
        //비밀번호 비교
        if(password != passwordConfirm) {
            $("#pwConfirm").siblings(".txt_error").css('display','block');
            return false;
        } else {
            $("#pwConfirm").siblings(".txt_error").css('display','none');
        }

        $.ajax({
            headers: {'X-CSRF-TOKEN': '${_csrf.token}'},
            url: "/mypage/updateMyInfo",
            type: "POST",
            dataType: "json",
            data: { id:id, password:password},
            success: function (data) {
                if (data.statusCode == '0000') {
                    alertNoti("complete.change.password", "/en/signin");
                    //document.location.href = "/signin";
                }
            },
            error: function () {
                alertNoti('error.occurred');
                return false;
            },
        });
    }
</script>