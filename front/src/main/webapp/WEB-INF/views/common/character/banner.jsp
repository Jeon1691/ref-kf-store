<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="si" uri="http://www.kakaofriends.com/si" %>
<c:set var="characterOrder" value="${param.selectedCharacterOrder-1}" scope="request"/>

<a href="${recommendationBanner[characterOrder].link}" class="link_theme">
    <div class="bg_option rw_show">
        <img src="${kakaoFriendsCdn.recommendation}/${recommendationBanner[characterOrder].pcImage}" class="thumb_g" alt="${recommendationBanner[characterOrder].alt}">
    </div>
    <div class="bg_option rw_hide">
        <img src="${kakaoFriendsCdn.recommendation}/${recommendationBanner[characterOrder].mobileImage}" class="thumb_g" alt="${recommendationBanner[characterOrder].alt}">
    </div>

    <div class="frame_thumb rw_show">
        <img src="${kakaoFriendsCdn.recommendation}/${recommendationBanner[characterOrder].pcBgImage}" class="thumb_g" alt="${recommendationBanner[characterOrder].alt}">
    </div>
    <div class="frame_thumb rw_hide">
        <img src="${kakaoFriendsCdn.recommendation}/${recommendationBanner[characterOrder].mobileBgImage}" class="thumb_g" alt="${recommendationBanner[characterOrder].alt}">
    </div>
    <div class="info_theme rw_show screen_out">
        <h3 class="tit_main" style="color:#fff">${recommendationBanner[characterOrder].title}</h3>
        <span class="txt_theme" style="color:#fff">${recommendationBanner[characterOrder].subTitle}</span>
    </div>
    <div class="info_theme rw_hide screen_out">
        <h3 class="tit_main" style="color:#fff">${recommendationBanner[characterOrder].title}</h3>
        <span class="txt_theme" style="color:#fff">${recommendationBanner[characterOrder].subTitle}</span>
    </div>
</a>