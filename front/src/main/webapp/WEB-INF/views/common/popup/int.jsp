<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="friends_layer int_layer">
  <div class="inner_layer">
    <div class="layer_head">
      <strong class="tit_int">주문 후 취소, 반품, 배송지<br> 변경이 불가합니다.</strong>
    </div>
    <div class="layer_body">
      <strong class="screen_out">안내사항</strong>
      <ul class="list_int">
        <li>- 배송일 지정은 불가하며 2월 10일경 배송 예정입니다.</li>
        <li>- 자수는 영문 대,소문자만 가능합니다.<br>대,소문자를 구분하여 배송메모란에 입력해주세요.</li>
        <li>- 자수 모양으로 인한 교환은 불가합니다.</li>
      </ul>
    </div>
    <div class="layer_foot">
      <button type="button" class="btn_int btn_reset">취소</button>
      <button type="button" class="btn_int btn_initial">동의</button>
    </div>
  </div>
</div>
<script type="text/javascript">
  $(".int_layer").show();
  $("#kakaoIndex, #kakaoWrap").attr("aria-hidden","true");
  $("#kakaoIndex a, #kakaoWrap a, #kakaoIndex button, #kakaoWrap button").attr("tabindex","-1");
  popupCenter();
  $(".int_layer").attr("tabindex","0").focus();
  $(".int_layer").removeAttr("tabindex");
  $(".int_layer .btn_reset").on("click", function () {
    $("#kakaoIndex, #kakaoWrap").removeAttr("aria-hidden");
    $("#kakaoIndex a, #kakaoWrap a, #kakaoIndex button, #kakaoWrap button").removeAttr("tabindex");
    $("body").attr("tabindex","0").focus();
    $("body").removeAttr("tabindex");
    $(".int_layer").hide();
    $(".dimmed_layer").hide();
  });
</script>
