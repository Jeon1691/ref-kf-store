<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div id="mSub">
	<div class="box_intro cate_intro" style="background-color:${'#'}${mSubInfo.ctColor}">
		<div class="inner_intro">
			<img src="${kakaoFriendsCdn.category}/${mSubInfo.ctImage1}" class="img_intro rw_show" alt="${mSubInfo.ctName}">
			<img src="${kakaoFriendsCdn.category}/${mSubInfo.ctImage2}" class="img_intro rw_hide" alt="${mSubInfo.ctName}">
			<h2 id="kakaoBody" class="tit_intro">${mSubInfo.ctName}</h2>
			<em class="emph_en">${mSubInfo.ctEname}</em>
		</div>
	</div>
</div>