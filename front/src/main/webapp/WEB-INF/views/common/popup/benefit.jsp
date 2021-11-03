<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="language" value="${pageContext.response.locale.language.equals('en') ? 'en' : 'kr'}"/>

<div class="friends_layer benefit_layer" style="display:block">
    <div class="inner_layer">
        <div class="layer_head">
            <strong class="tit_order">카카오프렌즈 회원구매 혜택</strong>
        </div>
        <div class="layer_body">
            <p>신규 가입시 <strong>1,000포인트 즉시 지급!</strong></p>
            <p>회원 구매시 <strong>6% 적립!</strong></p>
        </div>
        <div class="option_btns">
            <button type="button" class="btn_check buy_nomember">비회원 구매</button>
            <button type="button" class="btn_check buy_member">간편 회원 구매</button>
        </div>
        <button type="button" class="btn_check buy_close">팝업 닫기</button>
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