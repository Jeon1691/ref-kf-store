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
    <h2 class="tit_error">Please optimize your browser settings to continue.</h2>
  </div>
  <hr class="hide">
  <div id="kakaoContent">
    <p class="desc_error desc_type1">
      <em class="emph_browser">The Kakao Friends Online Store has been optimized for IE9 and above.</em>
      <%--또한 <a href="https://www.google.co.kr/chrome/" class="link_browser">Chrome</a>, <a href="https://www.mozilla.org/ko/firefox/new/" class="link_browser">Firefox</a>, <a href="https://support.apple.com/ko_KR/downloads/safari" class="link_browser">Safari</a> 에서도 사용이 가능합니다.--%>
      It can also be viewed with <a href="https://www.google.co.kr/chrome/" class="link_browser">Chrome</a> and <a href="https://www.mozilla.org/ko/firefox/new/" class="link_browser">Firefox</a>.
    </p>
    <div class="wrap_btn">
      <a href="javascript:history.back()" class="link_error link_prev">Back</a>
      <a href="http://windows.microsoft.com/ko-kr/internet-explorer/download-ie" class="link_error link_down"><span class="ico_bg ico_ie">IE</span>Download Center</a>
    </div>
  </div>
</div>
</html>
