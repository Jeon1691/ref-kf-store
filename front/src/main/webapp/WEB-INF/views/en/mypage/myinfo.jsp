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
	<%--<div class="privacy_detial">--%>
		<%--<form id="frm" class="form_login" method="get">--%>
			<%--<fieldset>--%>
				<%--<legend class="screen_out">Your Account form</legend>--%>
				<%--<h3 class="tit_detial">Your Account</h3>--%>
				<%--<div class="group_login" >--%>
					<%--<div class="inner_group">--%>
						<%--<dl class="list_inp">--%>
							<%--<dt><label class="lab_tf" for="tfPw">Please enter a password (6~15 characters)</label></dt><!-- 비밀번호 입력시 screen_out 클래스 추가 -->--%>
							<%--<dd>--%>
								<%--<input type="password" class="tf_g" id="tfPw" onkeyup="toggleLabel(this, 'screen_out')">--%>
							<%--</dd>--%>
						<%--</dl>--%>
					<%--</div>--%>
				<%--</div>--%>
				<%--<div class="group_desc">--%>
					<%--<a href="/usr/findpw" class="link_login">Forgot your password?</a>--%>
				<%--</div>--%>
				<%--<div class="group_btn">--%>
					<%--<button class="btn_signup bg_yellow" onclick="javascript:checkPassword(); return false;">OK</button>--%>
				<%--</div>--%>
			<%--</fieldset>--%>
		<%--</form>--%>
		<%--<strong class="screen_out">Log in using social media account</strong>--%>
		<%--<ul class="list_sns">--%>
			<%--<li><a href="/isMyPrivacyOk" class="link_social"><span class="ico_newfriends_v1 ico_kakao"></span>Kakao Talk Account<span class="ico_newfriends_v1 ico_arrow"></span></a></li>--%>
			<%--<li><a href="/isMyPrivacyOk" class="link_social"><span class="ico_newfriends_v1 ico_facebook"></span>Facebook Account<span class="ico_newfriends_v1 ico_arrow"></span></a></li>--%>
		<%--</ul>--%>
	<%--</div>--%>
	<div class="privacy_detial">
		<div class="group_sns">
			<strong class="screen_out">Kakao Talk Account</strong>
			<a href="/isMyPrivacyOk" class="btn_signup bg_yellow"><span class="ico_newfriends_v1 ico_kakao"></span>Kakao Talk Account</a>
		</div>
	</div>
</div><!--// mArticle -->

<script>
    function checkPassword(){
        if(('#tfPw').length == 0) {
            alertNoti("error.auth.password.empty");
        }

        $.ajax({
            headers: {'X-CSRF-TOKEN': '${_csrf.token}'},
            url: "/isValidPassword",
            type: "POST",
            dataType: "json",
            data: {password:$('#tfPw').val()},
            success: function (data) {
                if (data.statusCode == '0000') {
                    sessionStorage.setItem("isValidPassword", true);

                    $("#frm").attr("action","/mypage/myinfoModify");
                    $("#frm").submit();
                } else {
                    alertNoti("error.auth.password");
                }
            },
            error: function () {
                alertNoti('error.occurred');
                return false;
            },
        });
    }
</script>
