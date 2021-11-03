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
				<a href="/kr/mypage/orderlist" class="link_tab">주문내역</a>
			</li>
			<li>
				<a href="/kr/mypage/wishlist" class="link_tab">찜</a>
			</li>
			<li>
				<a href="/kr/mypage/cancellist" class="link_tab">취소/교환</a>
			</li>
			<li>
				<a href="/kr/mypage/pointlist" class="link_tab">포인트</a>
			</li>
			<li>
				<a href="/kr/mypage/couponlist" class="link_tab">쿠폰</a>
			</li>
			<li>
				<a href="/kr/mypage/onetoone" class="link_tab">1:1문의</a>
			</li>
			<li class="on">
				<a href="/kr/mypage/myinfo" class="link_tab">개인정보 <span class="screen_out">선택됨</span></a>
			</li>
		</ul>
	</div>
	<!--// 2017-10-19 수정 끝 : 마이페이지 탭메뉴 변경 -->
	<%--<div class="privacy_detial">--%>
		<%--<form id="frm" class="form_login" method="get">--%>
			<%--<input type="hidden" id="isValidPassword" name="isValidPassword" value="${isValidPassword}"/>--%>
			<%--<fieldset>--%>
				<%--<legend class="screen_out">개인정보수정 - 로그인 입력 양식</legend>--%>
				<%--<h3 class="tit_detial">개인정보 수정</h3>--%>
				<%--<div class="group_login" >--%>
					<%--<div class="inner_group">--%>
						<%--<dl class="list_inp">--%>
							<%--<dt><label class="lab_tf screen_out" for="tfPw">비밀번호를 입력해 주세요(6~15자리)</label></dt><!-- 비밀번호 입력시 screen_out 클래스 추가 -->--%>
							<%--<dd>--%>
								<%--<input type="password" class="tf_g" placeholder="비밀번호를 입력해 주세요(6~15자리)" id="tfPw" >--%>
							<%--</dd>--%>
						<%--</dl>--%>
					<%--</div>--%>
				<%--</div>--%>
				<%--<div class="group_desc">--%>
					<%--<a href="/kr/usr/findpw" class="link_login">비밀번호 찾기</a>--%>
				<%--</div>--%>
				<%--<div class="group_btn">--%>
					<%--<button class="btn_signup bg_yellow" onclick="javascript:checkPassword(); return false;">수정하기</button>--%>
				<%--</div>--%>
			<%--</fieldset>--%>
		<%--</form>--%>
		<%--<strong class="screen_out">SNS 계정으로 로그인</strong>--%>
		<%--<ul class="list_sns">--%>
			<%--<li><a href="/isMyPrivacyOk" class="link_social"><span class="ico_newfriends_v1 ico_kakao"></span>카카오 계정회원 수정하기<span class="ico_newfriends_v1 ico_arrow"></span></a></li>--%>
			<%--<li><a href="/isMyPrivacyOk" class="link_social"><span class="ico_newfriends_v1 ico_facebook"></span>페이스북 계정회원 수정하기<span class="ico_newfriends_v1 ico_arrow"></span></a></li>--%>
		<%--</ul>--%>
	<%--</div>--%>
	<div class="privacy_detial">
		<div class="group_sns">
			<strong class="screen_out">카카오 계정회원 수정</strong>
			<a href="/isMyPrivacyOk" class="btn_signup bg_yellow"><span class="ico_newfriends_v1 ico_kakao"></span>카카오 계정회원 수정하기</a>
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
