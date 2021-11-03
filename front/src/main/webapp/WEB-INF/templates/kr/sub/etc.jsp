<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set value="${kakaoWebView}" var="kakaoWebView"/>
<c:set value="${kakaoWebView > 0 && requestPath eq '/kr/signup'}" var="isSignup" />
<c:if test="${isSignup}">
<div id="cEtc">
	<a href="/kr/info/charInfo" class="link_about">
		<span class="img_about"></span>
		<strong class="tit_newfriends tit_about">카카오프렌즈 소개 바로가기</strong>
	</a>
</div>
</c:if>