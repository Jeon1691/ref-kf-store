<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="friends_layer alert_common_layer">
  <div class="inner_layer">
    <div class="layer_head">
      <strong class="screen_out">주문취소 안내</strong>
    </div>
    <div class="layer_body">
      <div class="box_desc">
        <p class="desc_layer">
          해당 주문이 정상적으로 취소되었습니다.<br>
          환불은 영업일 기준 2~7일 소요되며, 관련된 추가<br class="rw_show">
          문의사항은 global@kakaofriends.com 으로<br class="rw_show">
          연락주시기 바랍니다.
        </p>
      </div>
      <button type="button" class="btn_verify btn_confirm">확인</button>
    </div>
  </div>
</div>
<script type="text/javascript">
  $(".alert_common_layer").show();
  $("#kakaoIndex, #kakaoWrap").attr("aria-hidden","true");
  $("#kakaoIndex a, #kakaoWrap a, #kakaoIndex button, #kakaoWrap button").attr("tabindex","-1");
  popupCenter();
  $(".friends_layer").attr("tabindex","0").focus();
  $(".friends_layer").removeAttr("tabindex");
  $(".alert_common_layer .btn_verify").on("click", function () {
    $("#kakaoIndex, #kakaoWrap").removeAttr("aria-hidden");
    $("#kakaoIndex a, #kakaoWrap a, #kakaoIndex button, #kakaoWrap button").removeAttr("tabindex");
    $("body").attr("tabindex","0").focus();
    $("body").removeAttr("tabindex");
    $(".alert_common_layer").hide();
    $(".dimmed_layer").hide();
  });
</script>
