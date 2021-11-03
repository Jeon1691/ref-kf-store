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
		<span class="img_emoticon  emoticon_complete "></span><!-- 아이디찾기_완료시, 비밀번호찾기_변경시 emoticon_complete 클래스 추가 -->
	</span>
		<strong class="screen_out">Find ID and password menu</strong>
		<div class="menu_tab menu_tab_type2">
			<ul class="tab_nav">
				<li class="on" ><a href="/en/usr/findid" class="link_tab">Forgot your ID (e-mail)</a></li><!-- 클릭시 on 클래스 추가 -->
				<li><a href="/kr/usr/findpw" class="link_tab">Forgot your password</a></li>
			</ul>
		</div>
		<div class="info_find">
			<form action="/signin">
				<fieldset>
					<legend class="screen_out">Forgot your ID (e-mail)</legend>
					<div class="group_find">
						<div class="info_complete">
							<span class="txt_complete">The ID matches your personal information.</span>
							<strong class="id_complete" id="email"></strong>
						</div>
					</div>
					<button type="submit" class="btn_signup bg_yellow">Sign in</button>
				</fieldset>
			</form>
		</div>
	</div>
</div>
<!--// mArticle -->

<script type="text/javascript">
    $(document).ready(function () {
        var data = sessionStorage.getItem('email');
        if (data != null) {
            $(".id_complete").html(data);
            sessionStorage.removeItem('email');
        } else {
            location.href = '/en/usr/findid';
        }
    });
</script>