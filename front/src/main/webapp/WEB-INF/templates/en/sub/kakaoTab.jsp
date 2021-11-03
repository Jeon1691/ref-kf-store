<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set value="${kakaoWebView}" var="kakaoWebView" />

<ul class="header_sub_tab">
    <li id="tab1" >
        <a href="javascript:;">HOME</a>
        <hr class="on">
    </li>
    <li id="tab2">
        <a href="javascript:;">NEW</a>
        <hr>
    </li>
    <li id="tab3">
        <a href="javascript:;">BEST</a>
        <hr>
        <span class="new_badge">Update</span>
    </li>
    <li id="tab4">
        <a href="javascript:;">SALE</a>
        <hr>
    </li>
</ul>