<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="language" value="${pageContext.response.locale.language.equals('en') ? 'en' : 'kr'}"/>

<div class="friends_layer benefit_layer" style="display:block">
    <div class="inner_layer">
        <div class="layer_head">
            <strong class="tit_order">Kakao Friends Membership Benefits</strong>
        </div>
        <div class="layer_body">
            <p>Receive 1,000 Points immediately upon new membership!</p>
            <p>Earn 6% on your purchase</p>
        </div>
        <div class="option_btns">
            <button type="button" class="btn_check buy_nomember">Non-Member Purchase</button>
            <button type="button" class="btn_check buy_member">Member Purchase</button>
        </div>
        <button type="button" class="btn_check buy_close">Close popup</button>
    </div>
</div>
<script type="text/javascript">
  $(".friends_layer").show();
  $("#kakaoIndex, #kakaoWrap").attr("aria-hidden","true");
  $("#kakaoIndex a, #kakaoWrap a, #kakaoIndex button, #kakaoWrap button").attr("tabindex","-1");
  popupCenter();
  $(".friends_layer").attr("tabindex","0").focus();
  $(".friends_layer").removeAttr("tabindex");

  $(".benefit_layer .buy_close, .dimmed_layer").one("click", function() {
      $(".dimmed_layer").hide();
  });
</script>