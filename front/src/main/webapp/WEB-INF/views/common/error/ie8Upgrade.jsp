<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!doctype html>
<html lang="${language}" class="${userAgent.os.name } ${' '} ${userAgent.browser.name } ${' '} ${userAgent.platform}">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
  <meta name="format-detection" content="telephone=no">
  <title>KAKAO FRIENDS</title>
  <link rel="shortcut icon" href="//t1.kakaocdn.net/kakaofriends_global/static/img/favicon.ico" type='image/x-ico' />
  <link rel="stylesheet" type="text/css" href="/resources/css/common.min.css">
</head>
<div id="kakaoWrap" class="wrap_error">
  <div id="kakaoHead">
    <h1 class="screen_out">KAKAO FRIENDS</h1>
    <span class="ico_bg ico_type1"></span>
    <h2 class="tit_error">인터넷 브라우저 최적화가 필요해요</h2>
  </div>
  <hr class="hide">
  <div id="kakaoContent">
    <p class="desc_error desc_type1">
      <em class="emph_browser">카카오프렌즈 온라인스토어는 IE9 이상에 최적화되어 있습니다.</em>
      <%--또한 <a href="https://www.google.co.kr/chrome/" class="link_browser">Chrome</a>, <a href="https://www.mozilla.org/ko/firefox/new/" class="link_browser">Firefox</a>, <a href="https://support.apple.com/ko_KR/downloads/safari" class="link_browser">Safari</a> 에서도 사용이 가능합니다.--%>
      또한 <a href="https://www.google.co.kr/chrome/" class="link_browser">Chrome</a>, <a href="https://www.mozilla.org/ko/firefox/new/" class="link_browser">Firefox</a> 에서도 사용이 가능합니다.
    </p>
    <div class="wrap_btn">
      <a href="javascript:history.back()" class="link_error link_prev">이전으로</a>
      <a href="http://windows.microsoft.com/ko-kr/internet-explorer/download-ie" class="link_error link_down"><span class="ico_bg ico_ie">인터넷익스플로러</span>다운로드 센터<span class="txt_g">로 이동</span></a>
    </div>
  </div>
</div>
</html>
