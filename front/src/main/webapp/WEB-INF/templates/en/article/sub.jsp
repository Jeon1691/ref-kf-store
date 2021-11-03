<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div id="mSub">
	<div class="box_intro" style="background-color:${'#'}${mSubInfo.ctColor}">
		<div class="inner_intro">
			<img src="https://t1.daumcdn.net/friends/www${mSubInfo.ctImage1}" class="img_intro rw_show" alt="${mSubInfo.ctEname}">
			<img src="https://t1.daumcdn.net/friends/www${mSubInfo.ctImage2}" class="img_intro rw_hide" alt="${mSubInfo.ctEname}">
			<h2 id="kakaoBody" class="tit_intro">${mSubInfo.ctEname}</h2>
		</div>
	</div>
</div>